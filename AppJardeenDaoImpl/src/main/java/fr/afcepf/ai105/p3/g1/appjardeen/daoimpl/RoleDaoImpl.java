package fr.afcepf.ai105.p3.g1.appjardeen.daoimpl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.ai105.p3.g1.appjardeen.dao.RoleDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Role;

@Remote(RoleDao.class)
@Stateless
public class RoleDaoImpl  extends GenericDaoImpl<Role> implements RoleDao {

	@PersistenceContext (unitName = "AppJardeenDS")
	private EntityManager em;
	
	
	@Override
	public List<Role> getAllRole() {
		Query query = em.createQuery("SELECT r FROM Role r");
		List<Role> roles = query.getResultList();
		return roles;
	}
	
	

}
