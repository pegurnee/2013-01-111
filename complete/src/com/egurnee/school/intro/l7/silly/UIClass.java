package com.egurnee.school.intro.l7.silly;
import javax.swing.*;
import java.util.Scanner;
/* Contains all the methods related to user interface
 * 
 */
public class UIClass
{
    public static void turnOn ()
    {
        Scanner sc = new Scanner(System.in);
        char c;

        boolean check = false;
        while (!check)
        {
            System.out.print("Would you like to start the program? [y/n] ");        
            String str = sc.nextLine().toLowerCase();

            if (str.length() == 1)
            {
                c = str.charAt(0);
                if (c == 'n')
                {
                    System.exit(0);
                }
                else if (c == 'y')
                {
                    check = true;
                }
            }
            else if (str.equals("no thank you. how about a game?"))
            {
            }            
        }
    }
    private static int enterOptions (String question, String[] options)
    {
        int r = JOptionPane.showOptionDialog   // will store the choice
        (null, 
            question, 
            null, // title
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,         // path to alternate icon
            options,      
            options[0]);  // default option

        return r;
    }
    private static String enterString(String prompt)
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

        return str;    
    }
    private static int enterInt(String prompt)
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
    public static void errorMessage (String error)
    {
        JOptionPane.showMessageDialog
        (null,
            error,
            null,
            JOptionPane.WARNING_MESSAGE);        
    }
    public static void displayTotal(RAMClass ram, int total)
    {
        JOptionPane.showMessageDialog
        (null,
            ram.getTotalPrompt() + total,
            null,
            JOptionPane.WARNING_MESSAGE);
    }
    public static void enterUser(RAMClass ram, boolean nYes)
    {
        ram.setUser(enterString(ram.getUserPrompt(nYes)), nYes);
    }
    public static void anotherStage(RAMClass ram, boolean fYes)
    {
        ram.setAnother(enterOptions(ram.getQuestion(fYes), ram.getOptions(fYes)));
    }
    public static void enterStage(RAMClass ram, boolean fYes)
    {
        ram.setStage(enterOptions(ram.getQuestion(fYes), ram.getOptions(fYes)));
    }
    public static void enterHours(RAMClass ram)
    {
        ram.setHours(enterInt(ram.getStagePrompts(0)));
    }
    public static void enterScience(RAMClass ram)
    {
        ram.setScienceCheck(enterOptions(ram.getStagePrompts(1), ram.getOptions(ram.F)));
    }
    public static void enterScholarship(RAMClass ram)
    {
        ram.setScholarship(enterInt(ram.getStagePrompts(2)));
    }
}
