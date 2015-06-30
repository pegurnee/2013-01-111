package intro.proj.pX.math_quiz;

import java.util.Scanner;
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
        Scanner key = new Scanner(System.in);
        
        System.out.print("What is your name? ");
        String n = key.nextLine().trim();
        
        System.out.print("What difficulty do you want to play? [easy/medium/hard] ");
        String d = key.nextLine().trim();
        
        int rD = -1;
        
        if (d.equalsIgnoreCase("easy") || d.equals("1"))
        {
            rD = 1;
        }
        
        User currentUser = new User(n, rD);
    }

}
