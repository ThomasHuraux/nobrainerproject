package fr.uhp.nobrain.mvc;

import java.util.Observer;

public interface Controller extends Observer{

	public void initialize(final Model model,final View view);

}
