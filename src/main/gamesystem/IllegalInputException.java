package main.gamesystem;

public class IllegalInputException extends IllegalStateException{

    IllegalInputException() {}
    IllegalInputException(String message) {

        super(message);
    }
}
