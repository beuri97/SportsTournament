package main.gameObject.athletes.type;

import main.gameObject.athletes.Athlete;

public class Stamina extends Athlete {

    public Stamina(String name, int offensive, int defensive, int stamina, float price){

        super("Dwayne Johnson", 100, 100, 130, 1200.00f);
        super.description = "I am the Rock!";
    }
}
