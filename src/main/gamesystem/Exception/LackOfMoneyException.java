package main.gamesystem.Exception;

/**
 * Exception class to use when player does not have enough money
 * @author H Yang
 */
public class LackOfMoneyException extends IllegalArgumentException {

    /**
     * Default exception handle with message
     */
    public LackOfMoneyException() {
        super("ERROR: Not Enough Money.");
    }
}
