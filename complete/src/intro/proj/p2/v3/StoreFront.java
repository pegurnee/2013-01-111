package intro.proj.p2.v3;

import java.util.Scanner;
import java.io.*;
/**
 * The class containing the whole program to buy items from Food-n-Stuff
 * 
 * @author Eddie Gurnee
 * @version 0.0.29
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
        try
        {
            userName += C.toFirstCap(C.userInputString("My friend, what is your name?", "Enter Name"));
        }
        catch (Exception e)
        {
            C.showMessage("Faulty User: Please upgrade and try again.", "Error: PEBKAC");
            System.exit(0);
        }
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
        Customer user = new Customer(userName, maxItems, loadMenu(fMenu));

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
    /**
     * Loads a menu from a given .txt file
     * 
     * @param fMenu the .txt file to load the menu information from
     * @return the information from the .txt file in proper form for the menu
     */
    private static Product[][][] loadMenu(String fMenu)
    {
        Product[][][] menu = new Product[0][0][0];

        try
        {            
            Scanner in = new Scanner(new FileInputStream(fMenu));

            int numOfItems = in.nextInt();
            int numOfCat = in.nextInt();
            int numOfSubCat = in.nextInt();
            int numOfUnit = in.nextInt();
            in.nextLine();

            menu = new Product[numOfCat][numOfSubCat][numOfUnit];

            String[] cat = new String[numOfCat];
            String[][] subCat = new String[numOfCat][numOfSubCat];
            String[][][] desc = new String[numOfCat][numOfSubCat][numOfUnit];

            for (int k = 0; k < numOfCat; k++)
            {
                cat[k] = in.nextLine();
                for (int j = 0; j < numOfSubCat; j++)
                {
                    subCat[k][j] = in.nextLine();
                    for (int i = 0; i < numOfUnit; i++)
                    {
                        desc[k][j][i] = in.nextLine();
                    }
                }
            }

            int[] rate = new int[numOfItems];
            double[] price = new double[numOfItems];
            boolean[] taxable = new boolean[numOfItems];

            for (int k = 0; k < numOfItems; k++)
            {
                rate[k] = in.nextInt();
            }
            in.nextLine();
            for (int k = 0; k < numOfItems; k++)
            {
                price[k] = in.nextDouble();
            }
            in.nextLine();
            for (int k = 0; k < numOfItems; k++)
            {
                taxable[k] = in.nextBoolean();
            }

            in.close();

            int h = 0;
            for (int k = 0; k < numOfCat; k++)
            {                
                for (int j = 0; j < numOfSubCat; j++)
                {
                    for (int i = 0; i < numOfUnit; i++)
                    {
                        menu[k][j][i] = new Product(desc[k][j][i], price[h], taxable[h], rate[h]);
                        h++;
                        menu[k][j][i].setSubCategory(subCat[k][j]);
                        menu[k][j][i].setCategory(cat[k]);
                    }
                }                
            }
        }
        catch (IOException e)
        {
            System.out.println("Import Error");
        }

        return menu;
    }
    /**
     * allows the user to browse a menu and select an item from the menu
     * 
     * @param user the specific user that will be browsing and selecting items
     */
    private static void browse(Customer user)
    {
        int c = C.userSelectDropDown(user.getName() + ", what \ncategory are you interested " +
                "in?", "Category Select", user.getCategoryList());
        if (c < 0) {return;}
        int d = C.userSelectDropDown(user.getName() + ", what \nsubcategory are you interested " +
                "in?", "Category Select", user.getSubCategoryList(c));
        if (d < 0) {return;}
        int e = C.userSelectDropDown(user.getName() + ", which \nitem are you interested " +
                "in?", "Category Select", user.getDescriptionList(c, d));
        if (e < 0) {return;}

        Product selectedProduct = new Product();
        selectedProduct = user.getSelectedProduct(c, d, e);

        C.showMessage(selectedProduct.toString(), "Item Specifics");
        if (user.alreadyInCart(selectedProduct))
        {
            if (C.userYesOrNo(user.getName() + ", would you like to remove some instances of \n[" + 
                selectedProduct.getItemDescription() + "]?", "Confirm Remove"))
            {
                user.removeNumOfItems(selectedProduct, C.userInputInt(user.getName() + " how many instances of \n[" + 
                        selectedProduct.getItemDescription() + "] \nwould you like to remove?", "Remove Instance"));
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
                    user.removeFromCart(C.userSelectDropDown(user.getName() + ", which item " +
                            "would you like to remove?", "Remove Item", user.getCart()));
                    C.showMessage("Item removed.", "Item Removed");
                }                
            }
            else if (C.userYesOrNo(user.getName() + ", would you like to buy some quantity of [" + 
                selectedProduct.getItemDescription() + "]?", "Confirm Item"))
            {
                user.addToCart(selectedProduct, C.userInputInt(user.getName() + 
                        ", how many instances of \n[" + selectedProduct.getItemDescription() + 
                        "] \ndo you want to purchase?", "Number to buy"));
                C.showMessage("Item added to cart.", "Item Added");
            } 
        }
    }
    /**
     * displays the items currently in the users cart
     * 
     * @param user the user who's cart will be viewed
     */
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
    /**
     * displays each item in the cart, the price for each item individually and their subtotal, and the total price of the bill
     * 
     * @param user the specific user who's purchases will be finalized
     */
    private static void checkOut(Customer user)
    {
        String receipt = user.getReceipt();
        C.showMessage(receipt, "Receipt");
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
    /**
     * offers one last chance to not quit the program
     * 
     * @param user the user who is exiting the account, used only to display user name.
     */
    private static void exit(Customer user)
    {
        if (C.userYesOrNo(user.getName() + ", are you \nsure you want to exit?", "Confirm Exit"))
        {
            C.showMessage("It was my pleasure helping you today. \nGoodbye.", user.getName());
            System.exit(0);
        }
    }
}
