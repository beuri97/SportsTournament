package main.gamesystem;

import main.gameObject.Product;
import main.gameObject.athletes.type.*;

import java.util.Random;

import main.gameObject.item.*;
import main.gamesystem.Exception.EmptySlotException;

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
	Product[][] products = new Product[][] {new Product[6], new Product[8]};

	/**
	 * Represent kinds of {@link main.gameObject.athletes.Athlete Athletes}.
	 * This will be used to generate athletes randomly.
	 * @author H Yang
	 *
	 */
	public enum Athletes {

		ANGELINA, DWAYNE, THORIN, PRODO;

		/**
		 * Choose Athlete kind randomly
		 * @return Athlete Kind
		 */
		public static Athletes generateAthlete() {

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

		/**
		 * Choose Item kind randomly
		 * @return Item Kind
		 */
		static Items generateItems() {

			return Items.values()[new Random().nextInt(Items.values().length)];
		}
	}

	/**
	 * Initialize Market.
	 * This constructor should be call if the Market needs to be reset.
	 */
	public Market() {

		this.setAthleteProduct(products[0]);

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
	 * get Item stocks
	 * @return Items
	 */
	public Product[] getItemProduct() {

		return this.products[1];
	}

	/**
	 * set Athlete stocks
	 */
	public void setAthleteProduct(Product[] slots) {

		for (int i = 0; i < slots.length; i++) {

			slots[i] = this.athleteBuilder();
		}
	}

	public Product athleteBuilder() {

		Product athlete = null;
		switch(Athletes.generateAthlete()) {

			case ANGELINA -> athlete = new Angelina();
			case DWAYNE -> athlete = new Dwayne();
			case THORIN -> athlete = new Thorin();
			case PRODO -> athlete = new Prodo();
		}

		return athlete;
	}

	/**
	 * Method to process when user purchases athletes or items.
	 * @param product Product stock array
	 * @param col index of items' or athletes' location that user wish to buy.
	 * @return purchased item or athlete
	 */
	public Product purchase(Product[] product, int col) {

		Product sold = product[col];
		product[col] = null;

		return sold;
	}
}
