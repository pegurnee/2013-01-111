import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Write a description of class Customer here.
 * 
 * @author Eddie Gurnee
 * @version 0.0.20
 */
public class Customer
{
    private String name;
    private int itemsIndex;
    
    private Product[] items;    
    private Product[][][] menu;
    
    /**
     * No-argument constructor for objects of class Customer
     * 
     */
    public Customer()
    {
        name = "Undefined";
    }
    /**
     * Constructor for objects of class Customer
     * 
     * @param jediKnightAndFriendOfCaptainSolo will become the user's name
     * @param fireflyClassSpaceshipSerenity will become the total number of item space available in the cart
     * @param theOneTrueKingOfWesteros will become the user's menu
     */
    public Customer(String jediKnightAndFriendOfCaptainSolo, int fireflyClassSpaceshipSenerity, Product[][][] theOneTrueKingOfWesteros)
    {
        name = jediKnightAndFriendOfCaptainSolo;        
        
        items = new Product[fireflyClassSpaceshipSenerity];
        for (int k = 0; k < items.length; k++)
        {
            items[k] = new Product();
        }
        
        menu = theOneTrueKingOfWesteros;
        
        itemsIndex = 0;
    }

    /**
     * returns the user's name
     * 
     * @return name of the customer
     */
    public String getName()
    {
        return name;
    }
    /**
     * returns the cart as an Array of type Product
     * 
     * @return the items Array
     */
    public Product[] getItems()
    {
        return items;
    }
    /**
     * gets the number of items in the cart that were placed by the user
     * 
     * @return the number of Products in cart that have be defined
     */
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
    /**
     * creates and returns an Array of Strings that is simply the names of each possible category
     * 
     * @return the possible category names for the items in menu
     */
    public String[] getCategoryList()
    {
        String[] str = new String[menu.length];
        for (int k = 0; k < str.length; k++)
        {
            str[k] = menu[k][0][0].getCategory();
        }
        return str;
    }
    /**
     * creates and returns an Array of Strings that is simply the names of each possible subCategory, given a category
     * 
     * @param cat the index of a specific category
     * @return the possible category names for the items in a specific category from the menu
     */
    public String[] getSubCategoryList(int cat)
    {
        String[] str = new String[menu[cat].length];
        for (int k = 0; k < str.length; k++)
        {
            str[k] = menu[cat][k][0].getSubCategory();
        }
        return str;
    }
    /**
     * creates and returns an Array of Strings that is simply the names of each possible item, given a category and subCategory
     * 
     * @param cat the index of a specific category
     * @param subCat the index of a specific subCategory
     * @return the possible category names for the items in a specific category and subCategory from the menu
     */
    public String[] getDescriptionList(int cat, int subCat)
    {
        String[] str = new String[menu[cat][subCat].length];
        for (int k = 0; k < str.length; k++)
        {
            str[k] = menu[cat][subCat][k].getItemDescription();
        }
        return str;
    }
    /**
     * returns a specific Product from the menu
     * 
     * @param cat the index of a specific category
     * @param subCat the index of a specific subCategory
     * @param desc the index of a specific item
     * @return the Product at index desc of category cat, subCategory subCat
     */
    public Product getSelectedProduct(int cat, int subCat, int desc)
    {
        return menu[cat][subCat][desc];
    }
    /**
     * creates and returns an Array of Strings representing the various items in the cart
     * 
     * @return the Customer's cart in an Array of type String
     */
    public String[] getCart()
    {        
        String[] str = new String[itemsIndex];
        
        for (int k = 0; k < str.length; k++)
        {
            str[k] = items[k].getItemDescription();
        }
        
        return str;
    }
    /**
     * creates a string representation of the purchases made today
     * 
     * @see Product#getReceipt() Product.getReceipt()
     * @return the bill of all purchases made today in String format, including date and time of transaction, total cost per item and item type, and total cost of all transactions
     */
    public String getReceipt()
    {
        Calendar cal = Calendar.getInstance();
        
        DateFormat date = new SimpleDateFormat("MM/dd/yy HH:mm");
        
        String mName = name.substring(10);
        String str = date.format(cal.getTime()) + "\n\n" + mName + 
                "'s purchases \n\tat Food-n-Stuff: \n______________________________ \n\n";
        for (int k = 0; k < items.length; k++)
        {
            if (!items[k].getItemDescription().equals("No item"))
            {
                str += items[k].getReceipt() + "\n";
            }
        }
        str += "______________________________ \n\nTotal Price: $";
        String formattedTotal = String.format("%.2f", getTotal());
        str += formattedTotal;
        return str.trim();
    }
    /**
     * gets the total price of the transaction
     * 
     * @see #getReceipt() getReceipt()
     * @return the price of the transaction for each item in the cart
     */
    private double getTotal()
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
    
    /**
     * returns the string representation of Customer object
     * 
     * @return the string representation of Customer object
     */
    public String toString()
    {        
        String str = name + "\n";
        
        for (Product p : items)
        {
           str += p.toString() + "\n";
        }
        return str.trim();
    }
    /**
     * checks to see if two customers are equal
     * 
     * @param other the comparing Customer object
     * @see Product#equals(Product otherProduct) Product.equals(Product otherProduct)
     * @return true if they are equal
     */
    public boolean equals(Customer other)
    {
        if (name.equals(other.getName()))
        {
            for (int k = 0; k < menu.length; k++)
            {                
                for (int j = 0; j < menu[k].length; j++)
                {
                    for (int i = 0; i < menu[k][j].length; i++)
                    {
                        if (!menu[k][j][i].equals(other.getSelectedProduct(k, j, i)))
                        {
                            return false;
                        }
                    }
                }
            }
            Product[] otherCart = other.getItems();
            if (items.length == otherCart.length)
            {
                for (int k = 0; k < items.length; k++)
                {
                    if (!items[k].equals(otherCart[k]))
                    {
                        return false;
                    }
                }
            }
            else
            {
                return false;
            }
            return true;
        }
        return false;
    }
    
    /**
     * checks if the Customer's cart is full
     * 
     * @return returns false if there is still room in the cart for more items
     */
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
    /**
     * adds a Product to the cart
     * 
     * @param newP the product to be atted to the cart
     * @param i the number of instances of newP to add
     */
    public void addToCart(Product newP, int i)
    {
        items[itemsIndex] = newP;
        items[itemsIndex].setNumOfProducts(i);
        itemsIndex++;
    }
    /**
     * removes a Product from the cart
     * 
     * @param i the index of the Product in the items[] to remove
     */
    public void removeFromCart(int i)
    {
        itemsIndex--;
        items[i] = items[itemsIndex];
        items[itemsIndex] = new Product();        
    }
    /**
     * checks to see if a given Product has already been selected for purchase
     * 
     * @param p the Product to check against the cart
     * @return true if the selected Product is already in the cart
     */
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
    /**
     * removes a number of instances from a given Product
     * 
     * @param p the Product to remove instances from
     * @param i the number of instances to remove from a given Product
     */
    public void removeNumOfItems(Product p, int i)
    {
        for (Product m : items)
        {
            if (p.equals(m))
            {
                m.setNumOfProducts(m.getNumOfProducts() - i);
            }
        }
    }
}