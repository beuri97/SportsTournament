package main.gamesystem;

import main.gameObject.Product;
import main.gamesystem.Exception.IllegalInputException;

public class SetUp {

    public void checkRegex(String input, final String REGEX, String message) throws IllegalInputException {

        if(!input.matches(REGEX)) {
            throw new IllegalInputException(message);
        }
    }

    public boolean isFull(Product[] products) {

        //array has fixed length so if at least one null in this array this mean becomes array is not full
        for (Product product : products) {
            if (product == null) {
                return false;
            }
        }
        return true;
    }
}
