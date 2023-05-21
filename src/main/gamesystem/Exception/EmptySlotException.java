package main.gamesystem.Exception;

/**
 * Exception class when user interaction with Empty slot
 * @author H Yang
 */
public class EmptySlotException extends IllegalArgumentException {

    /**
     * Default exception handle with message
     */
    public EmptySlotException() {

        super("NOTICE: This Slot is Empty!!");
    }
}
