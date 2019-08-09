package fr.afcepf.ai105.p3.g1.appjardeen.dao;

import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Actions;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.ActionsPlante;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Plante;

public interface ActionsPlanteDao extends GenericDao<ActionsPlante>{
	List<ActionsPlante> getAllActionsPlanteByPlante(Plante plante);
	List<ActionsPlante> getAllActionsPlanteAfterAP(ActionsPlante ap);
	Boolean exist(int numOrdre, Plante p);
	ActionsPlante getNumOrdreActionByPlanteAndAction(Actions action, Plante plante);
	List<Actions> getAllActionAfterNumOrdreByPlante(Plante p, int numOrdre);

}
