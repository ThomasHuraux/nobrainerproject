package fr.uhp.nobrain.plateform;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameContainerView extends JPanel{

	private static final long serialVersionUID = 1L;
	private GameContainerController control;
	
	private JPanel timer;
	private JLabel score;
	private JLabel name;
	private JPanel games;
	
	public GameContainerView(GameContainerController control){
		this.control = control;
		
		setPreferredSize(new Dimension(800,600));
		setLayout(new BorderLayout());
		
		JPanel north = new JPanel();
		north.setLayout(new GridLayout(1,2));
		north.setBackground(Color.black);
		
		name = new JLabel();
		score = new JLabel();
		
		refresh();
		
		games = control.getGameContext().getPanel();
		timer = control.getGameContext().getTimer().getPanel();
		score = control.getGameContext().getScoreLabel();

		name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		name.setForeground(Color.white);
		north.add(name);
		
		score.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		score.setForeground(Color.white);
		north.add(score);
		
		timer.setBackground(Color.black);
		
		add(timer,BorderLayout.SOUTH);
		add(north,BorderLayout.NORTH);
		add(games,BorderLayout.CENTER);
	
	}
	
	public void refresh(){
		name.setText(control.getGameContext().getGameName());
		score.setText("Score : "+control.getGameContext().getScore());
	}

}
