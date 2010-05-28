package fr.uhp.nobrain.highscore;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;
import fr.uhp.nobrain.player.PlayerPersistance;

public class HighScoreView extends JPanel implements View{

	private static final long serialVersionUID = 1L;
	private static final String[] titles = {"Rank","Name","Score"};
	private JTable table;
	private HighScore model;
	
	private JButton returnB;
	
	public HighScoreView(HighScore model) {
		
		JTabbedPane pane = new JTabbedPane();
		for(int level=0;level<3;level++){
			
			ArrayList<Score> filter = new ArrayList<Score>();
			for(Score s : model.getScores())
				if(s.getLevel() == level)
					filter.add(s);
//			
//			Collections.sort(filter);
	
			Object[][] data = new Object[filter.size()][titles.length];
			for(int i = 0; i<filter.size(); i++){
				data[i][0] = i+1;
				try {
					data[i][1] = PlayerPersistance.select(model.getScores().get(i).getPlayerId()).getName();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				data[i][2] = model.getScores().get(i).getScore();
			}
			table = new JTable(data,titles);
			
			JScrollPane sp = new JScrollPane(table);
			pane.addTab("Level "+(level+1), sp);
		}
		
		returnB = new JButton("Return");
		
		setPreferredSize(new Dimension(290,440));
		setLayout(new BorderLayout());
;		add(pane,BorderLayout.CENTER);
		add(returnB,BorderLayout.SOUTH);
		
		makeController();
		
	}
	
	public JButton getReturnB(){
		return returnB;
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
