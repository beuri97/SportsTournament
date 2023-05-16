package main.gameObject;

import main.gameObject.athletes.Athlete;
import main.gameObject.item.Item;
import main.gamesystem.Exception.InsufficientAthleteException;
import main.gamesystem.Exception.LackOfMoneyException;
import main.gamesystem.Exception.NoSpaceException;

import java.util.*;

/**
 * Class Team for user and opponents.
 * @author Yang
 */
public class Team {

    protected final int TOTAL_ATHLETE = 7;
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

    int gameWin;
    int totalGamePlay;


    /**
     * set Team Name
     * @param name Team name (3 - 15) characters without any special characters
     */
    public void setName(String name) {

        this.name = name;
    }

    public void setGameWin(){

        gameWin++;
    }

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

    public int getGameWin() {

        return gameWin;
    }

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
     * get total amount of money player has
     * @return player's money in type double
     */
    public double getMoney() {

        return money;
    }


    public void setMoney(double price) throws RuntimeException {

        if(money + price < 0) throw new LackOfMoneyException();
        money += price;
    }

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


        // if there is any null in array swap null to new athlete
        // else add new athlete at the end if total number of current athletes are less than 7
        for(int i=0; i<roster.size(); i++){
            if (roster.get(i) == null) {
                roster.set(i,(Athlete) athlete);
                break;
            }
        }
        if(roster.size()<=TOTAL_ATHLETE && !roster.contains((Athlete)athlete))
            roster.add((Athlete)athlete);

        // This will not run but keep it for this program to run safe
        else throw new NoSpaceException();
    }

 /**
 * Remove an athlete from the roster.
 * This method is for cases where a user sells an athlete
 * or an athlete is injured.
 * @param col target athlete's index that will be removed
 */
    public void leaveAthletes(Product athlete) {

        int index = roster.indexOf((Athlete) athlete);
        roster.set(index, null);
    }

    /**
     * Add item into inventory after user purchase item.
     * @param item item that user purchased
     */
    public void addItem(Product item) {

        for(int i=0; i<inventory.size(); i++){
            if (inventory.get(i) == null) {
                inventory.set(i,(Item) item);
                break;
            }
        }
        if(inventory.size() < TOTAL_ITEM && !inventory.contains((Item)item))
            inventory.add((Item) item);

        // This will not run but keep it for this program to run safe
        else throw new NoSpaceException();
    }
    
    /**
     * Remove an item from inventory if user use or sell the item.
     * @param col target item's index that will be removed
     */
    public void removeItem(int col) {
        inventory.set(col, null);
    }

    public boolean isFull(Product[] products) {

        //array has fixed length so if at least one null in this array this mean becomes array is not full
        for (Product product : products) {
            if (product == null) {
                return false;
            }
        }
        return true;
    }

    public void swapAthletes(int athlete1, int athlete2) {

        Collections.swap(roster, athlete1, athlete2);
    }
}
