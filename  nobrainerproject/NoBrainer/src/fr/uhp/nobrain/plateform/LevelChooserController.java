package fr.uhp.nobrain.plateform;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelChooserController {
	
	private LevelChooserView view;
	
	public LevelChooserController(LevelChooserView v){
		view = v;
		
		ActionListener alE = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// gamecontext.start(0);
			}
		};
		ActionListener alM = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// gamecontext.start(1);
			}
		};
		ActionListener alH = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// gamecontext.start(2);
			}
		};
		
		
		view.getEasy().addActionListener(alE);
		view.getMedium().addActionListener(alM);
		view.getHard().addActionListener(alH);
	}

}
