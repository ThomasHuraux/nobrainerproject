package fr.uhp.nobrain.plateform;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LevelChooserView extends JPanel{

	private static final long serialVersionUID = 1L;

	private JButton easy;
	private JButton medium;
	private JButton hard;
	
	public LevelChooserView(){
		
		easy = new JButton("EASY");
		medium = new JButton("MEDIUM");
		hard = new JButton("HARD");
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(3,1));
		buttons.add(easy);
		buttons.add(medium);
		buttons.add(hard);
		
		setLayout(new BorderLayout());
		add(new JLabel("Choose a difficulty :"),BorderLayout.CENTER);
		add(buttons,BorderLayout.SOUTH);
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
}
