package fr.afcepf.ai105.p3.g1.appjardeen.businessimpl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai105.p3.g1.appjardeen.business.ActionsPlanteBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.dao.ActionsPlanteDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Actions;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.ActionsPlante;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Plante;


@Remote(ActionsPlanteBusiness.class)
@Stateless
public class ActionsPlanteBusinessImpl implements ActionsPlanteBusiness{

	@EJB
	private ActionsPlanteDao proxyActionsPlanteDao;
	
	@Override
	public List<Actions> obtenirToutesActionApresNumOrdreByPlante(Plante plante, int numOrdre) {
		return proxyActionsPlanteDao.getAllActionAfterNumOrdreByPlante(plante, numOrdre);
	}
	
	@Override
	public List<ActionsPlante> obtenirToutesActionsPlanteByPlante(Plante plante) {
		return proxyActionsPlanteDao.getAllActionsPlanteByPlante(plante);
	} 
	
	
	@Override
	public ActionsPlante obtenirNumOrdreActionByPlanteAndAction(Actions action, Plante plante) {
		return proxyActionsPlanteDao.getNumOrdreActionByPlanteAndAction(action, plante);
	}
	
	@Override
	public void ajouterActionPlante(ActionsPlante ap) {
		if(proxyActionsPlanteDao.exist(ap.getNumOrdonnancement(), ap.getPlante())) {
			List<ActionsPlante> listAP = proxyActionsPlanteDao.getAllActionsPlanteAfterAP(ap);
			for (ActionsPlante element : listAP) {
				int a = element.getNumOrdonnancement()+1;
				element.setNumOrdonnancement(a);
				proxyActionsPlanteDao.update(element);
			}
		} 
		proxyActionsPlanteDao.insert(ap);
	}
	
	@Override
	public void supprimerActionPlante(int id) {
		proxyActionsPlanteDao.remove(proxyActionsPlanteDao.findById(id));
	}
}
