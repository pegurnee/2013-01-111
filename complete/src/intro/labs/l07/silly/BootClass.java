package intro.labs.l07.silly;

/* Gotta load the program before doing anything else!
 * 
 */
public class BootClass
{
    public static void main(String [] args)
    {
        UIClass.turnOn();
        
        CPUClass processor = new CPUClass();
    }    
}