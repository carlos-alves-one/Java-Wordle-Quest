
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
        JLabel labelFieldsDB2 = new JLabel();
        labelFieldsDB2.setText("******       *****       ****");
        labelFieldsDB2.setHorizontalTextPosition(JLabel.CENTER);
        labelFieldsDB2.setVerticalTextPosition(JLabel.TOP);

        /* set color, font type and size of the text */
        labelFieldsDB.setForeground(Color.orange);
        labelFieldsDB.setFont(new Font("MV Bold", Font.BOLD,25));
        labelFieldsDB2.setForeground(Color.orange);
        labelFieldsDB2.setFont(new Font("MV Bold", Font.BOLD,35));

        /* set and display background color plus border of the label */
        labelFieldsDB.setBackground(Color.black);
        labelFieldsDB.setOpaque(true);
        labelFieldsDB2.setBackground(Color.black);
        labelFieldsDB2.setOpaque(true);

        /* instantiate the labels to display data from the database */
        JLabel fieldsRow_1_Column_1 = new JLabel();
        JLabel fieldsRow_1_Column_2 = new JLabel();
        JLabel fieldsRow_1_Column_3 = new JLabel();
        JLabel fieldsRow_2_Column_1 = new JLabel();
        JLabel fieldsRow_2_Column_2 = new JLabel();
        JLabel fieldsRow_2_Column_3 = new JLabel();
        JLabel fieldsRow_3_Column_1 = new JLabel();
        JLabel fieldsRow_3_Column_2 = new JLabel();
        JLabel fieldsRow_3_Column_3 = new JLabel();
        JLabel fieldsRow_4_Column_1 = new JLabel();
        JLabel fieldsRow_4_Column_2 = new JLabel();
        JLabel fieldsRow_4_Column_3 = new JLabel();
        JLabel fieldsRow_5_Column_1 = new JLabel();
        JLabel fieldsRow_5_Column_2 = new JLabel();
        JLabel fieldsRow_5_Column_3 = new JLabel();

        fieldsRow_1_Column_1.setBackground(Color.black);
        fieldsRow_1_Column_2.setBackground(Color.black);
        fieldsRow_1_Column_3.setBackground(Color.black);
        fieldsRow_2_Column_1.setBackground(Color.black);
        fieldsRow_2_Column_2.setBackground(Color.black);
        fieldsRow_2_Column_3.setBackground(Color.black);
        fieldsRow_3_Column_1.setBackground(Color.black);
        fieldsRow_3_Column_2.setBackground(Color.black);
        fieldsRow_3_Column_3.setBackground(Color.black);
        fieldsRow_4_Column_1.setBackground(Color.black);
        fieldsRow_4_Column_2.setBackground(Color.black);
        fieldsRow_4_Column_3.setBackground(Color.black);
        fieldsRow_5_Column_1.setBackground(Color.black);
        fieldsRow_5_Column_2.setBackground(Color.black);
        fieldsRow_5_Column_3.setBackground(Color.black);

        fieldsRow_1_Column_1.setForeground(Color.gray);
        fieldsRow_1_Column_2.setForeground(Color.gray);
        fieldsRow_1_Column_3.setForeground(Color.gray);
        fieldsRow_2_Column_1.setForeground(Color.gray);
        fieldsRow_2_Column_2.setForeground(Color.gray);
        fieldsRow_2_Column_3.setForeground(Color.gray);
        fieldsRow_3_Column_1.setForeground(Color.gray);
        fieldsRow_3_Column_2.setForeground(Color.gray);
        fieldsRow_3_Column_3.setForeground(Color.gray);
        fieldsRow_4_Column_1.setForeground(Color.gray);
        fieldsRow_4_Column_2.setForeground(Color.gray);
        fieldsRow_4_Column_3.setForeground(Color.gray);
        fieldsRow_5_Column_1.setForeground(Color.gray);
        fieldsRow_5_Column_2.setForeground(Color.gray);
        fieldsRow_5_Column_3.setForeground(Color.gray);

        fieldsRow_1_Column_1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        fieldsRow_1_Column_2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        fieldsRow_1_Column_3.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        fieldsRow_2_Column_1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        fieldsRow_2_Column_2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        fieldsRow_2_Column_3.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        fieldsRow_3_Column_1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        fieldsRow_3_Column_2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        fieldsRow_3_Column_3.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        fieldsRow_4_Column_1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        fieldsRow_4_Column_2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        fieldsRow_4_Column_3.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        fieldsRow_5_Column_1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        fieldsRow_5_Column_2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        fieldsRow_5_Column_3.setBorder(BorderFactory.createLineBorder(Color.black, 1));

        fieldsRow_1_Column_1.setPreferredSize(new Dimension(175,40));
        fieldsRow_1_Column_2.setPreferredSize(new Dimension(70,40));
        fieldsRow_1_Column_3.setPreferredSize(new Dimension(120,40));
        fieldsRow_2_Column_1.setPreferredSize(new Dimension(175,40));
        fieldsRow_2_Column_2.setPreferredSize(new Dimension(70,40));
        fieldsRow_2_Column_3.setPreferredSize(new Dimension(120,40));
        fieldsRow_3_Column_1.setPreferredSize(new Dimension(175,40));
        fieldsRow_3_Column_2.setPreferredSize(new Dimension(70,40));
        fieldsRow_3_Column_3.setPreferredSize(new Dimension(120,40));
        fieldsRow_4_Column_1.setPreferredSize(new Dimension(175,40));
        fieldsRow_4_Column_2.setPreferredSize(new Dimension(70,40));
        fieldsRow_4_Column_3.setPreferredSize(new Dimension(120,40));
        fieldsRow_5_Column_1.setPreferredSize(new Dimension(175,40));
        fieldsRow_5_Column_2.setPreferredSize(new Dimension(70,40));
        fieldsRow_5_Column_3.setPreferredSize(new Dimension(120,40));

        /* call method to connect to the database and query data */
        connectDB();

        fieldsRow_1_Column_1.setText(dataDatabase.get(0));
        fieldsRow_1_Column_1.setFont(new Font("Consolas",Font.BOLD, 20));
        fieldsRow_1_Column_2.setText(dataDatabase.get(1));
        fieldsRow_1_Column_2.setFont(new Font("Consolas",Font.BOLD, 20));
        fieldsRow_1_Column_3.setText(dataDatabase.get(2));
        fieldsRow_1_Column_3.setFont(new Font("Consolas",Font.BOLD, 20));
        fieldsRow_2_Column_1.setText(dataDatabase.get(3));
        fieldsRow_2_Column_1.setFont(new Font("Consolas",Font.BOLD, 20));
        fieldsRow_2_Column_2.setText(dataDatabase.get(4));
        fieldsRow_2_Column_2.setFont(new Font("Consolas",Font.BOLD, 20));
        fieldsRow_2_Column_3.setText(dataDatabase.get(5));
        fieldsRow_2_Column_3.setFont(new Font("Consolas",Font.BOLD, 20));
        fieldsRow_3_Column_1.setText(dataDatabase.get(6));
        fieldsRow_3_Column_1.setFont(new Font("Consolas",Font.BOLD, 20));
        fieldsRow_3_Column_2.setText(dataDatabase.get(7));
        fieldsRow_3_Column_2.setFont(new Font("Consolas",Font.BOLD, 20));
        fieldsRow_3_Column_3.setText(dataDatabase.get(8));
        fieldsRow_3_Column_3.setFont(new Font("Consolas",Font.BOLD, 20));
        fieldsRow_4_Column_1.setText(dataDatabase.get(9));
        fieldsRow_4_Column_1.setFont(new Font("Consolas",Font.BOLD, 20));
        fieldsRow_4_Column_2.setText(dataDatabase.get(10));
        fieldsRow_4_Column_2.setFont(new Font("Consolas",Font.BOLD, 20));
        fieldsRow_4_Column_3.setText(dataDatabase.get(11));
        fieldsRow_4_Column_3.setFont(new Font("Consolas",Font.BOLD, 20));
        fieldsRow_5_Column_1.setText(dataDatabase.get(12));
        fieldsRow_5_Column_1.setFont(new Font("Consolas",Font.BOLD, 20));
        fieldsRow_5_Column_2.setText(dataDatabase.get(13));
        fieldsRow_5_Column_2.setFont(new Font("Consolas",Font.BOLD, 20));
        fieldsRow_5_Column_3.setText(dataDatabase.get(14));
        fieldsRow_5_Column_3.setFont(new Font("Consolas",Font.BOLD, 20));

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
        panelKeyboard.setPreferredSize(new Dimension(200,50));
        panelGrid.setPreferredSize(new Dimension(100,50));

        /* create and setup frame */
        frame = new JFrame();
        frame.setTitle("Wordle -->> Top Players");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); // prevents frame from being resized
        frame.setSize(469,450);;
        frame.setVisible(true);

        /* set up position of the frame at the center of the screen */
        frame.setLocationRelativeTo(null);

        /* add labels and fields to the panel */
        panelTitle.add(labelTitle);
        panelGrid.add(labelFieldsDB);
        panelGrid.add(labelFieldsDB2);
        panelGrid.add(fieldsRow_1_Column_1);
        panelGrid.add(fieldsRow_1_Column_2);
        panelGrid.add(fieldsRow_1_Column_3);
        panelGrid.add(fieldsRow_2_Column_1);
        panelGrid.add(fieldsRow_2_Column_2);
        panelGrid.add(fieldsRow_2_Column_3);
        panelGrid.add(fieldsRow_3_Column_1);
        panelGrid.add(fieldsRow_3_Column_2);
        panelGrid.add(fieldsRow_3_Column_3);
        panelGrid.add(fieldsRow_4_Column_1);
        panelGrid.add(fieldsRow_4_Column_2);
        panelGrid.add(fieldsRow_4_Column_3);
        panelGrid.add(fieldsRow_5_Column_1);
        panelGrid.add(fieldsRow_5_Column_2);
        panelGrid.add(fieldsRow_5_Column_3);

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

            /* prepare statement to insert a new record */
            Statement statement = conn.createStatement();

            /* query database */
            ResultSet results = statement.executeQuery("SELECT * FROM players ORDER BY score DESC");

            /* declare counter to add into the array only 5 records from the query*/
            int countRows = 0;

            while (results.next() && countRows < 5) {

                /* store data from the database */
                dataDatabase.add(results.getString("name"));
                dataDatabase.add(results.getString("score"));
                dataDatabase.add(results.getString("game"));
                countRows++;
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
}
