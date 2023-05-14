package main.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import main.GameEnvironment;
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

public class StadiumGui {

	private JFrame frmStadium;
	
	GameEnvironment gameEnvironment;
	Athlete[] myRoster;
	private JTextField txtA;

	/**
	 * Create the application.
	 */
	public StadiumGui(GameEnvironment gameEnvironment) {
		this.gameEnvironment = gameEnvironment;
		this.myRoster = gameEnvironment.getTeam().getRoster();
		setup(gameEnvironment);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void setup(GameEnvironment gameEnvironment) {
		setFrame();
	}
	
	private void setFrame() {
		frmStadium = new JFrame();
		frmStadium.setSize(1650,1080);
		frmStadium.getContentPane().setLayout(null);
		frmStadium.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBounds(95, 128, 306, 448);
		frmStadium.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("My Team");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 23));
		lblNewLabel.setBounds(12, 12, 137, 33);
		panel.add(lblNewLabel);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Aggressive");
		tglbtnNewToggleButton.setFont(new Font("Dialog", Font.BOLD, 16));
		tglbtnNewToggleButton.setBounds(496, 646, 132, 46);
		frmStadium.getContentPane().add(tglbtnNewToggleButton);
		
		JToggleButton tglbtnCareful = new JToggleButton("Careful");
		tglbtnCareful.setFont(new Font("Dialog", Font.BOLD, 16));
		tglbtnCareful.setBounds(666, 646, 138, 46);
		frmStadium.getContentPane().add(tglbtnCareful);
		
		JLabel lblNewLabel_1 = new JLabel("my current stat with buff");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_1.setBounds(496, 510, 306, 106);
		frmStadium.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setBorder(new LineBorder(UIManager.getColor("Button.foreground")));
		
		JLabel lblNewLabel_1_1 = new JLabel("opponent current stat with buff");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_1_1.setBorder(new LineBorder(UIManager.getColor("Button.foreground")));
		lblNewLabel_1_1.setBounds(915, 510, 306, 106);
		frmStadium.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("opponent current stance");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setBackground(new Color(152, 106, 68));
		lblNewLabel_1_1_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBorder(new LineBorder(UIManager.getColor("Button.foreground")));
		lblNewLabel_1_1_1.setBounds(915, 642, 306, 52);
		frmStadium.getContentPane().add(lblNewLabel_1_1_1);
		
		txtA = new JTextField();
		txtA.setText("game photo");
		txtA.setHorizontalAlignment(SwingConstants.CENTER);
		txtA.setBounds(496, 149, 730, 322);
		frmStadium.getContentPane().add(txtA);
		txtA.setColumns(10);
		
		JButton btnNewButton = new JButton("Back to Main");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitBox();
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 17));
		btnNewButton.setBounds(1483, 951, 155, 40);
		frmStadium.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1_2 = new JLabel("Game Result description");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_1_2.setBorder(new LineBorder(UIManager.getColor("Button.foreground")));
		lblNewLabel_1_2.setBounds(711, 738, 306, 106);
		frmStadium.getContentPane().add(lblNewLabel_1_2);
		
		JButton btnNewButton_1 = new JButton("Fight");
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 30));
		btnNewButton_1.setBounds(711, 904, 306, 69);
		frmStadium.getContentPane().add(btnNewButton_1);
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
