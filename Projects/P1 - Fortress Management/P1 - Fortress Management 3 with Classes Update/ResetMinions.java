
/* Resets all currently allocated minions
 */
public class ResetMinions
{
    public static void run(CurrentUser theUser)
    {
        theUser.resetMinions();
        System.out.println(theUser.minions.getName() + " reset.");
    }
}
