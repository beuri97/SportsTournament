package main;

import javax.swing.ImageIcon;

import main.gameObject.Product;
import main.gameObject.athletes.Athlete;

/**
 * Interface that is used in CmdLineUi, GameEnvironment.
 * @author H Yang, J Kim
 */
public interface UserInterface {

	
	String NAME_CHAR_REQUIREMENT = "Team name cannot include any special character.";
	
	String NAME_LENGTH_REQUIREMENT = "The length of team name has to be between 3 to 15.";

	String NAME_REGEX = "^[A-Za-z0-9]{3,15}$";

	String SEASON_REGEX = "([5-9]|1[0-5])";
	String VALID_NUMBER = "Please enter a valid number.\nThe number of weeks for the season has to be between 5 to 15.";
	String INVALID_NUMBER = "Invalid number please enter it again.";


//	void main();
	
	void setup(GameEnvironment gameEnvironment);
	
	default String printingName(Product product) {

		return (product == null) ? "EMPTY" : String.format("<html>%s</html>", product.getName());
	}

	default String printing(Object product) {

		return (product == null) ? "EMPTY" : String.format("<html>%s</html>",
									product.toString().replace("\n", "<br/>"));
	}
	
	default ImageIcon printingFacePhoto(Product athlete) {
		if (athlete == null) {return null;}
		else {return athlete.getAthleteFacePhoto();}
	}
}

