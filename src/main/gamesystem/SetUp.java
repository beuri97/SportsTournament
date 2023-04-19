package main.gamesystem;

import main.GameEnvironment;

public class SetUp {

    public static void checkRegex(String input, final String REGEX) throws IllegalInputException{

        if(!input.matches(REGEX)) {
            throw new IllegalInputException("ERROR: Invalid Input!");
        }
    }
}
