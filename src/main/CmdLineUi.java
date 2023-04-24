package main;

import main.gameObject.Product;
import main.gamesystem.Exception.DifficultyOption;
import main.gamesystem.Exception.IllegalInputException;

import java.util.Scanner;

/**
 * class for Command line User Interface.
 * @author H Yang, J Kim
 */
public class CmdLineUi implements UserInterface {

	private final Scanner scan;

	private GameEnvironment gameEnvironment;

	private enum MainOption {

		MARKET( "market", "Market to purchase, sell athletes or items"),
		STADIUM("stadium", "Play Game!"),
		TEAM("team", "Manage Team Here"),
		SETUP("setup", "Configure Game Option"),
		EXIT("exit", "Terminate this game");

		final String COMMAND;
		final String DESCRIPTION;

		MainOption(String command, String description) {
			this.COMMAND = command;
			this.DESCRIPTION = description;
		}

		public String toString() {

			return String.format("%s    %s",this.COMMAND, this.DESCRIPTION);
		}
	}

	public CmdLineUi() {
		this.scan = new Scanner(System.in);
	}

	/**
	 * initial game environment setup
	 *
	 * @param gameEnvironment game environment which is core of this program
	 */
	public void setup(GameEnvironment gameEnvironment) {
		this.gameEnvironment = gameEnvironment;

		//Welcoming~~~
		System.out.println("|||||||||||||||||||||||||||||||||||||");
		System.out.println("||        SPORTS TOURNAMENT        ||");
		System.out.println("|||||||||||||||||||||||||||||||||||||");
		System.out.println();

		//setup sequence
		String name = this.setTeamName();
		int week = this.setWeeksForSeason();
		String difficulty = this.setDifficulty();
		//send setup info to gameEnvironment
		gameEnvironment.set(name, week, difficulty);
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
				//check input is valid catch exception if input is invalid
				gameEnvironment.check(input, NAME_REGEX, NAME_CHAR_REQUIREMENT);
				//print feedback to player
				System.out.println("Awesome! Your team name is " + input);
				return input;

			} catch (IllegalInputException e) {
				//print err message
				System.err.println(e.getMessage());
				if (input.length() > 15 || input.length() < 3) System.err.println(NAME_LENGTH_REQUIREMENT);
			}
		}
	}

	/**
	 * set up number of weeks for season of the game between 5 and 15 (inclusive).
	 */
	public int setWeeksForSeason() {

		System.out.println("Please choose the number of weeks for the season of the game");
		System.out.println("Minimum is 5 weeks and Maximum is 15 weeks");
		while (true) {
			String input = scan.nextLine();
			try {
				//Check input requirement
				gameEnvironment.check(input, SEASON_REGEX, VALID_NUMBER);
				//give feedback to user
				System.out.printf("The game season set %s weeks long%n", input);

				//parse input to integer and send input to gameEnvironment
				return Integer.parseInt(input);

			} catch (IllegalInputException iie) {

				//catch any wrong input requirement
				System.err.println(iie.getMessage());
				System.out.println("Please do it again\n\n");
			}

		}
	}

	/**
	 * set up the difficulty of the game between easy and difficult
	 */
	public String setDifficulty() {
		DifficultyOption[] options = DifficultyOption.values();
		while (true) {
			System.out.println("Choose the number of difficulty of the game level.");
			this.listing(options);
			System.out.println("Your Option(Choose Number 1 or 2): ");
			String input = scan.nextLine();
			try {
				gameEnvironment.check(input, "(1|2)", INVALID_NUMBER);
				System.out.printf("Difficulty set: %s%n", options[Integer.parseInt(input) - 1].DIFFICULTY);
				switch (input) {
					case "1" -> { return options[0].DIFFICULTY; }
					case "2" -> { return options[1].DIFFICULTY; }
				}
			} catch (IllegalInputException e) {
				System.err.println(e.getMessage());
			}
		}
	}

	/**
	 * Main Menu CommandLine Interfaces
	 */
	public void main() {

		MainOption[] option = MainOption.values();
		System.out.printf("Your Team Name: %s%n", gameEnvironment.getTeam().getName());
		System.out.println("Current week: ");
		while(true) {
			try {
				System.out.println("Please input command here");
				System.out.println("input \"help\" for more information");
				String input = scan.nextLine();
				switch (input) {
					case "help" -> listing(option);
					case "exit" -> System.exit(0);
					//TODO - create methods and call them here
					//case "market" ->
					//case "team"
					//case "game"
					default -> throw new IllegalInputException("Please type again.");
				}
			}catch (IllegalInputException e) {

				System.err.println(e.getMessage());
			}

		}

	}

	/**
	 * method to recruit athletes
	 */
	private void marketSystem() {

		while(true) {
			Product[] athletes = gameEnvironment.getMarket().getAthleteProduct();
			this.listing(athletes);
			String input = scan.nextLine();
			try {
				//terminate market
				if(input.equalsIgnoreCase("exit")) break;

				gameEnvironment.check(input, String.format("[1-%d]", athletes.length), INVALID_NUMBER);
				int index = Integer.parseInt(input) - 1;
				Product athlete = gameEnvironment.getMarket().purchase(athletes, index);
				gameEnvironment.getTeam().recruitAthletes(athlete);
			} catch (IllegalInputException e) {
				System.err.println(e.getMessage());
			}
		}
	}

	/**
	 * print options with cardinal number
	 * @param array array to print option
	 */
	public void listing(Object[] array) {

		for (int i = 1; i <= array.length; i++) {
			System.out.printf("%d. %s%n", i, (array[i - 1] == null) ? "EMPTY\n" : array[i - 1]);
		}
	}
}