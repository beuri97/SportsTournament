package main.gui;


import main.GameEnvironment;
import main.Gui;
import main.UserInterface;
import main.gameObject.athletes.Athlete;

import java.awt.Color;
import java.awt.Font;

import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.Date;
/**
 * Class to create Stadium window in the game
 * @author J Kim
 */
public class StadiumGui extends Gui {

	/**
	 * Frame for stadium window
	 */
	private JFrame frmStadium;

	/**
	 * ArrayList contains JLabel which indicates athletes of my team, opponents
	 */
	private JLabel[][] athleteLabel = new JLabel[2][4];

	/**
	 * arrayList of athlete that the player has
	 */
	private Athlete[] myRoster;

	/**
	 * arrayList of Opponent Athletes
	 */
	private Athlete[] opponentRoster;

	/**
	 * number of current set
	 */
	private int setNum;

	/**
	 * the player's score
	 */
	private int myScore;

	/**
	 * the opponent score
	 */
	private int oppoScore;

	/**
	 * the player's previous score
	 */
	private int prevMyScore;

	/**
	 * the opponent previous score
	 */
	private int prevOppoScore;

	/**
	 * button to start fight
	 */
	private JButton fightBttn;

	/**
	 * label to show current stats with buff
	 */
	private JLabel currentStatBuffLabel; 

	/**
	 * label to show game result
	 */
	private JLabel gameResultLabel;

	/**
	 * label to show current set number
	 */
	private JLabel numberOfSetLabel;

	/**
	 * label to show the player's score
	 */
	private JLabel myScoreLabel;

	/**
	 * label to show the opponent score
	 */
	private JLabel opponentScoreLabel;

	/**
	 * toggle button to make athlete aggressive
	 */
	private JToggleButton aggresiveBttn;

	/**
	 * toggle button to make athlete careful
	 */
	private JToggleButton carefulBttn;

	/**
	 * label to show the battle photo
	 */
	private JLabel battlePhoto;
	
	/**
	 * the battle photo for both athletes attacked successfully
	 */
	private final ImageIcon bothAtct = new ImageIcon(getClass().getResource("/Images/BothAtct.jpg"));

	/**
	 * the battle photo for both athletes attacked and failed
	 */
	private final ImageIcon draw = new ImageIcon(getClass().getResource("/Images/Draw.jpg"));

	/**
	 * the battle photo for only the player's athlete won
	 */
	private final ImageIcon leftWon = new ImageIcon(getClass().getResource("/Images/LeftWon.jpg"));

	/**
	 * the battle photo for only the opponent athlete won
	 */
	private final ImageIcon rightWon = new ImageIcon(getClass().getResource("/Images/RightWon.jpg"));

	/**
	 * the stanby photo when the player is waiting for the result
	 */
	private final ImageIcon standby = new ImageIcon(getClass().getResource("/Images/Standby.jpg"));


	/**
	 * Create the application.
	 * @param gameEnvironment game environment which is core of this program
	 */
	public StadiumGui(GameEnvironment gameEnvironment) {

		setup(gameEnvironment);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param gameEnvironment game environment which is core of this program
	 */
	public void setup(GameEnvironment gameEnvironment) {
		super.gameEnvironment = gameEnvironment;
		this.myRoster = gameEnvironment.getTeam().getRoster();
		this.opponentRoster = gameEnvironment.getOpponent().getRoster();
		this.myScore = gameEnvironment.matchResult()[0];
		this.oppoScore = gameEnvironment.matchResult()[1];
		this.setNum = gameEnvironment.getGameSetNumber();
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
		currentStatBuffLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		currentStatBuffLabel.setBounds(484, 576, 315, 258);
		frmStadium.getContentPane().add(currentStatBuffLabel);
		currentStatBuffLabel.setBorder(new LineBorder(UIManager.getColor("Button.foreground")));

		gameResultLabel = new JLabel("Game Result description");
		gameResultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gameResultLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		gameResultLabel.setBorder(new LineBorder(UIManager.getColor("Button.foreground")));
		gameResultLabel.setBounds(859, 576, 306, 258);
		frmStadium.getContentPane().add(gameResultLabel);
		
		numberOfSetLabel = new JLabel("Number of Set");
		numberOfSetLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		numberOfSetLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numberOfSetLabel.setBounds(731, 12, 213, 46);
		frmStadium.getContentPane().add(numberOfSetLabel);
		numberOfSetLabel.setText("Set Score" + setNum);
		
		JLabel doubleDotScoreLabel = new JLabel(":");
		doubleDotScoreLabel.setFont(new Font("Dialog", Font.BOLD, 28));
		doubleDotScoreLabel.setBounds(826, 70, 14, 69);
		frmStadium.getContentPane().add(doubleDotScoreLabel);
		
		myScoreLabel = new JLabel(Integer.toString(myScore));
		myScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		myScoreLabel.setFont(new Font("Dialog", Font.BOLD, 63));
		myScoreLabel.setBounds(671, 51, 101, 113);
		frmStadium.getContentPane().add(myScoreLabel);
		
		opponentScoreLabel = new JLabel(Integer.toString(oppoScore));
		opponentScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		opponentScoreLabel.setFont(new Font("Dialog", Font.BOLD, 63));
		opponentScoreLabel.setBounds(886, 51, 101, 113);
		frmStadium.getContentPane().add(opponentScoreLabel);	
		
		
		battlePhoto = new JLabel("");
		battlePhoto.setHorizontalAlignment(SwingConstants.CENTER);
		battlePhoto.setBounds(465, 176, 700, 338);
		frmStadium.getContentPane().add(battlePhoto);
		battlePhoto.setIcon(standby);
	}

	/**
	 * set player's athlete and opponent's athlete panels with recent information
	 */
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
		
		//show active athletes with blue color labels.
		showActive(setNum-1);
	}

