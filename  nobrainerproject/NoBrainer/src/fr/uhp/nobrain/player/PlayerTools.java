package fr.uhp.nobrain.player;

import java.security.MessageDigest;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.uhp.nobrain.tools.HibernateUtil;

public class PlayerTools {

	@SuppressWarnings("unchecked")
	public static int select(Player player) throws Exception {
		HibernateUtil hibernateUtil = new HibernateUtil();
		Session s = hibernateUtil.getSession();
		s.beginTransaction();
		
		Query q = s.createQuery("from Player");
		List<Player> l = q.list();
		
		for (Player p : l)
			if (player.equals(p))
				return p.getId();

		s.close();
		return -1;
	}
	
	public static boolean persist(Player player) throws Exception {
		HibernateUtil hibernateUtil = new HibernateUtil();
		Session s = hibernateUtil.getSession();
		s.beginTransaction();

		boolean persist = false;
		if (! alreadyExists(player)) {
			s.save(player);
			persist = true;
		}
		else System.out.println("Impossible d'enregistrer " + player.getName() 
				+ " car il existe deja dans la table");

		s.flush();
		s.getTransaction().commit();
		s.close();
		
		return persist;
	}
	
	@SuppressWarnings("unchecked")
	public static boolean alreadyExists(Player player) throws Exception {
		HibernateUtil hibernateUtil = new HibernateUtil();
		Session s = hibernateUtil.getSession();
		s.beginTransaction();
		
		boolean exists = false;
		Query q = s.createQuery("from Player");
		List<Player> l = q.list();
		
		for (Player p : l) {
			if (player.equals(p)) {
				exists = true;
				return exists;
			}
		}

		s.close();
		
		return exists;
	}
	
	@SuppressWarnings("unchecked")
	public static boolean alreadyExists(int playerId) throws Exception {
		HibernateUtil hibernateUtil = new HibernateUtil();
		Session s = hibernateUtil.getSession();
		s.beginTransaction();
		
		Query q = s.createQuery("from Player");
		List<Player> l = q.list();
		
		for (Player p : l)
			if (playerId == p.getId())
				return true;

		s.close();
		
		return false;
	}
	
	protected static String sha1(String password) {
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

	protected static String bytes2String(byte[] bytes) {
		StringBuilder string = new StringBuilder();
		for (byte b: bytes) {
			String hexString = Integer.toHexString(0x00FF & b);
			string.append(hexString.length() == 1 ? "0" + hexString : hexString);
		}
		return string.toString();
	}
	
}
