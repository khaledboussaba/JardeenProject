package fr.afcepf.ai105.p3.g1.appjardeen.dao;

import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.TypeSol;

public interface TypeSolDao extends GenericDao<TypeSol>{
	

	List<TypeSol> getTypesSol();
}
