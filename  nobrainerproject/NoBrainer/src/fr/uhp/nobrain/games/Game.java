package fr.uhp.nobrain.games;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class Game {

	private int level;
	private Timer timer;
	private int timeRemaining;
	private JComponent view;
	private final JLabel lbl;
	
	public Game() {
		this.timer = initCountDown();
		this.timeRemaining = 45;
	
		view = new JPanel();
		lbl = new JLabel(String.valueOf(timeRemaining));
	}
	
	public Game(int level) {
		this.level = level;
		this.timer = initCountDown();
		this.timeRemaining = chooseTime();
	
		view = new JPanel();
		lbl = new JLabel(String.valueOf(timeRemaining));
	}

	public abstract JComponent getView();
	public abstract boolean validateAnswer();

	private int chooseTime() {
		switch (level) {
		case 0 : return (timeRemaining = 60);
		case 1 : return (timeRemaining = 45);
		default : return (timeRemaining = 30);
		}
	}
	
	private Timer initCountDown() {
		return timer = new Timer(
							1000, 
							new ActionListener() {
			
								@Override
								public void actionPerformed(ActionEvent e) {
									if (--timeRemaining > 0) {
										lbl.setText(String.valueOf(timeRemaining));
									} else {
										lbl.setText("Finish !");
										timer.stop();
									}
								}
							}
						);
	}

	public void play() {
		timer.start();
	}
}
