package fr.afcepf.ai105.p3.g1.appjardeen.daoimpl;


import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.ai105.p3.g1.appjardeen.dao.OutilDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Actions;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Outil;

@Remote(OutilDao.class)
@Stateless
public class OutilDaoImpl extends GenericDaoImpl<Outil> implements OutilDao{

	@PersistenceContext(unitName="AppJardeenDS")
	private EntityManager em;
	
	@Override
	public List<Outil> getByDateAndAction(Date dateHeureDebut, Date dateHeureFin, Actions action) {
		Query query = em.createQuery("SELECT o FROM Outil o"
				+ "						INNER JOIN FETCH o.outilsAction oa"
				+ "						WHERE oa.action = :action"
									);
//		query.setParameter("debut", dateHeureDebut);
//		query.setParameter("fin", dateHeureFin);
		query.setParameter("action", action);
		@SuppressWarnings("unchecked")
		List<Outil> outils = query.getResultList();
		return outils;
	}

	@Override
	public List<Outil> getByDate(Date dateHeureDebut, Date dateHeureFin) {
		Query query = em.createQuery("SELECT o FROM Outil o"
				+ "     					)"
									);
//		query.setParameter("debut", dateHeureDebut);
//		query.setParameter("fin", dateHeureFin);
		@SuppressWarnings("unchecked")
		List<Outil> outils = query.getResultList();
		return outils;
	}

	@Override
	public List<Outil> getAll() {
		Query query = em.createQuery("SELECT o FROM Outil o");
		List<Outil> outils = query.getResultList();
		return outils;
	}
}