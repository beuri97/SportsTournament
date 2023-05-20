package main.gui;


import javax.swing.JFrame;

import main.GameEnvironment;
import main.UserInterface;
import main.gameObject.athletes.Athlete;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;

public class StadiumGui implements UserInterface{

	private JFrame frmStadium;
	private JLabel[][] athleteLabel = new JLabel[2][4];
	
	private GameEnvironment gameEnvironment;
	private Athlete[] myRoster;
	private Athlete[] opponentRoster;
	private int setNum;
	
	private JButton fightButton;
	
	private JLabel currentStatBuffLabel; 
	private JLabel gameResultLabel;
	private JPanel battlePhoto;
	private JLabel numberofSetLabel;
	private JLabel myScoreLabel;
	private JLabel opponentScoreLabel;
	
	private JToggleButton aggresiveBttn;
	private JToggleButton carefulBttn;
	
	
	


	/**
	 * Create the application.
	 */
	public StadiumGui(GameEnvironment gameEnvironment) {
		this.gameEnvironment = gameEnvironment;
		this.myRoster = gameEnvironment.getTeam().getRoster();
		this.opponentRoster = gameEnvironment.getOpponent().getRoster();
		this.setNum = gameEnvironment.getGameSetNumber();
		setup(gameEnvironment);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void setup(GameEnvironment gameEnvironment) {
		setFrame();
		setAthletePanel();
		setButton();
	}

	/**
	 * create the frame with basic components for stadium
	 */
	private void setFrame() {
		frmStadium = new JFrame();
		frmStadium.setSize(1650,1080);
		frmStadium.getContentPane().setLayout(null);
		frmStadium.setLocation((1925 - frmStadium.getWidth()) / 2, (1080 - frmStadium.getHeight()) / 2);
		frmStadium.setVisible(true);
		
		JLabel statBuffLabel = new JLabel("My Athlete Stat with Buff");
		statBuffLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		statBuffLabel.setHorizontalAlignment(SwingConstants.CENTER);
		statBuffLabel.setBounds(501, 526, 298, 38);
		frmStadium.getContentPane().add(statBuffLabel);

		currentStatBuffLabel = new JLabel("my current stat with buff");
		currentStatBuffLabel.setHorizontalAlignment(SwingConstants.CENTER);
		currentStatBuffLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		currentStatBuffLabel.setBounds(484, 576, 315, 258);
		frmStadium.getContentPane().add(currentStatBuffLabel);
		currentStatBuffLabel.setBorder(new LineBorder(UIManager.getColor("Button.foreground")));

		gameResultLabel = new JLabel("Game Result description");
		gameResultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gameResultLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		gameResultLabel.setBorder(new LineBorder(UIManager.getColor("Button.foreground")));
		gameResultLabel.setBounds(859, 526, 306, 366);
		frmStadium.getContentPane().add(gameResultLabel);
		
		battlePhoto = new JPanel();
		battlePhoto.setBounds(464, 176, 700, 338);
		frmStadium.getContentPane().add(battlePhoto);
		battlePhoto.setBorder(new LineBorder(UIManager.getColor("Button.foreground")));
		
		numberofSetLabel = new JLabel("Number of Set");
		numberofSetLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		numberofSetLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numberofSetLabel.setBounds(731, 12, 213, 46);
		frmStadium.getContentPane().add(numberofSetLabel);
		numberofSetLabel.setText("Set Score" + setNum);
		
		JLabel doubleDotScoreLabel = new JLabel(":");
		doubleDotScoreLabel.setFont(new Font("Dialog", Font.BOLD, 28));
		doubleDotScoreLabel.setBounds(826, 70, 14, 69);
		frmStadium.getContentPane().add(doubleDotScoreLabel);
		
		myScoreLabel = new JLabel(Integer.toString(gameEnvironment.matchResult()[0]));
		myScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		myScoreLabel.setFont(new Font("Dialog", Font.BOLD, 63));
		myScoreLabel.setBounds(671, 51, 101, 113);
		frmStadium.getContentPane().add(myScoreLabel);
		
		opponentScoreLabel = new JLabel(Integer.toString(gameEnvironment.matchResult()[1]));
		opponentScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		opponentScoreLabel.setFont(new Font("Dialog", Font.BOLD, 63));
		opponentScoreLabel.setBounds(886, 51, 101, 113);
		frmStadium.getContentPane().add(opponentScoreLabel);	
		
	}
	/*
	 * update all the information on the screen and reset all the buttons
	 */
	private void refreshWindow() {
		setNum = gameEnvironment.getGameSetNumber();
		myScoreLabel.setText(Integer.toString(gameEnvironment.matchResult()[0]));
		opponentScoreLabel.setText(Integer.toString(gameEnvironment.matchResult()[1]));
		currentStatBuffLabel.setText(printing(myRoster[setNum-1].getAthleteSummary()));
		aggresiveBttn.setSelected(false);
		carefulBttn.setSelected(false);
		numberofSetLabel.setText("Set Score " + setNum);
		showActive(setNum-1);
	}
	/*
	 * change the font colour of athlete's information if he is on the match.
	 */
	private void showActive(int athlete) {
		//change back to black font colour after match
		if (athlete > 0) {
			athleteLabel[0][athlete-1].setForeground(new Color(0, 0, 0));
			athleteLabel[1][athlete-1].setForeground(new Color(0, 0, 0));
		}
		//if on the match, change colour to blue
		athleteLabel[0][athlete].setForeground(new Color(0, 0, 204));
		athleteLabel[1][athlete].setForeground(new Color(0, 0, 204));
	}

	
	private void setAthletePanel() {
		JPanel myTeamPanel = new JPanel();
		myTeamPanel.setBounds(70, 176, 306, 643);
		frmStadium.getContentPane().add(myTeamPanel);
		myTeamPanel.setLayout(null);
		myTeamPanel.setBorder(new LineBorder(UIManager.getColor("Button.foreground")));
		
		JLabel myTeamLabel = new JLabel(gameEnvironment.getTeam().getName());
		myTeamLabel.setFont(new Font("Dialog", Font.BOLD, 23));
		myTeamLabel.setBounds(28, 22, 171, 33);
		myTeamPanel.add(myTeamLabel);
		
		JPanel opponentPanel = new JPanel();
		opponentPanel.setLayout(null);
		opponentPanel.setBounds(1255, 176, 306, 643);
		frmStadium.getContentPane().add(opponentPanel);
		opponentPanel.setBorder(new LineBorder(UIManager.getColor("Button.foreground")));
		
		JLabel opponentTeamLabel = new JLabel("Opponent Team");
		opponentTeamLabel.setFont(new Font("Dialog", Font.BOLD, 23));
		opponentTeamLabel.setBounds(12, 12, 282, 33);
		opponentPanel.add(opponentTeamLabel);
		
		//create athlete arrays to contain athletes from myRoster and opponentRoster
		for (int r=0; r<2; r++) {
			for (int c=0; c<4; c++) {
				//add my athletes into array
				if (r == 0) {
					athleteLabel[r][c] = new JLabel(printing(myRoster[c].getAthleteSummary()));
					athleteLabel[r][c].setHorizontalAlignment(SwingConstants.LEFT);
					myTeamPanel.add(athleteLabel[r][c]);
				}
				//add opponent team members into array
				else if (r == 1) {
					athleteLabel[r][c] = new JLabel(printing(opponentRoster[c].getAthleteSummary()));
					athleteLabel[r][c].setHorizontalAlignment(SwingConstants.LEFT);
					opponentPanel.add(athleteLabel[r][c]);
				}}}
		
		athleteLabel[0][0].setBounds(97, 67, 197, 135);
		athleteLabel[0][1].setBounds(97, 214, 197, 135);
		athleteLabel[0][2].setBounds(97, 361, 197, 135);
		athleteLabel[0][3].setBounds(97, 502, 197, 135);
		
		athleteLabel[1][0].setBounds(97, 67, 197, 135);
		athleteLabel[1][1].setBounds(97, 214, 197, 135);
		athleteLabel[1][2].setBounds(97, 361, 197, 135);
		athleteLabel[1][3].setBounds(97, 502, 197, 135);
		
		//show active athletes with blue colour labels.
		showActive(setNum-1);
	}
	
	
	private void getBuffStat() {
		Athlete current = myRoster[setNum-1];
		currentStatBuffLabel.setText(String.format("<html> Name : %s <br/>"
				+ "Original Offense Stat : %d <br/>"
				+ "Original Defense Stat : %d <br/>"
				+ "Offense Stat with Buff : %d ~ %d <br/>"
				+ "Defense Stat with Buff : %d ~ %d </html>", 
				current.getName(), 
				current.getOffenseStat(), 
				current.getDefenseStat(), 
				gameEnvironment.getAdjustedStats()[0][0], 
				gameEnvironment.getAdjustedStats()[0][1],
				gameEnvironment.getAdjustedStats()[1][0], 
				gameEnvironment.getAdjustedStats()[1][1]));
	}
	
	private void setButton() {
		JButton backToMainButton = new JButton("Back to Main");
		backToMainButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToMain();
				}});
		backToMainButton.setFont(new Font("Dialog", Font.BOLD, 17));
		backToMainButton.setBounds(1483, 951, 155, 40);
		frmStadium.getContentPane().add(backToMainButton);
		
		aggresiveBttn = new JToggleButton("Aggressive");
		aggresiveBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.buffOffensive();
				carefulBttn.setSelected(false);
				getBuffStat();
			}
		});
		aggresiveBttn.setFont(new Font("Dialog", Font.BOLD, 16));
		aggresiveBttn.setBounds(663, 846, 136, 46);
		frmStadium.getContentPane().add(aggresiveBttn);
		
		carefulBttn = new JToggleButton("Careful");
		carefulBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.buffDefensive();
				aggresiveBttn.setSelected(false);
				getBuffStat();		
				}
		});
		carefulBttn.setFont(new Font("Dialog", Font.BOLD, 16));
		carefulBttn.setBounds(484, 846, 136, 46);
		frmStadium.getContentPane().add(carefulBttn);
		
		fightButton = new JButton("Fight");
		fightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.battleSequences();
				gameResultLabel.setText(printing(gameEnvironment.getBattleMessage()));
				refreshWindow();
				gameEnvironment.isSet();

				if (gameEnvironment.isGame()) {
					fightButton.setEnabled(false);
					aggresiveBttn.setEnabled(false);;
					carefulBttn.setEnabled(false);
					int myScore = gameEnvironment.matchResult()[0];
					int oppoScore = gameEnvironment.matchResult()[1];
					double money;
					if (myScore > oppoScore) {
						money = gameEnvironment.getDifficulty().getMoneyGain() * 1.5;
						gameEnvironment.closingGame(money, true);
						gameResultLabel.setText(String.format("<html>Well Done!! <br/>You Won!!<br/> "
								+ "Total score was %d : %d<br/>"
								+ "MONEY GAIN: %.2f</html>",myScore,oppoScore,money) );}
					else if(myScore == oppoScore) {
						money = gameEnvironment.getDifficulty().getMoneyGain() * 0.7;
						gameEnvironment.closingGame(money, true);
						gameResultLabel.setText(String.format("<html>That was very close!! <br/>"
								+ "Next time you can win!!<br/> Total score was %d : %d<br/>"
								+ "MONEY GAIN: %.2f</html>",myScore,oppoScore,money) );}
					else {
						money = gameEnvironment.getDifficulty().getMoneyGain();
						gameEnvironment.closingGame(money, false);
						gameResultLabel.setText(String.format("<html>You lost!! <br/>"
								+ "Train your athletes harder!!<br/> Total score was %d : %d<br/>"
								+ "MONEY GAIN: %.2f</html>",myScore,oppoScore,money) );}
				
				}	
			}
		});
		fightButton.setFont(new Font("Dialog", Font.BOLD, 30));
		fightButton.setBounds(681, 904, 306, 69);
		frmStadium.getContentPane().add(fightButton);
	}
	
	/*
	 * create the panel to let the player know that he can't go back to main until he finishes his game.
	 */
	private void backToMain() {
	    JPanel backToMainPanel = new JPanel();
	    if(gameEnvironment.isGame()) {
	    	finishedWindow();
			gameEnvironment.openMainWindow();
	    }
	    else {
		    backToMainPanel.add(new JLabel("<html>You haven't finished this match!!<br/> Let's finish and go back to main!!</html>"));
		    int result = JOptionPane.showOptionDialog(null, backToMainPanel, "Can't go back!",
		        JOptionPane.DEFAULT_OPTION, JOptionPane.OK_OPTION, null,
		        null, null);
	    }
	    
	}
	/*
	 * close Stadium window ( it will be called from gameEnvironment)
	 */
	public void closeWindow() {
		frmStadium.dispose();
	}
	/*
	 * close Stadium window
	 */
	public void finishedWindow() {
		gameEnvironment.closeStatiumWindow(this);
	}
}
