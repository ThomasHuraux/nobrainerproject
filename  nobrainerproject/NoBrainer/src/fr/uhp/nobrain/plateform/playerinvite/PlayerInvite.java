package fr.uhp.nobrain.plateform.playerinvite;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.uhp.nobrain.friends.Invitation;
import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;
import fr.uhp.nobrain.player.PlayerPersistance;
import fr.uhp.nobrain.tools.Context;
import fr.uhp.nobrain.tools.HibernateUtil;

public class PlayerInvite extends Observable implements Model{
	
	private View view;
	
	private List<Invitation> invitations;
	
	@SuppressWarnings("unchecked")
	public PlayerInvite() throws Exception{
		HibernateUtil hibernateUtil = new HibernateUtil();
        Session s = hibernateUtil.getSession();
        s.beginTransaction();
        
        int playerId = PlayerPersistance.select(Context.getCurrentPlayer());
        Query q = s.createQuery("from Invitation where playerOneId = "+playerId);
        
        invitations = q.list();
        
        s.close();
        
        (new PlayerInviteView()).initialize(this);
	}
	

	public List<Invitation> getInvitations() {
		return invitations;
	}


	public void attach(Observer o) {
		view = (View) o;
		this.addObserver(view);
	}

	public void detach(Observer o) {
		this.deleteObserver(view);
	}

	public PlayerInviteView getView() {
		return (PlayerInviteView) view;
	}

}
