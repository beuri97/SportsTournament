package main.gameObject.item;

import java.util.*;

/**
 * class for item, RandomChicken which will increase random stat
 * @author J Kim
 */
public class RandomChicken extends Item{

	private static ArrayList<String> statList = new ArrayList<String>();

	public RandomChicken() {
		super("RandomChicken", 100, getRandomAmount(), getRandomStat());

	}
	/**
	 * RandomChicken provides the random amount to increase the random stat.
	 * Amount will be randomly selected between 5  to  35.
	 * @return int value about the amount of incremental statistics
	 */
	private static int getRandomAmount() {
		int upperBound = 35;
		int lowerBound = 5;
		Random result = new Random();
		return result.nextInt(lowerBound, upperBound);
		
	}
	/**
	 * Random stat will be selected between "Offence", "Defence" and "Stamina".
	 * @return String value about types of statistics
	 */
	private static String getRandomStat() {
		statList.add("Offense");
		statList.add("Defense");
		statList.add("Stamina");
		Random result = new Random();
		int i = result.nextInt(3);
		return statList.get(i);
		
		
	}
}
