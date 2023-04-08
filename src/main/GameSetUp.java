package main;

import java.util.Scanner;
import java.util.regex.Pattern;

public class GameSetUp {
	private Scanner scan = new Scanner(System.in);
	/**
	 * Player's Team name
	 */
	private String teamName;
	/**
	 * Number of weeks for one Season of the game
	 */	
	private String weeksForSeason;
	/**
	 * difficulty of the game
	 */
	private String difficulty;
	/**
	 * Start new game by setting up Team name, number of weeks for season and difficulty of game 
	 */
	public GameSetUp() {
		setTeamName();
		setWeeksForSeason();
		setDifficulty();		
	}
	
	/**
	 * set up player's team name. only accept the letter lengths between 3 to 15(inclusive) 
	 * doesn't allow to have special characters and.
	 */	
	public void setTeamName() {
		System.out.println("Please choose your team name!");
		String input = scan.nextLine();
		Pattern name = Pattern.compile("[^A-Za-z0-9]");
		if (name.matcher(input).find()) {
			System.out.println("Team name cannot include any special character. Please enter again.");
			setTeamName();
		}
		else if (input.length()<3 || input.length() >15) {
			System.out.println("The length of team name has to be between 3 to 15. Please enter again.");
			setTeamName();
		}
		else {
			teamName = input;
			System.out.println("Awesome! Your team name is "+ teamName );
		}
		
	}
	/**
	 * set up number of weeks for season of the game between 5 to 15 (inclusive).
	 */
	public void setWeeksForSeason() {
		System.out.println("Please choose the number of weeks for the season of the game");
		System.out.println("Minimum is 5 weeks and Maximum is 15 weeks");
		String input = scan.nextLine();
		int answer = Integer.parseInt(input);
		boolean truth = true;
		for (int i = 0; i < input.length(); i++) {
			if (!Character.isDigit(input.charAt(i))) {
				truth = false;
			}
		}
		if (!truth) {
			System.out.println("Please enter a valid number.");
			setWeeksForSeason();
		}
		
		else if ( answer <5 || answer >15) {
			System.out.println("The number of weeks for the season has to be between 5 to 15. Please enter again.");
			setWeeksForSeason();
		}
		else {
			weeksForSeason = input;
			System.out.println("Great! You got "+ weeksForSeason+ " weeks for the season." );
		}
		
	}
	/**
	 * set up the difficulty of the game between easy and difficult
	 */
	public void setDifficulty() {
		System.out.println("Please choose the difficulty of the game level.");
		System.out.println("Options : Easy || Difficult");
		String input = scan.nextLine();
		if (input.contains("easy") || input.contains("Easy")) {
			difficulty = "easy";
			System.out.println("You chose easy level. But it won't be too easy! Good Luck!");
		}
		else if(input.contains("Difficult") || input.contains("difficult")) {
			difficulty = "difficult";
			System.out.println("You chose difficult level. You must love hard life!! All the best!");
		}
		else {
			System.out.println("We don't have "+ difficulty + " in the option. Please type in correctly.");
			setDifficulty();
		}
	}
	
	/**
	 * return current player's team name
	 */
	public String getTeamname() { return teamName;}
	/**
	 * return the number of weeks for season of the current game
	 */
	public String getWeeksForSeason() {return weeksForSeason;}
	/**
	 * get the difficulty of the current game 
	 */
	public String getDifficulty() {return difficulty;}
	/**
	 *  start the game with current information that player chose
	 */
	public void startMySeason() {
		
	}

}


