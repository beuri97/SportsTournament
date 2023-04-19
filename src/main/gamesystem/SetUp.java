package main.gamesystem;

import main.GameEnvironment;

public class SetUp {

    public void checkRegex(String input, final String REGEX, String message) throws IllegalInputException{

        if(!input.matches(REGEX)) {
            throw new IllegalInputException(message);
        }
    }
}
