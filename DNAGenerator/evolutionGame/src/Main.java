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
        ArrayList <String> yourGenomList = yourOrganism.creator ();

        Levels Mutator = new Levels();
        //ArrayList <String> genesStringed = Mutator.mutateAndBack(yourGenomList);


        Levels.levels(yourGenomList);
    }
}
