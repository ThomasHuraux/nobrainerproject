package fr.uhp.nobrain.plateform;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemandController {
	
	private Demand model;
	private DemandView view;
	
	public DemandController(Demand m, DemandView v) {
		this.model = m;
		this.view = v;
		
		for(int i = 0;i<view.getAccepts().size();i++){
			final int id = i;
			
			view.getAccepts().get(i).addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					// Accept with object fr.uhp.nobrain.friends.Accept
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

}
