package intro.proj.p1.v3;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class CommonChecks
{
    public static void checkDebug(CurrentUser theUser)
    {    
        String str = (String)               // user choice received here
            JOptionPane.showInputDialog
            (null,                           // current frame
                null,  // prompt
                null,                   // title
                JOptionPane.PLAIN_MESSAGE,
                null,                        // path to alternate icon
                null,                        // items in drop-down
                null);                   // default choice (can be null)

        if (str.equals("deBUG"))
        {
            theUser.setDebug(true);
            JOptionPane.showMessageDialog
            (null,
                "Debug enabled.",
                null,
                JOptionPane.PLAIN_MESSAGE);

            System.out.println("Debug enabled.");
        }
    }

    public static void checkGender(CurrentUser theUser)
    {
        Scanner keyboard = new Scanner(System.in);
        boolean check = false;
        while (!check)
        {
            System.out.print("Are you a male or female? [m/f] ");
            String str = keyboard.nextLine().trim().toLowerCase();
            if (str.isEmpty())
            {
            }
            else if (str.charAt(0) == 'm' || str.charAt(0) == 'f')
            {
                if (str.charAt(0) == 'm')
                {
                    theUser.setMale(true);
                }
                else
                {
                    theUser.setMale(false);
                }                    
                check = true;
            }
            else
            {
                System.out.println("Invalid Input.");
            }
        }
    }

    public static void checkAltCommand (CurrentUser theUser)
    {
        String[] customSysNames = {"01protoss.txt", 
                "02dwarf.txt", "03chiss.txt", "04undead.txt", 
                "05goblin.txt", "06demon.txt", "07robot.txt", 
                "08pirate.txt", "09ninja.txt", "10cultist.txt"};
        String[] commandOptions = {"Protoss", 
                "Dwarves", "Chiss", "Undead", 
                "Goblin", "Demon", "Robot", 
                "Pirate", "Ninja", "Cultists"};
        String str = (String)               // user choice received here
            JOptionPane.showInputDialog
            (null,                           // current frame
                "What type of civilization do you want leadership of?",  // prompt
                null,                   // title
                JOptionPane.PLAIN_MESSAGE,
                null,                        // path to alternate icon
                commandOptions,                        // items in drop-down
                null);                   // default choice (can be null)

        if (str == null)
        {
        }
        else 
        {
            for (int k = 0; k < 10; k++)
            {
                if (str.equals(commandOptions[k]))
                {
                    theUser.setfName(customSysNames[k]);
                }
            }
        }
    }

    public static void checkCustomInput (CurrentUser theUser)
    {
        try
        {
            String fCustom = "100custom.txt";
            String fName = "00example.txt";            
            Scanner inName = new Scanner(new FileInputStream(fName));

            int limit = Integer.parseInt(inName.nextLine().trim());
            String[] exampleCustom = new String[limit];
            for (int k = 0; k < limit; k++)
            {
                exampleCustom[k] = inName.nextLine();
            }
            inName.close();

            PrintWriter outCustom = new PrintWriter(new FileOutputStream(fCustom));
            for (int k = 0; k < limit; k++)
            {
                boolean check = false;
                while (!check)
                {
                    String str = (String)              // user choice received here
                        JOptionPane.showInputDialog
                        (null,                                       // current frame
                            "Enter custom name for \"" + exampleCustom[k] + "\": ",          // prompt
                            null,  // title
                            JOptionPane.PLAIN_MESSAGE,
                            null,                          // path to alternate icon
                            null,                          // items in drop-down
                            null);                         // default choice

                    if (!str.isEmpty())
                    {
                        outCustom.println(str);
                        check = true;
                    }
                }
            }
            outCustom.close();

            theUser.setfName(fCustom);
        }                                                
        catch (Exception e)
        {
            messageOOC("Error writing custom race names.");
        }
    }

    public static void checkSaying (CurrentUser theUser)
    {
        if (!theUser.getSaying().equals("null"))
        {
            System.out.print(", \n" + theUser.getSaying());
        }
    }

    public static char checkConfirmDeny (CurrentUser theUser, String question)
    {
        Scanner keyboard = new Scanner(System.in);
        String str = null;
        boolean check = false;
        while (!check)
        {
            System.out.print(question + " [" + theUser.getConfirmChar() + "/" + theUser.getDenyChar() + "] ");
            str = keyboard.nextLine().trim().toLowerCase();

            if (str.isEmpty())
            {
            } 
            else if (str.charAt(0) == theUser.getConfirmChar() || str.charAt(0) == theUser.getDenyChar())
            {
                check = true;
            }
            else
            {
                System.out.println("Invalid Input");
            }
        }        
        return str.charAt(0);
    }

    public static char checkMultipleOption (CurrentUser theUser, String question, String errorReport, char[] options)
    {
        Scanner keyboard = new Scanner(System.in);
        String str = null;
        boolean check = false;
        while (!check)
        {
            System.out.print(question + " ");
            str = keyboard.nextLine().trim().toLowerCase();
            boolean success = false;
            if (str.isEmpty())
            {
            } 
            else
            {
                for (int k = 0; k < options.length; k++)
                {
                    if (str.charAt(0) == options[k])
                    {
                        check = true;
                        success = true;
                    }                    
                }
                if (!success)
                {
                    System.out.println(errorReport);
                }
            }            
        }
        return str.charAt(0);
    }

    public static String checkTwoStringOptions(CurrentUser theUser, String question, String errorReport, String[] options)
    {
        Scanner keyboard = new Scanner(System.in);
        String str = null;
        boolean check = false;
        while (!check)
        {
            System.out.print(question + " [" + options[0] + "/" + options[1] + "] ");
            str = keyboard.nextLine().trim().toLowerCase();
            boolean success = false;
            if (str.isEmpty())
            {
            } 
            else
            {
                if ((str.charAt(0) == theUser.getConfirmChar() && str.length() == 1) || (str.charAt(0) == theUser.getDenyChar() && str.length() == 1))
                {
                    check = true;
                    success = true;
                }
                else if (str.charAt(0) == 'q' && (str.charAt(0) != theUser.getConfirmChar()) && (str.charAt(0) != theUser.getDenyChar()))
                {
                    check = true;
                    success = true;
                }
                else
                {
                    for (int k = 0; k < options.length; k++)
                    {
                        if (str.equals(options[k]))
                        {
                            check = true;
                            success = true;
                        }                    
                    }
                }
                if (!success)
                {
                    System.out.println(errorReport);
                }
            }            
        }
        return str;
    }

    public static String checkMultipleStringOptions(CurrentUser theUser, String question, String errorReport, String[] options)
    {
        Scanner keyboard = new Scanner(System.in);
        String str = null;       
        String optionsString = ("[" + options[0]);        
        for (int k = 1; k < options.length; k++)
        {
            optionsString = (optionsString + "/" + options[k]);
        }
        optionsString = (optionsString + "] ");
        int[] numSelect = new int[options.length];
        for (int k = 0; k < numSelect.length; k++)
        {
            numSelect[k] = (k + 1);
        }
        boolean check = false;
        while (!check)
        {
            System.out.print(question + " " + optionsString);
            str = keyboard.nextLine().trim().toLowerCase();
            boolean success = false;
            if (str.isEmpty())
            {
            } 
            else
            {
                for (int k = 0; k < options.length; k++)
                {
                    if (checkNumberInt(str))
                    {
                        int i = (Integer.parseInt(str) - 1);
                        if (i < options.length)
                        {
                            str = options[i];
                        }
                    }
                    if (str.equals(options[k]) || str.equals(Integer.toString(numSelect[k])))
                    {
                        check = true;
                        success = true;
                    }
                }
                if (!success)
                {
                    System.out.println(errorReport);
                }
            }            
        }
        return str;
    }

    public static String forceAnswer(String question)
    {
        Scanner keyboard = new Scanner(System.in);
        String str = null;
        boolean check = false;
        while (!check)
        {
            System.out.print(question);
            str = keyboard.nextLine().trim().toLowerCase();

            if (str.isEmpty())
            {
            }
            else
            {
                check = true;
            }
        }
        return str;
    }

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

    public static void notImplementedOOC()
    {
        JOptionPane.showMessageDialog
        (null,
            "That mode hasn't been implemented yet, please select another.",
            null,
            JOptionPane.ERROR_MESSAGE);
    }

    public static void checkDifficulty (CurrentUser theUser)
    {
        String str = "What difficulty do you want to play?";
        String[] difficulties = {"Easy", "Medium", "Hard"};

        int diff = CommonChecks.checkOptionsOOC(str, difficulties);

        for (int k = 0; k < difficulties.length; k++)
        {
            if (diff == k)
            {
                theUser.setDifficulty(k);
            }
        }
    }

    public static int checkConfirmDenyOOC (CurrentUser theUser, String question)
    {
        int response = -1;
        boolean check = false;
        while(!check)
        {
            response = JOptionPane.showConfirmDialog
            ( null, 
                question, 
                null, 
                JOptionPane.YES_NO_OPTION);

            if (response == 0 || response == 1)
            {
                check = true;
            }
        }
        return response;
    }

    public static int checkOptionsOOC (String question, String[] options)
    {
        int response = -1;
        boolean check = false;
        while(!check)
        {
            response = JOptionPane.showOptionDialog   // will store the choice
            (null, 
                question, 
                null, // title
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,         // path to alternate icon
                options,      
                options[0]);  // default option

            if (response != -1)
            {
                check = true;
            }
        }
        return response;
    }
    
    public static void keyLine()
    {
        Scanner keyboard = new Scanner(System.in);
        keyboard.nextLine();
    }

    public static int checkOptionsDropDownOOC (String question, String[] options)
    {
        String strResponse = null;
        int response = -1;
        boolean check = false;
        while(!check)
        {
            strResponse = (String)
            JOptionPane.showInputDialog
            (null,                             // current frame
                question,          // prompt
                null,  // title
                JOptionPane.PLAIN_MESSAGE,
                null,                          // path to alternate icon
                options,                 // items in drop-down
                options[0]);             // default choice

            if (strResponse != null)
            {
                check = true;
                for (int k = 0; k < options.length; k++)
                {
                    if (strResponse.equals(options[k]))
                    {
                        response = k;
                    }
                }
            }
        }
        return response;
    }

    public static void messageOOC (String message)
    {
        JOptionPane.showMessageDialog
        (null,
            message,
            null,
            JOptionPane.PLAIN_MESSAGE);
    }

    public static String toFirstCap(String input)
    {
        return (input.substring(0, 1).toUpperCase() + input.substring(1));
    }
}
