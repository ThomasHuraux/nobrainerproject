package fr.uhp.nobrain.friends;

import java.util.List;

import javax.persistence.*;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.uhp.nobrain.player.Player;
import fr.uhp.nobrain.tools.HibernateUtil;

@Entity
@IdClass(Invitation.class)
public class Invitation implements java.io.Serializable {
	
	private static final long serialVersionUID = 2939295636417063657L;
	private int id;
	private int playerOneId;
	private int playerTwoId;
	
	public Invitation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Invitation(Player player1, Player player2) {
		super();
		this.playerOneId = player1.getId();
		this.playerTwoId = player2.getId();
	}

	public Invitation(int playerOneId, int playerTwoId) {
		super();
		this.playerOneId = playerOneId;
		this.playerTwoId = playerTwoId;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getInvitationId() {
		return id;
	}
	
	public void setInvitationId(int id) {
		this.id = id;
	}
	
	@Id
	@Column(name="playerOneId",insertable=false,updatable=false)
	public int getPlayerOneId() {
		return playerOneId;
	}
	
	@SuppressWarnings("unchecked")
	public String playerOneName() throws Exception {
		HibernateUtil hibernateUtil = new HibernateUtil();
		Session s = hibernateUtil.getSession();
		s.beginTransaction();
		
		Query q = s.createQuery("from Player");
		List<Player> l = q.list();
		
		for (Player p : l)
			if (playerOneId == p.getId())
				return p.getName();

		s.close();
		return null;
	}
	
	public void setPlayerOneId(int playerOneId) {
		this.playerOneId = playerOneId;
	}
	
	@Id
	@Column(name="playerTwoId",insertable=false,updatable=false)
	public int getPlayerTwoId() {
		return playerTwoId;
	}
	
	public void setPlayerTwoId(int playerTwoId) {
		this.playerTwoId = playerTwoId;
	}
	
	@SuppressWarnings("unchecked")
	public String playerTwoName() throws Exception {
		HibernateUtil hibernateUtil = new HibernateUtil();
		Session s = hibernateUtil.getSession();
		s.beginTransaction();
		
		Query q = s.createQuery("from Player");
		List<Player> l = q.list();
		
		for (Player p : l)
			if (playerTwoId == p.getId())
				return p.getName();

		s.close();
		return null;
	}
	
	@Override
	public boolean equals(Object p) {
		if (!(p instanceof Invitation)) return false;
		if (this.getPlayerOneId()==((Invitation)p).getPlayerOneId() && this.getPlayerTwoId() ==((Invitation)p).getPlayerTwoId()
				|| this.getPlayerOneId()==((Invitation)p).getPlayerTwoId() && this.getPlayerTwoId() ==((Invitation)p).getPlayerOneId())
			return true;
		return false;
	}

	@Override
	public int hashCode() {
		return ((Integer)playerOneId).hashCode() ^ ((Integer)playerTwoId).hashCode();
	}
}
