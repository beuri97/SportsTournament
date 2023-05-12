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
	
	private JToggleButton athleteBttn1;
	private JToggleButton athleteBttn2;
	private JToggleButton athleteBttn3;
	private JToggleButton athleteBttn4;
	private JToggleButton athleteBttn5;
	private JToggleButton athleteBttn6;
	
	private JLabel athlNameLable1;
	private JLabel athlNameLable2;
	private JLabel athlNameLable3;
	private JLabel athlNameLable4;
	private JLabel athlNameLable5;
	private JLabel athlNameLable6;
	
	private JToggleButton itemButton1;
	private JToggleButton itemButton2;
	private JToggleButton itemButton3;
	private JToggleButton itemButton4;
	private JToggleButton itemButton5;
	private JToggleButton itemButton6;
	private JToggleButton itemButton7;
	private JToggleButton itemButton8;
	
	private JLabel itemLabel1;
	private JLabel itemLabel2;
	private JLabel itemLabel3;
	private JLabel itemLabel4;
	private JLabel itemLabel5;
	private JLabel itemLabel6;
	private JLabel itemLabel7;
	private JLabel itemLabel8;
	
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
	}
	
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
		
		athleteBttn1 = new JToggleButton("Athlete1");
	    athleteBttn2 = new JToggleButton("Athlete2");
		athleteBttn3 = new JToggleButton("Athlete3");
		athleteBttn4 = new JToggleButton("Athlete4");
		athleteBttn5 = new JToggleButton("Athlete5");
		athleteBttn6 = new JToggleButton("Athlete6");
		
		athleteBttn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelBuyAhtleteToggle();
				athleteBttn1.setSelected(true);
				athleteDiscriptionLabel.setText(printing(athleteList[0].toString()));

			}
		});
		athleteBttn1.setBounds(28, 79, 150, 150);
		setBuyAthletePanel.add(athleteBttn1);
		
		athleteBttn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelBuyAhtleteToggle();
				athleteBttn2.setSelected(true);
				athleteDiscriptionLabel.setText(printing(athleteList[1].toString()));

			}
		});
		athleteBttn2.setBounds(198, 79, 150, 150);
		setBuyAthletePanel.add(athleteBttn2);
		
		athleteBttn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelBuyAhtleteToggle();
				athleteBttn3.setSelected(true);
				athleteDiscriptionLabel.setText(printing(athleteList[2].toString()));
			}
		});
		athleteBttn3.setBounds(28, 282, 150, 150);
		setBuyAthletePanel.add(athleteBttn3);
		
		athleteBttn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelBuyAhtleteToggle();
				athleteBttn4.setSelected(true);
				athleteDiscriptionLabel.setText(printing(athleteList[3].toString()));

			}
		});
		athleteBttn4.setBounds(198, 282, 150, 150);
		setBuyAthletePanel.add(athleteBttn4);
			
		athleteBttn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelBuyAhtleteToggle();
				athleteBttn5.setSelected(true);
				athleteDiscriptionLabel.setText(printing(athleteList[4].toString()));

			}
		});
		athleteBttn5.setBounds(28, 472, 150, 150);
		setBuyAthletePanel.add(athleteBttn5);
		
		athleteBttn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelBuyAhtleteToggle();
				athleteBttn6.setSelected(true);
				athleteDiscriptionLabel.setText(printing(athleteList[5].toString()));

			}
		});
		athleteBttn6.setBounds(198, 472, 150, 150);
		setBuyAthletePanel.add(athleteBttn6);
		
		athlNameLable1 = new JLabel("Athlete 1 Name");
		athlNameLable1.setBounds(38, 241, 131, 16);
		setBuyAthletePanel.add(athlNameLable1);
		athlNameLable1.setText(athleteList[0].getName());
		
		athlNameLable2 = new JLabel("Athlete 2 Name");
		athlNameLable2.setBounds(208, 241, 131, 16);
		setBuyAthletePanel.add(athlNameLable2);
		athlNameLable2.setText(athleteList[1].getName());
		
		athlNameLable3 = new JLabel("Athlete 3 Name");
		athlNameLable3.setBounds(38, 444, 131, 16);
		setBuyAthletePanel.add(athlNameLable3);
		athlNameLable3.setText(athleteList[2].getName());
			
		athlNameLable4 = new JLabel("Athlete 4 Name");
		athlNameLable4.setBounds(208, 444, 131, 16);
		setBuyAthletePanel.add(athlNameLable4);
		athlNameLable4.setText(athleteList[3].getName());
		
		athlNameLable5 = new JLabel("Athlete 5 Name");
		athlNameLable5.setBounds(38, 634, 131, 16);
		setBuyAthletePanel.add(athlNameLable5);
		athlNameLable5.setText(athleteList[4].getName());
		
		athlNameLable6 = new JLabel("Athlete 6 Name");
		athlNameLable6.setBounds(208, 634, 131, 16);
		setBuyAthletePanel.add(athlNameLable6);
		athlNameLable6.setText(athleteList[5].getName());
	}
	
	private void cancelBuyAhtleteToggle() {
		athleteBttn1.setSelected(false);
		athleteBttn2.setSelected(false);
		athleteBttn3.setSelected(false);
		athleteBttn4.setSelected(false);
		athleteBttn5.setSelected(false);
		athleteBttn6.setSelected(false);
	}
	
	private void cancelBuyItemToggle() {
		itemButton1.setSelected(false);
		itemButton2.setSelected(false);
		itemButton3.setSelected(false);
		itemButton4.setSelected(false);
		itemButton5.setSelected(false);
		itemButton6.setSelected(false);
		itemButton7.setSelected(false);
		itemButton8.setSelected(false);

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
		
		itemButton1 = new JToggleButton("itemBttn1");
		itemButton2 = new JToggleButton("itemBttn2");
		itemButton3 = new JToggleButton("itemBttn3");
		itemButton4 = new JToggleButton("itemBttn4");
		itemButton5 = new JToggleButton("itemBttn5");
		itemButton6 = new JToggleButton("itemBttn6");
		itemButton7 = new JToggleButton("itemBttn7");
		itemButton8 = new JToggleButton("itemBttn8");
		
		itemButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelBuyItemToggle();
				itemButton1.setSelected(true);
				itemDiscriptionLabel.setText(printing(itemList[0].toString()));
			}
		});
		itemButton1.setBounds(46, 111, 87, 86);
		setBuyItemsPanel.add(itemButton1);		
		
		itemButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelBuyItemToggle();
				itemButton2.setSelected(true);
				itemDiscriptionLabel.setText(printing(itemList[1].toString()));
			}
		});
		itemButton2.setBounds(183, 111, 87, 86);
		setBuyItemsPanel.add(itemButton2);
		
		itemButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelBuyItemToggle();
				itemButton3.setSelected(true);
				itemDiscriptionLabel.setText(printing(itemList[2].toString()));
			}
		});
		itemButton3.setBounds(46, 237, 87, 86);
		setBuyItemsPanel.add(itemButton3);
		
		itemButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelBuyItemToggle();
				itemButton4.setSelected(true);
				itemDiscriptionLabel.setText(printing(itemList[3].toString()));
			}
		});
		itemButton4.setBounds(183, 237, 87, 86);
		setBuyItemsPanel.add(itemButton4);
		
		itemButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelBuyItemToggle();
				itemButton5.setSelected(true);
				itemDiscriptionLabel.setText(printing(itemList[4].toString()));
			}
		});
		itemButton5.setBounds(46, 365, 87, 86);
		setBuyItemsPanel.add(itemButton5);
		
		itemButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelBuyItemToggle();
				itemButton6.setSelected(true);
				itemDiscriptionLabel.setText(printing(itemList[5].toString()));
			}
		});
		itemButton6.setBounds(183, 365, 87, 86);
		setBuyItemsPanel.add(itemButton6);
		
		
		itemButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelBuyItemToggle();
				itemButton7.setSelected(true);
				itemDiscriptionLabel.setText(printing(itemList[6].toString()));
			}
		});
		itemButton7.setBounds(46, 491, 87, 86);
		setBuyItemsPanel.add(itemButton7);
		
		itemButton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelBuyItemToggle();
				itemButton8.setSelected(true);
				itemDiscriptionLabel.setText(printing(itemList[7].toString()));
			}
		});
		itemButton8.setBounds(183, 491, 87, 86);
		setBuyItemsPanel.add(itemButton8);
		
		itemLabel1 = new JLabel("itemLabel1");
		itemLabel1.setBounds(30, 209, 131, 16);
		setBuyItemsPanel.add(itemLabel1);
		itemLabel1.setText(itemList[0].getName());
		
		itemLabel2 = new JLabel("itemLabel2");
		itemLabel2.setBounds(173, 209, 131, 16);
		setBuyItemsPanel.add(itemLabel2);
		itemLabel2.setText(itemList[1].getName());
		
		itemLabel3 = new JLabel("itemLabel3");
		itemLabel3.setBounds(30, 335, 131, 16);
		setBuyItemsPanel.add(itemLabel3);
		itemLabel3.setText(itemList[2].getName());
		
		itemLabel4 = new JLabel("itemLabel4");
		itemLabel4.setBounds(173, 335, 131, 16);
		setBuyItemsPanel.add(itemLabel4);
		itemLabel4.setText(itemList[3].getName());
		
		itemLabel5 = new JLabel("itemLabel5");
		itemLabel5.setBounds(30, 463, 131, 16);
		setBuyItemsPanel.add(itemLabel5);
		itemLabel5.setText(itemList[4].getName());
		
		itemLabel6 = new JLabel("itemLabel6");
		itemLabel6.setBounds(173, 463, 131, 16);
		setBuyItemsPanel.add(itemLabel6);
		itemLabel6.setText(itemList[5].getName());
		
		itemLabel7 = new JLabel("itemLabel7");
		itemLabel7.setBounds(30, 589, 131, 16);
		setBuyItemsPanel.add(itemLabel7);
		itemLabel7.setText(itemList[6].getName());
		
		itemLabel8 = new JLabel("itemLabel8");
		itemLabel8.setBounds(173, 589, 131, 16);
		setBuyItemsPanel.add(itemLabel8);
		itemLabel8.setText(itemList[7].getName());
		
	}
	
	private void cancelSellAthleteToggle() {
		sellAthleteButton1.setSelected(false);
		sellAthleteButton2.setSelected(false);
		sellAthleteButton3.setSelected(false);
		sellAthleteButton4.setSelected(false);
		sellAthleteButton5.setSelected(false);
		sellAthleteButton6.setSelected(false);
		sellAthleteButton7.setSelected(false);
	}
	
	private void cancelSellItemToggle() {
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
	
	
	
	private void setSellAthleteItemPanel() {
		
		JPanel setSellItemPanel = new JPanel();
		setSellItemPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		setSellItemPanel.setBounds(527, 811, 425, 152);
		frmMarket.getContentPane().add(setSellItemPanel);
		setSellItemPanel.setLayout(new GridLayout(2, 5, 0, 0));
		
		JPanel setSellAthletePanel = new JPanel();
		setSellAthletePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		setSellAthletePanel.setBounds(124, 811, 350, 152);
		frmMarket.getContentPane().add(setSellAthletePanel);
		setSellAthletePanel.setLayout(new GridLayout(2, 4, 0, 0));
		
		
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
				cancelSellAthleteToggle();
				sellAthleteButton1.setSelected(true);
//				itemDiscriptionLabel.setText(printing(itemList[7].toString()));
			}
		});
		setSellAthletePanel.add(sellAthleteButton2);
		sellAthleteButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelSellAthleteToggle();
				sellAthleteButton2.setSelected(true);
