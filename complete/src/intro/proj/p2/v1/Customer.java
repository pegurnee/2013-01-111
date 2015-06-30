package intro.proj.p2.v1;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Write a description of class Customer here.
 * 
 * @author Eddie Gurnee
 * @version 0.0.12
 */
public class Customer
{
    private String name;
    private int itemsIndex;
    
    private boolean moneyLimit;    
    private double moneyTotal;
    private double moneyCurrent;
    
    private boolean rewardZone;
    
    private Product[] items;    
    private Product[] menu;
    
    private String[] categoryList;
    private String[][] subCategoryLists;
    private String[][][] descriptionLists;

    /**
     * Constructor for objects of class Customer
     * 
     */
    public Customer()
    {
        name = "Undefined";
        moneyTotal = -1.0;
    }
    public Customer(String n, double m, int i, Product[] inMenu)
    {
        name = n;
        if (m < 0)
        {
            moneyLimit = false;
        }
        else
        {
            moneyCurrent = moneyTotal = m;
        }
        itemsIndex = 0;
        
        items = new Product[i];
        for (int k = 0; k < items.length; k++)
        {
            items[k] = new Product();
        }
        menu = new Product[inMenu.length];
        for (int k = 0; k < menu.length; k++)
        {
            menu[k] = inMenu[k];
        }
        initializeLists();
    }
    private void initializeLists()
    {
        String[] tempCat = new String[menu.length];
        String[] tempSub = new String[menu.length];
        String lastCat = "m";
        String lastSub = "m";
        int catI = 0;
        int subI = 0;
//         for (int k = 0; k < menu.length; k++)        
//         {
//             System.out.println(lastCat);
//             if(!menu[k].getCategory().equals(lastCat))
//             {
//                 lastCat = menu[k].getCategory();
//                 tempCat[catI] = menu[k].getCategory();
//                 catI++;
//             }
//             if(!menu[k].getSubCategory().equals(lastSub))
//             {
//                 lastSub = menu[k].getSubCategory();
//                 tempSub[subI] = menu[k].getSubCategory();
//                 subI++;
//             }
//         }
        for (Product m : menu)
        {
            System.out.println(lastCat);
            if(!m.getCategory().equals(lastCat))
            {
                lastCat = m.getCategory();
                tempCat[catI] = m.getCategory();
                catI++;
            }
            if(!m.getSubCategory().equals(lastSub))
            {
                lastSub = m.getSubCategory();
                tempSub[subI] = m.getSubCategory();
                subI++;
            }
        }
        categoryList = new String[catI];
        subCategoryLists = new String[categoryList.length][subI / categoryList.length];
        descriptionLists = new String   [categoryList.length]
                                        [subCategoryLists[0].length]
                                        [menu.length / (categoryList.length * subCategoryLists[0].length)];                                        
        for (int k = 0; k < categoryList.length; k++)
        {
            categoryList[k] = tempCat[k];
        }
        int i = 0;
        for (int j = 0; j < subCategoryLists.length; j++)
        {
            for (int k = 0; k < subCategoryLists[j].length; k++)
            {                    
                subCategoryLists[j][k] = tempSub[i];
                i++;
            }
        }
        i = 0;
        for (int j = 0; j < descriptionLists.length; j++)
        {
            for (int k = 0; k < descriptionLists[j].length; k++)
            {
                for (int l = 0; l < descriptionLists[j][k].length; l++)
                {
                    descriptionLists[j][k][l] = menu[i].getItemDescription();
                    i++;
                }
            }
        }
    }

    /**
     * 
     * @return name of the customer
     */
    public String getName()
    {
        return name;
    }
    public int getTotalItems()
    {
        int n = 0;
        for (int k = 0; k < items.length; k++)
        {
            n += items[k].getNumOfProducts();
        }
        return n;
    }
    public Product[] getMenu()
    {
        return menu;
    }
    public Product[] getItems()
    {
        return items;
    }
    public int getNumInCart()
    {
        int count = 0;
        for (int k = 0; k < items.length; k++)
        {
            if (!items[k].getItemDescription().equals("No item"))
            {
                count++;              
            }
        }
        return count;
    }
    public String[] getCategoryList()
    {        
        return categoryList;
    }
    public String[] getSubCategoryList(int cat)
    {
        return subCategoryLists[cat];
    }
    public String[] getDescriptionList(int cat, int subCat)
    {
        return descriptionLists[cat][subCat];
    }
    public String getDescriptionFromList(int cat, int subCat, int desc)
    {
        return descriptionLists[cat][subCat][desc];
    }
    public Product getSelectedProduct(int cat, int subCat, int desc)
    {
        int l = -1;
        for (int k = 0; k < menu.length; k++)
        {
            if (menu[k].getItemDescription().equals(descriptionLists[cat][subCat][desc]))
            {
                l = k;
            }
        }
        return menu[l];
    }    
    public String[] getCart()
    {        
        String[] str = new String[itemsIndex];
        
        for (int k = 0; k < str.length; k++)
        {
            str[k] = items[k].getItemDescription();
        }
        
        return str;
    }    
    public String getReceipt(boolean b)
    {
        Calendar cal = Calendar.getInstance();
        
        DateFormat date = new SimpleDateFormat("MM/dd/yy HH:mm");
        
        String mName = name.substring(10);
        String str = date.format(cal.getTime()) + "\n\n" + mName + 
                "'s purchases at Food-n-Stuff: \n______________________________ \n";
        for (int k = 0; k < items.length; k++)
        {
            if (!items[k].getItemDescription().equals("No item"))
            {
                str += items[k].getReceipt(b) + "\n";
            }
        }
        str += "______________________________ \n \nTotal Price: $";
        String formattedTotal = String.format("%.2f", getSubTotal());
        str += formattedTotal;
        if (!b)
        {
            str = "<html><body>" + str /*+ "</html>"*/;
        }
        return str.trim();
    }
    
    public String toString()
    {        
        String str = name + "\n" + "Total Money: " + moneyTotal + 
                "\n" + "Current Money: " + moneyCurrent + "\n";
        
        for (Product p : items)
        {
           str += p.toString() + "\n";
        }
        return str.trim();
    }
    public boolean equals(Customer other)
    {
        return true;
    }
    
    public boolean cartFull()
    {
        if (itemsIndex == items.length)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public void addToCart(Product newP, int i)
    {
        items[itemsIndex] = newP;
        items[itemsIndex].setNumOfProducts(i);
        itemsIndex++;
        if (moneyLimit)
        {
            moneyCurrent -= newP.getTotalPrice();
        }
    }
    public void removeItemFromCart(int i)
    {
        itemsIndex--;
        items[i] = items[itemsIndex];
        items[itemsIndex] = new Product();        
    }
    public double getSubTotal()
    {
        double sum = 0;
        if (itemsIndex != 0)
        {
            for (Product p : items)
            {                
                sum += p.getTotalPrice();
            }
        }
        return sum;
    }
    public boolean alreadyInCart(Product p)
    {
        for (Product m : items)
        {
            if (p.equals(m))
            {
                return true;
            }
        }
        return false;
    }
    public double toSubTotal(Product p)
    {
        return p.getTotalPrice();
    }
    public void removeNumOfItems(Product p, int i)
    {
        for (Product m : items)
        {
            if (p.equals(m))
            {
                m.setNumOfProducts(m.getNumOfProducts() - i);
            }
        }
        if (moneyLimit)
        {
            moneyCurrent += (p.getTotalPrice() * i);
        }
    }
}