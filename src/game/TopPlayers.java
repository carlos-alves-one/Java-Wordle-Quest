
/*
 * Goldsmiths University of London
 * Author...: Carlos Manuel de Oliveira Alves
 * Student..: cdeol003
 * Created..: 25/04/2022
 */

/* declare package and all libraries to be used with this class */
package game;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/* declare class to display top players */
public class TopPlayers {

    /* declare instance variables */
    public String name;
    public int score;
    public String game;

    /* declare the construction function for this class */
    public TopPlayers(String name, int score, String game) {
        this.name = name;
        this.score = score;
        this.game = game;
        connectDB();
    }

    /* connect the database of top players */
    public static void connectDB() {

        Connection conn = null;

        try {
            // db parameters
            String url = "jdbc:sqlite:src/databases/topPlayers.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println(">> Connection to database has been established");
            Statement statement = conn.createStatement();
            statement.execute("INSERT INTO players (name, score, game)" + "VALUES (name, score, game)");
            System.out.println(">> New record added to the database successfully");

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
