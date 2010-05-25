package fr.uhp.nobrain.games;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.uhp.nobrain.mvc.Switcher;
import fr.uhp.nobrain.timer.GameTimer;


public class GameContext extends Thread implements GameState, StateTransition {

	private GameState gameState;
	private GameStateLoader loader;
	private GameTimer timer;
	
	private int level;
	private int score;
	
    public GameContext() {
		super();
		this.gameState = null;
		this.loader = new GameStateLoader();
		this.score = 0;
		timer = new GameTimer();
		loader.load();
		Switcher.create();
	}

	public void start (int level) {
		this.level = level;
		System.out.println("TAILLE DE LA LISTE " + StateTransition.list.size()+"\n");
		if (! StateTransition.list.isEmpty()) {
			changeToState(StateTransition.list.remove(0)); 
	    	gameState.start(level);
	    	timer.start(this);
		} else 
			exit();
    }

	public void stopGame() {
		System.out.println("STOP CURRENT GAME");
		score += gameState.exit();
		timer.exit();
    	start(level);
    }
	
	@Override
	public int exit(){
		score += gameState.exit();		
		return score;
	}

    public void changeToState (GameState gameState) {
    	this.gameState = gameState;
    }

	public int getLevel() {
		return this.level;
	}

	public GameState getGameState() {
		return gameState;
	}

	public JLabel getScoreLabel() {
		return new JLabel(gameState.getScore()+"");
	}
	
	@Override
	public int getScore() {
		return gameState.getScore();
	}

	@Override
	public JPanel getPanel() {
		return gameState.getPanel();
	}

	@Override
	public String getGameName() {
		return gameState.getGameName();
	}

	@Override
	public int getTime() {
		return gameState.getTime();
	}

	public GameTimer getTimer() {
		return timer;
	}
	
	
}

