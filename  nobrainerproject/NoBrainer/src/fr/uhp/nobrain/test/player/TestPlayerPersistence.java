package fr.uhp.nobrain.test.player;


import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.uhp.nobrain.player.Player;
import fr.uhp.nobrain.player.PlayerPersistance;

public class TestPlayerPersistence {

	private Player player;

	@Before
	public void setUp() {
		player = new Player("toto", "ght1pca3");
	}

	@After
	public void tearDown() {
		if (player != null) player = null;
	}

	@Test
	public void testPersist() {
		setUp();
		try {
			assertTrue(PlayerPersistance.persist(player));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			tearDown();
		}
	}

	@Test
	public void testDelete() {
		setUp();
		try {
			assertTrue(PlayerPersistance.delete(player));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			tearDown();
		}
	}
	
	@Test
	public void testAlreadyExists() {
		setUp();
		try {
			PlayerPersistance.persist(player);
			assertTrue(PlayerPersistance.alreadyExists(player));
			PlayerPersistance.delete(player);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			tearDown();
		}
		
	}


	//	public static void main(String[] args) throws Exception{ 
	//		Player player1 = new Player("toto", "ght1pca3");
	//		Player player2 = new Player("tof", "ght1pca3");
	//
	//		PlayerPersistance.persist(player1);
	//		PlayerPersistance.persist(player2);
	//	
	//		PlayerPersistance.delete(player2);
	//		Invitation i = new Invitation(player1, player2);
	//		
	//		FriendsPersistance.persist(i);
	//
	//		ScoreModel sm = new ScoreModel(3, PlayerPersistance.select(player1));
	//		sm.setScore(125);
	//		
	//		ScorePersistance.persist(sm);
	//	}

}
