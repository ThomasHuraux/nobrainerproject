package fr.uhp.nobrain.friends;

public class Delete extends Action{

	private Friends friendship;

	public Delete(Friends friendship) {
		super();
		this.friendship = friendship;
	}
	
	@Override
	public void execute() {
		try {
			FriendsPersistance.delete(friendship);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
