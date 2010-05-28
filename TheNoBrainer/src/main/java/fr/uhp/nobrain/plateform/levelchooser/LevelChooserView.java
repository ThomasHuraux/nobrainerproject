package fr.uhp.nobrain.plateform.levelchooser;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;

public class LevelChooserView extends JPanel implements View{

	private static final long serialVersionUID = 1L;

	private JButton easy;
	private JButton medium;
	private JButton hard;
	
	private JLabel logo;
	
	public void initialize(Model model){
		
		easy = new JButton("EASY");
		medium = new JButton("MEDIUM");
		hard = new JButton("HARD");
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(3,1));
		buttons.add(easy);
		buttons.add(medium);
		buttons.add(hard);
		
		String imgPath = ((LevelChooser) model).getLogoPath();
		logo = new JLabel(new ImageIcon(imgPath));
		
		setLayout(new BorderLayout());
		add(logo,BorderLayout.CENTER);
		add(buttons,BorderLayout.SOUTH);
		
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
