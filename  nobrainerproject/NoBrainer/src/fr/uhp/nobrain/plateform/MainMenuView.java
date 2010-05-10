package fr.uhp.nobrain.plateform;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenuView extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private MainMenu model;
	
	private JLabel logo;
	private JButton logoutButton;
	private JButton statsButton;
	private JButton friendsButton;
	private JButton playButton;
	
	public MainMenuView(MainMenu model){
		
		this.model = model;
		
		logoutButton = new JButton("Logout");
		statsButton = new JButton("Stats");
		friendsButton = new JButton("Friends");
		playButton = new JButton("Play");
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(4,1));
		buttons.add(playButton);
		buttons.add(statsButton);
		buttons.add(friendsButton);
		buttons.add(logoutButton);
		
		String imgPath = model.getLogoPath();
		logo = new JLabel(new ImageIcon(imgPath));
		//logo.setPreferredSize(new Dimension(302,323));
		
		setLayout(new BorderLayout());
		add(logo,BorderLayout.CENTER);
		add(buttons,BorderLayout.SOUTH);
	}

	public JLabel getLogo() {
		return logo;
	}

	public JButton getLogoutButton() {
		return logoutButton;
	}

	public JButton getStatsButton() {
		return statsButton;
	}

	public JButton getFriendsButton() {
		return friendsButton;
	}

	public JButton getPlayButton() {
		return playButton;
	}

}
