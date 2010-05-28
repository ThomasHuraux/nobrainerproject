package fr.uhp.nobrain.plateform.container;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;

public class GameContainerView extends JPanel implements View{

	private static final long serialVersionUID = 1L;
	private GameContainer model;
	
	private JPanel timer;
	private JLabel score;
	private JLabel name;
	private JPanel games;
	
	public void initialize(Model m){
		this.model = (GameContainer) m;
		
		setPreferredSize(new Dimension(800,600));
		setLayout(new BorderLayout());
		
		JPanel north = new JPanel();
		north.setLayout(new GridLayout(1,2));
		north.setBackground(Color.black);
		
		name = new JLabel();
		score = new JLabel();
		
		games = model.getGameContext().getPanel();
		timer = model.getGameContext().getTimer().getView();
		score = new JLabel(model.getGameContext().getScore()+"");

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
		
		model.attach(this);
		makeController();
	
	}

	@Override
	public void makeController() {
		GameContainerController gcc = new GameContainerController();
		gcc.initialize(model, this);
	}

	@Override
	public void update(Observable o, Object arg) {
		name.setText(((GameContainer)o).getGameContext().getGameName());
		score.setText("Score : "+((GameContainer)o).getGameContext().getScore());
		if(((Boolean) arg).booleanValue()){
			games.removeAll();
			timer.removeAll();
			
			games = ((GameContainer)o).getGameContext().getPanel();
			timer = model.getGameContext().getTimer().getView();
			timer.setBackground(Color.black);
			
			add(games,BorderLayout.CENTER);
			add(timer,BorderLayout.SOUTH);
		}
	}

}
