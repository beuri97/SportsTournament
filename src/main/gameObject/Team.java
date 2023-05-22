package main.gameObject;

import main.gameObject.athletes.Athlete;
import main.gameObject.item.Item;
import main.gamesystem.Exception.InsufficientAthleteException;
import main.gamesystem.Exception.LackOfMoneyException;
import main.gamesystem.Exception.NoSpaceException;

import java.util.*;

/**
 * Represent an object Team for user and opponents This class will give basic information about player Team.
 * This class will use team roster only when this class use as opponent team.
 * @author Yang
 */
public class Team {

    /**
     * Total number of athlete that team can have
     */
    protected final int TOTAL_ATHLETE = 7;

    /**
     * Total number of item that team can have
     */
    protected final int TOTAL_ITEM = 10;

    /**
     * Team name
     */
    String name;
    
    /**
     * Money that team(player) has
     */
    double money;
    /**
     * Athletes' roster. Regular Athletes are in index 0 - 3(inclusive) reserves are in index 4 - 6(inclusive).
     */
    ArrayList<Athlete> roster = new ArrayList<>();
    
    /**
     * Item Inventory
     */
    ArrayList<Item> inventory = new ArrayList<>();

    /**
     * Number of game this team win
     */
    int gameWin;

    /**
     * Number of game this team played
     */
    int totalGamePlay;

    /**
     * Set Team Name
     * @param name Team name (3 - 15) characters without any special characters
     */
    public void setName(String name) {

        this.name = name;
    }

    /**
     * Method for adding the number of games won
     */
    public void setGameWin(){

        gameWin++;
    }

    /**
     * Method for adding the number of games played
     */
    public void setTotalGamePlay() {

        totalGamePlay++;
    }

    /**
     * get method to return Team name
     * @return Team name
     */
    public String getName(){

        return name;
    }

    /**
     * Get number of game this team played
     * @return integer value about team's total matches played
     */
    public int getGameWin() {

        return gameWin;
    }

    /**
     * Get number of game this team won
     * @return integer value about team's win on matches
     */
    public int getTotalGamePlay() {

        return totalGamePlay;
    }

    /**
     * get Team's Athletes roster in Array converted from ArrayList.
     * Index 0 - 3 represent regular 4 - 6 represent reserves
     * @return Athlete array player has
     */
    public Athlete[] getRoster() {

        return roster.toArray(new Athlete[TOTAL_ATHLETE]);
    }

    /**
     * get Team(players) inventory in an array converted from the ArrayList
     * @return Item array player has
     */
    public Item[] getInventory() {

        return inventory.toArray(new Item[TOTAL_ITEM]);
    }

    /**
     * get total amount of money this team has.
     * @return player's money in type double
     */
    public double getMoney() {

        return money;
    }

    /**
     * Team's money control method. This method will add and subtract money that user earn or spend.
     * @param price total price user earn or spend
     * @throws RuntimeException (optional) throws LackOfMoneyException if team does not have enough money.
     */
    public void setMoney(double price) throws RuntimeException {

        if(money + price < 0) throw new LackOfMoneyException();
        money += price;
    }

    /**
     * Check method to check if this team meets the requirement to have match.
     */
    public void isQualify(){
        int count = 0;

        for (Athlete athlete : this.getRoster()) {
            if (athlete != null) count++;
            if (athlete != null && count < 4 && athlete.isInjured()) throw new InsufficientAthleteException("Detected Injured regular athletes.");
            if (athlete == null && count < 4) throw new InsufficientAthleteException();
        }
 
    }

    /**
     * Add athletes into roster after purchase them
     * @param athlete an athlete that user purchased
     */
    public void recruitAthletes(Product athlete) {

        // add athlete if number of athletes in roster is not exceed constant TOTAL_ATHLETES
        if(roster.size()<=TOTAL_ATHLETE && !roster.contains((Athlete)athlete)) {
            roster.add(0, (Athlete) athlete);
            athlete.setSellPrice();
        }

        // This will not run but keep it for this program to run safe
        else throw new NoSpaceException();
    }

 /**
 * Remove an athlete from the roster.
 * This method is for cases where a user sells an athlete
 * or an athlete is injured.
 * @param athlete target athlete's index that will be removed
 */
    public void leaveAthletes(Product athlete) {

        roster.remove((Athlete) athlete);
    }

    /**
     * Add item into inventory after user purchase item.
     * @param item item that user purchased
     */
    public void addItem(Product item) {


        if(inventory.size() < TOTAL_ITEM && !inventory.contains((Item)item)) {
            inventory.add((Item) item);
            item.setSellPrice();
        }

        // This will not run but keep it for this program to run safe
        else throw new NoSpaceException();
    }
    
    /**
     * Remove an item from inventory if user use or sell the item.
     * @param item target item's index that will be removed
     */
    public void removeItem(Product item) {
        inventory.remove((Item) item);
    }

    public boolean isFull() {

        //array has fixed length so if at least one null in this array this mean becomes array is not full
        return this.roster.size() == TOTAL_ATHLETE;
    }

    /**
     * Swap the position or order of athletes.
     * @param athlete1 athlete to be swapped with athlete2
     * @param athlete2 athlete to be swapped with athlete1
     */
    public void swapAthletes(int athlete1, int athlete2) {

        Collections.swap(roster, athlete1, athlete2);
    }
}
