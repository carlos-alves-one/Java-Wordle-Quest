
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
    public static ArrayList<String> dataDatabase = new ArrayList();

    /* instantiate the text fields to display data from the database */
    private final JTextField fieldsRow_1;
    private final JTextField fieldsRow_2;
    private final JTextField fieldsRow_3;


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

        /* add fields to the panel to receive data from the database */
        fieldsRow_1  = new JFormattedTextField();
        fieldsRow_2  = new JFormattedTextField();
        fieldsRow_3  = new JFormattedTextField();
        fieldsRow_1.setBackground(Color.blue);
        fieldsRow_2.setBackground(Color.blue);
        fieldsRow_3.setBackground(Color.blue);

        fieldsRow_1.setPreferredSize(new Dimension(178,40));
        fieldsRow_2.setPreferredSize(new Dimension(70,40));
        fieldsRow_3.setPreferredSize(new Dimension(120,40));

        /* call method to connect to the database and query data */
        connectDB();

        fieldsRow_1.setText(dataDatabase.get(0));
        fieldsRow_1.setFont(new Font("Consolas",Font.BOLD, 20));
        fieldsRow_2.setText(dataDatabase.get(1));
        fieldsRow_2.setFont(new Font("Consolas",Font.BOLD, 20));
        fieldsRow_3.setText(dataDatabase.get(2));
        fieldsRow_3.setFont(new Font("Consolas",Font.BOLD, 20));


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

        /* add labels and fields to the panel */
        panelTitle.add(labelTitle);
        panelGrid.add(labelFieldsDB);
        panelGrid.add(fieldsRow_1);
        panelGrid.add(fieldsRow_2);
        panelGrid.add(fieldsRow_3);

        /* add all panels to frame */
        frame.add(panelTitle, BorderLayout.NORTH);
        frame.add(panelWest, BorderLayout.WEST);
        frame.add(panelEast, BorderLayout.EAST);
        frame.add(panelKeyboard, BorderLayout.SOUTH);
        frame.add(panelGrid, BorderLayout.CENTER);

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
                dataDatabase.add(results.getString("name"));
                dataDatabase.add(results.getString("score"));
                dataDatabase.add(results.getString("game"));

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
