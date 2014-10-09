import java.io.*;
import java.net.*;
/**
 * Write a description of class MainServerClass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainServerClass
{
    public static void main(String[] args)
    {
        try 
        {
            int port = 25565;
            
            System.out.println("Waiting for connection on port " + port);
            
            ServerSocket servConn = new ServerSocket(port);
            Socket conn = servConn.accept();
            
            BufferedReader clientIn = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            DataOutputStream clientOut = new DataOutputStream(conn.getOutputStream());
            
            System.out.println("Connection, waiting for client...");
            String ctext = clientIn.readLine();
            String rtext = "Thank you " + ctext + ".";
            clientOut.writeBytes(rtext + "\n");
            System.out.println("Data sent: " + rtext);
            
            Product pServer = new Product();
            System.out.println("Current product: " + pServer.toString());
            System.out.println("Connection, waiting for product...");
            pServer = new Product(Integer.parseInt(clientIn.readLine().trim()), clientIn.readLine().trim(), 
                    Double.parseDouble(clientIn.readLine().trim()), Boolean.parseBoolean(clientIn.readLine().trim()),
                    Integer.parseInt(clientIn.readLine().trim()), Integer.parseInt(clientIn.readLine().trim()));
            System.out.println("Updated product: " + pServer.toString());
            
            pServer.setItemDescription("Hat");            
            System.out.println("Changing product title to " + pServer.getItemDescription());
            clientOut.writeBytes(pServer.getItemDescription() + "\n");
            
            clientIn.close();
            clientOut.close();
            conn.close();
            servConn.close();
        }
        catch (IOException e)
        {
            System.out.println("Fuck");
        }
    }
}
