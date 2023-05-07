package main.gamesystem;

import main.GameEnvironment;
import main.gameObject.Team;

public class GameManager {

    private GameEnvironment gameEnvironment;
    private Team opponent, player;
    private int buffMaximum, nerfMinimum;
    private final int TOTAL_SET = 4;
    private final int SET_SCORE = 3;

    private int playerSetScore, opponentSetScore;

    private int playerGameScore, opponentGameScore;

    private int setNumber;

    /**
     * Game Manager Constructor
     * @param gameEnvironment main game environment system
     */
    public GameManager(GameEnvironment gameEnvironment, Team opponent) {

        this.gameEnvironment = gameEnvironment;
        this.opponent = opponent;
        this.player = this.gameEnvironment.getTeam();
        this.buffMaximum = 30;
        this.nerfMinimum = 10;
    }

    public Team getOpponent() {

        return this.opponent;
    }
    public boolean isGame() {

        return this.setNumber > this.TOTAL_SET;
    }


    public boolean isSet() {

        return this.playerSetScore == SET_SCORE || this.opponentSetScore == SET_SCORE;
    }
}