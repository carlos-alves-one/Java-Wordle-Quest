/*
 * Goldsmiths University of London
 * Author...: Carlos Manuel de Oliveira Alves
 * Student..: cdeol003
 * Created..: 15/04/2022
 */

/* declare all libraries to be used on this class */
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.*;
import java.lang.NumberFormatException;
import java.text.DecimalFormat;


/* declare and extend the class to include JFrame */
public class Game {

    public static void main(String[] args) {

        /* declare image */
        ImageIcon image = new ImageIcon("wordle.png");

        /* create label and set the text with position */
        JLabel label = new JLabel();
        label.setText("Please press enter to start the game");
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);

        /* set color, font type and size of the text */
        label.setForeground(Color.GREEN);
        label.setFont(new Font("MV Boli", Font.BOLD,18));
        label.setIconTextGap(20); // set gap of text to image

        /* set background color of the label */
        label.setBackground(Color.black);
        label.setOpaque(true);

        /* create and setup frame */
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(469,500);
        frame.setVisible(true);

        /* set up position of the frame at the center of the screen */
        frame.setLocationRelativeTo(null);

        /* add label to the frame */
        frame.add(label);
    }
}
