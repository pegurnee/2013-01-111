package intro.util;
import java.util.Random;
/**
 * Write a description of class PrintingRandom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PrintingRandom
{
    public static void main(String[] args)
    {
        System.out.println(randomString(-229985452) + " " + randomString(-2102569775));
    }
    public static String randomString(int i)
    {
        Random ran = new Random(i);
        StringBuilder sb = new StringBuilder();
        for (int n = 0; ; n++)
        {
            int k = ran.nextInt(27);
            if (k == 0)
                break;
    
            sb.append((char)('W' + k));
        }
    
        return sb.toString();
    }
}
