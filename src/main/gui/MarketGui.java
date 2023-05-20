package main.gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import main.GameEnvironment;
import main.UserInterface;
import main.gameObject.Product;
import main.gameObject.athletes.Athlete;
import main.gameObject.item.Item;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import main.gamesystem.Exception.EmptySlotException;
import main.gamesystem.Exception.LackOfMoneyException;
import main.gamesystem.Exception.NoSpaceException;

import javax.swing.*;

public class MarketGui implements UserInterface{

	private JFrame frmMarket;
	private JToggleButton[] buyAthleteBttns = new JToggleButton[6];
	private JToggleButton[] buyItemBttns = new JToggleButton[8];
	private JToggleButton[] myRosterBttns = new JToggleButton[7];
	private JToggleButton[] myInventoryBttns = new JToggleButton[10];
	
	private GameEnvironment gameEnvironment;
	private Product[] athleteList;
	private Product[] itemList;
	private Athlete[] myRoster;
	private Item[] myInventory;
	
	

	
	// next four ints indicate Athlete buttons and item button are clicked, 
		//	when int is -1, button is not clicked
		//	when int is greater than 0(inclusive), it is clicked
		//	this number will be used as index to call athletes and item from the lists. 
	int athleteBuyNum = -1;
	int athleteSellNum = -1;
	int itemBuyNum = -1;
	int itemSellNum = -1;

	private JLabel athletePhoto;
	private JLabel warningLabel;
	private JLabel athleteDiscriptionLabel;
	private JLabel itemDiscriptionLabel;
	private JLabel moneyLabel;
	private JLabel sellDescriptionLabel;
	
	private ImageIcon angelina = new ImageIcon(getClass().getResource("/Images/Angelina.jpg"));
	private ImageIcon dwayne = new ImageIcon(getClass().getResource("/Images/Dwayne.jpg"));;
	private ImageIcon prodo = new ImageIcon(getClass().getResource("/Images/Prodo.jpg"));;
	private ImageIcon thorin = new ImageIcon(getClass().getResource("/Images/Thorin.jpg"));;
	
	
	/**
	 * Create the application.
	 */
	public MarketGui(GameEnvironment gameEnvironment) {
		this.gameEnvironment = gameEnvironment;
		this.athleteList = gameEnvironment.getMarket().getAthleteProduct();
		this.itemList = gameEnvironment.getMarket().getItemProduct();
		this.myRoster = gameEnvironment.getTeam().getRoster();
		this.myInventory = gameEnvironment.getTeam().getInventory();
		setup(gameEnvironment);
	}
	
	public void setup(GameEnvironment gameEnvironment) {
		setFrameLabel();
		setBuyAthletePanel();
		setBuyItemsPanel();
		setAthleteItemInfoPanel();
		setSellAthleteItemPanel();
		setButton();
	}
	
