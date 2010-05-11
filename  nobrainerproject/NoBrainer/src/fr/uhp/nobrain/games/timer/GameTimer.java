package fr.uhp.nobrain.games.timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import fr.uhp.nobrain.games.GameContext;

public class GameTimer{

	private static final long serialVersionUID = 1L;
	
	private TimerView view;
	private Timer refresh;
	
	private int time = 0;
	private ActionListener updatePerformer;

	public JPanel getView () {
        return view;
    }

	public void start(final GameContext context){
		time = 0;
		
		if(view == null)
			view = TimerView.create(context.getGameState().getTimeRemaining());
		else
			view.reInit();
		
		updatePerformer = new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				time += TimerView.getRefreshDelay();
				view.update(time);
				
				if(time >= context.getGameState().getTimeRemaining()){
					context.stopGame();
				}
				
			}
		};
		
		refresh = new Timer(TimerView.getRefreshDelay(),updatePerformer);
		refresh.setRepeats(true);
		refresh.start();
	}

	public int getTime() {
		return time;
	}
	
	public void stop(){
		refresh.setRepeats(false);
		refresh.stop();
	}
	

}

