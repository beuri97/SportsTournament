package main.gameObject.athletes.type;

import main.gameObject.athletes.Athlete;
import main.gamesystem.Market.Rarity;

public class Prodo extends Athlete {

    public Prodo(Rarity rarity) {

        super("Prodo Baggins", rarity, "The ring was mine!");
      
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
