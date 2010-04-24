package fr.uhp.nobrain.model.highscore.impl;

import fr.uhp.nobrain.model.highscore.Entry;
import fr.uhp.nobrain.model.highscore.HsService;

import javax.swing.JComponent;
import javax.swing.event.ListDataListener;


public class HsMock implements HsService {

	public void add(Entry e) {
		// TODO Auto-generated method stub
		
	}

	public void addListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
		
	}

	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void removeListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
		
	}

	public JComponent getView() {
		// TODO Auto-generated method stub
		return null;
	}

	public Entry getTopScore() {
		// TODO Auto-generated method stub
		return new Entry("toto",100);
	}

}
