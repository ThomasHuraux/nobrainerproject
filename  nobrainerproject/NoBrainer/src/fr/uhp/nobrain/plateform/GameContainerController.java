package fr.uhp.nobrain.plateform;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import fr.uhp.nobrain.games.GameContext;


public class GameContainerController {
	
	private GameContext context;
	private GameContainerView view;
	
	public GameContainerController(GameContext context){
		this.context = context;

		this.view = new GameContainerView(this);

		ActionListener updatePerformer = new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				view.refresh();
			}
		};
		
		Timer refresh = new Timer(1000,updatePerformer);
		refresh.start();
	}
	
	public GameContext getGameContext() {
		return context;
	}
	
	public GameContainerView getView() {
		return view;
	}

}
