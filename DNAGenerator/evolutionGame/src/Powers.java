import java.util.ArrayList;
import java.util.Random;

public class Powers
{
    public static ArrayList <String> checkPowers (ArrayList <String> cataclysm)
    {
        int size = cataclysm.size();
        ArrayList <String> neededPowers = new ArrayList<String>();
        for (int i= 0; i<size; i++)
        {
            String tempString = cataclysm.get(i);

            switch (tempString)
            {
                case "ABCD":
                    neededPowers.add("Strength");
                    break;

                case "ACBD":
                    neededPowers.add("Speed");
                    break;

                case "ACDB":
                    neededPowers.add("Flying");
                    break;

                case "ADBC":
                    neededPowers.add("Armor");
                    break;

                case "ADCB":
                    neededPowers.add("Hearing");
                    break;

                case "BACD":
                    neededPowers.add("Smell");
                    break;

                case "BADC":
                    neededPowers.add("Sight");
                    break;

                case "BDAC":
                    neededPowers.add("Swimming");
                    break;

                default:
                    break;

            }


        }

        if (neededPowers == null)
        {
            System.out.println("You don't need any powers this time");
        }
        else
        {
            System.out.println(neededPowers);
        }

        return neededPowers;


    }

    public static ArrayList <String> makeCataclysm ()
    {
        ArrayList <String> Cataclysm = new ArrayList<String>();
        ArrayList <String> Permutations = new ArrayList<String>();

        ReadUp tempPermutations = new ReadUp();
        Permutations = tempPermutations.readFromFile ("src/genom.txt");

        Random rand1 = new Random();
        int r = 0;

        for (int i = 0; i<6; i++)
        {
            r = rand1.nextInt(20-1);
            String tempGene = Permutations.get(r);
            Cataclysm.add(tempGene);
        }
        return Cataclysm;
    }

    public static boolean comparePowers (ArrayList <String> organism, ArrayList<String> cataclysm)
    {
        boolean isThere = false;
        boolean isOk = true;

        int size = organism.size();
        int size2 = cataclysm.size();

        for (int i = 0; i<size2; i++)
        {
            for (int g =0; g<size; g++)
            {
                if (organism.get(g)==cataclysm.get(i))
                {
                    isThere = true;
                }
            }
            if (isThere!=true)
            {
                isOk = false;
            }
        }
        if (isOk == true)
        {
            System.out.println("You survived");
        }
        else
        {
            System.out.println("You died");
        }
        return isOk;
    }
}
