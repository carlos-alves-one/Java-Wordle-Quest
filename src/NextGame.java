/*
 * Goldsmiths University of London
 * Author...: Carlos Manuel de Oliveira Alves
 * Student..: cdeol003
 * Created..: 23/04/2022
 */

/* declare all libraries to be used with this class */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

/* declare and extend the class to include JFrame and Key Listener */
public class NextGame extends JFrame implements ActionListener{

    /* declare frame as global */
    JFrame frame;

    /* declare default constructor for this class */
    NextGame() {

        /* create radio buttons and add to the frame */
        JRadioButton newGame = new JRadioButton("Start a new game");
        JRadioButton topGame = new JRadioButton("Top five players");
        JRadioButton endGame = new JRadioButton("End of game");
        frame.add(newGame);
        frame.add(topGame);
        frame.add(endGame);

        /* show to user three options to start a new game, to end or show top five players */
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
