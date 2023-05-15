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
import main.UserInterface;

import javax.swing.JToggleButton;
import main.gameObject.*;
import main.gameObject.athletes.Athlete;
import main.gameObject.item.Item;

import javax.swing.SwingConstants;

/**
 * class for Setup window when start the game
 * @author J Kim
 */
public class MainScreenGui implements UserInterface{

	private JFrame frmMainWindow;
	GameEnvironment gameEnvironment;
	Team team;
	String teamName;
	Athlete[] myRoster;
	Item[] myInvertory;

	// next three ints indicate the Athlete buttons in Active, Reserve and item button are clicked, 
	//	when int is -1, button is not clicked
	//	when int is greater than 0(inclusive), it is clicked
	//	this number will be used as index to call athletes and item from from the arraylist. 
	int athleteSwitchingNum1 = -1;
	int athleteSwitchingNum2 = -1;
	int usingItemNum = -1;
	
	private JToggleButton athleteButton1;
	private JToggleButton athleteButton2;
	private JToggleButton athleteButton3;
	private JToggleButton athleteButton4;
	private JToggleButton athleteButton5;
	private JToggleButton athleteButton6;
	private JToggleButton athleteButton7;
	
	private JToggleButton itemButton1;
	private JToggleButton itemButton2;
	private JToggleButton itemButton3;
	private JToggleButton itemButton4;
	private JToggleButton itemButton5;
	private JToggleButton itemButton6;
	private JToggleButton itemButton7;
	private JToggleButton itemButton8;
	private JToggleButton itemButton9;
	private JToggleButton itemButton10;
	
	

	JLabel noticeLabel;
	JLabel athleteDescriptionLabel;
	JLabel itemDescriptionLabel;
	JLabel moneyLabel;
	
