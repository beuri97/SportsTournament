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
	
	private JToggleButton itemButton1;
	private JToggleButton itemButton2;
	private JToggleButton itemButton3;
	private JToggleButton itemButton4;
	private JToggleButton itemButton5;
	private JToggleButton itemButton6;
	private JToggleButton itemButton7;
	private JToggleButton itemButton8;

	JLabel athleteDiscriptionLabel;
	JLabel itemInfoLabel;
	
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
		
		JLabel moneyLabel = new JLabel("$Money");
		moneyLabel.setFont(new Font("Dialog", Font.BOLD, 23));
		moneyLabel.setBounds(1480, 45, 145, 49);
		frmMarket.getContentPane().add(moneyLabel);
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
				cancelAhtleteToggle();
				athleteBttn1.setSelected(true);
				athleteDiscriptionLabel.setText(printing(athleteList[0].toString()));

			}
		});
		athleteBttn1.setBounds(28, 79, 150, 150);
		setBuyAthletePanel.add(athleteBttn1);
		
		athleteBttn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelAhtleteToggle();
				athleteBttn2.setSelected(true);
				athleteDiscriptionLabel.setText(printing(athleteList[1].toString()));

			}
		});
		athleteBttn2.setBounds(198, 79, 150, 150);
		setBuyAthletePanel.add(athleteBttn2);
		
		athleteBttn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelAhtleteToggle();
				athleteBttn3.setSelected(true);
				athleteDiscriptionLabel.setText(printing(athleteList[2].toString()));

			}
		});
		athleteBttn3.setBounds(28, 282, 150, 150);
		setBuyAthletePanel.add(athleteBttn3);
		
		athleteBttn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelAhtleteToggle();
				athleteBttn4.setSelected(true);
				athleteDiscriptionLabel.setText(printing(athleteList[3].toString()));

			}
		});
		athleteBttn4.setBounds(198, 282, 150, 150);
		setBuyAthletePanel.add(athleteBttn4);
			
		athleteBttn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelAhtleteToggle();
				athleteBttn5.setSelected(true);
				athleteDiscriptionLabel.setText(printing(athleteList[4].toString()));

			}
		});
		athleteBttn5.setBounds(28, 472, 150, 150);
		setBuyAthletePanel.add(athleteBttn5);
		
		athleteBttn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelAhtleteToggle();
				athleteBttn6.setSelected(true);
				athleteDiscriptionLabel.setText(printing(athleteList[5].toString()));

			}
		});
		athleteBttn6.setBounds(198, 472, 150, 150);
		setBuyAthletePanel.add(athleteBttn6);
		
		JLabel athlNameLable1 = new JLabel("Athlete 1 Name");
		athlNameLable1.setBounds(38, 241, 131, 16);
		setBuyAthletePanel.add(athlNameLable1);
		athlNameLable1.setText(athleteList[0].getName());
		
		JLabel athlNameLable2 = new JLabel("Athlete 2 Name");
		athlNameLable2.setBounds(208, 241, 131, 16);
		setBuyAthletePanel.add(athlNameLable2);
		athlNameLable2.setText(athleteList[1].getName());
		
		JLabel athlNameLable3 = new JLabel("Athlete 3 Name");
		athlNameLable3.setBounds(38, 444, 131, 16);
		setBuyAthletePanel.add(athlNameLable3);
		athlNameLable3.setText(athleteList[2].getName());
			
		JLabel athlNameLable4 = new JLabel("Athlete 4 Name");
		athlNameLable4.setBounds(208, 444, 131, 16);
		setBuyAthletePanel.add(athlNameLable4);
		athlNameLable4.setText(athleteList[3].getName());
		
		JLabel athlNameLable5 = new JLabel("Athlete 5 Name");
		athlNameLable5.setBounds(38, 634, 131, 16);
		setBuyAthletePanel.add(athlNameLable5);
		athlNameLable5.setText(athleteList[4].getName());
		
		JLabel athlNameLable6 = new JLabel("Athlete 6 Name");
		athlNameLable6.setBounds(208, 634, 131, 16);
		setBuyAthletePanel.add(athlNameLable6);
		athlNameLable6.setText(athleteList[5].getName());
	}
	
	private void cancelAhtleteToggle() {
		athleteBttn1.setSelected(false);
		athleteBttn2.setSelected(false);
		athleteBttn3.setSelected(false);
		athleteBttn4.setSelected(false);
		athleteBttn5.setSelected(false);
		athleteBttn6.setSelected(false);
	}
	
	private void cancelItemToggle() {
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
		
		JLabel lblNewLabel = new JLabel("<<Available Items>>");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 22, 281, 45);
		setBuyItemsPanel.add(lblNewLabel);
		
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
				cancelItemToggle();
				itemButton1.setSelected(true);
			}
		});
		itemButton1.setBounds(46, 111, 87, 86);
		setBuyItemsPanel.add(itemButton1);		
		
		itemButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelItemToggle();
				itemButton2.setSelected(true);
			}
		});
		itemButton2.setBounds(183, 111, 87, 86);
		setBuyItemsPanel.add(itemButton2);
		
		itemButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelItemToggle();
				itemButton3.setSelected(true);
			}
		});
		itemButton3.setBounds(46, 237, 87, 86);
		setBuyItemsPanel.add(itemButton3);
		
		itemButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelItemToggle();
				itemButton4.setSelected(true);
			}
		});
		itemButton4.setBounds(183, 237, 87, 86);
		setBuyItemsPanel.add(itemButton4);
		
		itemButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelItemToggle();
				itemButton5.setSelected(true);
			}
		});
		itemButton5.setBounds(46, 365, 87, 86);
		setBuyItemsPanel.add(itemButton5);
		
		itemButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelItemToggle();
				itemButton6.setSelected(true);
			}
		});
		itemButton6.setBounds(183, 365, 87, 86);
		setBuyItemsPanel.add(itemButton6);
		
		
		itemButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelItemToggle();
				itemButton7.setSelected(true);
			}
		});
		itemButton7.setBounds(46, 491, 87, 86);
		setBuyItemsPanel.add(itemButton7);
		
		itemButton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelItemToggle();
				itemButton8.setSelected(true);
			}
		});
		itemButton8.setBounds(183, 491, 87, 86);
		setBuyItemsPanel.add(itemButton8);
		
		JLabel AthlNameLable1 = new JLabel("itemLabel1");
		AthlNameLable1.setBounds(30, 209, 131, 16);
		setBuyItemsPanel.add(AthlNameLable1);
		
		JLabel AthlNameLable3 = new JLabel("itemLabel2");
		AthlNameLable3.setBounds(173, 209, 131, 16);
		setBuyItemsPanel.add(AthlNameLable3);
		
		JLabel AthlNameLable1_1 = new JLabel("itemLabel3");
		AthlNameLable1_1.setBounds(30, 335, 131, 16);
		setBuyItemsPanel.add(AthlNameLable1_1);
		
		JLabel AthlNameLable3_1 = new JLabel("itemLabel4");
		AthlNameLable3_1.setBounds(173, 335, 131, 16);
		setBuyItemsPanel.add(AthlNameLable3_1);
		
		JLabel AthlNameLable1_2 = new JLabel("itemLabel5");
		AthlNameLable1_2.setBounds(30, 463, 131, 16);
		setBuyItemsPanel.add(AthlNameLable1_2);
		
		JLabel AthlNameLable3_2 = new JLabel("itemLabel6");
		AthlNameLable3_2.setBounds(173, 463, 131, 16);
		setBuyItemsPanel.add(AthlNameLable3_2);
		
		JLabel AthlNameLable1_3 = new JLabel("itemLabel7");
		AthlNameLable1_3.setBounds(30, 589, 131, 16);
		setBuyItemsPanel.add(AthlNameLable1_3);
		
		JLabel AthlNameLable3_3 = new JLabel("itemLabel8");
		AthlNameLable3_3.setBounds(173, 589, 131, 16);
		setBuyItemsPanel.add(AthlNameLable3_3);
		
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
		
		
		JToggleButton AthleteButton1 = new JToggleButton("Athlete1");
		setSellAthletePanel.add(AthleteButton1);
		JToggleButton AthleteButton2 = new JToggleButton("Athlete2");
		setSellAthletePanel.add(AthleteButton2);
		JToggleButton AthleteButton3 = new JToggleButton("Athlete3");
		setSellAthletePanel.add(AthleteButton3);
		JToggleButton AthleteButton4 = new JToggleButton("Athlete4");
		setSellAthletePanel.add(AthleteButton4);
		JToggleButton AthleteButton5 = new JToggleButton("Athlete5");
		setSellAthletePanel.add(AthleteButton5);
		JToggleButton AthleteButton6 = new JToggleButton("Athlete6");
		setSellAthletePanel.add(AthleteButton6);
		JToggleButton AthleteButton7 = new JToggleButton("Athlete7");
		setSellAthletePanel.add(AthleteButton7);
		
		
		JToggleButton itemButton1 = new JToggleButton("Item1");
		setSellItemPanel.add(itemButton1);
		JToggleButton itemButton2 = new JToggleButton("Item2");
		setSellItemPanel.add(itemButton2);
		JToggleButton itemButton3 = new JToggleButton("Item3");
		setSellItemPanel.add(itemButton3);
		JToggleButton itemButton4 = new JToggleButton("Item4");
		setSellItemPanel.add(itemButton4);
		JToggleButton itemButton5 = new JToggleButton("Item5");
		setSellItemPanel.add(itemButton5);
		JToggleButton itemButton6 = new JToggleButton("Item6");
		setSellItemPanel.add(itemButton6);
		JToggleButton itemButton7 = new JToggleButton("Item7");
		setSellItemPanel.add(itemButton7);
		JToggleButton itemButton8 = new JToggleButton("Item8");
		setSellItemPanel.add(itemButton8);
		JToggleButton itemButton9 = new JToggleButton("Item9");
		setSellItemPanel.add(itemButton9);
		JToggleButton itemButton10 = new JToggleButton("Item10");
		setSellItemPanel.add(itemButton10);

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
		
		itemInfoLabel = new JLabel("<<Item Info.>>");
		itemInfoLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		itemInfoLabel.setBounds(22, 34, 206, 20);
		setBuyItemInfoPanel.add(itemInfoLabel);

		JLabel itemDiscriptionLabel = new JLabel("- Description -");
		itemDiscriptionLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		itemDiscriptionLabel.setBounds(22, 66, 142, 382);
		setBuyItemInfoPanel.add(itemDiscriptionLabel);
		itemDiscriptionLabel.setText(printing(athleteList[1].toString()));
		
		JLabel athleteInfoLabel = new JLabel("<<Athelte Info.>>");
		athleteInfoLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		athleteInfoLabel.setBounds(12, 31, 212, 20);
		setBuyAthleteInfoPanel.add(athleteInfoLabel);
			
		athleteDiscriptionLabel = new JLabel("");
		athleteDiscriptionLabel.setBounds(25, 63, 199, 369);
		setBuyAthleteInfoPanel.add(athleteDiscriptionLabel);
		athleteDiscriptionLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		
	}
	
}
