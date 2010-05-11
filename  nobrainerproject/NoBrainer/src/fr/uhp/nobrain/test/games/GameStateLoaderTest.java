package fr.uhp.nobrain.test.games;

import fr.uhp.nobrain.games.GameStateLoader;
import fr.uhp.nobrain.games.StateTransition;

public class GameStateLoaderTest {
	
	public static void main(String[] args){
		GameStateLoader gsl = new GameStateLoader();
		gsl.load();
		System.out.println(StateTransition.list.size()+" GameStates in StateTransition");
	}

}
