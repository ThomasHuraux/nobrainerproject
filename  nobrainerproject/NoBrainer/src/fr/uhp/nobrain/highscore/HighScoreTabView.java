package fr.uhp.nobrain.highscore;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JTable;

public class HighScoreTabView extends HighScoreView{

	private static final long serialVersionUID = 1L;
	private static final String[] titles = {"Rank","Name","Score"};
	private JTable table;
	
	@SuppressWarnings("unchecked")
	public HighScoreTabView(ArrayList<Score> scores,int level) {
		
		ArrayList<Score> filter = new ArrayList<Score>();
		for(Score s : scores)
			if(s.getLevel() == level)
				filter.add(s);
		
		Collections.sort(filter);
		
		Object[][] data = new Object[scores.size()][titles.length];
		for(int i = 0; i<filter.size(); i++){
			data[i][0] = i;
			data[i][1] = filter.get(i).getPlayerName();
			data[i][2] = filter.get(i).getScore();
		}
		table = new JTable(data,titles);
		
		add(table);
		
	}

}
