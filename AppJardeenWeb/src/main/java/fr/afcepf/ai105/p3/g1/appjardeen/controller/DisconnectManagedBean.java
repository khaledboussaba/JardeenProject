package fr.afcepf.ai105.p3.g1.appjardeen.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name="mbDisconnect")
public class DisconnectManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public String disconnect() {
		HttpSession session = (HttpSession)  FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		//session.removeAttribute("adherent");
		session.invalidate();
		return "/accueilVisiteur.xhtml?faces-redirect=true";
	}

}
