package main.gameObject.athletes.type;

import javax.swing.ImageIcon;

import main.gameObject.athletes.Athlete;

public class Thorin extends Athlete {

    public Thorin (){
    	
    	super("Thorin II \"Oakenshield\"~", "This is not my kingdom!!!");
        
    	switch(super.rarity.string) {
        
        case "N":
        	super.offenseStat = 40;
        	super.defenseStat = 35;
        	super.maxStamina = 80;
        	super.stamina = 80;
        	super.price = 1500.00f;
        	break;
        case "R":
        	super.offenseStat = 70;
        	super.defenseStat = 50;
        	super.maxStamina = 100;
        	super.stamina = 100;
        	super.price = 2200.00f;
        	break;
        case "SR":
        	super.offenseStat = 95;
        	super.defenseStat = 80;
        	super.maxStamina = 120;
        	super.stamina = 120;
        	super.price = 3200.00f;
        	break;
        case "SSR":
        	super.offenseStat = 110;
        	super.defenseStat = 90;
        	super.maxStamina = 150;
        	super.stamina = 150;
        	super.price = 4700.00f;
        	break;
        }
        super.athletePhoto = new ImageIcon(getClass().getResource("/Images/Thorin.jpg"));
        super.athleteFacePhoto = new ImageIcon(getClass().getResource("/Images/ThorinF.jpg"));
    }
}
