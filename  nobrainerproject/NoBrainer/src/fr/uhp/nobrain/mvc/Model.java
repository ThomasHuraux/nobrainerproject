package fr.uhp.nobrain.mvc;

import java.awt.Container;
import java.util.Observer;

public interface Model{
	
	public void attach(Observer o);
	public void detach(Observer o);
	public Container getView();

}
