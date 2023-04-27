package main;

import main.gameObject.Product;
import main.gameObject.Team;
import main.gameObject.athletes.Athlete;
import main.gamesystem.DifficultyOption;
import main.gamesystem.Exception.IllegalInputException;
import main.gamesystem.Exception.LackOfMoneyException;
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
	private SetUp setup = new SetUp();

	/**
	 * Start new game by setting up Team name, number of weeks for season and difficulty of game
	 */
	public GameEnvironment(UserInterface userInterface) {
		this.ui = userInterface;
	}

	public void set(String name, int week, DifficultyOption difficulty){
		this.season = week;
		this.difficulty = difficulty;
		Team newTeam = getTeam();
		newTeam.setName(name);
		newTeam.setMoney(difficulty.getMoney());

	}
	/**
	 * get Player's {@link main.gameObject.Team team}. Create new Team if this.team == null
	 * @return player's {@link main.gameObject.Team team}
	 */
	public Team getTeam() {
		if (this.team == null) this.team = new Team();    // maybe need to be removed

		return this.team;
	}

	public Market getMarket(){
		if(this.market == null) this.market = new Market();

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


	public void tradingProcess(String type, Product[] products, int col) throws LackOfMoneyException {

		switch(type) {
			case "buy":
				team.setMoney(- products[col].getPrice());
				Product product = this.market.purchase(products, col);
				if ((product instanceof Athlete)) {
					this.team.recruitAthletes(product);
				} else {
					this.team.addItem(product);
				}
				break;
			case "sell":
				Product sale = products[col];
				team.setMoney(sale.getPrice());
				if(products[col] instanceof Athlete) team.leaveAthletes(sale);
				else team.removeItem(sale);
				break;
		}
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
