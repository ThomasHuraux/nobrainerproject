package fr.uhp.nobrain.friends;

import javax.persistence.*;

import fr.uhp.nobrain.player.Player;

@Entity
@Table(name="Friendships")
public class FriendsServer implements java.io.Serializable {
	
	private static final long serialVersionUID = -5304878832454326869L;
	private int id;
    private Player player;
    private Player friend;
    
    
	public FriendsServer() {}
	public FriendsServer(Player player, Player friend) {
		this.player = player;
		this.friend = friend;
	}

	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@OneToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "player")
	@PrimaryKeyJoinColumn
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@OneToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "player")
	@PrimaryKeyJoinColumn
	public Player getFriend() {
		return friend;
	}

	public void setFriend(Player friend) {
		this.friend = friend;
	}
}
