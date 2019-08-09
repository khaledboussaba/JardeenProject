package fr.afcepf.ai105.p3.g1.appjardeen.daoimpl;


import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.ai105.p3.g1.appjardeen.dao.OutilTacheDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Outil;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.OutilTache;

@Remote(OutilTacheDao.class)
@Stateless
public class OutilTacheDaoImpl extends GenericDaoImpl<OutilTache> implements OutilTacheDao{

	@PersistenceContext(unitName="AppJardeenDS")
	private EntityManager em;

	@Override
	public int getQuantiteUtilisee(Date dateHeureDebut, Date dateHeureFin, Outil outil) {
		Query query = em.createQuery("SELECT ot.quantiteOutilUtilisee FROM OutilTache ot"
				+ "						WHERE ot.outil = :outil"
				+ "						AND ((ot.tache.dateDebutTache > :debut AND ot.tache.dateDebutTache < :fin)"
				+ "					  	OR (ot.tache.dateFinTache > :debut AND ot.tache.dateFinTache < :fin)" 
				+ "                   	OR (ot.tache.dateDebutTache <= :debut AND ot.tache.dateFinTache >= :fin))"
									);
		query.setParameter("debut", dateHeureDebut);
		query.setParameter("fin", dateHeureFin);
		query.setParameter("outil", outil);
		@SuppressWarnings("unchecked")
		List<Integer> quantitesUtilisees = query.getResultList();
		int quantite = 0;
		for (Integer q : quantitesUtilisees) {
			quantite += q;
		}
		return quantite;
	}
}