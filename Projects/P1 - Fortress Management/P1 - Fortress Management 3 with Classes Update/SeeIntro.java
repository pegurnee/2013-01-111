
/* Contains the processes to view the intro and commands
 * 
 */
public class SeeIntro
{    
    public static void run(CurrentUser theUser)
    {
        if (!theUser.loaded())
        {
            char confirm = CommonChecks.checkConfirmDeny(theUser, "Is this your first time playing?");

            if (confirm == theUser.getConfirmChar())
            {
                System.out.println();
                CommonChecks.messageOOC("Well then let me tell you the basics...");
                CommonChecks.messageOOC("Leaving the pampered life from which you came, \n" +
                                        "you and a group of loyal companions venture forth  \n" +
                                        "to claim your own land, and create a mark on \n" +
                                        "this world..."                
                                         );
                CommonChecks.messageOOC("Holding you in the highest of respects, your \n" +
                                        "companions trust you to guide their actions, to \n" +
                                        "not only survive, but to thrive in these untamed \n" +
                                        "wilds. \n" +
                                        "\n" +
                                        "The faith your companions have in you is boundless; \n" +
                                        "they would follow you into the depths of hell itself."
                                        );
                CommonChecks.messageOOC("This land is rich with resources needed to grow and \n" +
                                        "prosper. Working the land will give you resources \n" +
                                        "that can be used to upgrade and purchase more land; \n" +
                                        "and with more land, the number of companions you can \n" +
                                        "support grows."
                                        );
                CommonChecks.messageOOC("While this land is fertile and prime for expansion, \n" +
                                        "it is also fraught with danger; enemies of all shapes \n" +
                                        "and sizes are about: seeking to kill your companions, \n" +
                                        "steal your resources, and take what is yours by right. \n" +
                                        "\n" +
                                        "Only constant vigilence can protect you, as no one knows \n" +
                                        "when and where an attack will strike."
                                        );
                
               
                System.out.println("If all of your followers die, the game is over!");
                System.out.println();

                confirm = CommonChecks.checkConfirmDeny(theUser, "Would you like to see the commands?");

                if (confirm == theUser.getConfirmChar())
                {
                    ViewHelp.run(theUser);
                }
            }
            System.out.println();
            System.out.println("Welcome " + theUser.getTitle() + " " + theUser.getName() + ", to your new " + theUser.getLocation() + ".");             
        }
        else
        {
            System.out.println();
            System.out.println("Welcome back, " + theUser.getTitle() + " " + theUser.getName() + ".");
        }
        System.out.println("__________________________________________");
        CommonChecks.keyLine();

        System.out.println("Anytime you need to see the possible"); // informs how to see commands
        System.out.println("commands, just enter 'h' or '?'");
        CommonChecks.keyLine();

        System.out.print(theUser.getTitle() + " " + theUser.getName() + " your " + theUser.minions.getName() + " await");
        CommonChecks.checkSaying(theUser);        
        System.out.println("!");

        System.out.println("__________________________________________");
    }
} 