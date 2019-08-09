package fr.afcepf.ai105.p3.g1.appjardeen.businessimpl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai105.p3.g1.appjardeen.business.AdherentBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.AffectationAdherentBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.OutilTacheBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.TacheBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.dao.AffectationAdherentDao;
import fr.afcepf.ai105.p3.g1.appjardeen.dao.MotifTacheDao;
import fr.afcepf.ai105.p3.g1.appjardeen.dao.OutilTacheDao;
import fr.afcepf.ai105.p3.g1.appjardeen.dao.TacheDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Actions;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.AffectationAdherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Competence;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.MotifTache;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Outil;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.OutilTache;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Parcelle;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Plante;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Tache;

@Remote(TacheBusiness.class)
@Stateless
public class TacheBusinessImpl implements TacheBusiness{
	
	@EJB
	TacheDao proxyTacheDao;
	@EJB
	MotifTacheDao proxyMotifTacheDao;
	@EJB
	OutilTacheBusiness proxyOutilTacheBusiness;
	@EJB
	AffectationAdherentBusiness proxyAffectationAdherentBusiness;
	@EJB
	OutilTacheDao proxyOutilTacheDao;
	@EJB
	AffectationAdherentDao proxyAffectationAdherentDao;
	
	@Override
	public Tache obtenirTache(int idTache) {
		System.out.println("Id tache :"+idTache);
		System.out.println("Tache :"+proxyTacheDao.findById(idTache));

		return proxyTacheDao.findById(idTache);
	}

	@Override
	public void reporterTache(int idTache, Date dateDebutTache, Date dateFinTache) {
		AdherentBusiness adherentBusiness = new AdherentBusinessImpl();
		List<Adherent> listeAdherentDispo = adherentBusiness.listerAdherentsDisponible(dateDebutTache, dateFinTache);

		Tache t= proxyTacheDao.findById(idTache);
		t.setDateDebutTache(dateDebutTache);
		t.setDateFinTache(dateFinTache);
				
		// Determiner les adherents affectés à cette tache et les notifier
		for (AffectationAdherent ligneAffectationAdherent : t.getAffectationsAdherents()) {
			//L adherent n est pas disponible  donc on le désaffecte
			if (!listeAdherentDispo.contains(ligneAffectationAdherent.getAdherent())){
				MailBusinessImpl.testMail();
//				MailBusinessImpl.notifierAdherent(ligneAffectationAdherent.getAdherent(), t, "pasDispo");
			}else {
				MailBusinessImpl.testMail();
//				MailBusinessImpl.notifierAdherent(ligneAffectationAdherent.getAdherent(), t,  "reportee");
			}
		}
		proxyTacheDao.update(t);

	}

	@Override
	public void annulerTache(int idTache, int idMotif) {
		Tache t = proxyTacheDao.findById(idTache);
		MotifTache m = proxyMotifTacheDao.findById(idMotif);
		t.setDateAnnulationTache(new Date());
		t.setMotifAnnulation(m);
		System.out.println("TACHE -> "+t);
		
		System.out.println("nombre jardeen affecte : "+t.getAffectationsAdherents().size());
		System.out.println("-----REDA------");

		for (AffectationAdherent ligneAffectationAdherent : t.getAffectationsAdherents()) {
			MailBusinessImpl.notifierAdherent(ligneAffectationAdherent.getAdherent(),t, "annulee");
		}
		proxyTacheDao.update(t);

	}
	
	@Override
	public List<Tache> obtenirLesTachesPlanifees() {
		return proxyTacheDao.getCollection("SELECT t FROM Tache t");
	}
	
	@Override
	public List<Tache> obtenirLesTachesPlanifeesEtNonFinies() {
		return proxyTacheDao.getAll();
	}
	
	@Override
	public List<Tache> obtenirLesTachesPlanifeesViaPlante(Plante plante) {
		return proxyTacheDao.getAllTacheByPlante(plante);
	}

