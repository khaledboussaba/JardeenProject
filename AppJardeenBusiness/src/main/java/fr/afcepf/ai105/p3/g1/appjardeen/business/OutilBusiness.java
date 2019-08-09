package fr.afcepf.ai105.p3.g1.appjardeen.business;

import java.util.Date;
import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Actions;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Outil;

public interface OutilBusiness {

	List<Outil> listerOutilsDisponiblesRecommandes(Date dateHeureDebut, Date dateHeureFin, Actions action);
	List<Outil> listerOutilsDisponibles(Date dateHeureDebut, Date dateHeureFin, List<Outil> outilsAffectes);
	List<Outil> listerOutils();
	List<Outil> modificationQuantiteOutils(Outil ouuuut);
}
