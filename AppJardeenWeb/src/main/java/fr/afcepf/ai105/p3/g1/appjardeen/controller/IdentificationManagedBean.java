package fr.afcepf.ai105.p3.g1.appjardeen.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.afcepf.ai105.p3.g1.appjardeen.business.CompteBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;

@ManagedBean (name="mbConnect")
@SessionScoped
public class IdentificationManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String login;
	private String password;
	private Adherent adherent;
	private String redirect;
	

	@EJB
	private CompteBusiness proxyCompteBusiness;

	public String connect() {
		adherent = proxyCompteBusiness.connexion(login, password);
		String redirect;
		if(adherent != null) {
			if (adherent.getRole().getIdRole() < 3) {
				redirect = "/dashboard.xhtml?faces-redirect=true";
			} else {
				redirect = "/pageAdherent.xhtml?faces-redirect=true";
			}
		} else {
			redirect = "/identification.xhtml?faces-redirect=true";
		}
		return redirect;
	}
	
//	public void init() {
//		redirect = "identification.xhtml";
//	}

	public String disconnect() {
		HttpSession session = (HttpSession)  FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		
		
		System.out.println("======================"+session.getAttribute("adherent"));
		session.removeAttribute("adherent");
		System.out.println("======================"+session.getAttribute("adherent"));
		session.invalidate();
		return "/accueilVisiteur.xhtml?faces-redirect=true";
	}
	
	public String register() {
		return "/enregistrementAdherent.xhtml?faces-redirect=true";
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Adherent getAdherent() {
		return adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

	public String getRedirect() {
		return redirect;
	}

	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}

	
}
