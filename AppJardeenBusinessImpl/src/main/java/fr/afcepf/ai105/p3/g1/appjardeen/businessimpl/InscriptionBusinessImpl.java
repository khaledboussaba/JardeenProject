package fr.afcepf.ai105.p3.g1.appjardeen.businessimpl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai105.p3.g1.appjardeen.business.InscriptionBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.dao.InscriptionDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Inscription;

@Remote(InscriptionBusiness.class)
@Stateless
public class InscriptionBusinessImpl implements InscriptionBusiness{

	@EJB
	private InscriptionDao proxyInscriptionDao;
	
	@Override
	public void ajouterUneInscription(Inscription inscription) {
		proxyInscriptionDao.insert(inscription);
	}

	@Override
	public String obtenirDerniereDateInscription(Adherent adherent) {
		return proxyInscriptionDao.getLastIncriptionDateByAdherent(adherent);
	}

	@Override
	public List<Adherent> obtenirListeAdherentsInscriptionArrivantAEcheance() {
		return proxyInscriptionDao.getAllAdherentsInscriptionArrivantAEcheance();
	}

}
