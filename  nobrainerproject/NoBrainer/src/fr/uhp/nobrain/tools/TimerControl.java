package fr.uhp.nobrain.tools;

import java.util.ArrayList;

import javax.swing.JPanel;

public class TimerControl extends Thread implements TimerInterface {
	private static final int REFRESH_DELAY = 1000;
	private int timeRemaining;
	private ArrayList<Observateur> listObservateur = new ArrayList<Observateur>();
	private TimerView view;
	private Thread t;
	private boolean run = true;
	
	public TimerControl() {
		t = new Thread(this);
	}
	
	@Override
	public void run() {
		
		while(run){
			if (this.timeRemaining -- == 1)
				run = false;
			
			this.updateObservateur();
			
			try {
				Thread.sleep(REFRESH_DELAY);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int exit() {
		this.run = false;
		return -1;
	}
	
	@Override
	public void start(int level) {
		this.timeRemaining = level;
		view = new TimerView(this);
		t.start();
	}

	public void addObservateur(Observateur obs) {
		this.listObservateur.add(obs);
	}

	public void delObservateur() {
		this.listObservateur = new ArrayList<Observateur>();
	}

	public void updateObservateur() {
		for(Observateur obs : this.listObservateur )
			obs.update(this.toString());
	}

	public int getTimeRemaining() {
		return timeRemaining;
	}

	@Override
	public JPanel getPanel() {
		return view.getPanel();
	}
	
	@Override
	public String toString() {
		return "" + timeRemaining;
	}
}
