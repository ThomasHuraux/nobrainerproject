package fr.uhp.nobrain.plateform;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.uhp.nobrain.friends.Invitation;
import fr.uhp.nobrain.player.Player;
import fr.uhp.nobrain.tools.HibernateUtil;

public class Demand {
	private Player current;
	private List<Invitation> invitations;
	
	public Demand(Player c){
		current = c;
		
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query q = s.createQuery("from Invitation");
        invitations = q.list();
        filter();
        s.close();
	}

	
	private void filter(){
		for(Invitation i : invitations){
			if(current.getPlayerId() != i.getPlayerTwo().getPlayId())
				players.remove(p);
		}
	}
	
	public Player getCurrent() {
		return current;
	}

	public List<Player> getPlayers() {
		return players;
	}
}
