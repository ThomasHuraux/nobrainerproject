package fr.uhp.nobrain.highscore;

public class ScoreModel {
	private int score = 0;
	private int level;
	private String name;
	
	public ScoreModel() {
		super();
		this.level = -1;
		this.name = null;
	}

	public ScoreModel(int level, String name) {
		super();
		this.level = level;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
