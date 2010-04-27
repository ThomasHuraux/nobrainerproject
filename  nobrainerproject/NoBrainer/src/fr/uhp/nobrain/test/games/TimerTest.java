package fr.uhp.nobrain.test.games;

import javax.swing.*;

import fr.uhp.nobrain.games.GameContext;
import fr.uhp.nobrain.games.GameStateMock;
import fr.uhp.nobrain.games.StateTransition;

public class TimerTest {
	
public static void main(String[] args){
	GameContext instance = new GameContext(0);
	StateTransition.list.add(new GameStateMock());
	instance.start();
	
	JPanel panel = instance.getTimer().getView();
	
	JFrame frame = new JFrame("Test Timer");
	frame.setContentPane(panel);
	frame.setVisible(true);
	frame.pack();
}

}
