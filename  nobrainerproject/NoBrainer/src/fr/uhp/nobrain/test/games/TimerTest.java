package fr.uhp.nobrain.test.games;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.uhp.nobrain.games.GameContext;
import fr.uhp.nobrain.games.StateTransition;

public class TimerTest {

	private int level = 10;
	private GameContext instance;
	
	@Before
	public void setUp() {
		instance = new GameContext();
	}
	
	@After
	public void tearDown() {
		if (instance != null) {
			instance.exit();
			instance = null;
		}
		StateTransition.list.clear();
	}
	
	@Test
	public void testTimer() {
		System.out.println("Timer - initialization");
		setUp();
		instance.start(level);
		assertNotNull(instance.getTimer());
		tearDown();
	}

	@Test
	public void testTimerView() {
		System.out.println("Timer - view");
		setUp();
		instance.start(level);
		assertNotNull(instance.getTimer().getView());
		tearDown();
	}
	
	@Test
	public void testTimerTimer() {
		System.out.println("Timer - time remaining");
		setUp();
		instance.start(level);
		int t = instance.getTimer().getTimeRemaining();
		try {
			GameContext.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(instance.getTimer().getTimeRemaining() < t);
		tearDown();
	}
	
	@Test
	public void testStop() {
		System.out.println("Timer - stop");
		setUp();
		instance.start(level);
		instance.getTimer().stop();
		assertFalse(instance.getTimer().isRun());
		tearDown();
	}
}
