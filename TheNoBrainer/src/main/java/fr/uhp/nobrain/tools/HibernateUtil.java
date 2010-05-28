package fr.uhp.nobrain.tools;

import java.sql.*;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory object.
 *
 * @author halaskaf
 */
public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	private static Statement st;

	static{
		try {
		sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();

		Class.forName("org.gjt.mm.mysql.Driver");
		String url = "jdbc:mysql://db4free.net:3306/nobrainer";

		Connection conn = DriverManager.getConnection(url, "nobrainer", "nobrainerpwd");
		st = conn.createStatement();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public Statement getSt() {
		return st;
	}

}
