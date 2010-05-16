package fr.uhp.nobrain.player;

import java.security.MessageDigest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player implements java.io.Serializable {

	private static final long serialVersionUID = 1073256708139002061L;
	private int id;
	private String name;
	private String pwd;
	
	public Player() {}
	
	public Player(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = sha1(pwd);
	}
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
	
	@Column(name = "name", nullable = false, length = 10)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "pwd", nullable = false, length = 64)
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = sha1(pwd);
	}

	@Override
	public boolean equals(Object p) {
		if (!(p instanceof Player)) return false;
		if (this.getName().equals(((Player)p).getName()) && sha1(this.getPwd()).equals(((Player) p).getPwd()))
			return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode() ^ pwd.hashCode();
	}
	
	private static String sha1(String password) {
		String res = "";
		try {
			MessageDigest sha1 = MessageDigest.getInstance("SHA1");
			byte[] digest = sha1.digest((password).getBytes());
			res = bytes2String(digest);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return res;
	}	

	private static String bytes2String(byte[] bytes) {
		StringBuilder string = new StringBuilder();
		for (byte b: bytes) {
			String hexString = Integer.toHexString(0x00FF & b);
			string.append(hexString.length() == 1 ? "0" + hexString : hexString);
		}
		return string.toString();
	}
}
