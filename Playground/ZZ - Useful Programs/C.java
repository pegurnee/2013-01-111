import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.util.Random;
/**
 * Class C contains Eddie Gurnee's commonly used static methods
 * All coding provided by Eddie Gurnee
 * 
 * @author Eddie Gurnee
 * @version 0.0.09
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
        return userInputString(thePrompt, theTitleText, null);
    }
    /**
     * A pop-up message box allowing string input
     * 
     * @param thePrompt the text displayed in the message box to induce response
     * @param theTitleText the text displayed in the title of the message box
     * @param defaultText the text displayed as the default input string value
     * @return c the user inputted string
     */
    public static String userInputString(String thePrompt, String theTitleText, String defaultText)
    {
        String c = (String)
            JOptionPane.showInputDialog
            (null,
                thePrompt,
                theTitleText,
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                defaultText);
            
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
        double r = 0;
        try
        {
            r = Double.parseDouble(userInputString(thePrompt, theTitleText));
        }
        catch (Exception e)
        {
            showMessage("Error: Improper Format.", "Input Error");
            userInputDouble(thePrompt, theTitleText);
        }
        return r;
    }
    /**
     * A pop-up message box allowing numeric input
     * 
     * @param thePrompt the text displayed in the message box to induce response
     * @param theTitleText the text displayed in the title of the message box
     * @return c the user inputted value (rounded) as int
     */
    public static int userInputInt(String thePrompt, String theTitleText)
    {
        return (int)(userInputDouble(thePrompt, theTitleText) + 0.5);
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
     * A pop-up message box displaying possible selections in button form
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
    /**
     * A pop-up error box informing the user that something hasn't been included yet
     * 
     */
    public static void notImplementedOOC()
    {        
        JOptionPane.showMessageDialog
        (null,
            "That hasn't been implemented yet, try something else.",
            "Not Implemented",
            JOptionPane.ERROR_MESSAGE);
    }
    /**
     * Utility to see if an inputted string is a numeric value
     * 
     * @param checkString the String to check if it a valid integer
     * @return validNum returns true if the input is a numeric value
     */
    public static boolean checkNumberInt(String checkString)
    {
        boolean validNum = true;
        for (int k = 0; k < checkString.length(); k++)
        {                                
            if (!Character.isDigit(checkString.charAt(k)))
            {                                            
                validNum = false;
            }
        }
        return validNum;
    }
    /**
     * Utility to print an empty line to the terminal
     * 
     */    
    public static void keyLine()
    {
        System.out.println();
    }
    /**
     * Prints out a specific number of empty lines
     *  
     * @param num the number of empty lines to be printed out
     */
    public static void keyLine(int num)
    {
        for (int k = 0; k < num; k++)
        {
            keyLine();
        }
    }
    /**
     * Waits on the user to Press Enter
     * 
     */
    public static void pressEnter()
    {
        Scanner keyboard = new Scanner(System.in);
        keyboard.nextLine();
    }
    /**
     * Utility to clear the terminal by printing out 500 empty lines
     * 
     */
    public static void clearTerm()
    {
        keyLine(500);
    }
    /**
     * Utility to capitalize the first letter of a given String
     *  
     * @param input the String where the first letter shall be capitalized
     * @return the String with the first letter capitalized
     */
    public static String toFirstCap(String input)
    {
        return (input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase());
    }
    /**
     * Utility to get the OS name
     * 
     * @return the OS name
     */
    public static String getOS()
    {
        return System.getProperty("os.name");
    }
    /**
     * Utility to create random strings
     * 
     * @param i seed
     * @param b char seed
     * @return randomly generated string based on seed and character seed
     */
    public static String randomString(int i, char b)
    {
        Random ran = new Random(i);
        StringBuilder sb = new StringBuilder();
        for (int n = 0; ; n++)
        {
            int k = ran.nextInt(27);
            if (k == 0)
                break;
    
            sb.append((char)(b + k));
        }
    
        return sb.toString();
    }
    public static void falseCheck()
    {
        System.out.println(randomString(-1919252040, '\\') + 
            " " + randomString(-2147463645,'_') + 
            " " + randomString(-2102569775, 'W'));
    }
}
