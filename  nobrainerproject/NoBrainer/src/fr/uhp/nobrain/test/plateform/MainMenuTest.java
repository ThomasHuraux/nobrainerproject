package fr.uhp.nobrain.test.plateform;

import fr.uhp.nobrain.plateform.mainmenu.MainMenu;
import fr.uhp.nobrain.tools.Context;

public class MainMenuTest {

	public static void main(String[] args){
		MainMenu menu = new MainMenu();
		Context.create();
		Context.change(menu);
	}
}
