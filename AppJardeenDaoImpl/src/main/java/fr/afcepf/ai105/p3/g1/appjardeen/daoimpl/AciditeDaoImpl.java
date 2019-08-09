package fr.afcepf.ai105.p3.g1.appjardeen.daoimpl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai105.p3.g1.appjardeen.dao.AciditeDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Acidite;

@Remote(AciditeDao.class)
@Stateless
public class AciditeDaoImpl extends GenericDaoImpl<Acidite> implements AciditeDao {

	@PersistenceContext(unitName="AppJardeenDS")
	private EntityManager em;
}
