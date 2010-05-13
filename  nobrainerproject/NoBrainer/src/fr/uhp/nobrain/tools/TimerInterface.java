package fr.uhp.nobrain.tools;

import javax.swing.JPanel;

public interface TimerInterface {
	public JPanel getPanel();
	public void start(int level);
	public int exit();
}
