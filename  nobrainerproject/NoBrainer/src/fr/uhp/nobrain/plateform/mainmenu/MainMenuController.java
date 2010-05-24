package fr.uhp.nobrain.plateform.mainmenu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JFrame;

import fr.uhp.nobrain.games.GameContext;
import fr.uhp.nobrain.mvc.Controller;
import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.Switcher;
import fr.uhp.nobrain.mvc.View;
import fr.uhp.nobrain.plateform.levelchooser.LevelChooser;

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
				Switcher.change(lc);
			}
		});
		
		((MainMenuView) view).getStatsButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("stats");
			}
		});
		
		((MainMenuView) view).getFriendsButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("friends");
			}
		});
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	}
}
