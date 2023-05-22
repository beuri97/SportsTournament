package main.gui;

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
import main.gamesystem.Exception.IllegalInputException;

import javax.swing.SwingConstants;

/**
 * class for Setup window when start the game
 * @author J Kim
 */
public class SetupWindowGui implements UserInterface {

	/**
	 * Frame for setup Window
	 */
	private JFrame frmSetup;
	/**
	 * TextField for the team name that the player will type in
	 */
	private JTextField teamNameField;
	/**
	 * title label for number of week
	 */
	private JLabel numWeekLabel;
	/**
	 * Slider to choose number of weeks
	 */
	private JSlider slider;
	/**
	 * show notice if the name doesn't meet the requirement
	 */
	private JLabel infoLabel;
	/**
	 * difficulty level that the player will choose
	 * default difficulty level is Easy.
	 */
	private DifficultyOption level = DifficultyOption.EASY;
	/**
	 * game environment which has all of this game system
	 */
	private GameEnvironment gameEnvironment;

	/**
	 * setup Window constructor
	 */
	public SetupWindowGui() {}
	/**
	 * create the setup window
	 * @param gameEnvironment game environment which is core of this program
	 */
	public void setup(GameEnvironment gameEnvironment) {
		this.gameEnvironment = gameEnvironment;
		setFrame();
		setLabel();
		setTextField();
		setJSlider();
		setJbutton();			
	}
	/*
	 * set the frame of setup window
	 */
	private void setFrame() {
		frmSetup = new JFrame();
		frmSetup.setSize(1650,1080);
		frmSetup.setLocation((1925 - frmSetup.getWidth()) / 2, (1080 - frmSetup.getHeight()) / 2);
		frmSetup.setVisible(true);
	}
	/**
	 * show the labels on window
	 */
	private void setLabel() {
		frmSetup.getContentPane().setLayout(null);
		JLabel welcoming = new JLabel("Welcome to FencingTournament");
		welcoming.setBounds(669, 378, 403, 25);
		welcoming.setFont(new Font("Dialog", Font.PLAIN, 24));
		frmSetup.getContentPane().add(welcoming);
		JLabel teamname = new JLabel("Team Name : ");
		teamname.setBounds(558, 505, 115, 21);
		frmSetup.getContentPane().add(teamname);
		
		numWeekLabel = new JLabel("Number of weeks for one season :");
		numWeekLabel.setBounds(496, 589, 263, 16);
		numWeekLabel.setToolTipText("");
		frmSetup.getContentPane().add(numWeekLabel);
		
		infoLabel = new JLabel("");
		infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		infoLabel.setBounds(558, 531, 783, 14);
		infoLabel.setForeground(new Color(255, 0, 0));
		infoLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frmSetup.getContentPane().add(infoLabel);
		
		JLabel diffcultyLabel = new JLabel("Difficulty :");
		diffcultyLabel.setBounds(568, 664, 96, 16);
		frmSetup.getContentPane().add(diffcultyLabel);
	
	}
	/**
	 * show slider to choose the number of weeks per season
	 */
	private void setJSlider() {
		slider = new JSlider(5,15);
		slider.setBounds(828, 571, 190, 52);
		JLabel status = new JLabel("Slide the slider!!");
		status.setBounds(1023, 589, 156, 16);
		frmSetup.getContentPane().add(status);
		frmSetup.getContentPane().add(slider);
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
		frmSetup.getContentPane().add(teamNameField);	
		teamNameField.setColumns(30);
	}
	/**
	 * show difficulty option with label and buttons to choose.
	 */
	private void setJbutton() {
		
		// give two buttons for difficulty options. Can't click both, so it will be cancelled when click the other one.
		JToggleButton easyButton = new JToggleButton("Easy");
		JToggleButton diffButton = new JToggleButton("Difficult");
		easyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level = DifficultyOption.EASY;
				diffButton.setSelected(false);
			}
		});
		easyButton.setBounds(841, 659, 75, 29);
		frmSetup.getContentPane().add(easyButton);
		
		diffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level = DifficultyOption.DIFFICULT;
				easyButton.setSelected(false);			
			}
		});
		diffButton.setBounds(928, 659, 96, 29);
		frmSetup.getContentPane().add(diffButton);
		
		// when click 'Start game' button, it will check the regex of what the player entered, if it fails, show the requirement for team name, otherwise
		// save team name, number of weeks per season and difficulty. And then, close the current window and show main Screen to play.
		JButton startBttn = new JButton("Start game");
		startBttn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					gameEnvironment.check(teamNameField.getText(), NAME_REGEX, NAME_CHAR_REQUIREMENT);
					gameEnvironment.set(teamNameField.getText(), slider.getValue(), level);	
					finishedWindow();
					gameEnvironment.openMainWindow();
				}
				catch(IllegalInputException a) {
					infoLabel.setText(a.getMessage());	
				}
			}
		});	
		startBttn.setBounds(1153, 718, 146, 29);
		frmSetup.getContentPane().add(startBttn);
		
		// button to exit from the game. Small window will pop up and ask if the player really wants to eixt.
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitBox();
			}
		});
		exitButton.setBounds(1344, 718, 146, 29);
		frmSetup.getContentPane().add(exitButton);
	}
	/*
	 * create option panel to ask whether the player really wants to quit the game or not
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
	/*
	 * close setup window ( it will be called from gameEnvironment)
	 */
	public void closeWindow() {
		frmSetup.dispose();
	}
	/*
	 * close setup window
	 */
	public void finishedWindow() {
		gameEnvironment.closeSetupWindow(this);
	}
}
