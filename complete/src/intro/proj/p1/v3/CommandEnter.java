package intro.proj.p1.v3;


/* Contains the process for choosing commands
 * 
 */
public class CommandEnter
{
    public static void run(CurrentUser theUser)
    {
        while (!theUser.getEndDay() && theUser.getRunGame())
        {
            char[] possibleCommands = {'?', 'h', 'd', 'g', 'r', 'b', 's', 'm', 'e', 'o', 'q'};
            char command = CommonChecks.checkMultipleOption(theUser, "What is your command?", "Invalid Command. Press 'h' or '?' for help.", possibleCommands);

            if (command == 'h' || command == '?') // if 'h' is pressed, show command options
            {
                ViewHelp.run(theUser);
            }
            else if (command == 'd' || command == 'g' || command == 'r') // if 'd', 'g', or 'r' is pressed set/add defenders, gatherers, or recruiters
            {
                DefendGatherRecruit.run(theUser, command);
            }
            else if (command == 'b')
            {
                BuyThings.run(theUser);
            }
            else if (command == 's') // if 's' is pressed, see the economic status
            {
                EconomicStatus.run(theUser);
            }
            else if (command == 'm') // if 'm' is pressed, unassign all minion jobs
            {
                ResetMinions.run(theUser);
            }
            else if (command == 'e') // if 'e' is pressed, end the day
            {
                EndDay.run(theUser);
            }
            else if (command == 'o') // if 'o' is pressed, choose options
            {
                AccessOptions.run(theUser);
            }
            else if (command == 'q') // if 'q' is pressed, quit the game
            {
                QuitGame.run(theUser);
            }
            System.out.println();
            if (theUser.checkFull())
            {
                char confirmEnd = CommonChecks.checkConfirmDeny(theUser, "All of your " + theUser.minions.getName() + " are assigned. \nWould you like to end the day?");

                if (confirmEnd == theUser.getConfirmChar())
                {
                    theUser.setEndDay(true);
                }
            }
        }
    }
}
