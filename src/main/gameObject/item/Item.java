package main.gameObject.item;

import main.gameObject.Product;
/**
 * Item which will be used while playing game
 *
 * @author J Kim
 */
public class Item implements Product{
	private String name;
	private float buyPrice;
	private int incAmount;
	private String incStat;
	
	/**
	 * 
	 * @param name  - name of Item
	 * @param buyPrice - price to buy
	 * @param incAmount - the amount increasing specific stat by item
	 * @param incStat - the stat which will be increased by item
	 */
	public Item(String name, float buyPrice, int incAmount, String incStat) {
		this.name = name;
		this.buyPrice = buyPrice;
		this.incAmount = incAmount;
		this.incStat = incStat;
		
	}
	
	/**
	 * @return the name of item
	 */
	public String getName() {
		
		return name;
	}
	/**
	 * @return the price of item to buy
	 */
	public float getPrice() {
	
		return buyPrice;
	}
	/**
     *
     */
	public void setSellPrice() {
		buyPrice *= SELL_PRICE_PENALTY;
	}
	/**
	 * @return the amount increasing specific stat by item
	 */
	public int getIncAmount() {
		
		return incAmount;
	}
	/**
	 * @return the stat which will be increased by item
	 */
	public String getIncStat() {
		
		return incStat;
	}

	/**
	 * @return description of item
	 */
	public String toString() {
		
		return String.format("item: %s%nEffect: %s +%d%nprice: %.2f%n%n", 
				this.name, this.incStat, this.incAmount, this.buyPrice);
	}
	
}
