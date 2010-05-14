package fr.uhp.nobrain.friends;

import javax.persistence.*;

import fr.uhp.nobrain.player.Player;

@Entity

@IdClass(Invitation.class)
public class Invitation {
	
	private int playerOneId;
	private int playerTwoId;
	private Player playerOne;
	private Player playerTwo;
	
	@Id
	@Column(name = "PlayerOne", insertable = false, updatable = false)
	public int getPlayerOneId() {
		return playerOneId;
	}
	
	public void setPlayerOneId(int playerOneId) {
		this.playerOneId = playerOneId;
	}
	
	@Id
	@Column(name = "PlayerTwo", insertable = false, updatable = false)
	public int getPlayerTwoId() {
		return playerTwoId;
	}
	
	@ManyToOne
	@JoinColumn(name = "PlayerOne")
	public Player getPlayerOne() {
		return playerOne;
	}

	public void setPlayerOne(Player playerOne) {
		this.playerOne = playerOne;
	}

	@ManyToOne
	@JoinColumn(name = "PlayerTwo")
	public Player getPlayerTwo() {
		return playerTwo;
	}

	public void setPlayerTwo(Player playerTwo) {
		this.playerTwo = playerTwo;
	}

	public void setPlayerTwoId(int playerTwoId) {
		this.playerTwoId = playerTwoId;
	}
}
