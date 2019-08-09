package fr.afcepf.ai105.p3.g1.appjardeen.daoimpl;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.ai105.p3.g1.appjardeen.dao.TacheDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Parcelle;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Plante;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Tache;

@Remote(TacheDao.class)
@Stateless
public class TacheDaoImpl extends GenericDaoImpl<Tache> implements TacheDao{

	@PersistenceContext(unitName="AppJardeenDS")
	private EntityManager em;

	
	@Override
	public Tache getLastTacheInParcelle(Parcelle p) {	
		Tache t = new Tache();
		Query query = em.createQuery(" SELECT t " + 
									 " FROM Tache t " + 
									 " WHERE " + 
									 " (t.dateDebutTache =  ( SELECT max(t.dateDebutTache) "
									 + "					  FROM Tache t2 "
									 + "					  WHERE t.parcelle= :parcelle))");
		query.setParameter("parcelle", p);
		List<Tache> result = query.getResultList();
		if(result.size()>0) {
			t = result.get(0);
		}else {
			t=null;
		}
		return t;
	}

	@Override
	public List<Tache> getAllTacheByPlante(Plante plante) {
		Query query = em.createQuery("SELECT t "+ 
									 "FROM Tache t "+ 
									 "WHERE t.plante = :plante "
									+"     AND t.dateAnnulationTache IS NULL "
									+ "	   AND (t.dateDebutTache >= current_date())");
		query.setParameter("plante", plante);
		List<Tache> result = query.getResultList();
		return result;		
	}

	@Override
	public List<Tache> getTachesDuJour() {
		Query query = em.createQuery("SELECT t FROM Tache t WHERE DATE(t.dateDebutTache) = :dateDuJour");
		query.setParameter("dateDuJour", new Date());
		List<Tache> taches = query.getResultList();
		return taches;
	}

	@Override
	public List<Tache> getTacheManquantDeJardiniers() {
		Query query = em.createQuery("SELECT t FROM Tache t WHERE t.nbAdherentRequis > (SELECT COUNT (a) FROM AffectationAdherent a WHERE a.tache = t))");
		List<Tache> taches = query.getResultList();
		return taches;
	}

	@Override
	public List<Tache> getAll() {
		Query query = em.createQuery("	SELECT t "
				+ "						FROM Tache t "
				+ "						WHERE 	t.dateAnnulationTache IS NULL "
				+ "								AND (t.date_fin_tache >= current_date() "
				+ "										OR t.dateDebutTache >=  current_date())");
		List<Tache> taches = query.getResultList();
		return taches;
	}


}
