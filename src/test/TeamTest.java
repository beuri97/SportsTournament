package test;



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.gamesystem.Market;
import java.util.Random;
import main.gameObject.*;


/**
 * JUnit Test for classes ( Market, Team )
 * @author J Kim
 *
 */


class TeamTest {
	Team testTeam;
	Random pickNum = new Random();
	Market testMarket;
	
	
	/**
	 * Before perform the test, set up the team with temporary name
	 */
	@BeforeEach
	void setTestTeam() {
		testTeam = new Team();
		testTeam.setName("testTeamName");
	}

	/**
	 * test if Class Team contains the correct team name.
	 */
	
	@Test
	void isTeanNameCorrect() {assertEquals(testTeam.getName(), "testTeamName");}
	
	
	@Test
	void isNumAthletesCorrect() {

		Team team = new Team();
		team.setMoney(50000.00);
		for (int i = 0; i< 5; i++ ) {
			team.recruitAthletes(getRadomAthlete()); 
		}
		int count=0;
		for (int j=0; j<7; j++) {
			if (team.getRoster()[j] != null) {
				count +=1;
			}}
		assertEquals(5, count);
		
		assertFalse(team.isFull());
		
		team.leaveAthletes(team.getRoster()[4]);
		
		int count2=0;
		for (int j=0; j<7; j++) {
			if (team.getRoster()[j] != null) {
				count2 +=1;
			}}
		assertEquals(4, count2);
	}
		
	
	
	@Test
	void overNumAthletesThrow() {
		Team team = new Team();
		team.setMoney(50000.00);
		for (int i = 0; i< 7; i++ ) {team.recruitAthletes(getRadomAthlete());}
		//check if the team is full
		assertTrue(team.isFull());
	}

	@Test
	void isNumItemsCorrect1() {

		Team team = new Team();
		team.setMoney(50000.00);
		for (int i = 0; i< 5; i++ ) {
			team.addItem(getRandomItem()); 
		}
		int count=0;
		for (int j=0; j<10; j++) {
			if (team.getInventory()[j] != null) {
				count +=1;
			}}
		assertEquals(5, count);
		
		team.removeItem(team.getInventory()[4]);
		
		int count2=0;
		for (int j=0; j<7; j++) {
			if (team.getInventory()[j] != null) {
				count2 +=1;
			}}
		assertEquals(4, count2);
	}
	@Test
	void checkMoney() {
		Team team = new Team();
		double currentMoney = team.getMoney();
		team.setMoney(20000);
		assertEquals(team.getMoney(), currentMoney+20000);
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