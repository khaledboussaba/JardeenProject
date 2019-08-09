package fr.afcepf.ai105.p3.g1.appjardeen.business;

import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Actions;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Competence;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Plante;

public interface ActionsBusiness {
	List<Actions> listerActions();
	List<Actions> listeActionsNonDejaOrdonnanceeByPlante(Plante plante);
	Competence obtenirCompetenceSelonAction(Actions action);
}
