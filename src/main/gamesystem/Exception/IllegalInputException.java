package main.gamesystem.Exception;

public class IllegalInputException extends IllegalStateException{

    public IllegalInputException() {}
    public IllegalInputException(String message) {

        super("ERROR: Invalid Input!\n" + message + "\nPlease do it again.\n");
    }
}
