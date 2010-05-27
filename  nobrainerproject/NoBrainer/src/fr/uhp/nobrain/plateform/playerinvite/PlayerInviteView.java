package fr.uhp.nobrain.plateform.playerinvite;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;

public class PlayerInviteView extends JPanel implements View{
	
	private PlayerInvite model;
	
	private static final long serialVersionUID = 1L;
	private ArrayList<JLabel> name;
	private ArrayList<JButton> invite;
	private JButton returnB;
	
	public void initialize(Model m) {
		
		model = (PlayerInvite) m;

		name = new ArrayList<JLabel>();
		invite = new ArrayList<JButton>();
		returnB = new JButton("Return");
		
		JPanel inpan = new JPanel();
		inpan.setLayout(new GridLayout(model.getPlayers().size(),1));
		
		boolean b = false;
		for(int i = 0; i<model.getPlayers().size();i++){
			try {
				JLabel l = new JLabel(model.getPlayers().get(i).getName());
				l.setPreferredSize(new Dimension(180,20));
				l.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				name.add(l);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			invite.add(new JButton("Invite"));
			
			JPanel line = new JPanel();
			line.add(name.get(i));
			line.add(invite.get(i));
			
			if(b)
				line.setBackground(Color.lightGray);
			
			b = !b;
			line.setPreferredSize(new Dimension(290,20));
			inpan.add(line);
		}
		

		inpan.setPreferredSize(new Dimension(290,440));
		JScrollPane jsp = new JScrollPane(inpan);
		
		setLayout(new BorderLayout());
		add(jsp,BorderLayout.CENTER);
		add(returnB,BorderLayout.SOUTH);
		
		model.attach(this);
		makeController();
	}

	public JButton getReturnB() {
		return returnB;
	}

	public ArrayList<JLabel> getNames() {
		return name;
	}

	public ArrayList<JButton> getInvite() {
		return invite;
	}

	@Override
	public void makeController() {
		PlayerInviteController pic = new PlayerInviteController();
		pic.initialize(model, this);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
