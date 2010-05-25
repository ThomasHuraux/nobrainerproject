package fr.uhp.nobrain.plateform.playerinvite;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import fr.uhp.nobrain.friends.Action;
import fr.uhp.nobrain.friends.Invite;
import fr.uhp.nobrain.mvc.Controller;
import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;

public class PlayerInviteController implements Controller{

	private PlayerInviteView piv;
	
	@Override
	public void initialize(final Model model, final View view) {
		piv = (PlayerInviteView) view;
		for(int i = 0; i < piv.getInvite().size(); i++){
			final int id = i;
			((PlayerInviteView)view).getInvite().get(i).addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					Action invitation = new Invite(((PlayerInvite)model).getCurrent().getId(),((PlayerInvite)model).getPlayers().get(id).getId());	
					invitation.execute();
				}
			});
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}
