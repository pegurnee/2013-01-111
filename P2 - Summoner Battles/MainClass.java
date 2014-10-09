
/**
 * Write a description of class MainClass here.
 * 
 * @author Eddie Gurnee
 * @version 0.0.04
 */
public class MainClass
{
    public static void main(String [ ] args)
    {
        int c = C.userSelectButtons("What type of game will be played?", 
                    "Setup Game", new String[]{"Single Player", "Hot-Seat Multiplayer", "LAN", "Exit"});
                    
        if (c == 0)
        {
            SinglePlayer.run();
        }
        else if (c == 1)
        {
            HotSeat.run();
        }
        else if (c == 2)
        {
            LAN.run();
        }
        else
        {
            System.exit(0);
        }
    }
}
