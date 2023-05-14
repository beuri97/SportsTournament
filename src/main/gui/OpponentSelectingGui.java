package main.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class OpponentSelectingGui {

	private JFrame frmOpponentSelec;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpponentSelectingGui window = new OpponentSelectingGui();
					window.frmOpponentSelec.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OpponentSelectingGui() {
		setup();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void setup() {
		frmOpponentSelec = new JFrame();		
		frmOpponentSelec.setSize(1650,1080);
		frmOpponentSelec.getContentPane().setLayout(null);
//		frmOpponentSelec.setVisible(true);
	}

}
