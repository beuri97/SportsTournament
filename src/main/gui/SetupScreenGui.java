package main.gui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Font;
import java.awt.Color;
import main.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import main.gamesystem.*;
import javax.swing.SwingConstants;

/**
 * class for Setup window when start the game
 * @author J Kim
 */
public class SetupScreenGui implements UserInterface{

	private JFrame frmFencingGame;
	private JTextField teamNameField;
	private JLabel NumWeekLabel;
	private JSlider slider;
	private JLabel infoLabel;
	private JLabel infoLabel2;
	private DifficultyOption level;
	static GameEnvironment gameEnvironment;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface ui = new CmdLineUi();
			        gameEnvironment = new GameEnvironment(ui);
			        SetupScreenGui window = new SetupScreenGui(gameEnvironment);
					window.frmFencingGame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * 
	 */
	private SetupScreenGui(GameEnvironment gameEnvironment) {
		
		setup(gameEnvironment);
	}
	/**
	 * create the setup window
	 */
	public void setup(GameEnvironment gameEnvironment) {
		this.gameEnvironment = gameEnvironment;
		setFrame();
		setLabel();
		setTextField();
		setJSlider();
		setJbutton();			
	}
	public void main() {
		
	}
	/*
	 * set the frame of setup window
	 */
	private void setFrame() {
		frmFencingGame = new JFrame();
		frmFencingGame.setTitle("Fencing Game");
		frmFencingGame.setSize(1650,1080);
		frmFencingGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**
	 * show the labels on window
	 */
	private void setLabel() {
		frmFencingGame.getContentPane().setLayout(null);
		JLabel welcoming = new JLabel("Welcome to FencingTournament");
		welcoming.setBounds(669, 378, 403, 25);
		welcoming.setFont(new Font("Dialog", Font.PLAIN, 24));
		frmFencingGame.getContentPane().add(welcoming);
		JLabel teamname = new JLabel("Team Name : ");
		teamname.setBounds(558, 505, 115, 21);
		frmFencingGame.getContentPane().add(teamname);
		
		NumWeekLabel = new JLabel("Number of weeks for one season :");
		NumWeekLabel.setBounds(496, 589, 263, 16);
		NumWeekLabel.setToolTipText("");
		frmFencingGame.getContentPane().add(NumWeekLabel);
		
		infoLabel = new JLabel("Enter your team name here");
		infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		infoLabel.setBounds(759, 531, 370, 14);
		infoLabel.setForeground(new Color(255, 0, 0));
		infoLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frmFencingGame.getContentPane().add(infoLabel);
		
		infoLabel2 = new JLabel("");
		infoLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		infoLabel2.setForeground(Color.RED);
		infoLabel2.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		infoLabel2.setBounds(759, 545, 370, 14);
		frmFencingGame.getContentPane().add(infoLabel2);
		
		JLabel diffcultyLabel = new JLabel("Difficulty :");
		diffcultyLabel.setBounds(568, 664, 96, 16);
		frmFencingGame.getContentPane().add(diffcultyLabel);
	
	}
	/**
	 * show slider to choose the number of weeks per season
	 */
	private void setJSlider() {
		slider = new JSlider(5,15);
		slider.setBounds(828, 571, 190, 52);
		JLabel status = new JLabel("Slide the slider!!");
		status.setBounds(1023, 589, 156, 16);
		frmFencingGame.getContentPane().add(status);
		frmFencingGame.getContentPane().add(slider);
		slider.setPaintTrack(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(5);
		slider.setMinorTickSpacing(1);
		slider.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
				status.setText(((JSlider)e.getSource()).getValue() + " weeks");
			}
		});
	}
	/**
	 * show the text field for user to type in a team name
	 */
	private void setTextField() {
		
		teamNameField = new JTextField();
		teamNameField.setBounds(759, 500, 370, 26);
		frmFencingGame.getContentPane().add(teamNameField);	
		teamNameField.setColumns(30);
		
	}
	/**
	 * show difficulty option with label and buttons to choose.
	 */
	private void setJbutton() {
		
		JToggleButton easyButton = new JToggleButton("Easy");
		JToggleButton diffButton = new JToggleButton("Difficult");
		easyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level = DifficultyOption.EASY;
				diffButton.setSelected(false);
			}
		});
		easyButton.setBounds(841, 659, 75, 29);
		frmFencingGame.getContentPane().add(easyButton);
		
		diffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level = DifficultyOption.DIFFICULT;
				easyButton.setSelected(false);			
			}
		});
		
		diffButton.setBounds(928, 659, 96, 29);
		frmFencingGame.getContentPane().add(diffButton);
		JButton startBttn = new JButton("Start game");
		startBttn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!teamNameField.getText().matches(NAME_REGEX)) {
					infoLabel.setText(NAME_LENGTH_REQUIREMENT);	
					infoLabel2.setText(NAME_CHAR_REQUIREMENT);
				}
				else {
					frmFencingGame.dispose();
					MainScreenGui gameStart = new MainScreenGui(gameEnvironment);
					gameEnvironment.set(teamNameField.getText(), slider.getValue(), level);	
					tempText = gameEnvironment.getTeam().getName();
				}
			}
		});
		
		startBttn.setBounds(1153, 718, 146, 29);
		frmFencingGame.getContentPane().add(startBttn);
		
		// button to exit from the game. Small window will pop up and ask if the player really wants to eixt.
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitBox();
			}
		});
		exitButton.setBounds(1344, 718, 146, 29);
		frmFencingGame.getContentPane().add(exitButton);
		

	}
	
	
	/*
	 * creat optionpanel to ask whether the player really wants to quit the game or not
	 */
	private void exitBox() {
		Object[] options1 = { "Quit", "Cancel" };
	    JPanel panel = new JPanel();
	    panel.add(new JLabel("Are you sure you want to quit???"));
	  
	    int result = JOptionPane.showOptionDialog(null, panel, "Quit",
	        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
	        options1, null);
	    if (result == JOptionPane.YES_OPTION) {
	    	System.exit(0);
	    }

	}
}
