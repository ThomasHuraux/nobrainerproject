package fr.uhp.nobrain.plateform.demand;

import java.awt.Container;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.uhp.nobrain.friends.Invitation;
import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;
import fr.uhp.nobrain.player.Player;
import fr.uhp.nobrain.tools.Context;
import fr.uhp.nobrain.tools.HibernateUtil;

public class Demand extends Observable implements Model{
	
	private View view;
	private Player current;
	private List<Invitation> invitations;
	
	@SuppressWarnings("unchecked")
	public Demand() throws Exception{
		current = Context.getCurrentPlayer();
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query q = s.createQuery("from Invitation where playerTwoId = '" + Context.getCurrentPlayer().getId()+"'");
        invitations = q.list();
//        filter();
        s.close();
        (new DemandView()).initialize(this);
	}

//	
//	private void filter(){
//		for(Invitation i : invitations){
//			if(current.getId() != i.getPlayerTwoId())
//				invitations.remove(i);
//		}
//	}
	
	public Player getCurrent() {
		return current;
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

	public Container getView() {
		return (Container) view;
	}
}