	private void setPhoto(int num) {

		String athleteName = printingName(athleteList[num]);
		
		if (athleteName.contains("Angelina")) {athletePhoto.setIcon(angelina);}
		else if (athleteName.contains("Dwayne")) {athletePhoto.setIcon(dwayne);}
		else if (athleteName.contains("Prodo")) {athletePhoto.setIcon(prodo);}
		else if (athleteName.contains("Thorin")){athletePhoto.setIcon(thorin);}
		else {athletePhoto.setIcon(null);}
	}
	
	
	/*
	 * set the frame with labels
	 */
	private void setFrameLabel() {
		frmMarket = new JFrame();
		frmMarket.setSize(1650,1080);
		frmMarket.getContentPane().setLayout(null);
		frmMarket.setLocation((1925 - frmMarket.getWidth()) / 2, (1080 - frmMarket.getHeight()) / 2);
		frmMarket.setVisible(true);
		
		JLabel myTeamLabel = new JLabel("My Team");
		myTeamLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 26));
		myTeamLabel.setBounds(124, 763, 180, 36);
		frmMarket.getContentPane().add(myTeamLabel);
		
		JLabel myInventoryLabel = new JLabel("My Inventory");
		myInventoryLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 26));
		myInventoryLabel.setBounds(527, 763, 227, 36);
		frmMarket.getContentPane().add(myInventoryLabel);
		
		moneyLabel = new JLabel("$Money");
		moneyLabel.setFont(new Font("Dialog", Font.BOLD, 23));
		moneyLabel.setBounds(1480, 45, 145, 49);
		frmMarket.getContentPane().add(moneyLabel);
		moneyLabel.setText("$ " + gameEnvironment.getTeam().getMoney());
		
		
		warningLabel = new JLabel("");
		warningLabel.setHorizontalAlignment(SwingConstants.CENTER);
		warningLabel.setBounds(568, 682, 425, 20);
		warningLabel.setForeground(Color.RED);
		frmMarket.getContentPane().add(warningLabel);
		
		athletePhoto = new JLabel("");
		athletePhoto.setHorizontalAlignment(SwingConstants.CENTER);
		athletePhoto.setBounds(706, 135, 287, 460);
		frmMarket.getContentPane().add(athletePhoto);

	}
	/*
	 * set the panel to show available athletes in market
	 */
	private void setBuyAthletePanel() {
		
		JPanel setBuyAthletePanel = new JPanel();
		setBuyAthletePanel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		setBuyAthletePanel.setBounds(63, 75, 375, 662);
		frmMarket.getContentPane().add(setBuyAthletePanel);
		setBuyAthletePanel.setLayout(null);
		
		JLabel aThletePanelTitle = new JLabel("<<Available Athletes>>");
		aThletePanelTitle.setFont(new Font("Dialog", Font.BOLD, 21));
		aThletePanelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		aThletePanelTitle.setBounds(38, 22, 311, 45);
		setBuyAthletePanel.add(aThletePanelTitle);
		
		
		
		for (int i = 0; i < athleteList.length; i++) {
			buyAthleteBttns[i] = new JToggleButton(printingName(athleteList[i]));
			setBuyAthletePanel.add(buyAthleteBttns[i]);}

		buyAthleteBttns[0].setBounds(28, 79, 150, 150);
		buyAthleteBttns[1].setBounds(198, 79, 150, 150);
		buyAthleteBttns[2].setBounds(28, 282, 150, 150);
		buyAthleteBttns[3].setBounds(198, 282, 150, 150);
		buyAthleteBttns[4].setBounds(28, 472, 150, 150);
		buyAthleteBttns[5].setBounds(198, 472, 150, 150);
		
		buyAthleteBttns[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buyAthlete(0);}});	
		buyAthleteBttns[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buyAthlete(1);}});
		buyAthleteBttns[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buyAthlete(2);}});
		buyAthleteBttns[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buyAthlete(3);}});
		buyAthleteBttns[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buyAthlete(4);}});
		buyAthleteBttns[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buyAthlete(5);}});
		
	}
	/*
	 * set the panel to show available items in market
	 */
	private void setBuyItemsPanel() {

		JPanel setBuyItemsPanel = new JPanel();
		setBuyItemsPanel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		setBuyItemsPanel.setBounds(1028, 135, 308, 501);
		frmMarket.getContentPane().add(setBuyItemsPanel);
		setBuyItemsPanel.setLayout(null);
		
		JLabel availableItemLabel = new JLabel("<<Available Items>>");
		availableItemLabel.setFont(new Font("Dialog", Font.BOLD, 21));
		availableItemLabel.setHorizontalAlignment(SwingConstants.CENTER);
		availableItemLabel.setBounds(15, 12, 281, 45);
		setBuyItemsPanel.add(availableItemLabel);
		
		
		for (int i = 0; i < itemList.length; i++) {
			buyItemBttns[i] = new JToggleButton(printingName(itemList[i]));
			setBuyItemsPanel.add(buyItemBttns[i]);
			buyItemBttns[i].setFont(new Font("Dialog", Font.BOLD, 14));
		}
		
		buyItemBttns[0].setBounds(49, 69, 200, 40);
		buyItemBttns[1].setBounds(49, 121, 200, 40);
		buyItemBttns[2].setBounds(49, 173, 200, 40);
		buyItemBttns[3].setBounds(49, 225, 200, 40);
		buyItemBttns[4].setBounds(49, 281, 200, 40);
		buyItemBttns[5].setBounds(49, 336, 200, 40);
		buyItemBttns[6].setBounds(49, 388, 200, 40);
		buyItemBttns[7].setBounds(49, 440, 200, 40);
		
		buyItemBttns[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buyItem(0);}});
		buyItemBttns[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buyItem(1);}});
		buyItemBttns[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buyItem(2);}});
		buyItemBttns[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buyItem(3);}});
		buyItemBttns[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buyItem(4);}});
		buyItemBttns[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buyItem(5);}});
		buyItemBttns[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buyItem(6);}});
		buyItemBttns[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {buyItem(7);}});
		}
	
	/*
	 * cancel all toggle buttons for buying athlete
	 */
	private void cancelBuyAhtleteToggle() {
		for (int i = 0; i < athleteList.length; i++) {buyAthleteBttns[i].setSelected(false);}
		warningLabel.setText(null);
	}
	/*
	 * cancel all toggle buttons for buying item
	 */
	private void cancelBuyItemToggle() {
		for (int i = 0; i < itemList.length; i++) {buyItemBttns[i].setSelected(false);}
		warningLabel.setText(null);
	}
	/*
	 * cancel all toggle buttons for selling athletes and items
	 */
	private void cancelSellAthleteItemToggle() {
		for (int i = 0; i<myRoster.length; i++) {myRosterBttns[i].setSelected(false);}
		for (int i = 0; i<myInventoryBttns.length; i++) {myInventoryBttns[i].setSelected(false);}	
		warningLabel.setText(null);
	}
	/* 
	 * function to help buying athletes
	 * assign the athlete slot number and cancel all the toggle buttons clicked
	 */
	private void buyAthlete(int slotNum) {
		cancelBuyAhtleteToggle();
		setPhoto(slotNum);
		athleteBuyNum = slotNum;
		athleteDiscriptionLabel.setText(printing(athleteList[slotNum]));
		buyAthleteBttns[slotNum].setSelected(true);
	}
	/* 
	 * function to help buying items
	 * assign the athlete slot number and cancel all the toggle buttons clicked
	 */
	private void buyItem(int slotNum) {
		cancelBuyItemToggle();
		itemBuyNum = slotNum;
		itemDiscriptionLabel.setText(printing(itemList[slotNum]));
		buyItemBttns[slotNum].setSelected(true);
	}
	/*
	 * Sell button is clicked, cancel all the other sell buttons,
	 * and assign the index number of athlete list
	 */
	private void sellAthlete(int slotNum) {
			cancelSellAthleteItemToggle();
			athleteSellNum = slotNum;
			itemSellNum = -1;
			sellDescriptionLabel.setText(printing(myRoster[slotNum]));		
			myRosterBttns[slotNum].setSelected(true);
	}
	/*
	 * Sell button is clicked, cancel all the other sell buttons,
	 * and assign the index number of item list
	 */
	private void sellItem(int slotNum) {
			cancelSellAthleteItemToggle();
			itemSellNum = slotNum;
			athleteSellNum = -1;
			sellDescriptionLabel.setText(printing(myInventory[slotNum]));
			myInventoryBttns[slotNum].setSelected(true);
	}
	/*
	 * update screen with the latest information.
	 */
	private void refreshScreen() {
		moneyLabel.setText("$ " + gameEnvironment.getTeam().getMoney());
		athleteList = gameEnvironment.getMarket().getAthleteProduct();
		itemList = gameEnvironment.getMarket().getItemProduct();
		myInventory = gameEnvironment.getTeam().getInventory();
		myRoster = gameEnvironment.getTeam().getRoster();
	
		for (int i = 0; i < athleteList.length; i++) {buyAthleteBttns[i].setText(printingName(athleteList[i]));;}
		for (int i = 0; i < itemList.length; i++) {buyItemBttns[i].setText(printingName(itemList[i]));}
		for (int i = 0; i<myRoster.length; i++) {myRosterBttns[i].setText(printingName(myRoster[i]));}
		for (int i = 0; i<myInventoryBttns.length; i++) {myInventoryBttns[i].setText(printingName(myInventory[i]));}	
	}
	/*
	 * show the current athletes and items that the player has
	 */
	private void setSellAthleteItemPanel() {
		
		JPanel setSellAthletePanel = new JPanel();
		setSellAthletePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		setSellAthletePanel.setBounds(124, 811, 350, 152);
		frmMarket.getContentPane().add(setSellAthletePanel);
		setSellAthletePanel.setLayout(new GridLayout(2, 4, 0, 0));
		
		JPanel setSellItemPanel = new JPanel();
		setSellItemPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		setSellItemPanel.setBounds(505, 811, 654, 152);
		frmMarket.getContentPane().add(setSellItemPanel);
		setSellItemPanel.setLayout(new GridLayout(2, 5, 0, 0));
			
		
		//set sell athlete buttons
		for (int i = 0; i<myRoster.length; i++) {
			myRosterBttns[i] = new JToggleButton(printingName(myRoster[i]));
			setSellAthletePanel.add(myRosterBttns[i]);}
		
		myRosterBttns[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {sellAthlete(0);}});
		myRosterBttns[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {sellAthlete(1);}});
		myRosterBttns[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {sellAthlete(2);}});
		myRosterBttns[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {sellAthlete(3);}});
		myRosterBttns[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {sellAthlete(4);}});
		myRosterBttns[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {sellAthlete(5);}});
		myRosterBttns[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {sellAthlete(6);}});
		
		
		//set the sell item buttons which are from my Inventory
		
		for (int i = 0; i < myInventory.length; i++) {
			myInventoryBttns[i] = new JToggleButton(printingName(myInventory[i]));
			setSellItemPanel.add(myInventoryBttns[i]);
			myInventoryBttns[i].setFont(new Font("Dialog", Font.BOLD, 10));
			}
		
		myInventoryBttns[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {sellItem(0);}});
		myInventoryBttns[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {sellItem(1);}});
		myInventoryBttns[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {sellItem(2);}});
		myInventoryBttns[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {sellItem(3);}});
		myInventoryBttns[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {sellItem(4);}});
		myInventoryBttns[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {sellItem(5);}});
		myInventoryBttns[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {sellItem(6);}});
		myInventoryBttns[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {sellItem(7);}});
		myInventoryBttns[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {sellItem(8);}});
		myInventoryBttns[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {sellItem(9);}});
	}
	/*
	 * set all the buttons on window, but not in the panel.
	 */
	private void setButton() {
		// button to recruit the clicked athlete
		JButton recruitButton = new JButton("RECRUIT");
		recruitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (athleteBuyNum == -1) {athleteDiscriptionLabel.setText("Choose Athlete!");return;}
				try {
					gameEnvironment.tradingProcess("buy", athleteList ,athleteBuyNum);
					athleteBuyNum = -1;
					cancelBuyAhtleteToggle();
					refreshScreen();
					athletePhoto.setIcon(null);
					athleteDiscriptionLabel.setText("Recruited!!");
				}
				catch(EmptySlotException a){warningLabel.setText(a.getMessage());}		
				catch(NoSpaceException a) {warningLabel.setText(a.getMessage());}
				catch(LackOfMoneyException a) {warningLabel.setText(a.getMessage());}}
		});
		recruitButton.setFont(new Font("Lucida Grande", Font.BOLD, 23));
		recruitButton.setBounds(705, 607, 287, 63);
		frmMarket.getContentPane().add(recruitButton);
		
		// button to purchase the product that the player clicked
		JButton purchaseButton = new JButton("PURCHASE");
		purchaseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (itemBuyNum == -1) {athleteDiscriptionLabel.setText("Choose an item!");return;}
				try {
					gameEnvironment.tradingProcess("buy", itemList ,itemBuyNum);
					itemBuyNum = -1;
					cancelBuyItemToggle();
					refreshScreen();
					itemDiscriptionLabel.setText("Purchased!!");
				}
				catch(EmptySlotException a) {warningLabel.setText(a.getMessage());}
				catch(NoSpaceException a) {warningLabel.setText(a.getMessage());}
				catch(LackOfMoneyException a) {warningLabel.setText(a.getMessage());}}});
		
		purchaseButton.setFont(new Font("Lucida Grande", Font.BOLD, 23));
		purchaseButton.setBounds(1373, 611, 180, 55);
		frmMarket.getContentPane().add(purchaseButton);
		
		// button to sell the product that the player clicked
		JButton sellButton = new JButton("SELL");
		sellButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (athleteSellNum != -1){
					try {
						gameEnvironment.tradingProcess("sell", myRoster ,athleteSellNum);
						athleteSellNum = -1;
						cancelSellAthleteItemToggle();
						refreshScreen();
						sellDescriptionLabel.setText("Sold your athlete!!");
					}
					catch(EmptySlotException a){warningLabel.setText(a.getMessage());}}
				
				else if(itemSellNum != -1) {
					try {
						gameEnvironment.tradingProcess("sell", myInventory ,itemSellNum);
						itemSellNum = -1;
						cancelSellAthleteItemToggle();
						refreshScreen();
						sellDescriptionLabel.setText("Sold your item!!");}
					
					catch(EmptySlotException a) {warningLabel.setText(a.getMessage());}}}});
		
		sellButton.setFont(new Font("Lucida Grande", Font.BOLD, 23));
		sellButton.setBounds(1451, 900, 174, 63);
		frmMarket.getContentPane().add(sellButton);
		
		// set the button to go back to main screen
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				gameEnvironment.openMainWindow();
			}
		});
		backButton.setFont(new Font("Lucida Grande", Font.BOLD, 23));
		backButton.setBounds(30, 982, 97, 31);
		frmMarket.getContentPane().add(backButton);
		


	}
	/*
	 * make a panel to show the information of athletes and items when the player click
	 */
	private void setAthleteItemInfoPanel() {
		JPanel setBuyItemInfoPanel = new JPanel();
		setBuyItemInfoPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		setBuyItemInfoPanel.setBounds(1373, 137, 180, 460);
		frmMarket.getContentPane().add(setBuyItemInfoPanel);
		setBuyItemInfoPanel.setLayout(null);
		
		JPanel setBuyAthleteInfoPanel = new JPanel();
		setBuyAthleteInfoPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		setBuyAthleteInfoPanel.setBounds(455, 137, 235, 460);
		frmMarket.getContentPane().add(setBuyAthleteInfoPanel);
		setBuyAthleteInfoPanel.setLayout(null);
		
		JPanel setSellAthleteItemInfoPanel = new JPanel();
		setSellAthleteItemInfoPanel.setLayout(null);
		setSellAthleteItemInfoPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		setSellAthleteItemInfoPanel.setBounds(1183, 746, 256, 215);
		frmMarket.getContentPane().add(setSellAthleteItemInfoPanel);
		
		JLabel athleteInfoLabel = new JLabel("<<Athelte Info.>>");
		athleteInfoLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		athleteInfoLabel.setBounds(12, 31, 212, 20);
		setBuyAthleteInfoPanel.add(athleteInfoLabel);
		
		JLabel itemInfoLabel = new JLabel("<<Item Info.>>");
		itemInfoLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		itemInfoLabel.setBounds(22, 34, 206, 20);
		setBuyItemInfoPanel.add(itemInfoLabel);

		JLabel sellAthleteItemInfoLabel = new JLabel("<<Info.>>");
		sellAthleteItemInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sellAthleteItemInfoLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		sellAthleteItemInfoLabel.setBounds(24, 12, 212, 20);
		setSellAthleteItemInfoPanel.add(sellAthleteItemInfoLabel);
		
		athleteDiscriptionLabel = new JLabel();
		athleteDiscriptionLabel.setBounds(25, 63, 199, 369);
		setBuyAthleteInfoPanel.add(athleteDiscriptionLabel);
		athleteDiscriptionLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

		itemDiscriptionLabel = new JLabel();
		itemDiscriptionLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		itemDiscriptionLabel.setBounds(22, 66, 142, 382);
		setBuyItemInfoPanel.add(itemDiscriptionLabel);
		
		sellDescriptionLabel = new JLabel();
		sellDescriptionLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
		sellDescriptionLabel.setBounds(18, 44, 218, 158);
		setSellAthleteItemInfoPanel.add(sellDescriptionLabel);
		
	}
	/*
	 * close Market window ( it will be called from gameEnvironment)
	 */
	public void closeWindow() {
		frmMarket.dispose();
	}
	/*
	 * close Market window
	 */
	public void finishedWindow() {
		gameEnvironment.closeMarketWindow(this);
	}
}
