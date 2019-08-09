package fr.afcepf.ai105.p3.g1.appjardeen.businessimpl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai105.p3.g1.appjardeen.business.PlanteBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.dao.PlanteDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Plante;

@Remote(PlanteBusiness.class)
@Stateless
public class PlanteBusinessImpl implements PlanteBusiness{

	@EJB
	private PlanteDao proxyPlanteDao;
	
	@Override
	public List<Plante> listerPlantes() {
		List<Plante> plantes = proxyPlanteDao.getAll();
		return plantes;
	}
}