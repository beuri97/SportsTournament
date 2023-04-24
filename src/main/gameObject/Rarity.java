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
			
	public final String string;
		
	/**
	 * Description about athletes' rarity
	 * @param string Athlete's rarity
	 */
	Rarity(String string) {
		this.string = string;
	}
		
		
	public static Rarity setRarity() {

		double rarity = new Random().nextDouble(100.00);
		if(rarity <= 0.7) return Rarity.SUPER_SUPER_RARE;
		else if(rarity <= 15) return Rarity.SUPER_RARE;
		else if(rarity <= 45) return Rarity.RARE;
		else return Rarity.NORMAL;
	}
}
