package intro.proj.p1.v3;


/* Contains the day cycle events
 * 
 */
public class DayCycle
{
    public static void run(CurrentUser theUser)
    {
        System.out.println();
        System.out.println("Press Enter to start Day " + (theUser.getDay() + 1) + ", " + theUser.getTitle() + " " + theUser.getName() + ".");           
        CommonChecks.keyLine();

        if (theUser.getAutoJobReset())
        {
            theUser.resetMinions();
            System.out.println("Minions Reset. \n");
        }
        else
        {
            CheckSameJobs.run(theUser);
        }
        
        CommandEnter.run(theUser);
    }
}