	/**
	 * update all the information on the screen and reset all the buttons
	 */
	private void refreshWindow() {
		setNum = gameEnvironment.getGameSetNumber();
		myScore = gameEnvironment.matchResult()[0];
		oppoScore = gameEnvironment.matchResult()[1];	
		myScoreLabel.setText(Integer.toString(myScore));
		opponentScoreLabel.setText(Integer.toString(oppoScore));
		currentStatBuffLabel.setText(printing(myRoster[setNum-1].getAthleteSummary()));
		carefulBttn.setSelected(false);
		aggresiveBttn.setSelected(false);
		carefulBttn.setEnabled(true);
		aggresiveBttn.setEnabled(true);
		numberOfSetLabel.setText("Set Score " + setNum);
		showActive(setNum-1);
	}
	/**
	 * change the font color of athlete's information if he is on the match.
	 * @param athlete the type of int which indicates the slot number of arrayList.
	 */
	private void showActive(int athlete) {
		//change back to black font color after match
		if (athlete > 0) {
			athleteLabel[0][athlete-1].setForeground(new Color(0, 0, 0));
			athleteLabel[1][athlete-1].setForeground(new Color(0, 0, 0));
		}
		//if on the match, change color to blue
		athleteLabel[0][athlete].setForeground(new Color(0, 0, 204));
		athleteLabel[1][athlete].setForeground(new Color(0, 0, 204));
	}


	/**
	 * when the player click the buff button
	 * update the athlete's stats with buff
	 */
	
	private void getBuffStat() {
		battlePhoto.setIcon(standby);
		gameResultLabel.setText("Athlete is ready!!");
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
	
	
	/**
	 * show the battle photo that matches the result of game
	 */
	private void showBattlePhoto() {

		if(prevMyScore < myScore && prevOppoScore < oppoScore) {
			battlePhoto.setIcon(bothAtct);
		}
		else if(prevMyScore == myScore && prevOppoScore < oppoScore) {
			battlePhoto.setIcon(rightWon);
		}
		else if(prevMyScore < myScore && prevOppoScore == oppoScore) {
			battlePhoto.setIcon(leftWon);
		}
		else if(prevMyScore == myScore && prevOppoScore == oppoScore) {
			battlePhoto.setIcon(draw);
		}
		prevMyScore = myScore;
		prevOppoScore = oppoScore;
	}
	
	/**
	 * create all the buttons on stadium window
	 */
	private void setButton() {

		// button to go back to main window
		JButton backToMainButton = new JButton("Back to Main");
		backToMainButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToMain();
				}});
		backToMainButton.setFont(new Font("Dialog", Font.BOLD, 17));
		backToMainButton.setBounds(1483, 951, 155, 40);
		frmStadium.getContentPane().add(backToMainButton);
		/**
		 * button to make athlete aggressive
		 */
		aggresiveBttn = new JToggleButton("Aggressive");
		aggresiveBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.buffOffensive();
				carefulBttn.setEnabled(false);
				aggresiveBttn.setEnabled(false);
				getBuffStat();
			}
		});
		aggresiveBttn.setFont(new Font("Dialog", Font.BOLD, 14));
		aggresiveBttn.setBounds(663, 846, 136, 46);
		frmStadium.getContentPane().add(aggresiveBttn);
		/**
		 * button to make athlete careful
		 */
		carefulBttn = new JToggleButton("Careful");
		carefulBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.buffDefensive();
				aggresiveBttn.setEnabled(false);
				carefulBttn.setEnabled(false);
				getBuffStat();		
				}
		});
		carefulBttn.setFont(new Font("Dialog", Font.BOLD, 14));
		carefulBttn.setBounds(484, 846, 136, 46);
		frmStadium.getContentPane().add(carefulBttn);
		
		//button to start match
		fightBttn = new JButton("Fight");
		fightBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					fightBttn.setEnabled(false);
					
					Thread.sleep(400);
					fightBttn.setEnabled(true);
					gameEnvironment.battleSequences();
					gameResultLabel.setText(printing(gameEnvironment.getBattleMessage()));
					refreshWindow();	
					gameEnvironment.isSet();
					showBattlePhoto();
				}
				catch(InterruptedException ex) {
					currentStatBuffLabel.setText(ex.getMessage());
				}
				
				//if the game is finished, disable the gaming buttons and show the result of game on description label
				if (gameEnvironment.isGame()) {
					fightBttn.setEnabled(false);
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
		fightBttn.setFont(new Font("Dialog", Font.BOLD, 37));
		fightBttn.setBounds(501, 904, 653, 87);
		frmStadium.getContentPane().add(fightBttn);
	}
	
	/**
	 * create the panel to let the player know that he can't go back to main until he finishes his game.
	 * if the player has finished the match, go back to main
	 */
	private void backToMain() {
	    JPanel backToMainPanel = new JPanel();
	    if(gameEnvironment.isGame()) {
	    	finishedWindow();
			gameEnvironment.openMainWindow();
	    }
	    else {
		    backToMainPanel.add(new JLabel("<html>You haven't finished this match!!<br/> Let's finish and go back to main!!</html>"));
		    JOptionPane.showOptionDialog(null, backToMainPanel, "Can't go back!", JOptionPane.DEFAULT_OPTION, JOptionPane.OK_OPTION, null, null, null);
	    }   
	}

	/**
	 * close Stadium window ( it will be called from gameEnvironment)
	 */
	public void closeWindow() {
		frmStadium.dispose();
	}

	/**
	 * close Stadium window
	 */
	public void finishedWindow() {
		gameEnvironment.closeStadiumWindow(this);
	}
}
