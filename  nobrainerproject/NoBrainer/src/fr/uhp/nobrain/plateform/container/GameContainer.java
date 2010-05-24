package fr.uhp.nobrain.plateform.container;

import java.awt.Container;
import java.util.Observable;
import java.util.Observer;

import fr.uhp.nobrain.games.GameContext;
import fr.uhp.nobrain.mvc.Model;

public class GameContainer extends Observable implements Model{
	
	private GameContext game;
	
	private GameContainerView view;

	public GameContainer(GameContext game){
		this.game = game;
		(new GameContainerView()).initialize(this);
	}

	public GameContext getGameContext() {
		return game;
	}

	@Override
	public void attach(Observer o) {
		view = (GameContainerView) o;
		this.addObserver(o);
	}

	@Override
	public void detach(Observer o) {
		this.deleteObserver(o);
	}

	@Override
	public Container getView() {
		return view;
	}
	
	
}
