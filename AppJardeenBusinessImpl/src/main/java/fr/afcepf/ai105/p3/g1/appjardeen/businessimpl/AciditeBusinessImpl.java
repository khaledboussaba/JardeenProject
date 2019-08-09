package fr.afcepf.ai105.p3.g1.appjardeen.businessimpl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai105.p3.g1.appjardeen.business.AciditeBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.dao.AciditeDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Acidite;

@Remote(AciditeBusiness.class)
@Stateless
public class AciditeBusinessImpl implements AciditeBusiness{

	@EJB
	private AciditeDao proxyAcidite;

	@Override
	public List<Acidite> obtenirAcidite() {
		List<Acidite> acidites = proxyAcidite.getCollection("select a from Acidite a");
		return acidites;
	}

	@Override
	public List<Acidite> obtenirTousLesAcidites() {
		return proxyAcidite.getCollection("SELECT a FROM Acidite a");
	}
	
	
}
