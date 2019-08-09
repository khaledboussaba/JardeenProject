package fr.afcepf.ai105.p3.g1.appjardeen.business;

import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Inscription;

public interface InscriptionBusiness {

	void ajouterUneInscription(Inscription inscription);

	String obtenirDerniereDateInscription(Adherent adherent);

	List<Adherent> obtenirListeAdherentsInscriptionArrivantAEcheance();

}
