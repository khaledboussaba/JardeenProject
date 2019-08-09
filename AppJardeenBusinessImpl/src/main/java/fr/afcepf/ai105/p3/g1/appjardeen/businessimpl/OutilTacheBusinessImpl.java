package fr.afcepf.ai105.p3.g1.appjardeen.businessimpl;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai105.p3.g1.appjardeen.business.OutilTacheBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.dao.OutilTacheDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.OutilTache;

@Remote(OutilTacheBusiness.class)
@Stateless
public class OutilTacheBusinessImpl implements OutilTacheBusiness{

	@EJB
	OutilTacheDao proxyOutilTacheDao;
	
	@Override
	public void creationOutilTache(OutilTache outilTache) {
		proxyOutilTacheDao.insert(outilTache);
	}
}
