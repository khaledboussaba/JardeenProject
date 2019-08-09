package fr.afcepf.ai105.p3.g1.appjardeen.daoimpl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.ai105.p3.g1.appjardeen.dao.AdherentTerrainDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.AdherentTerrain;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Terrain;


@Remote(AdherentTerrainDao.class)
@Stateless
public class AdherentTerrainDaoImpl extends GenericDaoImpl<AdherentTerrain> implements AdherentTerrainDao{

	@PersistenceContext(unitName ="AppJardeenDS")
	private EntityManager em;
	
	@Override
	public List<Terrain> getTerrainByAdherent(int idAdherent) {
		
		Query query = em.createQuery("SELECT  at.terrain from AdherentTerrain at "
				+ "where at.adherent.idAdherent= :paramIdAdherent");
		query.setParameter("paramIdAdherent", idAdherent);
		@SuppressWarnings("unchecked")
		List<Terrain> terrainsAdherent = query.getResultList();
		return terrainsAdherent;
	}

	@Override
	public List<AdherentTerrain> getAdherentTerrainByAdherent(int idAdherent) {
		
		Query query = em.createQuery("SELECT  at from AdherentTerrain at "
				+ "where at.adherent.idAdherent= :paramIdAdherent");
		query.setParameter("paramIdAdherent", idAdherent);
		@SuppressWarnings("unchecked")
		List<AdherentTerrain> terrainsAdherent = query.getResultList();
		return terrainsAdherent;
	}

}
