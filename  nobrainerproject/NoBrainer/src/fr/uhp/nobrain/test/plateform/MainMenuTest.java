package fr.uhp.nobrain.test.plateform;

import fr.uhp.nobrain.mvc.Switcher;
import fr.uhp.nobrain.plateform.MainMenu;

public class MainMenuTest {

	public static void main(String[] args){
		MainMenu menu = new MainMenu();
		Switcher.create();
		Switcher.change(menu);
	}
}
