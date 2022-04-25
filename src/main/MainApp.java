
/*
 * Goldsmiths University of London
 * Author...: Carlos Manuel de Oliveira Alves
 * Student..: cdeol003
 * Created..: 12/04/2022
 */

/* declare package and all libraries to be used on this class */
package main;
import game.Game;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class MainApp extends JPanel {

    /* pretty colours for the output */
    public static final String TEXT_BLUE  = "\u001B[34m";
    public static final String TEXT_GREEN = "\u001B[32m";

    /* declare the word target */
    public static String wordle;

    // a list of all possible 5-letter words in English
    public static HashSet<String> dictionary = new HashSet<>();

    // a smaller list of words for selecting the target word from (i.e. the word the player needs to guess)
    public static ArrayList<String> targetWords = new ArrayList<>();

    /* main method of the app */
    public static void main(String[] args) {

        // load in the two word lists
        try{
            Scanner in_dict  = new Scanner(new File("src/files/gameDictionary.txt"));
            while(in_dict.hasNext()){
                dictionary.add(in_dict.next());
            }

            Scanner in_targets = new Scanner(new File("src/files/targetWords.txt"));
            while(in_targets.hasNext()){
                targetWords.add(in_targets.next());
            }
            in_dict.close();
            in_targets.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        /* print the word wordle in the console */
        System.out.print(TEXT_GREEN);
        System.out.println("""
                
                ██╗    ██╗ ██████╗ ██████╗ ██████╗ ██╗     ███████╗
                ██║    ██║██╔═══██╗██╔══██╗██╔══██╗██║     ██╔════╝
                ██║ █╗ ██║██║   ██║██████╔╝██║  ██║██║     █████╗
                ██║███╗██║██║   ██║██╔══██╗██║  ██║██║     ██╔══╝
                ╚███╔███╔╝╚██████╔╝██║  ██║██████╔╝███████╗███████╗
                 ╚══╝╚══╝  ╚═════╝ ╚═╝  ╚═╝╚═════╝ ╚══════╝╚══════╝
                """);
        System.out.print(TEXT_BLUE);

        /* print the word in the console we are looking for */
        wordle = getTarget();

        new Game();
    }

    // use this method for selecting a word. It's important for marking that the word you have selected
    // is printed out to the console!
    public static String getTarget(){
        Random r = new Random();
        String target = targetWords.get(r.nextInt(targetWords.size()));
        //don't delete this line.
        System.out.println("** The word we are looking for -->> " + target);
        return target;
    }
}

