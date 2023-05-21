package main.gameObject.athletes.type;

import javax.swing.ImageIcon;

import main.gameObject.athletes.Athlete;

public class Angelina extends Athlete {

    public Angelina() {

        super("Angelina Jolie", "I am pretty much warlike person!");
        
        switch(super.rarity.string) {
        
        case "N":
        	super.offenseStat = 35;
        	super.defenseStat = 20;
        	super.maxStamina = 85;
        	super.stamina = 85;
        	super.price = 1200.00f;
        	break;
        case "R":
        	super.offenseStat = 50;
        	super.defenseStat = 30;
        	super.maxStamina = 100;
        	super.stamina = 100;
        	super.price = 2000.00f;
        	break;
        case "SR":
        	super.offenseStat = 85;
        	super.defenseStat = 45;
        	super.maxStamina = 125;
        	super.stamina = 125;
        	super.price = 3200.00f;
        	break;
        case "SSR":
        	super.offenseStat = 100;
        	super.defenseStat = 65;
        	super.maxStamina = 150;
        	super.stamina = 150;
        	super.price = 4500.00f;
        	break;
        }
        super.athleteFacePhoto = new ImageIcon(getClass().getResource("/Images/AngelinaF.jpg"));
    }
}
