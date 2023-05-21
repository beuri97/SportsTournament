package main.gui;


import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import main.GameEnvironment;
import main.UserInterface;
import main.gameObject.athletes.Athlete;
import main.gamesystem.SetUp;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * class for Improving Athlete window when start the game
 * @author J Kim
 */
public class ImprovingAthleteGui implements UserInterface{
	private GameEnvironment gameEnvironment;
	/**
	 * Frame for Improving Athlete window
	 */
	private JFrame frmImproving;
	/**
	 * label for athletes description that the player choose
	 */
	private JLabel athleteInfo;
	/**
	 * arrayList of the player's athletes
	 */
	private Athlete[] myRoster;
	/**
	 * arrayList of JButton contains athlete buttons
	 */
	private JButton[] athleteBttn = new JButton[7];
	/*
	 * index number of athlete that the player choose
	 */
	private int improvNum;

	/**
	 * setup information for Improving Athlete window
	 * when the player take a bye and go to next week, the system will ask the player choose a player to improve stats.
	 * 
	 */
	public ImprovingAthleteGui(GameEnvironment gameEnvironment) {
		this.gameEnvironment = gameEnvironment;
		this.myRoster = gameEnvironment.getTeam().getRoster();
		setup(gameEnvironment);
	}

	/**
	 * Setup Frame to show Athlete and information to make the player to select.
	 */
	public void setup(GameEnvironment gameEnvironment) {
		frmImproving = new JFrame();
		frmImproving.setSize(1650,1080);
		frmImproving.setLocation((1925 - frmImproving.getWidth()) / 2, (1080 - frmImproving.getHeight()) / 2);
		frmImproving.getContentPane().setLayout(null);
		frmImproving.setVisible(true);
		
		/**
		 * improve athlete that the player selected
		 * it improves randomly all the stats
		 */
		JButton improveButton = new JButton("Improve!");
		improveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (improvNum != 0) {
					myRoster[improvNum-1].setOffenseStat(SetUp.randomInt(2, 7));
					myRoster[improvNum-1].setDefenseStat(SetUp.randomInt(2, 7));
					myRoster[improvNum-1].setMaxStamina(SetUp.randomInt(2, 7));
					athleteInfo.setText(printing(myRoster[improvNum-1]));
					improveButton.setEnabled(false);
					improveButton.setText("Improved!!");
					//after improving athlete, disable all the buttons
					for (JButton btn : athleteBttn) {btn.setEnabled(false);}		
				}
				else {
					athleteInfo.setText("Choose the athlete!!");
				}}});
		
		improveButton.setFont(new Font("Dialog", Font.BOLD, 36));
		improveButton.setBounds(885, 716, 412, 127);
		frmImproving.getContentPane().add(improveButton);
		
		/**
		 * button to start next week
		 */
		JButton startNxtWkBttn = new JButton("Start Next Week!!");
		startNxtWkBttn.setFont(new Font("Dialog", Font.BOLD, 20));
		startNxtWkBttn.setBounds(1280, 943, 261, 57);
		frmImproving.getContentPane().add(startNxtWkBttn);
		startNxtWkBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.reset();
				finishedWindow();
				gameEnvironment.openMainWindow();
			}
		});	
		/**
		 * button to select the athlete that the player will choose
		 */
		JPanel bttnPanel = new JPanel();
		bttnPanel.setBounds(301, 122, 457, 721);
		frmImproving.getContentPane().add(bttnPanel);
		bttnPanel.setLayout(new GridLayout(7, 1, 0, 0));
		
		
		for (int i=0; i<myRoster.length; i++) {
			athleteBttn[i] = new JButton(printingName(myRoster[i]));
			athleteBttn[i].setEnabled(isEmpty(myRoster[0]));
			bttnPanel.add(athleteBttn[i]);}
		
		athleteBttn[0].setFont(new Font("Dialog", Font.BOLD, 22));
		athleteBttn[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteInfo.setText(printing(myRoster[0]));
				improvNum = 1;}});
		
		athleteBttn[1].setFont(new Font("Dialog", Font.BOLD, 22));
		athleteBttn[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteInfo.setText(printing(myRoster[1]));
				improvNum = 2;}});

		athleteBttn[2].setFont(new Font("Dialog", Font.BOLD, 22));
		athleteBttn[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteInfo.setText(printing(myRoster[2]));
				improvNum = 3;}});
		
		athleteBttn[3].setFont(new Font("Dialog", Font.BOLD, 22));
		athleteBttn[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteInfo.setText(printing(myRoster[3]));
				improvNum = 4;}});
		
		athleteBttn[4].setFont(new Font("Dialog", Font.BOLD, 22));
		athleteBttn[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteInfo.setText(printing(myRoster[4]));
				improvNum = 5;}});

		athleteBttn[5].setFont(new Font("Dialog", Font.BOLD, 22));
		athleteBttn[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteInfo.setText(printing(myRoster[5]));
				improvNum = 6;}});
		
		athleteBttn[6].setFont(new Font("Dialog", Font.BOLD, 22));
		athleteBttn[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteInfo.setText(printing(myRoster[6]));
				improvNum = 7;}});

		JPanel setAthleteInfoPanel = new JPanel();
		setAthleteInfoPanel.setLayout(null);
		setAthleteInfoPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		setAthleteInfoPanel.setBounds(885, 122, 412, 562);
		frmImproving.getContentPane().add(setAthleteInfoPanel);
		
		JLabel athleteInfoTitleLabel = new JLabel("<<Athelte Information>>");
		athleteInfoTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		athleteInfoTitleLabel.setFont(new Font("Dialog", Font.BOLD, 23));
		athleteInfoTitleLabel.setBounds(12, 12, 388, 51);
		setAthleteInfoPanel.add(athleteInfoTitleLabel);
		
		athleteInfo = new JLabel("<html>Your team has been trained for a week! You can pick one athlete to improve significantly!</html>");
		athleteInfo.setFont(new Font("Dialog", Font.PLAIN, 18));
		athleteInfo.setBounds(22, 118, 366, 418);
		setAthleteInfoPanel.add(athleteInfo);
	}
	/*
	 * check if the athlete from team is null.
	 */
	private boolean isEmpty(Athlete athlete) {
		if (athlete == null) { return false;}
		else {return true;}
	}
	
	/*
	 * close Improving athlete window ( it will be called from gameEnvironment).
	 */
	public void closeWindow() {
		frmImproving.dispose();
	}
	/*
	 * close Improving athlete window
	 */
	
	public void finishedWindow() {
		gameEnvironment.closeImprovingWindow(this);
	}
}
