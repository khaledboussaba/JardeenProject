package fr.afcepf.ai105.p3.g1.appjardeen.daoimpl;


import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.ai105.p3.g1.appjardeen.dao.AdherentDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Desinscription;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Indisponibilite;

@Remote(AdherentDao.class)
@Stateless
public class AdherentDaoImpl extends GenericDaoImpl<Adherent> implements AdherentDao {

	@PersistenceContext(unitName="AppJardeenDS")
	private EntityManager em;

	@Override
	public Boolean exist(Adherent adherent) {
		Query query = em.createQuery("SELECT a FROM Adherent a WHERE a.login = :paramlogin");
		query.setParameter("paramlogin", adherent.getLogin());
		@SuppressWarnings("unchecked")
		List<Adherent> adherents = query.getResultList();
		return adherents.size() > 0 ? true : false;
	}

	@Override
	public Adherent authenticate(String login, String password) {
		Query query = em.createQuery("SELECT a FROM Adherent a WHERE a.login = :paramlogin AND a.password = :parampassword");
		query.setParameter("paramlogin", login);
		query.setParameter("parampassword", password);
		List<Adherent> adherents = query.getResultList();
		Adherent adherent = null;
		if(adherents.size() > 0) {
			adherent = adherents.get(0);
		}
		return adherent;
	}

	@Override                                       
	public String getCompetenceAdherent(Adherent adherent) {
		Query query = em.createQuery("SELECT  a.competence.libelleCompetence from Adherent a "
				+ "where a.idAdherent= :paramIdAdherent");
		query.setParameter("paramIdAdherent", adherent.getIdAdherent());
		@SuppressWarnings("unchecked")
		String competence = (String)query.getSingleResult();
		return competence;
	}

	@Override
	public String getSexeAdherent(Adherent adherent) {
		Query query = em.createQuery("SELECT  a.sexe.libelleSexe from Adherent a "
				+ "where a.idAdherent= :paramIdAdherent");
		query.setParameter("paramIdAdherent", adherent.getIdAdherent());
		@SuppressWarnings("unchecked")
		String sexe = (String)query.getSingleResult();
		return sexe;
	}

	@Override
	public String getRoleAdherent(Adherent adherent) {
		Query query = em.createQuery("SELECT a.role.libelleRole from Adherent a "
				+ "where a.idAdherent= :paramIdAdherent");
		query.setParameter("paramIdAdherent", adherent.getIdAdherent());
		@SuppressWarnings("unchecked")
		String role = (String)query.getSingleResult();
		return role;
	}

	@Override
	public List<Indisponibilite> getIndisponibiliteByAdherent(Adherent adherent) {
		Query query = em.createQuery("SELECT ind FROM Indisponibilite ind "
				+"WHERE ind.adherent.idAdherent=:paramadherent");
		query.setParameter("paramadherent", adherent.getIdAdherent());
		List<Indisponibilite> indisponibilite = query.getResultList();
		return indisponibilite;	
	}

	@Override
	public List<Adherent> getAll() {
		Query query = em.createQuery("SELECT a FROM Adherent a");
		List<Adherent> adherents = query.getResultList();
		return adherents;
	}


	// Reda : ajout de la gestion de la date d'inscription car elle renvoyait meme les personnes enregistrées et non inscrit 
	@Override
	public List<Adherent> getAllAdherentInscrit() {
		Query query = em.createQuery("SELECT a FROM Adherent a "
				+ "WHERE a.idAdherent NOT IN (SELECT d.adherent.idAdherent FROM Desinscription d) "
				+ "AND a.idAdherent IN (SELECT i.adherent.idAdherent FROM Inscription i WHERE i.dateInscription>:dateReference)");
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1);
		query.setParameter("dateReference", calendar.getTime());
		
