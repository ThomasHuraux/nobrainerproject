package fr.uhp.nobrain.games;

import javax.swing.JPanel;

import fr.uhp.nobrain.games.timer.GameTimer;

public class GameContext implements Game, StateTransition {

	private GameState gameState;
	private GameTimer timer;
	private GraphicContext graphicContext;
	private GameStateLoader loader;
	
	private int level;
	private int score;
	
    public GameContext(int level) {
		super();
		this.gameState = null;
		this.loader = new GameStateLoader();
		this.graphicContext = new GraphicContext();
		this.level = level;
		this.score = 0;
		this.timer = new GameTimer();
		loader.load();
	}

	public void start () {
		if (! StateTransition.list.isEmpty()) {
			graphicContext.removeAll();
			changeToState(StateTransition.list.remove(0));
			timer.start(this);
	    	gameState.start(level,graphicContext);
		}
    }

	public void stopGame() {
		score += gameState.stop();
    	if(! StateTransition.list.isEmpty()){
    		start();
    	}else stop();
    }
	
	public int stop(){
		timer.stop();
		return score;
	}

    public void changeToState (GameState gameState) {
    	this.gameState = gameState;
    }

    public JPanel getGraphicContext () {
        return this.graphicContext;
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
	
	public GameTimer getTimer(){
		return timer;
	}


}

