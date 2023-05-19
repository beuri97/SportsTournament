package main;

import main.gameObject.Product;
import main.gameObject.Team;
import main.gamesystem.DifficultyOption;
import main.gamesystem.Exception.EmptySlotException;
import main.gamesystem.Exception.IllegalInputException;
import main.gamesystem.Exception.InsufficientAthleteException;
import main.gamesystem.Market;

import java.util.Arrays;
import java.util.Scanner;

/**
 * class for Command line User Interface.
 * @author H Yang, J Kim
 */
public class CmdLineUi implements UserInterface {

	private final Scanner scan;

	private GameEnvironment gameEnvironment;

	enum Option {

		INFO("info - Show current game status briefly"),
		MARKET( "market - Market to purchase, sell athletes or items"),
		STADIUM("stadium - Play Game!"),
		TEAM("team - Manage Team Here"),
		EXIT("exit - Terminate this game");
		final String DESCRIPTION;

		Option(String description) {
			this.DESCRIPTION = description;
		}

		public String toString() {

			return this.DESCRIPTION;
		}
	}

	enum MarketOption {
		USAGE("""
				usage
				\tbuy -a [1-6]|-i [1-8]
				\tsell -a [1-7]|-i ([1-9]|10)
				\texit"""),
		BUY("""
				buy - show Market stock to athletes or items
				\toption
				\t\t-a\tshow purchasable athlete. purchasing process will be proceed if input number is exist and valid
				\t\t-i\tshow purchasable items. purchasing process will be proceed if input number is exist and valid"""),
		SELL("""
				sell - show Team Roster and inventory to sell athletes or items
				\toption
				\t\t-a\tshow sellable. athlete selling process will be proceed if input number is exist and valid
				\t\t-i\tshow sellable. items selling process will be proceed if input number is exist and valid"""),
		EXIT("exit - exit market");

		final String DESCRIPTION;

		MarketOption(String string) {

			this.DESCRIPTION = string;
		}

		public String toString() {

			return this.DESCRIPTION;
		}
	}


	enum TeamManageOption {
		USAGE("""
				usage
				\tshow|exit
				\tuse ([1-9]|1[0-4])
				\tswap [1-7] to [1-7]
				\texit
				"""),
		SHOW("""
				show - show athlete roster and item inventory
				"""),
		USE("""
				use - command to use item to athlete
				\toption
				\t\tnumber - 1 to 14 which is inventory index number(cardinal)
				\t\t\t if number is valid athlete roster will be printed and play choose number to select athlete
				"""),
		SWAP("""
				swap - swap athletes' order
				\toption
				\t\t[1-7] to [1-7] - index number represent athletes' order
				"""),
		EXIT("""
				exit - exit team manager
				""");

		final String DESCRIPTION;

		TeamManageOption(String description) {
			this.DESCRIPTION = description;
		}

		public String toString() {

			return this.DESCRIPTION;
		}
	}

	/**
	 * Class constructor to construct scanner
	 */
	public CmdLineUi() {
		this.scan = new Scanner(System.in);
	}

	/**
	 * initial game environment setup
	 * @param gameEnvironment game environment which is core of this program
	 */
	public void setup(GameEnvironment gameEnvironment) {
		this.gameEnvironment = gameEnvironment;

		//Welcoming~~~
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("|||||||        SPORTS TOURNAMENT        |||||||");
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println();

		//setup sequence
		String name = this.setTeamName();
		int week = this.setWeeksForSeason();
		DifficultyOption difficulty = this.setDifficulty();
		//send setup info to gameEnvironment
		this.gameEnvironment.set(name, week, difficulty);
		//start main program
		this.main();
	}

	/**
	 * set up player's team name. only accept the letter lengths between 3 and 15(inclusive)
	 * doesn't allow to have special characters and.
	 */
	public String setTeamName() {

		System.out.println("Please choose your team name");
		//iterate until input is valid
		while (true) {
			String input = scan.nextLine();
			try {
				// check input is valid catch exception if input is invalid
				gameEnvironment.check(input, NAME_REGEX, NAME_CHAR_REQUIREMENT);
				// print feedback to player
				System.out.println("Awesome! Your team name is " + input);
				return input;

			} catch (IllegalInputException e) {
				// print err message
				System.out.println(e.getMessage());
				if (input.length() > 15 || input.length() < 3) System.out.println(NAME_LENGTH_REQUIREMENT);
			}
		}
	}

