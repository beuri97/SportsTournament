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
import main.gameObject.athletes.Athlete;
import main.gameObject.item.Item;
import main.gamesystem.Exception.InsufficientAthleteException;

import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

/**
 * class for Main window after setup
 * @author J Kim
 */
public class MainScreenGui implements UserInterface{
	/**
	 * game environment which has all of this game system
	 */
	private GameEnvironment gameEnvironment;
	/**
	 * frame for the main window
	 */
	private JFrame frmMainWindow;
	/**
	 * arrayList for JToggleButton contains all the athletes that the player has
	 */
	private JToggleButton[] athleteBttns = new JToggleButton[7];
	/**
	 * arrayList for JToggleButton contains all the items that the player has
	 */
	private JToggleButton[] itemBttns = new JToggleButton[10];
	/**
	 * arrayList for JLabel contains player's athlete Labels
	 */
	private JLabel[] athleteLabel = new JLabel[7];
	/**
	 * label to show notice
	 */
	private JLabel noticeLabel;
	/**
	 * label to show the description of athlete
	 */
	private JLabel athleteDescriptionLabel;
	/**
	 * label to show the description of item
	 */
	private JLabel itemDescriptionLabel;
	/**
	 * label to show money that the player currently has
	 */
	private JLabel moneyLabel;
	/**
	 * label to show current week
	 */
	private JLabel weekNumLabel;
	/**
	 * arrayList contains athletes that the player has
	 */
	private Athlete[] myRoster;
	/**
	 * arrayList contains items that the player has
	 */
	private Item[] myInventory;
	/**
	 * checkbox to activate swap function
	 */
	private JCheckBox swapOn;

	/**
	 *  Next three ints indicate the Athlete buttons and the item button are clicked
	 *  when int is -1, button is not clicked
	 *  when int is greater than 0(inclusive), it is clicked
	 *  this number will be used as index number to call or swap athletes and use an item. 
	 */
	private int athleteSwitchingNum1 = -1;
	private int athleteSwitchingNum2 = -1;
	private int usingItemNum = -1;
	
	/**
	 * boolean value that shows if there was random athlete leave event
	 */
	private boolean isRandomLeave;
	/**
	 * boolean value that shows if there was random athlete join event
	 */
	private boolean isRandomJoin;
	/**
	 * boolean value that shows if there was random athlete upgrade event
	 */
	private boolean isRandomUpgrade;	
	
	/**
	 * MainScreen constructor to create main window
	 * @param gameEnvironment game environment which is core of this program
	 */
	public  MainScreenGui(GameEnvironment gameEnvironment) {
		this.gameEnvironment = gameEnvironment;
		this.myRoster = gameEnvironment.getTeam().getRoster();
		this.myInventory = gameEnvironment.getTeam().getInventory();
		setup(gameEnvironment);
	}

	/**
	 * setup the main window
	 * @param gameEnvironment game environment which is core of this program
	 */
	public void setup(GameEnvironment gameEnvironment) {
		
		setFrameLabels();
		setAthletePanel();
		setItemPanel();
		setAthleteItemInfoPanel();
		setButton();
	}

