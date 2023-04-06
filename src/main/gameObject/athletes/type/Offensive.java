package main.gameObject.athletes.type;

import main.gameObject.athletes.Athlete;

public class Offensive extends Athlete {

    public Offensive (String name, int offensive, int defensive, int stamina, float price) {

        super("Dwayne Johnson", 135, 100, 100, 1200.00f);
        super.description = "I am the Rock!";
    }
}
