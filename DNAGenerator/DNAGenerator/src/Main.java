import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main
{
    public static void main (String [] args) throws IOException {
        Scanner input = new Scanner (in);
        System.out.println ("Podaj ciąg znaków do permutacji");
        String stringOfDNA = input.nextLine ();

        Set <String> genesPermutations = new HashSet<String>();

        permutation newGenom = new permutation();
        genesPermutations = newGenom.getPermutation (stringOfDNA);
        System.out.println("Your genom: " + genesPermutations);
        writeDown toFile = new writeDown();
        writeDown.toTheFile(genesPermutations, "genom.txt");
    }


}
