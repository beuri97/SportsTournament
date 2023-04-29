package main;

import main.gameObject.Product;
import main.gameObject.Team;
import main.gameObject.athletes.Athlete;
import main.gameObject.item.Item;
import main.gamesystem.DifficultyOption;
import main.gamesystem.Exception.EmptySlotException;
import main.gamesystem.Exception.IllegalInputException;
import main.gamesystem.Exception.NoSpaceException;
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
		this.team = new Team();
		this.team.setName(name);
		this.team.setMoney(difficulty.getMoney());

	}

	/**
	 * get Player's {@link main.gameObject.Team team}. Create new Team if this.team == null
	 * @return player's {@link main.gameObject.Team team}
	 */
	public Team getTeam() {

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


	public void tradingProcess(String type, String stockType, int col) throws RuntimeException {

		Product[] properties = (stockType.equals("-a")) ? team.getRoster() : team.getInventory();
		switch(type) {
			case "buy":
				Product[] stocks = (stockType.equals("-a")) ? market.getAthleteProduct() : market.getItemProduct();
				if(stocks[col] == null) throw new EmptySlotException();
				if(team.isFull(properties)) throw new NoSpaceException();
				team.setMoney(- stocks[col].getPrice());
				Product product = market.purchase(stocks, col);
				if ((product instanceof Athlete)) {
					this.team.recruitAthletes(product);
				} else {
					this.team.addItem(product);
				}

				break;
			case "sell":
				if(properties[col] == null) throw new EmptySlotException();
				Product sale = properties[col];
				team.setMoney(sale.getPrice());
				if(properties[col] instanceof Athlete) team.leaveAthletes(col);
				else team.removeItem(col);
				break;
		}
	}


	public void useItem(int athleteIndex, int itemIndex) {

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

	/**
	 * reset market status and match list when user take a bye
	 */
	public void reset() {
		this.market = new Market();
	}
}
