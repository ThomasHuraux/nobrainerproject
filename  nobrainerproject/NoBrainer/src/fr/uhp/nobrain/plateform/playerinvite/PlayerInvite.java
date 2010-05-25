package fr.uhp.nobrain.plateform.playerinvite;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;
import fr.uhp.nobrain.plateform.register.RegisterView;
import fr.uhp.nobrain.player.Player;
import fr.uhp.nobrain.tools.HibernateUtil;

public class PlayerInvite extends Observable implements Model{
	
	private View view;
	
	private Player current;
	private List<Player> players;
	
	@SuppressWarnings("unchecked")
	public PlayerInvite(Player c) throws Exception{
		current = c;
		HibernateUtil hibernateUtil = new HibernateUtil();
        Session s = hibernateUtil.getSession();
        s.beginTransaction();
        Query q = s.createQuery("from Player");
        players = q.list();
        filter();
        s.close();
        
        (new PlayerInviteView()).initialize(this);
	}
	
	private void filter(){
		for(Player p : players){
			if(current.getId() == p.getId() || current.isFriend(p))
				players.remove(p);
		}
	}
	
	public Player getCurrent() {
		return current;
	}

	public List<Player> getPlayers() {
		return players;
	}


	public void attach(Observer o) {
		view = (View) o;
		this.addObserver(view);
	}

	public void detach(Observer o) {
		this.deleteObserver(view);
	}

	public RegisterView getView() {
		return (RegisterView) view;
	}

}
