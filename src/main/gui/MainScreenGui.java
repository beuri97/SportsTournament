package main.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
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

/**
 * class for Setup window when start the game
 * @author J Kim
 */
public class MainScreenGui implements UserInterface{

	private JFrame frmMainWindow;
	private JToggleButton[] athleteBttns = new JToggleButton[7];
	private JToggleButton[] itemBttns = new JToggleButton[10];
	private JLabel[] athleteLabel = new JLabel[7];
	private JLabel noticeLabel;
	private JLabel athleteDescriptionLabel;
	private JLabel itemDescriptionLabel;
	private JLabel moneyLabel;
	private JLabel weekNumLabel;
	
	private GameEnvironment gameEnvironment;
	private Athlete[] myRoster;
	private Item[] myInventory;
	private int currentWeek;

	//  Next three ints indicate the Athlete buttons and the item button are clicked
	//	when int is -1, button is not clicked
	//	when int is greater than 0(inclusive), it is clicked
	//	this number will be used as index to call or swap athletes and use an item. 
	private int athleteSwitchingNum1 = -1;
	private int athleteSwitchingNum2 = -1;
	private int usingItemNum = -1;
	
	
	private ImageIcon angelina = new ImageIcon(getClass().getResource("/Images/AngelinaF.jpg"));
	private ImageIcon dwayne = new ImageIcon(getClass().getResource("/Images/DwayneF.jpg"));;
	private ImageIcon prodo = new ImageIcon(getClass().getResource("/Images/ProdoF.jpg"));;
	private ImageIcon thorin = new ImageIcon(getClass().getResource("/Images/ThorinF.jpg"));;
	
	/**
	 * Create the application.
	 */
	public  MainScreenGui(GameEnvironment gameEnvironment) {
		this.gameEnvironment = gameEnvironment;
		this.myRoster = gameEnvironment.getTeam().getRoster();
		this.myInventory = gameEnvironment.getTeam().getInventory();
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
		weekNumLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		weekNumLabel.setBounds(632, 36, 141, 30);
		frmMainWindow.getContentPane().add(weekNumLabel);
		resetCurretWeek();
		
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
			setPhoto(athleteBttns[i], i);
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
	
		
		//make the labels for injured Athletes
		//it will show under the button
		for (int i = 0; i<myRoster.length; i++) {
			athleteLabel[i] = new JLabel(printingName(myRoster[i]));
			if (i < 4) {setAthletePanel.add(athleteLabel[i]);}
			else {setReservePanel.add(athleteLabel[i]);}
			}
		
		athleteLabel[0].setBounds(40, 189, 80, 25);
		athleteLabel[1].setBounds(214, 189, 80, 25);
		athleteLabel[2].setBounds(408, 189, 80, 25);
		athleteLabel[3].setBounds(574, 189, 80, 25);
		athleteLabel[4].setBounds(36, 189, 80, 25);
		athleteLabel[5].setBounds(235, 189, 80, 25);
		athleteLabel[6].setBounds(409, 189, 80, 25);
		
		checkInjured();
	}
	/*
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
		setItemPanel.add(itemBttns[i]);}

	itemBttns[0].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			selectingResetItemSlots(0);
			itemBttns[0].setSelected(true);}});
	itemBttns[1].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			selectingResetItemSlots(1);
			itemBttns[1].setSelected(true);}});
	itemBttns[2].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			selectingResetItemSlots(2);
			itemBttns[2].setSelected(true);}});
	itemBttns[3].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			selectingResetItemSlots(3);			
			itemBttns[3].setSelected(true);}});
	itemBttns[4].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			selectingResetItemSlots(4);
			itemBttns[4].setSelected(true);}});
	itemBttns[5].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			selectingResetItemSlots(5);
			itemBttns[5].setSelected(true);}});
	itemBttns[6].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			selectingResetItemSlots(6);
			itemBttns[6].setSelected(true);}});
	itemBttns[7].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			selectingResetItemSlots(7);
			itemBttns[7].setSelected(true);}});
	itemBttns[8].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			selectingResetItemSlots(8);
			itemBttns[8].setSelected(true);}});
	itemBttns[9].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			selectingResetItemSlots(9);
			itemBttns[9].setSelected(true);}});
	}
	

	private void setPhoto(JToggleButton button, int num) {

		String athleteName = printingName(myRoster[num]);
		
		if (athleteName.contains("Angelina")) {button.setIcon(angelina);}
		else if (athleteName.contains("Dwayne")) {button.setIcon(dwayne);}
		else if (athleteName.contains("Prodo")) {button.setIcon(prodo);}
		else if (athleteName.contains("Thorin")){button.setIcon(thorin);}
		else {button.setIcon(null);}
	}
	
	/*
	 * update number of week on main screen.
	 */
	private void resetCurretWeek() {
		currentWeek = gameEnvironment.getCurrentSeason();
		if (currentWeek == 1) {weekNumLabel.setText("1st week");}
		else if((currentWeek == 2)){weekNumLabel.setText("2nd week");}
		else {weekNumLabel.setText(gameEnvironment.getCurrentSeason() + "rd week");}
	}
	
