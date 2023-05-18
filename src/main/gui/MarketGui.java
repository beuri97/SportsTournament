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


public class MarketGui implements UserInterface{

	private JFrame frmMarket;
	
	private GameEnvironment gameEnvironment;
	private Product[] athleteList;
	private Product[] itemList;
	private Athlete[] myRoster;
	private Item[] myInventory;
	int flag;

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

	private JLabel warningLabel;
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
		setAthleteItemInfoPanel();
		setSellAthleteItemPanel();
		setButton();
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
	}
	/*
	 * set the panel to show available athletes in market
	 */
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
		
		buyAthleteBttn1 = new JToggleButton(printingName(3, 0));
		buyAthleteBttn2 = new JToggleButton(printingName(3, 1));
		buyAthleteBttn3 = new JToggleButton(printingName(3, 2));
		buyAthleteBttn4 = new JToggleButton(printingName(3, 3));
		buyAthleteBttn5 = new JToggleButton(printingName(3, 4));
		buyAthleteBttn6 = new JToggleButton(printingName(3, 5));
		
		buyAthleteBttn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncBuyAthlete(0);
				buyAthleteBttn1.setSelected(true);
			}
		});
		buyAthleteBttn1.setBounds(28, 79, 150, 150);
		setBuyAthletePanel.add(buyAthleteBttn1);
		
		buyAthleteBttn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncBuyAthlete(1);
				buyAthleteBttn2.setSelected(true);
			}
		});
		buyAthleteBttn2.setBounds(198, 79, 150, 150);
		setBuyAthletePanel.add(buyAthleteBttn2);
		
		buyAthleteBttn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncBuyAthlete(2);
				buyAthleteBttn3.setSelected(true);
			}
		});
		buyAthleteBttn3.setBounds(28, 282, 150, 150);
		setBuyAthletePanel.add(buyAthleteBttn3);
		
		buyAthleteBttn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncBuyAthlete(3);
				buyAthleteBttn4.setSelected(true);
			}
		});
		buyAthleteBttn4.setBounds(198, 282, 150, 150);
		setBuyAthletePanel.add(buyAthleteBttn4);
			
		buyAthleteBttn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncBuyAthlete(4);
				buyAthleteBttn5.setSelected(true);
			}
		});
		buyAthleteBttn5.setBounds(28, 472, 150, 150);
		setBuyAthletePanel.add(buyAthleteBttn5);
		
		buyAthleteBttn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncBuyAthlete(5);
				buyAthleteBttn6.setSelected(true);
			}
		});
		buyAthleteBttn6.setBounds(198, 472, 150, 150);
		setBuyAthletePanel.add(buyAthleteBttn6);

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
		
		buyItemButton1 = new JToggleButton(printingName(4, 0));
		buyItemButton1.setFont(new Font("Dialog", Font.BOLD, 14));
		buyItemButton2 = new JToggleButton(printingName(4, 1));
		buyItemButton2.setFont(new Font("Dialog", Font.BOLD, 14));
		buyItemButton3 = new JToggleButton(printingName(4, 2));
		buyItemButton3.setFont(new Font("Dialog", Font.BOLD, 14));
		buyItemButton4 = new JToggleButton(printingName(4, 3));
		buyItemButton4.setFont(new Font("Dialog", Font.BOLD, 14));
		buyItemButton5 = new JToggleButton(printingName(4, 4));
		buyItemButton5.setFont(new Font("Dialog", Font.BOLD, 14));
		buyItemButton6 = new JToggleButton(printingName(4, 5));
		buyItemButton6.setFont(new Font("Dialog", Font.BOLD, 14));
		buyItemButton7 = new JToggleButton(printingName(4, 6));
		buyItemButton7.setFont(new Font("Dialog", Font.BOLD, 14));
		buyItemButton8 = new JToggleButton(printingName(4, 7));
		buyItemButton8.setFont(new Font("Dialog", Font.BOLD, 14));
		
		buyItemButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncBuyItem(0);
				buyItemButton1.setSelected(true);
			}
		});
		buyItemButton1.setBounds(49, 69, 200, 40);
		setBuyItemsPanel.add(buyItemButton1);		
		
		buyItemButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncBuyItem(1);
				buyItemButton2.setSelected(true);
			}
		});
		buyItemButton2.setBounds(49, 121, 200, 40);
		setBuyItemsPanel.add(buyItemButton2);
		
		buyItemButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncBuyItem(2);
				buyItemButton3.setSelected(true);
			}
		});
		buyItemButton3.setBounds(49, 173, 200, 40);
		setBuyItemsPanel.add(buyItemButton3);
		
		buyItemButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncBuyItem(3);
				buyItemButton4.setSelected(true);
			}
		});
		buyItemButton4.setBounds(49, 225, 200, 40);
		setBuyItemsPanel.add(buyItemButton4);
		
		buyItemButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncBuyItem(4);
				buyItemButton5.setSelected(true);
			}
		});
		buyItemButton5.setBounds(49, 281, 200, 40);
		setBuyItemsPanel.add(buyItemButton5);
		
		buyItemButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncBuyItem(5);
				buyItemButton6.setSelected(true);
			}
		});
		buyItemButton6.setBounds(49, 336, 200, 40);
		setBuyItemsPanel.add(buyItemButton6);
		
		
		buyItemButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncBuyItem(6);
				buyItemButton7.setSelected(true);
			}
		});
		buyItemButton7.setBounds(49, 388, 200, 40);
		setBuyItemsPanel.add(buyItemButton7);
		
		buyItemButton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncBuyItem(7);
				buyItemButton8.setSelected(true);
			}
		});
		buyItemButton8.setBounds(49, 440, 200, 40);
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
		warningLabel.setText(null);
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
		warningLabel.setText(null);
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
		
		warningLabel.setText(null);
	}
	/* 
	 * function to help buying athletes
	 * assign the athlete slot number and cancel all the toggle buttons clicked
	 */
	private void helpFuncBuyAthlete(int slotNum) {
		cancelBuyAhtleteToggle();
		athleteBuyNum = slotNum;
		athleteDiscriptionLabel.setText(printing(athleteList[slotNum]));
	}
	/* 
	 * function to help buying items
	 * assign the athlete slot number and cancel all the toggle buttons clicked
	 */
	private void helpFuncBuyItem(int slotNum) {
		cancelBuyItemToggle();
		itemBuyNum = slotNum;
		itemDiscriptionLabel.setText(printing(itemList[slotNum]));
	}
	/*
	 * Sell button is clicked, cancel all the other sell buttons,
	 * and assign the index number of athlete list
	 */
	private void helpFuncSellAthlete(int slotNum) {
			cancelSellAthleteItemToggle();
			athleteSellNum = slotNum;
			itemSellNum = -1;
			sellDescriptionLabel.setText(printing(myRoster[slotNum]).replace("<br/><br/>", "<br/>"));		
	}
	/*
	 * Sell button is clicked, cancel all the other sell buttons,
	 * and assign the index number of item list
	 */
	private void helpFuncSellItem(int slotNum) {
			cancelSellAthleteItemToggle();
			itemSellNum = slotNum;
			athleteSellNum = -1;
			sellDescriptionLabel.setText(printing(myInventory[slotNum]));
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
	
		sellAthleteButton1.setText(printingName(1, 0));
		sellAthleteButton2.setText(printingName(1, 1));
		sellAthleteButton3.setText(printingName(1, 2));
		sellAthleteButton4.setText(printingName(1, 3));
		sellAthleteButton5.setText(printingName(1, 4));
		sellAthleteButton6.setText(printingName(1, 5));
		sellAthleteButton7.setText(printingName(1, 6));
		
		sellitemButton1.setText(printingName(2, 0));
		sellitemButton2.setText(printingName(2, 1));
		sellitemButton3.setText(printingName(2, 2));
		sellitemButton4.setText(printingName(2, 3));
		sellitemButton5.setText(printingName(2, 4));
		sellitemButton6.setText(printingName(2, 5));
		sellitemButton7.setText(printingName(2, 6));
		sellitemButton8.setText(printingName(2, 7));
		sellitemButton9.setText(printingName(2, 8));
		sellitemButton10.setText(printingName(2, 9));
		
		buyAthleteBttn1.setText(printingName(3, 0));
		buyAthleteBttn2.setText(printingName(3, 1));
		buyAthleteBttn3.setText(printingName(3, 2));
		buyAthleteBttn4.setText(printingName(3, 3));
		buyAthleteBttn5.setText(printingName(3, 4));
		buyAthleteBttn6.setText(printingName(3, 5));
		
		buyItemButton1.setText(printingName(4, 0));
		buyItemButton2.setText(printingName(4, 1));
		buyItemButton3.setText(printingName(4, 2));
		buyItemButton4.setText(printingName(4, 3));
		buyItemButton5.setText(printingName(4, 4));
		buyItemButton6.setText(printingName(4, 5));
		buyItemButton7.setText(printingName(4, 6));
		buyItemButton8.setText(printingName(4, 7));
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
		sellAthleteButton1 = new JToggleButton(printingName(1, 0));
		sellAthleteButton2 = new JToggleButton(printingName(1, 1));
		sellAthleteButton3 = new JToggleButton(printingName(1, 2));
		sellAthleteButton4 = new JToggleButton(printingName(1, 3));
		sellAthleteButton5 = new JToggleButton(printingName(1, 4));
		sellAthleteButton6 = new JToggleButton(printingName(1, 5));
		sellAthleteButton7 = new JToggleButton(printingName(1, 6));
		
		setSellAthletePanel.add(sellAthleteButton1);
		sellAthleteButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncSellAthlete(0);
				sellAthleteButton1.setSelected(true);}});
		
		setSellAthletePanel.add(sellAthleteButton2);
		sellAthleteButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncSellAthlete(1);
				sellAthleteButton2.setSelected(true);}});
		
		setSellAthletePanel.add(sellAthleteButton3);
		sellAthleteButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncSellAthlete(2);
				sellAthleteButton3.setSelected(true);}});
		
		setSellAthletePanel.add(sellAthleteButton4);
		sellAthleteButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncSellAthlete(3);
				sellAthleteButton4.setSelected(true);}});
		
		setSellAthletePanel.add(sellAthleteButton5);
		sellAthleteButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncSellAthlete(4);
				sellAthleteButton5.setSelected(true);}});
		
		setSellAthletePanel.add(sellAthleteButton6);
		sellAthleteButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncSellAthlete(5);
				sellAthleteButton6.setSelected(true);}});
		
		setSellAthletePanel.add(sellAthleteButton7);
		sellAthleteButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncSellAthlete(6);
				sellAthleteButton7.setSelected(true);}});
		//set the sell item buttons
		sellitemButton1 = new JToggleButton(printingName(2, 0));
		sellitemButton2 = new JToggleButton(printingName(2, 1));
		sellitemButton3 = new JToggleButton(printingName(2, 2));
		sellitemButton4 = new JToggleButton(printingName(2, 3));
		sellitemButton5 = new JToggleButton(printingName(2, 4));
		sellitemButton6 = new JToggleButton(printingName(2, 5));
		sellitemButton7 = new JToggleButton(printingName(2, 6));
		sellitemButton8 = new JToggleButton(printingName(2, 7));
		sellitemButton9 = new JToggleButton(printingName(2, 8));
		sellitemButton10 = new JToggleButton(printingName(2, 9));

		sellitemButton1.setFont(new Font("Dialog", Font.BOLD, 10));
		sellitemButton2.setFont(new Font("Dialog", Font.BOLD, 10));
		sellitemButton3.setFont(new Font("Dialog", Font.BOLD, 10));
		sellitemButton4.setFont(new Font("Dialog", Font.BOLD, 10));
		sellitemButton5.setFont(new Font("Dialog", Font.BOLD, 10));
		sellitemButton6.setFont(new Font("Dialog", Font.BOLD, 10));
		sellitemButton7.setFont(new Font("Dialog", Font.BOLD, 10));
		sellitemButton8.setFont(new Font("Dialog", Font.BOLD, 10));
		sellitemButton9.setFont(new Font("Dialog", Font.BOLD, 10));
		sellitemButton10.setFont(new Font("Dialog", Font.BOLD, 10));
		
		setSellItemPanel.add(sellitemButton1);
		sellitemButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncSellItem(0);
				sellitemButton1.setSelected(true);}});
		setSellItemPanel.add(sellitemButton2);
		sellitemButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncSellItem(1);
				sellitemButton2.setSelected(true);}});
		setSellItemPanel.add(sellitemButton3);
		sellitemButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncSellItem(2);
				sellitemButton3.setSelected(true);}});
		setSellItemPanel.add(sellitemButton4);
		sellitemButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncSellItem(3);
				sellitemButton4.setSelected(true);}});
		setSellItemPanel.add(sellitemButton5);
		sellitemButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncSellItem(4);
				sellitemButton5.setSelected(true);}});
		setSellItemPanel.add(sellitemButton6);
		sellitemButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncSellItem(5);
				sellitemButton6.setSelected(true);}});
		setSellItemPanel.add(sellitemButton7);
		sellitemButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncSellItem(6);
				sellitemButton7.setSelected(true);}});
		setSellItemPanel.add(sellitemButton8);
		sellitemButton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncSellItem(7);
				sellitemButton8.setSelected(true);}});
		setSellItemPanel.add(sellitemButton9);
		sellitemButton9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncSellItem(8);
				sellitemButton9.setSelected(true);}});
		setSellItemPanel.add(sellitemButton10);
		sellitemButton10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpFuncSellItem(9);
				sellitemButton10.setSelected(true);}});
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
				gameEnvironment.openMainScreen();
			}
		});
		backButton.setFont(new Font("Lucida Grande", Font.BOLD, 23));
		backButton.setBounds(30, 982, 97, 31);
		frmMarket.getContentPane().add(backButton);
	}
	/*
	 * print name for Athletes & items on the button
	 * if flag is 0, print athlete namefrom my roster
	 */
	private String printingName(int flag, int indexNum) {
		if(flag == 1) {return (myRoster[indexNum] == null) ? "EMPTY" : printing(myRoster[indexNum].getName());}
		else if(flag ==2){return(myInventory[indexNum] == null) ? "EMPTY" : printing(myInventory[indexNum].getName());}		
		else if(flag == 3) {return(athleteList[indexNum] == null) ? "EMPTY" : printing(athleteList[indexNum].getName());}	
		else {return(itemList[indexNum] == null) ? "EMPTY" : printing(itemList[indexNum].getName());}		
	
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
	public void closeWindow() {
		frmMarket.dispose();
	}
	public void finishedWindow() {
		gameEnvironment.closeMarketWindow(this);
	}
}
