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
	Athlete[] athleteList;
	Item[] itemList;

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
	
	private JLabel athleteLabel1;
	private JLabel athleteLabel2;
	private JLabel athleteLabel3;
	private JLabel athleteLabel4;
	private JLabel athleteLabel5;
	private JLabel athleteLabel6;
	private JLabel athleteLabel7;
	
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
	
	

	JLabel noticeUsingSwitching;
	JLabel athleteDescriptionLabel;
	JLabel itemDescriptionLabel;
	
	/**
	 * Create the application.
	 */
	public  MainScreenGui(GameEnvironment gameEnvironment) {
		this.gameEnvironment = gameEnvironment;
		this.athleteList = gameEnvironment.getTeam().getRoster();
		this.itemList = gameEnvironment.getTeam().getInventory();
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
		
		JLabel weekLabel = new JLabel(" / ");
		weekLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		weekLabel.setBounds(771, 38, 15, 30);
		frmMainWindow.getContentPane().add(weekLabel);
		
		JLabel diffLevelLabel = new JLabel("Difficulty Level : ");
		diffLevelLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		diffLevelLabel.setBounds(926, 36, 202, 30);
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
		weekNumLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		weekNumLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		weekNumLabel.setBounds(632, 36, 141, 30);
		frmMainWindow.getContentPane().add(weekNumLabel);
		
		int currentWeek = gameEnvironment.getCurrentSeason();
		if (currentWeek == 1) {weekNumLabel.setText("1st week");}
		else if((currentWeek == 2)){weekNumLabel.setText("2nd week");}
		else {weekNumLabel.setText(gameEnvironment.getCurrentSeason() + "rd week");}
		
		JLabel totalweekLabel = new JLabel("TOTAL WEEKS HERE");
		totalweekLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		totalweekLabel.setBounds(785, 38, 243, 30);
		frmMainWindow.getContentPane().add(totalweekLabel);
		totalweekLabel.setText("Total "+ gameEnvironment.getTotalSeason() + "weeks");
		
		JLabel selectedDifficultyLabel = new JLabel("SelectedDifficulty");
		selectedDifficultyLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		selectedDifficultyLabel.setBounds(1140, 36, 174, 30);
		frmMainWindow.getContentPane().add(selectedDifficultyLabel);
		selectedDifficultyLabel.setText(gameEnvironment.getDifficulty().toString());
		
		JLabel moneyLabel = new JLabel("$ Money");
		moneyLabel.setFont(new Font("Lucida Grande", Font.BOLD, 27));
		moneyLabel.setBounds(1277, 36, 202, 30);
		frmMainWindow.getContentPane().add(moneyLabel);
		moneyLabel.setText("$ " + gameEnvironment.getTeam().getMoney());
		
		noticeUsingSwitching = new JLabel("");
		noticeUsingSwitching.setForeground(new Color(255, 11, 3));
		noticeUsingSwitching.setBounds(906, 738, 282, 16);
		frmMainWindow.getContentPane().add(noticeUsingSwitching);
	}
	/**
	 * Panel for Athlete lists on main screen
	 */
	private void setAthletePanel() {
		
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
		
		//Create toggle buttons for All the athletes that the player owns.
		// 1~4 are Active, 5~7 are Reserves
		athleteButton1 = new JToggleButton("Athlete1");
		athleteButton2 = new JToggleButton("Athlete2");
		athleteButton3 = new JToggleButton("Athlete3");
		athleteButton4 = new JToggleButton("Athlete4");
		athleteButton5 = new JToggleButton("Athlete5");
		athleteButton6 = new JToggleButton("Athlete6");
		athleteButton7 = new JToggleButton("Athlete7");
		
		athleteLabel1 = new JLabel("AthleteName1");
		athleteLabel2 = new JLabel("AthleteName2");
		athleteLabel3 = new JLabel("AthleteName3");
		athleteLabel4 = new JLabel("AthleteName4");
		athleteLabel5 = new JLabel("AthleteName5");
		athleteLabel6 = new JLabel("AthleteName6");
		athleteLabel7 = new JLabel("AthleteName7");
		
		athleteButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteButton2.setSelected(false);
				athleteButton3.setSelected(false);
				athleteButton4.setSelected(false);
				isAthleteSlotEmpty(0);		
			}
		});
		athleteButton1.setBounds(20, 20, 150, 150);
		setAthletePanel.add(athleteButton1);
		
		athleteButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteButton1.setSelected(false);
				athleteButton3.setSelected(false);
				athleteButton4.setSelected(false);	
				isAthleteSlotEmpty(1);			
			}
		});
		athleteButton2.setBounds(190, 20, 150, 150);
		setAthletePanel.add(athleteButton2);
		
		athleteButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteButton1.setSelected(false);
				athleteButton2.setSelected(false);
				athleteButton4.setSelected(false);
				isAthleteSlotEmpty(2);			
			}
		});
		athleteButton3.setBounds(360, 20, 150, 150);
		setAthletePanel.add(athleteButton3);
				
		athleteButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteButton1.setSelected(false);
				athleteButton2.setSelected(false);
				athleteButton3.setSelected(false);
				isAthleteSlotEmpty(3);			
			}
		});
		athleteButton4.setBounds(530, 20, 150, 150);
		setAthletePanel.add(athleteButton4);
			
		athleteButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteSwitchingNum2 = 4;
				athleteButton6.setSelected(false);
				athleteButton7.setSelected(false);
				isAthleteSlotEmpty(4);			
			}
		});
		athleteButton5.setBounds(20, 20, 150, 150);
		setReservePanel.add(athleteButton5);
			
		athleteButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteSwitchingNum2 = 5;
				athleteButton5.setSelected(false);
				athleteButton7.setSelected(false);
				isAthleteSlotEmpty(5);			
			}
		});
		athleteButton6.setBounds(190, 20, 150, 150);
		setReservePanel.add(athleteButton6);
			
		athleteButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteButton5.setSelected(false);
				athleteButton6.setSelected(false);
				isAthleteSlotEmpty(6);		

			}
		});
		athleteButton7.setBounds(360, 20, 150, 150);
		setReservePanel.add(athleteButton7);
		
		
		athleteLabel1 = new JLabel("Athlete 1 Name");
		athleteLabel1.setBounds(30, 182, 131, 16);
		setAthletePanel.add(athleteLabel1);
