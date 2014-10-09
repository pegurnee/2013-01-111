
/**
 * Write a description of class HotSeat here.
 * 
 * @author Eddie Gurnee
 * @version 0.0.04
 */
public class HotSeat
{
    public static void run()
    {
        Summoner[] players = new Summoner[C.userInputInt("How many players will be playing?", "Start Game")];

        for (int k = 0; k < players.length; k++)
        {
            players[k] = new Summoner();
            players[k].setName(C.userInputString("Player " + (1 + k) + ", enter your name:", "Enter Name"));
            players[k].addSummon(new Summon((C.userInputString("Name your first Summon:", "Name Starter")),
                    (C.userSelectButtons("What type of Summon would you like to start with?", 
                    "Starting Summon", new String[]{"Water", "Grass", "Fire"}))));
        }

        while (anyAlive(players))
        {
            for (int k = 0; k < players.length; k++)
            {
                if (players[k].getAlive())
                {
                    C.showMessage("Summoner " + players[k].getName() + "\nIt is your turn.", "");
                    Phase.adventure(players[k]);                    
                }
            }
        }
    }
    private static boolean anyAlive(Summoner[] players)
    {
        boolean c = false;
        for (int k = 0; k < players.length; k++)
        {
            if (players[k].getAlive())
            {
                c = true;
            }
        }
        return c;
    }
}
