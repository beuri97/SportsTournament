package main;
/**
 * Interface that is used in CmdLineUi, GameEnvironment.
 * @author H Yang, J Kim
 */
public interface UserInterface {

	
	String NAME_CHAR_REQUIREMENT = "Team name cannot include any special character.";
	
	String NAME_LENGTH_REQUIREMENT = "The length of team name has to be between 3 to 15.";

	String NAME_REGEX = "^e[A-Za-z0-9]{3,15}$";

	String SEASON_REGEX = "([3-9]|1[0-5])";
	String VALID_NUMBER = "Please enter a valid number.\nThe number of weeks for the season has to be between 5 to 15.";
	String VALID_DIFFICULTY = "Please enter right number (1 or 2)";
	
//	public String 
	
	void setup(GameEnvironment gameEnvironment);
		
	void exitGame();
	
	void confirmExit();
	
	

}

