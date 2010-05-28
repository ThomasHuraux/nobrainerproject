package fr.uhp.nobrain.plateform;

import fr.uhp.nobrain.plateform.login.Login;
import fr.uhp.nobrain.plateform.mainmenu.MainMenu;
import fr.uhp.nobrain.tools.Context;

public class Plateforme {

	public static void main(String[] args){
		Login r =  new Login();
		MainMenu mm = new MainMenu();
		Context.create();
		Context.change(r);
	}
}
