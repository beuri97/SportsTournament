package main.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ImprovingAthleteGui {

	private JFrame frmImproving;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImprovingAthleteGui window = new ImprovingAthleteGui();
					window.frmImproving.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ImprovingAthleteGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmImproving = new JFrame();
		frmImproving.setBounds(100, 100, 700, 600);
		frmImproving.setLocation((1925 - frmImproving.getWidth()) / 2, (1080 - frmImproving.getHeight()) / 2);
		frmImproving.getContentPane().setLayout(null);
		
		JButton improveButton = new JButton("Improve!");
		improveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		improveButton.setFont(new Font("Dialog", Font.BOLD, 20));
		improveButton.setBounds(391, 482, 254, 60);
		frmImproving.getContentPane().add(improveButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(48, 55, 281, 441);
		frmImproving.getContentPane().add(panel);
		panel.setLayout(new GridLayout(7, 1, 0, 0));
		
		JButton athlete1 = new JButton("athlete1");
		athlete1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(athlete1);
		
		JButton athlete2 = new JButton("athlete2");
		athlete2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(athlete2);
		
		JButton athlete3 = new JButton("athlete3");
		athlete3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(athlete3);
		
		JButton athlete4 = new JButton("athlete4");
		athlete4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(athlete4);
		
		JButton athlete5 = new JButton("athlete5");
		athlete5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(athlete5);
		
		JButton athlete6 = new JButton("athlete6");
		athlete6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(athlete6);
		
		JButton athlete7 = new JButton("athlete7");
		athlete7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(athlete7);
		
		JPanel setAthleteInfoPanel = new JPanel();
		setAthleteInfoPanel.setLayout(null);
		setAthleteInfoPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		setAthleteInfoPanel.setBounds(367, 99, 287, 371);
		frmImproving.getContentPane().add(setAthleteInfoPanel);
		
		JLabel athleteInfoTitleLabel = new JLabel("<<Athelte Information>>");
		athleteInfoTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		athleteInfoTitleLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		athleteInfoTitleLabel.setBounds(12, 12, 271, 20);
		setAthleteInfoPanel.add(athleteInfoTitleLabel);
		
		JLabel lblChooseOneAthlete = new JLabel("<html>Your team has been trained for a week! You can pick one athlete to improve significantly!</html>");
		lblChooseOneAthlete.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblChooseOneAthlete.setBounds(22, 44, 253, 306);
		setAthleteInfoPanel.add(lblChooseOneAthlete);

	}
}
