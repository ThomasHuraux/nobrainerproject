package fr.uhp.nobrain.test.plateform;

import javax.swing.JFrame;

import fr.uhp.nobrain.plateform.MainMenu;
import fr.uhp.nobrain.plateform.MainMenuController;
import fr.uhp.nobrain.plateform.MainMenuView;

public class MainMenuTest {

	public static void main(String[] args){
		MainMenu menu = new MainMenu();
		menu.setLogoPath("img/nobrainer.png");
		MainMenuView view = new MainMenuView(menu);
		MainMenuController controller = new MainMenuController(view);
		
		JFrame frame = new JFrame("  NoBrainer");
		frame.setContentPane(view);
		frame.setVisible(true);
		frame.pack();
	}
}
