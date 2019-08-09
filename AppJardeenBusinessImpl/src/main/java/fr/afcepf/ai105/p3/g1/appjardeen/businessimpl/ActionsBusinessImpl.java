package fr.afcepf.ai105.p3.g1.appjardeen.businessimpl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai105.p3.g1.appjardeen.business.ActionsBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.dao.ActionsDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Actions;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Competence;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Plante;

@Remote(ActionsBusiness.class)
@Stateless
public class ActionsBusinessImpl implements ActionsBusiness{

	@EJB
	private ActionsDao proxyActionsDao;
	
	@Override
	public List<Actions> listerActions() {
		List<Actions> actions = proxyActionsDao.getAll();
		return actions;
	}
	
	@Override
	public List<Actions> listeActionsNonDejaOrdonnanceeByPlante(Plante plante){
		return proxyActionsDao.getAllActionNonDejaOrdonnanceeByPlante(plante);
		
	}

	@Override
	public Competence obtenirCompetenceSelonAction(Actions action) {
		return proxyActionsDao.getCompetenceByAction(action);
	}

}
