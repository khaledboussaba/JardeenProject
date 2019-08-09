package fr.afcepf.ai105.p3.g1.appjardeen.business;

import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.AdherentTerrain;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Terrain;

public interface AdherentTerrainBusiness {

	List<Terrain> obtenirTerrainAdherent(int idAdherent);
	void annullerTerrainFavoris(AdherentTerrain adTerrain);
	List<AdherentTerrain> obtenirAdherentTerrain(int idAdherent);
	void ajouterTerrainFavoris(Adherent adherent, Terrain terrain);
}
