package intro.proj.p1.v3;

import java.io.*;
import java.util.Scanner;

/* Contains the initial game setup
 */
public class StartGame
{
    public static void run(CurrentUser theUser)
    {
        Scanner keyboard = new Scanner(System.in);
        
        if (theUser.getDifficulty() == 0)
        {
            initialValues(20, 12, 10, 3, theUser);
        }
        else if (theUser.getDifficulty() == 1)
        {
            initialValues(10, 7, 6, 1, theUser);
        }
        else if (theUser.getDifficulty() == 2)
        {
            initialValues(0, 4, 4, 0, theUser);
        }
        else
        {
            multiplayer();
        }
        
        // check for existing text files
        String[] fileNames = {"00example.txt", "01protoss.txt", 
            "02dwarf.txt", "03chiss.txt", "04undead.txt", 
            "05goblin.txt", "06demon.txt", "07robot.txt", 
            "08pirate.txt", "09ninja.txt", "10cultist.txt", 
            "99basic.txt", "100custom.txt", "HighScore.txt", "HighScoreName.txt"};
        for (int k = 0; k < fileNames.length; k++)
        {
            File f = new File(fileNames[k]);
            if (!f.exists())
            {
                try
                {
                    String fCopy = fileNames[k];

                    InputStream stream = MainClass.class.getResourceAsStream(fCopy);        
                    Scanner inLoad = new Scanner(stream);

                    PrintWriter outCustom = new PrintWriter(new FileOutputStream(fCopy));
                    while (inLoad.hasNextLine())
                    {
                        String str = inLoad.nextLine();
                        outCustom.println(str);
                    }
                    stream.close();
                    outCustom.close();
                }
                catch (Exception e)
                {
                    System.out.println("Creating Host Files Error.");
                    System.exit(0);
                }
            }
        }
        System.out.println("Fortress Manager!");
        System.out.println("Press Enter to Start!");
        keyboard.nextLine(); 
    }
    private static void initialValues(int a, int b, int c, int d, CurrentUser theUser)
    {
        theUser.gold.setValue(a);
        theUser.minions.setValue(b);
        theUser.land.setValue(c);
        for (int k = 0; k < 3; k++)
        {
            theUser.buildings[k].setValue(d);
        }
    }
    private static void multiplayer()
    {
        CommonChecks.notImplementedOOC();
        System.exit(0);
    }
}