	/*
	 * this is help function to swap two athletes when player click two athletes and refresh screen to show changes and cancel clicked toggle buttons
	 */
	private void swapAthleteSlots(int slotNum) {
		athleteSwitchingNum1 = athleteSwitchingNum2;
		athleteSwitchingNum2 = slotNum;
		athleteDescriptionLabel.setText(printing(myRoster[slotNum]));
		if (athleteSwitchingNum1 != -1 && athleteSwitchingNum2 != -1) {
			if (myRoster[athleteSwitchingNum1] == null || myRoster[athleteSwitchingNum2] == null) {
				noticeLabel.setText("Select two athlete to switch!");}
			else {gameEnvironment.swap(athleteSwitchingNum1, athleteSwitchingNum2);}
			cancelAthleteToggle();
			refreshWindow();
		}
			
	}
	/*
	 * this is help function to implement cancelItemToggle() method and assign slot number that player clicked
	 */
	private void selectingResetItemSlots(int slotNum) {
			cancelItemToggle();
			usingItemNum = slotNum;
			itemDescriptionLabel.setText(printing(myInventory[slotNum]));
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
	
	

	/*
	 * update screen with the latest information.
	 */
	private void refreshWindow() {
		moneyLabel.setText("$ " + gameEnvironment.getTeam().getMoney());
		myRoster = gameEnvironment.getTeam().getRoster();
		myInventory = gameEnvironment.getTeam().getInventory();
		resetCurretWeek();
		checkInjured();
		
		for (int i = 0; i<myRoster.length; i++) {
			athleteBttns[i].setText(printingName(myRoster[i]));
			setPhoto(athleteBttns[i], i);
			}
		
		for (int i = 0; i<myInventory.length; i++) {
			itemBttns[i].setText(printingName(myInventory[i]));
			}
	}
	
	/*
	 * this is help fuction to cancel all the athlete toggle buttons and reset athlete index number
	 */
	private void cancelAthleteToggle() {
		for (int i = 0; i<myRoster.length; i++) {
			athleteBttns[i].setSelected(false);}
		athleteSwitchingNum1 = -1;
		athleteSwitchingNum2 = -1;
	}
	/*
	 * this is help fuction to cancel all the item toggle buttons and reset item index number
	 */
	private void cancelItemToggle() {
		
		for (int i = 0; i<myInventory.length; i++) {
			itemBttns[i].setSelected(false);}
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
		JButton takeAByeButton = new JButton("Take a BYE");
		takeAByeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(gameEnvironment.isPlayed()) {
					checkingTakeABye();}
				 else {
					 checkingGameOver();
				 }
			}});
		takeAByeButton.setFont(new Font("Lucida Grande", Font.ITALIC, 20));
		takeAByeButton.setBounds(1033, 501, 149, 59);
		frmMainWindow.getContentPane().add(takeAByeButton);
		
		//make use button to use item to one athlete
		JButton itemUseButton = new JButton("Use");
		itemUseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//check which athlete is selected
				if (athleteSwitchingNum2 != -1){
					if (myRoster[athleteSwitchingNum2] == null || myInventory[usingItemNum] == null) {
						noticeLabel.setText("You clicked the empty slot!"); 
						return;}
					gameEnvironment.useItem(athleteSwitchingNum2, usingItemNum);
					athleteDescriptionLabel.setText(printing(myRoster[athleteSwitchingNum2]));
					itemDescriptionLabel.setText("Item is used! Check the difference!!");
				}
				else {
					noticeLabel.setText("Select One Item and Athlete for each!");
					return;
				}
				refreshWindow();
				cancelAthleteToggle();
				cancelItemToggle();	
				usingItemNum = -1;	
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
	
	/*
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
	/*
	 * close Main window ( it will be called from gameEnvironment)
	 */
	public void closeWindow() {
		frmMainWindow.dispose();
	}
	/*
	 * close Main window
	 */
	public void finishedWindow() {
		gameEnvironment.closeMainWindow(this);
	}
}
