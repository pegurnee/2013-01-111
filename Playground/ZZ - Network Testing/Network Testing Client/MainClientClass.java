import java.io.*;
import java.net.*;
import java.util.Scanner;
/**
 * Write a description of class MainClientClass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainClientClass
{
    public static void main(String[] args)
    {
        try
        {
            Scanner s = new Scanner(System.in);
            
            int port = 25565;
            String host = "localhost";
            
            System.out.println("Connecting to server port " + port);
            Socket conn = new Socket(host, port);
            
            BufferedReader serverIn = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            DataOutputStream serverOut = new DataOutputStream(conn.getOutputStream());
            
            System.out.println("Connection made!");
            System.out.print("Enter name: ");
            String name = s.nextLine();
            serverOut.writeBytes(name + "\n");
            
            System.out.println("Waiting for reply...");
            String sreply = serverIn.readLine();
            System.out.println("Recieved: " + sreply);
            
            Product pClient = new Product();
            System.out.println("Product: " + pClient.toString());
            System.out.print("Enter SKU number: ");
            pClient = new Product(s.nextInt(), "Shoe", 17.99, true, 8, 3);
            s.nextLine();
            
            System.out.println("Sending product: " + pClient.toString());            
            serverOut.writeBytes(pClient.getSkuNumber() + "\n" + pClient.getItemDescription() + "\n" +
                    pClient.getItemPrice() + "\n" + pClient.getIsTaxable() + "\n" + pClient.getTaxRate() + 
                    "\n" + pClient.getNumOfProducts() + "\n");
            
            System.out.println("Waiting for updated name...");
            pClient.setItemDescription(serverIn.readLine());
            System.out.println("Renew Product: " + pClient.toString());
            
            serverOut.close();
            serverIn.close();
            conn.close();
        }
        catch (IOException e)
        {
            System.out.println("Fuck");
        }
    }
}
