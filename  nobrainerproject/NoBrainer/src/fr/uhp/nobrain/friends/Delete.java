package fr.uhp.nobrain.friends;

public class Delete extends Action{

	private Invitation invitation;

	public Delete(Invitation invitation) {
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