//				itemDiscriptionLabel.setText(printing(itemList[7].toString()));
			}
		});
		
		setSellAthletePanel.add(sellAthleteButton3);
		sellAthleteButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelSellAthleteToggle();
				sellAthleteButton3.setSelected(true);
//				itemDiscriptionLabel.setText(printing(itemList[7].toString()));
			}
		});
		
		setSellAthletePanel.add(sellAthleteButton4);
		sellAthleteButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelSellAthleteToggle();
				sellAthleteButton4.setSelected(true);
//				itemDiscriptionLabel.setText(printing(itemList[7].toString()));
			}
		});
		
		setSellAthletePanel.add(sellAthleteButton5);
		sellAthleteButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelSellAthleteToggle();
				sellAthleteButton5.setSelected(true);
//				itemDiscriptionLabel.setText(printing(itemList[7].toString()));
			}
		});
		
		setSellAthletePanel.add(sellAthleteButton6);
		sellAthleteButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelSellAthleteToggle();
				sellAthleteButton6.setSelected(true);
//				itemDiscriptionLabel.setText(printing(itemList[7].toString()));
			}
		});
		
		setSellAthletePanel.add(sellAthleteButton7);
		sellAthleteButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelSellAthleteToggle();
				sellAthleteButton7.setSelected(true);
