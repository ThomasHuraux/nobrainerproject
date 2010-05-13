package fr.uhp.nobrain.tools;

import javax.swing.JPanel;
import javax.swing.JProgressBar;


public class TimerView {
	private static final long serialVersionUID = 1L;
	
	private TimerControl control;
	private JPanel panel;
	private JProgressBar progress;

	public TimerView(TimerControl control) {
		super();
		this.panel = new JPanel();
		this.control = control;
		this.progress = new JProgressBar(0,control.getTimeRemaining());
		
		this.control.addObservateur(new Observateur(){
			@Override
			public void update(String s) {
				progress.setValue(Integer.valueOf(s));
			}
		});

		this.panel.add(progress);
	}
	
	public JPanel getPanel() {
		return panel;
	}

	public String toString() {
		return control.toString();
	}
}
