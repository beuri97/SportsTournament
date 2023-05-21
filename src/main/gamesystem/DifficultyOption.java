package main.gamesystem;

/**
 * An enum shows the different difficulty options of the game
 * @author J Kim, H Yang
 */
public enum DifficultyOption {
    EASY("Easy", 15000.00, 7000.00, 0),
    DIFFICULT("Difficult", 12000.00, 4000.00, 1);

    /**
     * Difficulty in String.
     */
    final String DIFFICULTY;

    /**
     * Money that player starts with.
     */
    final double MONEY;

    /**
     * Initial money that play can earn
     */
    final double MONEY_GAINED;

    /**
     * Phase for the game to getting harder
     */
    final int PHASE;

    /**
     * Construct Game difficulty using this constructor
     * @param string Difficulty in String
     * @param money Money that player starts with
     * @param gain Initial money that play can earn
     * @param phase Phase for the game to getting harder
     */
    DifficultyOption(String string, double money, double gain, int phase) {
        this.DIFFICULTY = string;
        this.MONEY = money;
        this.MONEY_GAINED = gain;
        this.PHASE = phase;

    }

    /**
     * A method that returns the standard value of the player's obtainable money
     * @return double value
     */
    public double getMoneyGain() {

        return this.MONEY_GAINED;
    }
    /**
     * get initial money in double for player
     * @return Initial player's money in double
     */
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