package fr.uhp.nobrain.highscore;

import java.util.ArrayList;

public class HighScore extends HSService{
	
	private ArrayList<Score> scores;

	@Override
	public void addEntry(Score s) {
		scores.add(s);
	}

	@Override
	public HighScoreView getGraphView() {
		return null;
	}

	@Override
	public HighScoreView getTabView(int level) {
		return new HighScoreTabView(scores,level);
	}

}
