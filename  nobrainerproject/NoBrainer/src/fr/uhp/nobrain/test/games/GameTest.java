/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.uhp.nobrain.test.games;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.uhp.nobrain.games.Game;
import fr.uhp.nobrain.games.GameContext;
import static org.junit.Assert.*;

/**
 *
 * @author labedan
 */
public class GameTest {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of start method, of class Game.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        int level = 0;
        Game instance = new GameContext();
        
        instance.start(level);
        
        assertEquals(level,instance.getLevel());
    }

    /**
     * Test of stop method, of class Game.
     */
    @Test
    public void testStop() {
        System.out.println("stop");
        Game instance = new GameContext();
       
        instance.stop();
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}