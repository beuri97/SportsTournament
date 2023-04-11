package main.gameObject.item;

import main.gameObject.Product;

public class Item implements Product{
	private String name;
	private float buyPrice;
	private int incAmount;
	private String incStat;
	
	
	public Item(String name, float buy_price, int inc_amount, String inc_stat) {
		this.name = name;
		this.buyPrice = buy_price;
		this.incAmount = inc_amount;
		this.incStat = inc_stat;
		
	}
	
	
	public String getName() {
		
		return name;
	}
	
	public float getPrice() {
	
		return buyPrice;
	}
	
	public float getSellPrice() {
		float i = getPrice() * SELL_PRICE_PENALTY;		
		return i;
	}
	
	public int getInc_Amount() {
		
		return incAmount;
	}
	public String getInc_Stat() {
		
		return incStat;
	}
	
	
	public String toString() {
		
		return String.format("item: %s%nEffect: %s +%d%nprice: %.2f%n%n", 
				this.name, this.incStat, this.incAmount, this.buyPrice);
	}
	
}
