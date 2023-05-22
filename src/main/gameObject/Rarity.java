package main.gameObject;

import java.util.Random;



/**
 * Represent athletes' rarity.
 * This will affect athletes' statistics.
 * @author H Yang
 *
 */
public enum Rarity {

	/**
	 * Represent Normal rarity of Athletes
	 */
	NORMAL("N"),

	/**
	 * Represent Rare rarity of Athletes
	 */
	RARE("R"),

	/**
	 * Represent Super-Rare rarity of Athletes
	 */
	SUPER_RARE("SR"),

	/**
	 * Represent Super-Super-Rare rarity of Athletes
	 */
	SUPER_SUPER_RARE("SSR");

	/**
	 * Initial representation about rarity
	 */
	public final String string;
		
	/**
	 * Description about athletes' rarity
	 * @param string Athlete's rarity
	 */
	Rarity(String string) {
		this.string = string;
	}

	/**
	 * random trigger to get athlete's rarity
	 * @return literal value about athlete's rarity
	 */
	public static Rarity setRarity() {

		double rarity = new Random().nextDouble(100.00);
		if(rarity <= 3) return Rarity.SUPER_SUPER_RARE;
		else if(rarity <= 15) return Rarity.SUPER_RARE;
		else if(rarity <= 45) return Rarity.RARE;
		else return Rarity.NORMAL;
	}
}
