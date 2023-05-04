package main.gui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Font;
import java.awt.Color;

/**
 * class for Setup window when start the game
 * @author J Kim
 */
public class SetupScreenGui {

	private JFrame frmFencingGame;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JSlider slider;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetupScreenGui window = new SetupScreenGui();
					window.frmFencingGame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SetupScreenGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//set up the window frame
		
		setFrame();
		setJlabel();
		setTextField();
		setJSlider();
		setJbutton();	
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
	private void setJlabel() {
		frmFencingGame.getContentPane().setLayout(null);
		JLabel welcoming = new JLabel("Welcome to FencingTournament");
		welcoming.setBounds(714, 418, 308, 25);
		welcoming.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		frmFencingGame.getContentPane().add(welcoming);
		JLabel label = new JLabel("Team Name : ");
		label.setBounds(558, 533, 86, 16);
		frmFencingGame.getContentPane().add(label);
		
		lblNewLabel = new JLabel("Number of weeks for one season :");
		lblNewLabel.setBounds(494, 589, 215, 16);
		lblNewLabel.setToolTipText("");
		frmFencingGame.getContentPane().add(lblNewLabel);
	}
	/**
	 * show slider to choose the number of weeks per season
	 */
	private void setJSlider() {
		slider = new JSlider(5,15);
		slider.setBounds(828, 571, 190, 52);
		JLabel status = new JLabel("Slide the slider!!");
		status.setBounds(1023, 589, 101, 16);
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
		
		textField = new JTextField();
		textField.setBounds(759, 531, 370, 26);
		frmFencingGame.getContentPane().add(textField);	
		textField.setColumns(30);
		JLabel label = new JLabel("Enter your team name here");
		label.setBounds(849, 557, 144, 14);
		label.setForeground(new Color(255, 0, 0));
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		frmFencingGame.getContentPane().add(label);
	}
	/**
	 * show difficulty option with label and buttons to choose.
	 */
	private void setJbutton() {
		JLabel label = new JLabel("Difficulty :");
		label.setBounds(568, 664, 67, 16);
		frmFencingGame.getContentPane().add(label);
		JButton button = new JButton("Easy");
		button.setBounds(943, 658, 75, 29);
		frmFencingGame.getContentPane().add(button);
		JButton button_1 = new JButton("Difficult");
		button_1.setBounds(1028, 658, 96, 29);
		frmFencingGame.getContentPane().add(button_1);
		JButton button_2 = new JButton("Start game");
		button_2.setBounds(1129, 722, 111, 29);
		frmFencingGame.getContentPane().add(button_2);
	}
	

}
