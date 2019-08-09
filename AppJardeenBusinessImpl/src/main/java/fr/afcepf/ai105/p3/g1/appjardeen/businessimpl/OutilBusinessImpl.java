package fr.afcepf.ai105.p3.g1.appjardeen.businessimpl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai105.p3.g1.appjardeen.business.OutilBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.dao.OutilDao;
import fr.afcepf.ai105.p3.g1.appjardeen.dao.OutilTacheDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Actions;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Outil;

@Remote(OutilBusiness.class)
@Stateless
public class OutilBusinessImpl implements OutilBusiness {

	@EJB 
	OutilDao proxyOutilDao;
	@EJB 
	OutilTacheDao proxyOutilTacheDao;
	
	@Override
	public List<Outil> listerOutilsDisponiblesRecommandes(Date dateHeureDebut, Date dateHeureFin, Actions action) {
		List<Outil> outils = proxyOutilDao.getByDateAndAction(dateHeureDebut, dateHeureFin, action);
		for (Outil outil : outils) {
			int quantiteUtilisee = proxyOutilTacheDao.getQuantiteUtilisee(dateHeureDebut, dateHeureFin, outil);
			outil.setQuantiteOutilTotale(outil.getQuantiteOutilTotale() - quantiteUtilisee);
		}
		return outils;
	}

	@Override
	public List<Outil> listerOutilsDisponibles(Date dateHeureDebut, Date dateHeureFin, List<Outil> outilsAffectes) {
		List<Outil> outils = proxyOutilDao.getByDate(dateHeureDebut, dateHeureFin);
		for (int i = 0; i < outilsAffectes.size(); i++) {
			outils.remove(outilsAffectes.get(i));
		}
		for (Outil outil : outils) {
			int quantiteUtilisee = proxyOutilTacheDao.getQuantiteUtilisee(dateHeureDebut, dateHeureFin, outil);
			outil.setQuantiteOutilTotale(outil.getQuantiteOutilTotale() - quantiteUtilisee);
		}
		return outils;
	}

	@Override
	public List<Outil> listerOutils() {
		List<Outil> outils = proxyOutilDao.getAll();
		return outils;
	}

	@Override
	public List<Outil> modificationQuantiteOutils(Outil ouuuut) {
		proxyOutilDao.update(ouuuut);
		return null;
	}
}
