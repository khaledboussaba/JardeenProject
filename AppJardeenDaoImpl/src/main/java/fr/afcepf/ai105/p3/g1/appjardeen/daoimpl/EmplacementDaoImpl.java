package fr.afcepf.ai105.p3.g1.appjardeen.daoimpl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.ai105.p3.g1.appjardeen.dao.EmplacementDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Emplacement;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Parcelle;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Terrain;

@Remote (EmplacementDao.class)
@Stateless
public class EmplacementDaoImpl extends GenericDaoImpl<Emplacement> implements EmplacementDao{

	@PersistenceContext(unitName="AppJardeenDS")
	private EntityManager em;
	
	@Override
	public List<Emplacement> getAllEmplacementDesParcellesNonRetireByTerrain(Terrain terrain) {
		Query query = em.createQuery("	SELECT e "
				+ "						FROM Emplacement e "
				+ "                   	WHERE e.parcelle.terrain = :terrain"
				+ "							  AND e.parcelle.dateRetraitParcelle IS NULL");
		query.setParameter("terrain", terrain);
		return query.getResultList();
	}	


	@Override
	public Emplacement getEmplacementByTerrainAndNumColonneAndNumLigne(int numLigne, int numColonne, Terrain terrain) {
		Emplacement e = null;
		Query query = em.createQuery("	SELECT e "
				+ "						FROM Emplacement e "
				+ "                   	WHERE e.parcelle.terrain = :terrain "
				+ "                           AND e.numLigne=:numLigne "
		        + "                           AND e.numColonne=:numColonne "
				+ "							  AND e.parcelle.dateRetraitParcelle IS NULL");
	
		query.setParameter("terrain", terrain);
		query.setParameter("numLigne", numLigne);
		query.setParameter("numColonne", numColonne);
		
		if(query.getResultList().size()>0) {
			e = (Emplacement)query.getResultList().get(0);
		}

		return  e;
	}

	@Override
	public String getCouleurEmplacementByEmplacement(Emplacement e) {
		Query query = em.createQuery("	SELECT e.parcelle.couleurParcelle "
				+ "						FROM Emplacement e "
				+ "                   	WHERE e = :emplacement ");
		query.setParameter("emplacement", e);
		return (String) query.getResultList().get(0);
	}

	@Override
	public Parcelle getParcelleByNumLigneAndNumColonne(int numLigne, int numColonne) {
		Query query = em.createQuery("	SELECT e.parcelle "
				+ "						FROM Emplacement e "
				+ "                   	WHERE e.numLigne=:numLigne "  
				+ "                         AND e.numColonne=:numColonne ");
		query.setParameter("numLigne", numLigne);
		query.setParameter("numColonne", numColonne);
		return (Parcelle) query.getResultList().get(0);
	}


	@Override
	public List<Emplacement> getAllEmplacementByParcelle(Parcelle p) {
		Query query = em.createQuery("	SELECT e "
				+ "						FROM Emplacement e "
				+ "                   	WHERE e.parcelle=:parcelle ");  
		query.setParameter("parcelle", p);
		return query.getResultList();
	}



}