//		athleteLabel1.setText(printing(athleteList[0].getName().toString()));
		
		athleteLabel2 = new JLabel("Athlete 2 Name");
		athleteLabel2.setBounds(200, 182, 131, 16);
		setAthletePanel.add(athleteLabel2);
//		athleteLabel2.setText(athleteList[1].getName());
		
		athleteLabel3 = new JLabel("Athlete 3 Name");
		athleteLabel3.setBounds(370, 182, 131, 16);
		setAthletePanel.add(athleteLabel3);
//		athleteLabel3.setText(athleteList[2].getName());
	
		athleteLabel4 = new JLabel("Athlete 4 Name");
		athleteLabel4.setBounds(540, 182, 131, 16);
		setAthletePanel.add(athleteLabel4);
//		athleteLabel4.setText(athleteList[3].getName());
		
		athleteLabel5 = new JLabel("Athlete 5 Name");
		athleteLabel5.setBounds(30, 182, 131, 16);
		setReservePanel.add(athleteLabel5);
//		athleteLabel5.setText(athleteList[4].getName());
		
		athleteLabel6 = new JLabel("Athlete 6 Name");
		athleteLabel6.setBounds(200, 182, 131, 16);
		setReservePanel.add(athleteLabel6);
//		athleteLabel6.setText(athleteList[5].getName());
		
		athleteLabel7 = new JLabel("Athlete 7 Name");
		athleteLabel7.setBounds(370, 182, 131, 16);
		setReservePanel.add(athleteLabel7);
