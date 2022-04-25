
package game;/*

 * Goldsmiths University of London
 * Author...: Carlos Manuel de Oliveira Alves
 * Student..: cdeol003
 * Created..: 25/04/2022
 */

/* declare all libraries to be used with this class */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/* declare class to display top players */
public class TopPlayers {

    /* connect the database of top players */
    public static void connectDB() {

        Connection conn = null;

        try {
            // db parameters
            String url = "jdbc:sqlite:topPlayers.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println(">> Connection to database has been established");
            Statement statement = conn.createStatement();
//            statement.execute("INSERT INTO topPlayers (name, score, dateGame)" +
//                    "VALUES ('Carlos', 100, '25/04/2022')");

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
    // main method
    public static void main(String[] args) {
        connectDB();
    }
}
