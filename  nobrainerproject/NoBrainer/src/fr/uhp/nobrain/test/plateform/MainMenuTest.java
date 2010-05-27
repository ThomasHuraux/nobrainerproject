package fr.uhp.nobrain.test.plateform;

import fr.uhp.nobrain.plateform.login.Login;
import fr.uhp.nobrain.plateform.mainmenu.MainMenu;
import fr.uhp.nobrain.plateform.register.Register;
import fr.uhp.nobrain.tools.Context;

public class MainMenuTest {

	public static void main(String[] args){
		Login r =  new Login();
		MainMenu mm = new MainMenu();
		Context.create();
		Context.change(r);
	}
}
