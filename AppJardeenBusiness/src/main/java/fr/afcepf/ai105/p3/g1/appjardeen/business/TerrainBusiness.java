package fr.afcepf.ai105.p3.g1.appjardeen.business;

import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Terrain;

public interface TerrainBusiness {
	
	List<Terrain> obtenirTerrain();
	
	Terrain enregistrerTerrain(Terrain terrain);

	void retirerTerrain(Terrain terrain);
	
	List<Terrain> obtenirTerrainNonRetire();

	List<Terrain> obtenirLaListeDesTerrainsRetires();

	void rajouterTerrain(Terrain terrain);

	Terrain obtenirTerrainById(int idTerrain);
	
}