	/**
	 * Create the application.
	 */
	public  MainScreenGui(GameEnvironment gameEnvironment) {
		this.gameEnvironment = gameEnvironment;
		this.myRoster = gameEnvironment.getTeam().getRoster();
		this.myInvertory = gameEnvironment.getTeam().getInventory();
		setup(gameEnvironment);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void setup(GameEnvironment gameEnvironment) {
		
		setFrameLabels();
		setAthletePanel();
		setItemPanel();
		setAthleteItemInfoPanel();
		setButton();
	}

	/*
	 * set the main frame and all the labels on main window
	 */
	private void setFrameLabels() {
		
		frmMainWindow = new JFrame();
		frmMainWindow.setTitle("MAIN WINDOW");
		frmMainWindow.setSize(1650,1080);
		frmMainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainWindow.getContentPane().setLayout(null);
		frmMainWindow.setVisible(true);
		
		JLabel myTeamLabel = new JLabel("My team name :");
		myTeamLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		myTeamLabel.setBounds(48, 36, 218, 30);
		frmMainWindow.getContentPane().add(myTeamLabel);
		
		JLabel diffLevelLabel = new JLabel("Difficulty Level : ");
		diffLevelLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		diffLevelLabel.setBounds(926, 36, 202, 30);
		frmMainWindow.getContentPane().add(diffLevelLabel);
		
		JLabel activeLabel = new JLabel("Active Athlete");
		activeLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		activeLabel.setBounds(92, 182, 174, 28);
		frmMainWindow.getContentPane().add(activeLabel);
		
		JLabel reservesLabel = new JLabel("Reserves");
		reservesLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		reservesLabel.setBounds(125, 407, 141, 59);
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
		weekNumLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		weekNumLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		weekNumLabel.setBounds(632, 36, 141, 30);
		frmMainWindow.getContentPane().add(weekNumLabel);
		
		int currentWeek = gameEnvironment.getCurrentSeason();
		if (currentWeek == 1) {weekNumLabel.setText("1st week");}
		else if((currentWeek == 2)){weekNumLabel.setText("2nd week");}
		else {weekNumLabel.setText(gameEnvironment.getCurrentSeason() + "rd week");}
		
		JLabel totalweekLabel = new JLabel(" / Total "+ gameEnvironment.getTotalSeason() + "weeks");
		totalweekLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		totalweekLabel.setBounds(785, 38, 243, 30);
		frmMainWindow.getContentPane().add(totalweekLabel);
		
		JLabel selectedDifficultyLabel = new JLabel(gameEnvironment.getDifficulty().toString());
		selectedDifficultyLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		selectedDifficultyLabel.setBounds(1140, 36, 174, 30);
		frmMainWindow.getContentPane().add(selectedDifficultyLabel);
		
		moneyLabel = new JLabel("$ " + gameEnvironment.getTeam().getMoney());
		moneyLabel.setFont(new Font("Lucida Grande", Font.BOLD, 27));
		moneyLabel.setBounds(1277, 36, 202, 30);
		frmMainWindow.getContentPane().add(moneyLabel);
		
		noticeLabel = new JLabel("");
		noticeLabel.setForeground(new Color(255, 11, 3));
		noticeLabel.setBounds(300, 566, 594, 30);
		frmMainWindow.getContentPane().add(noticeLabel);
	}

	/**
	 * Panel for Athlete lists on main screen
	 */
	private void setAthletePanel() {
		
		//Create the panel for Active Athletes
		JPanel setAthletePanel = new JPanel();
		setAthletePanel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		setAthletePanel.setBounds(300, 100, 698, 190);
		frmMainWindow.getContentPane().add(setAthletePanel);
		setAthletePanel.setLayout(null);
		
		//Create the panel for Reserves Athletes
		JPanel setReservePanel = new JPanel();
		setReservePanel.setLayout(null);
		setReservePanel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		setReservePanel.setBounds(300, 338, 535, 190);
		frmMainWindow.getContentPane().add(setReservePanel);
		
		//Create toggle buttons for All the athletes that the player owns.
		// 1~4 are Active, 5~7 are Reserves
		athleteButton1 = new JToggleButton("Athlete1");
		athleteButton2 = new JToggleButton("Athlete2");
		athleteButton3 = new JToggleButton("Athlete3");
		athleteButton4 = new JToggleButton("Athlete4");
		athleteButton5 = new JToggleButton("Athlete5");
		athleteButton6 = new JToggleButton("Athlete6");
		athleteButton7 = new JToggleButton("Athlete7");
		
		athleteButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncAthleteSlots(0);	
				athleteButton1.setSelected(true);}});
		athleteButton1.setBounds(20, 20, 150, 150);
		setAthletePanel.add(athleteButton1);
		
		athleteButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncAthleteSlots(1);	
				athleteButton2.setSelected(true);}});
		athleteButton2.setBounds(190, 20, 150, 150);
		setAthletePanel.add(athleteButton2);
		
		athleteButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncAthleteSlots(2);	
				athleteButton3.setSelected(true);}});
		athleteButton3.setBounds(360, 20, 150, 150);
		setAthletePanel.add(athleteButton3);
				
		athleteButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncAthleteSlots(3);	
				athleteButton4.setSelected(true);}});
		athleteButton4.setBounds(530, 20, 150, 150);
		setAthletePanel.add(athleteButton4);
			
		athleteButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncAthleteSlots(4);	
				athleteButton5.setSelected(true);}});
		athleteButton5.setBounds(20, 20, 150, 150);
		setReservePanel.add(athleteButton5);
			
		athleteButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncAthleteSlots(5);	
				athleteButton6.setSelected(true);}});
		athleteButton6.setBounds(190, 20, 150, 150);
		setReservePanel.add(athleteButton6);
			
		athleteButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncAthleteSlots(6);	
				athleteButton7.setSelected(true);}});
		athleteButton7.setBounds(360, 20, 150, 150);
		setReservePanel.add(athleteButton7);
	}
	
	private void setItemPanel(){
	//Create the panel for item in player's inventory
	JPanel setItemPanel = new JPanel();
	setItemPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
	setItemPanel.setBounds(300, 624, 594, 220);
	frmMainWindow.getContentPane().add(setItemPanel);
	setItemPanel.setLayout(new GridLayout(2, 7, 0, 0));
	
	itemButton1 = new JToggleButton("Item1");
	itemButton2 = new JToggleButton("Item2");
	itemButton3 = new JToggleButton("Item3");
	itemButton4 = new JToggleButton("Item4");
	itemButton5 = new JToggleButton("Item5");
	itemButton6 = new JToggleButton("Item6");
	itemButton7 = new JToggleButton("Item7");
	itemButton8 = new JToggleButton("Item8");
	itemButton9 = new JToggleButton("Item9");
	itemButton10 = new JToggleButton("Item10");
	
	itemButton1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			helpFuncItemSlots(0);
			itemButton1.setSelected(true);}});
	setItemPanel.add(itemButton1);
	
	itemButton2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			helpFuncItemSlots(1);
			itemButton2.setSelected(true);}});
	setItemPanel.add(itemButton2);
	
	itemButton3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			helpFuncItemSlots(2);
			itemButton3.setSelected(true);}});
	setItemPanel.add(itemButton3);
	
	itemButton4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			helpFuncItemSlots(3);			
			itemButton4.setSelected(true);}});
	setItemPanel.add(itemButton4);
	
	itemButton5.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			helpFuncItemSlots(4);
			itemButton5.setSelected(true);}});
	setItemPanel.add(itemButton5);
	
	itemButton6.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			helpFuncItemSlots(5);
			itemButton6.setSelected(true);}});
	setItemPanel.add(itemButton6);
	
	itemButton7.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			helpFuncItemSlots(6);
			itemButton7.setSelected(true);}});
	setItemPanel.add(itemButton7);
	
	itemButton8.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			helpFuncItemSlots(7);
			itemButton8.setSelected(true);}});
	setItemPanel.add(itemButton8);
	
	itemButton9.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			helpFuncItemSlots(8);
			itemButton9.setSelected(true);}});
	setItemPanel.add(itemButton9);
	
	itemButton10.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			helpFuncItemSlots(9);
			itemButton10.setSelected(true);}});
	setItemPanel.add(itemButton10);	
	}
	/*
	 * this is help function to reset athlete toggle buttons and assign athlete slot number that player clicked to switch athletes
	 */
	private void helpFuncAthleteSlots(int slotNum) {
		if (slotNum < 4){
			athleteSwitchingNum1 = slotNum;
			athleteButton1.setSelected(false);
			athleteButton2.setSelected(false);
			athleteButton3.setSelected(false);
			athleteButton4.setSelected(false);	
		}
		else if (slotNum >= 4){
			athleteSwitchingNum2 = slotNum;
			athleteButton5.setSelected(false);
			athleteButton6.setSelected(false);
			athleteButton7.setSelected(false);
		}

			athleteDescriptionLabel.setText(printing(myRoster[slotNum]));
			
	}
	/*
	 * this is help function to implement cancelItemToggle() method and assign slot number that player clicked
	 */
	private void helpFuncItemSlots(int slotNum) {
			cancelItemToggle();
			usingItemNum = slotNum;
			itemDescriptionLabel.setText(printing(myInvertory[slotNum]));
	}

	/*
	 * update screen with the latest information.
	 */
	private void refreshScreen() {
		moneyLabel.setText("$ " + gameEnvironment.getTeam().getMoney());
		myRoster = gameEnvironment.getTeam().getRoster();
		myInvertory = gameEnvironment.getTeam().getInventory();
	}
	
	/*
	 * this is help fuction to cancel all the athlete toggle buttons and reset athlete index number
	 */
	private void cancelAthleteToggle() {
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
	/*
	 * this is help fuction to cancel all the item toggle buttons and reset item index number
	 */
	private void cancelItemToggle() {
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

	/*
	 * set buttons on main screen
	 */
	private void setButton() {
		// close the main window and show market
		JButton marketButton = new JButton("Market");
		marketButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//////////////////////////////////////////////////////////////////////////////for test, autometically buy 4 athletes/////////////////////////////////////
				gameEnvironment.tradingProcess("buy", gameEnvironment.getMarket().getAthleteProduct() ,0);
				gameEnvironment.tradingProcess("buy", gameEnvironment.getMarket().getAthleteProduct() ,1);
				gameEnvironment.tradingProcess("buy", gameEnvironment.getMarket().getAthleteProduct() ,2);
				gameEnvironment.tradingProcess("buy", gameEnvironment.getMarket().getAthleteProduct() ,3);
				//////////////////////////////////////////////////////////////////////////////for test, autometically buy 4 athletes//////////////////////////////////////

				frmMainWindow.dispose();
				MarketGui openMarket = new MarketGui(gameEnvironment);
			}
		});
		marketButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		marketButton.setBounds(125, 895, 237, 78);
		frmMainWindow.getContentPane().add(marketButton);
		
		//close the main window and show stadium
		JButton stadiumButton = new JButton("Stadium");
		stadiumButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i=0; i<4;i++) {
					if (null == myRoster[i]) {
						noticeLabel.setText("You need at least 4 Athletes in Active slots");
						return;}}
				frmMainWindow.dispose();
				OpponentSelectingGui letsSelectOpponent = new OpponentSelectingGui(gameEnvironment);		
			}
		});
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
		
		//switch two selected athletes around and reset all toggle buttons of Athletes
		JButton switchButton = new JButton("Switch");
		switchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (myRoster[athleteSwitchingNum1] == null || myRoster[athleteSwitchingNum2] == null
						|| athleteSwitchingNum1 < 0 || athleteSwitchingNum2 < 0) {
					noticeLabel.setText("Select two athlete to switch!");}
				else {gameEnvironment.swap(athleteSwitchingNum1, athleteSwitchingNum2);}
				cancelAthleteToggle();
				refreshScreen();
			}});
		switchButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		switchButton.setBounds(881, 450, 117, 78);
		frmMainWindow.getContentPane().add(switchButton);
		
		//make use button to use item to one athlete
		JButton itemUseButton = new JButton("Use");
		itemUseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//check which athlete is selected
				if (athleteSwitchingNum1 >= 0 && athleteSwitchingNum2 < 0) {
					if (myRoster[athleteSwitchingNum1] == null || myInvertory[usingItemNum] == null) {
						noticeLabel.setText("You clicked the empty slot!"); 
						return;}
					gameEnvironment.useItem(athleteSwitchingNum1, usingItemNum);
					noticeLabel.setText("Used item! Check the difference!!");
				}
				else if (athleteSwitchingNum1 < 0 && athleteSwitchingNum2 >= 0){
					if (myRoster[athleteSwitchingNum2] == null || myInvertory[usingItemNum] == null) {
						noticeLabel.setText("You clicked the empty slot!"); 
						return;}
					gameEnvironment.useItem(athleteSwitchingNum2, usingItemNum);
					noticeLabel.setText("Used item! Check the difference!!");
				}
				else {
					noticeLabel.setText("Select One Item and Athlete for each!");
					return;
				}
				cancelAthleteToggle();
				cancelItemToggle();	
				usingItemNum = -1;
				refreshScreen();
			}
		});
		itemUseButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		itemUseButton.setBounds(984, 766, 117, 78);
		frmMainWindow.getContentPane().add(itemUseButton);
	}
	
	/*
	 * set the information panel for athlete and item on main screen
	 */
	private void setAthleteItemInfoPanel() {
		JPanel setAthleteInfoPanel = new JPanel();
		setAthleteInfoPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		setAthleteInfoPanel.setBounds(1212, 100, 300, 460);
		frmMainWindow.getContentPane().add(setAthleteInfoPanel);
		setAthleteInfoPanel.setLayout(null);
		
		JPanel setItemInfoPanel = new JPanel();
		setItemInfoPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		setItemInfoPanel.setBounds(1212, 624, 297, 220);
		frmMainWindow.getContentPane().add(setItemInfoPanel);
		setItemInfoPanel.setLayout(null);
		
		JLabel athleteInfoTitleLabel = new JLabel("<<Athelte Information>>");
		athleteInfoTitleLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		athleteInfoTitleLabel.setBounds(15, 20, 271, 20);
		setAthleteInfoPanel.add(athleteInfoTitleLabel);
		
		athleteDescriptionLabel = new JLabel("- Description -");
		athleteDescriptionLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		athleteDescriptionLabel.setBounds(22, 67, 266, 363);
		setAthleteInfoPanel.add(athleteDescriptionLabel);
	
		
		JLabel itemInfoTitleLabel = new JLabel("-Item Information-");
		itemInfoTitleLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		itemInfoTitleLabel.setBounds(44, 17, 247, 20);
		setItemInfoPanel.add(itemInfoTitleLabel);
		
		itemDescriptionLabel = new JLabel("");
		itemDescriptionLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		itemDescriptionLabel.setBounds(25, 101, 247, 90);
		setItemInfoPanel.add(itemDescriptionLabel);
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
	 * create panel to notify the player that one athlete has left. This is random occasion.
	 */
	private void athleteLeft() {
	    JPanel athleteLeft = new JPanel();
	    athleteLeft.add(new JLabel("<html>Oh Noooooo!!!!!!!!!!!!!!!!!<br/> All of sudden, one of your athlete ran away!!<br/> Check who left your team!  </html>"));
	    JOptionPane.showOptionDialog(null, athleteLeft, "Such a tragic!",
	        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
	        null, null);
 

	}
}
