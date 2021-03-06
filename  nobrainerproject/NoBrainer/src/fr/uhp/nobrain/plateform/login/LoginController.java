package fr.uhp.nobrain.plateform.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JOptionPane;

import fr.uhp.nobrain.mvc.Controller;
import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;
import fr.uhp.nobrain.plateform.mainmenu.MainMenu;
import fr.uhp.nobrain.plateform.register.Register;

import fr.uhp.nobrain.player.Player;
import fr.uhp.nobrain.player.PlayerPersistance;

import fr.uhp.nobrain.tools.Context;


public class LoginController implements Controller {

	private LoginView view;
	
	public void initialize(Model model, View v){
		view = (LoginView) v;
		
		ActionListener alOk = new ActionListener(){
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Player player = new Player(view.getNickname().getText(), view.getPass().getText());
				MainMenu mn;
				try {
					if (PlayerPersistance.select(player) != null) {
						Context.setCurrentPlayer(player);
						mn = new MainMenu();
						Context.change(mn);
					}else JOptionPane.showMessageDialog(view,"Wrong password or username","Please try again",JOptionPane.ERROR_MESSAGE);
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(view,e1,"Error",JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
					
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
