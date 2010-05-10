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
import fr.uhp.nobrain.games.GameStateMock;
import fr.uhp.nobrain.games.StateTransition;
import static org.junit.Assert.*;

/**
 *
 * @author labedan
 */
public class GameTest {

	int level;
	GameContext instance;
	
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
     * Test of start method, of class Game.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        int level = 0;
        Game instance = new GameContext(level);
        
        instance.start();
        
        assertEquals(level,instance.getLevel());
    }

    /**
     * Test of stop method, of class Game.
     */
    @Test
    public void testStop() {
        System.out.println("stop");
<<<<<<< .mine
        Game instance = new GameContext(0);
       
=======
        int level = 0;
        Game instance = new GameContext(level);
        instance.start();
>>>>>>> .r9
        instance.stop();
        
        assertEquals(level,instance.getLevel());
    }

}