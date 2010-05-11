package fr.uhp.nobrain.games.timer;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class TimerView extends JPanel{

	private static final long serialVersionUID = 1L;
	private static final int REFRESH_DELAY = 1000;

	
	private JProgressBar progress;

	private TimerView(int size) {
		super();
		
		this.progress = new JProgressBar(0,size);
		add(progress);

	}
	
	public void reInit(){
		progress.setValue(0);
	}
	
	public static TimerView create(int size){
		return new TimerView(size);
	}
	
	public void update(int val){
		progress.setValue(val);
	}

	public JProgressBar getProgress() {
		return progress;
	}

	public static int getRefreshDelay() {
		return REFRESH_DELAY;
	}
	
	public void setColor(Color c){
		progress.setBackground(c);
	}
	
	
}
