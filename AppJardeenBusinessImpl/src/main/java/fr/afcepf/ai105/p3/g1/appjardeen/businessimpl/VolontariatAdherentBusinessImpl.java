package fr.afcepf.ai105.p3.g1.appjardeen.businessimpl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai105.p3.g1.appjardeen.business.VolontariatAdherentBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.dao.VolontariatAdherentDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Indisponibilite;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Tache;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.VolontariatAdherent;

@Remote(VolontariatAdherentBusiness.class)
@Stateless
public class VolontariatAdherentBusinessImpl implements VolontariatAdherentBusiness {

	@EJB
	VolontariatAdherentDao proxyVolontariat;
		
	@Override
	public List<Tache> obtenirTacheVolontariatByAdherent(int idAdherent) {
		return proxyVolontariat.getTacheVolontariatByIdAdherent(idAdherent) ;
	}

	@Override
	public void insertVolontariat(Adherent adherent, Tache tache) {
		VolontariatAdherent volontariat = new VolontariatAdherent();
		volontariat.setAdherent(adherent);
		volontariat.setTache(tache);
		proxyVolontariat.insert(volontariat);
		
	}

	@Override
	public List<Adherent> obtenirAdherentsVolontaireByIdTache(Tache tache) {
		
		return proxyVolontariat.getAdherentsVolontaireByIdTache(tache);
	}

}
