package fr.uhp.nobrain.plateform;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuController {

	@SuppressWarnings("unused")
	private MainMenuView view;
	
	public MainMenuController(MainMenuView view) {
		this.view = view;
		
		view.getLogoutButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("logout");
			}
		});
		
		view.getPlayButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("play");
			}
		});
		
		view.getStatsButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("stats");
			}
		});
		
		view.getFriendsButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("friends");
			}
		});
	}
}
