
/*
 * Goldsmiths University of London
 * Author...: Carlos Manuel de Oliveira Alves
 * Student..: cdeol003
 * Created..: 23/04/2022
 */

/* declare package, libraries and variables to be used with this class */
package game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static game.PlayGame.namePlayer;
import static game.PlayGame.playerScore;
import static main.MainApp.dataGame;

/* declare and extend the class to include JFrame and Key Listener */
public class MenuGame extends JFrame implements ActionListener{

    /* declare buttons global */
    JButton topGame;
    JButton endGame;

    /* declare default constructor for this class */
    MenuGame() {

        /* create and setup frame */
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,70);
        this.setLayout(new GridLayout(1,3,10,10));
        this.setTitle(">> Press one button");
        this.setResizable(false); // prevents frame from being resized

        /* set up position of the frame at the center of the screen */
        this.setLocationRelativeTo(null);

        /* create buttons and add to the frame */

        topGame = new JButton("Top Players");
        topGame.setFont(new Font("Clear Sans", Font.BOLD, 14));
        topGame.setFocusable(false);
        topGame.setBackground(new Color(66,167,245));
        topGame.addActionListener(this);

        endGame = new JButton("End of game.Game");
        endGame.setFont(new Font("Clear Sans", Font.BOLD, 14));
        endGame.setFocusable(false);
        endGame.setBackground(new Color(149,245,66));
        endGame.addActionListener(this);

        this.add(topGame);
        this.add(endGame);
        this.setVisible(true);
    }

    @Override
    /* method invoked when one of the radio buttons are selected */
    public void actionPerformed(ActionEvent e) {

        /* check we press the end game button */
        if (e.getSource() == endGame) {
            System.exit(0);
        }

        /* check we press the top players button */
        if (e.getSource() == topGame) {
            new TopPlayers(namePlayer, playerScore, dataGame);
        }
    }
}
