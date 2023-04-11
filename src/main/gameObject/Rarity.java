package main.gameObject;

import java.util.Random;



/**
 * Represent athletes' rarity.
 * This will affect athletes' statistics.
 * @author H Yang
 *
 */
public enum Rarity {
	
	NORMAL("N"), RARE("R"), SUPER_RARE("SR"), SUPER_SUPER_RARE("SSR");
			
	public final String rarity;
		
	/**
	 * Description about athletes' rarity
	 * @param string Athlete's rarity
	 */
	Rarity(String string) {
		this.rarity = string;
	}
		
		
	public static Rarity setRarity() {
			
		return Rarity.values()[new Random().nextInt(Rarity.values().length)];
	}
}
