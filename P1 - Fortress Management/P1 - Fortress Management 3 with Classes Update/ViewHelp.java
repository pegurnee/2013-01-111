
/* Contains the help information
 * 
 */
public class ViewHelp
{
    public static void run(CurrentUser theUser)
    {
        System.out.println("Press 'd' to set " + theUser.defGatRec[0].getName() + ".");
        System.out.println("Press 'g' to set " + theUser.defGatRec[1].getName() + ".");
        System.out.println("Press 'r' to set " + theUser.defGatRec[2].getName() + ".");
        System.out.println("Press 'b' to purchase and upgrade land.");
        System.out.println("Press 's' to see economic status.");
        System.out.println("Press 'm' to see reset " + theUser.minions.getName() + " distribution.");
        System.out.println("Press 'e' to end the day.");
        System.out.println("Press 'o' to access options.");
        System.out.println("Press 'q' to quit game.");
    }
}