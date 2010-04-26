package fr.uhp.nobrain.games;


public class NumState implements GameState {

	private int timeRemaining;
	private int level;
	
    public NumState () {
    }

    public void start (int level) {
    }

    public int stop () {
        return 0;
    }

    @Override
    public void setTimeRemaining (int timeRemaining) {
    	this.timeRemaining = timeRemaining;
    }

	@Override
	public int getLevel() {
		return this.level;
	}

	@Override
	public int getTimeRemaining() {
		return this.timeRemaining;
	}

}

