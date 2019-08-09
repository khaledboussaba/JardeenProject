package fr.afcepf.ai105.p3.g1.appjardeen.dao;

import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Terrain;

public interface TerrainDao extends GenericDao<Terrain>{
	List<Terrain> getAllTerrainNonRetire();

	List<Terrain> getAllTerrainRetire();
	
	List<Terrain> getTerrain();
	
}
