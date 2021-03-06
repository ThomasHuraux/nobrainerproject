package fr.uhp.nobrain.test.games;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.uhp.nobrain.games.GameContext;
import fr.uhp.nobrain.games.GameState;
import fr.uhp.nobrain.games.StateTransition;
import static org.junit.Assert.*;


public class GameStateTest {

	int level = 0;
	GameContext gc;
	GameState instance;
	
    @Before
    public void setUp() {
    	gc = new GameContext();
    	gc.start(level);
    	instance = gc.getGameState();
    }

    @After
    public void tearDown() {
    	if (instance != null) {
    		instance.exit();
    		instance = null;
    	}
    	if (gc != null) {
    		gc.exit();
    		gc = null;
    	}
    	StateTransition.list.clear();
    }

    @Test
    public void testStart() {
        System.out.println("GameState - start");
        
        setUp();

        assertTrue(instance.getScore() == 0);
        
        tearDown();
    }

    @Test
    public void testTimer() {
        System.out.println("GameState - timer");
        
        setUp();
        
        assertNotNull(instance.getTime());
        
        tearDown();
    }
    
    @Test
    public void testView() {
    	System.out.println("GameState - view");
        
        setUp();
        
        assertNotNull(instance.getPanel());
        
        tearDown();
    }
    
    @Test
    public void testStop() {
        System.out.println("GameState - stop");
        setUp();
        
        int score = instance.exit();
        
        assertEquals(score, 0);
        
        tearDown();
    }
}