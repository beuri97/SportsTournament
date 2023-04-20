package main;

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

	private String difficulty;

	/**
	 * An enum shows the different difficulty options of the game
	 */
	private enum DifficultyOption {
		EASY("Easy"), DIFFICULT("Difficult");

		public final String difficulty;

		DifficultyOption(String string) {
			this.difficulty = string;
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
		setTeamName();
		setWeeksForSeason();
		setDifficulty();
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
				gameEnvironment.check(input, SEASON_REGEX, VALID_NUMBER);
				System.out.printf("The game season set %s weeks long%n", input);
				int weeks = Integer.parseInt(input);
				gameEnvironment.setSeason(weeks);
				break;

			} catch (IllegalInputException iie) {
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
			for (int i = 1; i <= 2; i++) {
				System.out.printf("%d. %s%n", i, options[i - 1].difficulty);
			}
			System.out.println("Your Option: ");
			String input = scan.nextLine();
			try {
				gameEnvironment.check(input, "(1|2)", VALID_DIFFICULTY);
				switch (input) {
					case "1" -> gameEnvironment.setDifficulty(options[0].difficulty);
					case "2" -> gameEnvironment.setDifficulty(options[1].difficulty);
				}
				System.out.printf("Difficulty set: %s%n", gameEnvironment.getDifficulty());
				break;
			} catch (IllegalInputException e) {
				System.err.println(e.getMessage());
			}
		}
	}

	/**
	 * start the game with current information that player chose
	 */
	public void startMySeason() {

	}

	@Override
	public void exitGame() {
		exit = true;
	}

	public void confirmExit() {

	}
}
