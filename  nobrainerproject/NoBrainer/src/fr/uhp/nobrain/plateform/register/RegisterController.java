package fr.uhp.nobrain.plateform.register;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import fr.uhp.nobrain.mvc.Controller;
import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;

public class RegisterController implements Controller{
	
	private RegisterView view;

	public void initialize(Model model, View v){
		view = (RegisterView) v;
		
		ActionListener al = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				// Treat OK
			}
			
		};
		
		view.getOk().addActionListener(al);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
