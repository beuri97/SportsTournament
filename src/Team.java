import athletes.Athlete;
import java.util.ArrayList;

/**
 * Class for user's team. Class
 * TODO - Write about Class Team more detail
 * @Author Yang
 */
public class Team {

    ArrayList<Athlete> roster = new ArrayList<>();
    ArrayList<Object> inventory = new ArrayList<>();

    public void recruitAthletes(Athlete athlete) {

        roster.add(athlete);
    }

    public void leaveAthletes(Athlete athlete) {

        roster.remove(athlete);
    }

    public void addItem(Object item) {

        inventory.add(item);
    }
}
