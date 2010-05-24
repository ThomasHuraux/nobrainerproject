package fr.uhp.nobrain.friends;

import fr.uhp.nobrain.player.Player;


public class FriendsServer {
	private Action action;
	
	public void accept(Invitation invitation) {
		action = new Accept(invitation);
		action.execute();
	}
	
	public void decline(Invitation invitation) {
		action = new Decline(invitation);
		action.execute();
	}
	
	public void delete(Friends friendship) {
		action = new Delete(friendship);
		action.execute();
	}
	
	public void invite(Player player1, Player player2) {
		action = new Invite(player1, player2);
		action.execute();
	}
}
