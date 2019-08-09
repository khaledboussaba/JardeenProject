package fr.afcepf.ai105.p3.g1.appjardeen.businessimpl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai105.p3.g1.appjardeen.business.MotifDesinscriptionBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.dao.MotifDesinscriptionDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.MotifDesinscription;

@Remote(MotifDesinscriptionBusiness.class)
@Stateless
public class MotifDesinscriptionBusinessImpl implements MotifDesinscriptionBusiness {

	@EJB
	private MotifDesinscriptionDao proxyMotifDesinscription;
	
	@Override
	public List<MotifDesinscription> obtenirTousLesMotifsDesinscription() {
		List<MotifDesinscription> motifs = proxyMotifDesinscription.getAll();
		return motifs;
	}


}
