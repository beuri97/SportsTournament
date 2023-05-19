package main.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import main.GameEnvironment;
import main.UserInterface;
import main.gameObject.Team;
import main.gameObject.athletes.Athlete;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StadiumGui implements UserInterface{

	private JFrame frmStadium;
	
	private GameEnvironment gameEnvironment;
	private Athlete[] myRoster;
	private Athlete[] opponentRoster;
	private int athleteNum;
	private int setScore = 1;
	
	JButton fightButton;
	
	JLabel currentStatBuffLabel; 
	JLabel gameResultLabel;
	JPanel battlePhoto;
	JLabel numberofSetLabel;
	JLabel myScoreLabel;
	JLabel opponentScoreLabel;
	
	JToggleButton aggresiveBttn;
	JToggleButton carefulBttn;


	/**
	 * Create the application.
	 */
	public StadiumGui(GameEnvironment gameEnvironment) {
		this.myRoster = gameEnvironment.getTeam().getRoster();
		this.opponentRoster = gameEnvironment.getOpponent().getRoster();
		setup(gameEnvironment);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void setup(GameEnvironment gameEnvironment) {
		this.gameEnvironment = gameEnvironment;
		setFrame();
		setMyAthletePanel();
		setOpponentPanel();
		setButton();
	}
	
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
		numberofSetLabel.setText("Set Score" + setScore);
		
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
	
	private void refreshScreen() {
		myScoreLabel.setText(Integer.toString(gameEnvironment.matchResult()[0]));
		opponentScoreLabel.setText(Integer.toString(gameEnvironment.matchResult()[1]));
		currentStatBuffLabel.setText(printing(myRoster[athleteNum].getAthleteSummary()));
		aggresiveBttn.setSelected(false);
		carefulBttn.setSelected(false);
		numberofSetLabel.setText("Set Score " + setScore);
	}
	
	private void setMyAthletePanel() {
		JPanel myTeamPanel = new JPanel();
		myTeamPanel.setBounds(93, 176, 306, 518);
		frmStadium.getContentPane().add(myTeamPanel);
		myTeamPanel.setLayout(null);
		myTeamPanel.setBorder(new LineBorder(UIManager.getColor("Button.foreground")));
		
		JLabel myTeamLabel = new JLabel(gameEnvironment.getTeam().getName());
		myTeamLabel.setFont(new Font("Dialog", Font.BOLD, 23));
		myTeamLabel.setBounds(12, 12, 171, 33);
		myTeamPanel.add(myTeamLabel);
		
		JLabel myAthleteLabel1 = new JLabel(printing(myRoster[0].getAthleteSummary()));
		JLabel myAthleteLabel2 = new JLabel(printing(myRoster[1].getAthleteSummary()));
		JLabel myAthleteLabel3 = new JLabel(printing(myRoster[2].getAthleteSummary()));
		JLabel myAthleteLabel4 = new JLabel(printing(myRoster[3].getAthleteSummary()));
		
		myAthleteLabel1.setHorizontalAlignment(SwingConstants.LEFT);
		myAthleteLabel1.setBounds(97, 57, 197, 95);
		myTeamPanel.add(myAthleteLabel1);
		myAthleteLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		myAthleteLabel2.setBounds(97, 174, 197, 95);
		myTeamPanel.add(myAthleteLabel2);
		myAthleteLabel3.setHorizontalAlignment(SwingConstants.LEFT);
		myAthleteLabel3.setBounds(97, 281, 197, 95);
		myTeamPanel.add(myAthleteLabel3);
		myAthleteLabel4.setHorizontalAlignment(SwingConstants.LEFT);
		myAthleteLabel4.setBounds(97, 393, 197, 95);
		myTeamPanel.add(myAthleteLabel4);
	}
	private void setOpponentPanel() {
		JPanel opponentPanel = new JPanel();
		opponentPanel.setLayout(null);
		opponentPanel.setBounds(1255, 176, 306, 518);
		frmStadium.getContentPane().add(opponentPanel);
		opponentPanel.setBorder(new LineBorder(UIManager.getColor("Button.foreground")));

		
		JLabel opponentTeamLabel = new JLabel("Opponent Team");
		opponentTeamLabel.setFont(new Font("Dialog", Font.BOLD, 23));
		opponentTeamLabel.setBounds(12, 12, 282, 33);
		opponentPanel.add(opponentTeamLabel);
		
		JLabel opponentAthleteLabel1 = new JLabel(printing(opponentRoster[0].getAthleteSummary()));
		JLabel opponentAthleteLabel2 = new JLabel(printing(opponentRoster[1].getAthleteSummary()));
		JLabel opponentAthleteLabel3 = new JLabel(printing(opponentRoster[2].getAthleteSummary()));
		JLabel opponentAthleteLabel4 = new JLabel(printing(opponentRoster[3].getAthleteSummary()));
		
		opponentAthleteLabel1.setHorizontalAlignment(SwingConstants.LEFT);
		opponentAthleteLabel1.setBounds(97, 66, 197, 95);
		opponentPanel.add(opponentAthleteLabel1);	
		opponentAthleteLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		opponentAthleteLabel2.setBounds(97, 173, 197, 95);
		opponentPanel.add(opponentAthleteLabel2);		
		opponentAthleteLabel3.setHorizontalAlignment(SwingConstants.LEFT);
		opponentAthleteLabel3.setBounds(97, 280, 197, 95);
		opponentPanel.add(opponentAthleteLabel3);	
		opponentAthleteLabel4.setHorizontalAlignment(SwingConstants.LEFT);
		opponentAthleteLabel4.setBounds(97, 397, 197, 95);
		opponentPanel.add(opponentAthleteLabel4);

	}
	
	
	private void setButton() {
		JButton backToMainButton = new JButton("Back to Main");
		backToMainButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToMain();
			}
		});
		backToMainButton.setFont(new Font("Dialog", Font.BOLD, 17));
		backToMainButton.setBounds(1483, 951, 155, 40);
		frmStadium.getContentPane().add(backToMainButton);
		
		aggresiveBttn = new JToggleButton("Aggressive");
		aggresiveBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.buffOffensive();
				carefulBttn.setSelected(false);
				currentStatBuffLabel.setText(printing(myRoster[athleteNum].getAthleteSummary()));
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
				currentStatBuffLabel.setText(printing(myRoster[athleteNum].getAthleteSummary()));
			}
		});
		carefulBttn.setFont(new Font("Dialog", Font.BOLD, 16));
		carefulBttn.setBounds(484, 846, 136, 46);
		frmStadium.getContentPane().add(carefulBttn);
		
		fightButton = new JButton("Fight");
		fightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aggresiveBttn.setEnabled(false);;
				carefulBttn.setEnabled(false);
				gameEnvironment.battleSequences();
				aggresiveBttn.setEnabled(true);;
				carefulBttn.setEnabled(true);
				gameResultLabel.setText(printing(gameEnvironment.getBattleMessage()));
				refreshScreen();
				
				if (gameEnvironment.isSet()) {
					athleteNum += 1;
					setScore = 1;
				}
				if (gameEnvironment.isGame()) {
					fightButton.setEnabled(false);
					aggresiveBttn.setEnabled(false);;
					carefulBttn.setEnabled(false);
					int myScore = gameEnvironment.matchResult()[0];
					int oppoScore = gameEnvironment.matchResult()[1];
					if (myScore > oppoScore) {
						gameResultLabel.setText(String.format("<html>Well Done!! <br/>You Won!!<br/> "
								+ "Total score was %d : %d</html>",myScore,oppoScore) );}
					else if(myScore == oppoScore) {
						gameResultLabel.setText(String.format("<html>That was very close!! <br/>"
								+ "Next time you can win!!<br/> Total score was %d : %d</html>",myScore,oppoScore) );}
					else {
						gameResultLabel.setText(String.format("<html>You lost!! <br/>"
								+ "Train your athletes harder!!<br/> Total score was %d : %d</html>",myScore,oppoScore) );}
					
					setScore += 1;
				
				}	
			}
		});
		fightButton.setFont(new Font("Dialog", Font.BOLD, 30));
		fightButton.setBounds(681, 904, 306, 69);
		frmStadium.getContentPane().add(fightButton);
	}
	
	/*
	 * create option panel to ask whether the player really wants to stop the game and go back to main screen or not.
	 */
	private void backToMain() {
		Object[] options1 = { "Back to Main", "Cancel" };
	    JPanel backToMainPanel = new JPanel();
	    if(gameEnvironment.isGame()) {
	    	finishedWindow();
			gameEnvironment.openMainScreen();
	    }
	    else {
		    	backToMainPanel.add(new JLabel("Are you sure? The match hasn't finished yet!"));
		    int result = JOptionPane.showOptionDialog(null, backToMainPanel, "Back to Main",
		        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
		        options1, null);
		    if (result == JOptionPane.YES_OPTION) {
		    	finishedWindow();
				gameEnvironment.openMainScreen();
	    }}
	    
	}
	public void closeWindow() {
		frmStadium.dispose();
	}
	
	public void finishedWindow() {
		gameEnvironment.closeStatiumWindow(this);
	}
}
