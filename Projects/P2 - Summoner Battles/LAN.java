
/**
 * Write a description of class LAN here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LAN
{
    public static void run()
    {
        int c = C.userSelectButtons("Do you want to host the game, or join another?", 
                "Setup Game", new  String[]{"Host", "Join"});
        
        if (c == 0)
        {
            host();
        }
        else if (c == 1)
        {
            join();
        }
        else
        {
            System.exit(0);
        }
    }
    private static void host()
    {
    }
    private static void join()
    {
    }
}
