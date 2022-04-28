
/*
 * Goldsmiths University of London
 * Author...: Carlos Manuel de Oliveira Alves
 * Student..: cdeol003
 * Created..: 28/04/2022
 */

/* declare package and all libraries to be used with this class */
package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* declare and extend the class to include JFrame and Key Listener */
public class databasePlayers extends JFrame implements ActionListener {

    /* declare frame as global */
    JFrame frame;

    /* declare default constructor for this class */
    databasePlayers() {

        /* create label and set the text with position */
        JLabel labelTitle = new JLabel();
        labelTitle.setText("WORDLE");
        labelTitle.setHorizontalTextPosition(JLabel.CENTER);
        labelTitle.setVerticalTextPosition(JLabel.TOP);

        /* set color, font type and size of the text */
        labelTitle.setForeground(Color.GREEN);
        labelTitle.setFont(new Font("MV Bold", Font.BOLD,36));

        /* set and display background color plus border of the label */
        labelTitle.setBackground(Color.black);
        labelTitle.setOpaque(true);

        
    }


    @Override
    public void actionPerformed(ActionEvent e) {


    }
}
