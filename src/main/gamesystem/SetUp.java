package main.gamesystem;

import main.gamesystem.Exception.IllegalInputException;

public class SetUp {

    public void checkRegex(String input, final String REGEX, String message) throws IllegalInputException {

        if(!input.matches(REGEX)) {
            throw new IllegalInputException(message);
        }
    }
}
