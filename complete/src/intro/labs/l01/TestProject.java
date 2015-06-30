package intro.labs.l01;

/* The first project for the COCS 111 class, an in class demo
 * Used for computing tax rate
Coding by Eddie Gurnee */

public class TestProject
{
   public static void main (String []args){
       System.out.println("Hello World"); //displays "Hello World//
       System.out.println(); //blank line//
       
       //michigan sales tax//
       double bill, taxRate, taxCost, totalCost; //declare variables//
       
       /*InputStreamReader istream = new InputStreamReader(System.in) ;
       BufferedReader inputBill = new BufferedReader(istream);
       System.out.println("How much is the bill?");
       */
       
       bill = 86.25; taxRate = .06; //base values, bill and percent of sales tax//
       taxCost = bill * taxRate; //math for tax cost//
       totalCost = bill + taxCost; //total cost of bill and tax//
       System.out.print("With a bill of $" + bill + " and a " + taxRate * 100); //displaying information//
       System.out.print("% sales tax, the tax on the bill will be $" + taxCost); //displaying information//
       System.out.print(", with a total cost of the bill, including tax, being $" + totalCost + "."); //displaying information//
       System.out.println(); //blank line//
       
       /*
       //playing with characters//
       char c = 'B'; 
       System.out.println("Char C = " + c);
       c = 65;
       System.out.println("Char 65 = " +c);
       System.out.println();
       
       //dungeons and dragons ability scores and modifiers//
       int str, dex, con, in, wis, cha, strMod, dexMod, conMod, inMod, wisMod, chaMod;
       str = 16; dex = 14; con = 15; in = 8; wis = 11; cha = 12;
       strMod = (str - 10) / 2; dexMod = (dex - 10) / 2; conMod = (con - 10) / 2; inMod = (in - 10) / 2; wisMod = (wis - 10) / 2; chaMod = (cha - 10) / 2; 
       System.out.println("Strength is = " + str + " and Strength modifier is " + strMod + ".");
       System.out.println("Dexterity is = " + dex + " and Dexterity modifier is " + dexMod + ".");
       System.out.println("Constitution is = " + con + " and Constitution modifier is " + conMod + ".");
       System.out.println("Intelligence is = " + in + " and Intelligence modifier is " + inMod + ".");
       System.out.println("Wisdom is = " + wis + " and Wisdom modifier is " + wisMod + ".");
       System.out.println("Charisma is = " + cha + " and Charisma modifier is " + chaMod + ".");
       System.out.println();
       */
      
       //
    }
}
