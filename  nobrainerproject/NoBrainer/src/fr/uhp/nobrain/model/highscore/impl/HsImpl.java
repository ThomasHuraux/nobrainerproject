package fr.uhp.nobrain.model.highscore.impl;

import fr.uhp.nobrain.model.highscore.Entry;
import fr.uhp.nobrain.model.highscore.HsService;

import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.JComponent;
import javax.swing.JList;

import com.google.inject.Singleton;

@Singleton
public class HsImpl extends AbstractListModel  implements HsService {
	private ArrayList<Entry> entries=new ArrayList<Entry>();
	

	public void add(Entry e) {
		// TODO Auto-generated method stub
		entries.add(e);
		fireIntervalAdded(this, entries.size()-1, entries.size());
	}


	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return entries.get(index);
	}


	public int getSize() {
		// TODO Auto-generated method stub
		return entries.size();
	}


	public JComponent getView() {
		return new JList(this);
	}


	public Entry getTopScore() {
		// TODO Auto-generated method stub
		return entries.get(entries.size());
	}
}
