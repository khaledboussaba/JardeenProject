package fr.afcepf.ai105.p3.g1.appjardeen.dao;

import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Role;

public interface RoleDao extends GenericDao<Role>{

	List<Role> getAllRole();
}
