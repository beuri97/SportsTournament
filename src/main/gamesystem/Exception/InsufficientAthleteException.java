package main.gamesystem.Exception;

public class InsufficientAthleteException extends RuntimeException{

    public InsufficientAthleteException() {

        super("FATAL: You do not have enough athletes. Recurit athletes at market.");
    }
}
