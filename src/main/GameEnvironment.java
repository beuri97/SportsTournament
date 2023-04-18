package main;

import main.gameObject.Team;

public class GameEnvironment {
    /**
     * TODO- Discuss about constants' nad variables' type, generate javadoc comment
     */
    public final Object DIFFICULTY = null;
    
    int season;
    
    Team team;
    
    private UserInterface userInterface;
    

	
	
	/**
	 * Start new game by setting up Team name, number of weeks for season and difficulty of game 
	 */
	public GameEnvironment(UserInterface userInterface) {
			this.userInterface = userInterface;
			
	}
	
	public void start() {
		userInterface.setup(this);
		
	}
	
	
    
    
}


