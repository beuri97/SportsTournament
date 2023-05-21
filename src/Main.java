import java.util.Scanner;

import javax.swing.SwingUtilities;

import main.CmdLineUi;
import main.GameEnvironment;
import main.UserInterface;
import main.gui.SetupWindowGui;

public class Main {


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