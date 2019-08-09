package fr.afcepf.ai105.p3.g1.appjardeen.businessimpl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai105.p3.g1.appjardeen.business.HumiditeSolBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.dao.HumiditeSolDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.HumiditeSol;

@Remote(HumiditeSolBusiness.class)
@Stateless
public class HumiditeSolBusinessImpl implements HumiditeSolBusiness {
	
	@EJB
	private HumiditeSolDao proxyHumiditeSolDao;

	@Override
	public List<HumiditeSol> obtenirTousLesHumiditeSol() {
		return proxyHumiditeSolDao.getCollection("SELECT hs FROM HumiditeSol hs");
	}
}
