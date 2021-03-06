package fr.uhp.nobrain.friends;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.uhp.nobrain.tools.HibernateUtil;

public class InvitationPersistance {
	
	@SuppressWarnings("unchecked")
	public static int select(Invitation invitation) throws Exception {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();

		Query q = s.createQuery("from Invitation");
		List<Invitation> l = q.list();

		int result = -1;
		
		for (Invitation i : l)
			if (invitation.equals(i))
				result =  i.getInvitationId();

		s.close();
		return result;
	}

	@SuppressWarnings("unchecked")
	public static boolean alreadyExists(Invitation inv) throws Exception {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();

		Query q = s.createQuery("from Invitation");
		List<Invitation> l = q.list();
		boolean exists = false;
		for (Invitation i : l)
			if (i.equals(inv))
				exists = true;

		s.close();

		return exists;
	}

	public static boolean persist(Invitation i) throws Exception {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		
		boolean persist = false;
		if (! fr.uhp.nobrain.player.PlayerPersistance.alreadyExists(i.getPlayerOneId()) 
				|| ! fr.uhp.nobrain.player.PlayerPersistance.alreadyExists(i.getPlayerTwoId())
				|| alreadyExists(i)) {
				System.out.println("Invitation persist : Operation impossible.");
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
		Session s = HibernateUtil.getSessionFactory().openSession();
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
