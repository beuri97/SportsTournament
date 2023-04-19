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

	/**
	 * Number of weeks for one Season of the game
	 */
	private String weeksForSeason;

	private boolean exit = false;

	private String difficulty;

	/**
	 * An enum shows the different difficulty options of the game
	 */
	private enum DifficultyOption{
		EASY, DIFFICULT;
	}


	public CmdLineUi() {
        this.scan = new Scanner(System.in);
	}

	/**
	 * intitial game environment setup
	 * @param gameEnvironment game environment which is core of this program
	 */
	public void setup(GameEnvironment gameEnvironment){
		this.gameEnvironment = gameEnvironment;
		setTeamName();
		weeksForSeason = setWeeksForSeason();
		setDifficulty();
	}

	/**
	 * set up player's team name. only accept the letter lengths between 3 to 15(inclusive)
	 * doesn't allow to have special characters and.
	 */
	public void setTeamName() {

		System.out.println("Please choose your team name");
		while(true) {
			String input = scan.nextLine();
			try {
				gameEnvironment.check(input, NAME_REGEX);
				System.out.println("Awesome! Your team name is " + input);
				gameEnvironment.team.setName(input);
				break;

			} catch (IllegalInputException e) {
				System.err.println(e.getMessage());
				if(input.length() > 15 || input.length() < 3) System.out.println(NAME_LENGTH_REQUIREMENT);
				System.out.println("Please do it again.");
			}
		}
	}

	/**
	 * set up number of weeks for season of the game between 5 to 15 (inclusive).
	 */
	public String setWeeksForSeason() throws CmdException{
		System.out.println("Please choose the number of weeks for the season of the game");
		System.out.println("Minimum is 5 weeks and Maximum is 15 weeks");
		String input = scan.nextLine();
		String result = input;
		boolean isInputIncorrect = true;

		while (isInputIncorrect) {
			try {for (int i = 0; i < input.length(); i++) {
				if (!Character.isDigit(input.charAt(i))) {throw new CmdException();}}} catch(CmdException e){
				System.out.println(VALID_NUMBER);
				result = setWeeksForSeason();
				break;}

			int intResult = Integer.parseInt(input);
			try { if ( intResult <5 || intResult >15) { throw new CmdException();} } catch (CmdException e){
				System.out.println(TEAMNUMBER_REQUIREMENT);
				result = setWeeksForSeason();
				break;
			}
			isInputIncorrect = false;
			System.out.println("Great! You got " + result + " weeks for the season." );
		}
		return result;

	}

	/**
	 * set up the difficulty of the game between easy and difficult
	 */
	public void setDifficulty() throws CmdException{
		System.out.println("Please choose the difficulty of the game level.");
		DifficultyOption[] options = DifficultyOption.values();
		for (DifficultyOption s : DifficultyOption.values()) {
			System.out.println(s);}
		String input = scan.nextLine();
		try {
			DifficultyOption option = DifficultyOption.valueOf(input.toUpperCase());
			handleDifficultyOption(option);
		} catch(IllegalArgumentException e) {
			System.out.println("We don't have "+ input + " in the option. Please type in correctly.");
			setDifficulty();
		}
	}

	private void handleDifficultyOption(DifficultyOption option){
		switch (option) {
			case EASY:
				difficulty = "Easy";
				System.out.println("You chose easy level. But it won't be too easy! Good Luck!");
				break;
			case DIFFICULT:
				difficulty = "Difficult";
				System.out.println("You chose difficult level. You must love hard life!! All the best!");
				break;
		}
	}

	/**
	 *  start the game with current information that player chose
	 */
	public void startMySeason() {

	}

	@Override
	public void exitGame() {
		exit = true;
	}

	public void confirmExit() {

	}

	public void showError(String error) {
        System.out.println("!!!!!!!! " + error + " !!!!!!!!");
    }

	/**
	 * return the number of weeks for season of the current game
	 */
	public String getWeeksForSeason() {return weeksForSeason;}

	/**
	 * get the difficulty of the current game
	 */
	public String getDifficulty() {return difficulty;}


	/**
	 * temporary test
	 * @param args
	 */
	public static void main (String[] args) {
		CmdLineUi kim = new CmdLineUi();
		kim.setup(null);
	}
}
