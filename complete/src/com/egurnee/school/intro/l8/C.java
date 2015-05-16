package com.egurnee.school.intro.l8;
import javax.swing.*;
/**
 * Holds common segments of code
 * 
 * @author Eddie Gurnee
 * @version 0.0.1
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
}
