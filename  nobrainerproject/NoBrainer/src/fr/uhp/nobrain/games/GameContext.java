package fr.uhp.nobrain.games;

import javax.swing.JPanel;

public class GameContext implements Game, StateTransition {

	private GameState gameState;
	private int level;
	
    public void start (int level) {
    }

    public void stop () {
    }

    public void changeToState (GameState gameState) {
    	this.gameState = gameState;
    }

    public JPanel getGraphicContext () {
        return null;
    }

	public int getLevel() {
		return this.level;
	}

	public GameState getGameState() {
		return gameState;
	}
}

