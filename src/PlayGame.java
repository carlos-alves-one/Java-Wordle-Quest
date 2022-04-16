/*
 * Goldsmiths University of London
 * Author...: Carlos Manuel de Oliveira Alves
 * Student..: cdeol003
 * Created..: 16/04/2022
 */

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/* declare and extend the class to include JFrame and Key Listener */
public class PlayGame extends JFrame implements KeyListener {

    /* declare frame as global */
    JFrame frame;

    /* declare default constructor for this class */
    PlayGame() {

        /* pop up user to enter the name */
        String namePlayer = JOptionPane.showInputDialog("Please enter your name: ");
        System.out.println("The player name is: " + namePlayer);

        /* create border for frame */
        Border border = BorderFactory.createLineBorder(Color.GREEN,3);

        /* create label and set the text with position */
        JLabel labelTitle = new JLabel();
        labelTitle.setText("WORDLE");
        labelTitle.setHorizontalTextPosition(JLabel.CENTER);
        labelTitle.setVerticalTextPosition(JLabel.TOP);

        /* set color, font type and size of the text */
        labelTitle.setForeground(Color.GREEN);
        labelTitle.setFont(new Font("MV Bold", Font.BOLD,36));
        labelTitle.setIconTextGap(20); // set gap of text to image ???

        /* set and display background color plus border of the label */
        labelTitle.setBackground(Color.black);
        labelTitle.setOpaque(true);

        /* create panels */
        JPanel panelTitle = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        /* set background color of the panels */
        panelTitle.setBackground(Color.black);
        panel2.setBackground(Color.black);
        panel3.setBackground(Color.black);
        panel4.setBackground(Color.magenta);
        panel5.setBackground(Color.black);

        /* set size of the panels */
        panelTitle.setPreferredSize(new Dimension(100,50));
        panel2.setPreferredSize(new Dimension(20,50));
        panel3.setPreferredSize(new Dimension(20,50));
        panel4.setPreferredSize(new Dimension(100,200));
        panel5.setPreferredSize(new Dimension(100,50));

        /* create and setup frame */
        frame = new JFrame();
        frame.setTitle("## WORDLE - PLAY GAME ##");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); // prevents frame from being resized
        frame.setSize(469,500);
        frame.addKeyListener(this);
        frame.setVisible(true);

        /* set up position of the frame at the center of the screen */
        frame.setLocationRelativeTo(null);

        /* add panels to the frame */
        panelTitle.add(labelTitle);

        /* GRID */
        Main.styleGrid();
        Main.addLabels();
        panel5.add(Main.grid);

        frame.add(panelTitle, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.WEST);
        frame.add(panel3, BorderLayout.EAST);
        frame.add(panel4, BorderLayout.SOUTH);
        frame.add(panel5, BorderLayout.CENTER);


    }

    /*  */
    public void paint(Graphics g){
        int x = 500,y = 150, width = 50, height = 50;
        for(int i= 0; i < 6; i++) { // for rows
            for (int j = 0; j < 5; j++) { //for columns
                g.drawRect(x + (width * j), y+(height*i), width, height);
            }
        }
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
