package main;

import java.util.Scanner;
import java.util.regex.Pattern;

import main.gameObject.Team;

public class GameEnvironment {
    /**
     * TODO- Discuss about constants' nad variables' type, generate javadoc comment
     */
    public final Object DIFFICULTY = null;
    
    int season;
    
    Team team;
    
    private GameEnvironmentUi userInterface;
    

	
	
	/**
	 * Start new game by setting up Team name, number of weeks for season and difficulty of game 
	 */
	public GameEnvironment(GameEnvironmentUi userInterface) {
			this.userInterface = userInterface;
			
	}
	
	public void start() {
		userInterface.setup(this);
		
	}
	
	
    
    
}


