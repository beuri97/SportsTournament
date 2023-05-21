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
import main.gui.GameOverGui;
import main.gui.ImprovingAthleteGui;
import main.gui.MainScreenGui;
import main.gui.MarketGui;
import main.gui.SelectOpponentGui;
import main.gui.SetupWindowGui;
import main.gui.StadiumGui;
import main.gamesystem.GameManager;
import main.gamesystem.Market;
import main.gamesystem.SetUp;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

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

	/**
	 * method for initial setup at the beginning of this program to play
	 * @param name player's Team name
	 * @param week total week that player wants to play
	 * @param difficulty difficulty of this program(game) that player wants to play
	 */
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

	/**
	 * get entire market system / information
	 * @return market data of each week
	 */
	public Market getMarket() {

		return this.market;
	}

	/**
	 * get player's difficulty data/information
	 * @return entire difficulty data as enum class
	 */
	public DifficultyOption getDifficulty() {

		return this.difficulty;
	}

	/**
	 * get week info that player is currently on
	 * @return integer value about players current week
	 */
	public int getCurrentSeason() {

		return this.currentSeason;
	}

	/**
	 * get total week of season player select at the beginning setup
	 * @return int value about players total week of season
	 */
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
	 * processing method about trading method
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
				if(this.team.isFull()) throw new NoSpaceException();
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
				if(stockType[col] instanceof Athlete) this.team.leaveAthletes(stockType[col]);
				else this.team.removeItem(sale);
				break;
		}
	}

	/**
	 * method to lead system to use item to athletes
	 * @param athleteIndex Player {@link main.gameObject.Team team's} athletes index in roster
	 * @param itemIndex Player {@link main.gameObject.Team team's} item index in inventory
	 */
	public void useItem(int athleteIndex, int itemIndex) {

		//get a specific athlete and item from team and make athlete use the item
		Athlete athlete = this.team.getRoster()[athleteIndex];
		Item item = this.team.getInventory()[itemIndex];
		athlete.useItem(item);
		team.removeItem(item);
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

	/**
	 * method that lead to swapAthletes method in class Team to swap two athletes
	 * @param athlete1 athlete's index user wants to swap
	 * @param athlete2 athlete's index user wants to swap
	 */
	public void swap(int athlete1, int athlete2) {

		team.swapAthletes(athlete1, athlete2);
	}

	/**
	 * Create opponents and add the opponent to opponents array.
	 */
	public void setOpponent() {

		Athlete[] temp = new Athlete[4];
		for(int i=0; i<this.opponents.length;i++) {
			this.market.setAthleteProduct(temp);
			this.opponents[i] = new Opponent(temp);
		}
	}

	/**
	 * get all opponents in array
	 * @return opponents array is Team array
	 */
	public Team[] getAllOpponent() {

		return this.opponents;
	}

	/**
	 * main Game start from here
	 * @param index opponent index of this.opponents,
	 */
	public void gameStart(int index) {

		Team opponent = this.opponents[index];
		this.opponents[index] = null;
		this.played = true;
		this.team.setTotalGamePlay();
		this.gameManager = new GameManager(this, opponent, difficulty);
	}

	/**
	 * method to get result about the match is all done by its condition
	 * @return boolean value about match is game
	 */
	public boolean isGame() {

		return gameManager.isGame();
	}

	/**
	 * method to get result about each set of match is finish
	 * @return boolean value about the game is set
	 */
	public boolean isSet() {

		return gameManager.isSet();
	}

	/**
	 * check player's team is qualify to have match
	 * @throws InsufficientAthleteException occurs when injured athlete is in regular position or team does not have
	 * enough athletes to play
	 */
	public void isPlayable() throws InsufficientAthleteException {

		this.getTeam().isQualify();
	}

	/**
	 * method to check if player played at least once per each week
	 * @return boolean value and value is true if player played match at lest once
	 */
	public boolean isPlayed() {

		return this.played;
	}

	/**
	 * get opponent team information from {@link GameManager}
	 * @return opponent team that player play against with
	 */
	public Team getOpponent() {

		return gameManager.getOpponent();
	}

	/**
	 * A method that connects a player to a method that can return the range of offensive and defensive stat corrections
	 * that an athlete's can receive during the game.
	 * @return integer values about athletes' range of offensive and defensive stat corrections in 2D array
	 */
	public int[][] getAdjustedStats() {

		return gameManager.getAdjustedStat();
	}

	/**
	 * method to lead system to adjusting athletes stats range during game
	 * this method will introduce how athletes' offense stats will be buffed
	 * and how athlete's defense stats will be nerfed
	 */
	public void buffOffensive() {
		this.gameManager.setOffensiveAdjust(0);
		this.gameManager.setDefensiveAdjust(1);
	}

	/**
	 * method to lead system to adjusting athletes stats range during game
	 * this method will introduce how athletes' defense stats will be buffed
	 * and how athlete's offense stats will be nerfed
	 */
	public void buffDefensive() {

		this.gameManager.setDefensiveAdjust(0);
		this.gameManager.setOffensiveAdjust(1);
	}

	/**
	 *  call actual battle sequence
	 */
	public void battleSequences() {

		this.gameManager.battle();

	}

	/**
	 * get message about each fight result
	 * @return String value about fighting result about each fight
	 */
	public String getBattleMessage() {

		return gameManager.battleMessage();
	}

	/**
	 * get match set number
	 * @return integer value about current set of the match
	 */
	public int getGameSetNumber() {

		return gameManager.getSetNumber();
	}

	/**
	 *get player's and opponent's game score from gameManager
	 * @return integer values about player's game score and opponents' game score in integer array
	 */
	public int[] matchResult() {

		int playerScore = gameManager.getPlayerGameScore();
		int opponentScore = gameManager.getOpponentGameScore();
		if(playerScore > opponentScore) this.team.setGameWin();
		return new int[] {playerScore, opponentScore};
	}

	/**
	 * give information that is about match result to UserInterface
	 * @return integer values about player's number of win and player's total played in integer array
	 */
	public int[] getPlayerOverall() {

		int playerWin = team.getGameWin();
		int totalPlayerPlay = team.getTotalGamePlay();
		return new int[] {playerWin, totalPlayerPlay};
	}

	/**
	 * reduce athlete stamina
	 * @param money money that player earned after match
	 * @param lose value should be true if player lose the game.
	 */
	public void closingGame(double money, boolean lose) {

		team.setMoney(money);
		setup.reducedStamina(getTeam().getRoster(), lose);
	}

	/**
	 * reset market status and match list when user take a bye
	 */
	public void reset() {

		this.played = false;
		this.market = new Market();
		this.setOpponent();
		currentSeason++;
	}

	/**
	 * random event method for athletes leave event if athlete is injured
	 * @return arraylist with added players where the event occurred
	 */
	public ArrayList<Athlete> randomLeaveEvent() {

		ArrayList<Athlete> result = new ArrayList<>();

		for(Athlete athlete : this.getTeam().getRoster()){

			//although Team getRoster method returns array it still works since the type is actually arraylist.
			if (athlete == null) { break; }

			else if (!setup.event(3.00) && !athlete.isInjured()) athlete.setStamina(athlete.getMaxStamina());

			else {
				result.add(athlete);
				team.leaveAthletes(athlete);
			}
		}

		//return null if no events occurs
		if(result.size() == 0) result = null;
		return result;
	}

	/**
	 * Random event method for upgrade athletes stats
	 * @return arraylist with added players where the event occurred
	 */
	public ArrayList<Athlete> randomUpgradeEvent() {

		ArrayList<Athlete> result = new ArrayList<>();

		for (Athlete athlete : this.getTeam().getRoster()){

			if(setup.event(70.00) && athlete != null) {
				// add event occurred athletes to report
				result.add(athlete);
				athlete.setOffenseStat(SetUp.randomInt(3));
				athlete.setDefenseStat(SetUp.randomInt(3));
				athlete.setMaxStamina(SetUp.randomInt(8));
				athlete.setStamina(athlete.getMaxStamina());
			}
		}

		if (result.size() == 0) result = null;
		return result;
	}

	/**
	 * Random Event method for join an athlete randomly
	 * @return true if a new athlete is joined to players team
	 */
	public boolean randomNewAthlete() {

		boolean result = false;
		if (setup.event(70.50) && !this.getTeam().isFull()) {

			this.team.recruitAthletes(market.athleteBuilder());
			result = true;
		}

		return result;
	}

	/**
	 *open GUI Main Window
	 */
	public void openMainWindow() {
		ui = new MainScreenGui(this);
	}
	/**
	 *open GUI Market Window
	 */
	public void openMarketWindow() {
		ui = new MarketGui(this);
	}
	/**
	 *open GUI Opponent selecting Window
	 */
	public void openSelectingOpponent() {
		ui = new SelectOpponentGui(this);
	}
	/**
	 *open GUI Stadium Window
	 */
	public void openStatiumWindow() {
		ui = new StadiumGui(this);
	}
	/**
	 *open GUI GameOver Window
	 */
	public void openGameOverWindow() {
		ui = new GameOverGui(this);
	}

	/**
	 *open GUI Improving Athlete Window
	 */
	public void openImprovingWindow() {
		ui = new ImprovingAthleteGui(this);
	}

	/**
	 *close GUI Setup Window
	 */
	public void closeSetupWindow(SetupWindowGui setupWindow) {
		setupWindow.closeWindow();
	}
	/**
	 *close GUI Main Window
	 */
	public void closeMainWindow(MainScreenGui mainWindow) {
		mainWindow.closeWindow();
	}
	/**
	 *close GUI Market Window
	 */
	public void closeMarketWindow(MarketGui marketWindow) {
		marketWindow.closeWindow();
	}
	/**
	 *close GUI Opponent selecting Window
	 */
	public void closeSelectingOpponent(SelectOpponentGui selectOpponentWindow) {
		selectOpponentWindow.closeWindow();
	}
	/**
	 *close GUI Stadium Window
	 */
	public void closeStatiumWindow(StadiumGui stadiumWindow) {
		stadiumWindow.closeWindow();
	}

	/**
	 *close GUI Improving Athlete Window
	 */
	public void closeImprovingWindow(ImprovingAthleteGui ImprovingWindow) {
		ImprovingWindow.closeWindow();
	}
}
