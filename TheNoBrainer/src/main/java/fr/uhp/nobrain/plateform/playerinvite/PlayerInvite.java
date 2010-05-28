package fr.uhp.nobrain.plateform.playerinvite;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;
import fr.uhp.nobrain.player.Player;
import fr.uhp.nobrain.tools.Context;
import fr.uhp.nobrain.tools.HibernateUtil;

public class PlayerInvite extends Observable implements Model{
	
	private View view;
	
	private List<Player> players;
	
	@SuppressWarnings("unchecked")
	public PlayerInvite() throws Exception{
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();

        Query q = s.createQuery("from Player where id != " + Context.getCurrentPlayer().getId());
        players = q.list();
        
        s.close();
        
        (new PlayerInviteView()).initialize(this);
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

	public PlayerInviteView getView() {
		return (PlayerInviteView) view;
	}

}
