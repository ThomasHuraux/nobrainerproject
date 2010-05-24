package fr.uhp.nobrain.games;

import javax.swing.JPanel;

public interface GameState {
	public JPanel getPanel();
	public void start(int level);
	public int exit();
	public String getGameName();
	public int getTime();
	public int getScore();
}
