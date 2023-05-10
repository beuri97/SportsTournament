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

import main.GameEnvironment;

import javax.swing.JToggleButton;
import main.gameObject.*;

/**
 * class for Setup window when start the game
 * @author J Kim
 */
public class MainScreenGui {

	private JFrame frmMainWindow;
	GameEnvironment gameEnvironment;
	Team team;
	String teamName;

	
	int athleteSwitchingNum1 = -1;
	int athleteSwitchingNum2 = -1;
	int usingItemNum = -1;
	
	/**
	 * Create the application.
	 */
	public  MainScreenGui(GameEnvironment gameEnvironment) {
		this.gameEnvironment = gameEnvironment;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setFrame();
		setLabels();
		setAthleteItemPanel();
		setAthleteInfoPanel();
		setItemInfoPanel();
		setButton();
		
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
	 * set all the labels on main window
	 */
	private void setLabels() {
		JLabel myTeamLabel = new JLabel("My team name :");
		myTeamLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		myTeamLabel.setBounds(48, 36, 218, 30);
		frmMainWindow.getContentPane().add(myTeamLabel);
		
		JLabel weekLabel = new JLabel("week / ");
		weekLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		weekLabel.setBounds(609, 38, 99, 30);
		frmMainWindow.getContentPane().add(weekLabel);
		
		JLabel diffLevelLabel = new JLabel("Difficulty Level : ");
		diffLevelLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		diffLevelLabel.setBounds(873, 36, 202, 30);
		frmMainWindow.getContentPane().add(diffLevelLabel);
		
		JLabel activeLabel = new JLabel("Active Athlete");
		activeLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		activeLabel.setBounds(92, 206, 174, 28);
		frmMainWindow.getContentPane().add(activeLabel);
		
		JLabel reservesLabel = new JLabel("Reserves");
		reservesLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		reservesLabel.setBounds(125, 414, 141, 59);
		frmMainWindow.getContentPane().add(reservesLabel);
		
		JLabel inventoryLabel = new JLabel("Inventory");
		inventoryLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		inventoryLabel.setBounds(125, 700, 141, 59);
		frmMainWindow.getContentPane().add(inventoryLabel);
	
		JLabel teamNameLabel = new JLabel("teamName");
		teamNameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		teamNameLabel.setBounds(248, 37, 256, 30);
		frmMainWindow.getContentPane().add(teamNameLabel);
		teamNameLabel.setText(gameEnvironment.getTeam().getName());
		
		JLabel weekNumLabel = new JLabel("NUM HERE");
		weekNumLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		weekNumLabel.setBounds(477, 36, 163, 30);
		frmMainWindow.getContentPane().add(weekNumLabel);
		
		JLabel totalweekLabel = new JLabel("TOTAL WEEKS HERE");
		totalweekLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		totalweekLabel.setBounds(671, 38, 190, 30);
		frmMainWindow.getContentPane().add(totalweekLabel);
////	totalweekLabel.setText(gameEnvironment.season);
		
		JLabel selectedDifficultyLabel = new JLabel("SelectedDifficulty");
		selectedDifficultyLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		selectedDifficultyLabel.setBounds(1087, 36, 174, 30);
		frmMainWindow.getContentPane().add(selectedDifficultyLabel);
		selectedDifficultyLabel.setText(gameEnvironment.getDifficulty());
		
		JLabel lblMoney = new JLabel("$ Money");
		lblMoney.setFont(new Font("Lucida Grande", Font.BOLD, 27));
		lblMoney.setBounds(1224, 36, 202, 30);
		frmMainWindow.getContentPane().add(lblMoney);
	}
	/**
	 * Panel for Athlete lists on main screen
	 */
	private void setAthleteItemPanel() {
		
		//Create the panel for Active Athletes
		JPanel setAthletePanel = new JPanel();
		setAthletePanel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		setAthletePanel.setBounds(300, 100, 700, 220);
		frmMainWindow.getContentPane().add(setAthletePanel);
		setAthletePanel.setLayout(null);
		
		//Create the panel for Reserves Athletes
		JPanel setReservePanel = new JPanel();
		setReservePanel.setLayout(null);
		setReservePanel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		setReservePanel.setBounds(300, 338, 530, 220);
		frmMainWindow.getContentPane().add(setReservePanel);
		
		//Create the panel for item in player's inventory
		JPanel setItemPanel = new JPanel();
		setItemPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		setItemPanel.setBounds(300, 624, 594, 220);
		frmMainWindow.getContentPane().add(setItemPanel);
		setItemPanel.setLayout(new GridLayout(2, 7, 0, 0));
		
		//Create toggle buttons for All the athletes that the player owns.
		// 1~4 are Active, 5~7 are Reserves
		JToggleButton athleteButton1 = new JToggleButton("Athlete1");
		JToggleButton athleteButton2 = new JToggleButton("Athlete2");
		JToggleButton athleteButton3 = new JToggleButton("Athlete3");
		JToggleButton athleteButton4 = new JToggleButton("Athlete4");
		JToggleButton athleteButton5 = new JToggleButton("Athlete5");
		JToggleButton athleteButton6 = new JToggleButton("Athlete6");
		JToggleButton athleteButton7 = new JToggleButton("Athlete7");
		athleteButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteSwitchingNum1 = 0;
				athleteButton2.setSelected(false);
				athleteButton3.setSelected(false);
				athleteButton4.setSelected(false);
			}
		});
		athleteButton1.setBounds(20, 20, 150, 150);
		setAthletePanel.add(athleteButton1);
		
		athleteButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteSwitchingNum1 = 1;
				athleteButton1.setSelected(false);
				athleteButton3.setSelected(false);
				athleteButton4.setSelected(false);
			}
		});
		athleteButton2.setBounds(190, 20, 150, 150);
		setAthletePanel.add(athleteButton2);
		
		athleteButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteSwitchingNum1 = 2;
				athleteButton1.setSelected(false);
				athleteButton2.setSelected(false);
				athleteButton4.setSelected(false);
			}
		});
		athleteButton3.setBounds(360, 20, 150, 150);
		setAthletePanel.add(athleteButton3);
				
		athleteButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteSwitchingNum1 = 3;
				athleteButton1.setSelected(false);
				athleteButton2.setSelected(false);
				athleteButton3.setSelected(false);
			}
		});
		athleteButton4.setBounds(530, 20, 150, 150);
		setAthletePanel.add(athleteButton4);
			
		athleteButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteSwitchingNum2 = 4;
				athleteButton6.setSelected(false);
				athleteButton7.setSelected(false);
			}
		});
		athleteButton5.setBounds(20, 20, 150, 150);
		setReservePanel.add(athleteButton5);
			
		athleteButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteSwitchingNum2 = 5;
				athleteButton5.setSelected(false);
				athleteButton7.setSelected(false);
			}
		});
		athleteButton6.setBounds(190, 20, 150, 150);
		setReservePanel.add(athleteButton6);
			
		athleteButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteSwitchingNum2 = 6;
				athleteButton5.setSelected(false);
				athleteButton6.setSelected(false);
			}
		});
		athleteButton7.setBounds(360, 20, 150, 150);
		setReservePanel.add(athleteButton7);
		
		JLabel athleteLabel1 = new JLabel("Athlete 1 Name");
		athleteLabel1.setBounds(30, 182, 131, 16);
		setAthletePanel.add(athleteLabel1);
		athleteLabel1.setText("Athlete 1 Name");
		
		JLabel athleteLabel2 = new JLabel("Athlete 2 Name");
		athleteLabel2.setBounds(200, 182, 131, 16);
		setAthletePanel.add(athleteLabel2);
		athleteLabel2.setText("Athlete 2 Name");
		
		JLabel athleteLabel3 = new JLabel("Athlete 3 Name");
		athleteLabel3.setBounds(370, 182, 131, 16);
		setAthletePanel.add(athleteLabel3);
		athleteLabel3.setText("Athlete 3 Name");
	
		JLabel athleteLabel4 = new JLabel("Athlete 4 Name");
		athleteLabel4.setBounds(540, 182, 131, 16);
		setAthletePanel.add(athleteLabel4);
		athleteLabel4.setText("Athlete 4 Name");
		
		JLabel athleteLabel5 = new JLabel("Athlete 5 Name");
		athleteLabel5.setBounds(30, 182, 131, 16);
		setReservePanel.add(athleteLabel5);
		athleteLabel5.setText("Athlete 5 Name");
		
		JLabel athleteLabel6 = new JLabel("Athlete 6 Name");
		athleteLabel6.setBounds(200, 182, 131, 16);
		setReservePanel.add(athleteLabel6);
		athleteLabel6.setText("Athlete 6 Name");
		
		JLabel athleteLabel7 = new JLabel("Athlete 7 Name");
		athleteLabel7.setBounds(370, 182, 131, 16);
		setReservePanel.add(athleteLabel7);
		athleteLabel7.setText("Athlete 7 Name");
		
		//switch two selected athletes around and reset all toggle buttons of Athletes
		JButton switchButton = new JButton("Switch");
		switchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (athleteSwitchingNum1 >= 0 && athleteSwitchingNum2 >= 0) {
					//Swap
				}
				athleteButton1.setSelected(false);
				athleteButton2.setSelected(false);
				athleteButton3.setSelected(false);
				athleteButton4.setSelected(false);
				athleteButton5.setSelected(false);
				athleteButton6.setSelected(false);
				athleteButton7.setSelected(false);
				athleteSwitchingNum1 = -1;
				athleteSwitchingNum2 = -1;
			}
		});
		switchButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		switchButton.setBounds(861, 480, 117, 78);
		frmMainWindow.getContentPane().add(switchButton);
		
		JToggleButton itemButton1 = new JToggleButton("Item1");
		JToggleButton itemButton2 = new JToggleButton("Item2");
		JToggleButton itemButton3 = new JToggleButton("Item3");
		JToggleButton itemButton4 = new JToggleButton("Item4");
		JToggleButton itemButton5 = new JToggleButton("Item5");
		JToggleButton itemButton6 = new JToggleButton("Item6");
		JToggleButton itemButton7 = new JToggleButton("Item7");
		JToggleButton itemButton8 = new JToggleButton("Item8");
		JToggleButton itemButton9 = new JToggleButton("Item9");
		JToggleButton itemButton10 = new JToggleButton("Item10");
		itemButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usingItemNum = 0;
				itemButton2.setSelected(false);
				itemButton3.setSelected(false);
				itemButton4.setSelected(false);
				itemButton5.setSelected(false);
				itemButton6.setSelected(false);
				itemButton7.setSelected(false);
				itemButton8.setSelected(false);
				itemButton9.setSelected(false);
				itemButton10.setSelected(false);				
			}
		});
		setItemPanel.add(itemButton1);
		
		itemButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usingItemNum = 1;
				itemButton1.setSelected(false);
				itemButton3.setSelected(false);
				itemButton4.setSelected(false);
				itemButton5.setSelected(false);
				itemButton6.setSelected(false);
				itemButton7.setSelected(false);
				itemButton8.setSelected(false);
				itemButton9.setSelected(false);
				itemButton10.setSelected(false);
			}
		});
		setItemPanel.add(itemButton2);
		
		itemButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usingItemNum = 2;
				itemButton1.setSelected(false);
				itemButton2.setSelected(false);
				itemButton4.setSelected(false);
				itemButton5.setSelected(false);
				itemButton6.setSelected(false);
				itemButton7.setSelected(false);
				itemButton8.setSelected(false);
				itemButton9.setSelected(false);
				itemButton10.setSelected(false);
			}
		});
		setItemPanel.add(itemButton3);
		
		itemButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usingItemNum = 3;
				itemButton1.setSelected(false);
				itemButton2.setSelected(false);
				itemButton3.setSelected(false);
				itemButton5.setSelected(false);
				itemButton6.setSelected(false);
				itemButton7.setSelected(false);
				itemButton8.setSelected(false);
				itemButton9.setSelected(false);
				itemButton10.setSelected(false);
			}
		});
		setItemPanel.add(itemButton4);
		
		itemButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usingItemNum = 4;
				itemButton1.setSelected(false);
				itemButton2.setSelected(false);
				itemButton3.setSelected(false);
				itemButton4.setSelected(false);
				itemButton6.setSelected(false);
				itemButton7.setSelected(false);
				itemButton8.setSelected(false);
				itemButton9.setSelected(false);
				itemButton10.setSelected(false);
			}
		});
		setItemPanel.add(itemButton5);
		
		itemButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usingItemNum = 5;
				itemButton1.setSelected(false);
				itemButton2.setSelected(false);
				itemButton3.setSelected(false);
				itemButton4.setSelected(false);
				itemButton5.setSelected(false);
				itemButton7.setSelected(false);
				itemButton8.setSelected(false);
				itemButton9.setSelected(false);
				itemButton10.setSelected(false);
			}
		});
		setItemPanel.add(itemButton6);
		
		itemButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usingItemNum = 6;
				itemButton1.setSelected(false);
				itemButton2.setSelected(false);
				itemButton3.setSelected(false);
				itemButton4.setSelected(false);
				itemButton5.setSelected(false);
				itemButton6.setSelected(false);
				itemButton8.setSelected(false);
				itemButton9.setSelected(false);
				itemButton10.setSelected(false);
			}
		});
		setItemPanel.add(itemButton7);
		
		itemButton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usingItemNum = 7;
				itemButton1.setSelected(false);
				itemButton2.setSelected(false);
				itemButton3.setSelected(false);
				itemButton4.setSelected(false);
				itemButton5.setSelected(false);
				itemButton6.setSelected(false);
				itemButton7.setSelected(false);
				itemButton9.setSelected(false);
				itemButton10.setSelected(false);
			}
		});
		setItemPanel.add(itemButton8);
		
		itemButton9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usingItemNum = 8;
				itemButton1.setSelected(false);
				itemButton2.setSelected(false);
				itemButton3.setSelected(false);
				itemButton4.setSelected(false);
				itemButton5.setSelected(false);
				itemButton6.setSelected(false);
				itemButton7.setSelected(false);
				itemButton8.setSelected(false);
				itemButton10.setSelected(false);
			}
		});
		setItemPanel.add(itemButton9);
		
		itemButton10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usingItemNum = 9;
				itemButton1.setSelected(false);
				itemButton2.setSelected(false);
				itemButton3.setSelected(false);
				itemButton4.setSelected(false);
				itemButton5.setSelected(false);
				itemButton6.setSelected(false);
				itemButton7.setSelected(false);
				itemButton8.setSelected(false);
				itemButton9.setSelected(false);
			}
		});
		setItemPanel.add(itemButton10);
		
		JLabel noticeUsingSwitching = new JLabel("");
		noticeUsingSwitching.setForeground(new Color(255, 11, 3));
		noticeUsingSwitching.setBounds(906, 738, 282, 16);
		frmMainWindow.getContentPane().add(noticeUsingSwitching);

		JButton itemUseButton = new JButton("Use");
		itemUseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//print select only one athlete
				if (athleteSwitchingNum1 >= 0 && athleteSwitchingNum2 >= 0) {
					noticeUsingSwitching.setText("Select Only One Athlete!");
				}
				//print select one item & one athlete
				else if (usingItemNum < 0 || (athleteSwitchingNum1 < 0 && athleteSwitchingNum2 < 0)){
					noticeUsingSwitching.setText("Select One Item and Athlete each!");

				}
				else if (usingItemNum >= 0 && (athleteSwitchingNum1 >= 0 || athleteSwitchingNum2 >= 0)) {
					if (athleteSwitchingNum1 >= 0) {
						//use item for num1
						noticeUsingSwitching.setText("Used item! Check the difference!!");
					}
					else if(athleteSwitchingNum2 >= 0) {
						//use item for num2
						noticeUsingSwitching.setText("Used item! Check the difference!!");
					}
				}
				athleteButton1.setSelected(false);
				athleteButton2.setSelected(false);
				athleteButton3.setSelected(false);
				athleteButton4.setSelected(false);
				athleteButton5.setSelected(false);
				athleteButton6.setSelected(false);
				athleteButton7.setSelected(false);
				athleteSwitchingNum1 = -1;
				athleteSwitchingNum2 = -1;
				
				itemButton1.setSelected(false);
				itemButton2.setSelected(false);
				itemButton3.setSelected(false);
				itemButton4.setSelected(false);
				itemButton5.setSelected(false);
				itemButton6.setSelected(false);
				itemButton7.setSelected(false);
				itemButton8.setSelected(false);
				itemButton9.setSelected(false);
				itemButton10.setSelected(false);
				usingItemNum = -1;
			}
		});
		itemUseButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		itemUseButton.setBounds(984, 766, 117, 78);
		frmMainWindow.getContentPane().add(itemUseButton);
	
	}


	/*
	 * set buttons on main screen
	 */
	private void setButton() {
		
		JButton marketButton = new JButton("Market");
		marketButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMainWindow.dispose();
				MarketGui openMarket = new MarketGui(gameEnvironment);
			}
		});
		marketButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		marketButton.setBounds(125, 895, 237, 78);
		frmMainWindow.getContentPane().add(marketButton);
		
		JButton stadiumButton = new JButton("Stadium");
		stadiumButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		stadiumButton.setBounds(421, 895, 237, 78);
		frmMainWindow.getContentPane().add(stadiumButton);
		
		// button to exit from the game. Small window will pop up and ask if the player really wants to exit.
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
