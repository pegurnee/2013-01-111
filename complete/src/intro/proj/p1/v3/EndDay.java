package intro.proj.p1.v3;


/* Contains the commands to end the day
 * 
 */
public class EndDay
{
    public static void run(CurrentUser theUser)
    {
        char confirmEnd = CommonChecks.checkConfirmDeny(theUser, "Are you sure you want to end the day?");

        if (confirmEnd == theUser.getConfirmChar())
        {
            if (!theUser.checkFull())
            {
                System.out.println("You still have " + theUser.unassignedMinions() + " unassigned " + theUser.minions.getName() + ".");
                String str = "Are you absolutely positive you want to end the day?";
                char checkNotFull = CommonChecks.checkConfirmDeny(theUser, str);

                if (checkNotFull == theUser.getConfirmChar())
                {
                    theUser.setEndDay(true);
                }
            }
            else
            {
                theUser.setEndDay(true);
            }
        }
    }
}
