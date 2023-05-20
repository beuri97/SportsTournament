package main.gui;

import java.awt.EventQueue;

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

public class GameOverGui implements UserInterface{

	private JFrame frmGameover;
	private GameEnvironment gameEnvironment;

	/**
	 * Create the application.
	 */
	public GameOverGui(GameEnvironment gameEnvironment) {
		setup(gameEnvironment);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void setup(GameEnvironment gameEnvironment) {
		frmGameover = new JFrame();
		frmGameover.setSize(1650,1080);
		frmGameover.setLocation((1925 - frmGameover.getWidth()) / 2, (1080 - frmGameover.getHeight()) / 2);
		frmGameover.getContentPane().setLayout(null);
		frmGameover.setVisible(true);
		
		
		JLabel gameOverLabel = new JLabel("Game Over!");
		gameOverLabel.setFont(new Font("Dialog", Font.BOLD, 80));
		gameOverLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gameOverLabel.setBounds(356, 224, 936, 213);
		frmGameover.getContentPane().add(gameOverLabel);
		
		JButton backToMainButton = new JButton("EXIT");
		backToMainButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		backToMainButton.setFont(new Font("Dialog", Font.BOLD, 28));
		backToMainButton.setBounds(702, 856, 266, 46);
		frmGameover.getContentPane().add(backToMainButton);
		
		JPanel resultDescriptionPanel = new JPanel();
		resultDescriptionPanel.setBounds(356, 450, 978, 355);
		frmGameover.getContentPane().add(resultDescriptionPanel);
		resultDescriptionPanel.setLayout(null);
		
		JLabel finalResultLabel = new JLabel("result");
		finalResultLabel.setFont(new Font("Dialog", Font.BOLD, 29));
		finalResultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		finalResultLabel.setBounds(12, 12, 954, 331);
		resultDescriptionPanel.add(finalResultLabel);
		
		int lastSeason = gameEnvironment.getCurrentSeason();
		int totalSeason = gameEnvironment.getTotalSeason();
		int[] playerOverall = gameEnvironment.getPlayerOverall();
		float rate = (playerOverall[1] != 0) ? (float)(playerOverall[0]/playerOverall[1])*100 : 0;
		finalResultLabel.setText(String.format("<html> You played %d week(s) out of %d weeks%n <br/><br/> "
								+ "Your game Summary: <br/>"
								+ "Your game difficulty was %s%n <br/> "
								+ "You Played %d you won %d%n <br/>"
								+ "Your percentage of victory is %.2f%n <br/>"
								+ "Thank You For Playing!!!</html>",lastSeason, totalSeason, gameEnvironment.getDifficulty()
								,playerOverall[1], playerOverall[0], rate));
		

	}
}
