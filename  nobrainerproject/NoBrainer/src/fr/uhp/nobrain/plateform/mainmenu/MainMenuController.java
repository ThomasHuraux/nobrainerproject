package fr.uhp.nobrain.plateform.mainmenu;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import fr.uhp.nobrain.mvc.Controller;
import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;
import fr.uhp.nobrain.plateform.friendsmenu.FriendsMenu;
import fr.uhp.nobrain.plateform.levelchooser.LevelChooser;
import fr.uhp.nobrain.tools.Context;

public class MainMenuController implements Controller{


	@Override
	public void initialize(Model model, View view) {
		((MainMenuView) view).getLogoutButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("logout");
				System.exit(0);
			}
		});
		
		((MainMenuView) view).getPlayButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				LevelChooser lc = new LevelChooser();
				Context.change(lc);
			}
		});
		
		((MainMenuView) view).getStatsButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("stats");
			}
		});
		
		((MainMenuView) view).getFriendsButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				FriendsMenu fm = new FriendsMenu();
				Context.change(fm);
			}
		});
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	}
}
