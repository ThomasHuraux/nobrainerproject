package fr.uhp.nobrain.highscore;
import java.util.ArrayList;

import javax.swing.JPanel;

import fr.uhp.nobrain.tools.Observable;
import fr.uhp.nobrain.tools.Observateur;


public class Score extends Thread implements Observable, java.lang.Comparable<Score> {
	private static final int REFRESH_DELAY = 5000;
	private int score = 0;
	private int level;
	private String name;
	private boolean run = true;
	private ArrayList<Observateur> listObservateur = new ArrayList<Observateur>();
	private ScoreView view;
	
	public Score(){
		super();
		view = new ScoreView(this);
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
	
	public JPanel getPanel() {
		return view.getPanel();
	}
	
	public void addObservateur(Observateur obs) {
		this.listObservateur.add(obs);
	}

	public void delObservateur() {
		this.listObservateur = new ArrayList<Observateur>();
	}

	public void updateObservateur() {
		String s = Integer.toString(score);
		for(Observateur obs : this.listObservateur )
			obs.update(s);
	}

	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public String getPlayerName() {
		return name;
	}
	
	public void setPlayerName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Score other) {
		 int n1 = other.getScore(); 
	     int n2 = this.getScore(); 
	     if (n1 > n2)  return -1;
	     else if(n1 == n2) return 0; 
	     else return 1; 
	}

	@Override
	public String toString() {
		return "score = " + score;
	}	
}