	@Override
	public void creationTache (
		String libelleTache,
		Parcelle parcelle,
		Plante plante,
		Actions action,
		Competence competence,
		int nbJardiniers,
		Date dateHeureDebut,
		Date dateHeureFin,
		List<Outil>outilsAffectes,
		List<Outil> quantitesOutilsUtilises,
		List<Adherent>adherentsAffectes) {
		 
		Tache tache = new Tache(
				libelleTache,
				dateHeureDebut,
				dateHeureFin,
				nbJardiniers,
				parcelle,
				action,
				plante,
				competence
				);
			
			Tache tacheCreee = proxyTacheDao.insert(tache);
			for (int i = 0; i < outilsAffectes.size(); i++) {
				OutilTache outilTache = new OutilTache(quantitesOutilsUtilises.get(i).getQuantiteAllouee(), tacheCreee, outilsAffectes.get(i));
				proxyOutilTacheBusiness.creationOutilTache(outilTache);
			}
			for (Adherent adherent : adherentsAffectes) {
				AffectationAdherent affectationAdherent = new AffectationAdherent(adherent, tacheCreee);
				proxyAffectationAdherentBusiness.creationAffectationAdherent(affectationAdherent);
			}		
	}	
	
	
	
	@Override
	public Tache obtenirDerniereTachePlanifee(Parcelle p ) {
		return proxyTacheDao.getLastTacheInParcelle(p);
	}

	@Override
	public List<Tache> listerTachesDuJour() {
		return proxyTacheDao.getTachesDuJour();
	}

	@Override
	public void modifierTache(Tache tache, String libelleTache, Parcelle parcelle, Plante plante, Actions action,
			Competence competence, int nbJardiniers) {
		tache.setLibelleTache(libelleTache);
		tache.setParcelle(parcelle);
		tache.setPlante(plante);
		tache.setAction(action);
		tache.setCompetence(competence);
		tache.setNbAdherentRequis(nbJardiniers);
		proxyTacheDao.update(tache);
		
	}

	@Override
	public void editionTache(
			Tache tacheAEditer,
			String libelleTache,
			Parcelle parcelle,
			Plante plante,
			Actions action,
			Competence competence,
			int nbJardiniers,
			Date dateHeureDebut,
			Date dateHeureFin,
			List<Outil>outilsAffectes,
			List<Outil> quantitesOutilsUtilises,
			List<Adherent>adherentsAffectes) {

		for (int i = 0; i < tacheAEditer.getOutilTache().size(); i++) {
			proxyOutilTacheDao.remove(tacheAEditer.getOutilTache().get(i));
		}
		for (int i = 0; i < tacheAEditer.getAffectationsAdherents().size(); i++) {
			proxyAffectationAdherentDao.remove(tacheAEditer.getAffectationsAdherents().get(i));
		}		

		tacheAEditer.setLibelleTache(libelleTache);
		tacheAEditer.setParcelle(parcelle);
		tacheAEditer.setPlante(plante);
		tacheAEditer.setAction(action);
		tacheAEditer.setCompetence(competence);
		tacheAEditer.setNbAdherentRequis(nbJardiniers);
		tacheAEditer.setDateDebutTache(dateHeureDebut);
		tacheAEditer.setDateFinTache(dateHeureFin);
	
				Tache tacheEditee = proxyTacheDao.update(tacheAEditer);
				for (int i = 0; i < outilsAffectes.size(); i++) {
					OutilTache outilTache = new OutilTache(quantitesOutilsUtilises.get(i).getQuantiteAllouee(), tacheEditee, outilsAffectes.get(i));
					proxyOutilTacheBusiness.creationOutilTache(outilTache);
				}
				for (Adherent adherent : adherentsAffectes) {
					AffectationAdherent affectationAdherent = new AffectationAdherent(adherent, tacheEditee);
					proxyAffectationAdherentBusiness.creationAffectationAdherent(affectationAdherent);
				}		
	}
}