//				itemDiscriptionLabel.setText(printing(itemList[7].toString()));
			}
		});
		
		
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
				cancelSellItemToggle();
				sellitemButton1.setSelected(true);
//				itemDiscriptionLabel.setText(printing(itemList[7].toString()));
			}
		});
		setSellItemPanel.add(sellitemButton2);
		sellitemButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelSellItemToggle();
				sellitemButton2.setSelected(true);
//				itemDiscriptionLabel.setText(printing(itemList[7].toString()));
			}
		});
		
		setSellItemPanel.add(sellitemButton3);
		sellitemButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelSellItemToggle();
				sellitemButton3.setSelected(true);
//				itemDiscriptionLabel.setText(printing(itemList[7].toString()));
			}
		});
		setSellItemPanel.add(sellitemButton4);
		sellitemButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelSellItemToggle();
				sellitemButton4.setSelected(true);
//				itemDiscriptionLabel.setText(printing(itemList[7].toString()));
			}
		});
		setSellItemPanel.add(sellitemButton5);
		sellitemButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelSellItemToggle();
				sellitemButton5.setSelected(true);
//				itemDiscriptionLabel.setText(printing(itemList[7].toString()));
			}
		});
		setSellItemPanel.add(sellitemButton6);
		sellitemButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelSellItemToggle();
				sellitemButton6.setSelected(true);
