package main.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

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
		frmGameover.setTitle("GameOver");
		frmGameover.setSize(1650,1080);
		frmGameover.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
