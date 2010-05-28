package fr.uhp.nobrain.test.player;


import static org.junit.Assert.*;

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
	public void testAlreadyExistsByObjectSuccess() {
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

	@Test
	public void testAlreadyExistsByObjectFailure() {
		setUp();
		try {
			assertFalse(PlayerPersistance.alreadyExists(player));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			tearDown();
		}	
	}
	
	@Test
	public void testSelectByObjectSuccess() {
		setUp();
		
		try {
			PlayerPersistance.persist(player);
			assertTrue(PlayerPersistance.select(player) != null);
			PlayerPersistance.delete(player);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tearDown();
	}

	@Test
	public void testSelectByObjectFailure() {
		setUp();
		
		try {
			assertTrue(PlayerPersistance.select(new Player("Titi", "Grosminet")) == null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tearDown();
	}
	
	@Test
	public void testSelectByNameSuccess() {
		setUp();
		
		try {
			PlayerPersistance.persist(player);
			assertNotNull(PlayerPersistance.select(player.getName()));
			PlayerPersistance.delete(player);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tearDown();
	}

	@Test
	public void testSelectByNameFailure() {
		setUp();
		
		try {
			assertNull(PlayerPersistance.select(player.getName()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tearDown();
	}
	
	@Test
	public void testSelectByIdSuccess() {
		setUp();
		
		try {
			PlayerPersistance.persist(player);
			assertNotNull(PlayerPersistance.select(player.getId()));
			PlayerPersistance.delete(player);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tearDown();
	}

	@Test
	public void testSelectByIdFailure() {
		setUp();
		
		try {
			assertNull(PlayerPersistance.select(player.getId()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tearDown();
	}
}
