package fr.uhp.nobrain.test.endgame;

import static org.junit.Assert.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import antlr.collections.List;

import fr.uhp.nobrain.highscore.Score;
import fr.uhp.nobrain.plateform.endgame.Endgame;
import fr.uhp.nobrain.player.Player;
import fr.uhp.nobrain.player.PlayerPersistance;
import fr.uhp.nobrain.tools.Context;
import fr.uhp.nobrain.tools.HibernateUtil;

public class TestEndGame {

	private Endgame endgame;
	private Player player;
	
	@Before
	public void setUp() {
		player = new Player("toto", "ght1pca3");
		try {
			PlayerPersistance.persist(player);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Context.setCurrentPlayer(player);
	}

	@After
	public void tearDown() {
		endgame = null;
	}

	@Test
	public void testHSWasPerist() {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		
		Query q = s.createQuery("from Score");
		int size = q.list().size();
		
		endgame = new Endgame(100, 2);
		q = s.createQuery("from Score");
		
		assertEquals(size, q.list().size()-1);
		
		s.close();
	}
	
	@Test
	public void testHSRetrieveScore() {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		
		Score score = new Score();
		score.setScore(100);
		
		endgame = new Endgame(score.getScore(), 2);
		
		Query q = s.createQuery("from Score where playerId = '" + Context.getCurrentPlayer().getId() +"'");
		
		assertEquals(score.compareTo((Score)q.list().get(0)),0);
		
		s.close();
	}
	
}
