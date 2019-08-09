package fr.afcepf.ai105.p3.g1.appjardeen.daoimpl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.ai105.p3.g1.appjardeen.dao.VolontariatAdherentDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Tache;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.VolontariatAdherent;


@Remote(VolontariatAdherentDao.class)
@Stateless
public class VolontariatAdherentDaoImpl extends GenericDaoImpl<VolontariatAdherent> implements VolontariatAdherentDao {

	@PersistenceContext(unitName="AppJardeenDS")
	private EntityManager em;
	
	@Override
	public List<Tache> getTacheVolontariatByIdAdherent(int idAdherent) {
		Query query = em.createQuery("SELECT v.tache from VolontariatAdherent v "
				+ "where v.adherent.idAdherent= :paramIdAdherent");
		query.setParameter("paramIdAdherent", idAdherent);
		@SuppressWarnings("unchecked")
		List<Tache> tachesVolontariat = query.getResultList();
		return tachesVolontariat;
	}

	@Override
	public List<Adherent> getAdherentsVolontaireByIdTache(Tache tache) {
		Query query = em.createQuery("SELECT v.adherent from VolontariatAdherent v "
				+ "where v.tache= :paramTache");
		
		query.setParameter("paramTache", tache);
		@SuppressWarnings("unchecked")
		List<Adherent> AdherentsVolontaire = query.getResultList();
		return AdherentsVolontaire;
	}

}
