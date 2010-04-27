package fr.uhp.nobrain.games;

import javax.swing.JPanel;

public class GameContext implements Game, StateTransition {

	private GameState gameState;
	private GameTimer timer;
	
	private int level;
	private int score;
	
    public GameContext(int level) {
		super();
		this.gameState = null;
		this.timer = new GameTimer();
		this.level = level;
		this.score = 0;
	}

	public int start () {
		changeToState(StateTransition.list.remove(0));
		timer.start(this);
    	gameState.start(level);
    	return score;
    }

	public void stopGame() {
		score += gameState.stop();
    	if(! StateTransition.list.isEmpty()){
    		changeToState(StateTransition.list.remove(0));
    		gameState.start(level);
    	}
    }
	
	public void stop(){
		score += gameState.stop();
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

	public int getScore() {
		return score;
	}

}

