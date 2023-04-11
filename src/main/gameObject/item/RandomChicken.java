package main.gameObject.item;

import java.util.*;
public class RandomChicken extends Item{

	private static ArrayList<String> stat_list = new ArrayList<String>();
	
	public RandomChicken() {
		super("RandomChicken", 100, getRandomAmount(), getRandomStat());

	}
	/*
	 * RandomChicken provides the random amount to increase the random stat.
	 * Amount will be randomly selected between 30  to  100.
	 */
	private static int getRandomAmount() {
		int upperBound = 100;
		int lowerBound = 30;
		Random result = new Random();
		return result.nextInt(lowerBound, upperBound);
		
	}
	/*
	 * Random stat will be selected between "Offence", "Defence" and "Stamina".
	 */
	private static String getRandomStat() {
		stat_list.add("Offence");
		stat_list.add("Defence");
		stat_list.add("Stamina");
		Random result = new Random();
		int i = result.nextInt(3);
		return stat_list.get(i);
		
		
	}
	
	
	
	
}
