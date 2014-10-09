
/* Displays status about the economy
 */
public class EconomicStatus
{
    public static void run(CurrentUser theUser)
    {
        int totalJobs = 0;
        for (int k = 0; k < theUser.defGatRec.length; k++)
        {
            totalJobs = totalJobs + theUser.defGatRec[k].getValue();
        }
        System.out.println("You currently have " + theUser.minions.getValue() + " " + theUser.minions.getName() + ".");
        if (theUser.minions.getValue() > totalJobs)
        {
            System.out.println((theUser.minions.getValue() - totalJobs) + " of which are unassigned.");
        }
        if (theUser.defGatRec[0].getValue() > 0)
        {
            System.out.println(theUser.defGatRec[0].getValue() + " of them are " + theUser.defGatRec[0].getActive() + ".");
        }
        if (theUser.defGatRec[1].getValue() > 0)
        {
            System.out.println(theUser.defGatRec[1].getValue() + " of them are " + theUser.defGatRec[1].getActive() + " " + theUser.gold.getName() + ".");
        }                        
        if (theUser.defGatRec[2].getValue() > 0)
        {
            System.out.println(theUser.defGatRec[2].getValue() + " of them are " + theUser.defGatRec[2].getActive() + " more " + theUser.minions.getName() + ".");
        }
        if (theUser.land.getValue() > 0)
        {
            System.out.println("You currently have " + theUser.land.getValue() + " " + theUser.land.getName() + ".");            
        }
        if (theUser.land.getUnimproved() > 0)
        {
             System.out.println(theUser.land.getUnimproved() + " of which is unimproved.");
        }
        for (int k = 0; k < theUser.buildings.length; k++)
        {
            if (theUser.buildings[k].getValue() > 0)
            {
                System.out.println(theUser.buildings[k].getValue() + " of your " + theUser.land.getName() + " has been improved with a " + theUser.buildings[k].getName() + ".");
            }
        }        
        if (theUser.gold.getValue() > 0)
        {
            System.out.println("You currently have " + theUser.gold.getValue() + " " + theUser.gold.getName() + ".");
        }       
    }
}
