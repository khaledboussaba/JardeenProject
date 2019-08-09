package fr.afcepf.ai105.p3.g1.appjardeen.businessimpl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai105.p3.g1.appjardeen.business.DesinscriptionBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.dao.DesinscriptionDao;
import fr.afcepf.ai105.p3.g1.appjardeen.dao.MotifDesinscriptionDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Desinscription;

@Remote(DesinscriptionBusiness.class)
@Stateless
public class DesinscriptionBusinessImpl implements DesinscriptionBusiness{

	@EJB
	private DesinscriptionDao proxyDesinscriptionDao;
	
	@Override
	public Desinscription enregistrerDesinscription(Desinscription desinscription) {
		proxyDesinscriptionDao.insert(desinscription);
		return desinscription;
	}

	@Override
	public List<Desinscription> obtenirDesinscriptionsByAdherent(Adherent adherent) {
		return proxyDesinscriptionDao.getAllDesinscriptionsByAdherent(adherent);
	}

	@Override
	public void retirerDesinscription(Desinscription desinscription) {
		proxyDesinscriptionDao.remove(desinscription);
	}

	@Override
	public List<Adherent> obtenirListeAdherentsDesinscrit() {
		return proxyDesinscriptionDao.getAll();
	}

}
