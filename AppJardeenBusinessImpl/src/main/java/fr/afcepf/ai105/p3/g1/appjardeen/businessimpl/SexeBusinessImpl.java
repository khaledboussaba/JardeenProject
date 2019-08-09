package fr.afcepf.ai105.p3.g1.appjardeen.businessimpl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai105.p3.g1.appjardeen.business.SexeBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.dao.SexeDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Sexe;

@Remote(SexeBusiness.class)
@Stateless
public class SexeBusinessImpl implements SexeBusiness {
	
	@EJB
	private SexeDao proxySexeDao;
	
	@Override
	public List<Sexe> getAll() {
		return proxySexeDao.getCollection("SELECT s FROM Sexe s");
	}

}
