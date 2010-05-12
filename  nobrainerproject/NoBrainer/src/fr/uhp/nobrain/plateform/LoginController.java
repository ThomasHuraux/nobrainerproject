package fr.uhp.nobrain.plateform;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {

	private LoginView view;
	
	public LoginController(LoginView v){
		view = v;
		
		ActionListener alOk = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				// Treat OK
			}
			
		};
		
		view.getOk().addActionListener(alOk);
		
		ActionListener alCre = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				// Treat Create
			}
			
		};
		
		view.getCreate().addActionListener(alCre);
	}
}
