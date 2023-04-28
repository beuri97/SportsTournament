package main.gamesystem.Exception;

import org.w3c.dom.ranges.RangeException;

public class NoSpaceException extends IndexOutOfBoundsException{

    public NoSpaceException(){
        super("Warning: Not enough space");
    };

    public NoSpaceException(String message) {

        super("Warning: " + message);
    }
}
