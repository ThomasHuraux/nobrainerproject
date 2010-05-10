package fr.uhp.nobrain.highscore;

@SuppressWarnings("unchecked")
public class Score implements java.lang.Comparable{

	private String name;
	private int score;
	private int level;
	
	public String getPlayerName() {
		return name;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}

	public int compareTo(Object other) {
	     int n1 = ((Score) other).getScore(); 
	     int n2 = this.getScore(); 
	     if (n1 > n2)  return -1; 
	     else if(n1 == n2) return 0; 
	     else return 1; 
	}	
}
