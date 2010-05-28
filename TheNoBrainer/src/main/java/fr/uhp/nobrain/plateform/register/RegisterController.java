package fr.uhp.nobrain.plateform.register;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JOptionPane;

import fr.uhp.nobrain.mvc.Controller;
import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;

import fr.uhp.nobrain.plateform.login.Login;
import fr.uhp.nobrain.player.Player;
import fr.uhp.nobrain.player.PlayerPersistance;
import fr.uhp.nobrain.tools.Context;


public class RegisterController implements Controller{
	
	private RegisterView view;

	public void initialize(Model model, View v){
		view = (RegisterView) v;
		
		ActionListener al = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(view.getLogin().getText().length() != 0
					&& view.getConfirm().getText().length() != 0
					&& view.getPass().getText().length() != 0
				){
					System.out.println(view.getLogin().getText());
					if (view.getPass().getText().equals(view.getConfirm().getText())) {
						Player player = new Player(view.getLogin().getText(), view.getPass().getText());
						try {
							PlayerPersistance.persist(player);
							Login login = new Login();
							Context.change(login);
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(view,e1,"Error",JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						}
					}
				}else JOptionPane.showMessageDialog(view,"Please fill all fields","Failed to register",JOptionPane.ERROR_MESSAGE);
			}
			
		};
		
		ActionListener alr = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				Context.change(l);
			}
			
		};
		
		view.getOk().addActionListener(al);
		view.getReturnB().addActionListener(alr);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
