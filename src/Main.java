import main.CmdLineUi;
import main.GameEnvironment;
import main.UserInterface;

public class Main {


    public static void main(String[] args) {
        UserInterface ui = new CmdLineUi();
        GameEnvironment gameEnvironment = new GameEnvironment(ui);
        gameEnvironment.start();
    }
}