package fr.uhp.nobrain.plateform;

import java.util.Observable;
import java.util.Observer;

import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;

public class MainMenu extends Observable implements Model{
	
	private View view;
	
	private String logoPath;
	
	public MainMenu(){
		logoPath = "img/nobrainer.png";
		(new MainMenuView()).initialize(this);
	}

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	public void attach(Observer v) {
		view = (View) v;
		this.addObserver(view);
	}

	public void detach(Observer o) {
		this.deleteObserver(view);
	}

	public MainMenuView getView() {
		return (MainMenuView) view;
	}

}
