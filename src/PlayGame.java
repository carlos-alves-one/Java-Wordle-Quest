/*
 * Goldsmiths University of London
 * Author...: Carlos Manuel de Oliveira Alves
 * Student..: cdeol003
 * Created..: 16/04/2022
 */

/* declare all libraries to be used with this class */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

/* declare and extend the class to include JFrame and Key Listener */
public class PlayGame extends JFrame implements ActionListener {

    /* declare frame as global */
    JFrame frame;

    /* declare an array to store letters using labels 5 letters by 6 rows */
    static JLabel[][] letterBoxes = new JLabel[6][5];
    static JPanel grid = new JPanel(new GridLayout(6,5,5,5));

    /* declare counters for score and control letters and words */
    int playerScore = 0;
    int totalLetters = 0;
    int totalWords = 0;

    /* declare an array to locate the enum to work with the score */
    String[] scoreGame = {"score1","score2","score3","score4","score5","score6"};

    /* declare variable to store the word from the user */
    String userWord = "";

    /* declare player name variable */
    String namePlayer;

    /* declare default constructor for this class */
    PlayGame() {

        /* pop up user to enter the name */
        namePlayer = JOptionPane.showInputDialog("Please enter your name: ");

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
        frame.setTitle("Player: " + namePlayer + " -->> " + playerScore + " Points");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); // prevents frame from being resized
        frame.setSize(469,500);;
        frame.setVisible(true);

        /* set up position of the frame at the center of the screen */
        frame.setLocationRelativeTo(null);

        /* add panels to the frame */
        panelTitle.add(labelTitle);

        /* create GRID */
        styleGrid();
        addLabels();
        panelGrid.add(grid);

        /* create an array to store the letters for the keyboard */
        String[] letters = {" Q "," W "," E "," R "," T "," Y "," U "," I "," O "," P ",
                            " A "," S "," D "," F "," G "," H "," J "," K "," L ",
                            " Z "," X "," C "," V "," B "," N "," M "," DELETE "," ENTER "};

        /* create an array to store all the buttons to be used with the keyboard */
        JButton[] keyboard;
        keyboard = new JButton[28];

        /* create buttons for keyboard */
        for (int i = 0; i < letters.length; i++) {
            keyboard[i] = new JButton();
            keyboard[i].setText(letters[i]);
            keyboard[i].setBorder(BorderFactory.createLineBorder(new Color(100, 100, 10), 10));
            keyboard[i].setBackground(new Color(129, 131, 132));
            keyboard[i].setOpaque(true);
            keyboard[i].setForeground(Color.darkGray);
            keyboard[i].setFont(new Font("Clear Sans", Font.BOLD, 13));
            keyboard[i].addActionListener(this);
            panelKeyboard.add(keyboard[i]);
        }

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

    /* method to style the grid */
    static void styleGrid() {
        Dimension size = new Dimension(250, 200);
        grid.setMaximumSize(size);
        grid.setPreferredSize(size);
        grid.setBackground(Color.BLACK);
    }

    /* method to add labels to the grid */
    public static void addLabels() {

        for(int i = 0; i < 6; i++) {

            for (int j = 0; j < 5; j++) {
                JLabel label = new JLabel();
                label.setOpaque(true);
                label.setBackground(Color.gray);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setFont(new Font("MV Bold", Font.BOLD,20));
                grid.add(letterBoxes[i][j] = label);
            }
        }
    }

    /* method to update the grid */
    public static void updateGrid(int i ,int j, String letter, String color) {

        if(j < 5 && i < 6 && j >= 0 && i >= 0) {

            letterBoxes[i][j].setText(letter);

            /* set background color of the letter */
            if (Objects.equals(color, "yellow")) {
                letterBoxes[i][j].setBackground(Color.yellow);
            }
            else if (Objects.equals(color, "green")) {
                letterBoxes[i][j].setBackground(Color.green);
            }
            else {
                letterBoxes[i][j].setBackground(Color.gray);
            }
        }
    }

