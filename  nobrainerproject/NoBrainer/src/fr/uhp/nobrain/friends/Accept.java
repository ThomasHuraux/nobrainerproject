package fr.uhp.nobrain.friends;

public class Accept extends Action{

	private Invitation invitation;
	
	public Accept(Invitation invitation) {
		super();
		this.invitation = invitation;
	}

	@Override
	public void execute() {
		try {
			FriendsPersistance.persist(invitation);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
