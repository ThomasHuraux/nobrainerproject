package fr.uhp.nobrain.test.games;

import javax.swing.JPanel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import fr.uhp.nobrain.games.GameContext;
import fr.uhp.nobrain.games.GameState;
import fr.uhp.nobrain.games.GameStateMock;
import fr.uhp.nobrain.games.StateTransition;
import static org.junit.Assert.*;

/**
 *
 * @author labedan
 */
public class GameContextTest {

	GameContext instance;
	int level;
	
    @Before
    public void setUp() {
    	level = 0;
    	instance = new GameContext(level);
        StateTransition.list.add(new GameStateMock());
    }

    @After
    public void tearDown() {
    	instance = null;
    	StateTransition.list.clear();
    }

    /**
     * Test of start method, of class GameContext.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        setUp();
        
        instance.start();
        
        assertEquals(instance.getLevel(),level);
        assertNotNull(instance.getGameState());
        assertNotNull(instance.getGraphicContext());
        
        tearDown();
    }

    /**
     * Test of stop method, of class GameContext.
     */
    @Test
    public void testStop() {
        System.out.println("stop");
        setUp();
        
        GameState previous = instance.getGameState();
        int lvl = instance.getLevel();
        instance.start();
        instance.stop();
        
        assertFalse(instance.getGameState().equals(previous));
        assertTrue(instance.getLevel() == lvl);
        assertNotNull(instance.getGraphicContext());
        
        tearDown();
    }

    /**
     * Test of changeToState method, of class GameContext.
     */
    @Test
    public void testChangeToState() {
        System.out.println("changeToState");
        setUp();
        GameState gameState = new GameStateMock();
        GameState previous = instance.getGameState();
        
        instance.changeToState(gameState);
        
        assertFalse(instance.getGameState().equals(previous));
        
        tearDown();
    }

    /**
     * Test of getGraphicContext method, of class GameContext.
     */
    @Test
    public void testGetGraphicContext() {
        System.out.println("getGraphicContext");
        setUp();
        
        JPanel result = instance.getGraphicContext();
        
        assertNotNull(result);
        
        tearDown();
    }

}