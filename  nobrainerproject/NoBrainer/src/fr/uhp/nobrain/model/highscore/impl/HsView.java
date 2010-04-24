package fr.uhp.nobrain.model.highscore.impl;
import javax.swing.JList;
import javax.swing.ListModel;

import com.google.inject.Inject;


public class HsView extends JList {
	private ListModel hs;
	
	@Inject
	HsView(ListModel hs) {
		super(hs);
	}
	
}
