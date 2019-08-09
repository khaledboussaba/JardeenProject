package fr.afcepf.ai105.p3.g1.appjardeen.dao;

import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.MotifDesinscription;

public interface MotifDesinscriptionDao extends GenericDao<MotifDesinscription>{

	List<MotifDesinscription> getAll();
	
}
