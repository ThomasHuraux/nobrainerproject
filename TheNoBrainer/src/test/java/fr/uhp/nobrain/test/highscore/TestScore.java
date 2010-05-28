package fr.uhp.nobrain.test.highscore;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.uhp.nobrain.highscore.Score;

public class TestScore {
	
	private Score score;
	
	@Before
	public void setUp() {
		score = new Score();
	}
	
	@After
	public void tearDown() {
		score = null;
	}
	
	@Test
	public void testCompareToLet() {
		System.out.println("PlayerPersistance - compare to - lesser than");
		score.setScore(100);
		Score s = new Score();
		s.setScore(200);
		
		assertEquals(score.compareTo(s), -1);
	}
	
	@Test
	public void testCompareToGrt() {
		System.out.println("PlayerPersistance - compare to - greater than");

		score.setScore(200);
		Score s = new Score();
		s.setScore(100);
		
		assertEquals(score.compareTo(s), 1);
	}
	
	@Test
	public void testCompareToEqu() {
		System.out.println("PlayerPersistance - compare to - equals");

		score.setScore(100);
		Score s = new Score();
		s.setScore(100);
		
		assertEquals(score.compareTo(s), 0);
	}
	
	@Test
	public void testEqualsSuccess() {
		setUp();
		
		score.setScore(100);
		Score s = new Score();
		s.setScore(100);
		
		assertTrue(score.equals(s));
		
		tearDown();
	}
	
	@Test
	public void testEqualsFailure() {
		setUp();
		
		score.setScore(100);
		Score s = new Score();
		s.setScore(200);
		
		assertFalse(score.equals(s));
		
		tearDown();
	}
}
