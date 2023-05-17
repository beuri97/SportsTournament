package main.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class GameOverGui {

	private JFrame frmGameover;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameOverGui window = new GameOverGui();
					window.frmGameover.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameOverGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGameover = new JFrame();
		frmGameover.setSize(1650,1080);
		frmGameover.setLocation((1925 - frmGameover.getWidth()) / 2, (1080 - frmGameover.getHeight()) / 2);
		frmGameover.getContentPane().setLayout(null);
		
		JButton backToMainButton = new JButton("Back to main");
		backToMainButton.setBounds(758, 860, 266, 46);
		frmGameover.getContentPane().add(backToMainButton);
		
		JPanel resultDescription = new JPanel();
		resultDescription.setBounds(555, 517, 707, 291);
		frmGameover.getContentPane().add(resultDescription);
		
		JLabel gameOverLabel = new JLabel("Game Over!");
		gameOverLabel.setFont(new Font("Dialog", Font.BOLD, 39));
		gameOverLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gameOverLabel.setBounds(380, 228, 936, 213);
		frmGameover.getContentPane().add(gameOverLabel);
	}

}
