package fr.uhp.nobrain.friends;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.uhp.nobrain.tools.HibernateUtil;

public class FriendsPersistance {

	@SuppressWarnings("unchecked")
	public static int select(Invitation invitation) throws Exception {
		HibernateUtil hibernateUtil = new HibernateUtil();
		Session s = hibernateUtil.getSession();
		s.beginTransaction();

		Query q = s.createQuery("from Invitation");
		List<Invitation> l = q.list();

		for (Invitation i : l)
			if (invitation.equals(i))
				return i.getInvitationId();

		s.close();
		return -1;
	}

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
		if (! fr.uhp.nobrain.player.PlayerPersistance.alreadyExists(i.getPlayerOneId()) || ! fr.uhp.nobrain.player.PlayerPersistance.alreadyExists(i.getPlayerTwoId())) {
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

	public static boolean delete(Invitation invitation) throws Exception {
		HibernateUtil hibernateUtil = new HibernateUtil();
		Session s = hibernateUtil.getSession();
		s.beginTransaction();

		boolean result = false;

		if (alreadyExists(invitation)) {
			invitation.setInvitationId(select(invitation));
			s.delete(invitation);
			s.flush();
		}
		if (!alreadyExists(invitation))
			result = true;

		s.close();

		return result;
	}
}
