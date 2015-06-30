package intro.proj.p1.v3;

import java.util.Scanner;

/* Contains all of the commands and processes for entering in a name
 */
public class EnterName
{
    public static void run(CurrentUser theUser)
    {
        Scanner keyboard = new Scanner(System.in); // creates keyboard scanner

        boolean createName = false;
        for (int k = 0; createName != true; k++)
        {
            System.out.print("Enter Name: "); 
            theUser.setName(keyboard.nextLine().trim()); // reads in username            
            if (theUser.getName().isEmpty())
            {
                if (k == 7)
                {
                    System.out.println("Name Accepted! \nYou shall henceforth be known as Shitsipper.");
                    theUser.setName("Shitsipper");
                    createName = true;
                }
            }
            else
            {
                createName = true;
            }
        }

        String checkName = theUser.getName().toLowerCase(); // new variable checkName is all lowercase to compare against custom user names
        if (checkName.equals("eddie"))
        {
            theUser.setDebug(true);
        }
        else
        {
            if (checkName.equals("tassadar"))
            {
                theUser.setfName("01protoss.txt");
                theUser.setName("Tassadar");
            }
            else if (checkName.equals("thorin"))
            {
                theUser.setfName("02dwarf.txt");
                theUser.setName("Thorin Oakenshield");
            }
            else if (checkName.equals("thrawn"))
            {
                theUser.setfName("03chiss.txt");
                theUser.setName("Commander Mitth'raw'nuruodo");
            }
            else if (checkName.equals("thrawn"))
            {
                theUser.setfName("03chiss.txt");
                theUser.setName("Commander Mitth'raw'nuruodo");
            }
            else if (checkName.equals("thrawn"))
            {
                theUser.setfName("03chiss.txt");
                theUser.setName("Commander Mitth'raw'nuruodo");
            }
            else if (checkName.equals("thrawn"))
            {
                theUser.setfName("06demon.txt");
                theUser.setName("Commander Mitth'raw'nuruodo");
            }
            else if (checkName.equals("thrawn"))
            {
                theUser.setfName("07robot.txt");
                theUser.setName("Commander Mitth'raw'nuruodo");
            }
            else if (checkName.equals("thrawn"))
            {
                theUser.setfName("08pirate.txt");
                theUser.setName("Commander Mitth'raw'nuruodo");
            }
            else if (checkName.equals("thrawn"))
            {
                theUser.setfName("09ninja.txt");
                theUser.setName("Commander Mitth'raw'nuruodo");
            }
            else if (checkName.equals("thrawn"))
            {
                theUser.setfName("10cultist.txt");
                theUser.setName("Commander Mitth'raw'nuruodo");
            }
            else 
            {
                if (checkName.equals("mike") || checkName.equals("bill"))
                {
                    CommonChecks.checkDebug(theUser);
                }
                theUser.setfName("99basic.txt");
                CommonChecks.checkGender(theUser);
            }            
        }
    }
}