package main.gameObject.athletes.type;

import javax.swing.ImageIcon;

import main.gameObject.athletes.Athlete;

public class Dwayne extends Athlete {

    public Dwayne(){

        super("Dwayne Johnson",  "I am the Rock!");
        
        switch(super.rarity.string) {
        
        case "N":
        	super.offenseStat = 35;
        	super.defenseStat = 50;
        	super.maxStamina = 90;
        	super.stamina = 90;
        	super.price = 1400.00f;
        	break;
        case "R":
        	super.offenseStat = 50;
        	super.defenseStat = 75;
        	super.maxStamina = 110;
        	super.stamina = 110;
        	super.price = 2300.00f;
        	break;
        case "SR":
        	super.offenseStat = 75;
        	super.defenseStat = 95;
        	super.maxStamina = 125;
        	super.stamina = 125;
        	super.price = 3700.00f;
        	break;
        case "SSR":
        	super.offenseStat = 90;
        	super.defenseStat = 120;
        	super.maxStamina = 165;
        	super.stamina = 165;
        	super.price = 4500.00f;
        	break;
        }
        super.athletePhoto = new ImageIcon(getClass().getResource("/Images/Dwayne.jpg"));
        super.athleteFacePhoto = new ImageIcon(getClass().getResource("/Images/DwayneF.jpg"));
    }
}
