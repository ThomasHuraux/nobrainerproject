package fr.uhp.nobrain.highscore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import fr.uhp.nobrain.player.Player;

@Entity
public class Score implements java.io.Serializable ,java.lang.Comparable<Score>  {

	private static final long serialVersionUID = 1596945168358558464L;
	private int scoreId;
	private int score = 0;
	private int level;
	private int playerId;
	
	public Score() {
		super();
		this.score = 0;
		this.level = 0;
		this.playerId = -1;
	}

	public Score(int level, Player player) {
		super();
		this.score = 0;
		this.level = level;
		this.playerId = player.getId();
	}

	public Score(int level, int playerId) {
		super();
		this.score = 0;
		this.level = level;
		this.playerId = playerId;
	}
	
	@Id
	@Column(name = "scoreId", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getScoreId() {
		return scoreId;
	}

	public void setScoreId(int scoreId) {
		this.scoreId = scoreId;
	}

	@Column(name = "score", nullable = false)
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Column(name = "level", nullable = false)
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Id
	@Column(name="playerId",insertable=false,updatable=false)
	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	
	@Override
	public boolean equals(Object p) {
		if (!(p instanceof Score)) return false;
		if (this.level==((Score)p).getLevel()
				&& this.playerId ==((Score)p).getPlayerId()
				&& this.score == ((Score)p).getScore()
				)
			return true;
		return false;
	}

	public int compareTo(Score other) {
		 int n1 = other.getScore();
	     int n2 = this.getScore();
	     if (n1 > n2)  return -1;
	     else if(n1 == n2) return 0;
	     else return 1;
	}
	
	@Override
	public int hashCode() {
		return ((Integer)playerId).hashCode() ^ ((Integer)level).hashCode() ^ ((Integer)score).hashCode();
	}
}
