package fr.afcepf.ai105.p3.g1.appjardeen.dao;

import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Emplacement;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Parcelle;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Terrain;

public interface EmplacementDao extends GenericDao<Emplacement> {

	Emplacement getEmplacementByTerrainAndNumColonneAndNumLigne(int numLigne, int numColonne, Terrain terrain);
	String getCouleurEmplacementByEmplacement(Emplacement e);
	Parcelle getParcelleByNumLigneAndNumColonne(int numLigne, int numColonne);
	List<Emplacement> getAllEmplacementDesParcellesNonRetireByTerrain(Terrain terrain);
	List<Emplacement> getAllEmplacementByParcelle(Parcelle p);

}
