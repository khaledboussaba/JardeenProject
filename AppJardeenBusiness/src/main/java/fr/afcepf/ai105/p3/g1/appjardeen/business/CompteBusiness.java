package fr.afcepf.ai105.p3.g1.appjardeen.business;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;

public interface CompteBusiness {
	Adherent createAccount(Adherent adherent);
	Adherent connexion(String login, String password);
	Adherent registerAdherent(Adherent adherent);
}
