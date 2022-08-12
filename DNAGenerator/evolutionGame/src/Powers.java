import java.util.ArrayList;
import java.util.Random;

public class Powers
{
    public static ArrayList <String> checkPowers (ArrayList <String> cataclysm)
    {
        int size = cataclysm.size();
        ArrayList <String> neededPowers = new ArrayList<String>();
        ArrayList <String> neededGenes = new ArrayList<String>();
        for (int i= 0; i<size; i++)
        {
            String tempString = cataclysm.get(i);

            switch (tempString)
            {
                case "ABCD":
                    neededPowers.add("Strength");
                    neededGenes.add("ABCD");
                    break;

                case "ACBD":
                    neededPowers.add("Speed");
                    neededGenes.add("ACBD");
                    break;

                case "ACDB":
                    neededPowers.add("Flying");
                    neededGenes.add("ACDB");
                    break;

                case "ADBC":
                    neededPowers.add("Armor");
                    neededGenes.add("ADBC");
                    break;

                case "ADCB":
                    neededPowers.add("Hearing");
                    neededGenes.add("ADCB");
                    break;

                case "BACD":
                    neededPowers.add("Smell");
                    neededGenes.add("BACD");
                    break;

                case "BADC":
                    neededPowers.add("Sight");
                    neededGenes.add("BADC");
                    break;

                case "BDAC":
                    neededPowers.add("Swimming");
                    neededGenes.add("BDAC");
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

        return neededGenes;


    }

    public static ArrayList <String> makeCataclysm ()
    {
        ArrayList <String> Cataclysm = new ArrayList<String>();
        ArrayList <String> Permutations = new ArrayList<String>();

        ReadUp tempPermutations = new ReadUp();
        Permutations = tempPermutations.readFromFile ("src/genom.txt");

        Random rand1 = new Random();
        int r = 0;

        for (int i = 0; i<3; i++)
        {
            r = rand1.nextInt(20-1);
            String tempGene = Permutations.get(r);
            Cataclysm.add(tempGene);
        }
        return Cataclysm;
    }

    public static boolean comparePowers (ArrayList <String> organism, ArrayList<String> cataclysm)
    {
        boolean isThere;
        boolean isOk = true;

        int size = organism.size();
        int size2 = cataclysm.size();

        for (int i = 0; i<size2; i++)
        {
            isThere=false;
            for (int g =0; g<size; g++)
            {
                if (organism.get(g).equals(cataclysm.get(i)))
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

    public static void checkPowersAndPrint (ArrayList <String> organismToCheck)
    {
        int size = organismToCheck.size();

        for (int i = 0; i < size; i++)
        {
            String tempString = organismToCheck.get(i);

            switch (tempString) {
                case "ABCD":
                    System.out.println("Strength");

                    break;

                case "ACBD":
                    System.out.println("Speed");

                    break;

                case "ACDB":
                    System.out.println("Flying");

                    break;

                case "ADBC":
                    System.out.println("Armor");

                    break;

                case "ADCB":
                    System.out.println("Hearing");

                    break;

                case "BACD":
                    System.out.println("Smell");

                    break;

                case "BADC":
                    System.out.println("Sight");

                    break;

                case "BDAC":
                    System.out.println("Swimming");

                    break;

                default:
                    break;

            }

        }
    }
}
