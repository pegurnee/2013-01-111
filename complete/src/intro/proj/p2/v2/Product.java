package intro.proj.p2.v2;


/**
 * This class defines products
 * 
 * @author Eddie Gurnee
 * @version 0.0.09
 */
public class Product
{    
    private String itemDescription;
    private String category;
    private String subCategory;
    private int numOfProducts, taxRate;
    private double itemPrice;
    private boolean isTaxable;    
    
    /**
     * No-argument constuctor for Product
     * 
     */
    public Product() 
    {
        this("No item", -1.0, true, -1);
    }
    /**
     * Constructor for the product, defaults 
     * 
     * @param d description
     * @param p price
     * @param i if taxable
     * @param t tax rate
     */
    public Product(String d, double p, boolean i, int t)
    {
        this(d, p, i, t, 1);
    }
    /**
     * Constructor for the product
     * 
     * @param d description
     * @param p price
     * @param i if taxable
     * @param t tax rate
     * @param n number of purchased items
     */
    public Product(String d, double p, boolean i, int t, int n)
    {        
        setItemDescription(d);
        setItemPrice(p);
        setIsTaxable(i);
        setTaxRate(t);
        setNumOfProducts(n);
    }
    
    /**
     * Gets the value of numOfProducts
     * 
     * @return numOfProducts
     */
    public int getNumOfProducts()
    {
        return numOfProducts;
    }
    /**
     * Gets the value of taxRate
     * 
     * @return taxRate
     */
    public int getTaxRate()
    {
        return taxRate;
    }
    /**
     * Gets the value of itemDescription
     * 
     * @return itemDescription
     */
    public String getItemDescription()
    {
        return itemDescription;
    }
    /**
     * Gets the value of category
     * 
     * @return category
     */
    public String getCategory()
    {
        return category;
    }
    /**
     * Gets the value of subCategory
     * 
     * @return subCategory
     */
    public String getSubCategory()
    {
        return subCategory;
    }
    /**
     * Gets the value of itemPrice
     * 
     * @return itemPrice
     */
    public double getItemPrice()
    {
        return itemPrice;
    }    
    /**
     * Gets the value of isTaxable
     * 
     * @return isTaxable
     */
    public boolean getIsTaxable()
    {
        return isTaxable;
    }
    /**
     * Returns a String representing the description, number of items, individual item price, and subtotal for the Product
     * 
     * @see Customer#getReceipt() Customer.getReceipt()
     * @return the Receipt of the Product
     */
    public String getReceipt()
    {
        String formattedTPrice = String.format("$%.2f", getTotalPrice());
        String formattedIPrice = String.format("$%.2f", itemPrice);
        String s = String.format("%dx%s%n  @%8s%19s", numOfProducts, itemDescription, formattedIPrice, formattedTPrice);        
        return s;
    }
    
    /**
     * Sets the value of numOfProducts
     * 
     * @param input for numOfProducts
     */
    public void setNumOfProducts(int input)
    {
        numOfProducts = input;
    }
    /**
     * Sets the value of taxRate
     * 
     * @param input for taxRate
     */
    public void setTaxRate(int input)
    {
        taxRate = input;
    }
    /**
     * Sets the value of itemDescription
     * 
     * @param input for itemDescription
     */
    public void setItemDescription(String input)
    {
        itemDescription = input;
    }
    /**
     * Sets the value of itemPrice
     * 
     * @param input for itemPrice
     */
    public void setItemPrice(double input)
    {
        itemPrice = input;
    }    
    /**
     * Sets the value of isTaxable
     * 
     * @param input for isTaxable
     */
    public void setIsTaxable(boolean input)
    {
        isTaxable = input;
    }
    /**
     * Sets the value of category
     * 
     * @param input for category
     */
    public void setCategory(String input)
    {
        category = input;
    }
    /**
     * Sets the value of subCategory
     * 
     * @param input for subCategory
     */
    public void setSubCategory(String input)
    {
        subCategory = input;
    }
    
    /**
     * Gives true if the two objects are equal
     * 
     * @param otherProduct to test for equality
     * @return e for equality test
     */
    public boolean equals(Product otherProduct)
    {
        if(itemDescription.equals(otherProduct.itemDescription) && itemPrice == otherProduct.itemPrice
            && taxRate == otherProduct.taxRate && isTaxable == otherProduct.isTaxable)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    /**
     * Converts information to a string value
     * 
     * @return all of the product variable information
     */
    public String toString()
    {
        String str;
        str = itemDescription + "\n" + "Category: " + category + "\n" + "Subcategory: " 
            + subCategory + "\n" + "Number of Items: " + numOfProducts + "\n" 
            + "Individual Price: $" + itemPrice + "\n";
            
        if (isTaxable)
        {
            str += "Tax Rate: " + getTaxRate() + "%";
        }
        else
        {
            str += "Tax Exempt";
        }
        
        str += "\n" + "Subtotal: $" + getTotalPrice();
        
        return str;
    }
    
    /**
     * Gives the cost of items purchased, without tax
     * 
     * @return numOfProducts * itemPrice
     */
    public double getTaxFreePrice()
    {
        int n = (int)(getNumOfProducts() * getItemPrice() * 100);
        return (double)n/100;
    }
    /**
     * Gives only the cost of tax on the items
     * 
     * @param t the tax rate of item
     * @return numOfProducts * itemPrice * taxRate
     */
    public double getOnlyTax()
    {        
        int n = (int)((getTaxFreePrice() * calculateTaxRate(isTaxable) * 100) + 0.5);
        return (double)n/100;
    }    
    /**
     * Gives the total cost of items, including tax
     * 
     * @param t the tax rate of item
     * @return numOfProducts * itemPrice * (1 + taxRate)
     */
    public double getTotalPrice()
    {
        int n = (int)((getTaxFreePrice() * (1 + calculateTaxRate(isTaxable)) * 100) + 0.5);
        return (double)n/100;
    }
    /**
     * Calculates tax rate
     * 
     * @param t checks if the item is taxable
     * 
     * @returns taxRate
     */
    private double calculateTaxRate(boolean t)
    {
        double m;
        if (t)
        {
            if (taxRate != -1)
            {
                m = taxRate;
            }
            else
            {
                m = 6;
            }
        }
        else
        {
            m = 0;
        }
        
        return m/100;
    }
}
