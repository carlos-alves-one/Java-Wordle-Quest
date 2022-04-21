/*
 * Goldsmiths University of London
 * Author...: Carlos Manuel de Oliveira Alves
 * Student..: cdeol003
 * Created..: 21/04/2022
 */

/* declare and initialise the enum to score the game */
public enum GameScore {

    /* instantiate the constants of the enum */
    score1(0,20,10),
    score2(1,18,9),
    score3(2,16,8),
    score4(3,14,7),
    score5(4,12,6),
    score6(5,10,5);

    /* declare variables to be assign with enum */
    private final int wordCount;
    private final int valueGreen;
    private final int valueYellow;

    /* declare default constructor for this enum */
    GameScore(int wordCount, int valueGreen, int valueYellow) {
        this.wordCount = wordCount;
        this.valueGreen = valueGreen;
        this.valueYellow = valueYellow;
    }

    /* declare getters for this enum */
    public int getWordCount() {return wordCount;}
    public int getValueGreen() {return valueGreen;}
    public int getValueYellow() {return valueYellow;}
}
