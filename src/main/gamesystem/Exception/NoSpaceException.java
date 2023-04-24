package main.gamesystem.Exception;

public class NoSpaceException extends IndexOutOfBoundsException{

    public NoSpaceException(){
        super("Warning: Not enough space");
    };

    public NoSpaceException(String message) {

        super("Warning: " + message);
    }
}
