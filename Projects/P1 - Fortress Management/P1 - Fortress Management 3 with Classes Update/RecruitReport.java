
/* Contains the report for recruitment
 * 
 */
public class RecruitReport
{
    public static void run(CurrentUser theUser)
    {
        if (theUser.defGatRec[2].getValue() == 0)
        {
            System.out.println("You can't " + theUser.defGatRec[2].getVerb() + " any " + theUser.minions.getName() + " without assigning some " + theUser.defGatRec[2].getName() + "!");
        }
        else 
        {
            if (openPop(theUser))
            {
                int p = produced(theUser);
                if (p > 0)
                {
                    System.out.println("Your " + theUser.defGatRec[2].getName() + " " + theUser.defGatRec[2].getPast() + " " + p + " " + theUser.minions.getName() + " today!");
                    theUser.minions.addValue(p);
                    System.out.println("Your " + theUser.getLocation() + " now has " + theUser.minions.getValue() + " " + theUser.minions.getName() + "!");                        
                }
                else
                {
                    System.out.println("Your " + theUser.defGatRec[2].getName() + " weren't able to " + theUser.defGatRec[2].getVerb() + " any " + theUser.minions.getName() + " today, sorry!");
                }                
            }
            else
            {
                System.out.println("Your " + theUser.getLocation() + " doesn't have any room for more " + theUser.minions.getName() + ".");
            }
        }
    }
    private static int produced(CurrentUser theUser)
    {
        return (int)(0.5 + (theUser.buildings[2].getBonus() / 5) + (theUser.defGatRec[2].getValue() / (theUser.getDifficulty() + 3)));
    }
    private static boolean openPop(CurrentUser theUser)
    {        
//         int diffMod;
//         if (d == 0)
//         {
//             diffMod = 3;
//         }
//         else if (d == 1)
//         {
//             diffMod = 2;
//         }
//         else
//         {
//             diffMod = 1;
//         }
        //int m = ((diffMod * theUser.land.getValue()) + (diffMod * 10 * theUser.buildings[2].getValue()));
        if (theUser.minions.getValue() < ((Math.abs(theUser.getDifficulty() - 3) * theUser.land.getValue()) + (Math.abs(theUser.getDifficulty() - 3) * 10 * theUser.buildings[2].getValue())))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
