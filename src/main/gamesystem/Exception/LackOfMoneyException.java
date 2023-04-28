package main.gamesystem.Exception;


public class LackOfMoneyException extends IllegalArgumentException {

    public LackOfMoneyException() {
        super("ERROR: Not Enough Money.");
    }
}
