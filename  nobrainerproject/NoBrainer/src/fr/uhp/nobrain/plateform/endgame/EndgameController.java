package fr.uhp.nobrain.plateform.endgame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import org.hibernate.Session;

import fr.uhp.nobrain.games.GameContext;
import fr.uhp.nobrain.highscore.Score;
import fr.uhp.nobrain.mvc.Controller;
import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;
import fr.uhp.nobrain.plateform.container.GameContainer;
import fr.uhp.nobrain.plateform.mainmenu.MainMenu;
import fr.uhp.nobrain.tools.Context;
import fr.uhp.nobrain.tools.HibernateUtil;

public class EndgameController implements Controller{

	@Override
	public void initialize(final Model model, View view) {
		((EndgameView) view).getReplay().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				GameContext g = new GameContext();
				g.start(((Endgame) model).getLevel());
				GameContainer gcc = new GameContainer(g);
				Context.change(gcc);
			}
		});
		
		((EndgameView) view).getQuit().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				MainMenu mm = new MainMenu();
				Context.change(mm);
			}
		});
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
