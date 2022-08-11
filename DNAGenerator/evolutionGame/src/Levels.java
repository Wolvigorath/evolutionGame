import java.util.ArrayList;

public class Levels

{
    public static void levels (ArrayList<String> organism)
    {
        int numberOfLevel = 1;
        int numberOfLevelsAtAll = 15;
        ArrayList <String> catastrophe = new ArrayList<String>();

        ArrayList <String> madeMate = new ArrayList<String>();
        Organism createMate = new Organism();
        for (int i =0; i<numberOfLevelsAtAll; i++)
        {
            catastrophe = Powers.makeCataclysm();
            ArrayList <String> youNeed = new ArrayList<String>();
            youNeed =  Powers.checkPowers(catastrophe);
            System.out.println("It's level: " + numberOfLevel);
           for (int g=0; g<(numberOfLevelsAtAll-i); g++)
           {
               madeMate = createMate.makeMate (organism);
               organism = createMate.mate (organism, madeMate);
               System.out.println("You have: ");
               try
               {
                   Powers.checkPowersAndPrint (organism);
               }
               catch (Exception e)
               {

               }
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
}
