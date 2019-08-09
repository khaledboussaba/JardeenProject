package fr.afcepf.ai105.p3.g1.appjardeen.daoimpl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.ai105.p3.g1.appjardeen.dao.DesinscriptionDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Desinscription;

@Remote(DesinscriptionDao.class)
@Stateless
public class DesinscriptionDaoImpl extends GenericDaoImpl<Desinscription> implements DesinscriptionDao {

	@PersistenceContext(unitName="AppJardeenDS")
	private EntityManager em;
	
	@Override
	public List<Desinscription> getAllDesinscriptionsByAdherent(Adherent adherent) {
		Query query = em.createQuery("SELECT d FROM Desinscription d "
				+ "WHERE d.adherent.idAdherent = :idAdherent");
		query.setParameter("idAdherent", adherent.getIdAdherent());
		List<Desinscription> desinscriptions = query.getResultList();
		return desinscriptions;
	}

	@Override
	public List<Adherent> getAll() {
		Query query = em.createQuery("  SELECT d.adherent "
				+ "						FROM Desinscription d ");
		List<Adherent> result = query.getResultList();
		return result;
	}

}
