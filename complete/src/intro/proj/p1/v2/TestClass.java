package intro.proj.p1.v2;


/* This Class exists to test code before putting it into my program
 * 
 */

import javax.swing.*; // imports swing gui
import java.util.Scanner; // imports scanner

public class TestClass
{
    public static void main(String [ ] args)
    {
        Scanner keyboard = new Scanner(System.in);
        boolean runTest = true;
        int day = 1;

        String optionChoices[] = {"yolo", "brolo", "harsh"};

        String optionChoice = (String)               // user choice received here
            JOptionPane.showInputDialog
            (null,                             // current frame
                "Choose the option to change:",          // prompt
                "Options",  // title
                JOptionPane.PLAIN_MESSAGE,
                null,                          // path to alternate icon
                optionChoices,                 // items in drop-down
                optionChoices[0]);             // default choice

        System.out.println(optionChoice);
        while (runTest)
        {

            double random = (Math.random() + .25);
            double dayConvert = ((1 / Math.log((double)day) * 10) * Math.random() + .25);
            double dbl = (dayConvert * random);
            System.out.print("Press q to quit, anything else to generate number: ");
            String str = keyboard.nextLine();
            if (!str.equals("q"))
            {
                System.out.println("day: " + day);
                System.out.println("dayConvert: " + dayConvert);
                System.out.println("random: " + random);
                System.out.println("dbl: " + dbl);
            }
            else
            {
                runTest = false;
            }
            day++;
        }
    }
}
