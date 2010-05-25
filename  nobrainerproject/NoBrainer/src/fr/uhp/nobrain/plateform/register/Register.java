package fr.uhp.nobrain.plateform.register;

import java.util.Observable;
import java.util.Observer;

import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;

public class Register extends Observable implements Model{
	
	private View view;

	public Register(){
		(new RegisterView()).initialize(this);
	}
	
	public void attach(Observer o) {
		view = (View) o;
		this.addObserver(view);
	}

	public void detach(Observer o) {
		this.deleteObserver(view);
	}

	public RegisterView getView() {
		return (RegisterView) view;
	}

}
