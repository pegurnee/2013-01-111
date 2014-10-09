
/* Contains the Day and Night Cycles of the game
 */
public class GameCycle
{
    public static void run(CurrentUser theUser, boolean input)
    {
        theUser.setRunGame(input);
        while (theUser.getRunGame())
        {
            DayCycle.run(theUser);
            NightCycle.run(theUser);
        }        
    }
}
