package fr.afcepf.ai105.p3.g1.appjardeen.business;

import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Emplacement;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Parcelle;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Terrain;

public interface EmplacementBusiness {

	Emplacement obtenirEmplacementByNumLigneEtNumColonne(int numLigne, int numColonne, Terrain terrain);
	String obtenirCouleurEmplacement(Emplacement e);
	Parcelle obtenirParcelleViaNumLigneEtNumColonne(int numLigne, int numColone);
	List<Emplacement> obtenirTousLesEmplacementsDontLesParcellesSontNonRetirerByTerrain(Terrain terrain);
	List<Emplacement> obtenirListeEmplacementByParcelle(Parcelle p1);
	void supprimer(Emplacement e);

}
