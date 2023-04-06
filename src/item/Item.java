package item;


public class Item {
	private String name;
	private float buy_price;
	private int inc_amount;
	private String inc_stat;
	
	
	public Item(String name, float buy_price, int inc_amount, String inc_stat) {
		this.name = name;
		this.buy_price = buy_price;
		this.inc_amount = inc_amount;
		this.inc_stat = inc_stat;
		
	}
	
	
	public String getName() {
		
		return name;
	}
	
	public float getBuyPrice() {
	
		return buy_price;
	}
	
	public double getSellPrice() {
		double i = getBuyPrice() * 0.7;		
		return i;
	}
	
	public int getInc_Amount() {
		
		return inc_amount;
	}
	public String getInc_Stat() {
		
		return inc_stat;
	}
	
	
	public static void main (String[] args) {
		Item RandomChicken = new RandomChicken();
		System.out.println(RandomChicken.getInc_Amount());
		System.out.println(RandomChicken.getInc_Stat());
		System.out.println(RandomChicken.getSellPrice());
		
	}
	
}
