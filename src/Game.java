/*
 * Goldsmiths University of London
 * Author...: Carlos Manuel de Oliveira Alves
 * Student..: cdeol003
 * Created..: 15/04/2022
 */

/* declare all libraries to be used with this class */
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/* declare and extend the class to include JFrame */
public class Game extends JFrame implements KeyListener{

    /* declare default constructor for this class */
    public Game() {

        /* declare image */
        ImageIcon image = new ImageIcon("wordle.png");

        /* create border for frame */
        Border border = BorderFactory.createLineBorder(Color.GREEN,3);

        /* create label and set the text with position */
        JLabel label = new JLabel();
        label.setText("Please press enter to start the game");
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);

        /* set color, font type and size of the text */
        label.setForeground(Color.GREEN);
        label.setFont(new Font("MV Bold", Font.BOLD,18));
        label.setIconTextGap(20); // set gap of text to image

        /* set and display background color plus border of the label */
        label.setBackground(Color.black);
        label.setOpaque(true);
        label.setBorder(border);

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

        /* add label to the frame */
        frame.add(label);
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

            /* play game */
            new PlayGame();
        }
    }

    @Override
    /* Called whenever a button is released */
    public void keyReleased(KeyEvent e) {

    }
}
