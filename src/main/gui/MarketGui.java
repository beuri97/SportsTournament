package main.gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class MarketGui {

	private JFrame frmMarket;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarketGui window = new MarketGui();
					window.frmMarket.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MarketGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame();
		setAthletePanel();
		setItemsPanel();
		setAthleteBuyInfoPanel();
		setItemBuyInfoPanel();
		setButton();
		setLabel();
		setSellItemPanel();
		setSellAthletePanel();
	}
	private void setFrame() {
		frmMarket = new JFrame();
		frmMarket.setTitle("Market");
		frmMarket.setSize(1650,1080);
		frmMarket.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMarket.getContentPane().setLayout(null);
	}
	
	private void setLabel() {
		JLabel myTeamLabel = new JLabel("My Team");
		myTeamLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 26));
		myTeamLabel.setBounds(394, 27, 128, 36);
		frmMarket.getContentPane().add(myTeamLabel);
		
		JLabel myInventoryLabel = new JLabel("My Inventory");
		myInventoryLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 26));
		myInventoryLabel.setBounds(594, 27, 227, 36);
		frmMarket.getContentPane().add(myInventoryLabel);
		
		JLabel moneyLabel = new JLabel("$Money");
		moneyLabel.setFont(new Font("Dialog", Font.BOLD, 23));
		moneyLabel.setBounds(1480, 45, 145, 49);
		frmMarket.getContentPane().add(moneyLabel);
		
	}
	
	private void setButton() {
		JButton recruitButton = new JButton("RECRUIT");
		recruitButton.setFont(new Font("Lucida Grande", Font.BOLD, 23));
		recruitButton.setBounds(705, 607, 287, 63);
		frmMarket.getContentPane().add(recruitButton);
		
		JButton purchaseButton = new JButton("PURCHASE");
		purchaseButton.setFont(new Font("Lucida Grande", Font.BOLD, 23));
		purchaseButton.setBounds(705, 693, 287, 63);
		frmMarket.getContentPane().add(purchaseButton);
		
		JButton sellButton = new JButton("SELL");
		sellButton.setFont(new Font("Lucida Grande", Font.BOLD, 23));
		sellButton.setBounds(450, 674, 174, 63);
		frmMarket.getContentPane().add(sellButton);
		
		JButton backButton = new JButton("Back");
		backButton.setFont(new Font("Lucida Grande", Font.BOLD, 23));
		backButton.setBounds(450, 609, 145, 63);
		frmMarket.getContentPane().add(backButton);
	}
	
	private void setItemBuyInfoPanel() {
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(754, 96, 180, 460);
		frmMarket.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel itemInfoLabel = new JLabel("<<Item Information>>");
		itemInfoLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		itemInfoLabel.setBounds(15, 20, 206, 20);
		panel_3.add(itemInfoLabel);
		
		JLabel lblNewLabel_7 = new JLabel("- Name -");
		lblNewLabel_7.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(22, 65, 81, 20);
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("- Description -");
		lblNewLabel_7_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_7_1.setBounds(22, 120, 142, 20);
		panel_3.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_7_3 = new JLabel("- Effect -");
		lblNewLabel_7_3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_7_3.setBounds(15, 250, 105, 20);
		panel_3.add(lblNewLabel_7_3);
		
		JLabel lblNewLabel_7_3_2 = new JLabel("incStat here");
		lblNewLabel_7_3_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_7_3_2.setBounds(15, 282, 105, 20);
		panel_3.add(lblNewLabel_7_3_2);
		
		JLabel lblNewLabel_7_4 = new JLabel("ATHLETE NAME HERE");
		lblNewLabel_7_4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_7_4.setBounds(22, 93, 233, 20);
		panel_3.add(lblNewLabel_7_4);
		
		JLabel lblNewLabel_7_4_1 = new JLabel("ATHLETE DISCRP HERE");
		lblNewLabel_7_4_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_7_4_1.setBounds(22, 146, 233, 20);
		panel_3.add(lblNewLabel_7_4_1);
		
		JLabel lblNewLabel_7_4_1_4 = new JLabel("+ incAmount here");
		lblNewLabel_7_4_1_4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_7_4_1_4.setBounds(15, 314, 233, 20);
		panel_3.add(lblNewLabel_7_4_1_4);
	
	}
	
	
	private void setAthleteBuyInfoPanel() {
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(455, 137, 227, 460);
		frmMarket.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("<<Athelte Information>>");
		lblNewLabel_6.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel_6.setBounds(15, 20, 206, 20);
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
	
	
	private void setAthletePanel() {

		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		panel.setBounds(63, 75, 375, 662);
		frmMarket.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel aThletePanelTitle = new JLabel("<<Available Athletes>>");
		aThletePanelTitle.setFont(new Font("Dialog", Font.BOLD, 21));
		aThletePanelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		aThletePanelTitle.setBounds(38, 22, 311, 45);
		panel.add(aThletePanelTitle);
		
		JToggleButton athleteBttn1 = new JToggleButton("Athlete1");
		athleteBttn1.setBounds(28, 79, 150, 150);
		panel.add(athleteBttn1);
		
		JToggleButton athleteBttn2 = new JToggleButton("Athlete2");
		athleteBttn2.setBounds(198, 79, 150, 150);
		panel.add(athleteBttn2);
		
		JToggleButton athleteBttn3 = new JToggleButton("Athlete3");
		athleteBttn3.setBounds(28, 282, 150, 150);
		panel.add(athleteBttn3);
		
		JToggleButton athleteBttn4 = new JToggleButton("Athlete4");
		athleteBttn4.setBounds(198, 282, 150, 150);
		panel.add(athleteBttn4);
		
		JToggleButton athleteBttn5 = new JToggleButton("Athlete5");
		athleteBttn5.setBounds(28, 472, 150, 150);
		panel.add(athleteBttn5);
		
		JToggleButton athleteBttn6 = new JToggleButton("Athlete6");
		athleteBttn6.setBounds(198, 472, 150, 150);
		panel.add(athleteBttn6);
		
		JLabel athlNameLable1 = new JLabel("Athlete 1 Name");
		athlNameLable1.setBounds(38, 241, 131, 16);
		panel.add(athlNameLable1);
		
		JLabel athlNameLable2 = new JLabel("Athlete 3 Name");
		athlNameLable2.setBounds(38, 444, 131, 16);
		panel.add(athlNameLable2);
		
		JLabel athlNameLable3 = new JLabel("Athlete 2 Name");
		athlNameLable3.setBounds(208, 241, 131, 16);
		panel.add(athlNameLable3);
		
		JLabel athlNameLable4 = new JLabel("Athlete 4 Name");
		athlNameLable4.setBounds(208, 444, 131, 16);
		panel.add(athlNameLable4);
		
		JLabel athlNameLable5 = new JLabel("Athlete 5 Name");
		athlNameLable5.setBounds(38, 634, 131, 16);
		panel.add(athlNameLable5);
		
		JLabel athlNameLable6 = new JLabel("Athlete 6 Name");
		athlNameLable6.setBounds(208, 634, 131, 16);
		panel.add(athlNameLable6);
	}
	private void setItemsPanel() {

		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		panel.setBounds(1022, 75, 308, 662);
		frmMarket.getContentPane().add(panel);
		panel.setLayout(null);
		
		JToggleButton itemBttn1 = new JToggleButton("itemBttn1");
		itemBttn1.setBounds(46, 111, 87, 86);
		panel.add(itemBttn1);
		
		JToggleButton itemBttn2 = new JToggleButton("itemBttn2");
		itemBttn2.setBounds(183, 111, 87, 86);
		panel.add(itemBttn2);
		
		JLabel AthlNameLable1 = new JLabel("Athlete 1 Name");
		AthlNameLable1.setBounds(30, 209, 131, 16);
		panel.add(AthlNameLable1);
		
		JLabel AthlNameLable3 = new JLabel("Athlete 2 Name");
		AthlNameLable3.setBounds(173, 209, 131, 16);
		panel.add(AthlNameLable3);
		
		JLabel lblNewLabel = new JLabel("<<Available Items>>");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 22, 281, 45);
		panel.add(lblNewLabel);
		
		JToggleButton itemBttn1_1 = new JToggleButton("itemBttn1");
		itemBttn1_1.setBounds(46, 237, 87, 86);
		panel.add(itemBttn1_1);
		
		JToggleButton itemBttn2_1 = new JToggleButton("itemBttn2");
		itemBttn2_1.setBounds(183, 237, 87, 86);
		panel.add(itemBttn2_1);
		
		JLabel AthlNameLable1_1 = new JLabel("Athlete 1 Name");
		AthlNameLable1_1.setBounds(30, 335, 131, 16);
		panel.add(AthlNameLable1_1);
		
		JLabel AthlNameLable3_1 = new JLabel("Athlete 2 Name");
		AthlNameLable3_1.setBounds(173, 335, 131, 16);
		panel.add(AthlNameLable3_1);
		
		JToggleButton itemBttn1_2 = new JToggleButton("itemBttn1");
		itemBttn1_2.setBounds(46, 365, 87, 86);
		panel.add(itemBttn1_2);
		
		JToggleButton itemBttn2_2 = new JToggleButton("itemBttn2");
		itemBttn2_2.setBounds(183, 365, 87, 86);
		panel.add(itemBttn2_2);
		
		JLabel AthlNameLable1_2 = new JLabel("Athlete 1 Name");
		AthlNameLable1_2.setBounds(30, 463, 131, 16);
		panel.add(AthlNameLable1_2);
		
		JLabel AthlNameLable3_2 = new JLabel("Athlete 2 Name");
		AthlNameLable3_2.setBounds(173, 463, 131, 16);
		panel.add(AthlNameLable3_2);
		
		JToggleButton itemBttn1_3 = new JToggleButton("itemBttn1");
		itemBttn1_3.setBounds(46, 491, 87, 86);
		panel.add(itemBttn1_3);
		
		JToggleButton itemBttn2_3 = new JToggleButton("itemBttn2");
		itemBttn2_3.setBounds(183, 491, 87, 86);
		panel.add(itemBttn2_3);
		
		JLabel AthlNameLable1_3 = new JLabel("Athlete 1 Name");
		AthlNameLable1_3.setBounds(30, 589, 131, 16);
		panel.add(AthlNameLable1_3);
		
		JLabel AthlNameLable3_3 = new JLabel("Athlete 2 Name");
		AthlNameLable3_3.setBounds(173, 589, 131, 16);
		panel.add(AthlNameLable3_3);
		
	}
	private void setSellItemPanel() {
		
		JPanel setSellItemPanel = new JPanel();
		setSellItemPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		setSellItemPanel.setBounds(152, 6, 425, 152);
		frmMarket.getContentPane().add(setSellItemPanel);
		setSellItemPanel.setLayout(new GridLayout(2, 5, 0, 0));
		
		
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
	
	private void setSellAthletePanel() {
		
		JPanel setSellAthletePanel = new JPanel();
		setSellAthletePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		setSellAthletePanel.setBounds(705, 27, 350, 152);
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


	}
	
}
