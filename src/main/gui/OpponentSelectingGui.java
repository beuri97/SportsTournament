package main.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import main.GameEnvironment;
import main.UserInterface;
import main.gameObject.Team;
import main.gameObject.athletes.Athlete;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class OpponentSelectingGui implements UserInterface {

	private JFrame frmOpponentSelec;
	private GameEnvironment gameEnvironment;
	private Athlete[] myRoster;
	private Team[] opponentList;
	
	private JLabel matchTitle;
	private int opponentIndexNum;
	
	private JLabel myAthleteLabel1;
	private JLabel myAthleteLabel2;
	private JLabel myAthleteLabel3;
	private JLabel myAthleteLabel4;
	
	private JPanel myAthletePhoto1;
	private JPanel myAthletePhoto2;
	private JPanel myAthletePhoto3;
	private JPanel myAthletePhoto4;
	
	private JLabel opponentTeam1Label1;
	private JLabel opponentTeam1Label2;
	private JLabel opponentTeam1Label3;
	private JLabel opponentTeam1Label4;
	
	private JPanel opponentTeam1Photo1;
	private JPanel opponentTeam1Photo2;
	private JPanel opponentTeam1Photo3;
	private JPanel opponentTeam1Photo4;

	private JLabel opponentTeam2Label1;
	private JLabel opponentTeam2Label2;
	private JLabel opponentTeam2Label3;
	private JLabel opponentTeam2Label4;
	private JPanel opponentTeam2Photo1;
	private JPanel opponentTeam2Photo2;
	private JPanel opponentTeam2Photo3;
	private JPanel opponentTeam2Photo4;
	
	private JLabel opponentTeam3Label1;
	private JLabel opponentTeam3Label2;
	private JLabel opponentTeam3Label3;
	private JLabel opponentTeam3Label4;
	private JPanel opponentTeam3Photo1;
	private JPanel opponentTeam3Photo2;
	private JPanel opponentTeam3Photo3;
	private JPanel opponentTeam3Photo4;
	
	private JLabel opponentTeam4Label1;
	private JLabel opponentTeam4Label2;
	private JLabel opponentTeam4Label3;
	private JLabel opponentTeam4Label4;
	private JPanel opponentTeam4Photo1;
	private JPanel opponentTeam4Photo2;
	private JPanel opponentTeam4Photo3;
	private JPanel opponentTeam4Photo4;

	private JLabel opponentTeam5Label1;
	private JLabel opponentTeam5Label2;
	private JLabel opponentTeam5Label3;
	private JLabel opponentTeam5Label4;
	private JPanel opponentTeam5Photo1;
	private JPanel opponentTeam5Photo2;
	private JPanel opponentTeam5Photo3;
	private JPanel opponentTeam5Photo4;

	/**
	 * Create the application.
	 */
	public OpponentSelectingGui(GameEnvironment gameEnvironment) {
		this.gameEnvironment = gameEnvironment;
		this.myRoster = gameEnvironment.getTeam().getRoster();
		this.opponentList = gameEnvironment.getAllOpponent();
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
		frmOpponentSelec = new JFrame();		
		frmOpponentSelec.setSize(1650,1080);
		frmOpponentSelec.getContentPane().setLayout(null);
		frmOpponentSelec.setVisible(true);
		
		matchTitle = new JLabel("<html>Who can you beat?<br/>Select one team and start game!!</html>");
		matchTitle.setFont(new Font("Dialog", Font.BOLD, 55));
		matchTitle.setHorizontalAlignment(SwingConstants.CENTER);
		matchTitle.setBounds(126, 61, 1373, 154);
		frmOpponentSelec.getContentPane().add(matchTitle);
		
	}
	
	private void setMyAthletePanel() {
		JPanel myTeamPanel = new JPanel();
		myTeamPanel.setBounds(73, 233, 263, 518);
		frmOpponentSelec.getContentPane().add(myTeamPanel);
		myTeamPanel.setLayout(null);
		
		JLabel myTeamLabel = new JLabel(gameEnvironment.getTeam().getName());
		myTeamLabel.setFont(new Font("Dialog", Font.BOLD, 23));
		myTeamLabel.setBounds(12, 12, 236, 33);
		myTeamPanel.add(myTeamLabel);
		
		myAthleteLabel1 = new JLabel(printingAthleteInfo(0));
		myAthleteLabel2 = new JLabel(printingAthleteInfo(1));
		myAthleteLabel3 = new JLabel(printingAthleteInfo(2));
		myAthleteLabel4 = new JLabel(printingAthleteInfo(3));
		
		myAthleteLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		myAthleteLabel1.setBounds(130, 61, 118, 100);
		myTeamPanel.add(myAthleteLabel1);
		myAthleteLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		myAthleteLabel2.setBounds(130, 173, 118, 100);
		myTeamPanel.add(myAthleteLabel2);
		myAthleteLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		myAthleteLabel3.setBounds(130, 285, 118, 100);
		myTeamPanel.add(myAthleteLabel3);
		myAthleteLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		myAthleteLabel4.setBounds(130, 397, 118, 100);
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
	/*
	 * make five opponent teams panels and show their photos and stats
	 */
	private void setOpponentPanel() {
		JPanel opponentPanel = new JPanel();
		opponentPanel.setLayout(null);
		opponentPanel.setBounds(389, 233, 213, 518);
		frmOpponentSelec.getContentPane().add(opponentPanel);
	
		JPanel opponentPanel_1 = new JPanel();
		opponentPanel_1.setLayout(null);
		opponentPanel_1.setBounds(614, 233, 213, 518);
		frmOpponentSelec.getContentPane().add(opponentPanel_1);

		JPanel opponentPanel_2 = new JPanel();
		opponentPanel_2.setLayout(null);
		opponentPanel_2.setBounds(839, 233, 213, 518);
		frmOpponentSelec.getContentPane().add(opponentPanel_2);

		JPanel opponentPanel_3 = new JPanel();
		opponentPanel_3.setLayout(null);
		opponentPanel_3.setBounds(1064, 233, 213, 518);
		frmOpponentSelec.getContentPane().add(opponentPanel_3);

		JPanel opponentPanel_4 = new JPanel();
		opponentPanel_4.setLayout(null);
		opponentPanel_4.setBounds(1289, 233, 213, 518);
		frmOpponentSelec.getContentPane().add(opponentPanel_4);
		
		JLabel opponentTeamLabel1 = new JLabel("Opponent Team1");
		opponentTeamLabel1.setFont(new Font("Dialog", Font.BOLD, 17));
		opponentTeamLabel1.setBounds(12, 12, 185, 33);
		opponentPanel.add(opponentTeamLabel1);
		
		opponentTeam1Label1 = new JLabel("opponentAthlete1");
		opponentTeam1Label2 = new JLabel("opponentAthlete2");
		opponentTeam1Label3 = new JLabel("opponentAthlete3");
		opponentTeam1Label4 = new JLabel("opponentAthlete4");
		
		opponentTeam1Label1.setHorizontalAlignment(SwingConstants.CENTER);
		opponentTeam1Label1.setBounds(120, 57, 77, 100);
		opponentPanel.add(opponentTeam1Label1);	
		opponentTeam1Label2.setHorizontalAlignment(SwingConstants.CENTER);
		opponentTeam1Label2.setBounds(120, 169, 77, 100);
		opponentPanel.add(opponentTeam1Label2);		
		opponentTeam1Label3.setHorizontalAlignment(SwingConstants.CENTER);
		opponentTeam1Label3.setBounds(120, 281, 77, 100);
		opponentPanel.add(opponentTeam1Label3);	
		opponentTeam1Label4.setHorizontalAlignment(SwingConstants.CENTER);
		opponentTeam1Label4.setBounds(120, 393, 77, 100);
		opponentPanel.add(opponentTeam1Label4);
		
		opponentTeam1Photo1 = new JPanel();
		opponentTeam1Photo2 = new JPanel();
		opponentTeam1Photo3 = new JPanel();
		opponentTeam1Photo4 = new JPanel();
		
		opponentTeam1Photo1.setBounds(12, 57, 100, 100);
		opponentPanel.add(opponentTeam1Photo1);
		opponentTeam1Photo2.setBounds(12, 169, 100, 100);
		opponentPanel.add(opponentTeam1Photo2);
		opponentTeam1Photo3.setBounds(12, 281, 100, 100);
		opponentPanel.add(opponentTeam1Photo3);
		opponentTeam1Photo4.setBounds(12, 393, 100, 100);
		opponentPanel.add(opponentTeam1Photo4);
		
		JLabel opponentTeamLabel2 = new JLabel("Opponent Team2");
		opponentTeamLabel2.setFont(new Font("Dialog", Font.BOLD, 17));
		opponentTeamLabel2.setBounds(12, 12, 185, 33);
		opponentPanel_1.add(opponentTeamLabel2);
		
		opponentTeam2Label1 = new JLabel("opponentAthlete1");
		opponentTeam2Label2 = new JLabel("opponentAthlete2");
		opponentTeam2Label3 = new JLabel("opponentAthlete3");
		opponentTeam2Label4 = new JLabel("opponentAthlete4");
		
		opponentTeam2Label1.setHorizontalAlignment(SwingConstants.CENTER);
		opponentTeam2Label1.setBounds(120, 57, 77, 100);
		opponentPanel_1.add(opponentTeam2Label1);
		opponentTeam2Label2.setHorizontalAlignment(SwingConstants.CENTER);
		opponentTeam2Label2.setBounds(120, 169, 77, 100);
		opponentPanel_1.add(opponentTeam2Label2);
		opponentTeam2Label3.setHorizontalAlignment(SwingConstants.CENTER);
		opponentTeam2Label3.setBounds(120, 281, 77, 100);
		opponentPanel_1.add(opponentTeam2Label3);
		opponentTeam2Label4.setHorizontalAlignment(SwingConstants.CENTER);
		opponentTeam2Label4.setBounds(120, 393, 77, 100);
		opponentPanel_1.add(opponentTeam2Label4);
		
		opponentTeam2Photo1 = new JPanel();
		opponentTeam2Photo1.setBounds(12, 57, 100, 100);
		opponentPanel_1.add(opponentTeam2Photo1);
		opponentTeam2Photo2 = new JPanel();
		opponentTeam2Photo2.setBounds(12, 169, 100, 100);
		opponentPanel_1.add(opponentTeam2Photo2);
		opponentTeam2Photo3 = new JPanel();
		opponentTeam2Photo3.setBounds(12, 281, 100, 100);
		opponentPanel_1.add(opponentTeam2Photo3);
		opponentTeam2Photo4 = new JPanel();
		opponentTeam2Photo4.setBounds(12, 393, 100, 100);
		opponentPanel_1.add(opponentTeam2Photo4);
			
		JLabel opponentTeamLabel3 = new JLabel("Opponent Team3");
		opponentTeamLabel3.setFont(new Font("Dialog", Font.BOLD, 17));
		opponentTeamLabel3.setBounds(12, 12, 185, 33);
		opponentPanel_2.add(opponentTeamLabel3);
		
		opponentTeam3Label1 = new JLabel("opponentAthlete1");
		opponentTeam3Label2 = new JLabel("opponentAthlete2");
		opponentTeam3Label3 = new JLabel("opponentAthlete3");
		opponentTeam3Label4 = new JLabel("opponentAthlete4");

		opponentTeam3Label1.setHorizontalAlignment(SwingConstants.CENTER);
		opponentTeam3Label1.setBounds(120, 57, 77, 100);
		opponentPanel_2.add(opponentTeam3Label1);	
		opponentTeam3Label2.setHorizontalAlignment(SwingConstants.CENTER);
		opponentTeam3Label2.setBounds(120, 169, 77, 100);
		opponentPanel_2.add(opponentTeam3Label2);
		opponentTeam3Label3.setHorizontalAlignment(SwingConstants.CENTER);
		opponentTeam3Label3.setBounds(120, 281, 77, 100);
		opponentPanel_2.add(opponentTeam3Label3);
		opponentTeam3Label4.setHorizontalAlignment(SwingConstants.CENTER);
		opponentTeam3Label4.setBounds(120, 393, 77, 100);
		opponentPanel_2.add(opponentTeam3Label4);
		
		opponentTeam3Photo1 = new JPanel();
		opponentTeam3Photo1.setBounds(12, 57, 100, 100);
		opponentPanel_2.add(opponentTeam3Photo1);
		opponentTeam3Photo2 = new JPanel();
		opponentTeam3Photo2.setBounds(12, 169, 100, 100);
		opponentPanel_2.add(opponentTeam3Photo2);
		opponentTeam3Photo3 = new JPanel();
		opponentTeam3Photo3.setBounds(12, 281, 100, 100);
		opponentPanel_2.add(opponentTeam3Photo3);
		opponentTeam3Photo4 = new JPanel();
		opponentTeam3Photo4.setBounds(12, 393, 100, 100);
		opponentPanel_2.add(opponentTeam3Photo4);
		
		JLabel opponentTeamLabel4 = new JLabel("Opponent Team4");
		opponentTeamLabel4.setFont(new Font("Dialog", Font.BOLD, 17));
		opponentTeamLabel4.setBounds(12, 12, 185, 33);
		opponentPanel_3.add(opponentTeamLabel4);
		
		opponentTeam4Label1 = new JLabel("opponentAthlete1");
		opponentTeam4Label2 = new JLabel("opponentAthlete2");
		opponentTeam4Label3 = new JLabel("opponentAthlete3");
		opponentTeam4Label4 = new JLabel("opponentAthlete4");

		opponentTeam4Label1.setHorizontalAlignment(SwingConstants.CENTER);
		opponentTeam4Label1.setBounds(120, 57, 77, 100);
		opponentPanel_3.add(opponentTeam4Label1);
		opponentTeam4Label2.setHorizontalAlignment(SwingConstants.CENTER);
		opponentTeam4Label2.setBounds(120, 169, 77, 100);
		opponentPanel_3.add(opponentTeam4Label2);
		opponentTeam4Label3.setHorizontalAlignment(SwingConstants.CENTER);
		opponentTeam4Label3.setBounds(120, 281, 77, 100);
		opponentPanel_3.add(opponentTeam4Label3);
		opponentTeam4Label4.setHorizontalAlignment(SwingConstants.CENTER);
		opponentTeam4Label4.setBounds(120, 393, 77, 100);
		opponentPanel_3.add(opponentTeam4Label4);
		
		opponentTeam4Photo1 = new JPanel();
		opponentTeam4Photo1.setBounds(12, 57, 100, 100);
		opponentPanel_3.add(opponentTeam4Photo1);
		opponentTeam4Photo2 = new JPanel();
		opponentTeam4Photo2.setBounds(12, 169, 100, 100);
		opponentPanel_3.add(opponentTeam4Photo2);
		opponentTeam4Photo3 = new JPanel();
		opponentTeam4Photo3.setBounds(12, 281, 100, 100);
		opponentPanel_3.add(opponentTeam4Photo3);
		opponentTeam4Photo4 = new JPanel();
		opponentTeam4Photo4.setBounds(12, 393, 100, 100);
		opponentPanel_3.add(opponentTeam4Photo4);
		
		JLabel opponentTeamLabel5 = new JLabel("Opponent Team5");
		opponentTeamLabel5.setFont(new Font("Dialog", Font.BOLD, 17));
		opponentTeamLabel5.setBounds(12, 12, 185, 33);
		opponentPanel_4.add(opponentTeamLabel5);
		
		opponentTeam5Label1 = new JLabel("opponentAthlete1");
		opponentTeam5Label2 = new JLabel("opponentAthlete2");
		opponentTeam5Label3 = new JLabel("opponentAthlete3");
		opponentTeam5Label4 = new JLabel("opponentAthlete4");
		
		opponentTeam5Label1.setHorizontalAlignment(SwingConstants.CENTER);
		opponentTeam5Label1.setBounds(120, 57, 77, 100);
		opponentPanel_4.add(opponentTeam5Label1);
		opponentTeam5Label2.setHorizontalAlignment(SwingConstants.CENTER);
		opponentTeam5Label2.setBounds(120, 169, 77, 100);
		opponentPanel_4.add(opponentTeam5Label2);
		opponentTeam5Label3.setHorizontalAlignment(SwingConstants.CENTER);
		opponentTeam5Label3.setBounds(120, 281, 77, 100);
		opponentPanel_4.add(opponentTeam5Label3);		
		opponentTeam5Label4.setHorizontalAlignment(SwingConstants.CENTER);
		opponentTeam5Label4.setBounds(120, 393, 77, 100);
		opponentPanel_4.add(opponentTeam5Label4);
		
		opponentTeam5Photo1 = new JPanel();
		opponentTeam5Photo1.setBounds(12, 57, 100, 100);
		opponentPanel_4.add(opponentTeam5Photo1);
		opponentTeam5Photo2 = new JPanel();
		opponentTeam5Photo2.setBounds(12, 169, 100, 100);
		opponentPanel_4.add(opponentTeam5Photo2);
		opponentTeam5Photo3 = new JPanel();
		opponentTeam5Photo3.setBounds(12, 281, 100, 100);
		opponentPanel_4.add(opponentTeam5Photo3);
		opponentTeam5Photo4 = new JPanel();
		opponentTeam5Photo4.setBounds(12, 393, 100, 100);
		opponentPanel_4.add(opponentTeam5Photo4);
	}
	
	private void setButton() {
		JButton opponentOpt1 = new JButton("opponentOpt1");
		opponentOpt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opponentIndexNum = 0;
			}
		});
		opponentOpt1.setFont(new Font("Dialog", Font.BOLD, 18));
		opponentOpt1.setBounds(399, 763, 191, 57);
		frmOpponentSelec.getContentPane().add(opponentOpt1);
		
		JButton opponentOpt2 = new JButton("opponentOpt2");
		opponentOpt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opponentIndexNum = 1;
			}
		});
		opponentOpt2.setFont(new Font("Dialog", Font.BOLD, 18));
		opponentOpt2.setBounds(624, 763, 191, 57);
		frmOpponentSelec.getContentPane().add(opponentOpt2);
		
		JButton opponentOpt3 = new JButton("opponentOpt3");
		opponentOpt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opponentIndexNum = 2;
			}
		});
		opponentOpt3.setFont(new Font("Dialog", Font.BOLD, 18));
		opponentOpt3.setBounds(849, 763, 191, 57);
		frmOpponentSelec.getContentPane().add(opponentOpt3);
		
		JButton opponentOpt4 = new JButton("opponentOpt4");
		opponentOpt4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opponentIndexNum = 3;
			}
		});
		opponentOpt4.setFont(new Font("Dialog", Font.BOLD, 18));
		opponentOpt4.setBounds(1074, 763, 191, 57);
		frmOpponentSelec.getContentPane().add(opponentOpt4);
		
		JButton opponentOpt5 = new JButton("opponentOpt5");
		opponentOpt5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opponentIndexNum = 4;
			}
		});
		opponentOpt5.setFont(new Font("Dialog", Font.BOLD, 18));
		opponentOpt5.setBounds(1299, 763, 191, 57);
		frmOpponentSelec.getContentPane().add(opponentOpt5);
		
		// set the button to go back to main screen
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmOpponentSelec.dispose();
				MainScreenGui backToMain = new MainScreenGui(gameEnvironment);
			}
		});
		backButton.setFont(new Font("Lucida Grande", Font.BOLD, 23));
		backButton.setBounds(28, 982, 97, 31);
		frmOpponentSelec.getContentPane().add(backButton);
		
		// set the button to go back to main screen
		JButton matchButton = new JButton("Start a match!");
		matchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				frmOpponentSelec.dispose();
				gameEnvironment.gameStart(opponentIndexNum);
				StadiumGui startGame = new StadiumGui(gameEnvironment);
			}
		});
		matchButton.setFont(new Font("Lucida Grande", Font.BOLD, 23));
		matchButton.setBounds(1390, 934, 223, 79);
		frmOpponentSelec.getContentPane().add(matchButton);
	}
	private String printingAthleteInfo(int indexNum) {
		Athlete temp = myRoster[indexNum];
		return (temp ==null) ? "Empty" : String.format("<html>Name: %s<br/>Offence: %d<br/>Deffence: %d<br/>Stamina: %d</html>"
				, temp.getName(), temp.getOffenseStat(), temp.getDefenseStat(), temp.getStamina());	
	}
}
