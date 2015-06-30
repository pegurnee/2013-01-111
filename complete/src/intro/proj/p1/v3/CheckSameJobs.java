package intro.proj.p1.v3;

/* Checks if the user wants to assign the same jobs as yesterday
 * 
 */
public class CheckSameJobs
{
    public static void run(CurrentUser theUser)
    {
        if (theUser.getDay() > 1 && theUser.minions.getValue() == theUser.minions.getOld())
        {
            String str = "Would you like to keep the same number \nof " + theUser.defGatRec[0].getName() + ", " + theUser.defGatRec[1].getName() + ", and " + theUser.defGatRec[2].getName() + " as yesterday?";
            char sameNum = CommonChecks.checkConfirmDeny(theUser, str);
            if (sameNum == theUser.getConfirmChar())
            {
                char endDay = CommonChecks.checkConfirmDeny(theUser, "Would you like to end the day?");
                if (endDay == theUser.getConfirmChar())
                {
                    theUser.setEndDay(true);
                }
            }
        }
    }
}
