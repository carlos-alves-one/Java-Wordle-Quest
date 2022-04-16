/*
 * Goldsmiths University of London
 * Author...: Carlos Manuel de Oliveira Alves
 * Student..: cdeol003
 * Created..: 12/04/2022
 */

/* declare all libraries to be used on this class */
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Main extends JPanel {

    static JLabel[][] letterBoxes = new JLabel[6][5];
    static JPanel grid = new JPanel(new GridLayout(6,5,5,5));

    public void paint (Graphics g){
        g.drawRect(150, 235, 150, 150);
    }

    /* pretty colours for the output */
    public static final String TEXT_RED   = "\u001B[31m";
    public static final String TEXT_BLUE  = "\u001B[34m";
    public static final String TEXT_WHITE = "\u001B[0m";
    public static final String TEXT_GREEN = "\u001B[32m";

    //a list of all possible 5-letter words in English
    public static HashSet<String> dictionary = new HashSet<>();

    //a smaller list of words for selecting the target word from (i.e. the word the player needs to guess)
    public static ArrayList<String> targetWords = new ArrayList<>();

    public static void main(String[] args) {

        //load in the two word lists
        try{
            Scanner in_dict  = new Scanner(new File("gameDictionary.txt"));
            while(in_dict.hasNext()){
                dictionary.add(in_dict.next());
            }

            Scanner in_targets = new Scanner(new File("targetWords.txt"));
            while(in_targets.hasNext()){
                targetWords.add(in_targets.next());
            }
            in_dict.close();
            in_targets.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        /* starting code from here... */

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
        String wordle = getTarget();

        /* run game */
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

    /*  */
    static void styleGrid() {
        Dimension size = new Dimension(250, 200);
        grid.setMaximumSize(size);
        grid.setPreferredSize(size);
        grid.setBackground(Color.BLACK);
    }

    public static void update(int i ,int j, String letter) {
        System.out.println("in update");
        if(j < 5 && i < 6 && j >= 0 && i >= 0)
            letterBoxes[i][j].setText(letter);
    }

    public static void addLabels() {
        for(int i = 0; i < 6; i++)
            for(int j = 0; j < 5; j++) {
                JLabel label = new JLabel();
                label.setOpaque(true);
                label.setBackground(Color.gray);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                grid.add(letterBoxes[i][j] = label);
            }
    }
}

