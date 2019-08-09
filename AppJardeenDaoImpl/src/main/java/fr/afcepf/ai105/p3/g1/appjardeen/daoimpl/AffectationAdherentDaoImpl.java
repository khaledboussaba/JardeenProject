package fr.afcepf.ai105.p3.g1.appjardeen.daoimpl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.ai105.p3.g1.appjardeen.dao.AffectationAdherentDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.AffectationAdherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Tache;

@Remote(AffectationAdherentDao.class)
@Stateless
public class AffectationAdherentDaoImpl extends GenericDaoImpl<AffectationAdherent> implements AffectationAdherentDao {

	
	@PersistenceContext(unitName ="AppJardeenDS")
	private EntityManager em;

	@Override
	public List<Tache> getTacheByIdAdherent(int idAdherent) {
		Query query = em.createQuery("SELECT  aff.tache from AffectationAdherent aff "
				+ "where aff.adherent.idAdherent= :paramIdAdherent");
		query.setParameter("paramIdAdherent", idAdherent);
		@SuppressWarnings("unchecked")
		List<Tache> taches = query.getResultList();
		return taches;
		
	}

	@Override
	public List<Adherent> getAdherentsAffectesByTache(int idTache) {
		Query query = em.createQuery("SELECT aff.adherent FROM AffectationAdherent aff "
							+"where aff.tache.idTache= :paramIdTache");
		query.setParameter("paramIdTache", idTache);
		@SuppressWarnings("unchecked")
		List<Adherent> adherents = query.getResultList();
		return adherents;
	}

	@Override
	public int getIdAffectation(Adherent adherent, Tache tache) {
		Query query = em.createQuery("SELECT aff.idAffectationAdherent FROM AffectationAdherent aff "
				                    +"where aff.tache= :paramTache AND aff.adherent= :paramAdherent");
		query.setParameter("paramTache", tache);
		query.setParameter("paramAdherent", adherent);
		int idAffectation = (int) query.getSingleResult();
		return idAffectation;
	}

}
