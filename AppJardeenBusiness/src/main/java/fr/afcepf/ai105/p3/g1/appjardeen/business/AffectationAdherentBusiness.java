package fr.afcepf.ai105.p3.g1.appjardeen.business;

import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.AffectationAdherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Tache;

public interface AffectationAdherentBusiness {
	
	void desaffecterAdherentTacheById(int idAffectationAdherent);
	AffectationAdherent obtenirAffectationAdherentById(int i);
	void affecterAdherentTache(int idAdherent, int idTache);
	List<Tache> obtenirTacheAffectByIdAdherent(int idAdherent);
	void creationAffectationAdherent(AffectationAdherent affectationAdherent);
	List<Adherent> obtenirAdherentsAffectesByIdTache(int idTache);
	void affecterAdherent(Adherent adherent, Tache tache);
	void desaffecterAdherent(Tache tache, Adherent adherent);
	int obtenirIdAffectation(Tache tache, Adherent adherent);
}
