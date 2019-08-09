package fr.afcepf.ai105.p3.g1.appjardeen.business;

import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Tache;

public interface VolontariatAdherentBusiness {

	List<Tache> obtenirTacheVolontariatByAdherent(int idAdherent);
	void insertVolontariat(Adherent adherent, Tache tache);
	List<Adherent> obtenirAdherentsVolontaireByIdTache(Tache tache);
}
