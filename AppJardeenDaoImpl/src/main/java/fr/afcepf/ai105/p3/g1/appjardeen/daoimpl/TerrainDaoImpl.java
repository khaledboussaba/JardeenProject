package fr.afcepf.ai105.p3.g1.appjardeen.daoimpl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.ai105.p3.g1.appjardeen.dao.TerrainDao;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.ActionsPlante;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Plante;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Terrain;


@Remote(TerrainDao.class)
@Stateless
public class TerrainDaoImpl extends GenericDaoImpl<Terrain> implements TerrainDao{

	@PersistenceContext(unitName="AppJardeenDS")
	private EntityManager em;

	
	
	@Override
	public List<Terrain> getAllTerrainNonRetire() {		
		Query query = em.createQuery("SELECT t "
										+ "FROM Terrain t "
										+ "WHERE t.dateRetraitTerrain IS NULL ");
		List<Terrain> result = query.getResultList();
		return result;
	}

	@Override
	public List<Terrain> getTerrain() {
		Query query = em.createQuery("SELECT t FROM Terrain t");
		List<Terrain> terrains = query.getResultList();
		return terrains;
	}

	@Override
	public List<Terrain> getAllTerrainRetire() {
		Query query = em.createQuery("SELECT t "
				+ "FROM Terrain t "
				+ "WHERE t.dateRetraitTerrain IS NOT NULL ");
		List<Terrain> result = query.getResultList();

		return result;
		
	}
}