    @Override
    /* method invoked when one of the buttons are pressed in the keyboard */
    public void actionPerformed(ActionEvent e) {

        /* store key pressed by the user */
        String keyPressed = e.getActionCommand();

        /* check we pressed DELETE */
        if(Objects.equals(keyPressed, " DELETE ")) {

            /* clear the grid with space and update background color */
            updateGrid(totalWords, totalLetters = totalLetters > 0 ?
                       totalLetters - 1 : totalLetters, " ", "gray");
            totalLetters--;

            /* update the word from the user */
            if (userWord.length() > 0) {
                userWord = userWord.replace(userWord.substring(userWord.length()-1),"");
            }
        }
        else if (!Objects.equals(keyPressed, " ENTER ")) {
                /* fill the grid with letter and update background color */
                updateGrid(totalWords, totalLetters, keyPressed, "gray");
        }

        /* only add letters to the word  when is not ENTER or DELETE */
        if (!Objects.equals(keyPressed, " ENTER ") && !Objects.equals(keyPressed, " DELETE ")) {
            keyPressed = keyPressed.toLowerCase();
            userWord += keyPressed.replaceAll(" ", "");
        }

        /* check we pressed ENTER */
        if(Objects.equals(keyPressed, " ENTER ")) {

            /* boolean variable to help with score update */
            boolean updateScore = true;

            /* check the word from the user is in the dictionary */
            if (!MainApp.dictionary.contains(userWord) && userWord.length() == 5) {
                JOptionPane.showMessageDialog(null,
                        "Word not in the dictionary - Please try again");
                /* if word is not in the dictionary don't update score */
                updateScore = false;
            }

            /* check all letter from the word and update background color */
            for (int i = 0; i < userWord.length(); i++) {

                /* store current letter of the user word only we have letters stored */
                String userLetter = String.valueOf(userWord.charAt(i));
                String userLetterFinal = " " + userLetter.toUpperCase() + " ";

                /* check the user word letter match with the word target and the score can be updated */
                if (userWord.charAt(i) ==  MainApp.wordle.charAt(i) && updateScore) {
                    updateGrid(totalWords, i, userLetterFinal, "green");

                    /* update score of the player */
                    playerScore += ScoreGame.valueOf(scoreGame[totalWords]).getValueGreen();

                } else if (MainApp.wordle.contains(userLetter) && updateScore) {
                    updateGrid(totalWords, i, userLetterFinal, "yellow");

                    /* update score of the player */
                    playerScore += ScoreGame.valueOf(scoreGame[totalWords]).getValueYellow();
                }

                /* update title with score */
                frame.setTitle("Player: " + namePlayer + " -->> " + playerScore + " Points");
            }

            /* validate we have a full word with 5 letters */
            if (userWord.length() < 4 && totalWords < 5) {
                JOptionPane.showMessageDialog(null,
                        "Invalid Word - Please fill the word with 5 letters");
                updateScore = false;
            }

            /* check we have a word, but we don't have a match */
            if (totalLetters == 4 && !userWord.equals(MainApp.wordle)) {
                JOptionPane.showMessageDialog(null,
                        "Wordle not found - Please enter another word");
            }

            /* check we have the last word, and we don't have a match */
            if (totalWords > 4 && !userWord.equals(MainApp.wordle) && totalLetters > 0) {
                JOptionPane.showMessageDialog(null,
                        "Unfortunately you did not found the Wordle");
            }

            /* check we have word match */
            if(userWord.equals(MainApp.wordle)) {
                JOptionPane.showMessageDialog(null,
                        "Congratulations you found the Wordle");
            }
        }
        /* check we have a word less than 5 letters */
        if (totalLetters < 5) {
            totalLetters++;
        }
        else {
            /* if we have a word we're going to next row */
            totalLetters = 0;
            if (totalWords < 5) {
                totalWords++;
            }
            /* reset current user word */
            userWord = "";
        }
    }
}
