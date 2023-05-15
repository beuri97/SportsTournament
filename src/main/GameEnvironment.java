package main;

import main.gameObject.Opponent;
import main.gameObject.Product;
import main.gameObject.Team;
import main.gameObject.athletes.Athlete;
import main.gameObject.item.Item;
import main.gamesystem.DifficultyOption;
import main.gamesystem.Exception.EmptySlotException;
import main.gamesystem.Exception.IllegalInputException;
import main.gamesystem.Exception.InsufficientAthleteException;
import main.gamesystem.Exception.NoSpaceException;
import main.gamesystem.GameManager;
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
	 * Game Total Season (Weekly)
	 */
	int totalSeason;

	/**
	 * game current season (in week)
	 */
	int currentSeason;
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
	private Team[] opponents;

	/**
	 * main game system
	 */
	private GameManager gameManager;

	/**
	 * Boolean set true if player play game at least once
	 */
	private boolean played;

	/**
	 * Start new game by setting up Team name, number of weeks for season and difficulty of game
	 */
	public GameEnvironment(UserInterface userInterface) {
		this.setup = new SetUp();
		this.ui = userInterface;
	}

	public void set(String name, int week, DifficultyOption difficulty){
		this.totalSeason = week;
		this.currentSeason = 1;
		this.difficulty = difficulty;
		this.team = new Team();
		this.team.setName(name);
		this.team.setMoney(difficulty.getMoney());
		this.market = new Market();
		this.opponents = new Team[5];
		this.setOpponent();

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

	public DifficultyOption getDifficulty() {

		return this.difficulty;
	}


	public int getCurrentSeason() {

		return this.currentSeason;
	}


	public int getTotalSeason() {

		return this.totalSeason;
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
	 * @throws RuntimeException Throws No Space Exception Empty slot Exception
	 */
	public void tradingProcess(String type, Product[] stockType, int col) throws RuntimeException {

		// setup.tradingManager(team, market, type, stockType, col);
		switch(type) {
			case "buy":
				Product[] properties = (stockType instanceof Athlete[]) ? this.team.getRoster() : this.team.getInventory();
				if(stockType[col] == null) throw new EmptySlotException();
				if(this.team.isFull(properties)) throw new NoSpaceException();
				this.team.setMoney(- stockType[col].getPrice());
				Product product = this.market.purchase(stockType, col);
				if (product instanceof Athlete) {
					this.team.recruitAthletes(product);
				} else {
					this.team.addItem(product);
				}
				break;

			case "sell":
				if(stockType[col] == null) throw new EmptySlotException();
				Product sale = stockType[col];
				this.team.setMoney(sale.getPrice());
				if(stockType[col] instanceof Athlete) this.team.leaveAthletes(col);
				else this.team.removeItem(col);
				break;
		}
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
	 * @param message String for error message
	 * @throws IllegalInputException throw this exception if input did not follow its requirement
	 */
	public void check(String input, final String REGEX, String message) throws IllegalInputException {

		this.setup.checkRegex(input, REGEX, message);
	}

	public void swap(int athlete1, int athlete2) {

		team.swapAthletes(athlete1, athlete2);
	}


	public void setOpponent() {

		Athlete[] temp = new Athlete[7];
		for(int i=0; i<this.opponents.length;i++) {
			this.market.setAthleteProduct(temp);
			this.opponents[i] = new Opponent(temp);
		}
	}


	public Team[] getAllOpponent() {

		return this.opponents;
	}

	/**
	 * main Game start from here
	 *
	 * @param index opponent index of this.opponents,
	 */
	public void gameStart(int index) {

		Team opponent = this.opponents[index];
		this.opponents[index] = null;
		this.played = true;
		this.gameManager = new GameManager(this, opponent, difficulty);
	}

	public boolean isGame() {

		return gameManager.isGame();
	}

	public boolean isSet() {

		return gameManager.isSet();
	}

	public void isPlayable() throws InsufficientAthleteException {

		this.getTeam().isQualify();
	}

	public boolean isPlayed() {

		return this.played;
	}

	public Team getOpponent() {

		return gameManager.getOpponent();
	}


	public void buffOffensive() {
		this.gameManager.setOffensiveAdjust(0);
		this.gameManager.setDefensiveAdjust(1);
	}

	public void buffDefensive() {

		this.gameManager.setDefensiveAdjust(0);
		this.gameManager.setOffensiveAdjust(1);
	}

	public void battleSequences() {
		//TODO - check if athlete is injured
		this.gameManager.battle();

	}

	public String getBattleMessage() {

		return gameManager.battleMessage();
	}

	public int[] matchResult() {

		int playerScore = gameManager.getPlayerGameScore();
		int opponentScore = gameManager.getOpponentGameScore();
		return new int[] {playerScore, opponentScore};
	}

	public int[] getPlayerOverall() {

		int playerWin = team.getGameWin();
		int totalPlayerPlay = team.getTotalGamePlay();
		return new int[] {playerWin, totalPlayerPlay};
	}

	/**
	 * reset market status and match list when user take a bye
	 */
	public void reset() {

		this.played = false;
		this.market = new Market();
		this.setOpponent();
		Athlete[] roster = this.getTeam().getRoster();
		for(int i = 0; i < roster.length; i++){


			if (setup.isLeave(3.00)) team.leaveAthletes(i);
			this.getTeam().getRoster()[i].setStamina(roster[i].getMaxStamina());
		}
		// TODO - Athlete Random events
	}
}
