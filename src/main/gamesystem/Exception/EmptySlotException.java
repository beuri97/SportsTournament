package main.gamesystem.Exception;

public class EmptySlotException extends NullPointerException {

    public EmptySlotException() {

        super("NOTICE: This Slot is Empty!!");
    }
}
