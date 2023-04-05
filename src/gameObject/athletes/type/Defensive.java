package gameObject.athletes.type;

import gameObject.athletes.Athlete;

public class Defensive extends Athlete {

    public Defensive(String name, int offensive, int defensive, int stamina, float price){

        super("Dwayne Johnson", 100, 135, 100, 1200.00f);
        super.description = "I am the Rock!";
    }
}
