package fr.uhp.nobrain.test.player;


import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.uhp.nobrain.player.Player;
import fr.uhp.nobrain.player.PlayerPersistance;

public class TestPlayer {

	private Player player;
	
	
	@Before
	public void setUp() throws Exception {
		player = new Player("toto", "pwd");
		PlayerPersistance.persist(player);
		player = PlayerPersistance.select(player);
//		System.out.println("\n"+player.getId() + " " + player.getName() + " " + player.getPwd()+"\n");
	}

//	@After
//	public void tearDown() throws Exception {
//		PlayerPersistance.delete(player);
//		player = null;
//	}

	@Test
	public void testEqualsSuccess() {
		try {
			setUp();
			assertTrue(player.equals(player));
//			tearDown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
