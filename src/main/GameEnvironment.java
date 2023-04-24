package main;

import main.gameObject.Team;
import main.gamesystem.IllegalInputException;
import main.gamesystem.Market;
import main.gamesystem.SetUp;

/**
 * Game Environment which is the core of this program
 * @author H Yang, J Kim
 */
public class GameEnvironment {
    /**
     * game difficulty
     */
    String difficulty;

	/**
	 * Game season (Weekly)
	 */
	int season;

	/**
	 * Player's {@link main.gameObject.Team team}
	 */
	Team team = null;

	/**
	 * Market
	 */
	private Market market;

	/**
	 * ui that clients are currently running
	 */
	private UserInterface ui;

	/**
	 * setup to check regex or any other requirement
	 */
	private SetUp setup = new SetUp();

	/**
	 * Start new game by setting up Team name, number of weeks for season and difficulty of game
	 */
	public GameEnvironment(UserInterface userInterface) {
		this.ui = userInterface;
	}

	/**
	 * get Player's {@link main.gameObject.Team team}. Create new Team if this.team == null
	 * @return player's {@link main.gameObject.Team team}
	 */
	public Team getTeam() {
		if (this.team == null) this.team = new Team();    // maybe need to be removed

		return this.team;
	}

	/**
	 * Call total weeks of season to run
	 * @return total weeks of season
	 */
	public int getSeason() {
		return this.season;
	}

	/**
	 * set duration of the season
	 * @param weeks total weeks to run
	 */
	public void setSeason(int weeks) {

		this.season = weeks;
	}

	/**
	 * get method to return game's difficulty
	 * @return game's difficulty
	 */
	public String getDifficulty() {

		return this.difficulty;
	}

	/**
	 * set method to set game's difficulty
	 * @param difficulty game difficulty that player chose
	 */
	public void setDifficulty(String difficulty) {

		this.difficulty = difficulty;
	}

	public Market getMarket(){
		if(this.market == null) this.market = new Market();

		return this.market;
	}

	/**
	 * call setup method in this.ui
	 */
	public void start() {
		this.ui.setup(this);
	}

	/**
	 * call checkRegex method form class {@link main.gamesystem.SetUp SetUp}
	 * @param input user's input
	 * @param REGEX regular expression to check input's requirement
	 * @param message Error message
	 * @throws IllegalInputException throw this exception if input did not follow its requirement
	 */
	public void check(String input, final String REGEX, String message) throws IllegalInputException {

		setup.checkRegex(input, REGEX, message);
	}

	/**
	 * reset market status and match list when user take a bye
	 */
	public void reset() {

		this.market = new Market();
	}
}
