package intro.toys.fiddling;


import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Fiddler
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        
        TestClass case1 = new TestClass();
        
        System.out.print("Enter number in testCase to edit: ");
        case1.testInt = keyboard.nextInt();
        keyboard.nextLine();
        
        System.out.print("Enter a name for the testCase: ");
        case1.name = keyboard.nextLine();
        
        case1.writeOutput();
        
    }
}