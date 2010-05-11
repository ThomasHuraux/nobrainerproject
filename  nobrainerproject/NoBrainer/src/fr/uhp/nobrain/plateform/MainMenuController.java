package fr.uhp.nobrain.plateform;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import fr.uhp.nobrain.games.GameContext;
import fr.uhp.nobrain.games.GraphicContext;

public class MainMenuController {

	@SuppressWarnings("unused")
	private MainMenuView view;
	
	public MainMenuController(MainMenuView view) {
		this.view = view;
		
		view.getLogoutButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("logout");
			}
		});
		
		view.getPlayButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				GameContext gc = new GameContext(0);
				gc.start();
				GameContainer container = new GameContainer(gc);
				GameContainerView gcv = new GameContainerView(container);
				GameContainerController gcc = new GameContainerController(container,gcv);
				
				JFrame frame = new JFrame("  Games ");
				frame.setPreferredSize(new Dimension(800,600));
				frame.setContentPane(gcv);
				frame.setVisible(true);
				frame.pack();
			}
		});
		
		view.getStatsButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("stats");
			}
		});
		
		view.getFriendsButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("friends");
			}
		});
	}
}
