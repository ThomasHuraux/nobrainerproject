package fr.uhp.nobrain.highscore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.uhp.nobrain.player.Player;

@Entity
@Table(name="HighScore")
public class ScoreModel implements java.io.Serializable {

	private static final long serialVersionUID = 1596945168358558464L;
	private int scoreId;
	private int score = 0;
	private int level;
	private int playerId;
	
	public ScoreModel() {
		super();
		this.score = -1;
		this.level = -1;
		this.playerId = -1;
	}

	public ScoreModel(int level, Player player) {
		super();
		this.score = -1;
		this.level = level;
		this.playerId = player.getId();
	}

	public ScoreModel(int level, int playerId) {
		super();
		this.score = -1;
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
		if (!(p instanceof ScoreModel)) return false;
		if (this.level==((ScoreModel)p).getLevel()
				&& this.playerId ==((ScoreModel)p).getPlayerId()
				&& this.score == ((ScoreModel)p).getScore()
				)
			return true;
		return false;
	}

	@Override
	public int hashCode() {
		return ((Integer)playerId).hashCode() ^ ((Integer)level).hashCode() ^ ((Integer)score).hashCode();
	}
}
