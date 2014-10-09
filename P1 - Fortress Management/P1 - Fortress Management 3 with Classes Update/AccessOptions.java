import javax.swing.*;

/* Contains the adjustable options
 * 
 */

public class AccessOptions
{
    public static void run(CurrentUser theUser)
    {
        String[] optionChoices;
        if (!theUser.getDebug() && !theUser.getDebugChecked())
        {
            optionChoices = new String[6];            
            optionChoices[5] = "Debug";
        }
        else
        {
            optionChoices = new String[5];
        }
        optionChoices[0] = "Auto-Reset " + theUser.minions.getName();
        optionChoices[1] = "Change Save Location";
        optionChoices[2] = "Save Game";
        optionChoices[3] = "Change Confirm/Deny Characters";
        optionChoices[4] = "Change Difficulty";

        String optionChoice = (String)               // user choice received here
            JOptionPane.showInputDialog
            (null,                             // current frame
                "Choose the option to change:",          // prompt
                "Options",  // title
                JOptionPane.PLAIN_MESSAGE,
                null,                          // path to alternate icon
                optionChoices,                 // items in drop-down
                optionChoices[0]);             // default choice

        if (optionChoice == null)
        {
        }
        else 
        {
            String str = null, str1 = null;
            if (optionChoice.equals(optionChoices[0]))
            {
                str = "Would you like your " + theUser.minions.getName() + " jobs to automatically reset at the end of each day?";
                int autoResetChoice = CommonChecks.checkConfirmDenyOOC(theUser, str);            

                if (autoResetChoice == 0)
                {
                    str1 = "Your " + theUser.minions.getName() + " jobs will automatically reset at the end of the day.";

                    theUser.setAutoJobReset(true);
                }
                else
                {
                    str1 = "Your " + theUser.minions.getName() + " will retain jobs at the end of the day, if possible.";

                    theUser.setAutoJobReset(false);
                }
                CommonChecks.messageOOC(str1);
                System.out.println(str1);
            }
            else if (optionChoice.equals(optionChoices[1]))
            {
                str = "Would you like to change the file location used to save the game?";
                int saveLocationChoice = CommonChecks.checkConfirmDenyOOC(theUser, str);

                if (saveLocationChoice == 0)
                {                    
                    String newSaveLocation = (String)              // user choice received here
                        JOptionPane.showInputDialog
                        (null,                                       // current frame
                            "Name new save location (without file extension):",          // prompt
                            null,  // title
                            JOptionPane.PLAIN_MESSAGE,
                            null,                          // path to alternate icon
                            null,                          // items in drop-down
                            null);                         // default choice

                    theUser.setfSave(newSaveLocation + ".txt");

                    JOptionPane.showMessageDialog
                    (null,
                        "New save location set to " + theUser.getfSave() + ".",
                        null,
                        JOptionPane.PLAIN_MESSAGE);

                    System.out.println("New save location set to " + theUser.getfSave() + ".");
                }
                else
                {
                    JOptionPane.showMessageDialog
                    (null,
                        "Your save location remains at " + theUser.getfSave() + ".",
                        null,
                        JOptionPane.PLAIN_MESSAGE);

                    System.out.println("Your save location remains at " + theUser.getfSave() + ".");
                }
            }
            else if (optionChoice.equals(optionChoices[2]))
            {
                int saveGameChoice = JOptionPane.showConfirmDialog
                    (null, 
                        "Would you like to save your current game?", 
                        null, 
                        JOptionPane.YES_NO_OPTION);

                if (saveGameChoice == 0)
                {
                    //                     for (int k = 0; k < NUMARRAYS; k++)
                    //                     {
                    //                         int saveLimit = Integer.parseInt(saveGame[k][0]);
                    //                         for (int j = 1; j < saveLimit; j++)
                    //                         {
                    //                             if (variableNames[k][j].equals("numMinions"))
                    //                             {
                    //                                 saveGame[k][j] = Integer.toString(numMinions);
                    //                             }
                    //                             else if (variableNames[k][j].equals("gold"))
                    //                             {
                    //                                 saveGame[k][j] = Integer.toString(gold);
                    //                             }
                    //                             else if (variableNames[k][j].equals("defendBonus"))
                    //                             {
                    //                                 saveGame[k][j] = Integer.toString(defendBonus);
                    //                             }
                    //                             else if (variableNames[k][j].equals("gatherBonus"))
                    //                             {
                    //                                 saveGame[k][j] = Integer.toString(gatherBonus);
                    //                             }
                    //                             else if (variableNames[k][j].equals("luck"))
                    //                             {
                    //                                 saveGame[k][j] = Integer.toString(luck);
                    //                             }
                    //                             else if (variableNames[k][j].equals("day"))
                    //                             {
                    //                                 saveGame[k][j] = Integer.toString(day);
                    //                             }
                    //                             else if (variableNames[k][j].equals("maxMinions"))
                    //                             {
                    //                                 saveGame[k][j] = Integer.toString(maxMinions);
                    //                             }
                    //                             else if (variableNames[k][j].equals("maxGold"))
                    //                             {
                    //                                 saveGame[k][j] = Integer.toString(maxGold);
                    //                             }
                    //                             else if (variableNames[k][j].equals("numDragonKill"))
                    //                             {
                    //                                 saveGame[k][j] = Integer.toString(numDragonKill);
                    //                             }
                    //                             else if (variableNames[k][j].equals("numBattlesWon"))
                    //                             {
                    //                                 saveGame[k][j] = Integer.toString(numBattlesWon);
                    //                             }
                    //                             else if (variableNames[k][j].equals("itemsFound"))
                    //                             {
                    //                                 saveGame[k][j] = Integer.toString(itemsFound);
                    //                             }
                    //                             else if (variableNames[k][j].equals("difficulty"))
                    //                             {
                    //                                 saveGame[k][j] = Integer.toString(difficulty);
                    //                             }
                    //                             else if (variableNames[k][j].equals("name"))
                    //                             {
                    //                                 saveGame[k][j] = name;
                    //                             }
                    //                             else if (variableNames[k][j].equals("fName"))
                    //                             {
                    //                                 saveGame[k][j] = fName;
                    //                             }
                    //                             else if (variableNames[k][j].equals("confirm"))
                    //                             {
                    //                                 saveGame[k][j] = Character.toString(confirm);
                    //                             }
                    //                             else if (variableNames[k][j].equals("deny"))
                    //                             {
                    //                                 saveGame[k][j] = Character.toString(deny);
                    //                             }
                    //                             else if (variableNames[k][j].equals("debug"))
                    //                             {
                    //                                 saveGame[k][j] = Boolean.toString(debug);
                    //                             }
                    //                             else if (variableNames[k][j].equals("male"))
                    //                             {
                    //                                 saveGame[k][j] = Boolean.toString(male);
                    //                             }
                    //                         }

                    CommonChecks.notImplementedOOC();

                    //                     try
                    //                     {
                    //                         PrintWriter outSave = new PrintWriter(new FileOutputStream(theUser.getfSave()));
                    // 
                    //                         for (int k = 0; k < NUMARRAYS; k++)
                    //                         {
                    //                             int saveLimit = Integer.parseInt(saveGame[k][0]);
                    //                             for (int j = 0; j < saveLimit; j++)
                    //                             {
                    //                                 outSave.println(saveGame[k][j]);
                    //                             }
                    //                         }
                    // 
                    //                         outSave.close();
                    // 	
                    //                         JOptionPane.showMessageDialog
                    //                         (null,
                    //                             "Your current game has been saved in " + theUser.getfSave() + ".",
                    //                             null,
                    //                             JOptionPane.PLAIN_MESSAGE);
                    //                         System.out.println("Your current game has been saved in " + theUser.getfSave() + ".");
                    //                     }
                    //                     catch (Exception e)
                    //                     {
                    //                         JOptionPane.showMessageDialog
                    //                         (null,
                    //                             "Error saving your game: your current game was not saved.",
                    //                             null,
                    //                             JOptionPane.PLAIN_MESSAGE);
                    //                         System.out.println("Error saving your game: your current game was not saved.");
                    //                     }
                }
                else
                {
                    JOptionPane.showMessageDialog
                    (null,
                        "Your current game was not saved.",
                        null,
                        JOptionPane.PLAIN_MESSAGE);
                    System.out.println("Your current game was not saved.");
                }                               
            }
            else if (optionChoice.equals(optionChoices[3]))
            {
                int confirmDenyCharChoice = JOptionPane.showConfirmDialog
                    (null, 
                        "Would you like to change the characters used to confirm and deny to something other than '" + theUser.getConfirmChar() + "' and '" + theUser.getDenyChar() + "'?", 
                        null, 
                        JOptionPane.YES_NO_OPTION);

                if (confirmDenyCharChoice == 0)
                {
                    String newConfirmDeny1 = (String)              // user choice received here
                        JOptionPane.showInputDialog
                        (null,                                       // current frame
                            "What character would you like to use for confirm instead of '" + theUser.getConfirmChar() + "'?",          // prompt
                            null,  // title
                            JOptionPane.PLAIN_MESSAGE,
                            null,                          // path to alternate icon
                            null,                          // items in drop-down
                            null);                         // default choice

                    char checkConfirm = newConfirmDeny1.charAt(0);

                    String newConfirmDeny2 = (String)              // user choice received here
                    JOptionPane.showInputDialog
                    (null,                                       // current frame
                        "What character would you like to use for deny instead of '" + theUser.getDenyChar() + "'?",          // prompt
                        null,  // title
                        JOptionPane.PLAIN_MESSAGE,
                        null,                          // path to alternate icon
                        null,                          // items in drop-down
                        null);                         // default choice

                    char checkDeny = newConfirmDeny2.charAt(0);

                    if (newConfirmDeny1 != null && newConfirmDeny2 != null && checkConfirm != checkDeny)
                    {
                        theUser.setConfirmChar(checkConfirm);
                        theUser.setDenyChar(checkDeny);
                        
                        JOptionPane.showMessageDialog
                        (null,
                            "Your new confirm and deny characters are '" + theUser.getConfirmChar() + "' and '" + theUser.getDenyChar() + "'.",
                            null,
                            JOptionPane.PLAIN_MESSAGE);

                        System.out.println("Your new confirm and deny characters are '" + theUser.getConfirmChar() + "' and '" + theUser.getDenyChar() + "'.");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog
                        (null,
                            "Error processing request: your confirm and deny characters remain  '" + theUser.getConfirmChar() + "' and '" + theUser.getDenyChar() + "'.",
                            null,
                            JOptionPane.PLAIN_MESSAGE);
                        System.out.println("Error processing request: your confirm and deny characters remain  '" + theUser.getConfirmChar() + "' and '" + theUser.getDenyChar() + "'.");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog
                    (null,
                        "Your confirm and deny characters remain  '" + theUser.getConfirmChar() + "' and '" + theUser.getDenyChar() + "'.",
                        null,
                        JOptionPane.PLAIN_MESSAGE);
                    System.out.println("Your confirm and deny characters remain  '" + theUser.getConfirmChar() + "' and '" + theUser.getDenyChar() + "'.");
                }
            }
            else if (optionChoice.equals(optionChoices[4]))
            {
                CommonChecks.notImplementedOOC();
            }
            else if (optionChoice.equals(optionChoices[5]))
            {
                String debugExtraCheck = (String)               // user choice received here
                    JOptionPane.showInputDialog
                    (null,                           // current frame
                        null,  // prompt
                        null,                   // title
                        JOptionPane.PLAIN_MESSAGE,
                        null,                        // path to alternate icon
                        null,                        // items in drop-down
                        "");                   // default choice (can be null)

                if (debugExtraCheck.equals("deBUG"))
                {
                    theUser.setDebug(true);
                    JOptionPane.showMessageDialog
                    (null,
                        "Debug enabled.",
                        null,
                        JOptionPane.PLAIN_MESSAGE);

                    System.out.println("Debug enabled.");
                }
                else
                {
                    theUser.setDebugChecked(true);
                }
            }
        }
    }
}
