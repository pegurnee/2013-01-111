package com.egurnee.school.intro.l8;
import java.util.Random;
/**
 * Holds the whole storefront
 * 
 * @author Eddie Gurnee
 * @version 0.0.5
 */
public class StoreFront
{
    public static void main(String []args)
    {
        boolean c = true;
        while (c)
        {
            boolean d = C.userYesOrNo("Would you like to randomly create a product?", "Item Creation");
            int sku, num, tax = 0;
            String description;
            double price;
            boolean taxable = true;
            
            if (d)
            {
                Random r = new Random();
                
                String[] randomItems = {"Comb", "Hairpiece", "Hat", "Shoe", "Door", "Car", "Fetal Pig"};
                
                sku = (r.nextInt(25623) + 1);
                description = randomItems[r.nextInt(randomItems.length)];
                double p1 = (int)((r.nextInt(200) + r.nextDouble() + 1.5) * 100);            
                price = ((double)p1/100);
                if (r.nextBoolean() && r.nextBoolean())
                {
                    taxable = false;
                }            
                if (taxable)
                {
                    tax = (r.nextInt(12) + 1);
                }
                num = (r.nextInt(20) + 1);
            }
            else
            {
                sku = C.userInputInt("What is the stock-keeping unit number?", "SKU Number");
                description = C.userInputString("What is the item called?", "Item Name");
                price = C.userInputDouble("What is the price of an individual unit?", "Individual Price");
                taxable = C.userYesOrNo("Is the item subject to sales tax?", "Check Taxable");
                if (taxable)
                {
                    tax = C.userInputInt("What is the item's sales tax rate?", "Check Tax Rate");
                }
                num = C.userInputInt("How many items would you like to buy?", "Number Desired");
            }
            
            Product itemOrder = new Product(sku, description, price, taxable, tax, num);
            
            C.showMessage(itemOrder.toString(), "");
            
            C.showMessage("The total price without tax is $" + itemOrder.getTaxFreePrice() + ".", "Subtotal");
            C.showMessage("The price of the tax alone is $" + itemOrder.getOnlyTax() + ".", "Tax Cost");
            String str = "The total price of " + itemOrder.getNumOfProducts() + " " + itemOrder.getItemDescription();
            if (itemOrder.getNumOfProducts() > 1)
            {
                str = str + "s";
            }
            str = str + ", including tax, is $" + itemOrder.getTotalPrice() + ".";
            C.showMessage(str, "Total Price");
            
            c = C.userYesOrNo("Would you like to check another item?", "Check Again");
        }
    }    
}
