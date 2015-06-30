package intro.proj.p1.v2;

import javax.swing.*; // imports swing class
/* Selects what mode for the user to play
 * 
 */
public class MainClass
{
    public static void main(String [ ] args)
    {
        TheGame game = new TheGame();
        boolean selectGameStyle = false;

        while (!selectGameStyle)
        {
            // Box that displays a set of choice buttons
            //   create array of options to present in dialog box    
            String[] gameMode = {"Single Player", "Multiplayer", "LAN", "Online", "Quit"};

            int n = JOptionPane.showOptionDialog   // n will store the choice
                (null, 
                    "What mode would you like to play?", 
                    null, // title
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,         // path to alternate icon
                    gameMode,      // array of game modes to display
                    gameMode[0]);  // default option

            if (n == 0)
            {
                game.run();
            }
            else if (n == 1 || n == 2 || n == 3)
            {
                JOptionPane.showMessageDialog
                (null,
                    "That mode hasn't been implemented yet, please select another.",
                    null,
                    JOptionPane.ERROR_MESSAGE);
                    
            }
            else if (n == 4)
            {
                System.exit(0);
            }
            else
            {
            }
        }
    }
}
