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
    String difficulty;
    
    int season;
    
    Team team = null;
    
    private UserInterface ui;


	/**
	 * Start new game by setting up Team name, number of weeks for season and difficulty of game
	 */
	public GameEnvironment(UserInterface userInterface) {
		this.ui = userInterface;
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

	public String getDifficulty() {

		return this.difficulty;
	}

	public void setDifficulty(String difficulty) {

		this.difficulty = difficulty;
	}
	
	public void start() {
		ui.setup(this);
	}

	public void check(String input, final String REGEX, String message) throws IllegalInputException {

		SetUp setup = new SetUp();
		setup.checkRegex(input, REGEX, message);
	}

	public void check(int input) throws IllegalInputException {


	}
}
