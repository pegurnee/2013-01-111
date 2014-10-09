/* Contains the processes for buying items
 * 
 */

public class BuyThings
{
    public static void run(CurrentUser theUser)
    {
        if (theUser.gold.getValue() == 0)
        {
            System.out.println("You have no " + theUser.gold.getName() + " to spend.");           
        }
        else
        {
            String questionLandOrImprove = "Would you like to buy more land or improve your land?";
            String[] possibleLandOrImprove = {"land", "improve"};
            String response = CommonChecks.checkTwoStringOptions(theUser, questionLandOrImprove, "Invalid command.", possibleLandOrImprove);
            boolean checkBuy;

//             try
//             {
                if (response.equals("land") || (response.charAt(0) == theUser.getConfirmChar() && !response.equals("improve")))
                {
                    runBuyLand(theUser);
                }
                else if (response.equals("improve") || (response.charAt(0) == theUser.getDenyChar() && !response.equals("land")))
                {
                    runImprove(theUser);
                }
//             }
//             catch (Exception e)
//             {
//                 System.out.println("Congratz, you broke the game.");
//                 System.exit(0);
//             }
        }
    }

    public static void runBuyLand(CurrentUser theUser)
    {
        int landCost = theUser.land.getCost();
        String str = "It currently costs " + landCost + " " + theUser.gold.getName() + " to purchase one more " + theUser.land.getName() + ". \nAre you sure you want to buy one?";

        char confirmBuy = CommonChecks.checkConfirmDeny(theUser, str);

        if (confirmBuy == theUser.getConfirmChar())
        {
            if (landCost > theUser.gold.getValue())
            {
                System.out.println("I'm sorry, " + theUser.getTitle() + ",");
                System.out.println("you don't have enough " + theUser.gold.getName() + " to do that.");
            }
            else
            {
                theUser.land.buyLand();
                String landName = CommonChecks.toFirstCap(theUser.land.getName());
                System.out.println(landName + " purchased.");
                System.out.print("You now have " + theUser.land.getValue() + " " + theUser.land.getName() + ", ");
                if (theUser.land.getImproved() > 0)
                {
                    System.out.println(theUser.land.getImproved() + " of which is improved.");
                }
                else
                {
                    System.out.println("all of which is unimproved.");
                }
            }
        }
    }

    public static void runImprove(CurrentUser theUser)
    {
        if (theUser.land.getUnimproved() == 0)
        {
            System.out.println("I'm sorry " + theUser.getTitle() + ",");
            System.out.println("you don't have any unimproved " + theUser.land.getName() + " to improve upon.");
        }
        else
        {
            String str = "What improvement would you like to purchase?";
            String[] buildingNames = new String[theUser.buildings.length];
            for (int k = 0; k < buildingNames.length; k++)
            {
                buildingNames[k] = theUser.buildings[k].getName();
            }

            String response = CommonChecks.checkMultipleStringOptions(theUser, str, "Invalid option", buildingNames).toLowerCase();

            for (int k = 0; k < buildingNames.length; k++)
            {
                if (response.equalsIgnoreCase(buildingNames[k]))
                {
                    String str1 = "It costs " + theUser.buildings[k].getCost() + " to purchase a " + theUser.buildings[k].getName() + ". \nAre you sure you want to upgrade?";
                    char confirmBuy = CommonChecks.checkConfirmDeny(theUser, str1);

                    if (confirmBuy == theUser.getConfirmChar())
                    {
                        if (theUser.buildings[k].getCost() > theUser.gold.getValue())
                        {
                            System.out.println("I'm sorry " + theUser.getTitle() + ",");
                            System.out.println("you don't have enough " + theUser.gold.getName() + " to do that.");
                        }
                        else
                        {                            
                            theUser.buildings[k].buyImprovement(theUser);
                            String buildingName = CommonChecks.toFirstCap(theUser.buildings[k].getName());
                            System.out.println(buildingName + " purchased.");
                            System.out.print("You now have " + theUser.buildings[k].getValue() + " " + theUser.buildings[k].getName());
                            if (theUser.buildings[k].getValue() > 1)
                            {
                                System.out.print("s");
                            }
                            System.out.println(".");
                        }
                    }
                }
            }
        }
    }
}
