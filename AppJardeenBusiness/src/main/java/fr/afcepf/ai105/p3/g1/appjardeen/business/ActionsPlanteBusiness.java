package fr.afcepf.ai105.p3.g1.appjardeen.business;

import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Actions;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.ActionsPlante;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Plante;

public interface ActionsPlanteBusiness {
	void ajouterActionPlante(ActionsPlante ap);
	void supprimerActionPlante(int id);
	List<ActionsPlante> obtenirToutesActionsPlanteByPlante(Plante plante);    
	ActionsPlante obtenirNumOrdreActionByPlanteAndAction(Actions action, Plante plante);
	List<Actions> obtenirToutesActionApresNumOrdreByPlante(Plante plante, int numOrdre);
}