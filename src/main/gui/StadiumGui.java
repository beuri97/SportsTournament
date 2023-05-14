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
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StadiumGui implements UserInterface{

	private JFrame frmStadium;
	
	GameEnvironment gameEnvironment;
	Athlete[] myRoster;
	Team opponentRoster;
	
	JLabel currentStatBuffLabel; 
	JLabel gameResultDescripTextField;
	JPanel battlePhoto;
	JLabel numberofSetLabel;
	JLabel myScoreLabel;
	JLabel opponentScoreLabel;
	
	JToggleButton aggresiveToggleButton;
	JToggleButton carefulToggleButton;
	
	JLabel myAthleteLabel1;
	JLabel myAthleteLabel2;
	JLabel myAthleteLabel3;
	JLabel myAthleteLabel4;
	
	JPanel myAthletePhoto1;
	JPanel myAthletePhoto2;
	JPanel myAthletePhoto3;
	JPanel myAthletePhoto4;
	
	JLabel opponentAthleteLabel1;
	JLabel opponentAthleteLabel2;
	JLabel opponentAthleteLabel3;
	JLabel opponentAthleteLabel4;
	
	JPanel opponentAthletePhoto1;
	JPanel opponentAthletePhoto2;
	JPanel opponentAthletePhoto3;
	JPanel opponentAthletePhoto4;


	/**
	 * Create the application.
	 */
	public StadiumGui(GameEnvironment gameEnvironment) {
		this.gameEnvironment = gameEnvironment;
		this.myRoster = gameEnvironment.getTeam().getRoster();
		this.opponentRoster = gameEnvironment.getOpponent();
		setup(gameEnvironment);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void setup(GameEnvironment gameEnvironment) {
		setFrame();
		setMyAthletePanel();
		setOpponentPanel();
		setButton();
	}
	
	private void setFrame() {
		frmStadium = new JFrame();
		frmStadium.setSize(1650,1080);
		frmStadium.getContentPane().setLayout(null);
		frmStadium.setVisible(true);
		
		JLabel statBuffLabel = new JLabel("My Athlete Stat with Buff");
		statBuffLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		statBuffLabel.setHorizontalAlignment(SwingConstants.CENTER);
		statBuffLabel.setBounds(485, 526, 298, 38);
		frmStadium.getContentPane().add(statBuffLabel);

		currentStatBuffLabel = new JLabel("my current stat with buff");
		currentStatBuffLabel.setHorizontalAlignment(SwingConstants.CENTER);
		currentStatBuffLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		currentStatBuffLabel.setBounds(477, 576, 306, 106);
		frmStadium.getContentPane().add(currentStatBuffLabel);
		currentStatBuffLabel.setBorder(new LineBorder(UIManager.getColor("Button.foreground")));

		gameResultDescripTextField = new JLabel("Game Result description");
		gameResultDescripTextField.setHorizontalAlignment(SwingConstants.CENTER);
		gameResultDescripTextField.setFont(new Font("Dialog", Font.BOLD, 16));
		gameResultDescripTextField.setBorder(new LineBorder(UIManager.getColor("Button.foreground")));
		gameResultDescripTextField.setBounds(631, 704, 410, 158);
		frmStadium.getContentPane().add(gameResultDescripTextField);
		
		battlePhoto = new JPanel();
		battlePhoto.setBounds(464, 176, 725, 338);
		frmStadium.getContentPane().add(battlePhoto);
		
		numberofSetLabel = new JLabel("Number of Set");
		numberofSetLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		numberofSetLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numberofSetLabel.setBounds(731, 12, 213, 46);
		frmStadium.getContentPane().add(numberofSetLabel);
		
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
	}
	
	private String printingAthleteInfo(int indexNum) {
		Athlete temp = myRoster[indexNum];
		return String.format("<html>Name: %s<br/>Offence: %i<br/>Deffence: %i<br/>Stamina: %i</html>"
				, temp.getName(), temp.getOffenseStat(), temp.getDefenseStat(), temp.getStamina());
	}
	
	private void setMyAthletePanel() {
		JPanel myTeamPanel = new JPanel();
		myTeamPanel.setBounds(93, 176, 306, 518);
		frmStadium.getContentPane().add(myTeamPanel);
		myTeamPanel.setLayout(null);
		
		JLabel myTeamLabel = new JLabel(gameEnvironment.getTeam().getName());
		myTeamLabel.setFont(new Font("Dialog", Font.BOLD, 23));
		myTeamLabel.setBounds(12, 12, 137, 33);
		myTeamPanel.add(myTeamLabel);
		
		
		myAthleteLabel1 = new JLabel(printingAthleteInfo(0));
		myAthleteLabel2 = new JLabel(printingAthleteInfo(1));
		myAthleteLabel3 = new JLabel(printingAthleteInfo(2));
		myAthleteLabel4 = new JLabel(printingAthleteInfo(3));
		
		myAthleteLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		myAthleteLabel1.setBounds(130, 99, 155, 33);
		myTeamPanel.add(myAthleteLabel1);
		myAthleteLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		myAthleteLabel2.setBounds(130, 211, 155, 33);
		myTeamPanel.add(myAthleteLabel2);
		myAthleteLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		myAthleteLabel3.setBounds(130, 323, 155, 33);
		myTeamPanel.add(myAthleteLabel3);
		myAthleteLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		myAthleteLabel4.setBounds(130, 435, 155, 33);
		myTeamPanel.add(myAthleteLabel4);
		myAthletePhoto1 = new JPanel();
		myAthletePhoto1.setBounds(22, 61, 100, 100);
		myTeamPanel.add(myAthletePhoto1);
		myAthletePhoto2 = new JPanel();
		myAthletePhoto2.setBounds(22, 173, 100, 100);
		myTeamPanel.add(myAthletePhoto2);
		myAthletePhoto3 = new JPanel();
		myAthletePhoto3.setBounds(22, 285, 100, 100);
		myTeamPanel.add(myAthletePhoto3);
		myAthletePhoto4 = new JPanel();
		myAthletePhoto4.setBounds(22, 397, 100, 100);
		myTeamPanel.add(myAthletePhoto4);
	}
	private void setOpponentPanel() {
		JPanel opponentPanel = new JPanel();
		opponentPanel.setLayout(null);
		opponentPanel.setBounds(1255, 176, 306, 518);
		frmStadium.getContentPane().add(opponentPanel);
		
		JLabel opponentTeamLabel = new JLabel("Opponent Team");
		opponentTeamLabel.setFont(new Font("Dialog", Font.BOLD, 23));
		opponentTeamLabel.setBounds(12, 12, 282, 33);
		opponentPanel.add(opponentTeamLabel);
		
		opponentAthleteLabel1 = new JLabel("opponentAthlete1");
		opponentAthleteLabel2 = new JLabel("opponentAthlete2");
		opponentAthleteLabel3 = new JLabel("opponentAthlete3");
		opponentAthleteLabel4 = new JLabel("opponentAthlete4");
		
		opponentAthleteLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		opponentAthleteLabel1.setBounds(130, 99, 155, 33);
		opponentPanel.add(opponentAthleteLabel1);	
		opponentAthleteLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		opponentAthleteLabel2.setBounds(130, 211, 155, 33);
		opponentPanel.add(opponentAthleteLabel2);		
		opponentAthleteLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		opponentAthleteLabel3.setBounds(130, 323, 155, 33);
		opponentPanel.add(opponentAthleteLabel3);	
		opponentAthleteLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		opponentAthleteLabel4.setBounds(130, 435, 155, 33);
		opponentPanel.add(opponentAthleteLabel4);
		
		
		opponentAthletePhoto1 = new JPanel();
		opponentAthletePhoto2 = new JPanel();
		opponentAthletePhoto3 = new JPanel();
		opponentAthletePhoto4 = new JPanel();
		
		opponentAthletePhoto1.setBounds(22, 61, 100, 100);
		opponentPanel.add(opponentAthletePhoto1);
		opponentAthletePhoto2.setBounds(22, 173, 100, 100);
		opponentPanel.add(opponentAthletePhoto2);
		opponentAthletePhoto3.setBounds(22, 285, 100, 100);
		opponentPanel.add(opponentAthletePhoto3);
		opponentAthletePhoto4.setBounds(22, 397, 100, 100);
		opponentPanel.add(opponentAthletePhoto4);

	}
	
	
	private void setButton() {
		JButton backToMainButton = new JButton("Back to Main");
		backToMainButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitBox();
			}
		});
		backToMainButton.setFont(new Font("Dialog", Font.BOLD, 17));
		backToMainButton.setBounds(1483, 951, 155, 40);
		frmStadium.getContentPane().add(backToMainButton);
		
		aggresiveToggleButton = new JToggleButton("Aggressive");
		aggresiveToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.buffOffensive();
				carefulToggleButton.setSelected(false);
			}
		});
		aggresiveToggleButton.setFont(new Font("Dialog", Font.BOLD, 16));
		aggresiveToggleButton.setBounds(887, 576, 256, 46);
		frmStadium.getContentPane().add(aggresiveToggleButton);
		
		carefulToggleButton = new JToggleButton("Careful");
		carefulToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.buffDefensive();
				aggresiveToggleButton.setSelected(false);
			}
		});
		carefulToggleButton.setFont(new Font("Dialog", Font.BOLD, 16));
		carefulToggleButton.setBounds(887, 634, 256, 46);
		frmStadium.getContentPane().add(carefulToggleButton);
		
		JButton Fight = new JButton("Fight");
		Fight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.battleSequences();
				aggresiveToggleButton.setEnabled(false);;
				carefulToggleButton.setEnabled(false);
			}
		});
		Fight.setFont(new Font("Dialog", Font.BOLD, 30));
		Fight.setBounds(681, 904, 306, 69);
		frmStadium.getContentPane().add(Fight);
	}
	
	
	
	
	/*
	 * create option panel to ask whether the player really wants to quit the game or not
	 */
	private void exitBox() {
		Object[] options1 = { "Back to Main", "Cancel" };
	    JPanel panel = new JPanel();
	    panel.add(new JLabel("Are you sure? The match hasn't finished yet!"));
	  
	    int result = JOptionPane.showOptionDialog(null, panel, "Quit",
	        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
	        options1, null);
	    if (result == JOptionPane.YES_OPTION) {
	    	frmStadium.dispose();
			MainScreenGui backToMain = new MainScreenGui(gameEnvironment);
	    }

	}
}
