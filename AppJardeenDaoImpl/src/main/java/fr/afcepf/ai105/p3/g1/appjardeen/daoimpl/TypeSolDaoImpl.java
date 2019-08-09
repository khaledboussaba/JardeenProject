package fr.afcepf.ai105.p3.g1.appjardeen.daoimpl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.ai105.p3.g1.appjardeen.dao.TypeSolDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.TypeSol;

@Remote( TypeSolDao.class)
@Stateless
public class TypeSolDaoImpl extends GenericDaoImpl<TypeSol> implements TypeSolDao {

	@PersistenceContext(unitName="AppJardeenDS")
	private EntityManager em;
	
	@Override
	public List<TypeSol> getTypesSol() {
//		Query query = em.createQuery("SELECT t FROM TypeSol t");
//		List<TypeSol> typesSol = query.getResultList();
		List<TypeSol> typesSol = getCollection("SELECT t FROM TypeSol t");
		return typesSol;
	}

}
