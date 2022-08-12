import java.util.ArrayList;
import java.util.Scanner;

public class Levels

{
    public static void levels (ArrayList<String> organism)
    {
        int numberOfLevel = 1;
        int numberOfLevelsAtAll = 15;
        ArrayList <String> catastrophe = new ArrayList<String>();
        Scanner input = new Scanner(System.in);
        String nextLine;

        ArrayList <String> madeMate = new ArrayList<String>();
        Organism createMate = new Organism();
        Levels greatMutator = new Levels();
        for (int i =0; i<numberOfLevelsAtAll; i++)
        {   int doNoth = 3;
            int mateMax = 0;
            catastrophe = Powers.makeCataclysm();
            ArrayList <String> youNeed = new ArrayList<String>();
            System.out.println("You need: ");
            youNeed =  Powers.checkPowers(catastrophe);
            System.out.println("It's level: " + numberOfLevel);
           for (int g=0; g<(numberOfLevelsAtAll-i); g++)
           {
               System.out.println("Do You want to mutate (1), mate (2), do nothing (3), print " +
                       "numbers and genes of powers (4) or show Your powers (5)?");
               nextLine = input.nextLine();

               switch (nextLine)
               {
                   case "1":
                   {
                       organism = greatMutator.mutateAndBack(organism);
                       break;
                   }

                   case "2":
                   {
                       if (mateMax<numberOfLevelsAtAll-i-3)
                       {
                           madeMate = createMate.makeMate (organism);
                           organism = createMate.mate (organism, madeMate);
                           System.out.println("You have: ");
                           try
                           {
                               Powers.checkPowersAndPrint (organism);
                               System.out.println("You have these genes: " +  organism);
                           }
                           catch (Exception e)
                           {

                           }
                           mateMax++;
                           System.out.println("You have: " + (numberOfLevelsAtAll-i-mateMax) + " left to spend");
                       }
                       else
                       {
                           System.out.println("You have used all Your mates on this level");
                           g--;
                       }

                       break;
                   }

                   case "3":
                   {
                       if (doNoth>0)
                       {
                           doNoth--;
                       }
                       else
                       {
                           System.out.println("You can't wait anymore - mate or mutate");
                           g--;
                       }
                       break;
                   }
                   case "4":
                   {
                       Manual.abilities();
                       g--;
                       break;
                   }

                   case "5":
                   {
                       Powers.checkPowersAndPrint(organism);
                       g--;
                       break;
                   }
                   default:
                   {
                       System.out.println("Wrong instruction");
                       g--;
                       break;
                   }

               }
               System.out.println("Number of operations left: " + (numberOfLevelsAtAll-i-g-1));

           }

            numberOfLevel++;

            Powers survival = new Powers();
            boolean didSurvive = survival.comparePowers (organism, youNeed);
            if (didSurvive == false)
            {
                break;
            }
        }


    }

    public static ArrayList <String> mutateAndBack (ArrayList <String> genomToMutate)
    {
        //ArrayList<String> yourGenomList = new ArrayList<String>();
        //yourGenomList =  yourOrganism.toList(genomToMutate);
        Organism yourOrganism = new Organism();

        System.out.println("You had these genes: " + genomToMutate);
        String genomString = new String();
        genomString = String.join("",genomToMutate);
        genomToMutate = yourOrganism.toList (genomString);
        genomToMutate = yourOrganism.mutate (genomToMutate);
        int gtmSize = genomToMutate.size();
        for (int i = 0; i<gtmSize-1; i++)
        {   String letter = new String();
            letter = genomToMutate.get(i);
            if (letter.equals("A") || letter.equals("B") || letter.equals("C") || letter.equals("D"))
            {

            }
            else
            {
                genomToMutate.remove(i);
                i--;
            }

            gtmSize=genomToMutate.size();
        }

        ArrayList <ArrayList<String>> genesSequnces = new ArrayList<ArrayList<String>>();
        genesSequnces =  yourOrganism.sequences(genomToMutate);
        ArrayList <String> genesStringed = yourOrganism.toStrings(genesSequnces);
        System.out.println("You have these genes: " +  genesStringed);
        System.out.println("You have these powers: ");
        Powers.checkPowersAndPrint(genesStringed);
        return genesStringed;
    }
}
