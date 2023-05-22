package main.gamesystem;

import main.gameObject.Product;
import main.gameObject.Team;
import main.gameObject.athletes.Athlete;
import main.gamesystem.Exception.EmptySlotException;
import main.gamesystem.Exception.IllegalInputException;
import main.gamesystem.Exception.NoSpaceException;

import java.util.Random;

/**
 * Class SetUp controls additional logic that requires to Class GameEnvironment.
 *
 * @author H Yang
 */
public class SetUp {

    /**
     * random to use any random case
     */
    static Random random = new Random();

    /**
     * method that checks whether an input string satisfies the requirements for each situation.
     * This method throws IllegalInputException if requirement is not met.
     * @param input input string to be checked.
     * @param REGEX A regular expression expressing the requirements for each situation.
     * @param message extra message to show when exception happens.
     * @throws IllegalInputException (Optional) if input does not match to REGEX
     */
    public void checkRegex(String input, final String REGEX, String message) throws IllegalInputException {

        if(!input.matches(REGEX)) {
            throw new IllegalInputException(message);
        }
    }

    /**
     * Control athletes stamina.
     * Loss more stamina if player lose a match.
     * @param athletes player's athletes
     * @param lose true if athlete lost a match
     */
    public void reducedStamina(Athlete[] athletes, boolean lose) {
        // correction trigger - if athlete lose a match correction value becomes 2
        final int CORRECTION = (!lose) ? 1 : 2;

        for (Athlete athlete : athletes) {

            if(athlete != null)
                athlete.setStamina(-30*CORRECTION);
        }
    }

    /**
     * Control athletes stamina.
     * Refill athletes' stamina full.
     * @param athletes player's athletes
     */
    public void refillStamina(Athlete[] athletes) {

        for (Athlete athlete : athletes) {

            athlete.setStamina(athlete.getMaxStamina());
        }
    }

    /**
     * event method to trigger random events
     * @param percentage double value representing the upper bound
     * @return random double value that does not exceed 100
     */
    public boolean event(double percentage) {

        return random.nextDouble(100.00) < percentage;
    }

    /**
     * random method to get any random integer number
     * @param bound int value representing the upper bound of random case
     * @return random integer value
     */
    public static int randomInt(int bound) {


        return random.nextInt(1, bound);
    }

    /**
     * random method to get any random integer number
     * @param origin int value representing the origin of random case
     * @param bound int value representing the upper bound of random case
     * @return random integer value
     */
    public static int randomInt(int origin, int bound) {

        return random.nextInt(origin, bound);
    }

}
