package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import main.gameObject.athletes.Athlete;
import main.gamesystem.Market;

import org.junit.jupiter.api.AfterEach;



/**
 * JUnit Test for classes Athlete 
 * @author J Kim
 *
 */
public class AthleteTest {
	Athlete testAthlete;
	
	@BeforeEach
	void getRadomAthlete() {
		Market testMarket = new Market();
		Random pickNum = new Random();
		int num = pickNum.nextInt(0, 4);
		testAthlete = (Athlete) testMarket.purchase(testMarket.getAthleteProduct(),num);
		System.out.println("testAthlete is : " + testAthlete);
	
	}
	
	@RepeatedTest(value = 1000)
	void testSellPrice() {	
		assertEquals(testAthlete.getPrice()*0.7f, testAthlete.getSellPrice() );
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

