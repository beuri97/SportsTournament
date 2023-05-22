package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import main.gameObject.athletes.Athlete;
import main.gameObject.item.Item;
import main.gamesystem.Market;
import main.GameEnvironment;
import main.UserInterface;

import org.junit.jupiter.api.AfterEach;



/**
 * JUnit Test for classes Market class, Athlete class and Item class
 * @author J Kim
 *
 */
//
@Suite
@SelectClasses({ TeamTest.class})
public class AthleteTest {
	UserInterface ui;
	GameEnvironment testEnvironment;
	Athlete testAthlete;
	Market testMarket;
	Item testItem;
	Random pickNum = new Random();;
	
	@BeforeEach
	void getRadomAthlete() {
		
		testEnvironment = new GameEnvironment(ui);
		testMarket = new Market();
		int num = pickNum.nextInt(0, 6);
		testAthlete = (Athlete) testMarket.purchase(testMarket.getAthleteProduct(),num);
		assertEquals(testAthlete.toString(), 
				String.format("Name: %s%nRarity: %s%nOffense: %d%nDefense: %d%nStamina: "
				+ "%d/%d%nPrice: %.2f%nDescription: %s%n",
				testAthlete.getName(), testAthlete.getRarity(), testAthlete.getOffenseStat(), testAthlete.getDefenseStat(), 
				testAthlete.getStamina(), testAthlete.getMaxStamina(), testAthlete.getPrice(), testAthlete.getDescription()));

		
	}
	
	@BeforeEach
	void getRandomitem() {
		testMarket = new Market();
		int num = pickNum.nextInt(0, 8);
		testItem = (Item) testMarket.purchase(testMarket.getItemProduct(), num);
		assertEquals(testItem.toString(), String.format("item: %s%nEffect: %s +%d%nprice: %.2f%n%n", 
				testItem.getName(), testItem.getIncStat(), testItem.getIncAmount(), testItem.getPrice()));
	}
	
	@RepeatedTest(value = 300)
	void testSellPrice() {
		double before = testAthlete.getPrice();
		testAthlete.setSellPrice();
		double after = testAthlete.getPrice();
		assertEquals(Math.round(before*0.7*100)/100, after);
		
		
	}

	@AfterEach
	void testInjuredStatus() {
		testAthlete.setStamina(-500);
		assertTrue(testAthlete.isInjured());
		testAthlete.setStamina(+500);
		assertFalse(testAthlete.isInjured());
	}
	@AfterEach
	void testNotInjuredStatus() {
		int testStamina = testAthlete.getStamina();
		testAthlete.setStamina(-40);
		testAthlete.setStamina(400);
		assertEquals(testAthlete.getStamina(), testStamina);
	}

	@AfterEach
	void testSetOffenseStat() {
		int testStat = testAthlete.getOffenseStat()+40;
		testAthlete.setOffenseStat(40);
		assertEquals(testStat, testAthlete.getOffenseStat());	
	}
	@AfterEach
	void testSetDefenseStat() {
		int testStat = testAthlete.getDefenseStat()+40;
		testAthlete.setDefenseStat(40);
		assertEquals(testStat, testAthlete.getDefenseStat());	
	}
	
}

