package fr.afcepf.ai105.p3.g1.appjardeen.business;

import java.util.Date;
import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Indisponibilite;

public interface IndisponibiliteBusiness {
	void annulerIndispo(Indisponibilite t);
	Indisponibilite update(Indisponibilite indispo, Date dateDebutIndispo, Date dateFinIndispo);
	Indisponibilite obtenirIndisponibilite(int idIndiponibilite);
	void insertIndispo(Adherent adherent, Date dateDebutIndispo, Date dateFinIndispo);
	List<Indisponibilite> listerIndisponibilites(Adherent adherent);
}
