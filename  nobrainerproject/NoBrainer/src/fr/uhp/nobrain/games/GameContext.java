package fr.uhp.nobrain.games;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.uhp.nobrain.highscore.HighScore;
import fr.uhp.nobrain.highscore.ScoreControl;
import fr.uhp.nobrain.tools.TimerControl;


public class GameContext extends Thread implements GameState, StateTransition {

	private GameState gameState;
	private GameStateLoader loader;
	private HighScore hs;
	
	private int level;
	private int score;
	
    public GameContext() {
		super();
		this.gameState = null;
		this.loader = new GameStateLoader();
		this.score = 0;
		this.hs = new HighScore();
		loader.load();
	}

	public void start (int level) {
		this.level = level;
		
		if (! StateTransition.list.isEmpty()) {
			changeToState(StateTransition.list.remove(0));
	    	gameState.start(level);
		}
    }

	public void stopGame() {
		score += gameState.exit();
		
    	if(! StateTransition.list.isEmpty()){
    		start(level);
    	} else {
    		exit();
    		ScoreControl sc = new ScoreControl();
    		sc.setScore(score);
    		hs.addEntry(sc);
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
	public TimerControl getTimer() {
		return gameState.getTimer();
	}
}

