package fr.afcepf.ai105.p3.g1.appjardeen.business;

import java.util.Date;
import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Acidite;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Parcelle;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Terrain;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.TypeSol;

public interface ParcelleBusiness {

	List<Parcelle> listerParcelles();
	List<Parcelle> listerParcellesTerrain(Terrain terrain);
	void modifierParcelle(Parcelle parcelle, String libilleParcelle, 
			TypeSol typeSol, Terrain terrain, Acidite acidite, Date dateCreation, Date dateAnnulation);
	void createParcelle(String libelleParcelle, 
						TypeSol typeSol, Terrain terrain, Acidite acidite, 
						Date dateCreation);
	void creerParcelle(Parcelle parcelle);
	void modifierParcelle(Parcelle parcelle);
	List<Parcelle> obtenirToutesLesParcellesByTerrain(Terrain terrain);
	List<Parcelle> obtenirToutesLesParcellesRetireesByTerrain(Terrain terrain);
	void supprimerDefinitivementParcelle(Parcelle p);

}
