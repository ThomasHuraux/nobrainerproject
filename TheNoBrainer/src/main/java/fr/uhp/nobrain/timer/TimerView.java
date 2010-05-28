package fr.uhp.nobrain.timer;

import java.util.Observable;

import javax.swing.JPanel;
import javax.swing.JProgressBar;

import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;


public class TimerView extends JPanel implements View{
	private static final long serialVersionUID = 1L;
	
	private GameTimer timer;
	private JProgressBar progress;

	public String toString() {
		return timer.toString();
	}

	@Override
	public void initialize(Model model) {
		timer = (GameTimer) model;
		this.progress = new JProgressBar(0,timer.getTimeRemaining());
		
		add(progress);
		
		timer.attach(this);
		makeController();
	}

	@Override
	public void makeController() {
		TimerControl tc = new TimerControl();
		tc.initialize(timer,this);
		timer.controller = tc;
	}

	@Override
	public void update(Observable o, Object arg) {
		progress.setValue(((GameTimer)o).getTimeRemaining());
	}
}
