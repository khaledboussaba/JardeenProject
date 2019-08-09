package fr.afcepf.ai105.p3.g1.appjardeen.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.afcepf.ai105.p3.g1.appjardeen.business.AdherentBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.RoleBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Role;

@ManagedBean(name="mbListeAdherentRole")
@RequestScoped
public class ListeAdherentRoleManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Adherent> adherents;
	private Adherent adherentSelected;
	private List<Role> roles;
	private Role roleSelected;
	
	public List<Adherent> getAdherents() {
		return adherents;
	}
	@EJB
	AdherentBusiness proxyAdherentBusiness;
	
	@PostConstruct
    public void init() {
		adherents= proxyAdherentBusiness.listerAdherents();
    }
	
	public void modifierRole() {
		
	}
	
	public void setAdherents(List<Adherent> adherents) {
		this.adherents = adherents;
	}
	public Adherent getAdherentSelected() {
		return adherentSelected;
	}
	public void setAdherentSelected(Adherent adherentSelected) {
		this.adherentSelected = adherentSelected;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public Role getRoleSelected() {
		return roleSelected;
	}
	public void setRoleSelected(Role roleSelected) {
		this.roleSelected = roleSelected;
	}
}
