package fr.uhp.nobrain.test.games;

import javax.swing.JPanel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import fr.uhp.nobrain.games.GameContext;
import fr.uhp.nobrain.games.GameState;
import static org.junit.Assert.*;

/**
 *
 * @author labedan
 */
public class GameContextTest {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of start method, of class GameContext.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        int level = 0;
        GameContext instance = new GameContext();
        
        instance.start(level);
        
        assertEquals(instance.getLevel(),level);
        assertNotNull(instance.getGameState());
        assertNotNull(instance.getGraphicContext());
    }

    /**
     * Test of stop method, of class GameContext.
     */
    @Test
    public void testStop() {
        System.out.println("stop");
        GameContext instance = new GameContext();
        
        GameState previous = instance.getGameState();
        int level = instance.getLevel();
        
        instance.stop();
        
        assertFalse(instance.getGameState().equals(previous));
        assertTrue(instance.getLevel() == level);
        assertNotNull(instance.getGraphicContext());
    }

    /**
     * Test of changeToState method, of class GameContext.
     */
    @Test
    public void testChangeToState() {
        System.out.println("changeToState");
        GameState gameState = null;
        GameContext instance = new GameContext();
        
        GameState previous = instance.getGameState();
        
        instance.changeToState(gameState);
        
        assertFalse(instance.getGameState().equals(previous));
    }

    /**
     * Test of getGraphicContext method, of class GameContext.
     */
    @Test
    public void testGetGraphicContext() {
        System.out.println("getGraphicContext");
        GameContext instance = new GameContext();
        JPanel expResult = null;
        
        JPanel result = instance.getGraphicContext();
        
        assertEquals(expResult, result);
    }

}