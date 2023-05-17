package main.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import main.GameEnvironment;
import main.UserInterface;
import main.gameObject.Team;
import main.gameObject.athletes.Athlete;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectOpponentGui implements UserInterface{

	private JFrame frmSelectingOpponent;
	private GameEnvironment gameEnvironment;
	private JLabel chooseOpponentLabel;
	private int selectedOpponentNum;
	private String myTeamName;
	

	/**
	 * Create the application.
	 */
	public SelectOpponentGui(GameEnvironment gameEnvironment) {
		this.gameEnvironment = gameEnvironment;
		this.myTeamName = gameEnvironment.getTeam().getName();
		setup(gameEnvironment);
	}

	private String printTitle() {
		return String.format("%s vs Opponent Team No.%d",myTeamName, selectedOpponentNum+1);
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
		chooseOpponentLabel.setBounds(569, 212, 707, 151);
		frmSelectingOpponent.getContentPane().add(chooseOpponentLabel);
		
		JButton teamButton1 = new JButton("<html>Opponent<br/>Team<br/> No.1</html>");
		teamButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedOpponentNum = 0;
				chooseOpponentLabel.setText(printTitle());
			}
		});
		JButton teamButton2 = new JButton("<html>Opponent<br/>Team<br/> No.2</html>");
		teamButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedOpponentNum = 1;
				chooseOpponentLabel.setText(printTitle());
			}
		});
		JButton teamButton3 = new JButton("<html>Opponent<br/>Team<br/> No.3</html>");
		teamButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedOpponentNum = 2;
				chooseOpponentLabel.setText(printTitle());
			}
		});
		JButton teamButton4 = new JButton("<html>Opponent<br/>Team<br/> No.4</html>");
		teamButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedOpponentNum = 3;
				chooseOpponentLabel.setText(printTitle());
			}
		});
		JButton teamButton5 = new JButton("<html>Opponent<br/>Team<br/> No.5</html>");
		teamButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedOpponentNum = 4;
				chooseOpponentLabel.setText(printTitle());
			}
		});
		
		teamButton1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 17));
		teamButton1.setBounds(569, 375, 120, 292);
		frmSelectingOpponent.getContentPane().add(teamButton1);
		teamButton2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 17));
		teamButton2.setBounds(715, 375, 120, 292);
		frmSelectingOpponent.getContentPane().add(teamButton2);
		teamButton3.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 17));
		teamButton3.setBounds(859, 375, 120, 292);
		frmSelectingOpponent.getContentPane().add(teamButton3);
		teamButton4.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 17));
		teamButton4.setBounds(1005, 375, 120, 292);
		frmSelectingOpponent.getContentPane().add(teamButton4);
		teamButton5.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 17));
		teamButton5.setBounds(1155, 375, 120, 292);
		frmSelectingOpponent.getContentPane().add(teamButton5);
		
		JButton startAMatchButton = new JButton("Start a match!!");
		startAMatchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				gameEnvironment.gameStart(selectedOpponentNum);
				finishedWindow();
				gameEnvironment.openStatiumScreen();;
			}
		});
		startAMatchButton.setFont(new Font("Gentium", Font.BOLD | Font.ITALIC, 55));
		startAMatchButton.setBounds(568, 690, 707, 171);
		frmSelectingOpponent.getContentPane().add(startAMatchButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("Dialog", Font.BOLD, 25));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				gameEnvironment.openMainScreen();
			}
		});
		cancelButton.setBounds(1454, 948, 137, 47);
		frmSelectingOpponent.getContentPane().add(cancelButton);
	}
	
	/*
	 * close opponent selecting window.
	 */
	public void closeWindow() {
		frmSelectingOpponent.dispose();
		
	}
	public void finishedWindow() {
		gameEnvironment.closeSelectingOpponent(this);
	}
}