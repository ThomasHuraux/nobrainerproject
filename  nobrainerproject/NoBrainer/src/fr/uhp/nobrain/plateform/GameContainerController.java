package fr.uhp.nobrain.plateform;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;


public class GameContainerController {
	
	private GameContainer model;
	private GameContainerView view;
	
	public GameContainerController(final GameContainer m,final GameContainerView v){
		this.model = m;
		this.view = v;
		
		ActionListener updatePerformer = new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				view.refresh();
			}
		};
		
		Timer refresh = new Timer(1000,updatePerformer);
		refresh.start();
	}

}
