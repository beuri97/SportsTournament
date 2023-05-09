package main.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class SelectingOpponentGui {

	private JFrame frmSelectingopponent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectingOpponentGui window = new SelectingOpponentGui();
					window.frmSelectingopponent.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SelectingOpponentGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSelectingopponent = new JFrame();
		frmSelectingopponent.setTitle("SelectingOpponent");
		frmSelectingopponent.setSize(1650,1080);
		frmSelectingopponent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSelectingopponent.getContentPane().setLayout(null);
	}

}
