package fr.uhp.nobrain.plateform.levelchooser;

import java.awt.Container;
import java.util.Observable;
import java.util.Observer;

import fr.uhp.nobrain.mvc.Model;

public class LevelChooser extends Observable implements Model {

	private LevelChooserView view;
	
	public LevelChooser(){
		(new LevelChooserView()).initialize(this);
	}
	
	@Override
	public void attach(Observer o) {
		view = (LevelChooserView) o;
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
