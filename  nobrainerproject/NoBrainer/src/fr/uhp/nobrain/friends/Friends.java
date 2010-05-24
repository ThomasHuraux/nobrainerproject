package fr.uhp.nobrain.friends;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.uhp.nobrain.player.Player;
import fr.uhp.nobrain.tools.HibernateUtil;

@Entity
@IdClass(Friends.class)
public class Friends implements java.io.Serializable {

	private static final long serialVersionUID = -5545911151115192042L;
	private int id;
	private int playerOneId;
	private int playerTwoId;
	
	public Friends() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Friends(Invitation invitation) {
		this.playerOneId = invitation.getInvitationId();
		this.playerTwoId = invitation.getPlayerTwoId();
	}

	public Friends(Player player1, Player player2) {
		super();
		this.playerOneId = player1.getId();
		this.playerTwoId = player2.getId();
	}

	public Friends(int playerOneId, int playerTwoId) {
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
	public String getPlayerOneName() throws Exception {
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
	
	public void setPlayerOneName(String name) {
		
	}
	
	@Id
	@Column(name="playerTwoId",insertable=false,updatable=false)
	public int getPlayerTwoId() {
		return playerTwoId;
	}
	
	public void setPlayerTwoId(int playerTwoId) {
		this.playerTwoId = playerTwoId;
	}
	
	public void setPlayerTwoName(String name) {
		
	}
	
	@SuppressWarnings("unchecked")
	public String getPlayerTwoName() throws Exception {
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
		if (!(p instanceof Friends)) return false;
		if (this.getPlayerOneId()==((Friends)p).getPlayerOneId() && this.getPlayerTwoId() ==((Friends)p).getPlayerTwoId()
				|| this.getPlayerOneId()==((Friends)p).getPlayerTwoId() && this.getPlayerTwoId() ==((Friends)p).getPlayerOneId())
			return true;
		return false;
	}

	@Override
	public int hashCode() {
		return ((Integer)playerOneId).hashCode() ^ ((Integer)playerTwoId).hashCode();
	}
}
