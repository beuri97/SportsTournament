package main.gamesystem;

import main.gameObject.Product;
import main.gameObject.athletes.Athlete;
import main.gameObject.athletes.type.*;

import java.util.Random;

import main.gameObject.item.Item;

/**
 * class for players to interact with Market
 * @author Yang
 *
 */
public class Market {
	
	/**
	 * product array to display for player to buy products
	 * First row is an array to display athletes, 
	 * second row is another array to display game items.
	 */
	Product[][] products = new Product[][] {new Product[5], new Product[8]};
	
	/**
	 * Represent kinds of {@link Athlete}. 
	 * This will be used to randomly generate athletes.
	 * @author Yang
	 *
	 */
	enum Athletes {
		
		ANGELINA, DWAYNE, THORIN, PRODO;
		
		
		static Athletes generateAthlete() {
			
			return Athletes.values()[new Random().nextInt(Athletes.values().length)];
			
		}

	}
	
	enum Items {
		
		FATTY_PROK_BELLY, HGIH_DOPING_CANDY, RANDOM_CHICKEN, STAMINA_COOKIE, YUMMY_STAKE, TREAD_MILL;
		
		static Items generateItems() {
			
			return Items.values()[new Random().nextInt(Items.values().length)];
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
			
			for (int i = 0; i < products[0].length; i++) {
			
				switch(Athletes.generateAthlete()) {
				
				case ANGELINA -> products[0][i] = new Angelina(Rarity.setRarity());
				case DWAYNE -> products[0][i] = new Dwayne(Rarity.setRarity());
				case THORIN -> products[0][i] = new Thorin(Rarity.setRarity());
				case PRODO -> products[0][i] = new Prodo(Rarity.setRarity());
				
				}
			}
			
			for (int i = 0; i < products[1].length; i++) {
				
				//TODO - Create enum Items and do same thing as line 72-77;
			}
		}
	}
	
	public Product purchase(int index) {
		
		return null;
		
	}
	
	
	public void sell(int index) {
		
		//TODO - Create Interface Purchasable and generate this method
	}
	
	
	public String toString() {
		
		
		String result = "\n\nAthlete\n\n\n";
		for (Product product : products[0]) result += product;
		result += "\n\nItem\n\n";
		for(Product product : products[1]) result += "Not Yet Implemented!\n\n";
		
		return result;
	}
	
	
	public static void main(String[] args) {
		
		Market m = new Market(true);
		System.out.println(m);
	}
	
	
}
