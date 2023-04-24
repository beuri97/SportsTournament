package main;

import main.gameObject.Product;
import main.gamesystem.IllegalInputException;

import java.util.Scanner;

/**
 * class for Command line User Interface.
 * @author H Yang, J Kim
 */
public class CmdLineUi implements UserInterface {

	private final Scanner scan;

	private GameEnvironment gameEnvironment;

	private boolean exit = false;

	/**
	 * An enum shows the different difficulty options of the game
	 */
	private enum DifficultyOption {
		EASY("Easy"), DIFFICULT("Difficult");

		private final String DIFFICULTY;

		DifficultyOption(String string) {
			this.DIFFICULTY = string;
		}

		/**
		 * return enum literal to string to show ui
		 * @return difficulty string value
		 */
		public String toString() {
			return this.DIFFICULTY;
		}
	}


	public CmdLineUi() {
		this.scan = new Scanner(System.in);
	}

	/**
	 * intitial game environment setup
	 *
	 * @param gameEnvironment game environment which is core of this program
	 */
	public void setup(GameEnvironment gameEnvironment) {
		this.gameEnvironment = gameEnvironment;
		this.setTeamName();
		this.setWeeksForSeason();
		this.setDifficulty();
		this.recruitAthletes();
	}

	/**
	 * set up player's team name. only accept the letter lengths between 3 to 15(inclusive)
	 * doesn't allow to have special characters and.
	 */
	public void setTeamName() {

		System.out.println("Please choose your team name");
		while (true) {
			String input = scan.nextLine();
			try {
				gameEnvironment.check(input, NAME_REGEX, NAME_CHAR_REQUIREMENT);
				System.out.println("Awesome! Your team name is " + input);
				gameEnvironment.getTeam().setName(input);
				break;

			} catch (IllegalInputException e) {
				System.err.println(e.getMessage());
				if (input.length() > 15 || input.length() < 3) System.err.println(NAME_LENGTH_REQUIREMENT);
			}
		}
	}

	/**
	 * set up number of weeks for season of the game between 5 to 15 (inclusive).
	 */
	public void setWeeksForSeason() {

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
				int weeks = Integer.parseInt(input);
				gameEnvironment.setSeason(weeks);
				break;

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
	public void setDifficulty() throws CmdException {
		DifficultyOption[] options = DifficultyOption.values();
		while (true) {
			System.out.println("Choose the number of difficulty of the game level.");
			this.listing(options);
			System.out.println("Your Option: ");
			String input = scan.nextLine();
			try {
				gameEnvironment.check(input, "(1|2)", INVALID_NUMBER);
				switch (input) {
					case "1" -> gameEnvironment.setDifficulty(options[0].toString());
					case "2" -> gameEnvironment.setDifficulty(options[1].toString());
				}
				System.out.printf("Difficulty set: %s%n", gameEnvironment.getDifficulty());
				break;
			} catch (IllegalInputException e) {
				System.err.println(e.getMessage());
			}
		}
	}

	/**
	 * method to recruit athletes
	 */
	private void recruitAthletes() {
		System.out.println("Recruit Athletes.");
		System.out.println("Please recruit at least 5");

		int i =5;
		while(i != 0) {
			Product[] athletes = gameEnvironment.getMarket().getAthleteProduct();
			this.listing(athletes);
			String input = scan.nextLine();
			try {
				gameEnvironment.check(input, String.format("[1-%d]", athletes.length), INVALID_NUMBER);
				int index = Integer.parseInt(input) - 1;
				Product athlete = gameEnvironment.getMarket().purchase(athletes, index);
				gameEnvironment.getTeam().recruitAthletes(athlete);

				i--;
			} catch (IllegalInputException e) {
				System.err.println(e.getMessage());
			}
		}
	}

	/**
	 * start the game with current information that player chose
	 */
	// public void startMySeason() {}
	public void listing(Object[] array) {

		for (int i = 1; i <= array.length; i++) {
			System.out.printf("%d. %s%n", i, (array[i - 1] == null) ? "EMPTY\n" : array[i - 1]);
		}
	}

	@Override
	public void exitGame() {
		exit = true;
	}

	public void confirmExit() {

	}
}