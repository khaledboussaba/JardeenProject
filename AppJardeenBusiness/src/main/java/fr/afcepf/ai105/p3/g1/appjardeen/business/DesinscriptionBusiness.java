package fr.afcepf.ai105.p3.g1.appjardeen.business;

import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Desinscription;

public interface DesinscriptionBusiness {

	Desinscription enregistrerDesinscription(Desinscription desinscription);
	List<Desinscription> obtenirDesinscriptionsByAdherent(Adherent adherent);
	void retirerDesinscription(Desinscription desinscription);
	List<Adherent> obtenirListeAdherentsDesinscrit();

}
