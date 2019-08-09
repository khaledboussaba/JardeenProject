package fr.afcepf.ai105.p3.g1.appjardeen.dao;

import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;

public interface GenericDao<T> {
	 T insert(T t);
	 Boolean remove(T t);
	 T update(T t);
	 T findById(Object o);
	 List<T> getCollection(String queryHQL);
	 
}
