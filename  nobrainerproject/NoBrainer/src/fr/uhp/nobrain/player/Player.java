package fr.uhp.nobrain.player;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Player{

	private String lastname;
	private String firstname;
	private String nickname;
	private Date birth;
	private String password;
	private int playerId;
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public Date getBirth() {
		return birth;
	}
	
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getPlayerId() {
		return playerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}	
	
}
