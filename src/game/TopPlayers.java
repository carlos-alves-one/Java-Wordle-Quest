
/*
 * Goldsmiths University of London
 * Author...: Carlos Manuel de Oliveira Alves
 * Student..: cdeol003
 * Created..: 25/04/2022
 */

/* declare package and all libraries to be used with this class */
package game;
import java.sql.*;
import java.text.SimpleDateFormat;
//import java.text.SimpleDateFormat;

/* declare class to display top players */
public class TopPlayers {

    /* declare instance variables */
    public static String name;
    public static int score;
    public static String game;

    /* declare the construction function for this class */
    public TopPlayers(String name, int score, String game) {
        TopPlayers.name = name;
        TopPlayers.score = score;
        TopPlayers.game = game;
        connectDB();
    }

    /* declare method to connect the database of top players */
    public static void connectDB() {

        Connection conn = null;

        try {
            /* declare path for the database */
            String url = "jdbc:sqlite:src/databases/topPlayers.db";

            /* create a connection to the database */
            conn = DriverManager.getConnection(url);
            System.out.println(">> Connection to database has been established");

            /* prepare statement to insert a new record */
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS players (name TEXT, score INT, game TEXT)");
            String sql = "INSERT INTO players (name, score, game) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, String.valueOf(score));
            pstmt.setString(3, game);
            pstmt.executeUpdate();
            System.out.println(">> New record added to the table successfully");

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
