package fr.afcepf.ai105.p3.g1.appjardeen.business;

import java.util.Date;
import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Actions;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Competence;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Outil;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Parcelle;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Plante;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Tache;

public interface TacheBusiness {
	
	Tache obtenirTache(int idTache);
	
	void annulerTache(int idTache, int idMotif);
	
	void reporterTache(int idTache, Date dateDebutTache, Date dateFinTache);
	
	List<Tache> obtenirLesTachesPlanifees();
	
	void creationTache(
		String libelleTache,
		Parcelle parcelle,
		Plante plante,
		Actions action,
		Competence competence,
		int nbJardiniers,
		Date dateHeureDebut,
		Date dateHeureFin,
		List<Outil>outilsAffectes,
		List<Outil> quantitesOutilsUtilises,
		List<Adherent>adherentsAffectes
		);
	
	void editionTache(
			Tache tacheAEditer,
			String libelleTache,
			Parcelle parcelle,
			Plante plante,
			Actions action,
			Competence competence,
			int nbJardiniers,
			Date dateHeureDebut,
			Date dateHeureFin,
			List<Outil>outilsAffectes,
			List<Outil> quantitesOutilsUtilises,
			List<Adherent>adherentsAffectes
			);
	
	void modifierTache(Tache tache, String libelleTache,
						Parcelle parcelle, Plante plante,
						Actions action,	Competence competence,
						int nbJardiniers);
	
	Tache obtenirDerniereTachePlanifee(Parcelle p);
	
	List<Tache> listerTachesDuJour();
	
	List<Tache> obtenirLesTachesPlanifeesViaPlante(Plante plante);
	
	List<Tache> obtenirLesTachesPlanifeesEtNonFinies();
}