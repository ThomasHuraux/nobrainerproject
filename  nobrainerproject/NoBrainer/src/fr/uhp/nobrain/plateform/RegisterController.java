package fr.uhp.nobrain.plateform;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterController {
	
	private RegisterView view;

	public RegisterController(RegisterView v) {
		view = v;
		
		ActionListener al = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				// Treat OK
			}
			
		};
		
		view.getOk().addActionListener(al);
	}
}
