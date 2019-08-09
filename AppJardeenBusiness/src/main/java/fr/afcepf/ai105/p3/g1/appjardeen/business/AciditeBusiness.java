package fr.afcepf.ai105.p3.g1.appjardeen.business;

import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Acidite;

public interface AciditeBusiness {
	List<Acidite> obtenirAcidite();

	List<Acidite> obtenirTousLesAcidites();
}
