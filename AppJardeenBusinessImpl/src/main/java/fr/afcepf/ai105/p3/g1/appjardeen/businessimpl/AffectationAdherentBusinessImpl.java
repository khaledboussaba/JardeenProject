package fr.afcepf.ai105.p3.g1.appjardeen.businessimpl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai105.p3.g1.appjardeen.business.AffectationAdherentBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.dao.AdherentDao;
import fr.afcepf.ai105.p3.g1.appjardeen.dao.AffectationAdherentDao;
import fr.afcepf.ai105.p3.g1.appjardeen.dao.TacheDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.AffectationAdherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Tache;

@Remote(AffectationAdherentBusiness.class)
@Stateless
public class AffectationAdherentBusinessImpl implements AffectationAdherentBusiness {

	@EJB 
	AffectationAdherentDao proxyAffectationAdherentDao;
	@EJB 
	AdherentDao proxyAdherentDao; 
	@EJB 
	TacheDao proxyTacheDao;	
	
	public AffectationAdherent obtenirAffectationAdherentById(int i) {
		return proxyAffectationAdherentDao.findById(i);
	}
	
	@Override
	public void affecterAdherentTache(int idAdherent, int idTache) {
		Adherent adherent = proxyAdherentDao.findById(idAdherent);
		Tache tache = proxyTacheDao.findById(idTache);
		
		AffectationAdherent a = new AffectationAdherent();
		a.setAdherent(adherent);
		a.setTache(tache);
		this.proxyAffectationAdherentDao.insert(a);
	}

	@Override
	public void desaffecterAdherentTacheById(int idAffectationAdherent) {
		AffectationAdherent a = proxyAffectationAdherentDao.findById(idAffectationAdherent);
		this.proxyAffectationAdherentDao.remove(a);	
	}

	@Override
	public List<Tache> obtenirTacheAffectByIdAdherent(int idAdherent) {
		List<Tache> taches = proxyAffectationAdherentDao.getTacheByIdAdherent(idAdherent);
		return taches;
	}

	@Override
	public void creationAffectationAdherent(AffectationAdherent affectationAdherent) {
		proxyAffectationAdherentDao.insert(affectationAdherent);
	}

	@Override
	public List<Adherent> obtenirAdherentsAffectesByIdTache(int idTache) {
		
		return proxyAffectationAdherentDao.getAdherentsAffectesByTache(idTache);
	}

	@Override
	public void affecterAdherent(Adherent adherent, Tache tache) {
		AffectationAdherent a = new AffectationAdherent();
		a.setAdherent(adherent);
		a.setTache(tache);
		this.proxyAffectationAdherentDao.insert(a);
		
	}

	@Override
	public void desaffecterAdherent(Tache tache, Adherent adherent) {
		AffectationAdherent affAdherent = new AffectationAdherent();
		affAdherent.setAdherent(adherent);
		affAdherent.setTache(tache);
		proxyAffectationAdherentDao.remove(affAdherent);
		
	}

	@Override
	public int obtenirIdAffectation(Tache tache, Adherent adherent) {
		
		return proxyAffectationAdherentDao.getIdAffectation(adherent, tache);
	}
}