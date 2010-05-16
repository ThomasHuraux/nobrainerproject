package fr.uhp.nobrain.plateform;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.uhp.nobrain.friends.Invite;

public class PlayerInviteController {

	private PlayerInvite model;
	private PlayerInviteView view;
	
	public PlayerInviteController(PlayerInvite m, PlayerInviteView v) {
		this.model = m;
		this.view = v;
		
		for(int i = 0;i<view.getInvite().size();i++){
			final int id = i;
			view.getInvite().get(i).addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					Invite invitation = new Invite(model.getCurrent().getId(),model.getPlayers().get(id).getId());	
					invitation.execute();
				}
			});
		}
	}
}
