package fr.uhp.nobrain.plateform.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import fr.uhp.nobrain.mvc.Controller;
import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;
import fr.uhp.nobrain.plateform.register.Register;
import fr.uhp.nobrain.tools.Context;

public class LoginController implements Controller {

	private LoginView view;
	
	public void initialize(Model model, View v){
		view = (LoginView) v;
		
		ActionListener alOk = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				// Treat OK
			}
			
		};
		
		view.getOk().addActionListener(alOk);
		
		ActionListener alCre = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Register reg = new Register();
				Context.change(reg);
			}
			
		};
		
		view.getCreate().addActionListener(alCre);
	}


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
