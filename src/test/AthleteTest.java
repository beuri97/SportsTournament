package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

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
public class AthleteTest {
	UserInterface ui;
	GameEnvironment testEnvironment;
	Athlete testAthlete;
	Market testMarket;
	Item testItem;
	
	@BeforeEach
	void getRadomAthlete() {
		
		testEnvironment = new GameEnvironment(ui);
		testMarket = new Market();
		Random pickNum = new Random();
		int num = pickNum.nextInt(0, 6);
		testAthlete = (Athlete) testMarket.purchase(testMarket.getAthleteProduct(),num);
		System.out.println("testAthlete is : " + testAthlete);
	}
	
	@BeforeEach
	void getRandomitem() {
		testMarket = new Market();
		Random pickNum = new Random();
		int num = pickNum.nextInt(0, 8);
		testItem = (Item) testMarket.purchase(testMarket.getItemProduct(), num);
		System.out.println("testAthlete is : " + testItem);
	}
	
	@RepeatedTest(value = 1000)
	void testSellPrice() {
		double before = testAthlete.getPrice();
		System.out.println(before*0.7);
		testAthlete.setSellPrice();
		double after = testAthlete.getPrice();
		System.out.println(after);
		assertEquals(before*0.7, after);
		
		
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

