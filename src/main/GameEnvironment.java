package main;

import main.gameObject.Team;
import main.gamesystem.IllegalInputException;
import main.gamesystem.SetUp;

/**
 * Game Environment which is the core of this program
 *
 * @author H Yang, J Kim
 */
public class GameEnvironment {
    /**
     * TODO- Discuss about constants' nad variables' type, generate javadoc comment
     */
    public final Object DIFFICULTY = null;
    
    int season;
    
    public Team team = new Team();
    
    private UserInterface userInterface;

	/**
	 * Start new game by setting up Team name, number of weeks for season and difficulty of game 
	 */
	public GameEnvironment(UserInterface userInterface) {
			this.userInterface = userInterface;
			
	}
	
	public void start() {
		userInterface.setup(this);
	}

	public void check(String input, final String REGEX) throws IllegalInputException {

		SetUp.checkRegex(input, REGEX);
	}
}
