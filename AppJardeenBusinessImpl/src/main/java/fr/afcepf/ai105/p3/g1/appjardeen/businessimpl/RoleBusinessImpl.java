package fr.afcepf.ai105.p3.g1.appjardeen.businessimpl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai105.p3.g1.appjardeen.business.RoleBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.dao.RoleDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Role;

@Remote(RoleBusiness.class)
@Stateless
public class RoleBusinessImpl implements RoleBusiness{
	
	@EJB
	private RoleDao proxyRoleDao;

	@Override
	public List<Role> obtenirRoles() {
		List<Role> roles =proxyRoleDao.getAllRole();
		return roles;
	}

	

}
