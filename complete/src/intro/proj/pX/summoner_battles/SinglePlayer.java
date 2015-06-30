package intro.proj.pX.summoner_battles;

/**
 * Write a description of class SinglePlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SinglePlayer
{
    public static void run()
    {       
        Summoner player = new Summoner();
        player.setName(C.userInputString("Summoner, enter your name:", "Enter Name"));
        player.addSummon(new Summon((C.userInputString("Name your first Summon:", "Name Starter")),
                (C.userSelectButtons("What type of Summon would you like to start with?", 
                "Starting Summon", new String[]{"Water", "Grass", "Fire"}))));        

        C.showMessage("Summoner " + player.getName() + "\nYour quest begins.", "");
        while (player.getAlive())
        {
            Phase.adventure(player);
        }
    }
}