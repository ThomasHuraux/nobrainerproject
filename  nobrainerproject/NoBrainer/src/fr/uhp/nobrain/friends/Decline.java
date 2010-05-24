package fr.uhp.nobrain.friends;

public class Decline extends Action{

	private Invitation invitation;
	
	public Decline(Invitation invitation) {
		super();
		this.invitation = invitation;
	}

	@Override
	public void execute() {
		try {
			FriendsPersistance.delete(invitation);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
