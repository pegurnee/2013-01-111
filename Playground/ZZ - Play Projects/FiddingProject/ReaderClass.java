import java.io.*;
import java.util.Scanner; 

public class ReaderClass
{
    public static void main(String[] args)
    {

        InputStream stream = ReaderClass.class.getResourceAsStream("Test.txt");        
        Scanner inLoad = new Scanner(stream);
        System.out.println(inLoad.nextLine());
        System.out.println(inLoad.nextLine());
        System.out.println(inLoad.nextLine());
        System.out.println(inLoad.nextLine());
        System.out.println(inLoad.nextLine());
        System.out.println(inLoad.nextLine());
            //         stream = ReaderClass.class.getClassLoader().getResourceAsStream("Test.txt");
            //         System.out.println(stream != null);

    }
}
