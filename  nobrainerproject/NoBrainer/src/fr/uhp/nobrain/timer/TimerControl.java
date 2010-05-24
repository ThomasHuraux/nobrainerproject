package fr.uhp.nobrain.timer;

import java.util.Observable;

import fr.uhp.nobrain.mvc.Controller;
import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;


public class TimerControl implements Controller {

	private GameTimer model;

	private Thread t;
	
	public int exit() {
		((GameTimer)model).run = false;
		return -1;
	}

	public void start() {
		t.start();
	}

	@Override
	public void initialize(final Model m, final View view) {
		this.model = (GameTimer) m;
		t = new Thread(){
			@SuppressWarnings("static-access")
			public void run(){
				while(model.isRun()){
					if (model.timeRemaining-- == 1)
						((GameTimer)model).setRun(false);
					
					view.update((Observable) model,null);
					
					try {
						int refreshDelay = model.getRefreshDelay();
						Thread.sleep(refreshDelay);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	}
}
