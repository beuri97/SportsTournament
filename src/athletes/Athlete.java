package athletes;

public class Athlete {

    /**
     * athlete's name
     */
    protected String name;

    /**
     * athletes' maximum Offensive statistics
     */
    protected int maxOffenseStat;

    /**
     * athletes' maximum Defensive statistics
     */
    protected int maxDefenseStat;

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
     * //@param offenseStat athlete's offense statistic
     * //@param defenseStat athlete's defense statistic
     * //@param stamina athlete's stamina
     * //@param health athlete's health
     * //@param price athlete's price
     */
    public Athlete(String name) {

        this.name = name;
        // this.offenseStat = offenseStat;
        // this.defenseStat = defenseStat;
        // this.stamina = stamina;
        // this.health = health;
        // this.price = price;
    }

    /**
     * get athlete's name
     * @return name of athlete
     */
    public String getName() {return this.name;}

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
     * check if an athlete is injured
     * @return athletes' injured status
     */
    public boolean isInjured() {return this.injured;}

    /**
     * set offense statistics
     * @param changedStat athlete's stat change amount
     */
    public void setOffenseStat(int changedStat) {
        this.offenseStat += changedStat;

        //if stat exceed maximum stat then change it to maximum stat
        if (this.offenseStat > this.maxOffenseStat) this.offenseStat = this.maxOffenseStat;
    }
    public void setDefenseStat(int changedStat) {
        this.defenseStat += changedStat;

        //if stat exceed maximum stat then change it to maximum stat
        if (this.defenseStat > this.maxDefenseStat) this.defenseStat = this.maxDefenseStat;
    }
    public void setStamina(int changedStamina) {
        this.stamina += changedStamina;

        //if stat exceed maximum stamina then change it to maximum stamina
        if(this.stamina > this.maxStamina) this.stamina = this.maxStamina;
    }

    /**
     * set this.injured true if athletes' stamina is equal to or lower than 0
     */
    public void setInjured() { if(this.stamina <= 0) this.injured = true; }
}
