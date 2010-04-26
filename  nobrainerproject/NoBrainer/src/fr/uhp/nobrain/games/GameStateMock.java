package fr.uhp.nobrain.games;

public class GameStateMock implements GameState {

	private int timeRemaining = 45;
	private int level = 0;
	
	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return this.level;
	}

	@Override
	public int getTimeRemaining() {
		// TODO Auto-generated method stub
		return this.timeRemaining;
	}

	@Override
	public void setTimeRemaining(int time) {
		// TODO Auto-generated method stub

	}

	@Override
	public void start(int level) {
		// TODO Auto-generated method stub

	}

	@Override
	public int stop() {
		// TODO Auto-generated method stub
		return 10;
	}

}
