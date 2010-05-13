package fr.uhp.nobrain.test.player;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.uhp.nobrain.player.Player;
import fr.uhp.nobrain.tools.HibernateUtil;

public class TestPersistence {
	
    public static void main(String[] args) {
    	
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        
        
        Player player1 = new Player();
        player1.setFirstname("Thomas");
        player1.setLastname("Huraux");
        player1.setNickname("toto");
        player1.setPassword("ght1pca3");
        
        Player player2 = new Player();
        player2.setFirstname("Christophe");
        player2.setLastname("Labedan");
        player2.setNickname("tof");
        player2.setPassword("ght1pca3");
        
        s.save(player1);
        s.save(player2);
        
        s.getTransaction().commit();
        Query q = s.createQuery("from Player");
        List<Player> l = q.list();
        for (Player o : l) {
            System.out.println(o.getFirstname());
        }
        s.close();
    }

}
