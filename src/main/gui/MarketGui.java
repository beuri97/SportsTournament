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

public class MarketGui implements UserInterface{

	private JFrame frmMarket;
	
	GameEnvironment gameEnvironment;
	Product[] athleteList;
	Product[] itemList;
	Athlete[] myRoster;
	Item[] myInventory;
	
////////////////////////////////after test.this will be deleted /////////////////////////////////////////////////////////////////////////////		
	JLabel tempTest;
////////////////////////////////after test.this will be deleted /////////////////////////////////////////////////////////////////////////////		
	private JToggleButton buyAthleteBttn1;
	private JToggleButton buyAthleteBttn2;
	private JToggleButton buyAthleteBttn3;
	private JToggleButton buyAthleteBttn4;
	private JToggleButton buyAthleteBttn5;
	private JToggleButton buyAthleteBttn6;
	
	private JToggleButton buyItemButton1;
	private JToggleButton buyItemButton2;
	private JToggleButton buyItemButton3;
	private JToggleButton buyItemButton4;
	private JToggleButton buyItemButton5;
	private JToggleButton buyItemButton6;
	private JToggleButton buyItemButton7;
	private JToggleButton buyItemButton8;
	
	private JToggleButton sellAthleteButton1;
	private JToggleButton sellAthleteButton2;
	private JToggleButton sellAthleteButton3;
	private JToggleButton sellAthleteButton4;
	private JToggleButton sellAthleteButton5;
	private JToggleButton sellAthleteButton6;
	private JToggleButton sellAthleteButton7;
	
	private JToggleButton sellitemButton1;
	private JToggleButton sellitemButton2;
	private JToggleButton sellitemButton3;
	private JToggleButton sellitemButton4;
	private JToggleButton sellitemButton5;
	private JToggleButton sellitemButton6;
	private JToggleButton sellitemButton7;
	private JToggleButton sellitemButton8;
	private JToggleButton sellitemButton9;
	private JToggleButton sellitemButton10;
	
	// next four ints indicate Athlete buttons and item button are clicked, 
		//	when int is -1, button is not clicked
		//	when int is greater than 0(inclusive), it is clicked
		//	this number will be used as index to call athletes and item from from the arraylist. 
	int athleteBuyNum = -1;
	int athleteSellNum = -1;
	int itemBuyNum = -1;
	int itemSellNum = -1;

