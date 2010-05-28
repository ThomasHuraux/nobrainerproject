package fr.uhp.nobrain.plateform.friendsmenu;

import java.util.Observable;
import java.util.Observer;

import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;

public class FriendsMenu extends Observable implements Model{
	
	private View view;
	
	private String logoPath;
	
	public FriendsMenu(){
		logoPath = "src/main/resources/img/nobrainer.png";
		(new FriendsMenuView()).initialize(this);
	}

	public String getLogoPath() {
		return logoPath;
	}

	public void attach(Observer v) {
		view = (View) v;
		this.addObserver(view);
	}

	public void detach(Observer o) {
		this.deleteObserver(view);
	}

	public FriendsMenuView getView() {
		return (FriendsMenuView) view;
	}

}
