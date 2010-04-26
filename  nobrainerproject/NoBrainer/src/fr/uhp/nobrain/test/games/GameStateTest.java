package fr.uhp.nobrain.test.games;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import fr.uhp.nobrain.games.GameState;
import fr.uhp.nobrain.games.GameStateMock;
import static org.junit.Assert.*;

/**
 *
 * @author labedan
 */
public class GameStateTest {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of start method, of class GameState.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        int level = 0;
        GameState instance = new GameStateMock();
//        int timeRemaining = instance.getTimeRemaining();
        
        instance.start(level);
        
        assertTrue(instance.getLevel() == level);
//        assertTrue(instance.getTimeRemaining() == timeRemaining);
    }

    /**
     * Test of stop method, of class GameState.
     */
    @Test
    public void testStop() {
        System.out.println("stop");
        GameState instance = new GameStateMock();
        int expResult = 10;
        
        int score = instance.stop();
        
        assertEquals(expResult, score);
    }

    /**
     * Test of setTimeRemaining method, of class GameState.
     */
    @Test
    public void testSetTimeRemaining() {
        System.out.println("setTimeRemaining");
        int timeRemaining = 0;
        GameState instance = new GameStateMock();
        
        instance.setTimeRemaining(timeRemaining);
        
        assertEquals(timeRemaining,instance.getTimeRemaining());
    }

}