	/**
	 * set the main frame and all the labels on main window
	 */
	private void setFrameLabels() {
		
		frmMainWindow = new JFrame();
		frmMainWindow.setSize(1650,1080);
		frmMainWindow.getContentPane().setLayout(null);
		frmMainWindow.setLocation((1925 - frmMainWindow.getWidth()) / 2, (1080 - frmMainWindow.getHeight()) / 2);
		frmMainWindow.setVisible(true);
		
		JLabel myTeamLabel = new JLabel("My team name :");
		myTeamLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		myTeamLabel.setBounds(48, 36, 218, 30);
		frmMainWindow.getContentPane().add(myTeamLabel);
		
		JLabel diffLevelLabel = new JLabel("Difficulty Level : ");
		diffLevelLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		diffLevelLabel.setBounds(955, 36, 202, 30);
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
		inventoryLabel.setBounds(180, 624, 141, 59);
		frmMainWindow.getContentPane().add(inventoryLabel);
	
		JLabel teamNameLabel = new JLabel("teamName");
		teamNameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		teamNameLabel.setBounds(248, 37, 256, 30);
		frmMainWindow.getContentPane().add(teamNameLabel);
		teamNameLabel.setText(gameEnvironment.getTeam().getName());
		
		weekNumLabel = new JLabel("NUM HERE");
		weekNumLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		weekNumLabel.setFont(new Font("Lucida Grande", Font.BOLD, 29));
		weekNumLabel.setBounds(519, 14, 202, 50);
		frmMainWindow.getContentPane().add(weekNumLabel);
		
		//set the current week 
		int currentWeek = gameEnvironment.getCurrentSeason();
		if (currentWeek == 1) {weekNumLabel.setText("1st week");}
		else if((currentWeek == 2)){weekNumLabel.setText("2nd week");}
		else {weekNumLabel.setText(gameEnvironment.getCurrentSeason() + "rd week");}
			
		JLabel totalweekLabel = new JLabel(" / Total "+ gameEnvironment.getTotalSeason() + "weeks");
		totalweekLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		totalweekLabel.setBounds(733, 36, 243, 30);
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
		noticeLabel.setBounds(300, 616, 594, 30);
		frmMainWindow.getContentPane().add(noticeLabel);
	}

