package br.upf.ads.topicos.jpa;

import java.util.List;

import javax.persistence.EntityManager;


/**
 * 
 * @author Jaqson
 *
 * @param <T>
 */
public class GenericDao<T> {

	public GenericDao() {
		
	}
	
	public T find(Object id, Class classe) throws Exception {
		EntityManager em = null;
		try {
			em = JpaUtil.getInstance().getEntityManager(); 
			return (T) em.find(classe, id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
			   em.close();
			} catch (Exception e) { }
		}
	}	
	
	public List<T> createQuery(String hql) throws Exception{
		EntityManager em = null;
		try {
			em = JpaUtil.getInstance().getEntityManager();
			return em.createQuery(hql).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				em.close();
			} catch (Exception e) {
			}
		}
	}
	
	public T merge(T objeto) throws Exception {
		EntityManager em = null;
		try {
			em = JpaUtil.getInstance().getEntityManager(); 
			em.getTransaction().begin();
			objeto = em.merge(objeto);
			em.getTransaction().commit();
			return objeto;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
			   em.close();
			} catch (Exception e) { }
		}
	}	
	
	public void persist(T objeto) throws Exception {
		EntityManager em = null;
		try {
			em = JpaUtil.getInstance().getEntityManager(); 
			em.getTransaction().begin();
			em.persist(objeto);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
			   em.close();
			} catch (Exception e) { }
		}
	}	
	
	public void remove(T objeto) throws Exception {
		EntityManager em = null;
		try {
			em = JpaUtil.getInstance().getEntityManager(); 
			em.getTransaction().begin();
			em.remove(em.merge(objeto));
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
			   em.close();
			} catch (Exception e) { }
		}
	}
	
	public void remove(Object id, Class classe) throws Exception {
		EntityManager em = null;
		try {
			em = JpaUtil.getInstance().getEntityManager(); 
			em.getTransaction().begin();
			em.remove(em.getReference(classe, id));
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
			   em.close();
			} catch (Exception e) { }
		}
	}	
	
	
}
