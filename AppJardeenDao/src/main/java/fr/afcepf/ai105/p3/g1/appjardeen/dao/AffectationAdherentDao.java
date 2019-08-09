package fr.afcepf.ai105.p3.g1.appjardeen.dao;

import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.AffectationAdherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Tache;

public interface AffectationAdherentDao extends GenericDao<AffectationAdherent>{

	List<Tache> getTacheByIdAdherent(int idAdherent);
	List<Adherent> getAdherentsAffectesByTache(int idTache);
	int getIdAffectation(Adherent adherent, Tache tache);
	
}
