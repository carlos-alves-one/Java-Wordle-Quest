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
        JPanel panelWest = new JPanel();
        JPanel panelEast = new JPanel();
        JPanel panelKeyboard = new JPanel();
        JPanel panelGrid = new JPanel();

        /* set background color of the panels */
        panelTitle.setBackground(Color.black);
        panelWest.setBackground(Color.black);
        panelEast.setBackground(Color.black);
        panelKeyboard.setBackground(Color.black);
        panelGrid.setBackground(Color.black);

        /* set size of the panels */
        panelTitle.setPreferredSize(new Dimension(100,50));
        panelWest.setPreferredSize(new Dimension(20,50));
        panelEast.setPreferredSize(new Dimension(20,50));
        panelKeyboard.setPreferredSize(new Dimension(200,200));
        panelGrid.setPreferredSize(new Dimension(100,50));

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
        panelGrid.add(Main.grid);

        /* create keyboard */
        JButton buttonQ = new JButton("Q");
        JButton buttonW = new JButton("W");
        JButton buttonE = new JButton("E");
        JButton buttonR = new JButton("R");
        JButton buttonT = new JButton("T");
        JButton buttonY = new JButton("Y");
        JButton buttonU = new JButton("U");
        JButton buttonI = new JButton("I");
        JButton buttonO = new JButton("O");
        JButton buttonP = new JButton("P");
        JButton buttonA = new JButton("A");
        JButton buttonS = new JButton("S");
        JButton buttonD = new JButton("D");
        JButton buttonF = new JButton("F");
        JButton buttonG = new JButton("G");
        JButton buttonH = new JButton("H");
        JButton buttonJ = new JButton("J");
        JButton buttonK = new JButton("K");
        JButton buttonL = new JButton("L");
        JButton buttonZ = new JButton("Z");
        JButton buttonX = new JButton("X");
        JButton buttonC = new JButton("C");
        JButton buttonV = new JButton("V");
        JButton buttonB = new JButton("B");
        JButton buttonN = new JButton("N");
        JButton buttonM = new JButton("M");
        JButton buttonENTER = new JButton("ENTER");
        JButton buttonDELETE = new JButton("DELETE");

        panelKeyboard.add(buttonQ);
        panelKeyboard.add(buttonW);
        panelKeyboard.add(buttonE);
        panelKeyboard.add(buttonR);
        panelKeyboard.add(buttonT);
        panelKeyboard.add(buttonY);
        panelKeyboard.add(buttonU);
        panelKeyboard.add(buttonI);
        panelKeyboard.add(buttonO);
        panelKeyboard.add(buttonP);
        panelKeyboard.add(buttonA);
        panelKeyboard.add(buttonS);
        panelKeyboard.add(buttonD);
        panelKeyboard.add(buttonF);
        panelKeyboard.add(buttonG);
        panelKeyboard.add(buttonH);
        panelKeyboard.add(buttonJ);
        panelKeyboard.add(buttonK);
        panelKeyboard.add(buttonL);
        panelKeyboard.add(buttonZ);
        panelKeyboard.add(buttonX);
        panelKeyboard.add(buttonC);
        panelKeyboard.add(buttonV);
        panelKeyboard.add(buttonB);
        panelKeyboard.add(buttonN);
        panelKeyboard.add(buttonM);
        panelKeyboard.add(buttonENTER);
        panelKeyboard.add(buttonDELETE);

        frame.add(panelTitle, BorderLayout.NORTH);
        frame.add(panelWest, BorderLayout.WEST);
        frame.add(panelEast, BorderLayout.EAST);
        frame.add(panelKeyboard, BorderLayout.SOUTH);
        frame.add(panelGrid, BorderLayout.CENTER);
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
