package fr.uhp.nobrain.test.player;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.uhp.nobrain.friends.Invitation;
import fr.uhp.nobrain.player.PersistTools;
import fr.uhp.nobrain.player.Player;
import fr.uhp.nobrain.tools.HibernateUtil;

public class TestPersistence {

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
	
	private static boolean persist(Invitation i) throws Exception {
		HibernateUtil hibernateUtil = new HibernateUtil();
		Session s = hibernateUtil.getSession();
		s.beginTransaction();

		boolean persist = false;
		if (! PersistTools.alreadyExists(i.getPlayerOneId()) || ! PersistTools.alreadyExists(i.getPlayerTwoId())) {
			if (alreadyExists(i))
				System.out.println("Operation impossible !");
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

	public static void main(String[] args) throws Exception{ 
		Player player1 = new Player("toto", "ght1pca3");
		Player player2 = new Player("tof", "ght1pca3");

		List<Player> list = new ArrayList<Player>();
		list.add(player1); list.add(player2);
		
		PersistTools.persist(list);
		
		Invitation i = new Invitation(player1, player2);
		
		persist(i);

	}

}
