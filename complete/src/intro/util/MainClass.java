package intro.util;

/**
 * Write a description of class MainClass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainClass
{
    public static void main(String[] args)
    {
        
    }
    public static void getLength()
    {
        String c = C.userInputString("Length of :", "Input String to obtain Length of");
        C.showMessage("Length of " + c + ": " + c.length(), "Length");
    }
    public static void getOS()
    {
        C.showMessage("Computer's Operating System: " + C.getOS(), "Operating System");
    }
    public static void stringPlay()
    {
        String str = String.format("This is the %40s", "string test.");
        C.showMessage(str, "String Test");
        System.out.println("This is the \n\t\tstring test.");
        System.out.println(str);
    }
}
