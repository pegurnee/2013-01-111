package intro.labs.l07.v1;

import javax.swing.*;
/* All the User Interface Methods
 * 
 */
public class UI
{
    public static void main(String [] args)
    {
        Lab07 lab = new Lab07();
    }
    public static int op(String q, String[] o) // options dialog box
    {
        int r = JOptionPane.showOptionDialog   // will store the choice
        (null, 
            q, 
            null, // title
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,         // path to alternate icon
            o,      
            o[0]);  // default option

        return r;
    }
    public static int in(String prompt) // int dialog box
    {
        String str = (String)              // user choice received here
            JOptionPane.showInputDialog
            (null,                                       // current frame
                prompt,          // prompt
                null,  // title
                JOptionPane.PLAIN_MESSAGE,
                null,                          // path to alternate icon
                null,                          // items in drop-down
                null);                         // default choice
                
        int i = Integer.parseInt(str);

        return i;
    }    
    public static void dT(int t) // displays total cost
    {
        JOptionPane.showMessageDialog
        (null,
            "The total cost for the student is $" + t,
            null,
            JOptionPane.PLAIN_MESSAGE);
    }
}
