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
    
    Team team = null;
    
    private UserInterface userInterface;


	/**
	 * Start new game by setting up Team name, number of weeks for season and difficulty of game
	 */
	public GameEnvironment(UserInterface userInterface) {
		this.userInterface = userInterface;

	}


	public Team getTeam() {
		if (this.team == null) this.team = new Team();

		return this.team;
	}

	public int getSeason() {
		return this.season;
	}

	public void setSeason(int weeks) {

		this.season = weeks;
	}
	
	public void start() {
		userInterface.setup(this);
	}

	public void check(String input, final String REGEX, String message) throws IllegalInputException {

		SetUp setup = new SetUp();
		setup.checkRegex(input, REGEX, message);
	}

	public void check(int input) throws IllegalInputException {


	}
}
