package fr.uhp.nobrain.test.games;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.uhp.nobrain.games.GameStateLoader;
import fr.uhp.nobrain.games.StateTransition;

public class GameStateLoaderTest {
	
	@Test
	public void testLoad() {
		System.out.println("GameStateLoader - load");
		GameStateLoader gsl = new GameStateLoader();
		gsl.load();
		assertTrue(StateTransition.list.size() != 0);
	}
}
