package fr.uhp.nobrain.highscore;

public abstract class HSService {

	public abstract void addEntry(ScoreControl s);
	public abstract HighScoreView getTabView(int level);
	public abstract HighScoreView getGraphView();
	
}
