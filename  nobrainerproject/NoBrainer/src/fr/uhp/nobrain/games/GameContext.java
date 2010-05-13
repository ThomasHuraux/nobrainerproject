package fr.uhp.nobrain.games;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import fr.uhp.nobrain.highscore.Score;


public class GameContext extends Thread implements GameState, StateTransition {

	private GameState gameState;
	private GameStateLoader loader;
	private Score currentScore;
	
	private int level;
	private int score;
	
    public GameContext() {
		super();
		this.gameState = null;
		this.loader = new GameStateLoader();
		this.score = 0;
		this.currentScore = new Score();
		loader.load();
	}

	public void start (int level) {
		this.level = level;
		
		if (! StateTransition.list.isEmpty()) {
			changeToState(StateTransition.list.remove(0));
	    	gameState.start(level);
	    	currentScore.start();
		}
    }

	public void stopGame() {
		score += gameState.exit();
		
    	if(! StateTransition.list.isEmpty()){
    		start(level);
    	} else exit();
    }
	
	@Override
	public int exit(){
		gameState.exit();
		currentScore.exit();
		
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

	public int getScore() {
		return score;
	}

	@Override
	public JPanel getPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(currentScore.getPanel(), BorderLayout.NORTH);
		panel.add(gameState.getPanel(),BorderLayout.CENTER);
		
		return panel;
	}

	@Override
	public String getGameName() {
		// TODO Auto-generated method stub
		return null;
	}

}

