package gameObject.athletes;

public class Athlete {

    /**
     * athlete's name
     */
    protected String name;

    /**
     * Description about types of athletes
     */
    protected String description;
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
     * @param offenseStat athlete's offense statistic
     * @param defenseStat athlete's defense statistic
     * @param stamina athlete's stamina
     * @param price athlete's price
     */
    public Athlete(String name, int offenseStat, int defenseStat, int stamina, float price) {

        this.name = name;
        this.offenseStat = offenseStat;
        this.defenseStat = defenseStat;
        this.stamina = stamina;
        this.price = price;
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
     * @param changedStamina athlete's stat change amount
     */
    public void setStamina(int changedStamina) {
        this.stamina += changedStamina;

        //if stat exceed maximum stamina then change it to maximum stamina
        if (this.stamina > this.maxStamina) this.stamina = this.maxStamina;
    }
}
