package fr.uhp.nobrain.plateform.demand;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;

public class DemandView extends JPanel implements View{

	private static final long serialVersionUID = 1L;
	
	private Demand demand;
	
	private JButton quit;
	private ArrayList<JLabel> name;
	private ArrayList<JButton> accepts;
	private ArrayList<JButton> ignores;
	
	public void initialize(Model model){
		
		demand = (Demand) model;

		name = new ArrayList<JLabel>();
		quit = new JButton("Return");
		accepts = new ArrayList<JButton>();
		ignores = new ArrayList<JButton>();
		
		JScrollPane jsp = new JScrollPane();
		JPanel inpan = new JPanel();
		inpan.setLayout(new GridLayout(demand.getInvitations().size(),1));
		
		boolean b = false;
		for(int i = 0; i<demand.getInvitations().size();i++){
			try {
				name.add(new JLabel(demand.getInvitations().get(i).getPlayerTwoName()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		
		setLayout(new BorderLayout());
		add(new JLabel("They want be your friend :"),BorderLayout.NORTH);
		add(jsp,BorderLayout.CENTER);
		add(quit,BorderLayout.SOUTH);
		
		model.attach(this);
		makeController();
	}

	public ArrayList<JLabel> getNickName() {
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

	@Override
	public void makeController() {
		DemandController dc = new DemandController();
		dc.initialize(demand, this);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	

}
