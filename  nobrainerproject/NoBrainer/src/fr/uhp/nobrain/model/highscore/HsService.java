package fr.uhp.nobrain.model.highscore;

import javax.swing.JComponent;
import javax.swing.ListModel;

public interface  HsService extends ListModel {
	void add(Entry e);
	JComponent getView();
	Entry getTopScore();
}
