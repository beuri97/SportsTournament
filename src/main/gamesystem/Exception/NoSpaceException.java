package main.gamesystem.Exception;

/**
 * Exception Class to use when arrays or arraylists are out of bound
 * @author H Yang
 */
public class NoSpaceException extends IndexOutOfBoundsException{

    /**
     * Default exception handle with message
     */
    public NoSpaceException(){
        super("Warning: Not enough space");
    };

    /**
     * exception handle with specify message
     * @param message special message to show or announce to player
     */
    public NoSpaceException(String message) {

        super("Warning: " + message);
    }
}
