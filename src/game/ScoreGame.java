
/*
 * Goldsmiths University of London
 * Author...: Carlos Manuel de Oliveira Alves
 * Student..: cdeol003
 * Created..: 21/04/2022
 */

/* declare package and initialise the enum to score the game */
package game;
public enum ScoreGame {

    /* instantiate the constants of the enum */
    score1(20,10),
    score2(18,9),
    score3(16,8),
    score4(14,7),
    score5(12,6),
    score6(10,5);

    /* declare variables to be assigned with enum */
    private final int valueGreen;
    private final int valueYellow;

    /* declare default constructor for this enum */
    ScoreGame(int valueGreen, int valueYellow) {
        this.valueGreen = valueGreen;
        this.valueYellow = valueYellow;
    }

    /* declare getters for this enum */
    public int getValueGreen() {return valueGreen;}
    public int getValueYellow() {return valueYellow;}
}
