package fr.uhp.nobrain.highscore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

import javax.swing.JPanel;
import javax.swing.JTable;

import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;

public class HighScoreView extends JPanel implements View{

	private static final long serialVersionUID = 1L;
	private static final String[] titles = {"Rank","Name","Score"};
	private JTable table;
	private HighScore model;
	
	public HighScoreView(ArrayList<ScoreControl> scores,int level) {
		
		ArrayList<ScoreControl> filter = new ArrayList<ScoreControl>();
		for(ScoreControl s : scores)
			if(s.getScoreModel().getLevel() == level)
				filter.add(s);
		
		Collections.sort(filter);
		
		Object[][] data = new Object[scores.size()][titles.length];
		for(int i = 0; i<filter.size(); i++){
			data[i][0] = i;
			data[i][1] = filter.get(i).getScoreModel().getPlayerId();
			data[i][2] = filter.get(i).getScore();
		}
		table = new JTable(data,titles);
		
		add(table);
		
	}

	@Override
	public void initialize(Model model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void makeController() {
		HighScoreController hsc = new HighScoreController();
		hsc.initialize(model, this);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
