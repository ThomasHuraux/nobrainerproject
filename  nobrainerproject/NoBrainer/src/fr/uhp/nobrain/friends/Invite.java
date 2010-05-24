package fr.uhp.nobrain.friends;

import fr.uhp.nobrain.player.Player;

public class Invite extends Action{

	private Invitation invitation;
	
	public Invite(int playerOneId, int playerTwoId) {
		this.invitation = new Invitation(playerOneId, playerTwoId);
	}
	
	public Invite(Player player1, Player player2) {
		this.invitation = new Invitation(player1, player2);
	}

	@Override
	public void execute() {
		try {
			InvitationPersistance.persist(invitation);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
