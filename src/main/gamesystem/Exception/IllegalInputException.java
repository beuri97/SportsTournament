package main.gamesystem.Exception;

public class IllegalInputException extends IllegalStateException{

    public IllegalInputException() {
        super("""
                ERROR: Invalid Input!
                Please do it again.
                """);
    }
    public IllegalInputException(String message) {

        super("ERROR: Invalid Input!\n" + message + "\nPlease do it again.\n");
    }
}
