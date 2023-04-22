package main.gamesystem;

import main.gameObject.Product;
import main.gameObject.athletes.type.*;

import java.util.Random;

import main.gameObject.item.*;

/**
 * class for players to interact with Market
 * @author H Yang
 *
 */
public class Market {

	/**
	 * Products array to display for player to buy products.
	 * First row is an array to display {@link main.gameObject.athletes.Athlete Athletes},
	 * second row is another array to display game {@link main.gameObject.item.Item Items}.
	 */
	Product[][] products = new Product[][] {new Product[5], new Product[8]};

	/**
	 * Represent kinds of {@link main.gameObject.athletes.Athlete Athletes}.
	 * This will be used to generate athletes randomly.
	 * @author H Yang
	 *
	 */
	enum Athletes {

		ANGELINA, DWAYNE, THORIN, PRODO;


		static Athletes generateAthlete() {

			return Athletes.values()[new Random().nextInt(Athletes.values().length)];

		}

	}

	/**
	 * Represent kinds of {@link main.gameObject.item.Item Items}.
	 * This will be used to generate items randomly.
	 * @author H Yang
	 *
	 */
	enum Items {

		FATTY_PORK_BELLY, HIGH_DOPING_CANDY, RANDOM_CHICKEN, STAMINA_COOKIE, YUMMY_STAKE, TREAD_MILL;

		static Items generateItems() {

			return Items.values()[new Random().nextInt(Items.values().length)];
		}
	}

	/**
	 * Initialize Market.
	 * This constructor should be call if the Market needs to be reset.
	 */
	public Market() {

		this.setAthleteProduct();

		for (int i = 0; i < products[1].length; i++) {

			switch(Items.generateItems()) {

				case FATTY_PORK_BELLY -> products[1][i] = new FattyPorkBelly();
				case HIGH_DOPING_CANDY -> products[1][i] = new HighDopingCandy();
				case RANDOM_CHICKEN -> products[1][i] = new RandomChicken();
				case STAMINA_COOKIE -> products[1][i] = new StaminaCookie();
				case TREAD_MILL -> products[1][i] = new TreadMill();
				case YUMMY_STAKE -> products[1][i] = new YummyStake();
			}
		}

	}

	/**
	 * get Athlete stocks
	 * @return athletes
	 */
	public Product[] getAthleteProduct() {

		return this.products[0];
	}

	/**
	 * set Athlete stocks
	 */
	public void setAthleteProduct() {

		for (int i = 0; i < products[0].length; i++) {

			switch(Athletes.generateAthlete()) {

				case ANGELINA -> products[0][i] = new Angelina();
				case DWAYNE -> products[0][i] = new Dwayne();
				case THORIN -> products[0][i] = new Thorin();
				case PRODO -> products[0][i] = new Prodo();
			}
		}
	}

	/**
	 * Method to process when user purchases athletes or items.
	 * @param type row index of products. Integer 0 represents list of athletes,
	 * integer 1 represents list of items.
	 * @param col index of items' or athletes' location that user wish to buy.
	 * @return purchased item or athlete
	 */
	public Product purchase(int type, int col) {


		Product sold = products[type][col];
		products[type][col] = null;

		return sold;
	}


	public void sell(int index) {

		//TODO - Create Interface Purchasable and generate this method
		// But this method might be removed
		// Need to think about this method later.
	}


	/**
	 * Returns current market state. Only use this method at CLI UI.
	 */
	public String toString() {

		String result = "\nAthlete\n\n";
		for (Product product : products[0]) result += product;
		result += "\nItem\n\n";
		for(Product product : products[1]) result += product;

		return result;
	}
}
