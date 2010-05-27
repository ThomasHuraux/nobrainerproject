package fr.uhp.nobrain.friends;

import fr.uhp.nobrain.player.Player;


public class FriendsServer {
	private static Action action;
	
	public static void accept(Invitation invitation) {
		action = new Accept(invitation);
		action.execute();
	}
	
	public static void decline(Invitation invitation) {
		action = new Decline(invitation);
		action.execute();
	}
	
	public static void delete(Friends friendship) {
		action = new Delete(friendship);
		action.execute();
	}
	
	public static void invite(Player player1, Player player2) {
		action = new Invite(player1, player2);
		action.execute();
	}
	
	public static void invite(int player1, int player2) {
		action = new Invite(player1, player2);
		action.execute();
	}
}
