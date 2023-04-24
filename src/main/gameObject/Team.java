package main.gameObject;

import main.gameObject.athletes.Athlete;
import main.gameObject.item.Item;

import java.util.ArrayList;

/**
 * Class Team for user and opponents.
 * @Author Yang
 */
public class Team {

    /**
     * Team name
     */
	String name;
    
    /**
     * Money that team(player) has
     */
    float money;
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
     * get Team's Athletes roster in 2D Array. First row(index 0) is regular athletes Second row(index 1) is reserves.
     * @return Athlete 2D array player has
     */
    public Athlete[] getRoster() {

        return this.roster.toArray(new Athlete[7]);
    }

    /**
     * get Team(players) inventory
     * @return Item array player has
     */
    public Item[] getInventory() {

        return this.inventory.toArray(new Item[8]);
    }

    /**
     * Add athletes into roster after purchase them
     * @param athlete an athlete that user purchased
     */
    public void recruitAthletes(Product athlete) {

        // place to regular array priority if the array has empty place
        // then place to reserve array
        //if all arrays are empty should return Exception -> TODO - this need to be implemented
        if (this.roster.size() < 7) {
            //add athletes - casting Product to Athletes
            this.roster.add((Athlete) athlete);
        } else {
            // TODO - Implement Exception here - Perhaps use try catch?
        }


 /**
 * Remove an athlete from the roster.
 * This method is for cases where a user sells an athlete
 * or an athlete is injured.
 * @param athlete target athlete that will be removed
 */
        }
    public void leaveAthletes(Athlete athlete) {

       this.roster.remove(athlete);
    }

    /**
     * Add item into inventory after user purchase item.
     * @param item item that user purchased
     */
    public void addItem(Product item) {

        if (this.inventory.size() < 8) {
            //append item after casting to Item
            this.inventory.add((Item) item);
        } //TODO - implement exception here
    }
    
    /**
     * Remove an item from inventory if user use or sell the item.
     * @param item target item that will be removed
     */
    public void removeItem(Item item) {
    	
    	this.inventory.remove(item);
    	
    }
}
