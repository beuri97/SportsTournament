package main.gameObject;

import javax.swing.ImageIcon;

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
	 */
	void setSellPrice();

	/**
	 * get Product's name
	 * @return String value about product's name
	 */
	String getName();

	/**
	 * method to return athlete's photo.
	 * Defined as default method because there is no plan to implement this method to Class Item.
	 * @return ImageIcon value about each athlete's photo
	 */
	default ImageIcon getAthleteFacePhoto() {
		return null;	
	}

}
