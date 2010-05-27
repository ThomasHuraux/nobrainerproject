package fr.uhp.nobrain.player;

import java.security.MessageDigest;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.uhp.nobrain.tools.HibernateUtil;

public class PlayerPersistance {

	public static boolean delete(Player player) throws Exception {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		
		boolean result = false;
		
		if (alreadyExists(player)) {
			player.setId(select(player));
			s.delete(player);
			s.flush();
		}
		if (!alreadyExists(player))
			result = true;
			
		s.close();
		
		return result;
	}
	
	/**
	 * Find a player's id in the DB.
	 * @param player
	 * @return id of player.
	 * @throws Exception if the player is not in the DB.
	 */
	@SuppressWarnings("unchecked")
	public static int select(Player player) throws Exception {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		
		Query q = s.createQuery("from Player");
		List<Player> l = q.list();
		
		for (Player p : l)
			if (player.equals(p))
				return p.getId();

		s.close();
		return -1;
	}
	
	@SuppressWarnings("unchecked")
	public static Player select(String player) throws Exception {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		
		Query q = s.createQuery("from Player where name like '" + player + "'");
		List<Player> l = q.list();
		
		s.close();
		return l.get(0);
	}
	
	/**
	 * Persist a player in the DB.
	 * @param player
	 * @return true if the operation is complete.
	 * @throws Exception from HibernateUtil
	 */
	public static boolean persist(Player player) throws Exception {
		Session s = HibernateUtil.getSessionFactory().openSession();
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
	
	/**
	 * Search a player in the DB.
	 * @param player
	 * @return true if the player already exists in the DB.
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static boolean alreadyExists(Player player) throws Exception {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		
		boolean exists = false;
		Query q = s.createQuery("from Player");
		List<Player> l = q.list();
		
		for (Player p : l)
			if (player.equals(p))
				exists = true;

		s.close();
		
		return exists;
	}
	
	/**
	 * Search a player by his id.
	 * @param playerId
	 * @return true if the player already exists. 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static boolean alreadyExists(int playerId) throws Exception {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		
		boolean exists = false;
		Query q = s.createQuery("from Player");
		List<Player> l = q.list();
		
		for (Player p : l)
			if (playerId == p.getId())
				exists = true;

		s.close();
		
		return exists;
	}
	
	/**
	 * Encryption used for the password.
	 * @param password
	 * @return encrypted password.
	 */
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

	/**
	 * Tool for sha1.
	 * @param bytes
	 * @return
	 */
	protected static String bytes2String(byte[] bytes) {
		StringBuilder string = new StringBuilder();
		for (byte b: bytes) {
			String hexString = Integer.toHexString(0x00FF & b);
			string.append(hexString.length() == 1 ? "0" + hexString : hexString);
		}
		return string.toString();
	}
	
}
