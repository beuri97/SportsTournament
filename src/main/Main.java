package main;

import javax.swing.SwingUtilities;

import main.gui.SetupWindowGui;


/**
 * Main Class. Whole system starts from here.
 */
public class Main {

    /**
     * Main method
     * @param args one argument is allowed which is 'cmd' for commandline interfaces
     */
    public static void main(String[] args) {
        
    	
    	UserInterface ui;
 
        if(args.length != 0 && args[0].equals("cmd")) {
        
        	ui = new CmdLineUi();
            GameEnvironment game = new GameEnvironment(ui);
            game.start();
        }
        else {
        	
        	ui = new SetupWindowGui();
            GameEnvironment game = new GameEnvironment(ui);
            SwingUtilities.invokeLater(() -> game.start());
        }
        

    }
}