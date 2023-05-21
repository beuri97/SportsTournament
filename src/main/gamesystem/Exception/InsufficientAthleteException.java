package main.gamesystem.Exception;

/**
 * Exception Class to use when player's teams does not have enough athlete to have a match
 * @author H Yang
 */
public class InsufficientAthleteException extends RuntimeException{

    /**
     * Default exception handle with message
     */
    public InsufficientAthleteException() {

        super("FATAL: You do not have enough athletes. Recurit athletes at market.");
    }

    /**
     * exception handle with specify message
     * @param message special message to show or announce to player
     */
    public InsufficientAthleteException(String message) {

        super("FATAL: " + message);
    }
}
