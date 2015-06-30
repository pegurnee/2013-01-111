package intro.proj.p1.v3;


/* Contains the night cycle events
 * 
 */
public class NightCycle
{
    public static void run(CurrentUser theUser)
    {
        System.out.println("__________________________________________");
        if (RandomEvents.check(theUser))
        {
            seperator("day's events");
            RandomEvents.run(theUser);
        }
        
        seperator(theUser.defGatRec[2].getActive() + " report");
        RecruitReport.run(theUser);
        
        seperator(theUser.defGatRec[1].getActive() + " report");
        GatherReport.run(theUser);
        
        seperator(theUser.defGatRec[0].getName() + " report");
        DefendReport.run(theUser);
        
        System.out.println("__________________________________________");
        theUser.setEndDay(false);
        theUser.dayCount();
    }
    private static void seperator(String s)
    {        
        System.out.println();            
        System.out.print("Press Enter to see the " + s + ".");
        CommonChecks.keyLine();
    }
}