	private JLabel athleteDiscriptionLabel;
	private JLabel itemDiscriptionLabel;
	private JLabel moneyLabel;
	private JLabel sellDescriptionLabel;
	
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
		setBuyAthleteItemInfoPanel();
		setSellAthleteItemPanel();
		setButton();
	}
	
	private void setFrameLabel() {
		frmMarket = new JFrame();
		frmMarket.setTitle("Market");
		frmMarket.setSize(1650,1080);
		frmMarket.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMarket.getContentPane().setLayout(null);
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
		
////////////////////////////////after test.this will be deleted /////////////////////////////////////////////////////////////////////////////		
		tempTest = new JLabel("tempTest label");
		tempTest.setBounds(522, 45, 212, 24);
		frmMarket.getContentPane().add(tempTest);
////////////////////////////////after test.this will be deleted /////////////////////////////////////////////////////////////////////////////	
	}
	
	private void setBuyAthletePanel() {
		
		JPanel atheltePhotoPanel = new JPanel();
		atheltePhotoPanel.setBounds(713, 129, 279, 468);
		frmMarket.getContentPane().add(atheltePhotoPanel);

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
		
		buyAthleteBttn1 = new JToggleButton("Athlete1");
		buyAthleteBttn2 = new JToggleButton("Athlete2");
		buyAthleteBttn3 = new JToggleButton("Athlete3");
		buyAthleteBttn4 = new JToggleButton("Athlete4");
		buyAthleteBttn5 = new JToggleButton("Athlete5");
		buyAthleteBttn6 = new JToggleButton("Athlete6");
		
		buyAthleteBttn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelBuyAhtleteToggle();
				athleteBuyNum = 0;
				buyAthleteBttn1.setSelected(true);
				athleteDiscriptionLabel.setText(printing(athleteList[0].toString()));

			}
		});
		buyAthleteBttn1.setBounds(28, 79, 150, 150);
		setBuyAthletePanel.add(buyAthleteBttn1);
		
		buyAthleteBttn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelBuyAhtleteToggle();
				athleteBuyNum = 1;
				buyAthleteBttn2.setSelected(true);
				athleteDiscriptionLabel.setText(printing(athleteList[1].toString()));

			}
		});
		buyAthleteBttn2.setBounds(198, 79, 150, 150);
		setBuyAthletePanel.add(buyAthleteBttn2);
		
		buyAthleteBttn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelBuyAhtleteToggle();
				athleteBuyNum = 2;
				buyAthleteBttn3.setSelected(true);
				athleteDiscriptionLabel.setText(printing(athleteList[2].toString()));
			}
		});
		buyAthleteBttn3.setBounds(28, 282, 150, 150);
		setBuyAthletePanel.add(buyAthleteBttn3);
		
		buyAthleteBttn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelBuyAhtleteToggle();
				athleteBuyNum = 3;
				buyAthleteBttn4.setSelected(true);
				athleteDiscriptionLabel.setText(printing(athleteList[3].toString()));

			}
		});
		buyAthleteBttn4.setBounds(198, 282, 150, 150);
		setBuyAthletePanel.add(buyAthleteBttn4);
			
		buyAthleteBttn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelBuyAhtleteToggle();
				athleteBuyNum = 4;
				buyAthleteBttn5.setSelected(true);
				athleteDiscriptionLabel.setText(printing(athleteList[4].toString()));

			}
		});
		buyAthleteBttn5.setBounds(28, 472, 150, 150);
		setBuyAthletePanel.add(buyAthleteBttn5);
		
		buyAthleteBttn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelBuyAhtleteToggle();
				athleteBuyNum = 5;
				buyAthleteBttn6.setSelected(true);
				athleteDiscriptionLabel.setText(printing(athleteList[5].toString()));

			}
		});
		buyAthleteBttn6.setBounds(198, 472, 150, 150);
		setBuyAthletePanel.add(buyAthleteBttn6);

	}
	
	private void setBuyItemsPanel() {

		JPanel setBuyItemsPanel = new JPanel();
		setBuyItemsPanel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		setBuyItemsPanel.setBounds(1022, 75, 308, 662);
		frmMarket.getContentPane().add(setBuyItemsPanel);
		setBuyItemsPanel.setLayout(null);
		
		JLabel availableItemLabel = new JLabel("<<Available Items>>");
		availableItemLabel.setFont(new Font("Dialog", Font.BOLD, 21));
		availableItemLabel.setHorizontalAlignment(SwingConstants.CENTER);
		availableItemLabel.setBounds(12, 22, 281, 45);
		setBuyItemsPanel.add(availableItemLabel);
		
		buyItemButton1 = new JToggleButton("itemBttn1");
		buyItemButton2 = new JToggleButton("itemBttn2");
		buyItemButton3 = new JToggleButton("itemBttn3");
		buyItemButton4 = new JToggleButton("itemBttn4");
		buyItemButton5 = new JToggleButton("itemBttn5");
		buyItemButton6 = new JToggleButton("itemBttn6");
		buyItemButton7 = new JToggleButton("itemBttn7");
		buyItemButton8 = new JToggleButton("itemBttn8");
		
		buyItemButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelBuyItemToggle();
				itemBuyNum = 0;
				buyItemButton1.setSelected(true);
				itemDiscriptionLabel.setText(printing(itemList[0].toString()));
			}
		});
		buyItemButton1.setBounds(46, 111, 87, 86);
		setBuyItemsPanel.add(buyItemButton1);		
		
		buyItemButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelBuyItemToggle();
				itemBuyNum = 1;
				buyItemButton2.setSelected(true);
				itemDiscriptionLabel.setText(printing(itemList[1].toString()));
			}
		});
		buyItemButton2.setBounds(183, 111, 87, 86);
		setBuyItemsPanel.add(buyItemButton2);
		
		buyItemButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelBuyItemToggle();
				itemBuyNum = 2;
				buyItemButton3.setSelected(true);
				itemDiscriptionLabel.setText(printing(itemList[2].toString()));
			}
		});
		buyItemButton3.setBounds(46, 237, 87, 86);
		setBuyItemsPanel.add(buyItemButton3);
		
		buyItemButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelBuyItemToggle();
				itemBuyNum = 3;
				buyItemButton4.setSelected(true);
				itemDiscriptionLabel.setText(printing(itemList[3].toString()));
			}
		});
		buyItemButton4.setBounds(183, 237, 87, 86);
		setBuyItemsPanel.add(buyItemButton4);
		
		buyItemButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelBuyItemToggle();
				itemBuyNum = 4;
				buyItemButton5.setSelected(true);
				itemDiscriptionLabel.setText(printing(itemList[4].toString()));
			}
		});
		buyItemButton5.setBounds(46, 365, 87, 86);
		setBuyItemsPanel.add(buyItemButton5);
		
		buyItemButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelBuyItemToggle();
				itemBuyNum = 5;
				buyItemButton6.setSelected(true);
				itemDiscriptionLabel.setText(printing(itemList[5].toString()));
			}
		});
		buyItemButton6.setBounds(183, 365, 87, 86);
		setBuyItemsPanel.add(buyItemButton6);
		
		
		buyItemButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelBuyItemToggle();
				itemBuyNum = 6;
				buyItemButton7.setSelected(true);
				itemDiscriptionLabel.setText(printing(itemList[6].toString()));
			}
		});
		buyItemButton7.setBounds(46, 491, 87, 86);
		setBuyItemsPanel.add(buyItemButton7);
		
		buyItemButton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelBuyItemToggle();
				itemBuyNum = 7;
				buyItemButton8.setSelected(true);
				itemDiscriptionLabel.setText(printing(itemList[7].toString()));
			}
		});
		buyItemButton8.setBounds(183, 491, 87, 86);
		setBuyItemsPanel.add(buyItemButton8);
	}
	
	/*
	 * cancel all toggle buttons for buying athlete
	 */
	private void cancelBuyAhtleteToggle() {
		buyAthleteBttn1.setSelected(false);
		buyAthleteBttn2.setSelected(false);
		buyAthleteBttn3.setSelected(false);
		buyAthleteBttn4.setSelected(false);
		buyAthleteBttn5.setSelected(false);
		buyAthleteBttn6.setSelected(false);
	}
	/*
	 * cancel all toggle buttons for buying item
	 */
	private void cancelBuyItemToggle() {
		buyItemButton1.setSelected(false);
		buyItemButton2.setSelected(false);
		buyItemButton3.setSelected(false);
		buyItemButton4.setSelected(false);
		buyItemButton5.setSelected(false);
		buyItemButton6.setSelected(false);
		buyItemButton7.setSelected(false);
		buyItemButton8.setSelected(false);
	}
	/*
	 * cancel all toggle buttons for selling athletes and items
	 */
	private void cancelSellAthleteItemToggle() {
		sellAthleteButton1.setSelected(false);
		sellAthleteButton2.setSelected(false);
		sellAthleteButton3.setSelected(false);
		sellAthleteButton4.setSelected(false);
		sellAthleteButton5.setSelected(false);
		sellAthleteButton6.setSelected(false);
		sellAthleteButton7.setSelected(false);
		
		sellitemButton1.setSelected(false);
		sellitemButton2.setSelected(false);
		sellitemButton3.setSelected(false);
		sellitemButton4.setSelected(false);
		sellitemButton5.setSelected(false);
		sellitemButton6.setSelected(false);
		sellitemButton7.setSelected(false);
		sellitemButton8.setSelected(false);
		sellitemButton9.setSelected(false);
		sellitemButton10.setSelected(false);
	}

	/*
	 * Sell button is clicked, cancel all the other sell buttons,
	 * and assign the index number of athlete list
	 */
	private void helpFuncSellAthlete(int slotNum) {
			cancelSellAthleteItemToggle();
			athleteSellNum = slotNum;
			sellDescriptionLabel.setText(printing(myRoster[slotNum]));		
	}
	/*
	 * Sell button is clicked, cancel all the other sell buttons,
	 * and assign the index number of item list
	 */
	private void helpFuncSellItem(int slotNum) {
			cancelSellAthleteItemToggle();
			itemSellNum = slotNum;
			sellDescriptionLabel.setText(printing(myInventory[slotNum]));
	
	}
	
	/*
	 * update screen with latest information.
	 */
	private void refreshScreen() {
		moneyLabel.setText("$ " + gameEnvironment.getTeam().getMoney());
		athleteList = gameEnvironment.getMarket().getAthleteProduct();
		itemList = gameEnvironment.getMarket().getItemProduct();
		myInventory = gameEnvironment.getTeam().getInventory();
		myRoster = gameEnvironment.getTeam().getRoster();
		
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
		setSellItemPanel.setBounds(527, 811, 425, 152);
		frmMarket.getContentPane().add(setSellItemPanel);
		setSellItemPanel.setLayout(new GridLayout(2, 5, 0, 0));
			
		//set sell athlete buttons
		sellAthleteButton1 = new JToggleButton("Athlete1");
		sellAthleteButton2 = new JToggleButton("Athlete2");
		sellAthleteButton3 = new JToggleButton("Athlete3");
		sellAthleteButton4 = new JToggleButton("Athlete4");
		sellAthleteButton5 = new JToggleButton("Athlete5");
		sellAthleteButton6 = new JToggleButton("Athlete6");
		sellAthleteButton7 = new JToggleButton("Athlete7");
		
		setSellAthletePanel.add(sellAthleteButton1);
		sellAthleteButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncSellAthlete(0);
				sellAthleteButton1.setSelected(true);
			}
		});
		
		setSellAthletePanel.add(sellAthleteButton2);
		sellAthleteButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncSellAthlete(1);
				sellAthleteButton2.setSelected(true);
			}
		});
		
		setSellAthletePanel.add(sellAthleteButton3);
		sellAthleteButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncSellAthlete(2);
				sellAthleteButton3.setSelected(true);
			}
		});
		
		setSellAthletePanel.add(sellAthleteButton4);
		sellAthleteButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncSellAthlete(3);
				sellAthleteButton4.setSelected(true);
			}
		});
		
		setSellAthletePanel.add(sellAthleteButton5);
		sellAthleteButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncSellAthlete(4);
				sellAthleteButton5.setSelected(true);
			}
		});
		
		setSellAthletePanel.add(sellAthleteButton6);
		sellAthleteButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncSellAthlete(5);
				sellAthleteButton6.setSelected(true);
			}
		});
		
		setSellAthletePanel.add(sellAthleteButton7);
		sellAthleteButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncSellAthlete(6);
				sellAthleteButton7.setSelected(true);
			}
		});
		//set the sell item buttons
		sellitemButton1 = new JToggleButton("Item1");
		sellitemButton2 = new JToggleButton("Item2");
		sellitemButton3 = new JToggleButton("Item3");
		sellitemButton4 = new JToggleButton("Item4");
		sellitemButton5 = new JToggleButton("Item5");
		sellitemButton6 = new JToggleButton("Item6");
		sellitemButton7 = new JToggleButton("Item7");
		sellitemButton8 = new JToggleButton("Item8");
		sellitemButton9 = new JToggleButton("Item9");
		sellitemButton10 = new JToggleButton("Item10");
		
		setSellItemPanel.add(sellitemButton1);
		sellitemButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncSellItem(0);
				sellitemButton1.setSelected(true);
			}
		});
		setSellItemPanel.add(sellitemButton2);
		sellitemButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncSellItem(1);
				sellitemButton2.setSelected(true);
			}
		});
		
		setSellItemPanel.add(sellitemButton3);
		sellitemButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncSellItem(2);
				sellitemButton3.setSelected(true);
			}
		});
		setSellItemPanel.add(sellitemButton4);
		sellitemButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncSellItem(3);
				sellitemButton4.setSelected(true);
			}
		});
		setSellItemPanel.add(sellitemButton5);
		sellitemButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncSellItem(4);
				sellitemButton5.setSelected(true);
			}
		});
		setSellItemPanel.add(sellitemButton6);
		sellitemButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncSellItem(5);
				sellitemButton6.setSelected(true);
			}
		});
		setSellItemPanel.add(sellitemButton7);
		sellitemButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncSellItem(6);
				sellitemButton7.setSelected(true);
			}
		});
		setSellItemPanel.add(sellitemButton8);
		sellitemButton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncSellItem(7);
				sellitemButton8.setSelected(true);
			}
		});
		setSellItemPanel.add(sellitemButton9);
		sellitemButton9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncSellItem(8);
				sellitemButton9.setSelected(true);
			}
		});
		setSellItemPanel.add(sellitemButton10);
		sellitemButton10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncSellItem(9);
				sellitemButton10.setSelected(true);
			}
		});
	}
	
	/*
	 * set all the buttons on window, but not in the panel.
	 */
	private void setButton() {
		
		// button to recruit the clicked athlete
		JButton recruitButton = new JButton("RECRUIT");
		recruitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (athleteBuyNum == -1){athleteDiscriptionLabel.setText("Choose an athelte!");}
				else {
					gameEnvironment.tradingProcess("buy", athleteList ,athleteBuyNum);
					athleteBuyNum = -1;
					cancelBuyAhtleteToggle();
					refreshScreen();
				}
			}
		});
		recruitButton.setFont(new Font("Lucida Grande", Font.BOLD, 23));
		recruitButton.setBounds(705, 607, 287, 63);
		frmMarket.getContentPane().add(recruitButton);
		
		// button to purchase the product that the player clicked
		JButton purchaseButton = new JButton("PURCHASE");
		purchaseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (itemBuyNum == -1) {itemDiscriptionLabel.setText("Choose an item!");}
				else {
					gameEnvironment.tradingProcess("buy", itemList ,itemBuyNum);
					itemBuyNum = -1;
					cancelBuyItemToggle();
					refreshScreen();
				}
				
			}
		});
		purchaseButton.setFont(new Font("Lucida Grande", Font.BOLD, 23));
		purchaseButton.setBounds(1373, 611, 180, 55);
		frmMarket.getContentPane().add(purchaseButton);
		
		// button to sell the product that the player clicked
		JButton sellButton = new JButton("SELL");
		sellButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (athleteSellNum != -1){
					gameEnvironment.tradingProcess("sell", myRoster ,athleteSellNum);
					athleteSellNum = -1;
					cancelSellAthleteItemToggle();
					refreshScreen();
					}
				else if(itemSellNum != -1) {
					//////////////////////////////////////////////////////////////////////////////////////////////////test. will be deleted
					tempTest.setText(itemSellNum+"");					
					//////////////////////////////////////////////////////////////////////////////////////////////////test. will be deleted
					gameEnvironment.tradingProcess("sell", myInventory ,itemSellNum);
					itemSellNum = -1;
					cancelSellAthleteItemToggle();
					refreshScreen();
				}
			}		
		});
		sellButton.setFont(new Font("Lucida Grande", Font.BOLD, 23));
		sellButton.setBounds(1451, 900, 174, 63);
		frmMarket.getContentPane().add(sellButton);
		
		// set the button to go back to main screen
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMarket.dispose();
				MainScreenGui backToMain = new MainScreenGui(gameEnvironment);
			}
		});
		backButton.setFont(new Font("Lucida Grande", Font.BOLD, 23));
		backButton.setBounds(30, 982, 97, 31);
		frmMarket.getContentPane().add(backButton);


	}
	
	private void setBuyAthleteItemInfoPanel() {
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
		setSellAthleteItemInfoPanel.setBounds(987, 749, 425, 214);
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
		sellAthleteItemInfoLabel.setBounds(112, 12, 212, 20);
		setSellAthleteItemInfoPanel.add(sellAthleteItemInfoLabel);
		
		athleteDiscriptionLabel = new JLabel("");
		athleteDiscriptionLabel.setBounds(25, 63, 199, 369);
		setBuyAthleteInfoPanel.add(athleteDiscriptionLabel);
		athleteDiscriptionLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

		itemDiscriptionLabel = new JLabel("");
		itemDiscriptionLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		itemDiscriptionLabel.setBounds(22, 66, 142, 382);
		setBuyItemInfoPanel.add(itemDiscriptionLabel);
		
		sellDescriptionLabel = new JLabel("");
		sellDescriptionLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
		sellDescriptionLabel.setBounds(41, 44, 342, 158);
		setSellAthleteItemInfoPanel.add(sellDescriptionLabel);
		
	}
}
