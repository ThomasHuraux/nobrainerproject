package fr.uhp.nobrain.player;

import java.security.MessageDigest;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.uhp.nobrain.tools.HibernateUtil;

public class PersistTools {

	@SuppressWarnings("unchecked")
	public static boolean persist(Player player) throws Exception {
		return persist((Collection<Player>)player); 
	}
	public static boolean persist(Collection<Player> c) throws Exception {
		HibernateUtil hibernateUtil = new HibernateUtil();
		Session s = hibernateUtil.getSession();
		s.beginTransaction();

		boolean persist = false;
		for (Player player : c)
			if (! alreadyExists(player)) {
				s.save(player);
				persist = true;
				System.out.println("\n>>>>>>>>>>>>>>>>>>>\n" + "Operation reussie !" + "<<<<<<<<<<<<<<<<<<<\n");
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
