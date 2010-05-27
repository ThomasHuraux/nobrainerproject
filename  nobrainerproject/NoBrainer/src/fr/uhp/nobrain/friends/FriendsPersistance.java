package fr.uhp.nobrain.friends;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.uhp.nobrain.tools.HibernateUtil;

public class FriendsPersistance {

	@SuppressWarnings("unchecked")
	public static int select(Friends friendship) throws Exception {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();

		Query q = s.createQuery("from Friends");
		List<Invitation> l = q.list();

		for (Invitation i : l)
			if (friendship.equals(i))
				return i.getInvitationId();

		s.close();
		return -1;
	}

	@SuppressWarnings("unchecked")
	public static boolean alreadyExists(Friends friendship) throws Exception {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();

		Query q = s.createQuery("from Friends");
		List<Friends> l = q.list();

		for (Friends f : l)
			if (f.equals(friendship))
				return true;

		s.close();

		return false;
	}

	public static boolean persist(Friends friendship) throws Exception {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		
		boolean persist = false;
		
		if (! fr.uhp.nobrain.player.PlayerPersistance.alreadyExists(friendship.getPlayerOneId()) 
				|| ! fr.uhp.nobrain.player.PlayerPersistance.alreadyExists(friendship.getPlayerTwoId())
				|| alreadyExists(friendship)) {
				System.out.println("Friends persist : Operation impossible.");
		}
		else {
			s.save(friendship);
			persist = true;
		}
		
		s.flush();
		s.getTransaction().commit();
		s.close();

		return persist;
	}

	public static boolean delete(Friends friendship) throws Exception {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();

		boolean result = false;

		if (alreadyExists(friendship)) {
			friendship.setInvitationId(select(friendship));
			s.delete(friendship);
			s.flush();
		}
		if (!alreadyExists(friendship))
			result = true;

		s.close();

		return result;
	}
}
