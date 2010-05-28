package fr.uhp.nobrain.timer;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import fr.uhp.nobrain.games.GameContext;
import fr.uhp.nobrain.mvc.Model;

public class GameTimer extends Observable implements Model{

	private static final int REFRESH_DELAY = 1000;
	
	private GameContext game;
	
	private TimerView view;
	protected TimerControl controller;
	
	protected int timeRemaining;
	protected boolean run = true;

	public void start(GameContext game) {
		this.game = game;
		timeRemaining = game.getGameState().getTime();
		(new TimerView()).initialize(this);
		run = true;
	}
	
	public void stop(){
		controller.stop();
		run = false;
	}
	
	@Override
	public void attach(Observer o) {
		view = (TimerView) o;
		this.addObserver(o);
	}

	@Override
	public void detach(Observer o) {
		this.deleteObserver(o);
	}

	public static int getRefreshDelay() {
		return REFRESH_DELAY;
	}

	public int getTimeRemaining() {
		return timeRemaining;
	}

	public String toString() {
		return "" + timeRemaining;
	}
	
	public JPanel getView() {
		return view;
	}

	public void setRun(boolean run){
		this.run = run;
		if(!run)
			game.stopGame();
	}

	public boolean isRun() {
		return run;
	}
}
