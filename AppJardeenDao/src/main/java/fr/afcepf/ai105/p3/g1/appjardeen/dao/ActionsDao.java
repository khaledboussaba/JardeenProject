package fr.afcepf.ai105.p3.g1.appjardeen.dao;

import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Actions;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Competence;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Plante;

public interface ActionsDao extends GenericDao<Actions>{
	List<Actions> getAll();
	List<Actions> getAllActionNonDejaOrdonnanceeByPlante(Plante plante);
	List<Actions> getAllActionRestanteAFaire(int numOrdre);
	Competence getCompetenceByAction(Actions action);
}
