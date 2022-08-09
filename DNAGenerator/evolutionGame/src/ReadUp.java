import java.io.File;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadUp
{
    public static ArrayList<String> readFromFile (String filePath)
    {
        ArrayList <String> permutations = new ArrayList<String>();

        try (Scanner inFile1 = new Scanner(new File(filePath)))
        {

            while (inFile1.hasNext())
            {
                String temp = new String();
                temp = inFile1.next();
                permutations.add(temp);

            }
            inFile1.close();

        }
        catch (Exception e)
        {
            System.out.println("Empty file or some other shieet");
        }
     return permutations;
    }
}
