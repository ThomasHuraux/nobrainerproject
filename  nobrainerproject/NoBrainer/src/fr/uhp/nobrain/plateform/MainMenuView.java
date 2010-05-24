package fr.uhp.nobrain.plateform;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;

public class MainMenuView extends JPanel implements View{

	private static final long serialVersionUID = 1L;
	
	private Model model;

	private JLabel logo;

	private JButton logoutButton;
	private JButton statsButton;
	private JButton friendsButton;
	private JButton playButton;

	
	public void initialize(Model model){

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
		
		String imgPath = ((MainMenu) model).getLogoPath();
		logo = new JLabel(new ImageIcon(imgPath));
		
		setPreferredSize(new Dimension(302,483));
		
		setLayout(new BorderLayout());
		add(logo,BorderLayout.CENTER);
		add(buttons,BorderLayout.SOUTH);

		model.attach(this);
		makeController();
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

	public void makeController() {
		MainMenuController mmc = new MainMenuController();
		mmc.initialize(model, this);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}


}
