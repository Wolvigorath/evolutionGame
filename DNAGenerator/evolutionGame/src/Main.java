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
        for (int i=0; i<4; i++)
        {
            yourGenomList = yourOrganism.mutate (yourGenomList);
        }
        System.out.println(yourGenomList);

    }
}
