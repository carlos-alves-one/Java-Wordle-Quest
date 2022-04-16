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

        System.out.println("Play game...");
    }

    @Override
    /* Invoked when a key is typed. Uses keyChar, char output */
    public void keyTyped(KeyEvent e) {

    }

    @Override
    /* Invoked when a physical key is pressed down. Uses KeyCode, int output */
    public void keyPressed(KeyEvent e) {

        /* enter key pressed ** it will play the game */
        if (e.getKeyCode() == 10) {

            // TODO...
        }
    }

    @Override
    /* Called whenever a button is released */
    public void keyReleased(KeyEvent e) {

    }
}
