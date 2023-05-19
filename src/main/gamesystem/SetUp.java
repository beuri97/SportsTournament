package main.gamesystem;

import main.gameObject.Product;
import main.gameObject.Team;
import main.gameObject.athletes.Athlete;
import main.gamesystem.Exception.EmptySlotException;
import main.gamesystem.Exception.IllegalInputException;
import main.gamesystem.Exception.NoSpaceException;

import java.util.Random;

public class SetUp {

    Random random = new Random();
    public void checkRegex(String input, final String REGEX, String message) throws IllegalInputException {

        if(!input.matches(REGEX)) {
            throw new IllegalInputException(message);
        }
    }

//    public void tradingManager(Team team, Market market, String type, Product[] stock, int col) {
//
//        switch(type) {
//            case "buy":
//                Product[] properties = (stock instanceof Athlete[]) ? team.getRoster() : team.getInventory();
//                if(stock[col] == null) throw new EmptySlotException();
//                if(team.isFull(properties)) throw new NoSpaceException();
//                team.setMoney(- stock[col].getPrice());
//                Product product = market.purchase(stock, col);
//                if (product instanceof Athlete) {
//                    team.recruitAthletes(product);
//                } else {
//                    team.addItem(product);
//                }
//                break;
//
//            case "sell":
//                if(stock[col] == null) throw new EmptySlotException();
//                Product sale = stock[col];
//                team.setMoney(sale.getPrice());
//                if(stock[col] instanceof Athlete) team.leaveAthletes(col);
//                else team.removeItem(col);
//                break;
//        }
//    }

    public void reducedStamina(Athlete[] athletes, boolean lose) {
        final int CORRECTION = (!lose) ? 1 : 2;
        for (Athlete athlete : athletes) {

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

    public int randomInt(int origin, int bound) {

        if(origin == 0) origin = 1;
        return random.nextInt(1, bound);
    }

}
