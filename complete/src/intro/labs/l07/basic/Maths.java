package intro.labs.l07.basic;



/* The class where all calculations take place
 * 
 */
public class Maths
{
    private static int t(int h, double f, int s) //finds the total cost (hours, fees, scholarship)
    {
        final int PH = 1200;
        if ((int)(h * PH * f - s) < 0)
        {
            return 0;
        }
        else
        {
            return (int)(h * PH * f - s);
        }
    }
    public static int run(int h) //only needs to know the number of hours
    {
        return t(h, 1.09, 0);
    }
    public static int run(int h, double f) //needs to know the number of hours and the extra fees
    {
        return t(h, f, 0);
    }
    public static int run(int h, double f, int s) //needs to know number of hours, extra fees, and scholarship
    {
        return t(h, f, s);
    }    
}
