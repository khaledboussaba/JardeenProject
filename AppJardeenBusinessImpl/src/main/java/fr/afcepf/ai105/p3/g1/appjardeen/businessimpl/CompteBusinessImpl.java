package fr.afcepf.ai105.p3.g1.appjardeen.businessimpl;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai105.p3.g1.appjardeen.business.CompteBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.dao.AdherentDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;

@Remote(CompteBusiness.class)
@Stateless
public class CompteBusinessImpl implements CompteBusiness {

	@EJB
	private AdherentDao proxyAdherentDao;
	
	@Override
	public Adherent createAccount(Adherent adherent) {
		Adherent returneAdherent = null;
		if(!(proxyAdherentDao.exist(adherent))) {
			returneAdherent = proxyAdherentDao.insert(adherent);
		}
		return returneAdherent;
	}

	@Override
	public Adherent connexion(String login, String password) {
		return proxyAdherentDao.authenticate(login, password);
	}

	@Override
	public Adherent registerAdherent(Adherent adherent) {
		proxyAdherentDao.insert(adherent);
		return adherent;
	}

	
}
