package fr.uhp.nobrain.plateform.playerinvite;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import fr.uhp.nobrain.friends.FriendsServer;
import fr.uhp.nobrain.mvc.Controller;
import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;
import fr.uhp.nobrain.player.PlayerPersistance;
import fr.uhp.nobrain.tools.Context;

public class PlayerInviteController implements Controller{

	private PlayerInviteView piv;
	
	public void initialize(final Model model, final View view) {
		piv = (PlayerInviteView) view;
		for(int i = 0; i < piv.getInvite().size(); i++){
			final int id = i;
			((PlayerInviteView)view).getInvite().get(i).addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					try {
						FriendsServer.invite(Context.getCurrentPlayer(),PlayerPersistance.select(piv.getNames().get(id).getText()));
						piv.getInvite().get(id).setEnabled(false);
						piv.getInvite().get(id).setText("Sent");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}
