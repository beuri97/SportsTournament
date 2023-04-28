package main.gamesystem.Exception;

public class EmptySlotException extends IllegalArgumentException {

    public EmptySlotException() {

        super("NOTICE: This Slot is Empty!!");
    }
}