		List<Adherent> adherents = query.getResultList();
		return adherents;
	}
	
	@Override
	public List<Adherent> getAllAdherentDesinscrit() {
		Query query = em.createQuery(" SELECT a "
				+ "				       FROM Adherent a "
				+ "					   WHERE a.idAdherent IN (SELECT d.adherent.idAdherent FROM Desinscription d) "
				+ "							OR a IN  (  SELECT i.adherent "
				+ "           							FROM Inscription i "
				+ "           							WHERE i.dateInscription < :dateReference "
				+ "												AND  i.dateInscription = ( SELECT MAX(ii.dateInscription) "  
				+ "																		   FROM Inscription ii"  
				+ "														                   WHERE i.adherent = ii.adherent "
				+ "																		  )"
				+ "									)");          
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1);
		query.setParameter("dateReference", calendar.getTime());
		List<Adherent> adherents = query.getResultList();
		return adherents;
	}


	// OK
	@Override
	public List<Adherent> getAllAdherentAInscrire() {
		Query query = em.createQuery("SELECT a FROM Adherent a "
				+ "WHERE a.idAdherent NOT IN "
				+ "(SELECT i.adherent.idAdherent FROM Inscription i) "
				+ "AND a.idAdherent NOT IN "
				+ "(SELECT d.adherent.idAdherent FROM Desinscription d)");
		List<Adherent> adherents = query.getResultList();
		return adherents;
	}

	
	// REDA : J'ai ajouté le traitement des descinscriptions et de l'inscription de moins d'un an
	@Override
	public List<Adherent> getByDisponibiliteEtCompetence(Date debut, Date fin, int niveauCompetence) {
		Query query = em.createQuery("SELECT a FROM Adherent a"
				+ "                   WHERE a NOT IN ("
				+ "					  	SELECT i.adherent from Indisponibilite i"
				+ "					  	WHERE ((i.debutDateIndisponibilite > :debut AND i.debutDateIndisponibilite < :fin)"
				+ "					  	OR (i.finDateIndisponibilite > :debut AND i.finDateIndisponibilite < :fin)" 
				+ "                   	OR (i.debutDateIndisponibilite <= :debut AND i.finDateIndisponibilite >= :fin))"
				+ "                   )"
				+ "					  AND a NOT IN ("
				+ "					  	SELECT afa.adherent from AffectationAdherent afa"
				+ "						WHERE ((afa.tache.dateDebutTache > :debut AND afa.tache.dateDebutTache < :fin)"
				+ "					  	OR (afa.tache.dateFinTache > :debut AND afa.tache.dateFinTache < :fin)" 
				+ "                   	OR (afa.tache.dateDebutTache <= :debut AND afa.tache.dateFinTache >= :fin))"
				+ "					  )"
				+ "                   AND a.competence.idCompetence >= :niveauCompetence " 
				+ "                   AND a NOT IN (SELECT d.adherent FROM Desinscription d WHERE d.adherent=a) "
				+ "                   AND a IN  (SELECT i.adherent FROM Inscription i WHERE i.dateInscription>:dateReference) ");
				
		query.setParameter("debut", debut);
		query.setParameter("fin", fin); 
		query.setParameter("niveauCompetence", niveauCompetence);
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1);
		System.out.println("---------> Date Reference : "+ calendar.getTime());
		query.setParameter("dateReference", calendar.getTime());
		
		
		List<Adherent> adherentsDisponibles = query.getResultList();
		return adherentsDisponibles;
	}

	// REDA : J'ai ajouté le traitement des descinscriptions et de l'inscription de moins d'un an
	@Override
	public List<Adherent> getAllAdherentDisponible(Date dateDebutTache, Date dateFinTache) {
		Query query = em.createQuery("SELECT a FROM Adherent a"
				+ "                   WHERE a NOT IN ("
				+ "					  	SELECT i.adherent from Indisponibilite i"
				+ "					  	WHERE ((i.debutDateIndisponibilite > :debut AND i.debutDateIndisponibilite < :fin)"
				+ "					  	OR (i.finDateIndisponibilite > :debut AND i.finDateIndisponibilite < :fin)" 
				+ "                   	OR (i.debutDateIndisponibilite <= :debut AND i.finDateIndisponibilite >= :fin))"
				+ "                   )"
				+ "					  AND a NOT IN ("
				+ "					  	SELECT afa.adherent from AffectationAdherent afa"
				+ "						WHERE ((afa.tache.dateDebutTache > :debut AND afa.tache.dateDebutTache < :fin)"
				+ "					  	OR (afa.tache.dateFinTache > :debut AND afa.tache.dateFinTache < :fin)" 
				+ "                   	OR (afa.tache.dateDebutTache <= :debut AND afa.tache.dateFinTache >= :fin))"
				+ "					  )" 
				+ "                   AND a NOT IN (SELECT d.adherent FROM Desinscription d WHERE d.adherent=a) "
				+ "                   AND a IN  (SELECT i.adherent FROM Inscription i WHERE i.dateInscription>:dateReference) ");
				
		query.setParameter("debut", dateDebutTache);
		query.setParameter("fin", dateFinTache); 
		
		//REDA
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1);
		query.setParameter("dateReference", calendar.getTime());
		
		@SuppressWarnings("unchecked")
		List<Adherent> adherentsDisponibles = query.getResultList();
		return adherentsDisponibles;
	}


}
