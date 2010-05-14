package fr.uhp.nobrain.plateform;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import fr.uhp.nobrain.player.Player;

public class PlayerInviteView {
	
	private JPanel panel;
	private ArrayList<JLabel> name;
	private ArrayList<JButton> invite;
	
	public PlayerInviteView(PlayerInvite pi){

		name = new ArrayList<JLabel>();
		invite = new ArrayList<JButton>();
		
		JScrollPane jsp = new JScrollPane();
		JPanel inpan = new JPanel();
		inpan.setLayout(new GridLayout(pi.getPlayers().size(),1));
		
		boolean b = false;
		for(int i = 0; i<pi.getPlayers().size();i++){
			name.add(new JLabel(pi.getPlayers().get(i).getNickname()));
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
		panel.add(jsp);
	}

	public JPanel getPanel() {
		return panel;
	}

	public ArrayList<JLabel> getName() {
		return name;
	}

	public ArrayList<JButton> getInvite() {
		return invite;
	}

}
