package main.gameObject.athletes;
import main.gameObject.Product;
import main.gameObject.Rarity;

/**
 * Class to implement athletes objects in game
 * @author Yang
 *
 */
public class Athlete implements Product{

    /**
     * athlete's name
     */
    protected String name;

    /**
     * Description about types of athletes
     */
    protected String description;
    
    /**
     * Athletes' Rarity
     */
    protected Rarity rarity;
    
    /**
     * athletes' maximum Stamina
     */
    protected int maxStamina;

    /**
     * offense statistics for athletes, and it will be deducted if the position of an athlete is offender
     */
    protected int offenseStat;

    /**
     * defense statistics for athletes, and it will be deducted if the position of an athlete is defender
     */
    protected int defenseStat;

    /**
     * athletes' stamina, and it will be deducted if the athletes goes to match.
     */
    protected int stamina;

    /**
     * athletes' price
     */
    protected float price;

    /**
     * athletes' injured status will be true if stamina is less than or equal to 0
     */
    protected boolean injured;

    /**
     * Athlete Constructor to create Athletes
     * @param name athlete's name
     * @param description athlete's description
     */
    public Athlete(String name, String description) {
    	
    	
        this.name = name;
        this.rarity = Rarity.setRarity();
        this. description = description;
    }

    /**
     * get athlete's name
     * @return name of athlete
     */
    public String getName() {return this.name;}

    /**
     * get athlete's description
     * @return athlete's description
     */
    public String getDescription() { return this.description; }

    /**
     * get athlete's rarity in string
     * return athlete's rarity
     */
    public String getRarity() { return this.rarity.string; }

    /**
     * get athletes' offensive statistic
     * @return athlete's offense stat
     */
    public int getOffenseStat() {return this.offenseStat;}

    /**
     * get athletes' defensive statistics
     * @return athlete's defense stat
     */
    public int getDefenseStat() {return this.defenseStat;}

    /**
     * @return get athletes' stamina
     */
    public int getStamina() {return this.stamina;}

    /**
     * show athletes' price
     * @return athletes' price
     */
    public float getPrice() {return this.price;}

    /**
     * check if an athlete is injured,
     * athletes' injured variable becomes true if athletes' stamina is lower than or equal to zero
     * @return athletes' injured status
     */
    public boolean isInjured() {

        this.injured = this.stamina <= 0;
        return this.injured;
    }

    /**
     * set offense statistics
     * @param changedStat athlete's stat change amount
     */
    public void setOffenseStat(int changedStat) { this.offenseStat += changedStat; }

    /**
     * set defensive statistics
     * @param changedStat athlete's stat change amount
     */
    public void setDefenseStat(int changedStat) { this.defenseStat += changedStat; }

    /**
     * set changed Stamina, if stamina will adjust to maxStamina if the stamina exceed maximum Stamina
     * @param changedStamina athlete's stamina change amount
     */
    public void setStamina(int changedStamina) {
        this.stamina += changedStamina;

        //if stamina exceed maximum stamina then change it to maximum stamina
        if (this.stamina > this.maxStamina) this.stamina = this.maxStamina;
    }
    
    /**
     * toString method to show information about athletes.
     */
    @Override
    public String toString() {
    	
    	return String.format("Name: %s%nRarity: %s%nOffense: %d%nDefense: %d%nStamina: %d%nPrice: %.2f%nDescription: %s%n",
    			getName(), getRarity(), getOffenseStat(), getDefenseStat(), getStamina(), getPrice(), getDescription());
    }

	public float getSellPrice() {
		float sellPrice = this.price;
		sellPrice *= SELL_PRICE_PENALTY;
		
		return sellPrice;
	}
}
