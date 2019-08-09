package fr.afcepf.ai105.p3.g1.appjardeen.daoimpl;


import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.ai105.p3.g1.appjardeen.dao.ParcelleDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Parcelle;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Terrain;


@Remote(ParcelleDao.class)
@Stateless
public class ParcelleDaoImpl extends GenericDaoImpl<Parcelle> implements ParcelleDao {

	@PersistenceContext (unitName = "AppJardeenDS")
	private EntityManager em;
	
	@Override
	public List<Parcelle> getAll() {
		Query query = em.createQuery("SELECT p FROM Parcelle p");
		List<Parcelle> parcelles = query.getResultList();
		return parcelles;
	}

	//REDA : J'ai ajoute le filtre pour ne pas avoir les parcelles retirees
	@Override
	public List<Parcelle> getParcellesByTerrain(Terrain terrain) {
		Query query = em.createQuery("  SELECT p "
				+ "						FROM Parcelle p "
				+ "                     WHERE p.terrain.idTerrain = :idTerrain "
				+ "                       AND p.dateRetraitParcelle IS NULL");
		query.setParameter("idTerrain", terrain.getIdTerrain());
		List<Parcelle> parcelles = query.getResultList();
		return parcelles;
	}

	@Override
	public List<Parcelle> getAllParcelleByTerrain(Terrain terrain) {
		Query query = em.createQuery("  SELECT p "
				+ "						FROM Parcelle p "
				+ "                     WHERE p.terrain.idTerrain = :idTerrain");
		query.setParameter("idTerrain", terrain.getIdTerrain());
		List<Parcelle> parcelles = query.getResultList();		
		return parcelles;
	}

	@Override
	public List<Parcelle> getAllParcelleRetireesByTerrain(Terrain terrain) {
		Query query = em.createQuery("  SELECT p "
				+ "						FROM Parcelle p "
				+ "                     WHERE p.terrain.idTerrain = :idTerrain "
				+ "							  AND p.dateRetraitParcelle IS NOT NULL ");
		query.setParameter("idTerrain", terrain.getIdTerrain());
		List<Parcelle> parcelles = query.getResultList();		
		return parcelles;
		}
	
}