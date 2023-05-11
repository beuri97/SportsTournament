package main.gamesystem;

import main.GameEnvironment;
import main.gameObject.Team;
import main.gameObject.athletes.Athlete;

import java.util.Random;

/**
 * Class for running main battle system.
 * Control all available battle sequences logic and give result to player.
 * Class is received command from a user interface via gameEnvironment and execute relevant methods
 * @author H Yang
 */
public class GameManager{

    /**
     *  TODO - How do I explain this??
     */
    private final Random random = new Random();

    /**
     * Opponent team to play with
     */
    private Team opponent;

    /**
     * player team itself
     */
    private Team player;

    /**
     * player's athlete who is on the stadium
     */
    private Athlete playerAthlete;

    /**
     * opponent's athlete who is on the stadium
     */
    private Athlete opponentAthlete;

    /**
     * Adjusted offensive and defensive statistics for game playing
     * use this statistics to get pseudorandom number to fight
     */
    private int buffOffensive, nerfOffensive, buffDefensive, nerfDefensive;

    /**
     * Define total number of set of each game
     */
    private final int TOTAL_SET = 4;

    /**
     * Define total number of set score of each set
     */
    private final int SET_SCORE = 3;

    /**
     * value of player and Opponent set score
     */
    private int playerSetScore, opponentSetScore;

    /**
     * value of player's and opponent's total game score
     */
    private int playerGameScore, opponentGameScore;

    /**
     * Define current set of game
     */
    private int setNumber;

    /**
     * flag for whether each athlete get score
     */
    private boolean playerScored, opponentScored;

    /**
     * Game Manager Constructor
     * @param gameEnvironment main game environment system
     */
    public GameManager(GameEnvironment gameEnvironment, Team opponent) {

        this.opponent = opponent;
        this.player = gameEnvironment.getTeam();
        this.setNumber = 1;
        this.playerOnStadium();
        this.buffOffensive = playerAthlete.getOffenseStat() +30;
        this.nerfOffensive = playerAthlete.getOffenseStat() + 10;
        this.buffDefensive = playerAthlete.getDefenseStat() + 15;
        this.nerfDefensive = playerAthlete.getDefenseStat() + 5;

    }

    /**
     * get opponent detail
     * @return Opponent team as Team Class
     */
    public Team getOpponent() {

        return this.opponent;
    }

    /**
     * method for report player game score
     * @return player's current game score as integer
     */
    public int getPlayerGameScore() {

        return this.playerGameScore;
    }

    /**
     * method for report opponent game score
     * @return opponent's current game score as integer
     */
    public int getOpponentGameScore() {

        return this.opponentGameScore;
    }

    /**
     * Check whether set is over
     * @return if at least one athlete get 3 score this method returns true
     */
    public boolean isSet() {

        boolean result = false;
        if (this.playerSetScore == SET_SCORE || this.opponentSetScore == SET_SCORE) {
            result = true;
            this.playerSetScore = 0;
            this.opponentSetScore = 0;
            setNumber++;
            this.playerOnStadium();
        }

        return result;
    }

    /**
     * Check whether game is finish
     * @return if at least one Team's score is 12 this method returns true
     */
    public boolean isGame() {

        return this.setNumber > this.TOTAL_SET;
    }

    /**
     * Adjusting method for player's athlete's offensive statistics.
     * @param flag use integer value 0 and 1.
     *             When flag is 0, minimum and maximum of adjusted statistics become increased
     *             When flag is 1, minimum and maximum of adjusted statistics become decreased
     */
    public void setOffensiveAdjust(int flag) {

        switch (flag) {

            case 0 :
                this.nerfOffensive += random.nextInt(5,15);
                this.buffOffensive += random.nextInt(5, 30);
                if (this.buffOffensive <= this.nerfOffensive) this.buffOffensive = random.nextInt(6) + 1;

            case 1:
                this.nerfOffensive = Math.max(this.nerfOffensive - random.nextInt(5,15), 0);
                this.buffOffensive -= random.nextInt(3, 10);
                if (this.buffOffensive <= this.nerfOffensive) this.buffOffensive = random.nextInt(6) + 1;
        }
    }

    /**
     * Adjusting method for player's athlete's defensive statistics.
     * @param flag use integer value 0 and 1.
     *             When flag is 0, minimum and maximum of adjusted statistics become increased
     *             When flag is 1, minimum and maximum of adjusted statistics become decreased
     */
    public void setDefensiveAdjust(int flag) {

        switch (flag) {

            case 0 :

                this.nerfDefensive += random.nextInt(5,10);
                this.buffDefensive += random.nextInt(7, 15);
                if (this.buffDefensive <= this.nerfDefensive) this.buffDefensive = random.nextInt(3) + 1;

            case 1:
                this.nerfDefensive = Math.max(this.nerfDefensive - random.nextInt(5, 10), 0);
                this.buffDefensive -= random.nextInt(3, 7);
                if (this.buffDefensive <= this.nerfDefensive) this.buffDefensive = random.nextInt(3) + 1;
        }
    }

    /**
     * main battle is executed when this method is called.
     */
    public void battle() {

        do {
            // Use Athletes offense and defense stat to get result of each battle
            int opponentOffense = opponentAthlete.getOffenseStat();
            int opponentDefense = opponentAthlete.getDefenseStat();
            // use random numerical value from revised stats that is revised with nerf and buff stat
            double playerAttackStat = random.nextDouble(this.nerfOffensive, this.buffOffensive);
            double playerDefenseStat = random.nextDouble(this.nerfDefensive, this.buffDefensive);
            double opponentAttackStat =  random.nextDouble(opponentOffense - 10, opponentOffense + 30);
            double opponentDefenseStat = random.nextDouble(opponentDefense - 10, opponentDefense + 30);
            // analyze outcome of the battle
            if (playerAttackStat > opponentDefenseStat) {
                this.playerScored = true;
                this.playerSetScore++;
                this.playerGameScore++;
            }
            if (opponentAttackStat > playerDefenseStat) {
                this.opponentScored = true;
                this.opponentSetScore++;
                this.opponentGameScore++;
            }

        } while (!this.playerScored && !this.opponentScored);

        //reset flag when while loop is terminated
        this.playerScored = false;
        this.opponentScored = false;
    }

    /**
     * assign playerAthlete and opponentAthlete during each set for battle
     */
    public void playerOnStadium() {

        this.playerAthlete = this.player.getRoster()[this.setNumber - 1];
        this.opponentAthlete = this.opponent.getRoster()[this.setNumber -1];
    }

    /**
     * Report method for give result of the game
     * @return game result in string
     */
    public String gameResult() {

        String result;
        if (this.playerGameScore > this.opponentGameScore) result = "YOU WIN";
        else if (this.playerGameScore == this.opponentGameScore) result = "DRAW";
        else result = "YOU LOSE";

        return result;
    }
}