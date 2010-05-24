package fr.uhp.nobrain.plateform.demand;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.uhp.nobrain.friends.Invitation;
import fr.uhp.nobrain.player.Player;
import fr.uhp.nobrain.tools.HibernateUtil;

public class Demand {
	private Player current;
	private List<Invitation> invitations;
	
	@SuppressWarnings("unchecked")
	public Demand(Player c) throws Exception{
		current = c;
		HibernateUtil hibernateUtil = new HibernateUtil();
        Session s = hibernateUtil.getSession();
        s.beginTransaction();
        Query q = s.createQuery("from Invitation");
        invitations = q.list();
        filter();
        s.close();
	}

	
	private void filter(){
		for(Invitation i : invitations){
			if(current.getId() != i.getPlayerTwoId())
				invitations.remove(i);
		}
	}
	
	public Player getCurrent() {
		return current;
	}

	public List<Invitation> getInvitations() {
		return invitations;
	}
}
