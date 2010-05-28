package fr.uhp.nobrain.player;

import javax.persistence.*;

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
		this.pwd = pwd;
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
		this.pwd = pwd;
	}

	public boolean isFriend(Player player) {
		return false;
	}

//	@Override
	public boolean equals(Player p) {
		if (!(p instanceof Player)) return false;
		System.out.println(this.getPwd() + "\n" + p.getPwd());
		if (this.getName().equals(((Player)p).getName()) 
				&& this.getPwd().equals(p.getPwd()))
			return true;
		return false;
	}

	@Override
	public int hashCode() {
		return name.hashCode() ^ pwd.hashCode();
	}
}
