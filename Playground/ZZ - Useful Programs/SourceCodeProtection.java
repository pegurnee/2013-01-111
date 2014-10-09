import java.util.Random;
/**
 * Write a description of class SourceCodeProtection here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SourceCodeProtection
{
    public static void main(String[] args)
    {
        System.out.println(randomString(-1919252040, '\\') + 
            " " + randomString(-2145991374, 'b') + randomString(-2144568147, 'c') +
            " " + randomString(-2147463645,'_') + 
            " " + randomString(-2102569775, 'W'));
    }
    public static String randomString(int i, char b)
    {
        Random ran = new Random(i);
        StringBuilder sb = new StringBuilder();
        for (int n = 0; ; n++)
        {
            int k = ran.nextInt(27);
            if (k == 0)
                break;
    
            sb.append((char)(b + k));
        }
    
        return sb.toString();
    }
}
