package fr.uhp.nobrain.plateform;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import fr.uhp.nobrain.games.GameContext;
import fr.uhp.nobrain.mvc.Controller;
import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.Switcher;
import fr.uhp.nobrain.mvc.View;

public class LevelChooserController implements Controller{
	
	private LevelChooserView view;
	
	public void initialize(Model model, View v){
		view = (LevelChooserView) v;
		
		ActionListener alE = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				GameContext g = new GameContext();
				g.start(0);
				GameContainer gcc = new GameContainer(g);
				Switcher.change(gcc);
			}
		};
		ActionListener alM = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				GameContext g = new GameContext();
				g.start(1);
				GameContainer gcc = new GameContainer(g);
				Switcher.change(gcc);
			}
		};
		ActionListener alH = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				GameContext g = new GameContext();
				g.start(2);
				GameContainer gcc = new GameContainer(g);
				Switcher.change(gcc);
			}
		};
		
		
		view.getEasy().addActionListener(alE);
		view.getMedium().addActionListener(alM);
		view.getHard().addActionListener(alH);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
