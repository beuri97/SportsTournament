package main.gamesystem;

import main.gameObject.athletes.Athlete;
import main.gameObject.athletes.type.*;

import java.util.Random;

import item.Item;

public class Market {
	
	/**
	 * For display of athletes
	 */
	public Athlete[] athletes = new Athlete[5];
	
	/**
	 * For display of items
	 */
	public Item[] items = new Item[8];
	
	Athletes kind;
	
	/**
	 * Represent kinds of {@link Athlete}. 
	 * This will be used to randomly generate athletes.
	 * @author Yang
	 *
	 */
	enum Athletes {
		
		ANGELINA, DWAYNE, THORIN, PRODO;
		
		
		Athletes generateAthlete() {
			
			return Athletes.values()[new Random().nextInt(Athletes.values().length)];
			
		}

	}
	
	public enum Rarity{
		
		NORMAL("Normal"), RARE("Rare"), SUPER_RARE("Super Rare"), SUPER_SUPER_RARE("Super-Super Rare");
		
		
		public final String rarity;
		
		/**
		 * Description about athletes' rarity
		 * @param string Athlete's rarity
		 */
		Rarity(String string) {
			this.rarity = string;
		}
		
		
		static Rarity setRarity() {
			
			return Rarity.values()[new Random().nextInt(Rarity.values().length)];
		}
	}
 	
	
	public Market(boolean reset) {
		
		
		if (reset) {
			for (int i = 0; i < athletes.length; i++) {
			
				switch(kind.generateAthlete()) {
				
				case ANGELINA -> athletes[i] = new Angelina(Rarity.setRarity());
				case DWAYNE -> athletes[i] = new Dwayne(Rarity.setRarity());
				case THORIN -> athletes[i] = new Thorin(Rarity.setRarity());
				case PRODO -> athletes[i] = new Prodo(Rarity.setRarity());
				
				}
			}
			
			for (int i = 0; i < items.length; i++) {
				
				//TODO - Create enum Items and do same thing as line 72-77;
			}
		}
	}
	
	public void purchase(int index) {
		
		//TODO - Create Interface Purchasable for Class Athlete and Item and generate this method
		
	}
	
	
	public void sell(int index) {
		
		//TODO - Create Interface Purchasable and generate this method
	}
	
	
	public String toString() {
		
		//TODO - Create toString method to Class Athlete and Items, and generate its statement
		
		return null;
	}
}
