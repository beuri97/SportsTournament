package main.gameObject.item;

import main.gameObject.Product;
/**
 * Item which will be used while playing game
 *
 * @author J Kim
 */
public class Item implements Product{

	/**
	 * Name Of Item
	 */
	private String name;

	/**
	 * price of the item
	 */
	private float buyPrice;

	/**
	 * amount of incremental stats
	 */
	private int increaseAmount;

	/**
	 * types of incremented stats
	 */
	private String increaseStat;
	
	/**
	 * Item constructor to construct various kind of items.
	 * @param name name of Item
	 * @param buyPrice price to buy
	 * @param incAmount the amount increasing specific stat by item
	 * @param increaseStat the stat which will be increased by item
	 */
	public Item(String name, float buyPrice, int incAmount, String increaseStat) {
		this.name = name;
		this.buyPrice = buyPrice;
		this.increaseAmount = incAmount;
		this.increaseStat = increaseStat;
		
	}
	
	/**
	 * return name of this item
	 * @return String value about the name of item
	 */
	public String getName() {
		
		return name;
	}
	/**
	 * return price of this product
	 * @return float value about the price of item to buy or sell
	 */
	public float getPrice() {
	
		return buyPrice;
	}
	/**
     * convert to selling price after purchase
     */
	public void setSellPrice() {
		buyPrice *= SELL_PRICE_PENALTY;
	}

	/**
	 * return incremental amount information of the item
	 * @return integer value about amount of increasing specific stat by item
	 */
	public int getIncreaseAmount() {
		
		return increaseAmount;
	}
	/**
	 * return incremental stat information of the item
	 * @return String value about the stat which will be increased by item
	 */
	public String getIncreaseStat() {
		
		return increaseStat;
	}

	/**
	 * Return full spec information about item
	 * @return description of item
	 */
	public String toString() {
		
		return String.format("item: %s%nEffect: %s +%d%nprice: %.2f%n%n", 
				this.name, this.increaseStat, this.increaseAmount, this.buyPrice);
	}
	
}
