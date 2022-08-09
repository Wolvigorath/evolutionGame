import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.FileHandler;

public class writeDown
{
    public static void toTheFile (Set <String> permutations1, String filePath) throws IOException
    {
        ArrayList <String> permutations = new ArrayList <String>();
        for (String value : permutations1)
        {
            permutations.add(value);

        }
        File file1 = new File(filePath);
        file1.delete();
        FileWriter fw = new FileWriter(filePath, true);
        try
        {
            for (int i = 0 ; i < permutations.size(); i++)
            fw.append(permutations.get(i) + "\n");

                    }
        catch (Exception e)
        {
            System.out.println("Się zesrało");
        } finally
        {

            fw.close();
        }

    }
}