//				itemDiscriptionLabel.setText(printing(itemList[7].toString()));
			}
		});
		setSellItemPanel.add(sellitemButton7);
		sellitemButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelSellItemToggle();
				sellitemButton7.setSelected(true);
//				itemDiscriptionLabel.setText(printing(itemList[7].toString()));
			}
		});
		setSellItemPanel.add(sellitemButton8);
		sellitemButton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelSellItemToggle();
				sellitemButton8.setSelected(true);
//				itemDiscriptionLabel.setText(printing(itemList[7].toString()));
			}
		});
		setSellItemPanel.add(sellitemButton9);
		sellitemButton9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelSellItemToggle();
				sellitemButton9.setSelected(true);
//				itemDiscriptionLabel.setText(printing(itemList[7].toString()));
			}
		});
		setSellItemPanel.add(sellitemButton10);
		sellitemButton10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelSellItemToggle();
				sellitemButton10.setSelected(true);
//				itemDiscriptionLabel.setText(printing(itemList[7].toString()));
			}
		});
	}
	
	private void setButton() {
		JButton recruitButton = new JButton("RECRUIT");
		recruitButton.setFont(new Font("Lucida Grande", Font.BOLD, 23));
		recruitButton.setBounds(705, 607, 287, 63);
		frmMarket.getContentPane().add(recruitButton);
		// button to purchase the product that the player clicked
		JButton purchaseButton = new JButton("PURCHASE");
		purchaseButton.setFont(new Font("Lucida Grande", Font.BOLD, 23));
		purchaseButton.setBounds(1373, 611, 180, 55);
		frmMarket.getContentPane().add(purchaseButton);
		// button to sell the product that the player clicked
		JButton sellButton = new JButton("SELL");
		sellButton.setFont(new Font("Lucida Grande", Font.BOLD, 23));
		sellButton.setBounds(450, 674, 174, 63);
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
		setSellAthleteItemInfoPanel.setBounds(719, 137, 235, 460);
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
		sellAthleteItemInfoLabel.setBounds(12, 31, 212, 20);
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
		sellDescriptionLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		sellDescriptionLabel.setBounds(22, 63, 199, 369);
		setSellAthleteItemInfoPanel.add(sellDescriptionLabel);
		
	}
	
}
