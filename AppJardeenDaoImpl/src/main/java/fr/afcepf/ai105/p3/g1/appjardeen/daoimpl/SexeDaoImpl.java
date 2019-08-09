package fr.afcepf.ai105.p3.g1.appjardeen.daoimpl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.ai105.p3.g1.appjardeen.dao.SexeDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Competence;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Sexe;

@Remote(SexeDao.class)
@Stateless
public class SexeDaoImpl extends GenericDaoImpl<Sexe> implements SexeDao {

	@PersistenceContext (unitName = "AppJardeenDS")
	private EntityManager em;
	
	
	@Override
	public List<Competence> getAll() {
		Query query = em.createQuery("SELECT s FROM Sexe s");
		List<Competence> civilites = query.getResultList();
		return civilites;
	}
}
