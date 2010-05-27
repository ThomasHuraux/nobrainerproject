package fr.uhp.nobrain.plateform.endgame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;

public class EndgameView extends JPanel implements View{

	private static final long serialVersionUID = 1L;

	private Model model;


	private JButton replay;
	private JButton quit;
	
	private JLabel score;
	
	public void initialize(Model model){

		this.model = model;
		
		score = new JLabel("Your score : "+((Endgame)model).getScore()+" pts");
		Font f = new Font("Arial", Font.PLAIN, 60);
		score.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		score.setFont(f);
		score.setForeground(Color.LIGHT_GRAY);
		
		replay = new JButton("Play again");
		quit = new JButton("Back to menu");
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(2,1));
		buttons.add(replay);
		buttons.add(quit);
		buttons.setBackground(Color.BLACK);
		
		
		
		JPanel center = new JPanel();
		center.setLayout(new BorderLayout());
		center.setPreferredSize(new Dimension(700,500));
		center.add(score,BorderLayout.CENTER);
		center.add(buttons,BorderLayout.SOUTH);
		center.setBackground(Color.BLACK);
		
		setPreferredSize(new Dimension(800,600));
		setBackground(Color.BLACK);
		add(center);

		model.attach(this);
		makeController();
	}

	public JButton getReplay() {
		return replay;
	}

	public JButton getQuit() {
		return quit;
	}

	public JLabel getScore() {
		return score;
	}

	public void makeController() {
		EndgameController mmc = new EndgameController();
		mmc.initialize(model, this);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}


}
