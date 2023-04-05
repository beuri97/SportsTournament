package gameObject.athletes.type;

import gameObject.athletes.Athlete;

public class Counter extends Athlete {

    public Counter(String name, int offensive, int defensive, int stamina, float price) {

        super("Dwayne Johnson", 120, 120, 90, 1200.00f);
        super.description = "I am the Rock!";
    }


    /**
     * Stamina adjustment for Counter type athletes
     * @param changedStamina athlete's stat change amount
     */
    @Override
    public void setStamina(int changedStamina) {
        super.stamina = (changedStamina < 0) ? (int)(super.stamina - changedStamina * 1.23) : (super.stamina + changedStamina);
    }
}
