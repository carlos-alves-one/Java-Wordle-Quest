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

/* declare and extend the class to include JFrame and Key Listener */
public class NextGame extends JFrame implements ActionListener{

    /* declare buttons global */
    JButton newGame;
    JButton topGame;
    JButton endGame;

    /* declare default constructor for this class */
    NextGame() {

        /* create and setup frame */
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setSize(500,100);
        this.setLayout(new GridLayout(1,3,10,10));
        this.setTitle("Please press one button");
        this.setResizable(false); // prevents frame from being resized

        /* set up position of the frame at the center of the screen */
        this.setLocationRelativeTo(null);

        /* create radio buttons and add to the frame */
        newGame = new JButton("Start a new game");
        newGame.setFont(new Font("Clear Sans", Font.BOLD, 14));
        newGame.setFocusable(false);
        newGame.setBackground(new Color(245,149,66));
        newGame.addActionListener(this);

        topGame = new JButton("Top five players");
        topGame.setFont(new Font("Clear Sans", Font.BOLD, 14));
        topGame.setFocusable(false);
        topGame.setBackground(new Color(66,167,245));
        topGame.addActionListener(this);

        endGame = new JButton("End of game");
        endGame.setFont(new Font("Clear Sans", Font.BOLD, 14));
        endGame.setFocusable(false);
        endGame.setBackground(new Color(149,245,66));
        endGame.addActionListener(this);

        this.add(newGame);
        this.add(topGame);
        this.add(endGame);
        this.setVisible(true);

        /* show to user three options to start a new game, to end or show top five players */
    }

    @Override
    /* method invoked when one of the radio buttons are selected */
    public void actionPerformed(ActionEvent e) {

        /* check we press the end game button */
        if (e.getSource() == endGame) {
            System.exit(0);
        }
    }
}
