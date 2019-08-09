package fr.afcepf.ai105.p3.g1.appjardeen.daoimpl;


import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.ai105.p3.g1.appjardeen.dao.ActionsPlanteDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Actions;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.ActionsPlante;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Plante;

@Remote( ActionsPlanteDao.class)
@Stateless
public class ActionsPlanteDaoImpl extends GenericDaoImpl<ActionsPlante>  implements ActionsPlanteDao {


	@PersistenceContext(unitName="AppJardeenDS")
	private EntityManager em;
	
	@Override
	public List<ActionsPlante> getAllActionsPlanteByPlante(Plante plante) {		
		Query query = em.createQuery("SELECT ap "
										+ "FROM ActionsPlante ap "
										+ "WHERE ap.plante= :plante "
										+ "ORDER BY ap.numOrdonnancement ");
		query.setParameter("plante", plante);
		List<ActionsPlante> result = query.getResultList();
		return result;
	}

	@Override
	public Boolean exist(int numOrdre, Plante p) {
		Query query = em.createQuery("	SELECT ap "
				+ "						FROM ActionsPlante ap "
				+ "						WHERE ap.numOrdonnancement = :numOrdre "
				+ "								AND ap.plante =:p ");
		query.setParameter("numOrdre", numOrdre);
		query.setParameter("p", p);
		@SuppressWarnings("unchecked")
		List<ActionsPlante> aps = query.getResultList();
		return aps.size() > 0 ? true : false;
	}

	@Override
	public List<ActionsPlante> getAllActionsPlanteAfterAP(ActionsPlante ap) {		
		Query query = em.createQuery("	SELECT ap "
				+ "						FROM ActionsPlante ap "
				+ "						WHERE 	ap.numOrdonnancement >= :numOrdre "
				+ "								AND ap.plante =:p ");
		query.setParameter("numOrdre", ap.getNumOrdonnancement());
		query.setParameter("p", ap.getPlante());

		@SuppressWarnings("unchecked")
		List<ActionsPlante> aps = query.getResultList();
		return aps;
	}
	
	@Override
	public List<Actions> getAllActionAfterNumOrdreByPlante(Plante p, int numOrdre) {		
		Query query = em.createQuery("	SELECT ap.action "
				+ "						FROM ActionsPlante ap "
				+ "						WHERE 	ap.numOrdonnancement > :numOrdre "
				+ "								AND ap.plante =:p ");

		query.setParameter("numOrdre", numOrdre);
		query.setParameter("p", p);

		@SuppressWarnings("unchecked")
		List<Actions> result = query.getResultList();
		
		return result;
	}


	//Pour recupérer le numOrdre de l action dans la plante associé
	@Override
	public ActionsPlante getNumOrdreActionByPlanteAndAction(Actions action, Plante plante) {
		ActionsPlante ap = new ActionsPlante();
		
		Query query = em.createQuery(" SELECT ap "
								+ "    FROM ActionsPlante ap "
								+ "    WHERE ap.plante= :plante "
								+ "      AND ap.action= :action ");
		query.setParameter("action", action);
		query.setParameter("plante", plante);
		List<ActionsPlante> result = query.getResultList();
		if(result.size()>0) {
			ap = result.get(0);
		}else {
			ap=null;
		}

		return ap;
	}
}
