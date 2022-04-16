/*
 * Goldsmiths University of London
 * Author...: Carlos Manuel de Oliveira Alves
 * Student..: cdeol003
 * Created..: 16/04/2022
 */

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/* declare and extend the class to include JFrame and Key Listener */
public class PlayGame extends JFrame implements KeyListener {

    /* declare default constructor for this class */
    PlayGame() {

        /* create and setup frame */
        JFrame frame = new JFrame();
        frame.setTitle("## WORDLE GAME - WELCOME ##");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); // prevents frame from being resized
        frame.setSize(469,500);
        frame.addKeyListener(this);
        frame.setVisible(true);

        /* set up position of the frame at the center of the screen */
        frame.setLocationRelativeTo(null);
    }

    @Override
    /* method invoked when a key is typed. Uses keyChar, char output */
    public void keyTyped(KeyEvent e) {

    }

    @Override
    /* method invoked when a physical key is pressed down. Uses KeyCode, int output */
    public void keyPressed(KeyEvent e) {

        /* enter key pressed ** it will play the game */
        if (e.getKeyCode() == 10) {

            // TODO...
        }
    }

    @Override
    /* method called whenever a button is released */
    public void keyReleased(KeyEvent e) {

    }
}
