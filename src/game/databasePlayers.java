
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
import java.sql.*;
import java.util.ArrayList;

/* declare and extend the class to include JFrame and Key Listener */
public class databasePlayers extends JFrame {

    /* declare frame as global */
    JFrame frame;

    /* declare an array list to store data from the database */
    public ArrayList<Player> dataDatabase = new ArrayList();

    /* instantiate the text fields to display data from the database */
    private final JTextField fieldName_1;
    private final JTextField fieldScore_1;
    private final JTextField fieldGame_1;

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

        /* create label for database fields */
        JLabel labelFieldsDB = new JLabel();
        labelFieldsDB.setText("PLAYER       SCORE       GAME");
        labelFieldsDB.setHorizontalTextPosition(JLabel.CENTER);
        labelFieldsDB.setVerticalTextPosition(JLabel.TOP);

        /* set color, font type and size of the text */
        labelFieldsDB.setForeground(Color.orange);
        labelFieldsDB.setFont(new Font("MV Bold", Font.BOLD,25));

        /* set and display background color plus border of the label */
        labelFieldsDB.setBackground(Color.black);
        labelFieldsDB.setOpaque(true);

        /* create panels */
        JPanel panelTitle = new JPanel();
        JPanel panelWest = new JPanel();
        JPanel panelEast = new JPanel();
        JPanel panelKeyboard = new JPanel();
        JPanel panelGrid = new JPanel();

        /* set background color of the panels */
        panelTitle.setBackground(Color.black);
        panelWest.setBackground(Color.orange);
        panelEast.setBackground(Color.orange);
        panelKeyboard.setBackground(Color.black);
        panelGrid.setBackground(Color.pink);

        /* set size of the panels */
        panelTitle.setPreferredSize(new Dimension(100,50));
        panelWest.setPreferredSize(new Dimension(20,50));
        panelEast.setPreferredSize(new Dimension(20,50));
        panelKeyboard.setPreferredSize(new Dimension(200,50));
        panelGrid.setPreferredSize(new Dimension(100,50));

        /* create and setup frame */
        frame = new JFrame();
        frame.setTitle("Wordle -->> Top Players");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); // prevents frame from being resized
        frame.setSize(469,500);;
        frame.setVisible(true);

        /* set up position of the frame at the center of the screen */
        frame.setLocationRelativeTo(null);

        /* add labels to the panels */
        panelTitle.add(labelTitle);
        panelGrid.add(labelFieldsDB);

        /* add all panels to frame */
        frame.add(panelTitle, BorderLayout.NORTH);
        frame.add(panelWest, BorderLayout.WEST);
        frame.add(panelEast, BorderLayout.EAST);
        frame.add(panelKeyboard, BorderLayout.SOUTH);
        frame.add(panelGrid, BorderLayout.CENTER);

        /* add fields to the panel to receive data from the database */
        fieldName_1  = new JFormattedTextField();
        fieldScore_1 = new JFormattedTextField();
        fieldGame_1  = new JFormattedTextField();
        fieldName_1.setEditable(false);
        fieldScore_1.setEditable(false);
        fieldGame_1.setEditable(false);
        fieldName_1.setBackground(Color.blue);
        fieldName_1.setText();


        /* call method to connect to the database and query data */
        connectDB();
    }

    /* declare method to connect the database of top players and query data */
    public static void connectDB() {

        Connection conn = null;

        /* handling with database connection errors */
        try {

            /* declare path for the database */
            String url = "jdbc:sqlite:src/databases/topPlayers.db";

            /* create a connection to the database */
            conn = DriverManager.getConnection(url);
            System.out.println(">> Connection to database established");

            /* prepare statement to insert a new record */
            Statement statement = conn.createStatement();

            /* query database */
            ResultSet results = statement.executeQuery("SELECT * FROM players");

            /* print results from the query */
            System.out.println(">> Data from the database Top Players:");
            while (results.next()) {

                /* store data from the database */


                /* print data on the console for test propose */
                System.out.println("** " + results.getString("game") + " * " +
                                           results.getInt("score")   + " * " +
                                           results.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /* created method for test propose only */
    public static void main(String[] args) {
        new databasePlayers();
    }
}