	/**
	 * set up number of weeks for season of the game between 5 and 15 (inclusive).
	 */
	private int setWeeksForSeason() {

		System.out.println("Please choose the number of weeks for the season of the game");
		System.out.println("Minimum is 5 weeks and Maximum is 15 weeks");
		while (true) {
			String input = scan.nextLine();
			try {
				// Check input requirement
				gameEnvironment.check(input, SEASON_REGEX, VALID_NUMBER);
				// give feedback to user
				System.out.printf("The game season set %s weeks long%n", input);

				// parse input to integer and send input to gameEnvironment
				return Integer.parseInt(input);

			} catch (IllegalInputException iie) {

				// catch any wrong input requirement
				System.out.println(iie.getMessage());
			}

		}
	}

	/**
	 * set up the difficulty of the game between easy and difficult
	 */
	private DifficultyOption setDifficulty() {
		//get array of difficulty options before system start
		DifficultyOption[] options = DifficultyOption.values();
		//main system starts here
		while (true) {
			System.out.println("Choose the number of difficulty of the game level.");
			this.listing(options);
			System.out.println("Your Option(Choose Number 1 or 2): ");
			String input = scan.nextLine();
			try {
				//check input requirement if not this throws exception
				gameEnvironment.check(input, "(1|2)", INVALID_NUMBER);

				//set difficulty option if input requirement is met
				switch (input) {
					case "1" -> { return options[0]; }
					case "2" -> { return options[1]; }
				}

				// give feedback to user
				System.out.printf("Difficulty set: %s%n", options[Integer.parseInt(input) - 1].toString());

			} catch (IllegalInputException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	/**
	 * Main Menu CommandLine Interfaces
	 */
	public void main() {
		//get main option value
		Option[] option = Option.values();
		getInfo();
		while(true) {
			try {
				System.out.println("Please input command here");
				System.out.println("input \"help\" for more information");
				String input = scan.nextLine();

				// check input option Exception throws if input requirement is not met
				switch (input) {
					case "help" -> listing(option);
					case "exit" -> confirmExit();
					case "market" -> marketSystem();
					case "info" -> getInfo();
					case "team" -> teamInfoSystem();
					case "stadium" -> stadium();
					case "bye" -> takeBye();
					default -> throw new IllegalInputException();
				}
			}catch (IllegalInputException e) {

				System.out.println(e.getMessage());
			}

		}

	}

	private void getInfo() {
		//get Team's(player's) Info
		Team player = gameEnvironment.getTeam();
		System.out.printf("\nYour Team Name: %s%n", player.getName());
		System.out.println("Current week: ");
		System.out.printf("Money: $ %.2f%n", player.getMoney());
		System.out.printf("Difficulty: %s%n", gameEnvironment.getDifficulty());
	}

	/**
	 * method to recruit athletes
	 */
	private void marketSystem() {
		MarketOption[] option = MarketOption.values();
		Market market = gameEnvironment.getMarket();
		Team player = gameEnvironment.getTeam();

		//Welcoming~
		System.out.println("\nWelcome to Trading Market!");
		while(true) {
			System.out.printf("Your Money: $ %.2f%n", player.getMoney());
			System.out.println("input command here\ninput \"help\" for more information.");
			System.out.println("WARNING: There is no double-checking so decide carefully.");
			String input = scan.nextLine();
			try {

				// Market has 6 athletes stocks 8 items stocks, Team can have 7 athletes and 8 items as maximum
				// if this preference is changed regex need to be fixed
				// if input requirement is not met exception will be thrown
				gameEnvironment.check(input, "exit|help|buy ((-a|-i)|(-a [1-6]|-i [1-8]))|sell ((-a|-i)|(-a [1-7]|-i ([1-9]|10)))",
						null);

				//split command input value
				String[] str = input.split(" ");

				//terminate while loop to get out the market
				if(input.equals("exit")) break;

					// else check command input player get help to input command
				else if (input.equals("help")) {
					System.out.println(option[0]);
					//since we already print first index we need to discard index 0
					listing(Arrays.copyOfRange(option, 1, option.length));
				}
				// provide market athlete stocks to player
				else if (input.equals("buy -a")) listing(market.getAthleteProduct());
				// provide market Item stocks to player
				else if (input.equals("buy -i")) listing(market.getItemProduct());
				// provide Team Athlete roster to player
				else if(input.equals("sell -a")) listing(player.getRoster());
				// provide Team Inventory to player
				else if(input.equals("sell -i")) listing(player.getInventory());
				// provide purchase sequence to player
				else if (input.matches("buy (-a [1-6]|-i [1-8])")){
					int col = Integer.parseInt(str[2]) - 1;
					Product[] stocks = (str[1].equals("-a")) ? market.getAthleteProduct() : market.getItemProduct();
					gameEnvironment.tradingProcess(str[0], stocks, col);
				}
				// provide sell sequence to player
				else if(input.matches("sell (-a [1-7]|-i ([1-9]|10))")) {
					int col = Integer.parseInt(str[2]) - 1;
					Product[] stocks = (str[1].equals("-a")) ? player.getRoster() : player.getInventory();
					gameEnvironment.tradingProcess(str[0], stocks, col);
				}

			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private void teamInfoSystem() {

		while(true) {
			this.getInfo();
			TeamManageOption[] option = TeamManageOption.values();
			Team player = gameEnvironment.getTeam();
			System.out.println("\nInput command to manage your Team below");
			String input = scan.nextLine();
			try {
				// break loop and exit team manager System
				if(input.equals("exit")) break;
				else if(input.equals("help")) {
					System.out.println(option[0]);
					this.listing(Arrays.copyOfRange(option, 1, option.length));
				} else if(input.equals("show")) {
					// define how many athlete
					final int REGULAR_NUMBER = 4;
					// print regular athletes
					System.out.println("Roster\n\nRegular");
					this.listing(Arrays.copyOfRange(player.getRoster(),0, REGULAR_NUMBER));
					// print reserve athletes
					System.out.println("\nReserve");
					this.listing(Arrays.copyOfRange(player.getRoster(), REGULAR_NUMBER, player.getRoster().length));
					// print item inventory
					System.out.println("\nInventory");
					this.listing(player.getInventory());
				}
				// command for use item to athlete
				else if (input.matches("^use ([1-9]|10)")) {

					int itemIndex = Integer.parseInt(input.split(" ")[1]) -1;
					System.out.println("\n Select athlete to apply. Input \"cancel\" to cancel process.");
					String temp = scan.nextLine();
					//check input requirement
					if(!temp.matches("^[1-7]")) throw new IllegalInputException();
					else if (temp.equals("cancel"))
						//ignore use command
						continue;

					int athleteIndex = Integer.parseInt(temp) -1;
					gameEnvironment.useItem(athleteIndex, itemIndex);
				} else if (input.matches("^swap [1-7] to [1-7]")) {
					String[] str = input.split(" ");
					int athlete1 = Integer.parseInt(str[1]) -1;
					int athlete2 = Integer.parseInt(str[3]) -1;
					gameEnvironment.swap(athlete1, athlete2);
				} else throw new IllegalInputException();

			} catch (IllegalInputException e) {
				System.out.println(e.getMessage());
			}
		}
	}


	private void stadium() {

		final String REGEX = String.format("[1-%d]", gameEnvironment.getAllOpponent().length);
		while(true) {
			try {
				this.gameEnvironment.isPlayable();
				System.out.println("Select opponent:");
				listing(gameEnvironment.getAllOpponent());
				String input = scan.nextLine();
				gameEnvironment.check(input, REGEX, "");
				this.actualGame(Integer.parseInt(input) - 1);
				break;
			} catch(IllegalInputException | EmptySlotException e) {
				System.out.println(e.getMessage());
			} catch(InsufficientAthleteException iae) {
				System.out.println(iae.getMessage());
				break;
			}
		}
	}

	/**
	 * Actual match sequence method in CLI.
	 * @param index index of gameEnvironment.opponents array to get specific opponent
	 */
	private void actualGame(int index) {

		gameEnvironment.gameStart(index);
		int i = 0;
		System.out.println("Match start!!");
		System.out.println("\nYour Regular Athlete Roster");
		listing(Arrays.copyOfRange(gameEnvironment.getTeam().getRoster(), 0, 4));
		System.out.println("\nOpponent Regular Roster: ");
		listing(Arrays.copyOfRange(gameEnvironment.getOpponent().getRoster(), 0, 4));
		System.out.println("Game Start!!");

		while (!gameEnvironment.isGame()) {

			System.out.println("\nYour athlete on the stadium\n");
			System.out.println(gameEnvironment.getTeam().getRoster()[i]);
			System.out.println("\nOpponent athlete on the stadium\n");
			System.out.println(gameEnvironment.getOpponent().getRoster()[i]);

			do {
				System.out.println("Order to your Athlete:");
				System.out.println("You have follow option");
				System.out.println("1. Choose either aggressive, careful, or skip this command pressing enter");
				System.out.println("Then athlete will battle");
				try{
					String input = scan.nextLine();
					if (input.equals("aggressive"))
						gameEnvironment.buffOffensive();
					else if (input.equals("careful"))
						gameEnvironment.buffDefensive();
					else if (input.equals(""))
						System.out.println();
					else throw new IllegalInputException();

					System.out.println("Battle Start!");
					gameEnvironment.battleSequences();
					String message = gameEnvironment.getBattleMessage();
					System.out.println(message);
				} catch (IllegalInputException e) {
					System.out.println(e.getMessage());
				}
			} while(!gameEnvironment.isSet());
		}
		this.gameResult();
	}


	private void takeBye() {

		if(this.gameEnvironment.isPlayed()) {
			System.out.println("See you next week!");
			this.gameEnvironment.reset();
		}else {
			System.out.println("You did not have any match in this week");
			System.out.println("Are you sure you want to finish this season?(Y|n)");
			String input = scan.nextLine();
			try{
				switch (input) {

					case "Y":
						this.declareGameOver();
						break;

					case "n":
					case "N":
						System.out.println();
						break;
					default:
						throw new IllegalInputException();

				}

			}catch (IllegalInputException e) {
				System.out.println(e.getMessage());
			}

		}
	}


	private void declareGameOver() {

		int lastSeason = gameEnvironment.getCurrentSeason();
		int totalSeason = gameEnvironment.getTotalSeason();
		int[] playerOverall = gameEnvironment.getPlayerOverall();

		System.out.println("GAME OVER");
		System.out.printf("You played %d week(s) out of %d seeks%n", lastSeason, totalSeason);
		System.out.println("Your game Summary:");
		System.out.printf("Your game difficulty was %s%n", gameEnvironment.getDifficulty());
		System.out.printf("You Played %d you won %d%n", playerOverall[1], playerOverall[0]);
		System.out.printf("Your percentage of victory is %.2f%n", (float)(playerOverall[0]/playerOverall[1])*100);

		System.out.println("Thank You For Playing!!!");
		System.exit(0);
	}


	/**
	 * print options with cardinal number
	 * @param array array to print option
	 */
	private void listing(Object[] array) {

		for (int i = 1; i <= array.length; i++) {
			System.out.printf("%d. %s%n", i, (array[i - 1] == null) ? "EMPTY\n" : array[i - 1]);
		}
	}

	private void gameResult() {
		int[] result = gameEnvironment.matchResult();
		int playerScore = result[0];
		int opponentScore = result[1];
		String message;
		double money;
		System.out.printf("Your Score: %d%nOpponent Score: %s%n", playerScore, opponentScore);

		if (playerScore > opponentScore) {
			message = "YOU WIN\n";
			money = gameEnvironment.getDifficulty().getMoneyGain() * 1.5;
			message += String.format("MONEY GAIN: %.2f", money);

		}
		else if (playerScore < opponentScore) {
			message = "YOU LOSE\n";
			money = gameEnvironment.getDifficulty().getMoneyGain() * 0.7;
			message += String.format("MONEY GAIN: %.2f", money);
		}
		else {
			message = "DRAW";
			money = gameEnvironment.getDifficulty().getMoneyGain();
			message += String.format("MONEY GAIN: %.2f", money);
		}
		boolean phase = message.contains("YOU LOSE");
		System.out.println(message);
		gameEnvironment.setAthletesStamina(phase);
	}

	/**
	 * method to double-check commend exit to terminate this program entirely
	 * @throws IllegalInputException if input is not "Y" or "n" (case is sensitive) error occurs
	 */
	private void confirmExit() throws IllegalInputException {
		// double-checking before exit entire program
		// "Y" input is case-sensitive
		// if input is neither "Y" nor "n" then method throws Exception
		System.out.println("Exit this game?(Y|n)");
		String input = scan.nextLine();
		switch(input) {
			case "Y" -> {
				System.out.println("GOOD-GYE!!!");
				System.exit(0);
			}
			case "n" -> System.out.println();
			default -> throw new IllegalInputException();
		}
	}
}