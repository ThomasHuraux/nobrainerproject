package fr.uhp.nobrain.plateform;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class DemandView {
	
	private JPanel panel;
	private JButton quit;
	private ArrayList<JLabel> name;
	private ArrayList<JButton> accepts;
	private ArrayList<JButton> ignores;
	
	public DemandView(Demand demand){

		name = new ArrayList<JLabel>();
		quit = new JButton("Return");
		accepts = new ArrayList<JButton>();
		ignores = new ArrayList<JButton>();
		
		JScrollPane jsp = new JScrollPane();
		JPanel inpan = new JPanel();
		inpan.setLayout(new GridLayout(demand.getPlayers().size(),1));
		
		boolean b = false;
		for(int i = 0; i<demand.getPlayers().size();i++){
			name.add(new JLabel(demand.getPlayers().get(i).getNickname()));
			accepts.add(new JButton("Accept"));
			ignores.add(new JButton("Ignore"));
			
			JPanel line = new JPanel();
			line.add(name.get(i));
			line.add(accepts.get(i));
			line.add(ignores.get(i));
			
			if(b)
				line.setBackground(Color.lightGray);
			
			b = !b;
			inpan.add(line);
		}
		
		jsp.add(inpan);
		
		panel.setLayout(new BorderLayout());
		panel.add(new JLabel("They want be your friend :"),BorderLayout.NORTH);
		panel.add(jsp,BorderLayout.CENTER);
		panel.add(quit,BorderLayout.SOUTH);
	}

	public JPanel getPanel() {
		return panel;
	}

	public ArrayList<JLabel> getName() {
		return name;
	}

	public ArrayList<JButton> getAccepts() {
		return accepts;
	}

	public ArrayList<JButton> getIgnores() {
		return ignores;
	}

	public JButton getQuit() {
		return quit;
	}
	

}
