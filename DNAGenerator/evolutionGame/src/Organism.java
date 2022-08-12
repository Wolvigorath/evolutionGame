import java.sql.Array;
import java.util.*;

public class Organism
{
    public static ArrayList <String> creator ()
    {
        Scanner input = new Scanner(System.in);
        String nextLine;
        ArrayList <String> genom = new ArrayList<String>();
        for (int i = 0; i <6; i++)
        {
            Manual powers = new Manual();
            powers.abilities ();
            System.out.println("Choose number of ability");
            nextLine = input.nextLine();

            switch (nextLine)
            {
                case "1":
                    genom.add("ABCD");
                    break;

                case "2":
                    genom.add("ACBD");
                    break;

                case "3":
                    genom.add("ACDB");
                    break;

                case "4":
                    genom.add("ADBC");
                    break;

                case "5":
                    genom.add("ADCB");
                    break;

                case "6":
                    genom.add("BACD");
                    break;

                case "7":
                    genom.add("BADC");
                    break;

                case "8":
                    genom.add("BDAC");
                    break;

                default:
                    System.out.println("Wrong instruction");


            }

        }
       // String genomString = new String();

        //genomString = String.join("",genom);

        //System.out.println(genomString);

        return  genom;


    }

    public static ArrayList<String> toList (String genomStr)
    {
        //LinkedList<String> genomList ;

       ArrayList <String> genomList = new ArrayList<>(Arrays.asList((genomStr.split(""))));

        return genomList;
    }

    public static ArrayList<String> mutate (ArrayList<String> genomToMutate)
    {
        int s = genomToMutate.size();
        Random rand = new Random();
        Random rand2 = new Random();

        int whichM = rand.nextInt(3);
        int whichChar = rand2.nextInt (s);
        switch (whichM)
        {
            case 0:
                //Minus char in genom
                genomToMutate.remove(whichChar);
                break;

            case 1:
                //plus char
                Random randLetter = new Random();
                String newChar = "o";
                int whichLetter = randLetter.nextInt(4);

                switch (whichLetter)
                {
                    case 0:
                        newChar = "A";
                        break;

                    case 1:
                        newChar = "B";
                        break;

                    case 2:
                        newChar = "C";
                        break;

                    case 3:
                        newChar = "D";
                        break;

                    default:
                        break;
                }
                genomToMutate.add(whichChar, newChar);
                break;

            case 2:
                //Change letter
                Random randLetter2 = new Random();
                String newChar2 = "o";
                int whichLetter2 = randLetter2.nextInt(4);

                switch (whichLetter2)
                {
                    case 0:
                        newChar2 = "A";
                        break;

                    case 1:
                        newChar2 = "B";
                        break;

                    case 2:
                        newChar2 = "C";
                        break;

                    case 3:
                        newChar2 = "D";
                        break;

                    default:
                        break;
                }
                genomToMutate.set(whichChar, newChar2);
                break;

        }

        return genomToMutate;
    }


    public  static ArrayList <ArrayList<String>> sequences (ArrayList <String> genomToSequent)
    {
        int i = genomToSequent.size();
        int divide = i/4;
        int a = i%4;
        if (a>0)
        {
            divide++;
        }
        ArrayList <ArrayList<String>> sequent = new ArrayList<ArrayList<String>>();
        int z=0;
        while (z<i)
        {
            //String [] temp = new String[4];
            ArrayList <String> temp = new ArrayList<String>();
            for (int d=0; d<4; d++)
            {
                if (z<i)
                {
                    if (genomToSequent.get(z)!= null)
                    {
                        temp.add(genomToSequent.get(z));
                        z++;
                    }
                }

            }

            sequent.add(temp);
        }
        return  sequent;
    }

    public static ArrayList <String> toStrings (ArrayList <ArrayList<String>> genomToStrings)
    {
        int size = genomToStrings.size();
        ArrayList <String> stringed = new ArrayList<String>();

        for (int i = 0; i<size ; i++)
        {
            //String tempString = Arrays.toString(genomToStrings.get(i)) ;
            StringBuffer stringBuffer = new StringBuffer();
            for (String element : genomToStrings.get(i))
            {
                stringBuffer.append(element);
            }
            String result = stringBuffer.toString();
            stringed.add(result);
        }

        return stringed;
    }

    public static ArrayList <String> makeMate (ArrayList <String> existingMate)
    {
        int size = existingMate.size();

        ArrayList <String> newMate = new ArrayList<String>();
        ArrayList <String> Permutations = new ArrayList<String>();

        ReadUp tempPermutations = new ReadUp();
        Permutations = tempPermutations.readFromFile ("src/genom.txt");

        Random rand1 = new Random();
        int r = 0;

        for (int i = 0; i<size; i++)
        {
            r = rand1.nextInt(20-1);
            String tempGene = Permutations.get(r);
            newMate.add(tempGene);
        }
        Scanner input = new Scanner(System.in);
        String nextLine;

        System.out.println("Choose number of ability");
        nextLine = input.nextLine();
        String power;
        power = null;
        switch (nextLine)
        {
            case "1":
                power = "ABCD";
                break;

            case "2":
                power =("ACBD");
                break;

            case "3":
                power =("ACDB");
                break;

            case "4":
                power =("ADBC");
                break;

            case "5":
                power =("ADCB");
                break;

            case "6":
                power =("BACD");
                break;

            case "7":
                power =("BADC");
                break;

            case "8":
                power =("BDAC");
                break;

            default:
                System.out.println("Wrong instruction");


        }
        Random rand2 = new Random();
        int g = rand2.nextInt(size-1);
        newMate.set(g, power);

        return newMate;
    }

    public static ArrayList <String> mate (ArrayList <String> existingMate, ArrayList <String> madeMate)
    {
        int size = existingMate.size();
        int genesToCross= size/2;

        Random rand1 = new Random();
        ArrayList <Integer> choosed = new ArrayList<Integer>();
        ArrayList <String> genesChoosed = new ArrayList<String>();
        while (choosed.size()<genesToCross)
        {
            int randTemp = rand1.nextInt(size-1);
            boolean check = false;
            for (int i=0; i< choosed.size(); i++)
            {
                if (randTemp == choosed.get(i))
                {
                    check = true;
                }
            }
            if (check == false)
            {
                String stringTemp = madeMate.get(randTemp);
                genesChoosed.add(stringTemp);
                choosed.add(randTemp);
            }

        }

        for (int g = 0; g<genesChoosed.size(); )
        {
            Random randomTemp2 = new Random();
            int check2 = randomTemp2.nextInt(genesChoosed.size());
            String stringTemp2 = genesChoosed.get(check2);
            genesChoosed.remove(check2);

            Random randomTemp3 = new Random();
            int place = randomTemp3.nextInt(existingMate.size()-1);
            existingMate.set(place, stringTemp2);

        }
        return existingMate;
    }
}
