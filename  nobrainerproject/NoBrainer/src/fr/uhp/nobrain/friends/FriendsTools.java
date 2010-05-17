package fr.uhp.nobrain.friends;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.uhp.nobrain.tools.HibernateUtil;

public class FriendsTools {

	@SuppressWarnings("unchecked")
	public static boolean alreadyExists(Invitation inv) throws Exception {
		HibernateUtil hibernateUtil = new HibernateUtil();
		Session s = hibernateUtil.getSession();
		s.beginTransaction();
		
		Query q = s.createQuery("from Invitation");
		List<Invitation> l = q.list();
		
		for (Invitation i : l)
			if (i.equals(inv))
				return true;

		s.close();
		
		return false;
	}
	
	public static boolean persist(Invitation i) throws Exception {
		HibernateUtil hibernateUtil = new HibernateUtil();
		Session s = hibernateUtil.getSession();
		s.beginTransaction();

		boolean persist = false;
		if (! fr.uhp.nobrain.player.PlayerTools.alreadyExists(i.getPlayerOneId()) || ! fr.uhp.nobrain.player.PlayerTools.alreadyExists(i.getPlayerTwoId())) {
			if (alreadyExists(i))
				System.out.println("Friends persist : Operation impossible.");
		}
		else {
			s.save(i);
			persist = true;
		}
		
		s.flush();
		s.getTransaction().commit();
		s.close();
		
		return persist;
	}
}
