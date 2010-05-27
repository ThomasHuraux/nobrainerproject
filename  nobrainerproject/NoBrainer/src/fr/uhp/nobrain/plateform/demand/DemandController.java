package fr.uhp.nobrain.plateform.demand;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import fr.uhp.nobrain.mvc.Controller;
import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;

public class DemandController implements Controller {
	
	private Demand model;
	private DemandView view;
	
	public void initialize(Model m, View v) {
		this.model = (Demand)m;
		this.view = (DemandView)v;
		
		for(int i = 0;i<view.getAccepts().size();i++){
			@SuppressWarnings("unused")
			final int id = i;
			
			view.getAccepts().get(i).addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			
			view.getIgnores().get(i).addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					// Ignore with object fr.uhp.nobrain.friends.Decline
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
