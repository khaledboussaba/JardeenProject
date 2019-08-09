package fr.afcepf.ai105.p3.g1.appjardeen.dao;
import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.dao.GenericDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Parcelle;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Terrain;

public interface ParcelleDao extends GenericDao<Parcelle> {

	List<Parcelle> getAll();
	List<Parcelle> getParcellesByTerrain(Terrain terrain);
	List<Parcelle> getAllParcelleByTerrain(Terrain terrain);
	List<Parcelle> getAllParcelleRetireesByTerrain(Terrain terrain);
}
