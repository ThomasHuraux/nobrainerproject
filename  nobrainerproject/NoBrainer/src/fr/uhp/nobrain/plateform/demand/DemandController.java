package fr.uhp.nobrain.plateform.demand;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import fr.uhp.nobrain.friends.FriendsServer;
import fr.uhp.nobrain.friends.Invitation;
import fr.uhp.nobrain.mvc.Controller;
import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;
import fr.uhp.nobrain.player.PlayerPersistance;
import fr.uhp.nobrain.tools.Context;

public class DemandController implements Controller {
	
	private Demand model;
	private DemandView view;
	
	public void initialize(Model m, View v) {
		this.model = (Demand)m;
		this.view = (DemandView)v;
		
		for(int i = 0;i<view.getAccepts().size();i++){
			final int id = i;
			
			view.getAccepts().get(i).addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					try {
						Invitation inv = new Invitation(
								PlayerPersistance.select(view.getAccepts().get(id).getText()),
								Context.getCurrentPlayer());
						FriendsServer.accept(inv);
						view.getAccepts().get(id).setEnabled(false);
						view.getAccepts().get(id).setText("Accepted");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
			view.getIgnores().get(i).addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					try {
						Invitation inv = new Invitation(
								PlayerPersistance.select(view.getAccepts().get(id).getText()),
								Context.getCurrentPlayer());
						FriendsServer.decline(inv);
						view.getAccepts().get(id).setEnabled(false);
						view.getAccepts().get(id).setText("Declined");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		
		view.getQuit().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// Return to menu
			}
		});
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	public void setModel(Demand model) {
		this.model = model;
	}

	public Demand getModel() {
		return model;
	}

}
