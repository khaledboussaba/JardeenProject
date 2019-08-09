package fr.afcepf.ai105.p3.g1.appjardeen.businessimpl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai105.p3.g1.appjardeen.business.AdherentBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.dao.AdherentDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Competence;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Desinscription;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Indisponibilite;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Sexe;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Role;

@Remote(AdherentBusiness.class)
@Stateless
public class AdherentBusinessImpl implements AdherentBusiness{
	
	@EJB 
	private AdherentDao proxyAdherentDao; 
	
	@Override
	public Adherent obtenirAdherent(int idAdherent) {
		return proxyAdherentDao.findById(idAdherent);
	}

	@Override
	public String competence(Adherent adherent) {
		return proxyAdherentDao.getCompetenceAdherent(adherent);
	}

	@Override
	public String sexe(Adherent adherent) {
		return proxyAdherentDao.getSexeAdherent(adherent);
	}

	@Override
	public String role(Adherent adherent) {
		return proxyAdherentDao.getRoleAdherent(adherent);
	}
	
	@Override
	public List<Adherent> listerAdherents() {
		List<Adherent> adherents = proxyAdherentDao.getAll();
		return adherents;
	}
	
	@Override
	public List<Indisponibilite> displayIndisponibilite(Adherent adherent) {
		return proxyAdherentDao.getIndisponibiliteByAdherent(adherent);
	}
	
	@Override
	public List<Adherent> listerAdherentsDisponiblesEtCompetents(Date debut, Date fin, int niveauCompetence) {
		List<Adherent> adherentsDisponibles = proxyAdherentDao.getByDisponibiliteEtCompetence(debut, fin, niveauCompetence);
		return adherentsDisponibles;
	}
	
	@Override
	public List<Adherent> listerAdherentsDisponible(Date dateDebutTache, Date dateFinTache) {
		
		return proxyAdherentDao.getAllAdherentDisponible(dateDebutTache, dateFinTache);
	}

	@Override
	public void modifierInfoAdherent(Adherent adherent, String log, String motDePasse
			, String email, String tel, String nom, String prenom, Date dateNaissance, Competence competence, Sexe sexe) {
		
		adherent.setLogin(log);
		adherent.setPassword(motDePasse);
		adherent.setEmail(email);
		adherent.setTelephone(tel);
		adherent.setNomNaissance(nom);
		adherent.setPrenom(prenom);
		adherent.setDateDeNaissance(dateNaissance);
		adherent.setCompetence(competence);
		adherent.setSexe(sexe);
		proxyAdherentDao.update(adherent);
			
	}
//methode arthur
	@Override
	public void modifierRoleAdherent(Adherent adherent, Role role) {
		
	}


	@Override
	public List<Adherent> listerAdherentsInscrit() {
		List<Adherent> adherents = proxyAdherentDao.getAllAdherentInscrit();
		return adherents;
	}
	
	@Override
	public List<Adherent> listerAdherentsDesinscrit() {
		List<Adherent> adherents = proxyAdherentDao.getAllAdherentDesinscrit();
		return adherents;
	}

	@Override
	public List<Adherent> listerAdherentsAInscrire() {
		List<Adherent> adherents = proxyAdherentDao.getAllAdherentAInscrire();
		return adherents;
	}

}
