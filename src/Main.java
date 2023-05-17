import java.util.Scanner;

import main.CmdLineUi;
import main.GameEnvironment;
import main.UserInterface;
import main.gui.SetupWindowGui;

public class Main {


    public static void main(String[] args) {
        
    	
    	Scanner scan = new Scanner(System.in);
    	String input = scan.nextLine();
    	
    	UserInterface ui = new CmdLineUi();;
    	GameEnvironment gameEnvironment = new GameEnvironment(ui);
    	
        if(input.length() >0 && (input.equals("cmd"))) {
        	gameEnvironment.start();   
        }
        else if(input.equals("gui")) {
        	gameEnvironment.openSetupWindow();
        }
    }
}