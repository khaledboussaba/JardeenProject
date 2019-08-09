package fr.afcepf.ai105.p3.g1.appjardeen.daoimpl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.ai105.p3.g1.appjardeen.dao.CompetenceDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Competence;

@Remote (CompetenceDao.class)
@Stateless
public class CompetenceDaoImpl extends GenericDaoImpl<Competence> implements CompetenceDao{

	@PersistenceContext (unitName = "AppJardeenDS")
	private EntityManager em;
	
	@Override
	public List<Competence> getAll() {
		Query query = em.createQuery("SELECT c FROM Competence c");
		List<Competence> competences = query.getResultList();
		return competences;
	}
}
