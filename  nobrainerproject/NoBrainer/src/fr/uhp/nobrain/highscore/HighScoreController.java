package fr.uhp.nobrain.highscore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.Timer;

import fr.uhp.nobrain.mvc.Controller;
import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;

public class HighScoreController implements Controller {

	@Override
	public void initialize(final Model model, final View view) {
		ActionListener updatePerformer = new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				((HighScoreView)view).update((Observable) model,null);
			}
		};
		
		Timer refresh = new Timer(1000,updatePerformer);
		refresh.start();
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

}