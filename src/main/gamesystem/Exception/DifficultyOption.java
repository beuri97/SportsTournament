package main.gamesystem.Exception;

/**
 * An enum shows the different difficulty options of the game
 * @author J Kim
 */
public enum DifficultyOption {
    EASY("Easy"), DIFFICULT("Difficult");

    public final String DIFFICULTY;

    DifficultyOption(String string) {
        this.DIFFICULTY = string;
    }

    /**
     * return enum literal to string to show ui
     * @return difficulty string value
     */
    public String toString() {
        return this.DIFFICULTY;
    }
}