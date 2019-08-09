package fr.afcepf.ai105.p3.g1.appjardeen.daoimpl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.ai105.p3.g1.appjardeen.dao.InscriptionDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Inscription;

@Remote(InscriptionDao.class)
@Stateless
public class InscriptionDaoImpl extends GenericDaoImpl<Inscription> implements InscriptionDao {

	@PersistenceContext(unitName="AppJardeenDS")
	private EntityManager em;

	//@AXEL ATTENTION G AJOUTER UNE CONDITION POUR GERER LE 30J et Pas plus.....
	@Override
	public List<Inscription> getInscriptionAEcheance() {
		// ANCIENNE REQUETE NE GERAIT PAS TOUS LES CAS 
		//		Query query = em.createQuery("SELECT i FROM Inscription i WHERE i.dateInscription < :dateReference ");
		Query query = em.createQuery(" SELECT i "
				+ "                    FROM Inscription i "
				+ "                    WHERE i.dateInscription < :dateReference "
				+ "                          AND i.dateInscription > :dateReference2 "
				+ "                          AND i.dateInscription = (SELECT max(ii.dateInscription) "
				+ "                                                   FROM Inscription ii "
				+ "                                                   WHERE i.adherent = ii.adherent )"
				+ "                          AND i.adherent NOT IN (SELECT d.adherent "
				+ "													FROM Desinscription d) ");

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1);
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
		query.setParameter("dateReference", calendar.getTime());
	
		Calendar calendar2 = Calendar.getInstance();
		calendar2.set(Calendar.YEAR, calendar2.get(Calendar.YEAR) - 1);		
		query.setParameter("dateReference2", calendar2.getTime());
		
		@SuppressWarnings("unchecked")
		List<Inscription> inscriptions = query.getResultList();
		return inscriptions;
	}

	@Override
	public String getLastIncriptionDateByAdherent(Adherent adherent) {
		Query query = em.createQuery(" SELECT max(i.dateInscription) "
				+ "					   FROM Inscription i "
				+ "					   WHERE i.adherent = :adherent");
		query.setParameter("adherent", adherent);

		Date date =  (Date) query.getResultList().get(0);
		String s =date.toString();
		String returnDate = s.substring(8,10)+"/"+s.substring(5,7)+"/"+s.substring(0,4);
		
		return returnDate;
	}

	@Override
	public List<Adherent> getAllAdherentsInscriptionArrivantAEcheance() {
		Query query = em.createQuery(" SELECT i.adherent "
				+ "                    FROM Inscription i "
				+ "                    WHERE i.dateInscription < :dateReference "
				+ "                          AND i.dateInscription > :dateReference2 "
				+ "                          AND i.dateInscription = (SELECT max(ii.dateInscription) "
				+ "                                                   FROM Inscription ii "
				+ "                                                   WHERE i.adherent = ii.adherent )"
				+ "                          AND i.adherent NOT IN (SELECT d.adherent "
				+ "													FROM Desinscription d) ");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1);
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
		query.setParameter("dateReference", calendar.getTime());
	
		Calendar calendar2 = Calendar.getInstance();
		calendar2.set(Calendar.YEAR, calendar2.get(Calendar.YEAR) - 1);		
		query.setParameter("dateReference2", calendar2.getTime());



		@SuppressWarnings("unchecked")
		List<Adherent> adherents = query.getResultList();
		return adherents;
	}


}
