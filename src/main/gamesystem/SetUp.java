package main.gamesystem;

import main.gameObject.Product;
import main.gameObject.Team;
import main.gameObject.athletes.Athlete;
import main.gamesystem.Exception.EmptySlotException;
import main.gamesystem.Exception.IllegalInputException;
import main.gamesystem.Exception.NoSpaceException;

import java.util.Random;

public class SetUp {

    static Random random = new Random();
    public void checkRegex(String input, final String REGEX, String message) throws IllegalInputException {

        if(!input.matches(REGEX)) {
            throw new IllegalInputException(message);
        }
    }

    public void reducedStamina(Athlete[] athletes, boolean lose) {
        final int CORRECTION = (!lose) ? 1 : 2;
        for (Athlete athlete : athletes) {

            if(athlete != null)
                athlete.setStamina(-30*CORRECTION);
        }
    }

    public void refillStamina(Athlete[] athletes) {

        for (Athlete athlete : athletes) {

            athlete.setStamina(athlete.getMaxStamina());
        }

    }

    public boolean event(double percentage) {

        return random.nextDouble(100.00) <= percentage;
    }

    public static int randomInt(int bound) {


        return random.nextInt(1, bound);
    }


    public static int randomInt(int origin, int bound) {

        return random.nextInt(origin, bound);
    }

}
