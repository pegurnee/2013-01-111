import java.io.*;
import java.util.Scanner;
import javax.swing.*;

/* Contains the commands to load the game
 */
public class LoadGame
{

    private String[][] variableNames = {
            {"numInArrayInt", "numMinions", "gold", "defendBonus", "gatherBonus", "luck", "day", "maxGold", "maxMinions", "numDragonKill", "numBattlesWon", "itemsFound", "difficulty"},
            {"numInArrayString", "name", "fName"},
            {"numInArrayChar", "confirm", "deny"},
            {"numInArrayBoolean", "debug", "male"}
        };
        
    public static void run(CurrentUser theUser)
    {
        String fLoad = "saveGame.txt";
        File f = new File(fLoad);
        if (f.exists())
        {
            boolean check = false;
            while (!check)
            {
                int confirm = JOptionPane.showConfirmDialog
                    ( null, 
                        "Would you like to load from a different location besides " + fLoad + "?", 
                        null, 
                        JOptionPane.YES_NO_OPTION);

                if(confirm == 0)
                {
                    String newLocation = (String)              // user choice received here
                        JOptionPane.showInputDialog
                        (null,                                       // current frame
                            "Name new load location:",          // prompt
                            null,  // title
                            JOptionPane.PLAIN_MESSAGE,
                            null,                          // path to alternate icon
                            null,                          // items in drop-down
                            null);                         // default choice

                    fLoad = (newLocation + ".txt");

                    loadFile(theUser, fLoad);                    
                }
                else if (confirm == 1)
                {
                    check = true;
                    theUser.setLoad(false);
                }
                else
                {
                }
            }
        }
    }

    private static void loadFile(CurrentUser theUser, String fLoad)
    {
        String[][] loadArray = new String[4][13];
        int[] loadLimit = new int[4];
        boolean confirmLocation = false;
        while (!confirmLocation)
        {
            try
            {
                //InputStream stream = MainClass.class.getResourceAsStream(fLoad);        
                //Scanner inLoad = new Scanner(stream);
                Scanner inLoad = new Scanner(new FileInputStream(fLoad));
                for (int k = 0; k < 4; k++)
                {
                    //String tempLoad = ;
                    loadLimit[k] = Integer.parseInt(inLoad.nextLine());
                    for (int j = 1; j < loadLimit[k]; j++)
                    {
                        loadArray[k][j] = inLoad.nextLine();
                    }
                }
                inLoad.close();

                confirmLocation = true;

                load(theUser, loadArray);
            }
            catch (Exception e)
            {
                int errorLoad = JOptionPane.showConfirmDialog
                    ( null, 
                        "Error loading from file location, would you like to try to load from another location?", 
                        null, 
                        JOptionPane.YES_NO_OPTION);

                if (errorLoad == 0)
                {
                    String newLoadLocation = (String)              // user choice received here
                        JOptionPane.showInputDialog
                        (null,                                       // current frame
                            "Name new load location, remember: \n-\".txt\" files only \n-Do not include the \".txt\" \n-Capitalization does not matter:",          // prompt
                            null,  // title
                            JOptionPane.PLAIN_MESSAGE,
                            null,                          // path to alternate icon
                            null,                          // items in drop-down
                            null);                         // default choice

                    fLoad = (newLoadLocation + ".txt");
                }
                else if (errorLoad == 1)
                {
                    run(theUser);
                }
                else
                {
                    System.exit(0);
                }
            }
        }
    }

    public static void load(CurrentUser theUser, String[][] theLoadArray)
    {
        // load int values
        theUser.minions.setValue(Integer.parseInt(theLoadArray[0][1]));
        theUser.gold.setValue(Integer.parseInt(theLoadArray[0][2]));
        theUser.defGatRec[0].setBonus(Integer.parseInt(theLoadArray[0][3]));
        theUser.defGatRec[1].setBonus(Integer.parseInt(theLoadArray[0][4]));
        // theUser.setLuck(Integer.parseInt(theLoadArray[0][5]));
        theUser.setDay(Integer.parseInt(theLoadArray[0][6]));
        theUser.gold.setMax(Integer.parseInt(theLoadArray[0][7]));
        theUser.minions.setMax(Integer.parseInt(theLoadArray[0][8]));
        theUser.setNumDragonKill(Integer.parseInt(theLoadArray[0][9]));
        theUser.setNumBattlesWon(Integer.parseInt(theLoadArray[0][10]));
        // theUser.setItemsFound(Integer.parseInt(theLoadArray[0][11]));
        // theUser.setDifficulty(Integer.parseInt(theLoadArray[0][12]));

        // load string values
        theUser.setName(theLoadArray[1][1]);
        theUser.setfName(theLoadArray[1][2]);

        // load char values
        theUser.setConfirmChar(theLoadArray[2][1].charAt(0));
        theUser.setDenyChar(theLoadArray[2][2].charAt(0));

        // load boolean values
        theUser.setDebug(Boolean.parseBoolean(theLoadArray[3][1]));
        theUser.setMale(Boolean.parseBoolean(theLoadArray[3][2]));

        theUser.setLoad(true);

        System.out.println();                        
        System.out.println("Welcome back, " + theUser.getTitle() + " " + theUser.getName() + ".");
    }
}