package fr.uhp.nobrain.games;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class TimerView extends JPanel{

	private static final long serialVersionUID = 1L;
	private static final int REFRESH_DELAY = 1000;
	private static final int DEFAULT_W = 120;
	private static final int DEFAULT_H = 20;
	
	private JProgressBar progress;
	
	private int width;
	private int height;
	
	private TimerView(int size) {
		super();
		
		this.width = DEFAULT_W;
		this.height = DEFAULT_H;
		
		this.progress = new JProgressBar(0,size);
		add(progress);
		
		progress.setPreferredSize(new Dimension(width,height));
		setPreferredSize(new Dimension(width,height));
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public static int getRefreshDelay() {
		return REFRESH_DELAY;
	}
	
	public void setColor(Color c){
		progress.setBackground(c);
	}
	
	
}
