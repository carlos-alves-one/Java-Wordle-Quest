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

    /* declare default constructor for this class */
    NextGame() {

        /* create and setup frame */
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,100);
        this.setLayout(new GridLayout(1,3,10,10));
        this.setTitle("Please press one button");
        this.setResizable(false); // prevents frame from being resized

        /* set up position of the frame at the center of the screen */
        this.setLocationRelativeTo(null);

        /* create radio buttons and add to the frame */
        JButton newGame = new JButton("Start a new game");
        newGame.setFont(new Font("Clear Sans", Font.BOLD, 14));
        newGame.setFocusable(false);
        newGame.setBackground(new Color(245,149,66));

        JButton topGame = new JButton("Top five players");
        topGame.setFont(new Font("Clear Sans", Font.BOLD, 14));
        topGame.setFocusable(false);
        topGame.setBackground(new Color(66,167,245));

        JButton endGame = new JButton("End of game");
        endGame.setFont(new Font("Clear Sans", Font.BOLD, 14));
        endGame.setFocusable(false);
        endGame.setBackground(new Color(149,245,66));
        
        this.add(newGame);
        this.add(topGame);
        this.add(endGame);
        this.setVisible(true);

        /* show to user three options to start a new game, to end or show top five players */
    }

    @Override
    /* method invoked when one of the radio buttons are selected */
    public void actionPerformed(ActionEvent e) {

    }
}
