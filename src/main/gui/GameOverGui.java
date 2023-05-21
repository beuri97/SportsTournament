package main.gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import main.GameEnvironment;
import main.UserInterface;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Class to create Game Over window in game
 * @author Joshua K
 *
 */
public class GameOverGui implements UserInterface{
	/**
	 * Frame for GameOver Window
	 */
	private JFrame frmGameover;

	/**
	 * Start game over window.
	 */
	public GameOverGui(GameEnvironment gameEnvironment) {
		setup(gameEnvironment);
	}

	/**
	 * setup the frame, Labels, a button for GameOver Window
	 * it shows the description about the player's play record.
	 */
	public void setup(GameEnvironment gameEnvironment) {
		frmGameover = new JFrame();
		frmGameover.setSize(1650,1080);
		frmGameover.setLocation((1925 - frmGameover.getWidth()) / 2, (1080 - frmGameover.getHeight()) / 2);
		frmGameover.getContentPane().setLayout(null);
		frmGameover.setVisible(true);
		
		//Big title label for game over window
		JLabel gameOverLabel = new JLabel("Game Over!");
		gameOverLabel.setFont(new Font("Dialog", Font.BOLD, 80));
		gameOverLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gameOverLabel.setBounds(356, 224, 936, 213);
		frmGameover.getContentPane().add(gameOverLabel);
		
		//create exit botton to close this game
		JButton backToMainButton = new JButton("EXIT");
		backToMainButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		backToMainButton.setFont(new Font("Dialog", Font.BOLD, 28));
		backToMainButton.setBounds(702, 856, 266, 46);
		frmGameover.getContentPane().add(backToMainButton);
		
		//create the panel for the game result
		JPanel resultDescriptionPanel = new JPanel();
		resultDescriptionPanel.setBounds(356, 450, 978, 355);
		frmGameover.getContentPane().add(resultDescriptionPanel);
		resultDescriptionPanel.setLayout(null);
		
		//label for the result description
		JLabel finalResultLabel = new JLabel("result");
		finalResultLabel.setFont(new Font("Dialog", Font.BOLD, 29));
		finalResultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		finalResultLabel.setBounds(12, 12, 954, 331);
		resultDescriptionPanel.add(finalResultLabel);
		
		//the week that the player stopped
		int lastSeason = gameEnvironment.getCurrentSeason();
		//the week that the player chosen at the start
		int totalSeason = gameEnvironment.getTotalSeason();
		//the game result as arrayList contains how many matches the player had and how many victories the player had
		int[] playerOverall = gameEnvironment.getPlayerOverall();
		//the percentage of victory
		float rate = (playerOverall[1] != 0) ? (float)(playerOverall[0]/playerOverall[1])*100 : 0;
		finalResultLabel.setText(String.format("<html> You played %d week(s) out of %d weeks%n <br/><br/> "
								+ "Your game Summary: <br/>"
								+ "Your game difficulty was %s <br/> "
								+ "You Played %d you won %d <br/>"
								+ "Your percentage of victory is %.2f <br/>"
								+ "Thank You For Playing!!!</html>",lastSeason, totalSeason, gameEnvironment.getDifficulty()
								,playerOverall[1], playerOverall[0], rate));
		

	}
}
