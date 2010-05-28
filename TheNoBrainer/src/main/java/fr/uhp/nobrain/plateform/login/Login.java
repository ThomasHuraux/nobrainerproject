package fr.uhp.nobrain.plateform.login;

import java.util.Observable;
import java.util.Observer;

import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;

public class Login extends Observable implements Model{

	private View view;
	private String logoPath;
	
	public Login(){
		logoPath = "src/main/resources/img/nobrainer.png";
		(new LoginView()).initialize(this);
	}
	
	public void attach(Observer o) {
		view = (View) o;
		this.addObserver(view);
	}

	public void detach(Observer o) {
		this.deleteObserver(view);
	}

	public LoginView getView() {
		return (LoginView) view;
	}

	public String getLogoPath() {
		return logoPath;
	}

}