//		athleteLabel7.setText(athleteList[6].getName());
	}
	
	private void isAthleteSlotEmpty(int slotNum) {
		if (athleteList[slotNum] == null) {
			athleteDescriptionLabel.setText(printing("Empty Slot! <br/><br/> Recruite your athlete in market!"));
		}
		else {
			athleteSwitchingNum1 = slotNum;
			athleteDescriptionLabel.setText(printing(athleteList[slotNum].toString()));
		}		
	}
	
	private void isItemSlotEmpty(int slotNum) {
		if (itemList[slotNum] == null) {
			itemDescriptionLabel.setText(printing("Empty Slot! <br/><br/> Purchase items in market!"));
		}
		else {
			usingItemNum = slotNum;
			itemDescriptionLabel.setText(printing(itemList[slotNum].toString()));
		}	
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
			isItemSlotEmpty(0);
			cancelItemToggle();				
			itemButton1.setSelected(true);
		}
	});
	setItemPanel.add(itemButton1);
	
	itemButton2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			isItemSlotEmpty(1);
			cancelItemToggle();				
			itemButton2.setSelected(true);
		}
	});
	setItemPanel.add(itemButton2);
	
	itemButton3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			isItemSlotEmpty(2);
			cancelItemToggle();				
			itemButton3.setSelected(true);
		}
	});
	setItemPanel.add(itemButton3);
	
	itemButton4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			isItemSlotEmpty(3);			
			cancelItemToggle();				
			itemButton4.setSelected(true);
		}
	});
	setItemPanel.add(itemButton4);
	
	itemButton5.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			isItemSlotEmpty(4);
			cancelItemToggle();			
			itemButton5.setSelected(true);
		}
	});
	setItemPanel.add(itemButton5);
	
	itemButton6.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			isItemSlotEmpty(5);
			cancelItemToggle();				
			itemButton6.setSelected(true);
		}
	});
	setItemPanel.add(itemButton6);
	
	itemButton7.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			isItemSlotEmpty(6);
			cancelItemToggle();		
			itemButton7.setSelected(true);
		}
	});
	setItemPanel.add(itemButton7);
	
	itemButton8.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			isItemSlotEmpty(7);
			cancelItemToggle();		
			itemButton8.setSelected(true);
		}
	});
	setItemPanel.add(itemButton8);
	
	itemButton9.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			isItemSlotEmpty(8);
			cancelItemToggle();		
			itemButton9.setSelected(true);
		}
	});
	setItemPanel.add(itemButton9);
	
	itemButton10.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			isItemSlotEmpty(9);
			cancelItemToggle();
			itemButton10.setSelected(true);
		}
	});
	setItemPanel.add(itemButton10);	
	
	}

	private void cancelAhtleteToggle() {
		athleteButton1.setSelected(false);
		athleteButton2.setSelected(false);
		athleteButton3.setSelected(false);
		athleteButton4.setSelected(false);
		athleteButton5.setSelected(false);
		athleteButton6.setSelected(false);
		athleteButton7.setSelected(false);
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
		itemButton9.setSelected(false);
		itemButton10.setSelected(false);
	}

	/*
	 * set buttons on main screen
	 */
	private void setButton() {
		// close the main window and show market
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
		
		//close the main window and show stadium
		JButton stadiumButton = new JButton("Stadium");
		stadiumButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMainWindow.dispose();
				StadiumGui enterStadium = new StadiumGui(gameEnvironment);
				
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
				if (athleteSwitchingNum1 >= 0 && athleteSwitchingNum2 >= 0) {
					//Swap
				}
				cancelAhtleteToggle();
				athleteSwitchingNum1 = -1;
				athleteSwitchingNum2 = -1;
			}
		});
		switchButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		switchButton.setBounds(861, 480, 117, 78);
		frmMainWindow.getContentPane().add(switchButton);
		
		//make use button to use item to one athlete
		JButton itemUseButton = new JButton("Use");
		itemUseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//print select only one athlete
				if (athleteSwitchingNum1 >= 0 && athleteSwitchingNum2 >= 0) {
					noticeUsingSwitching.setText("Select One Athlete for using a item!");
				}
				//print select one item & one athlete
				else if (usingItemNum < 0 || (athleteSwitchingNum1 < 0 && athleteSwitchingNum2 < 0)){
					noticeUsingSwitching.setText("Select One Item and Athlete for each!");
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
				cancelAhtleteToggle();
				cancelItemToggle();	
				athleteSwitchingNum1 = -1;
				athleteSwitchingNum2 = -1;		
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
		
		itemDescriptionLabel = new JLabel("IncStat");
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
	
}
