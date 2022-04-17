/*
 * Goldsmiths University of London
 * Author...: Carlos Manuel de Oliveira Alves
 * Student..: cdeol003
 * Created..: 16/04/2022
 */

/* declare all libraries to be used with this class */
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/* declare and extend the class to include JFrame and Key Listener */
public class PlayGame extends JFrame implements KeyListener {

    /* declare frame as global */
    JFrame frame;

    /* declare an array to store letters using labels 5 letters by 6 rows */
    static JLabel[][] letterBoxes = new JLabel[6][5];
    static JPanel grid = new JPanel(new GridLayout(6,5,5,5));

    /* declare default constructor for this class */
    PlayGame() {

        /* pop up user to enter the name */
        String namePlayer = JOptionPane.showInputDialog("Please enter your name: ");

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

        /* create and set color of panels for help subtitles */
        JPanel panelGreen = new JPanel();
        JPanel panelYellow = new JPanel();
        JPanel panelGray = new JPanel();
        panelGreen.setBackground(Color.green);
        panelGreen.setPreferredSize(new Dimension(25,20));
        panelYellow.setBackground(Color.yellow);
        panelYellow.setPreferredSize(new Dimension(25,20));
        panelGray.setBackground(Color.gray);
        panelGray.setPreferredSize(new Dimension(25,20));

        /* create label and set the text with position */
        JLabel labelTitleGreen = new JLabel();
        labelTitleGreen.setText("Correct letter");
        labelTitleGreen.setHorizontalTextPosition(JLabel.CENTER);
        labelTitleGreen.setVerticalTextPosition(JLabel.TOP);
        JLabel labelTitleYellow = new JLabel();
        labelTitleYellow.setText("Correct but wrong spot");
        labelTitleYellow.setHorizontalTextPosition(JLabel.CENTER);
        labelTitleYellow.setVerticalTextPosition(JLabel.TOP);
        JLabel labelTitleGray = new JLabel();
        labelTitleGray.setText("Letter not in the word");
        labelTitleGray.setHorizontalTextPosition(JLabel.CENTER);
        labelTitleGray.setVerticalTextPosition(JLabel.TOP);

        /* set color, font type and size of the text */
        labelTitleGreen.setForeground(Color.GREEN);
        labelTitleGreen.setFont(new Font("MV Bold", Font.BOLD,12));
        labelTitleYellow.setForeground(Color.YELLOW);
        labelTitleYellow.setFont(new Font("MV Bold", Font.BOLD,12));
        labelTitleGray.setForeground(Color.gray);
        labelTitleGray.setFont(new Font("MV Bold", Font.BOLD,12));

        /* set and display background color plus border of the label */
        labelTitleGreen.setBackground(Color.black);
        labelTitleGreen.setOpaque(true);
        labelTitleYellow.setBackground(Color.black);
        labelTitleYellow.setOpaque(true);
        labelTitleGray.setBackground(Color.black);
        labelTitleGray.setOpaque(true);

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
        frame.setTitle("Player: " + namePlayer);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); // prevents frame from being resized
        frame.setSize(469,500);
        frame.addKeyListener(this);
        frame.setVisible(true);

        /* set up position of the frame at the center of the screen */
        frame.setLocationRelativeTo(null);

        /* add panels to the frame */
        panelTitle.add(labelTitle);

        /* create GRID */
        styleGrid();
        addLabels();
        panelGrid.add(grid);

        /* create buttons for keyboard */
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
        JButton buttonDELETE = new JButton("DELETE");
        JButton buttonENTER = new JButton("ENTER");

        /* add buttons to panel */
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
        panelKeyboard.add(buttonDELETE);
        panelKeyboard.add(buttonENTER);

        /* create label and set the text with position */
        JLabel labelTitleB1 = new JLabel();
        labelTitleB1.setText("Guess the WORDLE in six tries.");
        labelTitleB1.setHorizontalTextPosition(JLabel.CENTER);
        labelTitleB1.setVerticalTextPosition(JLabel.TOP);

        /* set color, font type and size of the text */
        labelTitleB1.setForeground(Color.GREEN);
        labelTitleB1.setFont(new Font("MV Bold", Font.BOLD,12));

        /* set and display background color plus border of the label */
        labelTitleB1.setBackground(Color.black);
        labelTitleB1.setOpaque(true);
        panelKeyboard.add(labelTitleB1);

        /* create label and set the text with position */
        JLabel labelTitleB2 = new JLabel();
        labelTitleB2.setText("Each guess must be a valid five-letter word. Hit the enter button to submit.");
        labelTitleB2.setHorizontalTextPosition(JLabel.CENTER);
        labelTitleB2.setVerticalTextPosition(JLabel.TOP);

        /* set color, font type and size of the text */
        labelTitleB2.setForeground(Color.gray);
        labelTitleB2.setFont(new Font("MV Bold", Font.BOLD,12));

        /* set and display background color plus border of the label */
        labelTitleB2.setBackground(Color.black);
        labelTitleB2.setOpaque(true);
        panelKeyboard.add(labelTitleB2);

        /* add help subtitles */
        panelKeyboard.add(panelGreen);
        panelKeyboard.add(labelTitleGreen);
        panelKeyboard.add(panelYellow);
        panelKeyboard.add(labelTitleYellow);
        panelKeyboard.add(panelGray);
        panelKeyboard.add(labelTitleGray);

        /* add all panels to frame */
        frame.add(panelTitle, BorderLayout.NORTH);
        frame.add(panelWest, BorderLayout.WEST);
        frame.add(panelEast, BorderLayout.EAST);
        frame.add(panelKeyboard, BorderLayout.SOUTH);
        frame.add(panelGrid, BorderLayout.CENTER);
    }

    /* method to draw all labels of the grid */
    public void paint(Graphics g){

        int x = 500,y = 150, width = 50, height = 50;

        /* loop to draw rectangles for rows */
        for(int i= 0; i < 6; i++) {

            /* loop to draw rectangles for columns */
            for (int j = 0; j < 5; j++) {
                g.drawRect(x + (width * j), y+(height*i), width, height);
            }
        }
    }

    @Override
    /* method invoked when a key is typed. Uses keyChar, char output */
    public void keyTyped(KeyEvent e) {}

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
    public void keyReleased(KeyEvent e) {}

    /* method to style the grid */
    static void styleGrid() {
        Dimension size = new Dimension(250, 200);
        grid.setMaximumSize(size);
        grid.setPreferredSize(size);
        grid.setBackground(Color.BLACK);
    }

    /* method to update the grid */
    public static void update(int i ,int j, String letter) {

        System.out.println(">> Update the grid");

        if(j < 5 && i < 6 && j >= 0 && i >= 0)
            letterBoxes[i][j].setText(letter);
    }

    /* method to add labels to the grid */
    public static void addLabels() {

        for(int i = 0; i < 6; i++) {

            for (int j = 0; j < 5; j++) {
                JLabel label = new JLabel();
                label.setOpaque(true);
                label.setBackground(Color.gray);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                grid.add(letterBoxes[i][j] = label);
            }
        }
    }
}
