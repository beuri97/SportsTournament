package main.gameObject;

import main.gameObject.athletes.Athlete;

/**
 * Class for create opponent Team(NPC)
 * @author H Yang
 */
public class Opponent extends Team{

    public Opponent(Product[] athletes) {

        for(Product athlete : athletes) recruitAthletes((Athlete) athlete);
    }
}
