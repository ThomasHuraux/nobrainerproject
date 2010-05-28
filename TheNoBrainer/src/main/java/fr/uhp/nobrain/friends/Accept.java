package fr.uhp.nobrain.friends;

public class Accept extends Action{

	private Friends friendship;
	private Invitation invitation;
	
	public Accept(Invitation invitation) {
		super();
		this.friendship = new Friends(invitation);
		this.invitation = invitation;
	}

	@Override
	public void execute() {
		try {
			FriendsPersistance.persist(friendship);
			InvitationPersistance.delete(invitation);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
