package main;

import main.gameObject.Opponent;
import main.gameObject.Product;
import main.gameObject.Team;
import main.gameObject.athletes.Athlete;
import main.gameObject.item.Item;
import main.gamesystem.DifficultyOption;
import main.gamesystem.Exception.IllegalInputException;
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
    DifficultyOption difficulty;

	/**
	 * Game season (Weekly)
	 */
	int season;

	/**
	 * Player's {@link main.gameObject.Team team}
	 */
	Team team;

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
	private SetUp setup;

	/**
	 * opponents team for player to play with
	 */
	Team[] opponents;

	/**
	 * Start new game by setting up Team name, number of weeks for season and difficulty of game
	 */
	public GameEnvironment(UserInterface userInterface) {
		this.setup = new SetUp();
		this.ui = userInterface;
	}

	public void set(String name, int week, DifficultyOption difficulty){
		this.season = week;
		this.difficulty = difficulty;
		this.team = new Team();
		this.team.setName(name);
		this.team.setMoney(difficulty.getMoney());
		this.market = new Market();
		this.opponents = new Team[5];
		this.getOpponent();

	}

	/**
	 * get Player's {@link main.gameObject.Team team}. Create new Team if this.team == null
	 * @return player's {@link main.gameObject.Team team}
	 */
	public Team getTeam() {

		return this.team;
	}

	public Market getMarket() {

		return this.market;
	}

	public String getDifficulty() {

		return this.difficulty.toString();
	}

	/**
	 * call setup method in this.ui
	 */
	public void start() {
		this.ui.setup(this);
	}

	/**
	 *
	 * @param type String value indicating whether it is a buy or sell status
	 * @param stockType A value indicating whether the product players want to buy is an athlete or an item.
	 * @param col the stock's index in Market Team Roster or Team inventory.
	 * @throws RuntimeException
	 */
	public void tradingProcess(String type, Product[] stockType, int col) throws RuntimeException {

		setup.tradingManager(team, market, type, stockType, col);
	}

	/**
	 * method to lead system to use item to athletes
	 * @param athleteIndex Player {@link main.gameObject.Team team}'s athletes index in roster
	 * @param itemIndex Player {@link main.gameObject.Team team}'s item index in inventory
	 */
	public void useItem(int athleteIndex, int itemIndex) {

		//get a specific athlete and item from team and make athlete use the item
		Athlete athlete = this.team.getRoster()[athleteIndex];
		Item item = this.team.getInventory()[itemIndex];
		athlete.useItem(item);
	}

	/**
	 * call checkRegex method form class {@link main.gamesystem.SetUp SetUp}
	 * @param input user's input
	 * @param REGEX regular expression to check input's requirement
	 * @param message Error message
	 * @throws IllegalInputException throw this exception if input did not follow its requirement
	 */
	public void check(String input, final String REGEX, String message) throws IllegalInputException {

		this.setup.checkRegex(input, REGEX, message);
	}


	public void getOpponent() {

		Athlete[] temp = new Athlete[7];
		for(int i=0; i<this.opponents.length;i++) {
			this.market.setAthleteProduct(temp);
			this.opponents[i] = new Opponent(temp);
		}
	}

	/**
	 * reset market status and match list when user take a bye
	 */
	public void reset() {
		this.market = new Market();
	}
}
