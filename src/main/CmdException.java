package main;

public class CmdException extends IllegalStateException{
	public CmdException() {}
	public CmdException(String message) {
		super(message);
	}

}
