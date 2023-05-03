package main.gameObject;

import main.gameObject.athletes.Athlete;

/**
 * Class for create opponent Team(NPC)
 * @author H Yang
 */
public class Opponent extends Team{

    public Opponent(Athlete[] athletes) {

        for(Athlete athlete : athletes) recruitAthletes(athlete);
    }
}
