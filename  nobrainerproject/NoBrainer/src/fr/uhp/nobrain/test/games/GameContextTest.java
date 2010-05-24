package fr.uhp.nobrain.test.games;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.uhp.nobrain.games.GameContext;
import fr.uhp.nobrain.games.GameState;
import fr.uhp.nobrain.games.StateTransition;

import static org.junit.Assert.*;

public class GameContextTest {
	GameContext instance;
	int level;
	
    @Before
    public void setUp() {
    	level = 0;
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
    public void testStart() {
        System.out.println("GameContext - start");
        setUp();
        
        instance.start(level);
        
        assertEquals(instance.getLevel(),level);
        assertNotNull(instance.getGameState());
        assertEquals(instance.getScore(), 0);
        assertNotNull(instance.getGameName());
        
        tearDown();
    }

    @Test
    public void testStop() {
        System.out.println("GameContext - stop");
        setUp();
        
        GameState previous = instance.getGameState();
        instance.start(level);
        instance.exit();
        
        assertFalse(instance.getGameState().equals(previous));
        assertTrue(instance.getLevel() == level);
        assertNotNull(instance.getPanel());
        
        tearDown();
    }

    @Test
    public void testChangeToState() {
        System.out.println("GameContext - changeToState");
        setUp();
        GameState previous = instance.getGameState();
        
        instance.changeToState(StateTransition.list.get(1));
        
        assertFalse(instance.getGameState().equals(previous));
        
        tearDown();
    }

    @Test
    public void testGetGraphicContext() {
        System.out.println("GameContext - getGraphicContext");
        setUp();
        instance.start(level);
        assertNotNull(instance.getPanel());
        
        tearDown();
    }

}