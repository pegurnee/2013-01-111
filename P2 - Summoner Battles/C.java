import javax.swing.*;
/**
 * Holds common segments of code
 * 
 * @author Eddie Gurnee
 * @version 0.0.2
 */
public class C
{
    /**
     * A pop-up message box
     * 
     * @param theMessageText the text displayed in the message box
     * @param theTitleText the text displayed in the title of the message box
     */
    public static void showMessage(String theMessageText, String theTitleText)
    {
        JOptionPane.showMessageDialog
        (null,
            theMessageText,
            theTitleText,
            JOptionPane.PLAIN_MESSAGE);
    }
    /**
     * A pop-up message box allowing string input
     * 
     * @param thePrompt the text displayed in the message box to induce response
     * @param theTitleText the text displayed in the title of the message box
     * @return c the user inputted string
     */
    public static String userInputString(String thePrompt, String theTitleText)
    {
        String c = (String)
        JOptionPane.showInputDialog
        (null,
            thePrompt,
            theTitleText,
            JOptionPane.PLAIN_MESSAGE,
            null,
            null,
            null);
            
        return c;
    }
    /**
     * A pop-up message box allowing numeric input
     * 
     * @param thePrompt the text displayed in the message box to induce response
     * @param theTitleText the text displayed in the title of the message box
     * @return c the user inputted value as double
     */
    public static double userInputDouble(String thePrompt, String theTitleText)
    {
        return Double.parseDouble(userInputString(thePrompt, theTitleText));
    }
    /**
     * A pop-up message box allowing numeric input
     * 
     * @param thePrompt the text displayed in the message box to induce response
     * @param theTitleText the text displayed in the title of the message box
     * @return c the user inputted value as int
     */
    public static int userInputInt(String thePrompt, String theTitleText)
    {
        return (int)userInputDouble(thePrompt, theTitleText);
    }
    /**
     * A pop-up message box asking yes or no
     * 
     * @param thePrompt the text displayed in the message box to induce response
     * @param theTitleText the text displayed in the title of the message box
     * @return c the user yes or no returned as true or false
     */
    public static boolean userYesOrNo(String thePrompt, String theTitleText)
    {
        int c = JOptionPane.showConfirmDialog
            ( null, 
                thePrompt, 
                theTitleText, 
                JOptionPane.YES_NO_OPTION);
                
        if (c == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    /**
     * A pop-up message box with option buttons
     * 
     * @param thePrompt the text displayed in the message box to induce response
     * @param theTitleText the text displayed in the title of the message box
     * @param options the possible options in the selection buttons
     * @return c the user selected option returned as an int value
     */
    public static int userSelectButtons(String thePrompt, String theTitleText, String[] options)
    {
        int c = JOptionPane.showOptionDialog
            (null, 
                thePrompt, 
                theTitleText, 
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,         // path to alternate icon
                options,      // array of options to display
                options[0]);  // default option
                
        return c;
    }
    /**
     * A pop-up message box displaying possible selections in a drop down menu
     * 
     * @param thePrompt the text displayed in the message box to induce response
     * @param theTitleText the text displayed in the title of the message box
     * @param options the possible options in the selection box
     * @return c the selected option returned as an int value
     */
    public static int userSelectDropDown(String thePrompt, String theTitleText, String[] options)
    {
        String s = (String)
            JOptionPane.showInputDialog   // n will store the choice
            (null, 
                thePrompt, 
                theTitleText,                
                JOptionPane.PLAIN_MESSAGE,
                null,         // path to alternate icon
                options,      // array of options to display
                options[0]);  // default option
                
        int c = -1;
        for (int k = 0; k < options.length; k++)
        {
            if (options[k].equals(s))
            {
                c = k;
            }
        }
        return c;
    }    
}
