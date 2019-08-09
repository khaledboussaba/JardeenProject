package fr.afcepf.ai105.p3.g1.appjardeen.businessimpl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai105.p3.g1.appjardeen.business.TerrainBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.dao.TerrainDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Terrain;

@Remote(TerrainBusiness.class)
@Stateless
public class TerrainBusinessImpl implements TerrainBusiness {

	@EJB
	private TerrainDao proxyTerrain;
	
	@Override
	public List<Terrain> obtenirTerrain() {
		List<Terrain> terrains = proxyTerrain.getTerrain();
		return terrains;
	}
	

	@EJB
	private TerrainDao proxyTacheDao;
	
	@Override
	public List<Terrain> obtenirLaListeDesTerrainsRetires() {
		return proxyTacheDao.getAllTerrainRetire();
	}

	@Override
	public Terrain enregistrerTerrain(Terrain terrain) {
		proxyTacheDao.insert(terrain);
		return terrain;
	}

	@Override
	public void retirerTerrain(Terrain terrain) {
		proxyTacheDao.update(terrain);
	}
	
	@Override
	public List<Terrain> obtenirTerrainNonRetire() {
		return proxyTacheDao.getAllTerrainNonRetire();
	}

	@Override
	public void rajouterTerrain(Terrain terrain) {
		proxyTacheDao.update(terrain);
		
	}

	@Override
	public Terrain obtenirTerrainById(int idTerrain) {
		return proxyTerrain.findById(idTerrain) ;
	}
	
}
