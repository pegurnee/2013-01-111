package intro.toys.net;


/**
 * This class defines items
 * 
 * @author Eddie Gurnee
 * @version 0.0.2
 */
public class Product
{
    private int skuNumber, numOfProducts, taxRate;
    private String itemDescription;
    private double itemPrice;
    private boolean isTaxable;    
    
    public Product() 
    {
        itemDescription = "No item";
        taxRate = numOfProducts = skuNumber = -1;        
        itemPrice = -1.0;        
    }
    /**
     * Constructor for the product
     * @param s skuNumber
     * @param d description
     * @param p price
     * @param i if taxable
     * @param t tax rate
     * @param n number of purchased items
     */
    public Product(int s, String d, double p, boolean i, int t, int n)
    {
        setSkuNumber(s);
        setItemDescription(d);
        setItemPrice(p);
        setIsTaxable(i);
        setTaxRate(t);
        setNumOfProducts(n);        
    }
    
    /**
     * Gets the value of skuNumber
     * 
     * @return skuNumber
     */
    public int getSkuNumber()
    {
        return skuNumber;
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
     * Sets the value of skuNumber
     * 
     * @param input for skuNumber
     */
    public void setSkuNumber(int input)
    {
        skuNumber = input;
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
     * Gives true if the two objects are equal
     * 
     * @param otherProduct to test for equality
     * @return e for equality test
     */
    public boolean equals(Product otherProduct)
    {
        if(skuNumber == otherProduct.skuNumber && numOfProducts == otherProduct.numOfProducts
            && itemDescription.equals(otherProduct.itemDescription) && itemPrice == otherProduct.itemPrice
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
        str = itemDescription + "\n" + "SKU Number: " + skuNumber + "\n" + "Number of Items: " 
            + numOfProducts + "\n" + "Individual Price: $" + itemPrice + "\n";
            
        if (isTaxable)
        {
            str = str + "Tax Rate: " + getTaxRate() + "%";
        }
        else
        {
            str = str + "Tax Exempt";
        }
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
        int n = (int)(getTaxFreePrice() * calculateTaxRate(isTaxable) * 100);
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
        int n = (int)(getTaxFreePrice() * (1 + calculateTaxRate(isTaxable)) * 100);
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
