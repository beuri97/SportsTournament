package item;


public class Item {
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
	
	public float getBuyPrice() {
	
		return buyPrice;
	}
	
	public double getSellPrice() {
		double i = getBuyPrice() * 0.7;		
		return i;
	}
	
	public int getInc_Amount() {
		
		return incAmount;
	}
	public String getInc_Stat() {
		
		return incStat;
	}
	
	
	public static void main (String[] args) {
		Item RandomChicken = new RandomChicken();
		System.out.println(RandomChicken.getInc_Amount());
		System.out.println(RandomChicken.getInc_Stat());
		System.out.println(RandomChicken.getSellPrice());
		
	}
	
}
