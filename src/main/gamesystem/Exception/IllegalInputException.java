package main.gamesystem.Exception;

/**
 *  Exception class to use when user send input that is not meets requirement.
 *  @author H Yang
 */
public class IllegalInputException extends IllegalStateException{

    /**
     * Default exception handle with message
     */
    public IllegalInputException() {
        super("""
                ERROR: Invalid Input!
                Please do it again.
                """);
    }

    /**
     * exception handle with specify message
     * @param message special message to show or announce to player
     */
    public IllegalInputException(String message) {

        super("ERROR: Invalid Input!\n" + message + "\nPlease do it again.\n");
    }
}
