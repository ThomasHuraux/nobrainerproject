package fr.uhp.nobrain.plateform;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JPanel;

import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;

public class LevelChooserView extends JPanel implements View{

	private static final long serialVersionUID = 1L;

	private JButton easy;
	private JButton medium;
	private JButton hard;
	
	public void initialize(Model model){
		
		easy = new JButton("EASY");
		medium = new JButton("MEDIUM");
		hard = new JButton("HARD");
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(3,1));
		buttons.add(easy);
		buttons.add(medium);
		buttons.add(hard);
		
		setLayout(new BorderLayout());
		add(buttons,BorderLayout.CENTER);
		
		model.attach(this);
		makeController();
	}

	public JButton getEasy() {
		return easy;
	}

	public JButton getMedium() {
		return medium;
	}

	public JButton getHard() {
		return hard;
	}

	@Override
	public void makeController() {
		LevelChooserController lcc = new LevelChooserController();
		lcc.initialize(null, this);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
