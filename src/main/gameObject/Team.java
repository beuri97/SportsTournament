package main.gameObject;

import main.gameObject.athletes.Athlete;
import java.util.List;
import java.util.Arrays;

/**
 * Class for user's team. Class
 * TODO - Write about Class Team more detail
 * @Author Yang
 */
public class Team {

    String name;
    float money;
    Athlete[] roster = new Athlete[4];
    Athlete[] reserve = new Athlete[3];
    Object[] inventory = new Object[5];

    public void recruitAthletes(Athlete athlete) {

        if (this.roster.length < 4) {
            List<Athlete> temp = Arrays.asList(this.roster);
            temp.add(athlete);
            roster = temp.toArray(this.roster);
        } else if (this.reserve.length < 3) {
            List<Athlete> temp = Arrays.asList(this.reserve);
            temp.add(athlete);
            this.reserve = temp.toArray(this.reserve);
        }
    }

    public void leaveAthletes(Athlete athlete) {

        List<Athlete> temp = Arrays.asList(this.roster);
        temp.remove(athlete);
        this.roster = temp.toArray(this.roster);

    }

    public void addItem(Object item) {

        if (this.inventory.length < 5) {
            List<Object> temp = Arrays.asList(this.inventory);
            temp.add(item);
            this.inventory = temp.toArray(this.inventory);
        }
    }
}
