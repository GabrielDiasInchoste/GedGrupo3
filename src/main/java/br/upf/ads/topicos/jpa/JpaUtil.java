package br.upf.ads.topicos.jpa;

import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.jpa.HibernateEntityManager;

/**
 * 
 * @author Jaqson
 *
 */
public class JpaUtil {

	private EntityManagerFactory factory;

	public JpaUtil() {
		
	}

	public static JpaUtil getInstance() {
		return JpaUtilInstance.INSTANCE;
	}

	public EntityManager getEntityManager() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("appged");
		}
		return factory.createEntityManager();
	}

	private static class JpaUtilInstance {
		public static final JpaUtil INSTANCE = new JpaUtil();
		
	}

	/**
	 * Método responsável por obter uma conexão JDBC a partir de uma EntityManager.
	 * Funciona com Hibernate 5.2 ou superior.
	 * @return conexão JDBC com o banco de dados
	 * @throws SQLException
	 */
    public Connection getEntityManagerJDBCConnection() throws SQLException { 
        EntityManager em = getEntityManager();
        @SuppressWarnings("resource")
		Session s = (Session) em;
        SessionImplementor sim = (SessionImplementor) s;
        Connection conexao = sim.connection();
        em.close();
        return conexao; 
    }
    
    /* versões anteriores
	public Connection getEntityManagerJDBCConnection() throws SQLException {
		EntityManager em = getEntityManager();
		HibernateEntityManager hem = (HibernateEntityManager) em;
		SessionImplementor sim = (SessionImplementor) hem.getSession();
		Connection conexao = sim.connection();
		em.close();
		return conexao;
	}
	*/

}
