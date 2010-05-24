package fr.uhp.nobrain.mvc;

import java.util.Observer;

public interface View extends Observer{
	
	public void initialize(Model model);
	public void makeController();
}
