import java.io.PipedOutputStream;
import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;

public class Main
{
    public static void main (String [] args)
    {
        ArrayList <String> permutations = new ArrayList<String>();
        ReadUp reader = new ReadUp();
        permutations = reader.readFromFile("src/genom.txt");

        Manual manual = new Manual();
        manual.prolog ();
        Organism yourOrganism = new Organism();
        String yourGenom = yourOrganism.creator ();
        ArrayList<String> yourGenomList = new ArrayList<String>();
        yourGenomList =  yourOrganism.toList(yourGenom);
        for (int i=0; i<10; i++)
        {
            yourGenomList = yourOrganism.mutate (yourGenomList);
        }
        System.out.println(yourGenomList);
        ArrayList<String[]> genesSequnces = new ArrayList<String[]>();
        genesSequnces =  yourOrganism.sequences(yourGenomList);
        ArrayList <String> genesStringed = yourOrganism.toStrings(genesSequnces);
        ArrayList <String> catastrophe = new ArrayList<String>();
        catastrophe = Powers.makeCataclysm();
        ArrayList <String> youNeed = new ArrayList<String>();
        youNeed =  Powers.checkPowers(catastrophe);
        ArrayList <String> madeMate = new ArrayList<String>();
        Organism createMate = new Organism();
        for (int i=0; i<3; i++)
        {
            madeMate = createMate.makeMate (genesStringed);
            genesStringed = createMate.mate (genesStringed, madeMate);
        }

        Powers survival = new Powers();
        boolean didSurvive = survival.comparePowers (genesStringed, youNeed);
    }
}
