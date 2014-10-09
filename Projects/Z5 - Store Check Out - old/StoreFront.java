import java.util.Scanner;
import java.io.*;
/**
 * Write a description of class MainClass here.
 * 
 * @author Eddie Gurnee
 * @version 0.0.20
 */
public class StoreFront
{
    public static void main(String[] args)
    {
        C.showMessage("Hello new friend." +
                "\nWelcome to Food-n-Stuff." +
                "\nMy name is [GENERIC COMPUTER INTERFACE]." +
                "\nI am here to assist you.", "");
                
        C.showMessage("Please answer my questions so" +
                "\nthat I may better assist you.", "");
                
        String userName = "My friend ";
        userName += C.toFirstCap(C.userInputString("My friend, what is your name?", "Enter Name"));
        double maxMoney = -1;
        //         if (C.userYesOrNo(userName + ", is there a limit on how " +
        //                     "much money you have to spend?", "Money Limit"))
        //         {
        //             maxMoney = C.userInputDouble(userName + ", how much money do" +
        //                             "\nyou intend on spending today?", "Spending Money");
        //         }
        int maxItems = -1;
        boolean itemFail = true;
        while (itemFail)
        {
            maxItems = C.userInputInt(userName + ", how many different types" + 
                                "\nof items do you need to purchase today?", "Item Variety");
            if (maxItems < 1 || maxItems > 14)
            {
                C.showMessage("Error: Not a resonably purchaseable amount of different items.", "Error: Number of Items");
                itemFail = true;
            }
            else
            {
                itemFail = false;
            }
        }
        String fMenu = "items.txt";
        if (!C.userYesOrNo(userName + ", would you like to purchase from the default " +
                            "menu?", "Confirm Default Menu"))
        {
            fMenu = C.userInputString(userName + ", what menu do you want to " +
                        "buy from?", "Input Menu", fMenu);
        }
        Customer user = new Customer(userName, maxMoney, maxItems, loadMenu(fMenu));
        
        boolean c = true;
        while (c)
        {
            int d = C.userSelectDropDown(user.getName() + ", what \nwould you like to do?", 
                        "Main Menu", new String[]{"Browse Items", "View Cart", 
                            "Check-out", "Exit"});
                
            if (d == 0)
            {
                browse(user);
            }
            else if (d == 1)
            {
                viewCart(user);
            }
            else if (d == 2)
            {
                checkOut(user);
            }
            else
            {
                exit(user);
            }
            
            if (user.cartFull() && C.userYesOrNo(user.getName() + " your cart is full. Would you like to check out?", "Go to check-out"))
            {
                checkOut(user);
            }
        }
    }
     private static Product[] loadMenu(String fMenu)
    {
        Product[] menu = new Product[0];
        
        try
        {            
            Scanner in = new Scanner(new FileInputStream(fMenu));
            
            int numOfItems = in.nextInt();
            int numOfCat = in.nextInt();
            int numOfSubCat = in.nextInt();
            
            menu = new Product[numOfItems];
            
            String[] cat = new String[numOfCat];
            String[] subCat = new String[numOfSubCat];
            in.nextLine();
            
            String[] desc = new String[menu.length];
            int[] rate = new int[menu.length];
            double[] price = new double[menu.length];
            boolean[] taxable = new boolean[menu.length];
            
            for (int k = 0; k < cat.length; k++)
            {
                cat[k] = in.nextLine();
            }
            for (int k = 0; k < subCat.length; k++)
            {
                subCat[k] = in.nextLine();
            }
            for (int k = 0; k < desc.length; k++)
            {
                desc[k] = in.nextLine();
            }
            
            for (int k = 0; k < rate.length; k++)
            {
                rate[k] = in.nextInt();
            }
            in.nextLine();
            for (int k = 0; k < price.length; k++)
            {
                price[k] = in.nextDouble();
            }
            in.nextLine();
            for (int k = 0; k < taxable.length; k++)
            {
                taxable[k] = in.nextBoolean();
            }
            
            in.close();
            for (int k = 0; k < menu.length; k++)
            {
                menu[k] = new Product(desc[k], price[k], taxable[k], rate[k]);            
            }
            
            double mL = menu.length, sL = subCat.length, cL = cat.length;
            for (int k = 0; k < cat.length; k++)
            {                
                for (int j = (int)(k * sL * (mL / (sL * cL))); j < (int)(((k + (mL / (sL * cL))) * sL) + 0.5); j++)
                {
                    System.out.println(j);
                    menu[j].setCategory(cat[k]);
                }
            }            
            for (int k = 0; k < subCat.length; k++)
            {
                for (int j = (int)(k * cL * (mL / (sL * cL))); j < (int)((k + (mL / (sL * cL)) * cL) + 0.5); j++)
                {
                    System.out.println(j);
                    menu[j].setSubCategory(subCat[k]);
                }
            }
            
//             for (int k = 0; k < menu.length; k++)
//             {
//                 menu[k] = new Product(desc[k], price[k], taxable[k], rate[k]);            
//             }
//             for (int k = 0; k < cat.length; k++)
//             {
//                 for (int j = (k * subCat.length); j < ((k + 1) * subCat.length); j++)
//                 {
//                     menu[j].setCategory(cat[k]);
//                 }
//             }            
//             for (int k = 0; k < subCat.length; k++)
//             {
//                 for (int j = (k * cat.length); j < ((k + 1) * cat.length); j++)
//                 {
//                     menu[j].setSubCategory(subCat[k]);
//                 }
//             }
        }
        catch (IOException e)
        {
            System.out.println("Import Error");
        }
        
        return menu;
    }
    private static void browse(Customer user)
    {
        int c = C.userSelectDropDown(user.getName() + ", what \ncategory are you interested " +
                    "in?", "Category Select", user.getCategoryList());
        int d = C.userSelectDropDown(user.getName() + ", what \nsubcategory are you interested " +
                    "in?", "Category Select", user.getSubCategoryList(c));
        int e = C.userSelectDropDown(user.getName() + ", which \nitem are you interested " +
                    "in?", "Category Select", user.getDescriptionList(c, d));
                    
        C.showMessage(user.getSelectedProduct(c, d, e).toString(), "Item Specifics");
        if (user.alreadyInCart(user.getSelectedProduct(c, d, e)))
        {
            if (C.userYesOrNo(user.getName() + ", would you like to remove some instances of \n[" + 
                    user.getDescriptionFromList(c, d, e) + "]?", "Confirm Remove"))
            {
                user.removeNumOfItems(user.getSelectedProduct(c, d, e), C.userInputInt(user.getName() + " how many instances of \n[" + 
                    user.getDescriptionFromList(c, d, e) + "] \nwould you like to remove?", "Remove Instance"));
                C.showMessage("Instances removed.", "Instances Removed");
            }
        }
        else
        {
            if (user.cartFull())
            {
                    C.showMessage(user.getName() + ", you do not have enough room in " +
                            "your cart to add another item.", "Out of Room");
                    if (C.userYesOrNo(user.getName() + ", would you like to remove an item from " +
                            "the cart?", "Remove Item"))
                    {
                        user.removeItemFromCart(C.userSelectDropDown(user.getName() + ", which item " +
                            "would you like to remove?", "Remove Item", user.getCart()));
                        C.showMessage("Item removed.", "Item Removed");
                    }
            }
            else if (C.userYesOrNo(user.getName() + ", would you like to buy some quantity of [" + 
                    user.getDescriptionFromList(c, d, e) + "]?", "Confirm Item"))
            {
                user.addToCart(user.getSelectedProduct(c, d, e), C.userInputInt(user.getName() + 
                    ", how many instances of \n[" + user.getDescriptionFromList(c, d, e) + 
                    "] \ndo you want to purchase?", "Number to buy"));
                C.showMessage("Item added to cart.", "Item Added");
            } 
        }
    }
    private static void viewCart(Customer user)
    {
        int desDex = user.getNumInCart();
        
        if (desDex == 0)
        { 
            C.showMessage("Your cart is currently empty", "View Cart");
        }
        else
        {
            String[] itemDesc = new String[desDex];
            for (int k = 0; k < itemDesc.length; k++)
            {
                itemDesc[k] = user.getItems()[k].toString();
            }
            boolean c = true;
            desDex = 0;
            while (c)
            {
                String[] options;
                boolean f = false;
                boolean l = false;
                boolean o = false;
                if (user.getNumInCart() == 1)
                {
                    options = new String[1];
                    options[0] = "Exit";
                    o = true;
                }
                else if (desDex > 0)
                {
                    if (desDex < (itemDesc.length - 1))
                    {
                        options = new String[3];
                        options[0] = "Last";
                        options[1] = "Exit";
                        options[2] = "Next";
                    }
                    else
                    {
                        options = new String[2];
                        options[0] = "Last";
                        options[1] = "Exit";
                        l = true;
                    }
                }
                else
                {
                    options = new String[2];
                    options[0] = "Exit";
                    options[1] = "Next";
                    f = true;
                }
                int r = C.userSelectButtons(itemDesc[desDex], "View Cart", options);
                if (o)
                {
                    c = false;
                }
                else if (!f && !l)
                {
                    if (r == 0)
                    {
                        desDex--;
                    }
                    else if (r == 2)
                    {
                        desDex++;
                    }
                    else
                    {
                        c = false;
                    }
                }
                else if (f)
                {
                    if (r == 1)
                    {
                        desDex++;
                    }
                    else
                    {
                        c = false;
                    }
                }
                else
                {
                    if (r == 0)
                    {
                        desDex--;
                    }
                    else
                    {
                        c = false;
                    }
                }
            }
        }
    }
    private static void checkOut(Customer user)
    {
        String receipt = user.getReceipt(true);
        C.showMessage(user.getReceipt(false), "Receipt");
        System.out.println(receipt);
        if (C.userYesOrNo(user.getName() + ", would you like a .txt \nfile " +
                "copy of your receipt?", "Confirm Receipt"))
        {
            try
            {
                PrintWriter out = new PrintWriter(
                                    new FileOutputStream(
                                        (C.userInputString(user.getName() +
                                            ", what do you want to name the receipt?", 
                                            "Name Receipt", "Receipt")
                                                ) + ".txt"));
                                                
                out.println(receipt);
                
                out.close();
            }
            catch (IOException e)
            {
                System.out.println("Error: " + e);
                System.exit(0);
            }
        }
        if (C.userYesOrNo(user.getName() + ", is your shopping complete?", "Exit"))
        {
            exit(user);
        }
    }
    private static void exit(Customer user)
    {
        if (C.userYesOrNo(user.getName() + ", are you \nsure you want to exit?", "Confirm Exit"))
        {
            C.showMessage("It was my pleasure helping you today. \nGoodbye.", user.getName());
            System.exit(0);
        }
    }
   
}
