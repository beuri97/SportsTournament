package main.gameObject;

import main.gameObject.athletes.Athlete;
import main.gameObject.item.Item;

import java.util.List;
import java.util.Arrays;

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
     * Athletes' roster. Regular Athletes are in first row reserves are in second row.
     */
    Athlete[][] roster = new Athlete[][] {new Athlete[4], new Athlete[3]};
    
    /**
     * Item Inventory
     */
    Item[] inventory = new Item[5];


    public void setName(String name) {

        this.name = name;
    }

    public String getName(){

        return this.name;
    }
    /**
     * Add athletes into roster after purchase them
     * @param athlete an athlete that user purchased
     */
    public void recruitAthletes(Athlete athlete) {

        if (this.roster[0].length < 4) {
            List<Athlete> temp = Arrays.asList(this.roster[0]);
            temp.add(athlete);
            roster[0] = temp.toArray(this.roster[0]);
        } else if (this.roster[1].length < 3) {
            List<Athlete> temp = Arrays.asList(this.roster[1]);
            temp.add(athlete);
            this.roster[1] = temp.toArray(this.roster[1]);
        }
    }

    /**
     * Remove an athlete from the roster.
     * This method is for cases where a user sells an athlete 
     * or an athlete is injured.
     * @param row index to represent where athletes are currently in Regular(0) or reserve(1).
     * @param col index to represent an athlete's location
     */
    public void leaveAthletes(int row, int col) {

        roster[row][col] = null;

    }

    /**
     * Add item into inventory after user purchase item.
     * @param item item that user purchased
     */
    public void addItem(Item item) {

        if (this.inventory.length < 5) {
            List<Item> temp = Arrays.asList(this.inventory);
            temp.add(item);
            this.inventory = temp.toArray(this.inventory);
        }
    }
    
    /**
     * Remove an item from inventory if user use or sell the item.
     * @param index Represent items location
     */
    public void removeItem(int index) {
    	
    	inventory[index] = null;
    	
    }
}
