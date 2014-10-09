
/* It's a game.
 * All coding provided by Eddie Gurnee
 * 
 * This class allows the user to decide what mode to play
 * 
 * version 0.2.14
 * 
 */
public class MainClass
{
    public static void main(String [ ] args)
    {
        for (int k = 0; k < 5; k++)
        {
            //  Box that displays a set of choice buttons
            //  create array of options to present in dialog box    
            String[] gameMode = {"Single Player", "Multiplayer", "LAN", "Online", "Quit"};
            String modeSelect = "What mode would you like to play?";

            int n = CommonChecks.checkOptionsOOC(modeSelect, gameMode);

            if (n == 0)
            {
                SinglePlayer.run();
            }
            else if (n == 1 || n == 2 || n == 3)
            {
                CommonChecks.notImplementedOOC();                    
            }
            else if (n == 4)
            {
                System.exit(0);
            }
        }
        CommonChecks.messageOOC("If you're having that much trouble with starting the game, \nyou probably shouldn't even attempt this game.");
    }
}
