package main.gameObject;

/**
 * Interface for purchasable objects such as {@link main.gameObject.athletes.Athlete Athlete} 
 * and {@link main.gameObject.item.Item Item}.
 * @author H Yang
 *
 */
public interface Product {
	
	/**
	 * Apply this Penalty when user try to sell 
	 * {@link main.gameObject.athletes.Athlete Athlete}s or {@link main.gameObject.item.Item Item}s
	 */
	public float SELL_PRICE_PENALTY = 0.7f;

	/**
	 * Get price of product
	 * @return Products'({@link main.gameObject.athletes.Athlete Athlete}s 
	 * and {@link main.gameObject.item.Item Item}s) default price
	 */
	float getPrice();
	
	/**
	 * get amount of price of Products({@link main.gameObject.athletes.Athlete Athletes}
	 * and {@link main.gameObject.item.Item Items}) to sell
	 * @return Products' ({@link main.gameObject.athletes.Athlete Athletes}}
	 * and {@link main.gameObject.item.Item Items}) selling price
	 */
	float getSellPrice();

	String getName();

	String toString();
}
