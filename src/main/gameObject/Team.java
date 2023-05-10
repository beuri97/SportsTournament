package main.gameObject;

import main.gameObject.athletes.Athlete;
import main.gameObject.item.Item;
import main.gamesystem.Exception.LackOfMoneyException;
import main.gamesystem.Exception.NoSpaceException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Class Team for user and opponents.
 * @author Yang
 */
public class Team {

    protected final int TOTAL_ATHLETE = 7;
    protected final int TOTAL_ITEM = 14;
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
     * set Team Name
     * @param name Team name (3 - 15) characters without any special characters
     */
    public void setName(String name) {

        this.name = name;
    }

    /**
     * get method to return Team name
     * @return Team name
     */
    public String getName(){

        return this.name;
    }

    /**
     * get Team's Athletes roster in Array converted from ArrayList.
     * Index 0 - 3 represent regular 4 - 6 represent reserves
     * @return Athlete array player has
     */
    public Athlete[] getRoster() {

        return this.roster.toArray(new Athlete[TOTAL_ATHLETE]);
    }

    /**
     * get Team(players) inventory in an array converted from the ArrayList
     * @return Item array player has
     */
    public Item[] getInventory() {

        return this.inventory.toArray(new Item[TOTAL_ITEM]);
    }

    /**
     * get total amount of money player has
     * @return player's money in type double
     */
    public double getMoney() {

        return this.money;
    }


    public void setMoney(double price) throws RuntimeException {

        if(this.money + price < 0) throw new LackOfMoneyException();
        this.money += price;
    }

    /**
     * Add athletes into roster after purchase them
     * @param athlete an athlete that user purchased
     */
    public void recruitAthletes(Product athlete) {


        // if there is any null in array swap null to new athlete
        // else add new athlete at the end if total number of current athletes are less than 7
        for(int i=0; i<this.roster.size(); i++){
            if (this.roster.get(i) == null) {
                this.roster.set(i,(Athlete) athlete);
                break;
            }
        }
        if(this.roster.size()<=TOTAL_ATHLETE && !this.roster.contains((Athlete)athlete))
            this.roster.add((Athlete)athlete);

        // This will not run but keep it for this program to run safe
        else throw new NoSpaceException();
    }

 /**
 * Remove an athlete from the roster.
 * This method is for cases where a user sells an athlete
 * or an athlete is injured.
 * @param col target athlete's index that will be removed
 */
    public void leaveAthletes(int col) {

        this.roster.set(col, null);
    }

    /**
     * Add item into inventory after user purchase item.
     * @param item item that user purchased
     */
    public void addItem(Product item) {

        for(int i=0; i<this.inventory.size(); i++){
            if (this.inventory.get(i) == null) {
                this.inventory.set(i,(Item) item);
                break;
            }
        }
        if(this.inventory.size() < TOTAL_ITEM && !this.inventory.contains((Item)item))
            this.inventory.add((Item) item);

        // This will not run but keep it for this program to run safe
        else throw new NoSpaceException();
    }
    
    /**
     * Remove an item from inventory if user use or sell the item.
     * @param col target item's index that will be removed
     */
    public void removeItem(int col) {
        this.inventory.set(col, null);
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

        Collections.swap(this.roster, athlete1, athlete2);
    }
}
