package gameObject;

import gameObject.athletes.Athlete;
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
    Athlete[] roster = new Athlete[7];
    Object[] inventory = new Object[5];

    public void recruitAthletes(Athlete athlete) {

        if (roster.length < 7) {
            List<Athlete> temp = Arrays.asList(roster);
            temp.add(athlete);
            roster = temp.toArray(roster);
        }
    }

    public void leaveAthletes(Athlete athlete) {

        List<Athlete> temp = Arrays.asList(roster);
        temp.remove(athlete);
        roster = temp.toArray(roster);

    }

    public void addItem(Object item) {

        if (roster.length < 5) {
            List<Object> temp = Arrays.asList(inventory);
            temp.add(item);
            inventory = temp.toArray(inventory);
        }
    }
}
