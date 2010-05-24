package fr.uhp.nobrain.games;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.uhp.nobrain.highscore.ScoreControl;
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
	}

	public void start (int level) {
		this.level = level;
		
		if (! StateTransition.list.isEmpty()) {
			changeToState(StateTransition.list.remove(0));
	    	gameState.start(level);
	    	timer.start(this);
		}
    }

	public void stopGame() {
		System.out.println("STOP CURRENT GAME");
		score += gameState.exit();
		timer.exit();
    	if(! StateTransition.list.isEmpty()){
    		start(level);
    	} else {
    		exit();
    		ScoreControl sc = new ScoreControl();
    		sc.setScore(score);
    	}
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

