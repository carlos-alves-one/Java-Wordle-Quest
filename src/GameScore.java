/*
 * Goldsmiths University of London
 * Author...: Carlos Manuel de Oliveira Alves
 * Student..: cdeol003
 * Created..: 21/04/2022
 */

/* declare and initialise the enum to score the game */
public enum GameScore {

    /* instantiate the constants of the enum */
    score1(20,10),
    score2(18,9),
    score3(16,8),
    score4(14,7),
    score5(12,6),
    score6(10,5);

    /* declare variables to be assign with enum */
    private final int valueGreen;
    private final int valueYellow;

    /* declare default constructor for this enum */
    GameScore(int valueGreen, int valueYellow) {
        this.valueGreen = valueGreen;
        this.valueYellow = valueYellow;
    }

    /* declare getters for this enum */
    public int getValueGreen() {return valueGreen;}
    public int getValueYellow() {return valueYellow;}
}
