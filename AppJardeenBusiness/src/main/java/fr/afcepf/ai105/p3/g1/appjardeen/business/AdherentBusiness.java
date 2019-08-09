package fr.afcepf.ai105.p3.g1.appjardeen.business;

import java.util.Date;
import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Competence;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Desinscription;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Indisponibilite;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Role;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Sexe;

public interface AdherentBusiness {
	
	Adherent obtenirAdherent(int idAdherent);
	String competence(Adherent adherent);
	String sexe(Adherent adherent);
	String role(Adherent adherent);
	List <Indisponibilite>displayIndisponibilite(Adherent adherent);
	
	void modifierInfoAdherent(Adherent adherent, String login, String motDePasse, String email, String tel, 
			String nom, String prenom, Date dateNaissance, Competence competence, Sexe sexe);
	List<Adherent> listerAdherents();
	List<Adherent> listerAdherentsDisponiblesEtCompetents(Date debut, Date fin, int niveauCompetence);
	List<Adherent> listerAdherentsDisponible(Date dateDebutTache, Date dateFinTache);
	//methode arthur
		void modifierRoleAdherent(Adherent adherent, Role role);
	List<Adherent> listerAdherentsInscrit();
	List<Adherent> listerAdherentsDesinscrit();
	List<Adherent> listerAdherentsAInscrire();
		
}
