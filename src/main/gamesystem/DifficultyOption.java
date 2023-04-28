package main.gamesystem;

/**
 * An enum shows the different difficulty options of the game
 * @author J Kim
 */
public enum DifficultyOption {
    EASY("Easy", 30000.00, 15000.00, 0),
    DIFFICULT("Difficult", 20000.00, 7000.00, 1);

    final String DIFFICULTY;
    final double MONEY;
    final double MONEY_GAINED;
    final int PHASE;

    DifficultyOption(String string, double money, double gain, int phase) {
        this.DIFFICULTY = string;
        this.MONEY = money;
        this.MONEY_GAINED = gain;
        this.PHASE = phase;

    }

    public double getMoney() {
        return this.MONEY;
    }
    /**
     * return enum literal to string to show ui
     * @return difficulty string value
     */
    public String toString() {
        return this.DIFFICULTY;
    }
}