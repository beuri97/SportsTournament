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

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ImprovingAthleteGui implements UserInterface{

	private JFrame frmImproving;
	private JLabel athleteInfo;
	private GameEnvironment gameEnvironment;
	private Athlete[] myRoster;
	
	private int improvNum;

	/**
	 * Create the application.
	 */
	public ImprovingAthleteGui(GameEnvironment gameEnvironment) {
		this.gameEnvironment = gameEnvironment;
		this.myRoster = gameEnvironment.getTeam().getRoster();
		setup(gameEnvironment);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void setup(GameEnvironment gameEnvironment) {
		frmImproving = new JFrame();
		frmImproving.setSize(1650,1080);
		frmImproving.setLocation((1925 - frmImproving.getWidth()) / 2, (1080 - frmImproving.getHeight()) / 2);
		frmImproving.getContentPane().setLayout(null);
		frmImproving.setVisible(true);
		
		JButton improveButton = new JButton("Improve!");
		improveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				myRoster[improvNum].setOffenseStat(setup.randomInt(2, 7));///////////////////////////////////////////////////////////////////////////////////////
//				myRoster[improvNum].setOffenseStat(setup.randomInt(2, 7));///////////////////////////////////////////////////////////////////////////////////////
//				myRoster[improvNum].setOffenseStat(setup.randomInt(2, 7));
				if (improvNum != 0) {
					athleteInfo.setText(printing(myRoster[improvNum-1]));
					improveButton.setEnabled(false);
					improveButton.setText("Improved!!");
				}
				else {
					athleteInfo.setText("Choose the athlete!!");
				}
				
			}
		});
		
		improveButton.setFont(new Font("Dialog", Font.BOLD, 36));
		improveButton.setBounds(885, 716, 412, 127);
		frmImproving.getContentPane().add(improveButton);
		
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
		
		JPanel panel = new JPanel();
		panel.setBounds(301, 122, 457, 721);
		frmImproving.getContentPane().add(panel);
		panel.setLayout(new GridLayout(7, 1, 0, 0));
		
		JButton athlete1 = new JButton(printingName(myRoster[0]));
		athlete1.setEnabled(isEmpty(myRoster[0]));
		athlete1.setFont(new Font("Dialog", Font.BOLD, 22));
		athlete1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteInfo.setText(printing(myRoster[0]));
				improvNum = 1;
			}
		});
		panel.add(athlete1);
		
		JButton athlete2 = new JButton(printingName(myRoster[1]));
		athlete2.setEnabled(isEmpty(myRoster[1]));
		athlete2.setFont(new Font("Dialog", Font.BOLD, 22));
		athlete2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteInfo.setText(printing(myRoster[1]));
				improvNum = 2;
			}
		});
		panel.add(athlete2);
		
		JButton athlete3 = new JButton(printingName(myRoster[2]));
		athlete3.setEnabled(isEmpty(myRoster[2]));
		athlete3.setFont(new Font("Dialog", Font.BOLD, 22));
		athlete3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteInfo.setText(printing(myRoster[2]));
				improvNum = 3;
			}
		});
		panel.add(athlete3);
		
		JButton athlete4 = new JButton(printingName(myRoster[3]));
		athlete4.setEnabled(isEmpty(myRoster[3]));
		athlete4.setFont(new Font("Dialog", Font.BOLD, 22));
		athlete4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteInfo.setText(printing(myRoster[3]));
				improvNum = 4;
			}
		});
		panel.add(athlete4);
		
		JButton athlete5 = new JButton(printingName(myRoster[4]));
		athlete5.setEnabled(isEmpty(myRoster[4]));
		athlete5.setFont(new Font("Dialog", Font.BOLD, 22));
		athlete5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteInfo.setText(printing(myRoster[4]));
				improvNum = 5;
			}
		});
		panel.add(athlete5);
		
		JButton athlete6 = new JButton(printingName(myRoster[5]));
		athlete6.setEnabled(isEmpty(myRoster[5]));
		athlete6.setFont(new Font("Dialog", Font.BOLD, 22));
		athlete6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteInfo.setText(printing(myRoster[5]));
				improvNum = 6;
			}
		});
		panel.add(athlete6);
		
		JButton athlete7 = new JButton(printingName(myRoster[6]));
		athlete7.setEnabled(isEmpty(myRoster[6]));
		athlete7.setFont(new Font("Dialog", Font.BOLD, 22));
		athlete7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteInfo.setText(printing(myRoster[7]));
				improvNum = 7;
			}
		});
		panel.add(athlete7);
		
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