	/**
	 * Panel for Athlete lists on main screen
	 */
	private void setAthletePanel() {
		
		//Create the panel for Active Athletes
		JPanel setAthletePanel = new JPanel();
		setAthletePanel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		setAthletePanel.setBounds(300, 100, 699, 240);
		frmMainWindow.getContentPane().add(setAthletePanel);
		setAthletePanel.setLayout(null);
		
		//Create the panel for Reserves Athletes
		JPanel setReservePanel = new JPanel();
		setReservePanel.setLayout(null);
		setReservePanel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		setReservePanel.setBounds(300, 370, 535, 240);
		frmMainWindow.getContentPane().add(setReservePanel);

		//Create toggle buttons for All the athletes that the player owns.
		
		for (int i = 0; i < myRoster.length; i++) {
			athleteBttns[i] = new JToggleButton(printingName(myRoster[i]));
			athleteBttns[i].setIcon(printingFacePhoto(myRoster[i]));
			if(myRoster[i]==null) {athleteBttns[i].setEnabled(false);}
			if (i < 4) {setAthletePanel.add(athleteBttns[i]);}
			else {setReservePanel.add(athleteBttns[i]);}
			}
		athleteBttns[0].setBounds(20, 20, 150, 150);
		athleteBttns[1].setBounds(190, 20, 150, 150);
		athleteBttns[2].setBounds(360, 20, 150, 150);
		athleteBttns[3].setBounds(530, 20, 150, 150);
		athleteBttns[4].setBounds(20, 20, 150, 150);
		athleteBttns[5].setBounds(190, 20, 150, 150);
		athleteBttns[6].setBounds(360, 20, 150, 150);
		
		
		
		athleteBttns[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {swapAthleteSlots(0);}});
		athleteBttns[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {swapAthleteSlots(1);}});
		athleteBttns[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {swapAthleteSlots(2);}});
		athleteBttns[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {swapAthleteSlots(3);}});	
		athleteBttns[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {swapAthleteSlots(4);}});	
		athleteBttns[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {swapAthleteSlots(5);}});	
		athleteBttns[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {swapAthleteSlots(6);}});	
		
		//when clicking swapOn button, it refresh the buttons clicked.
		swapOn = new JCheckBox("Swap ON");
		swapOn.setBounds(847, 370, 128, 23);
		frmMainWindow.getContentPane().add(swapOn);
		swapOn.addActionListener(event -> {
			refreshWindow();
			athleteSwitchingNum1 = -1;
			athleteSwitchingNum2 = -1;
		});
		/**
		 * make the labels for Athletes' name
		 * if the athlete is injured, show it in read.
		 * 
		*/
		for (int i = 0; i<myRoster.length; i++) {
			athleteLabel[i] = new JLabel(printingName(myRoster[i]));
			if (i < 4) {setAthletePanel.add(athleteLabel[i]);}
			else {setReservePanel.add(athleteLabel[i]);}}
		
		athleteLabel[0].setBounds(40, 189, 80, 25);
		athleteLabel[1].setBounds(214, 189, 80, 25);
		athleteLabel[2].setBounds(408, 189, 80, 25);
		athleteLabel[3].setBounds(574, 189, 80, 25);
		athleteLabel[4].setBounds(36, 189, 80, 25);
		athleteLabel[5].setBounds(235, 189, 80, 25);
		athleteLabel[6].setBounds(409, 189, 80, 25);
		checkInjured();
	
	}
	/**
	 * Create the panel for item in player's inventory
	 */
	private void setItemPanel(){
		JPanel setItemPanel = new JPanel();
		setItemPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		setItemPanel.setBounds(180, 710, 784, 138);
		frmMainWindow.getContentPane().add(setItemPanel);
		setItemPanel.setLayout(new GridLayout(2, 7, 0, 0));
		
		//Create toggle buttons for All the items that the player owns.
		
		for (int i = 0; i < myInventory.length; i++) {
			itemBttns[i] = new JToggleButton(printingName(myInventory[i]));
			if(myInventory[i]==null) {itemBttns[i].setEnabled(false);}
			setItemPanel.add(itemBttns[i]);}
	
		itemBttns[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectingResetItemSlots(0);}});
		itemBttns[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectingResetItemSlots(1);}});
		itemBttns[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectingResetItemSlots(2);}});
		itemBttns[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectingResetItemSlots(3);}});
		itemBttns[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectingResetItemSlots(4);}});
		itemBttns[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectingResetItemSlots(5);}});
		itemBttns[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectingResetItemSlots(6);}});
		itemBttns[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectingResetItemSlots(7);}});
		itemBttns[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectingResetItemSlots(8);}});
		itemBttns[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectingResetItemSlots(9);}});
		}

	/**
	 * when the swapOn switch is ON, swap two athletes when player click two athletes and refresh screen to show changes and cancel clicked toggle buttons
	 * if swapOn switch is off, just show the clicked athlete's information
	 * @param slotNum type of integer which indicate slot number of ArrayList
	 */
	private void swapAthleteSlots(int slotNum) {
		if (swapOn.isSelected()) {
			athleteSwitchingNum1 = athleteSwitchingNum2;
			athleteSwitchingNum2 = slotNum;
			athleteLabel[slotNum].setForeground(new Color(0, 0, 255));
			athleteDescriptionLabel.setText(printing(myRoster[slotNum]));
			if (athleteSwitchingNum1 != -1 && athleteSwitchingNum2 != -1) {
				if (myRoster[athleteSwitchingNum1] == null || myRoster[athleteSwitchingNum2] == null) {
					noticeLabel.setText("Select two athlete to switch!");}
				else {
					gameEnvironment.swap(athleteSwitchingNum1, athleteSwitchingNum2);
					cancelAthleteToggle();
					refreshWindow();
				}}}
		else {
			athleteDescriptionLabel.setText(printing(myRoster[slotNum]));
			cancelAthleteToggle();
			refreshWindow();
			athleteBttns[slotNum].setSelected(true);
			athleteLabel[slotNum].setForeground(new Color(0, 0, 255));
			athleteSwitchingNum2 = slotNum;
		}
	
	}
	/**
	 * this is help function to implement cancelItemToggle() method and assign slot number that player clicked
	 * @param slotNum the type of int that indicate slot number of arrayList
	 */
	private void selectingResetItemSlots(int slotNum) {
			cancelItemToggle();
			usingItemNum = slotNum;
			itemDescriptionLabel.setText(printing(myInventory[slotNum]));
			itemBttns[slotNum].setSelected(true);
	}
	
	/**
	 * check if the athlete is injured, if it is, show with red text
	 */
	private void checkInjured() {
		for (int i = 0; i<myRoster.length; i++) {
			if (myRoster[i] != null && myRoster[i].isInjured()) {
				athleteLabel[i].setText("Injured");
				athleteLabel[i].setForeground(new Color(255, 0, 0));
			}
			else{athleteLabel[i].setText(printingName(myRoster[i]));
				athleteLabel[i].setForeground(new Color(0, 0, 0));
			}}}
	
	

	/**
	 * update screen with the latest information.
	 * there is a chance to have random event
	 */
	private void refreshWindow() {
		moneyLabel.setText("$ " + gameEnvironment.getTeam().getMoney());
		myRoster = gameEnvironment.getTeam().getRoster();
		myInventory = gameEnvironment.getTeam().getInventory();
		checkInjured();
		//refresh my roster buttons
		for (int i = 0; i<myRoster.length; i++) {
			athleteBttns[i].setText(printingName(myRoster[i]));
			athleteBttns[i].setIcon(printingFacePhoto(myRoster[i]));
			if (myRoster[i]==null) {athleteBttns[i].setEnabled(false);}
			else {athleteBttns[i].setEnabled(true);}}
		//refresh my invetory buttons
		for (int i = 0; i<myInventory.length; i++) {
			itemBttns[i].setText(printingName(myInventory[i]));
			if (myInventory[i]==null) {itemBttns[i].setEnabled(false);}
			else {itemBttns[i].setEnabled(true);}}
		isRandomEvent();
	}
	
	/**
	 * this is help fuction to cancel all the athlete toggle buttons and reset athlete index number
	 */
	private void cancelAthleteToggle() {
		for (int i = 0; i<myRoster.length; i++) {
			athleteBttns[i].setSelected(false);}
		athleteSwitchingNum1 = -1;
		athleteSwitchingNum2 = -1;
	}
	/**
	 * this is help fuction to cancel all the item toggle buttons and reset item index number
	 */
	private void cancelItemToggle() {
		
		for (int i = 0; i<myInventory.length; i++) {
			itemBttns[i].setSelected(false);}
		usingItemNum = -1;
	}

	/**
	 * set buttons on main screen
	 */
	private void setButton() {
		// close the main window and show market
		JButton marketButton = new JButton("Market");
		marketButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				gameEnvironment.openMarketWindow();;
			}
		});
		marketButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		marketButton.setBounds(125, 895, 237, 78);
		frmMainWindow.getContentPane().add(marketButton);
		
		//close the main window and show stadium
		JButton stadiumButton = new JButton("Stadium");
		stadiumButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					gameEnvironment.isPlayable();
					finishedWindow();
					gameEnvironment.openSelectingOpponent();}
				catch(InsufficientAthleteException a) {noticeLabel.setText(a.getMessage());	}}
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
		
		//button to finish this week
		//show pop-up window to ask if the player really wants to finish this week
		//there is a chance to have random events
		JButton takeAByeButton = new JButton("Take a BYE");
		takeAByeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isRandomEvent()) {}
				else {
					if(gameEnvironment.isPlayed()) {
						checkingTakeABye();}
					else {
						checkingGameOver();
				 }}
			}});
		
		takeAByeButton.setFont(new Font("Lucida Grande", Font.ITALIC, 20));
		takeAByeButton.setBounds(1033, 501, 149, 59);
		frmMainWindow.getContentPane().add(takeAByeButton);
		
		//make use button to use item to one athlete
		JButton itemUseButton = new JButton("Use");
		itemUseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//check swap function is on, item will be used onto last clicked athlete
				if (athleteSwitchingNum2 != -1) {
					gameEnvironment.useItem(athleteSwitchingNum2, usingItemNum);
					athleteDescriptionLabel.setText(printing(myRoster[athleteSwitchingNum2]));
					itemDescriptionLabel.setText("Item is used! Check the difference!!");}
				else {noticeLabel.setText("Please Click one athlete and one item for each ");}
				refreshWindow();
				cancelAthleteToggle();
				cancelItemToggle();	
			}
		});
		itemUseButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		itemUseButton.setBounds(984, 766, 117, 78);
		frmMainWindow.getContentPane().add(itemUseButton);
		
		
		
		//check if the season it over the total season,
		//show the button to end the game
		if (gameEnvironment.getCurrentSeason() == gameEnvironment.getTotalSeason()) {
			takeAByeButton.setEnabled(false);
			weekNumLabel.setText("Final week");
			JButton endGameBttn = new JButton("End Game");
			endGameBttn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					finishedWindow();
	    			gameEnvironment.openGameOverWindow();
					}});
			
			endGameBttn.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 49));
			endGameBttn.setBounds(1141, 872, 359, 129);
			frmMainWindow.getContentPane().add(endGameBttn);
			
		}
		
	}
	
	/**
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

	/**
	 * create an option panel to ask whether the player really wants to move to next week.
	 * if the player can't do more game or weeks are finished or just wants to quit, show game over window
	 */
	private void checkingTakeABye() {
	    	Object[] options1 = { "Start Next week!", "Not yet!" };
	    	JPanel panel = new JPanel(); 
	    	panel.add(new JLabel("Are you sure you want to finish this week???"));
	    	int result1 = JOptionPane.showOptionDialog(null, panel, "Stay this week? or Start next week?",
	    	        JOptionPane.DEFAULT_OPTION, JOptionPane.YES_NO_OPTION, null,
	    	        options1, null);
	        	if (result1 == JOptionPane.YES_NO_OPTION) {	
	    			finishedWindow();
	    			gameEnvironment.openImprovingWindow();
	    	}
	}
	/**
	 *check if the player really wants to quit this game without finishing.
	 */
	private void checkingGameOver() {
		Object[] options2 = { "Finish this game", "Try bit more!" };
		JPanel panel2 = new JPanel();
		panel2.add(new JLabel("<html>You didn't have a match for this week,<br/> Are you sure you really want to finish this game???</html>"));
		int result2 = JOptionPane.showOptionDialog(null, panel2, "Can you not play more??",
				JOptionPane.DEFAULT_OPTION, JOptionPane.YES_NO_OPTION, null,
				options2, null);
		if (result2 == JOptionPane.YES_NO_OPTION) {
			finishedWindow();
			gameEnvironment.openGameOverWindow();
		}
	}

	/**
	 * check if the randome event has occured.
	 * if it hasn't occured, make athlete randomly leave from the player's team.
	 * @return true if event is occurred
	 */
	private boolean isRandomEvent() {
		boolean happened =false;
		if(!isRandomLeave && gameEnvironment.randomLeaveEvent() != null) {	
			athleteRandomLeft();
			isRandomLeave = true;
			refreshWindow();
		}
		if(!isRandomJoin && gameEnvironment.randomNewAthlete()) {
			athleteRandomJoin();
			isRandomJoin = true;
			refreshWindow();
		}
		if(!isRandomUpgrade && gameEnvironment.randomUpgradeEvent() != null) {
			athleteRandomUpgrade();
			isRandomUpgrade = true;
			refreshWindow();
		}
		
		return happened;
	}
	
	/**
	 * create an option panel to ask whether the player really wants to quit the game or not
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

	
	/**
	 * create panel to notify the player that some athlete has left. This is random occasion.
	 */
	private void athleteRandomLeft() {
	    JPanel athleteLeft = new JPanel();
	    athleteLeft.add(new JLabel("<html>Oh Noooooo!!!!!!!!!!!!!!!!!<br/> All of sudden, some athlete(s) ran away!!<br/> Check who left your team!  </html>"));
	    JOptionPane.showOptionDialog(null, athleteLeft, "Such a tragic!",
	        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
	        null, null);
	}
	/**
	 * create panel to notify the player that some athlete joined the team. This is random occasion.
	 */
	private void athleteRandomJoin() {
	    JPanel athleteJoin = new JPanel();
	    athleteJoin.add(new JLabel("<html>!!!!!!!!!!!!!!WOW!!!!!!!!!!!!!!<br/> Congratulation!!, one athlete joined your team!!<br/> Check who joined and look after!  </html>"));
	    JOptionPane.showOptionDialog(null, athleteJoin, "Good News!!",
	        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
	        null, null);
	}

	/**
	 * create panel to notify the player that some athlete has left. This is random occasion.
	 */
	private void athleteRandomUpgrade() {
	    JPanel athleteUpgrade = new JPanel();
	    athleteUpgrade.add(new JLabel("<html>Good news!!!<br/> Some athlete(s)'s stats are improved!!<br/> Check who got improved!!!  </html>"));
	    JOptionPane.showOptionDialog(null, athleteUpgrade, "Such a tragic!",
	        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
	        null, null);
	}

	/**
	 * close Main window ( it will be called from gameEnvironment)
	 */
	public void closeWindow() {
		frmMainWindow.dispose();
	}

	/**
	 * close Main window
	 */
	public void finishedWindow() {
		gameEnvironment.closeMainWindow(this);
	}
}
