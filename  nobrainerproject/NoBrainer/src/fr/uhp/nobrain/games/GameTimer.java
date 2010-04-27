package fr.uhp.nobrain.games;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GameTimer{

	private static final long serialVersionUID = 1L;
	
	private TimerView view;
	private Timer refresh;
	
	private int time = 0;

	public JPanel getView () {
        return view;
    }

	public void start(final GameContext context){
		view = TimerView.create(context.getGameState().getTimeRemaining());
		
		ActionListener updatePerformer = new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				time += TimerView.getRefreshDelay();
				view.update(time);
				
				if(time >= context.getGameState().getTimeRemaining())
					context.stopGame();
			}
		};
		
		refresh = new Timer(TimerView.getRefreshDelay(),updatePerformer);
		refresh.setRepeats(true);
		refresh.start();
	}

}

