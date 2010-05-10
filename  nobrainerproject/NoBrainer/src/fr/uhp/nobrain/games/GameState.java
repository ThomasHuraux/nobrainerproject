package fr.uhp.nobrain.games;


public interface GameState {

    public static final int timeRemaining = 0;




    public void start (GraphicContext graphicContext);

    public int stop ();

    public void setTimeRemaining (int time);

	public int getTimeRemaining();

	public int getLevel();

}

