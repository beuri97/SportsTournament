package main;

public interface UserInterface {

	
	public String NAME_CHAR_REQUIREMENT = "Team name cannot include any special character.";
	
	public String NAME_LENGTH_REQUIREMENT = "The length of team name has to be between 3 to 15.";

	public String NAME_REGEX = "[^A-Za-z0-9]";
	
	public String VALID_NUMBER = "Please enter a valid number.";
	
	public String TEAMNUMBER_REQUIREMENT = "The number of weeks for the season has to be between 5 to 15.";
	
//	public String 
	
	void setup(GameEnvironment gameEnvironment);
		
	void exitGame();
	
	void confirmExit();
	
	

}

