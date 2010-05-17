package fr.uhp.nobrain.tools;

import java.sql.*;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory object.
 *
 * @author halaskaf
 */
public class HibernateUtil {
	private Session session;
	private Statement st;

	public HibernateUtil() throws Exception{
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		session = sessionFactory.openSession();

		// Load the JDBC driver.
		Class.forName("org.gjt.mm.mysql.Driver");
		// Establish the connection to the database.
		String url = "jdbc:mysql://localhost/NoBrainer";

		Connection conn = DriverManager.getConnection(url, "root", "adminpwd");
		st = conn.createStatement();
	}

	public Session getSession() {
		return session;
	}

	public Statement getSt() {
		return st;
	}

}
