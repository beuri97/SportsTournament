package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import main.gamesystem.Market;
import main.gameObject.item.*;
import java.util.Random;
import main.gameObject.*;
import main.gameObject.athletes.Athlete;


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
	
	/**
	 * test if Class Team contains the correct team name.
	 */
	
	@Test
	void isTeanNameCorrect() {assertEquals(testTeam.getName(), "testTeamName");}
	
	
	/**
	 * Randomly select the number to decide how many athletes will be added to the roster of Class Team 
	 * (Range is from 0 to 9 in order to test over-recruiting)
	 * If the random number is less than 7(inclusive), the random number has to be same as the total number of athletes in the roster.
	 * If the random number is more than 7, the total number of athletes in the roster has to be 7 because the roster has only 7 slots for athletes.
	 * This test will be repeated 1000 times for accurate result.
	 */
	@RepeatedTest(value = 1000)
	void isNumAthletesCorrect() {
		int num = pickNum.nextInt(0,9);
		for (int i = 0; i< num; i++ ) {
			testTeam.recruitAthletes(getRadomAthlete());
		}
		int count=0;
		
		if (num <= 7) {
			for (int i=0; i<7; i++) {
				if (testTeam.getRoster()[i] != null) {
					count +=1;
				}
			}
			assertEquals(num, count);	
		}
		else {
			for (int i=0; i<7; i++) {
				if (testTeam.getRoster()[i] != null) {
					count +=1;
				}
			}
			assertEquals(7, count);	
		}
		/**
		 * Unless there is no athlete in the roster, test the method, leaveAthletes()
		 * after removing one of athlete in the roster, check whether the removed Athlete is existing or not.
		 */
		if (count != 0) {
			Athlete leavingAthlete = testTeam.getRoster()[pickNum.nextInt(0, count)];
			testTeam.leaveAthletes(leavingAthlete);
			for (Athlete name: testTeam.getRoster()) {
				if (name != null) {
				assertNotEquals(leavingAthlete, name);
				}
			}
		}
	}

	
	/**
	 * Randomly select the number to decide how many items will be added to the inventory of Class Team 
	 * (Range is from 0 to 10 in order to test over-purchasing)
	 * If the random number is less than 8(inclusive), the random number has to be same as the total number of athletes in the inventory.
	 * If the random number is more than 8, the total number of athletes in the inventory has to be 8 because the inventory has only 8 slots for athletes.
	 * This test will be repeated 1000 times for accurate result.
	 */
	@RepeatedTest(value = 1000)
	void isNumItemsCorrect() {
		int num = pickNum.nextInt(0,10);
		for (int i = 0; i< num; i++ ) {
			testTeam.addItem(getRandomItem());
		}
		int count=0;
		if (num <= 8) {
			for (int i=0; i<8; i++) {
				if (testTeam.getInventory()[i] != null) {
					count +=1;
				}
			}
			assertEquals(num, count);	
		}
		else {
			for (int i=0; i<8; i++) {
				if (testTeam.getInventory()[i] != null) {
					count +=1;
				}
			}
			assertEquals(8, count);	
		}
		/**
		 * Unless there is no item in the inventory, test the method, removeItem()
		 * After removing one of item in the inventory, check whether the removed item is existing or not.
		 */
		if (count != 0) {
			Item removeditem = testTeam.getInventory()[pickNum.nextInt(0, count)];
			System.out.println(removeditem);
			testTeam.removeItem(removeditem);
			for (Item name: testTeam.getInventory()) {
				if (name != null) {
					assertNotEquals(removeditem, name);
				}
			}
		}
	}


}
