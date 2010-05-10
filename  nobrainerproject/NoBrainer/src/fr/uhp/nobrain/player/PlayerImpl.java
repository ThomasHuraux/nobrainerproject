package fr.uhp.nobrain.player;

import java.util.Date;

public class PlayerImpl extends Player{

	private String lastname;
	private String firstname;
	private String nickname;
	private Date birth;
	// ? private String password;
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
	
	public int getPlayerId() {
		return playerId;
	}	
	
}
