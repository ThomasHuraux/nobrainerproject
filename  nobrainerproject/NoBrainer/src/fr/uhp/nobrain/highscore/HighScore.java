package fr.uhp.nobrain.highscore;

import java.awt.Container;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.plateform.container.GameContainerView;

public class HighScore extends Observable implements Model{
	
	private ArrayList<ScoreControl> scores;
	private HighScoreView view;

	public HighScore() {
		super();
		(new GameContainerView()).initialize(this);
	}

	public void addEntry(ScoreControl s) {
		scores.add(s);
	}

	public HighScoreView getGraphView() {
		return null;
	}

	public HighScoreView getTabView(int level) {
		return new HighScoreView(scores,level);
	}

	@Override
	public void attach(Observer o) {
		view = (HighScoreView) o;
		this.addObserver(o);
	}

	@Override
	public void detach(Observer o) {
		this.deleteObserver(o);
	}

	@Override
	public Container getView() {
		return view;
	}

}
