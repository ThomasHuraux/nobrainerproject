package fr.uhp.nobrain.plateform.container;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.Timer;

import fr.uhp.nobrain.games.StateTransition;
import fr.uhp.nobrain.mvc.Controller;
import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;
import fr.uhp.nobrain.plateform.endgame.Endgame;
import fr.uhp.nobrain.tools.Context;


public class GameContainerController implements Controller{
	
	private int last;
	
	public void initialize(final Model model, final View view) {
		
		final Timer refresh = new Timer(1000,null);
		last = StateTransition.list.size();

		ActionListener updatePerformer = new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(last==0 && !((GameContainer)model).getGameContext().getTimer().isRun()){
					refresh.stop();
					Endgame eg = new Endgame(((GameContainer)model).getGameContext().getTotalScore(),((GameContainer)model).getGameContext().getLevel());
					Context.change(eg);
				}
				if(last != StateTransition.list.size()){
					if(((GameContainer)model).getGameContext().getPanel() != null){
						last = StateTransition.list.size();
						((GameContainerView)view).update((Observable) model,true);
					}
				}else
					((GameContainerView)view).update((Observable) model,false);
			}
		};
		
		refresh.addActionListener(updatePerformer);
		refresh.start();
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
