package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import main.GameEnvironment;
import main.UserInterface;
import main.gameObject.Product;
import main.gameObject.athletes.Athlete;
import main.gameObject.item.Item;
import main.gamesystem.DifficultyOption;
import main.gamesystem.Market;


import org.junit.jupiter.api.AfterEach;



/**
 * JUnit Test for Athlete class and Item class,, but it will cover Market class and Team class partially.
 * @author J Kim
 */
public class AthleteItemTest {
	/**
	 * create temporary UserInterface for JUnit test
	 */
	UserInterface ui = null;
	/**
	 * the core of this game
	 */
	GameEnvironment ge;
	/**
	 * create variable for the type of Athlete to test Athlete class
	 */
	Athlete testAthlete;
	/**
	 * create variable for the type of Market to trade athlete and items
	 */
	Market testMarket;
	/**
	 * create variable of Random type to make random numbers in the test
	 */
	Random pickNum = new Random();;
	
	
	
	
	/**
	 * get one random athlete from market and check if the description of athlete is printing correctly
	 */
	@BeforeEach
	void getRadomAthlete() {
		
		testMarket = new Market();
		int num = pickNum.nextInt(0, 6);
		testAthlete = (Athlete) testMarket.purchase(testMarket.getAthleteProduct(),num);
		assertEquals(testAthlete.toString(), 
				String.format("Name: %s%nRarity: %s%nOffense: %d%nDefense: %d%nStamina: "
				+ "%d/%d%nPrice: %.2f%nDescription: %s%n",
				testAthlete.getName(), testAthlete.getRarity(), testAthlete.getOffenseStat(), testAthlete.getDefenseStat(), 
				testAthlete.getStamina(), testAthlete.getMaxStamina(), testAthlete.getPrice(), testAthlete.getDescription()));
		assertEquals(testAthlete.getAthleteSummary(),String.format("Name: %s%n Offense: %d%n Defense: %s%n Stamina: %d/%d%n Injured: %s%n",
				testAthlete.getName(), testAthlete.getOffenseStat(), testAthlete.getDefenseStat(), testAthlete.getStamina(), testAthlete.getMaxStamina(),
				(testAthlete.isInjured()) ? "Yes":"No"));
	
	}
	
	/**
	 * get one random item from market and check if the description of item is printing correctly
	 */
	@BeforeEach
	void getRandomitem() {
		testMarket = new Market();
		int num = pickNum.nextInt(0, 8);
		Item testItem = (Item) testMarket.purchase(testMarket.getItemProduct(), num);
		assertEquals(testItem.toString(), String.format("item: %s%nEffect: %s +%d%nprice: %.2f%n%n", 
				testItem.getName(), testItem.getIncreaseStat(), testItem.getIncreaseAmount(), testItem.getPrice()));
	}
	/**
	 * check the sell price of athlete
	 * For accuracy, repeat 300 times
	 */
	@RepeatedTest(value = 300)
	void testSellPrice() {
		double before = testAthlete.getPrice();
		testAthlete.setSellPrice();
		double after = testAthlete.getPrice();
		assertEquals(Math.round(before*0.7*100)/100, after);
		
		
	}

	/**
	 * test athletes injured status by increasing and decreasing stamina value and also test maximum stamina function
	 */
	@AfterEach
	void testInjuredStatus() {
		testAthlete.setStamina(-500);
		assertTrue(testAthlete.isInjured());
		testAthlete.setStamina(+500);
		assertFalse(testAthlete.isInjured());
		int testMaxStamina = testAthlete.getMaxStamina();
		testAthlete.setMaxStamina(40);
		assertEquals(testAthlete.getMaxStamina(), testMaxStamina+40);
	}
	/**
	 * testing athlete's amount of stamina by reducing and increasing.
	 * it shouldn't increase over maximum amount.
	 */
	@AfterEach
	void testNotInjuredStatus() {
		testAthlete.setStamina(-40);
		testAthlete.setStamina(400);
		assertEquals(testAthlete.getStamina(), testAthlete.getMaxStamina());
	}

	/**
	 * testing athlete's offense stat by increasing certain amount.
	 */
	@AfterEach
	void testSetOffenseStat() {
		int testOffStat = testAthlete.getOffenseStat()+40;
		testAthlete.setOffenseStat(40);
		assertEquals(testOffStat, testAthlete.getOffenseStat());	
	}
	/**
	 * testing athlete's Defense stat by increasing certain amount.
	 */
	@AfterEach
	void testSetDefenseStat() {
		int testDeffStat = testAthlete.getDefenseStat()+40;
		testAthlete.setDefenseStat(40);
		assertEquals(testDeffStat, testAthlete.getDefenseStat());	
	}
	
	/**
	 * testing fuction to buy/sell athlete and item and check whether they are in player's roster and inventory or not.
	 */
	@AfterEach
	void testTradingUsingItem() {
		ge = new GameEnvironment(ui);
		ge.set("teamTestName", 5, DifficultyOption.EASY);
		testMarket = new Market();
		
		Product[] athleteMarket = testMarket.getAthleteProduct();
		ge.tradingProcess("buy",athleteMarket , 0);
		Athlete athlete = ge.getTeam().getRoster()[0];
		
		Product[] itemMarket = testMarket.getItemProduct();
		ge.tradingProcess("buy",itemMarket, 0);
		Item item = ge.getTeam().getInventory()[0];
		
		String statName = item.getIncreaseStat();
		int increasingAmount = item.getIncreaseAmount();
		int originalStat;
		
		if(statName == "Defense") {originalStat = athlete.getDefenseStat();}
		else if(statName == "Offense") {originalStat = athlete.getOffenseStat();}
		else {originalStat = athlete.getStamina();}
		
		ge.useItem(0, 0);
		
		if(statName == "Defense") {assertEquals(athlete.getDefenseStat(), originalStat + increasingAmount);}
		else if(statName == "Offense") {assertEquals(athlete.getOffenseStat(), originalStat + increasingAmount);}
		else {assertEquals(athlete.getStamina(), originalStat);}
		
		ge.tradingProcess("sell", ge.getTeam().getRoster() , 0);
		ge.tradingProcess("buy",itemMarket, 1);
		ge.tradingProcess("sell", ge.getTeam().getInventory() , 0);
		assertEquals(null, ge.getTeam().getRoster()[0]);
		assertEquals(null, ge.getTeam().getInventory()[0]);
		
	}
	
	
	
			

	
}

