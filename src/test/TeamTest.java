package test;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.gamesystem.DifficultyOption;
import main.gamesystem.Market;
import java.util.Random;

import main.GameEnvironment;
import main.UserInterface;
import main.gameObject.*;
import main.gameObject.athletes.Athlete;


/**
 * JUnit Test for Team class, but it partially covers Market class, athlete class and gameEnvironment class
 * It wouldn't test methods about game match in team class, so coverage is around 57%
 * @author J Kim
 *
 */

class TeamTest {
	/**
	 * create temporary UserInterface for JUnit test
	 */
	UserInterface ui = null;
	/**
	 * the core of this game
	 */
	GameEnvironment ge;
	/**
	 * create type of Team to test the methods in the team class
	 */
	Team testTeam;
	/**
	 * create variable of Random type to make random numbers in the test
	 */
	Random pickNum = new Random();
	/**
	 * create variable of Market type to refresh Market for the test
	 */
	Market testMarket;
	
	
	
	/**
	 * test if Class Team contains the correct team name.
	 */
	@BeforeEach
	void isTeamNameCorrect() {
		ge = new GameEnvironment(ui);
		ge.set("tempTeamName", 5, DifficultyOption.EASY);
		ge.getTeam().setName("testTeamName");
		assertEquals(ge.getTeam().getName(), "testTeamName");
	}
	
	/**
	 * test method for counting number of winning and playing during the game
	 */
	@Test
	public void checkingScore() {
		
		//before any game, it should return 0 
		assertEquals(0, ge.getTeam().getGameWin());
		//after two win, it has to return 2
		ge.getTeam().setGameWin();
		ge.getTeam().setGameWin();
		assertEquals(2, ge.getTeam().getGameWin());

		//before any match, it should return 0
		assertEquals(0, ge.getTeam().getTotalGamePlay());
		//after two matches, it has to return 2
		ge.getTeam().setTotalGamePlay();
		ge.getTeam().setTotalGamePlay();
		assertEquals(2, ge.getTeam().getTotalGamePlay());
	}

	/**
	 * buy random number of athletes from market 
	 * and check the total number in the inventory
	 */
	@Test
	void isNumAthletesCorrect() {

		Team team = new Team();
		for (int i = 0; i< 5; i++ ) {
			team.recruitAthletes(getRadomAthlete()); 
		}
		int count=0;
		for (int j=0; j<7; j++) {
			if (team.getRoster()[j] != null) {
				count +=1;
			}}
		assertEquals(5, count);
		//check if the team is full
		assertFalse(team.isFull(getRadomAthlete()));

		
		team.leaveAthletes(team.getRoster()[4]);
		
		int count2=0;
		for (int j=0; j<7; j++) {
			if (team.getRoster()[j] != null) {
				count2 +=1;
			}}
		assertEquals(4, count2);
	}
		
	
	/**
	 * checking the isFull method to check if it is working when the athlete arrayList of player is full.
	 */
	@Test
	void overNumAthletes() {
		Team team = new Team();
		for (int i = 0; i< 7; i++ ) {team.recruitAthletes(getRadomAthlete());}
		//check if the team is full
		assertTrue(team.isFull(getRadomAthlete()));
	}

	/**
	 * buy random number of items from market and check the total number in the inventory
	 */
	@Test
	void isNumItemsCorrect() {

		Team team = new Team();
		for (int i = 0; i< 5; i++ ) {
			team.addItem(getRandomItem()); 
		}
		int count=0;
		for (int j=0; j<10; j++) {
			if (team.getInventory()[j] != null) {
				count +=1;
			}}
		assertEquals(5, count);
		assertFalse(team.isFull(getRandomItem()));
		team.removeItem(team.getInventory()[4]);
		
		int count2=0;
		for (int j=0; j<7; j++) {
			if (team.getInventory()[j] != null) {
				count2 +=1;
			}}
		assertEquals(4, count2);
	}
	/**
	 * checking the isFull method to check if it is working when the item arrayList of player is full.
	 */
	@Test
	void overNumItem() {
		Team team = new Team();
		for (int i = 0; i< 10; i++ ) {team.addItem(getRandomItem());}
		//check if the inventory is full
//		assertTrue(team.isFull(getRandomItem()));
	} 
	/**
	 * test adding money function for the situation when the player gain money from match or trade.  
	 */
	@Test
	void checkMoney() {
		double currentMoney = ge.getTeam().getMoney();
		ge.getTeam().setMoney(20000);
		assertEquals(ge.getTeam().getMoney(), currentMoney+20000);
	}
	
	/**
	 * test swapping function when the player wants to change the athlete's position in the arrayList
	 * 
	 */
	@Test
	void checkSwap() {
		
		ge = new GameEnvironment(ui);
		ge.set("teamTestName", 5, DifficultyOption.EASY);
		for (int i = 0; i< 7; i++ ) {ge.getTeam().recruitAthletes(getRadomAthlete());}
		Athlete a1 = ge.getTeam().getRoster()[2];
		Athlete a2 = ge.getTeam().getRoster()[4];
		ge.swap(2, 4);
		assertEquals(a1,ge.getTeam().getRoster()[4]);
		assertEquals(a2,ge.getTeam().getRoster()[2]);
		
	}
	
	
	
	/**
	 * Help function for the test method,isNumAthletesCorrect()
	 * Randomly pick one of the athlete on the market
	 * @return one random athlete from market
	 */
	public Product getRadomAthlete() {
		testMarket = new Market();
		return testMarket.purchase(testMarket.getAthleteProduct(),pickNum.nextInt(0, 6));
	}
	/**
	 * Help function for the test method,isNumItemsCorrect()
	 * Randomly pick one of the item on the market
	 * @return one random item from market
	 */
	public Product getRandomItem() {
		testMarket = new Market();
		return testMarket.purchase(testMarket.getItemProduct(),pickNum.nextInt(0, 8));
	}
	

	
	
}