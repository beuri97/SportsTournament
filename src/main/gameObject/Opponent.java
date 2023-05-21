package main.gameObject;

import main.gameObject.athletes.Athlete;

/**
 * Class for create opponent Team(NPC)
 * @author H Yang
 */
public class Opponent extends Team{

    /**
     * constructor class to create Opponent as Team
     * @param athletes opponents athletes to be used
     */
    public Opponent(Athlete[] athletes) {

        for(Athlete athlete : athletes) recruitAthletes(athlete);
    }
}
