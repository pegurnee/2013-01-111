package intro.proj.p1.v3;


/* Contains the report for gathering
 * 
 */
public class GatherReport
{
    public static void run(CurrentUser theUser)
    {
        if (theUser.defGatRec[2].getValue() == 0)
        {
            System.out.println("You can't " + theUser.defGatRec[1].getVerb() + " any " + theUser.gold.getName() + " without assigning some " + theUser.defGatRec[1].getName() + "!");
        }
        else
        {
            int p = produced(theUser);

            if (p > 0)
            {
                System.out.println("Your " + theUser.defGatRec[1].getName() + " " + theUser.defGatRec[1].getPast() + " " + p + " " + theUser.gold.getName() + " today!");
                theUser.gold.addValue(p);
                System.out.println("Your " + theUser.getLocation() + " now has " + theUser.gold.getValue() + " " + theUser.gold.getName() + "!");                        
            }
            else
            {
                System.out.println("Your " + theUser.defGatRec[1].getName() + " weren't able to " + theUser.defGatRec[1].getVerb() + " any " + theUser.gold.getName() + " today, sorry!");
            }            
        }
    }
    private static int produced(CurrentUser theUser)
    {
        return (int)(0.5 + (theUser.buildings[1].getBonus() / 3) + ((theUser.defGatRec[1].getValue() * (Math.random() * 4)) / (theUser.getDifficulty() + 1)));
    }
}
