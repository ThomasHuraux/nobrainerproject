package fr.uhp.nobrain.highscore;
import java.util.ArrayList;

import fr.uhp.nobrain.tools.Observable;
import fr.uhp.nobrain.tools.Observateur;


public class ScoreControl extends Thread implements Observable, java.lang.Comparable<ScoreControl> {
	private static final int REFRESH_DELAY = 5000;
	private ScoreModel scoreModel;
	private boolean run = true;
	private ArrayList<Observateur> listObservateur = new ArrayList<Observateur>();
	
	
	
	public ScoreControl() {
		super();
		this.scoreModel = new ScoreModel();
	}

	public ScoreControl(ScoreModel sm){
		super();
		this.scoreModel = sm;
	}
	
	public void run() {
		while(run){
			this.updateObservateur();
			
			try {
				Thread.sleep(REFRESH_DELAY);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void exit() {
		this.run = false;
	}

	public void addObservateur(Observateur obs) {
		this.listObservateur.add(obs);
	}

	public void delObservateur() {
		this.listObservateur = new ArrayList<Observateur>();
	}

	public void updateObservateur() {
		for(Observateur obs : this.listObservateur )
			obs.update(this);
	}

	public ScoreModel getScoreModel() {
		return scoreModel;
	}

	public void setScoreModel(ScoreModel sm) {
		this.scoreModel = sm;
	}	
	
	public int getScore() {
		return this.scoreModel.getScore();
	}
	
	public void setScore(int score) {
		this.scoreModel.setScore(score);
	}

	@Override
	public int compareTo(ScoreControl other) {
		 int n1 = other.getScoreModel().getScore(); 
	     int n2 = this.scoreModel.getScore(); 
	     if (n1 > n2)  return -1;
	     else if(n1 == n2) return 0; 
	     else return 1; 
	}

	@Override
	public String toString() {
		return ""+this.scoreModel.getScore();
	}
}
