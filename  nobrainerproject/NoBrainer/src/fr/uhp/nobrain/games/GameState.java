package fr.uhp.nobrain.games;

import javax.swing.JPanel;

import fr.uhp.nobrain.tools.TimerControl;

public interface GameState {
	public JPanel getPanel();
	public void start(int level);
	public int exit();
	public String getGameName();
	public TimerControl getTimer();
	public int getScore();
}
