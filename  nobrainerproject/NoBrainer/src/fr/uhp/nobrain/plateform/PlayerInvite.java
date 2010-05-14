package fr.uhp.nobrain.plateform;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.uhp.nobrain.player.Player;
import fr.uhp.nobrain.tools.HibernateUtil;

public class PlayerInvite {
	
	private Player current;
	private List<Player> players;
	
	public PlayerInvite(Player c){
		current = c;
		
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query q = s.createQuery("from Player");
        players = q.list();
        filter();
        s.close();
	}

	
	private void filter(){
		for(Player p : players){
			if(current.getPlayerId() == p.getPlayerId() || current.isFriend(p))
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
