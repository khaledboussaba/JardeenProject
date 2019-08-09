package fr.afcepf.ai105.p3.g1.appjardeen.dao;

import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.AdherentTerrain;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Terrain;

public interface AdherentTerrainDao extends GenericDao<AdherentTerrain> {

	List<Terrain> getTerrainByAdherent(int idAdherent);
	List<AdherentTerrain> getAdherentTerrainByAdherent(int idAdherent);
}
