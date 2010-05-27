package fr.uhp.nobrain.plateform.playerinvite;

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

public class PlayerInviteView extends JPanel implements View{
	
	private PlayerInvite model;
	
	private static final long serialVersionUID = 1L;
	private ArrayList<JLabel> name;
	private ArrayList<JButton> invite;
	
	public void initialize(Model m) {
		
		model = (PlayerInvite) m;

		name = new ArrayList<JLabel>();
		invite = new ArrayList<JButton>();
		
		JScrollPane jsp = new JScrollPane();
		JPanel inpan = new JPanel();
		inpan.setLayout(new GridLayout(model.getInvitations().size(),1));
		
		boolean b = false;
		for(int i = 0; i<model.getInvitations().size();i++){
			try {
				name.add(new JLabel(model.getInvitations().get(i).getPlayerTwoName()));
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
			inpan.add(line);
		}
		
		jsp.add(inpan);
		add(jsp);
		
		model.attach(this);
		makeController();
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
