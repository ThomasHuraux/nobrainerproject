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
		player = new Player("TESTPLAYER", "PASSWORD");
	}

	@After
	public void tearDown() {
		try {
			PlayerPersistance.delete(player);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (player != null) player = null;
	}

	@Test
	public void testPersist() {
		System.out.println("PlayerPersistance - persist");
		try {
			assertTrue(PlayerPersistance.persist(player));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		System.out.println("PlayerPersistance - delete");
		try {
			assertTrue(PlayerPersistance.delete(player));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAlreadyExistsByObjectSuccess() {
		System.out.println("PlayerPersistance - already exists success");
		try {
			PlayerPersistance.persist(player);
			assertTrue(PlayerPersistance.alreadyExists(player));
			PlayerPersistance.delete(player);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Test
	public void testAlreadyExistsByObjectFailure() {
		System.out.println("PlayerPersistance - already exists failure");
		try {
			assertFalse(PlayerPersistance.alreadyExists(player));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Test
	public void testSelectByObjectSuccess() {	
		System.out.println("PlayerPersistance - select by object success");
		try {
			PlayerPersistance.persist(player);
			assertTrue(PlayerPersistance.select(player) != null);
			PlayerPersistance.delete(player);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSelectByObjectFailure() {
		System.out.println("PlayerPersistance - select by object failure");
		try {
			assertTrue(PlayerPersistance.select(new Player("Titi", "Grosminet")) == null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSelectByNameSuccess() {
		System.out.println("PlayerPersistance - select by name success");
		try {
			PlayerPersistance.persist(player);
			assertNotNull(PlayerPersistance.select(player.getName()));
			PlayerPersistance.delete(player);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSelectByNameFailure() {
		System.out.println("PlayerPersistance - select by name success");
		try {
			assertNull(PlayerPersistance.select("PLAYER_INCONNU"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSelectByIdSuccess() {
		System.out.println("PlayerPersistance - select by id success");
		try {
			PlayerPersistance.persist(player);
			assertNotNull(PlayerPersistance.select(player.getId()));
			PlayerPersistance.delete(player);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSelectByIdFailure() {
		System.out.println("PlayerPersistance - select by id success");
		try {
			assertNull(PlayerPersistance.select(player.getId()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
