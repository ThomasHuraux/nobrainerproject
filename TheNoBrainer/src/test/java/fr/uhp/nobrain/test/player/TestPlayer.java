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
		player = new Player("PLAYERTEST", "pwd");
		PlayerPersistance.persist(player);
		player = PlayerPersistance.select(player);
	}

	@After
	public void tearDown() throws Exception {
		PlayerPersistance.delete(player);
		player = null;
	}

	@Test
	public void testEqualsSuccess() {
		try {
			assertTrue(player.equals(player));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
