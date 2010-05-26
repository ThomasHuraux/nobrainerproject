package fr.uhp.nobrain.plateform.endgame;

import java.util.Observable;
import java.util.Observer;

import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;

public class Endgame extends Observable implements Model{

	private View view;
	private int score;
	private int level;
	
	public Endgame(int score,int level){
		this.score = score;
		this.level = level;
		(new EndgameView()).initialize(this);
	}
	
	public void attach(Observer v) {
		view = (View) v;
		this.addObserver(view);
	}

	public void detach(Observer o) {
		this.deleteObserver(view);
	}

	public EndgameView getView() {
		return (EndgameView) view;
	}

	public int getScore() {
		return score;
	}

	public int getLevel() {
		return level;
	}

}
