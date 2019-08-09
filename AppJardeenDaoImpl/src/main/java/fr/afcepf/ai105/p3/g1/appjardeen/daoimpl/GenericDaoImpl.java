package fr.afcepf.ai105.p3.g1.appjardeen.daoimpl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.afcepf.ai105.p3.g1.appjardeen.dao.GenericDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Actions;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {
	
	//private Class<T> persistentClass;

	@PersistenceContext (unitName = "AppJardeenDS")
	private EntityManager em;
	
	@Override
	public T insert(T t) {
		em.persist(t);
		return t;
	}

	@Override
	public  Boolean remove(T t) {
		t = em.merge(t);
		em.remove(t);
		return true;
	}

	@Override
	public  T update(T t) {
		em.merge(t);
		return t;
	}

	@Override
	public  T findById(Object o) {
		T t = null;
		try {
		String className = ((ParameterizedType)getClass().getGenericSuperclass()).
				getActualTypeArguments()[0].getTypeName();
		Class<?> clazz;
			clazz = Class.forName(className);
			t = (T) em.find(clazz, o);

			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public List<T> getCollection(String queryHQL) {
		TypedQuery<T> q = null;
		String className = ((ParameterizedType)getClass().getGenericSuperclass()).
				getActualTypeArguments()[0].getTypeName();
		Class<?> clazz;
		try {
			clazz = Class.forName(className);
			q = (TypedQuery<T>) em.createQuery(queryHQL, clazz);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return q.getResultList();
		
		//return em.createQuery("Select t from " + persistentClass.getSimpleName() + " t").getResultList();
	}

}
