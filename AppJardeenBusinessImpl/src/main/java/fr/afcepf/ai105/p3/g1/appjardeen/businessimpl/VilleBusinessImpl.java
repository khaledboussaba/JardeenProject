package fr.afcepf.ai105.p3.g1.appjardeen.businessimpl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai105.p3.g1.appjardeen.business.VilleBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.dao.VilleDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Ville;

@Remote(VilleBusiness.class)
@Stateless
public class VilleBusinessImpl implements VilleBusiness {

	@EJB
	private VilleDao proxyVilleDao;

	@Override
	public List<Ville> obtenirToutesLesVilles() {
		return proxyVilleDao.getCollection("Select v from Ville v");
	}

}
