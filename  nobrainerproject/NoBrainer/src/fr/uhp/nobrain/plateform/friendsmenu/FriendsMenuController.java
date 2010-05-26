package fr.uhp.nobrain.plateform.friendsmenu;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import fr.uhp.nobrain.mvc.Controller;
import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;
import fr.uhp.nobrain.plateform.demand.Demand;
import fr.uhp.nobrain.plateform.mainmenu.MainMenu;
import fr.uhp.nobrain.plateform.playerinvite.PlayerInvite;
import fr.uhp.nobrain.tools.Context;

public class FriendsMenuController implements Controller{


	@Override
	public void initialize(Model model, View view) {
		((FriendsMenuView) view).getFriendButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		((FriendsMenuView) view).getDemandButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Demand d;
				try {
					d = new Demand();
					Context.change(d);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		((FriendsMenuView) view).getInvitationsButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				PlayerInvite pi;
				try {
					pi = new PlayerInvite();
					Context.change(pi);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		((FriendsMenuView) view).getReturnButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				MainMenu mm = new MainMenu();
				Context.change(mm);
			}
		});
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	}
}
