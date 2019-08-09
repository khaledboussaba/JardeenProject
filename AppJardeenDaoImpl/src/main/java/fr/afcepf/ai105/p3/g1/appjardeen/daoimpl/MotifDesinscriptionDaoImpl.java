package fr.afcepf.ai105.p3.g1.appjardeen.daoimpl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.ai105.p3.g1.appjardeen.dao.MotifDesinscriptionDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.MotifDesinscription;


@Remote(MotifDesinscriptionDao.class)
@Stateless
public class MotifDesinscriptionDaoImpl extends GenericDaoImpl<MotifDesinscription> implements MotifDesinscriptionDao {

	@PersistenceContext(unitName="AppJardeenDS")
	private EntityManager em;
	
	@Override
	public List<MotifDesinscription> getAll() {
		Query query = em.createQuery("SELECT m FROM MotifDesinscription m");
		List<MotifDesinscription> motifs = query.getResultList();
		return motifs;
	}

}
