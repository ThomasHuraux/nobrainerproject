package fr.uhp.nobrain.highscore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import fr.uhp.nobrain.mvc.Controller;
import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;
import fr.uhp.nobrain.plateform.mainmenu.MainMenu;
import fr.uhp.nobrain.tools.Context;

public class HighScoreController implements Controller {

	@Override
	public void initialize(final Model model, final View view) {
		
		((HighScoreView)view).getReturnB().addActionListener(new ActionListener(){
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
