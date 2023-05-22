package main;

import javax.swing.ImageIcon;

import main.gameObject.Product;
import main.gameObject.athletes.Athlete;

/**
 * Interface that is used in CmdLineUi, GameEnvironment.
 * @author H Yang, J Kim
 */
public interface UserInterface {

	/**
	 * Error message for containing special character in team name
	 */
	String NAME_CHAR_REQUIREMENT = "Team name cannot include any special character.";

	/**
	 * Error message for team name length is not between 3 and 15
	 */
	String NAME_LENGTH_REQUIREMENT = "The length of team name has to be between 3 to 15.";

	/**
	 * Regular Expression about team name requirement
	 */
	String NAME_REGEX = "^[A-Za-z0-9]{3,15}$";

	/**
	 * Regular Expression about number of season
	 */
	String SEASON_REGEX = "([5-9]|1[0-5])";

	/**
	 * Error message about invalid total season number input
	 */
	String VALID_NUMBER = "Please enter a valid number.\nThe number of weeks for the season has to be between 5 to 15.";

	/**
	 * Error message about invalid number
	 */
	String INVALID_NUMBER = "Invalid number please enter it again.";


	/**
	 * initial setup about each user interface
	 * @param gameEnvironment this program's entire system
	 */
	void setup(GameEnvironment gameEnvironment);

	/**
	 * Reformat string in html to use product name for JLabel.
	 * @param product products that player can purchasable
	 * @return String value formatted in html
	 */
	default String printingName(Product product) {

		return (product == null) ? "EMPTY" : String.format("<html>%s</html>", product.getName());
	}

	/**
	 * Reformat string in html to use product detail for JLabel.
	 * @param product products that player can purchasable
	 * @return String value formatted in html
	 */
	default String printing(Object product) {

		return (product == null) ? "EMPTY" : String.format("<html>%s</html>",
									product.toString().replace("\n", "<br/>"));
	}

	/**
	 * Get image from Product and process.
	 * Defined as default method because there is no image in Class Item.
	 * @param athlete An athlete needing to return images
	 * @return athlete face photo, if athlete is null return null
	 */
	default ImageIcon printingFacePhoto(Product athlete) {
		if (athlete == null) {return null;}
		else {return athlete.getAthleteFacePhoto();}
	}
}

