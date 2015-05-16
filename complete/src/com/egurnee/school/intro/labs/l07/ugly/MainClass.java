package com.egurnee.school.intro.labs.l07.ugly;
import java.util.Scanner; // imports scanner class
/* Purpose of this program is to quickly calculate tuition based on a few factors
 * All coding provided by Eddie Gurnee
 * version 0.0.1
 */
public class MainClass
{
    public static void main(String [] args)
    {
        Scanner z = new Scanner(System.in); // scanner used to read in from the keyboard
        int h, s, t; // hours, scholarship, total tuition
        double f; // fees
        boolean sc; // science student        
        
        cSt(1, z); // stage one
        h = qH(z); // initializing hours
        t = m(h); // calculating totals
        c(z, t); // displaying total
        
        cSt(2, z); // stage two
        h = qH(z);
        f = qF(z); // initalizing fees based on participation in the field of science
        t = m(h, f); // calculating totals
        c(z, t); // displaying total
        
        cSt(3, z); // stage 3
        h = qH(z);
        f = qF(z);
        s = qS(z); // initalizing scholarship to be taken off after fees
        t = m(h, f, s); // calculating totals
        c(z, t); // displaying totals
    }
    private static void c(Scanner z, int t) // clean up at end of stage
    {
        aT(t);
        z.nextLine();
    }
    private static void aT(int t) // displaying total
    {
        pL("The total cost for the student will be $" + t);
    }
    private static int t(int h, double f, int s) // finds the total cost (hours, fees, scholarship)
    {
        final int PH = 1200; // cost per hour
        int t = (int)(h * PH * f - s);
        
        if (t < 0)
        {
            return 0;
        }
        else
        {
            return t;
        }
    }    
    private static int m(int h) // only needs to know the number of hours
    {
        return t(h, 1.09, 0);
    }
    private static int m(int h, double f) // needs to know the number of hours and the extra fees
    {
        return t(h, f, 0);
    }
    private static int m(int h, double f, int s) // needs to know number of hours, extra fees, and scholarship
    {
        return t(h, f, s);
    }
    private static void cSt(int n, Scanner z) // confirms continued viewing of lab
    {
        String s = "Would you like to see Stage " + n + "?";
        if (fA(s, z) == 'n')
        {
            System.exit(0);
        }
        pL("Stage " + n + ":");
        pL();
    }
    private static int qH(Scanner z) // question regarding the enrolled hours
    {
        return fAInt("How many hours is the student registered for?", z);
    }
    private static double qF(Scanner z) // question regarding the science department
    {
        char c = fA("Is the student a science student?", z);
        if (c == 'y')
        {
            return 1.12;
        }
        else
        {
            return 1.09;
        }
    }
    private static int qS(Scanner z) // question regarding the scholarship amount
    {
        return fAInt("How much in scholarships did the student recieve?", z);
    }
    private static double fADub(String q, Scanner z) // reads in a double
    {
        return Double.parseDouble(fAStr(q, z));
    }
    private static int fAInt(String q, Scanner z) // reads in an int
    {
        return Integer.parseInt(fAStr(q, z));
    }
    private static String fAStr(String q, Scanner z) // reads in a string
    {
        String s = null;
        boolean f = false;
        while (!f)
        {
            pS(q + " ");
            s = z.nextLine().trim().toLowerCase();
            if (s.isEmpty())
            {
            }
            else
            {
                f = true;
            }
        }
        return s;
    }
    private static char fA(String q, Scanner z) // force answer to a yes or no question
    {
        char c = 'a';
        boolean f = false;
        while (!f)
        {
            pS(q + " [y/n] ");
            String s = z.nextLine().trim().toLowerCase();
            if (s.isEmpty())
            {
            }
            else if (s.charAt(0) == 'y' || s.charAt(0) == 'n')
            {
                c = s.charAt(0);
                f = true;
            }            
        }
        return c; // returns 'y' or 'n'
    }    
    private static void pL() // prints a blank line
    {
        System.out.println();
    }
    private static void pL(String s) // println method
    {
        System.out.println(s);
    }
    private static void pS(String s) // print method
    {
        System.out.print(s);
    }    
}