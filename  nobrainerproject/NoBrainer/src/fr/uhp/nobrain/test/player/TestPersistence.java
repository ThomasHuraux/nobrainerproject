package fr.uhp.nobrain.test.player;

import org.hibernate.Session;

import fr.uhp.nobrain.friends.Invitation;
import fr.uhp.nobrain.friends.FriendsTools;
import fr.uhp.nobrain.highscore.ScoreModel;
import fr.uhp.nobrain.player.PlayerTools;
import fr.uhp.nobrain.player.Player;
import fr.uhp.nobrain.tools.HibernateUtil;

public class TestPersistence {
	
	private static void persist(ScoreModel sm) throws Exception {
		HibernateUtil hibernateUtil = new HibernateUtil();
		Session s = hibernateUtil.getSession();
		s.beginTransaction();

		s.merge(sm);
		
		s.flush();
		s.getTransaction().commit();
		s.close();
	}

	public static void main(String[] args) throws Exception{ 
		Player player1 = new Player("toto", "ght1pca3");
		Player player2 = new Player("tof", "ght1pca3");

		PlayerTools.persist(player1);
		PlayerTools.persist(player2);
		
		Invitation i = new Invitation(player1, player2);
		
		FriendsTools.persist(i);

		ScoreModel sm = new ScoreModel(3, PlayerTools.select(player1));
		sm.setScore(125);
		
		persist(sm);
	}

}
