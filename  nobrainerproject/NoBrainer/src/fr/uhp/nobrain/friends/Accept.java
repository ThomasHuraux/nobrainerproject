package fr.uhp.nobrain.friends;

public class Accept extends Action{

	private Friends friendship;
	
	public Accept(Invitation invitation) {
		super();
		this.friendship = new Friends(invitation);
	}

	@Override
	public void execute() {
		try {
			FriendsPersistance.persist(friendship);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
