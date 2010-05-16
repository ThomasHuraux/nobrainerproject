package fr.uhp.nobrain.test.player;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.uhp.nobrain.player.Player;
import fr.uhp.nobrain.tools.HibernateUtil;

public class TestPersistence {

	private static boolean persist(Player player) throws Exception {
		HibernateUtil hibernateUtil = new HibernateUtil();
		Session s = hibernateUtil.getSession();
		s.beginTransaction();

		boolean persist = false;
		if (! alreadyExists(player)) {
			s.save(player);
			persist = true;
			System.out.println("Operation reussie !");
		}
		else System.out.println("Impossible d'enregistrer " + player.getName() 
				+ " car il existe deja dans la table");

		s.flush();
		s.getTransaction().commit();
		s.close();
		
		return persist;
	}

	@SuppressWarnings("unchecked")
	private static boolean alreadyExists(Player player) throws Exception {
		HibernateUtil hibernateUtil = new HibernateUtil();
		Session s = hibernateUtil.getSession();
		s.beginTransaction();
		
		boolean exists = false;
		Query q = s.createQuery("from Player");
		List<Player> l = q.list();
		
		for (Player p : l) {
			if (player.equals(p)) {
				exists = true;
				return exists;
			}
		}

		s.close();
		
		return exists;
	}

	public static void main(String[] args) throws Exception{ 
		Player player1 = new Player("toto", "ght1pca3");
		Player player2 = new Player("tof", "ght1pca3");

		persist(player1);
		persist(player2);

	}

}
