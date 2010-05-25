package fr.uhp.nobrain.plateform.register;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import fr.uhp.nobrain.mvc.Controller;
import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;
import fr.uhp.nobrain.player.Player;
import fr.uhp.nobrain.player.PlayerPersistance;

public class RegisterController implements Controller{
	
	private RegisterView view;

	public void initialize(Model model, View v){
		view = (RegisterView) v;
		
		ActionListener al = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				if (view.getPass().getText().equals(view.getConfirm().getText())) {
					Player player = new Player(view.getName(), view.getPass().getText());
					try {
						PlayerPersistance.persist(player);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
		};
		
		view.getOk().addActionListener(al);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
