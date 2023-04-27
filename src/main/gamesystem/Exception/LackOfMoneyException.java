package main.gamesystem.Exception;

import main.gameObject.Product;

public class LackOfMoneyException extends IllegalArgumentException {

    public LackOfMoneyException() {
        super("ERROR: Not Enough Money.");
    }
}
