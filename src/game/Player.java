
/*
 * Goldsmiths University of London
 * Author...: Carlos Manuel de Oliveira Alves
 * Student..: cdeol003
 * Created..: 28/04/2022
 */

/* declare package of this class */
package game;

/* declare class for player */
public class Player {

    /* declare instance variables */
    private String name;
    private int score;
    private String game;

    /* declare the construction function for this class */
    public Player(String name, int score, String game) {
        this.name = name;
        this.score = score;
        this.game = game;
    }

    /* declare getters and setters */
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getScore() {return score;}
    public void setScore(int score) {this.score = score;}
    public String getGame() {return game;}
    public void setGame(String game) {this.game = game;}
}
