package fr.afcepf.ai105.p3.g1.appjardeen.daoimpl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.ai105.p3.g1.appjardeen.dao.ActionsDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Actions;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Competence;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Plante;

@Remote (ActionsDao.class)
@Stateless
public class ActionsDaoImpl extends GenericDaoImpl<Actions> implements ActionsDao{

	@PersistenceContext (unitName = "AppJardeenDS")
	private EntityManager em;
	
	@Override
	public List<Actions> getAll() {
		Query query = em.createQuery("SELECT a FROM Actions a");
		List<Actions> actions = query.getResultList();
		return actions;
	}
	
	//LE fetch permet de recuperer l'objet 
	@Override
	public List<Actions> getAllActionNonDejaOrdonnanceeByPlante(Plante plante) {
		Query query = em.createQuery("	SELECT a "
				+ "						FROM Actions a "
				+ "                   	WHERE a NOT IN ( "
				+ "								SELECT ap.action "
				+ "								FROM ActionsPlante ap "
				+ "								WHERE ap.plante = :plante )");
	
		query.setParameter("plante", plante);
		return query.getResultList();
	}
	
	@Override
	public List<Actions> getAllActionRestanteAFaire(int numOrdre) {
		Query query = em.createQuery("	SELECT a "
				+ "						FROM Actions a "
				+ "                   	WHERE a IN ( SELECT ap.action "
				+ "									 FROM ActionsPlante ap "
				+ "									 WHERE ap.numOrdonnancement > :numOrdre); ");
		query.setParameter("numOrdre", numOrdre);
		return query.getResultList();
	}
	
	@Override
	public Competence getCompetenceByAction(Actions action) {
		Query query = em.createQuery("SELECT a.competence FROM Actions a WHERE a = :action");
		query.setParameter("action", action);
		Competence competence = (Competence) query.getSingleResult();
		return competence;
	}
}