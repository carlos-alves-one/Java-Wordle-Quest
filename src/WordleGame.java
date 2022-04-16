/*
 * Goldsmiths University of London
 * Author...: Carlos Manuel de Oliveira Alves
 * Student..: cdeol003
 * Created..: 12/04/2022
 */

/* declare all libraries to be used on this class */
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/* declare and extend the class to include JFrame */
public class WordleGame extends JFrame {

    /* declare class to display words on the panel */
    static class WordPanel extends JPanel {

        /* declare an array of 5 labels to display each letter of the word */
        JLabel[] wordLetters = new JLabel[5];

        /* declare default constructor */
        public WordPanel() {

            /* declare the layout for the panel with one row and five columns */
            this.setLayout(new GridLayout(1,5));

            /* declare variable to use the border factory to create an instance */
            Border borderColor = BorderFactory.createLineBorder(Color.LIGHT_GRAY);

            /* for loop to initialize each individual labels inside the array */
            for (int i = 0; i < 5; i++) {
                wordLetters[i] = new JLabel();

                /* set the opacity of the label */
                wordLetters[i].setOpaque(true);

                /* add the border color of the label */
                wordLetters[i].setBorder(borderColor);

                /* each of five labels boxes will be added in a single row */
                this.add(wordLetters[i]);
            }
        }

        /* declare method to set up value inside this panel */
        public  void setPanelText(String charVal, Color color, int index) {

            /* call array using the index (position) to set up the background color and character value */
            this.wordLetters[index].setBackground(color);
            this.wordLetters[index].setText(charVal);
        }
    }

    /* declare class to accept the user inputs */
    static class UserPanel extends JPanel {

        /* instantiate the text field and enter button */
        private final JTextField userData;
        private final JButton enterButton;

        /* declare default constructor */
        public UserPanel() {

            /* setup layout for text and the button with one row and two columns */
            this.setLayout(new GridLayout(1, 2));

            /* initialize the text and the button */
            userData = new JTextField();
            enterButton = new JButton("ENTER");
        }

        /* declare getters */
        public JTextField getUserData() {return userData;}
        public JButton getEnterButton() {return enterButton;}


    }

    /* define JFrame which hold the entire game */
    private JFrame wordleGameFrame;

    /* declare an array of six word panels  */
    private final WordPanel[] wordArrayPanel = new WordPanel[6];

    /* declare the user panel */
    private UserPanel userPanel;

    /* declare the word we're going to look forward */
    private String wordle;

    /* declare a counter to indicate the position in the word panel array */
    private int counter = 0;

    /* declare default constructor of the class */
    public WordleGame() {

        /* initialize the components */
        wordleGameFrame = new JFrame("** Wordle Game"); // pass the game heading
        wordleGameFrame.setSize(320,320); // set the size of the frame

        /* allows the user to stop and close the game */
        wordleGameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        /* set up layout of the frame with rows and columns */
        wordleGameFrame.setLayout(new GridLayout(7,1));
        wordleGameFrame.setVisible(true); // enable the frame be visible

        /* set up position of the frame at the center of the screen */
        wordleGameFrame.setLocationRelativeTo(null);

        /* initialize the six individuals word array panels */
        for (int i = 0; i < 6; i++) {
            wordArrayPanel[i] = new WordPanel();
            wordleGameFrame.add(wordArrayPanel[i]);
        }

        /* initialize and add user panel */
        userPanel = new UserPanel();
        wordleGameFrame.add(userPanel);
        wordleGameFrame.revalidate();
    }

}
