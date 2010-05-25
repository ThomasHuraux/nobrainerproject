package fr.uhp.nobrain.highscore;

public interface HSService {

	public void addEntry(ScoreControl s);
	public HighScoreView getTabView(int level);
	public HighScoreView getGraphView();
	
}
