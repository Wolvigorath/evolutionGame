import java.util.*;

public class Organism
{
    public static String creator ()
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
        String genomString = new String();

        genomString = String.join("",genom);

        System.out.println(genomString);

        return  genomString;


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
}
