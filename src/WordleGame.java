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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/* declare and extend the class to include JFrame */
public class WordleGame extends JFrame {

    static class WordPanel extends JPanel {

        /* declare an array of 5 labels to display each letter of the word */
        JLabel[] wordColumns = new JLabel[5];

        /* declare default constructor */
        public WordPanel() {

            /* declare the layout for the panel with one row and five columns */
            this.setLayout(new GridLayout(1,5));

            /* for loop to initialize each individual labels inside the array */
            for (int i = 0; i < 5; i++) {
                wordColumns[i] = new JLabel();

                /* set the opacity of the label */
                wordColumns[i].setOpaque(true);

                /* each of five labels boxes will be added in a single row */
                this.add(wordColumns[i]);
            }
        }
    }

}
