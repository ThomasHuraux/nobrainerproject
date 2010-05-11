package fr.uhp.nobrain.plateform;

import fr.uhp.nobrain.games.GameContext;

public class GameContainer {
	
	private GameContext game;

	public GameContainer(GameContext game){
		this.game = game;
	}

	public GameContext getGameContext() {
		return game;
	}
	
	
}
