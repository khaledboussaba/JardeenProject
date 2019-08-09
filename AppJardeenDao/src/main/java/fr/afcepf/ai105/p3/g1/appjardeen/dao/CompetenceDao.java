package fr.afcepf.ai105.p3.g1.appjardeen.dao;

import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Competence;

public interface CompetenceDao extends GenericDao<Competence>{
	
	List<Competence> getAll();
		
}
