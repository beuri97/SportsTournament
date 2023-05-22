package main.gameObject.athletes.type;

import javax.swing.ImageIcon;

import main.gameObject.athletes.Athlete;

public class Prodo extends Athlete {

    public Prodo() {

        super("Prodo Baggins", "The ring was mine!");
        
        switch(super.rarity.string) {
        
        case "N":
        	super.offenseStat = 25;
        	super.defenseStat = 20;
        	super.maxStamina = 110;
        	super.stamina = 110;
        	super.price = 1340.00f;
        	break;
        case "R":
        	super.offenseStat = 40;
        	super.defenseStat = 30;
        	super.maxStamina = 100;
        	super.stamina = 100;
        	super.price = 2100.00f;
        	break;
        case "SR":
        	super.offenseStat = 60;
        	super.defenseStat = 55;
        	super.maxStamina = 125;
        	super.stamina = 125;
        	super.price = 3150.00f;
        	break;
        case "SSR":
        	super.offenseStat = 100;
        	super.defenseStat = 100;
        	super.maxStamina = 175;
        	super.stamina = 175;
        	super.price = 4390.00f;
        	break;
        }
        super.athleteFacePhoto = new ImageIcon(getClass().getResource("/Images/Prodo.jpg"));
    }

}
