package main.gui;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import main.GameEnvironment;
import main.UserInterface;
import main.gameObject.Team;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectOpponentGui implements UserInterface{

	private JFrame frmSelectingOpponent;
	private JLabel chooseOpponentLabel;
	private Team[] teamAllOpponent;
	private JButton[] teamSelect = new JButton[5];
	private GameEnvironment gameEnvironment;
	private int selectedOpponentNum;

	/**
	 * Create the application.
	 */
	public SelectOpponentGui(GameEnvironment gameEnvironment) {
		this.gameEnvironment = gameEnvironment;
		this.teamAllOpponent = gameEnvironment.getAllOpponent();
		setup(gameEnvironment);
	}

	private String printTitle() {
		return String.format("%s vs Opponent Team No.%d",gameEnvironment.getTeam().getName(), selectedOpponentNum);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	public void setup(GameEnvironment gameEnvironment) {
		frmSelectingOpponent = new JFrame();
		frmSelectingOpponent.setSize(1650,1080);
		frmSelectingOpponent.getContentPane().setLayout(null);
		frmSelectingOpponent.setVisible(true);
		frmSelectingOpponent.setLocation((1925 - frmSelectingOpponent.getWidth()) / 2, (1080 - frmSelectingOpponent.getHeight()) / 2);
		
		chooseOpponentLabel = new JLabel("Choose Your Opponent!!");
		chooseOpponentLabel.setFont(new Font("Dialog", Font.BOLD, 28));
		chooseOpponentLabel.setHorizontalAlignment(SwingConstants.CENTER);
		chooseOpponentLabel.setBounds(489, 212, 707, 151);
		frmSelectingOpponent.getContentPane().add(chooseOpponentLabel);
		
		//create 5 buttons for selecting opponents
		for (int i=0; i < teamAllOpponent.length; i++) {
			teamSelect[i] = new JButton(String.format("<html>Opponent<br/>Team<br/> No.%d</html>", i+1));
			teamSelect[i].setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 17));
			frmSelectingOpponent.getContentPane().add(teamSelect[i]);
		}
		
		teamSelect[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedOpponentNum = 1;
				chooseOpponentLabel.setText(printTitle());}});
	
		
		teamSelect[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedOpponentNum = 2;
				chooseOpponentLabel.setText(printTitle());}});
		
		teamSelect[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedOpponentNum = 3;
				chooseOpponentLabel.setText(printTitle());}});

		teamSelect[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedOpponentNum = 4;
				chooseOpponentLabel.setText(printTitle());}});
		
		teamSelect[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedOpponentNum = 5;
				chooseOpponentLabel.setText(printTitle());}});	
		
		teamSelect[0].setBounds(489, 375, 120, 292);
		teamSelect[1].setBounds(635, 375, 120, 292);
		teamSelect[2].setBounds(779, 375, 120, 292);
		teamSelect[3].setBounds(925, 375, 120, 292);
		teamSelect[4].setBounds(1075, 375, 120, 292);
		
		
		for (int i = 0 ; i < teamAllOpponent.length; i++) {
			if (teamAllOpponent[i] == null) {
				teamSelect[i].setEnabled(false);
				
			}
		}
		
		JButton startAMatchButton = new JButton("Start a match!!");
		startAMatchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectedOpponentNum == 0) {
					chooseOpponentLabel.setText("Choose your Opponent!!!");
				}
				else {
					gameEnvironment.gameStart(selectedOpponentNum-1);
					finishedWindow();
					gameEnvironment.openStatiumWindow();;
				}

			}
		});
		startAMatchButton.setFont(new Font("Gentium", Font.BOLD | Font.ITALIC, 55));
		startAMatchButton.setBounds(488, 690, 707, 171);
		frmSelectingOpponent.getContentPane().add(startAMatchButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("Dialog", Font.BOLD, 25));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				gameEnvironment.openMainWindow();
			}
		});
		cancelButton.setBounds(1454, 948, 137, 47);
		frmSelectingOpponent.getContentPane().add(cancelButton);
	}
	
	/*
	 * close Opponent selecting window ( it will be called from gameEnvironment)
	 */
	public void closeWindow() {
		frmSelectingOpponent.dispose();
	/*
	 * close Opponent selecting window
	 */
	}
	public void finishedWindow() {
		gameEnvironment.closeSelectingOpponent(this);
	}
}
