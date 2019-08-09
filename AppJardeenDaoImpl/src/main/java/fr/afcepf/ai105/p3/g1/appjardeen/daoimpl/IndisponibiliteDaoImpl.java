package fr.afcepf.ai105.p3.g1.appjardeen.daoimpl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.ai105.p3.g1.appjardeen.dao.IndisponibiliteDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Indisponibilite;

@Remote(IndisponibiliteDao.class)
@Stateless
public class IndisponibiliteDaoImpl extends GenericDaoImpl<Indisponibilite> implements IndisponibiliteDao {
	
	@PersistenceContext(unitName ="AppJardeenDS")
	private EntityManager em;

	@Override
	public List<Indisponibilite> getIndisponibilitesByAdherent(Adherent adherent) {
		Query query = em.createQuery("SELECT i FROM Indisponibilite i WHERE i.adherent = :adherent");
		query.setParameter("adherent", adherent);
		List<Indisponibilite> indisponibilites = query.getResultList();
		return indisponibilites;
	}
}