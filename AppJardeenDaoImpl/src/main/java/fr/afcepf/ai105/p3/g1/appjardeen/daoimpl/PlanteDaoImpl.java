package fr.afcepf.ai105.p3.g1.appjardeen.daoimpl;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.ai105.p3.g1.appjardeen.dao.PlanteDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Plante;

@Remote(PlanteDao.class)
@Stateless
public class PlanteDaoImpl extends GenericDaoImpl<Plante> implements PlanteDao {

	@PersistenceContext (unitName = "AppJardeenDS")
	private EntityManager em;
	
	@Override
	public List<Plante> getAll() {
		Query query = em.createQuery("SELECT p FROM Plante p");
		List<Plante> plantes = query.getResultList();
		return plantes;
	}

	@Override
	public List<Plante> getPlantesEnPeriodeDeSemis() {
		Query query = em.createQuery("SELECT p FROM Plante p WHERE p.debutSemis.idMois <= :moisActuel AND p.finSemis.idMois >= :moisActuel");
		query.setParameter("moisActuel", LocalDate.now().getMonth().getValue());
		List<Plante> plantes = query.getResultList();
		return plantes;
	}

	@Override
	public List<Plante> getPlantesEnPeriodeDeFloraison() {
		Query query = em.createQuery("SELECT p FROM Plante p WHERE p.debutFloraison.idMois <= :moisActuel AND p.finFloraison.idMois >= :moisActuel");
		query.setParameter("moisActuel", LocalDate.now().getMonth().getValue());
		List<Plante> plantes = query.getResultList();
		return plantes;
	}

	@Override
	public List<Plante> getPlantesEnPeriodeDeRecolte() {
		Query query = em.createQuery("SELECT p FROM Plante p WHERE p.debutRecolte.idMois <= :moisActuel AND p.finRecolte.idMois >= :moisActuel");
		query.setParameter("moisActuel", LocalDate.now().getMonth().getValue());
		List<Plante> plantes = query.getResultList();
		return plantes;
	}
	
}
