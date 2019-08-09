package fr.afcepf.ai105.p3.g1.appjardeen.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Desinscription;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Indisponibilite;

public interface AdherentDao extends GenericDao<Adherent> {
	
	Boolean exist(Adherent adherent);
	Adherent authenticate(String login, String password);
	String getCompetenceAdherent(Adherent adherent);
	String getSexeAdherent(Adherent adherent);
	String getRoleAdherent(Adherent adherent);
	List<Indisponibilite> getIndisponibiliteByAdherent(Adherent adherent);
	List<Adherent> getAll();
	List<Adherent> getByDisponibiliteEtCompetence(Date debut, Date fin, int niveauCompetence);
	List<Adherent> getAllAdherentDisponible(Date dateDebutTache, Date dateFinTache);
	List<Adherent> getAllAdherentInscrit();
	List<Adherent> getAllAdherentDesinscrit();
	List<Adherent> getAllAdherentAInscrire();

}
