package main.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.JToggleButton;


/**
 * class for Setup window when start the game
 * @author J Kim
 */
public class MainScreenGui {

	private JFrame frmMainWindow;


	/**
	 * Create the application.
	 */
	public  MainScreenGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setFrame();
		setLabels();
		setAthletePanel();
		setReservePanel();
		setItemPanel();
		setButton();
		setAthleteInfoPanel();
		setItemInfoPanel();
	}
	/*
	 * set the frame of main window
	 */
	private void setFrame() {
		frmMainWindow = new JFrame();
		frmMainWindow.setTitle("MAIN WINDOW");
		frmMainWindow.setSize(1650,1080);
		frmMainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainWindow.getContentPane().setLayout(null);
		frmMainWindow.setVisible(true);
	}
	/*
	 * set the labels on main window
	 */
	private void setLabels() {
		JLabel lblNewLabel = new JLabel("My team name : ");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel.setBounds(48, 36, 174, 30);
		frmMainWindow.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("week / ");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblNewLabel_1.setBounds(531, 37, 99, 30);
		frmMainWindow.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Difficulty Level : ");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel_2.setBounds(873, 36, 185, 30);
		frmMainWindow.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Active Athlete");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		lblNewLabel_3.setBounds(92, 206, 174, 28);
		frmMainWindow.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Reserves");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		lblNewLabel_4.setBounds(125, 414, 141, 59);
		frmMainWindow.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Inventory");
		lblNewLabel_4_1.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		lblNewLabel_4_1.setBounds(125, 700, 141, 59);
		frmMainWindow.getContentPane().add(lblNewLabel_4_1);
		
		JLabel lblTeammaneIsHere = new JLabel("TEAMNAME IS HERE");
		lblTeammaneIsHere.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblTeammaneIsHere.setBounds(234, 36, 256, 30);
		frmMainWindow.getContentPane().add(lblTeammaneIsHere);
		
		JLabel lblNewLabel_1_1 = new JLabel("NUM HERE");
		lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(477, 36, 57, 30);
		frmMainWindow.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("TOTAL WEEKS HERE");
		lblNewLabel_1_2.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(593, 38, 99, 30);
		frmMainWindow.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("DIFF LEVEL HERE");
		lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(1070, 36, 174, 30);
		frmMainWindow.getContentPane().add(lblNewLabel_2_1);
	}
	/**
	 * Panel for Athlete lists on main screen
	 */
	private void setAthletePanel() {

		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		panel.setBounds(300, 100, 700, 220);
		frmMainWindow.getContentPane().add(panel);
		panel.setLayout(null);
		
		JToggleButton btnNewButton = new JToggleButton("Athlete1");
		btnNewButton.setBounds(20, 20, 150, 150);
		panel.add(btnNewButton);
		
		JToggleButton btnAthlete = new JToggleButton("Athlete2");
		btnAthlete.setBounds(190, 20, 150, 150);
		panel.add(btnAthlete);
		
		JToggleButton btnAthlete_1 = new JToggleButton("Athlete3");
		btnAthlete_1.setBounds(360, 20, 150, 150);
		panel.add(btnAthlete_1);
		
		JToggleButton btnAthlete_2 = new JToggleButton("Athlete4");
		btnAthlete_2.setBounds(530, 20, 150, 150);
		panel.add(btnAthlete_2);
		
		JLabel lblNewLabel_5 = new JLabel("Athlete 1 Name");
		lblNewLabel_5.setBounds(30, 182, 131, 16);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_2 = new JLabel("Athlete 3 Name");
		lblNewLabel_5_2.setBounds(370, 182, 131, 16);
		panel.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_1 = new JLabel("Athlete 2 Name");
		lblNewLabel_5_1.setBounds(200, 182, 131, 16);
		panel.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_3 = new JLabel("Athlete 4 Name");
		lblNewLabel_5_3.setBounds(540, 182, 131, 16);
		panel.add(lblNewLabel_5_3);
	}
	/**
	 * Make panel for reserved athletes
	 */
	private void setReservePanel() {
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		panel_1.setBounds(300, 338, 530, 220);
		frmMainWindow.getContentPane().add(panel_1);
		
		JToggleButton btnAthlete_3 = new JToggleButton("Athlete5");
		btnAthlete_3.setBounds(20, 20, 150, 150);
		panel_1.add(btnAthlete_3);
		
		JToggleButton btnAthlete_4 = new JToggleButton("Athlete6");
		btnAthlete_4.setBounds(190, 20, 150, 150);
		panel_1.add(btnAthlete_4);
		
		JToggleButton btnAthlete_1_1 = new JToggleButton("Athlete7");
		btnAthlete_1_1.setBounds(360, 20, 150, 150);
		panel_1.add(btnAthlete_1_1);
		
		JLabel lblNewLabel_5_4 = new JLabel("Athlete 5 Name");
		lblNewLabel_5_4.setBounds(30, 182, 131, 16);
		panel_1.add(lblNewLabel_5_4);
		
		JLabel lblNewLabel_5_5 = new JLabel("Athlete 6 Name");
		lblNewLabel_5_5.setBounds(200, 182, 131, 16);
		panel_1.add(lblNewLabel_5_5);
		
		JLabel lblNewLabel_5_6 = new JLabel("Athlete 7 Name");
		lblNewLabel_5_6.setBounds(370, 182, 131, 16);
		panel_1.add(lblNewLabel_5_6);

	}
	
	
	
	/**
	 * Panel for item inventory on main screen
	 */
	private void setItemPanel() {
				
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(300, 624, 594, 220);
		frmMainWindow.getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(2, 7, 0, 0));
		
		
		JToggleButton itemButton1 = new JToggleButton("Item1");
		panel_2.add(itemButton1);
		JToggleButton itemButton2 = new JToggleButton("Item2");
		panel_2.add(itemButton2);
		JToggleButton itemButton3 = new JToggleButton("Item3");
		panel_2.add(itemButton3);
		JToggleButton itemButton4 = new JToggleButton("Item4");
		panel_2.add(itemButton4);
		JToggleButton itemButton5 = new JToggleButton("Item5");
		panel_2.add(itemButton5);
		JToggleButton itemButton6 = new JToggleButton("Item6");
		panel_2.add(itemButton6);
		JToggleButton itemButton7 = new JToggleButton("Item7");
		panel_2.add(itemButton7);
		JToggleButton itemButton8 = new JToggleButton("Item8");
		panel_2.add(itemButton8);
		JToggleButton itemButton9 = new JToggleButton("Item9");
		panel_2.add(itemButton9);
		JToggleButton itemButton10 = new JToggleButton("Item10");
		panel_2.add(itemButton10);

	}
	/*
	 * set buttons on main screen
	 */
	private void setButton() {
		
		JButton btnNewButton_1 = new JButton("Switch");
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton_1.setBounds(861, 480, 117, 78);
		frmMainWindow.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Use");
		btnNewButton_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton_1_1.setBounds(1026, 766, 117, 78);
		frmMainWindow.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Market");
		btnNewButton_1_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton_1_2.setBounds(125, 895, 237, 78);
		frmMainWindow.getContentPane().add(btnNewButton_1_2);
		
		JButton btnNewButton_1_2_1 = new JButton("Stadium");
		btnNewButton_1_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton_1_2_1.setBounds(421, 895, 237, 78);
		frmMainWindow.getContentPane().add(btnNewButton_1_2_1);
		
		// button to exit from the game. Small window will pop up and ask if the player really wants to eixt.
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitBox();
			}
		});
		exitButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		exitButton.setBounds(1512, 971, 117, 30);
		frmMainWindow.getContentPane().add(exitButton);
	
	}
	
	/*
	 * set the information panel for athlete on main screen
	 */
	private void setAthleteInfoPanel() {
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(1212, 100, 300, 460);
		frmMainWindow.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("<<Athelte Information>>");
		lblNewLabel_6.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel_6.setBounds(15, 20, 271, 20);
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("- Name -");
		lblNewLabel_7.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(22, 65, 81, 20);
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("- Description -");
		lblNewLabel_7_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_7_1.setBounds(22, 120, 142, 20);
		panel_3.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_7_2 = new JLabel("- Rarity -");
		lblNewLabel_7_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_7_2.setBounds(15, 200, 105, 20);
		panel_3.add(lblNewLabel_7_2);
		
		JLabel lblNewLabel_7_3 = new JLabel("- Offense -");
		lblNewLabel_7_3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_7_3.setBounds(15, 250, 105, 20);
		panel_3.add(lblNewLabel_7_3);
		
		JLabel lblNewLabel_7_3_1 = new JLabel("- Deffense -");
		lblNewLabel_7_3_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_7_3_1.setBounds(15, 300, 105, 20);
		panel_3.add(lblNewLabel_7_3_1);
		
		JLabel lblNewLabel_7_3_2 = new JLabel("- Stamina -");
		lblNewLabel_7_3_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_7_3_2.setBounds(15, 350, 105, 20);
		panel_3.add(lblNewLabel_7_3_2);
		
		JLabel lblNewLabel_7_4 = new JLabel("ATHLETE NAME HERE");
		lblNewLabel_7_4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_7_4.setBounds(22, 93, 233, 20);
		panel_3.add(lblNewLabel_7_4);
		
		JLabel lblNewLabel_7_4_1 = new JLabel("ATHLETE DISCRP HERE");
		lblNewLabel_7_4_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_7_4_1.setBounds(22, 146, 233, 20);
		panel_3.add(lblNewLabel_7_4_1);
		
		JLabel lblNewLabel_7_4_1_1 = new JLabel("ATHLETE RARITY HERE");
		lblNewLabel_7_4_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_7_4_1_1.setBounds(22, 224, 233, 20);
		panel_3.add(lblNewLabel_7_4_1_1);
		
		JLabel lblNewLabel_7_4_1_2 = new JLabel("ATHLETE OFFNS HERE");
		lblNewLabel_7_4_1_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_7_4_1_2.setBounds(25, 275, 233, 20);
		panel_3.add(lblNewLabel_7_4_1_2);
		
		JLabel lblNewLabel_7_4_1_3 = new JLabel("ATHLETE DIFNS HERE");
		lblNewLabel_7_4_1_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_7_4_1_3.setBounds(25, 325, 233, 20);
		panel_3.add(lblNewLabel_7_4_1_3);
		
		JLabel lblNewLabel_7_4_1_4 = new JLabel("ATHLETE STAMINA HERE");
		lblNewLabel_7_4_1_4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_7_4_1_4.setBounds(25, 378, 233, 20);
		panel_3.add(lblNewLabel_7_4_1_4);
	}
	
	/*
	 * set the information panel for athlete on main screen
	 */
	private void setItemInfoPanel() {
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3_1.setBounds(1212, 624, 297, 220);
		frmMainWindow.getContentPane().add(panel_3_1);
		panel_3_1.setLayout(null);
		
		JLabel lblNewLabel_6_1 = new JLabel("-Item Information-");
		lblNewLabel_6_1.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel_6_1.setBounds(44, 17, 247, 20);
		panel_3_1.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_7_3_2_1 = new JLabel("IncStat");
		lblNewLabel_7_3_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_7_3_2_1.setBounds(25, 101, 74, 20);
		panel_3_1.add(lblNewLabel_7_3_2_1);
		
		JLabel lblNewLabel_7_3_2_1_1 = new JLabel("IncAmount");
		lblNewLabel_7_3_2_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_7_3_2_1_1.setBounds(116, 101, 74, 20);
		panel_3_1.add(lblNewLabel_7_3_2_1_1);
	}
	
		
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
