package fr.afcepf.ai105.p3.g1.appjardeen.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import fr.afcepf.ai105.p3.g1.appjardeen.business.AdherentBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.IndisponibiliteBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Indisponibilite;

@ManagedBean(name = "mbIndisponibilite")
@ViewScoped
public class IndisponibiliteManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{mbConnect.adherent}")
	private Adherent adherent;
	
	private Date dateDebutIndispo;
	private Date dateFinIndispo;
	private List<Indisponibilite> indisponibilites;
	@EJB
	private AdherentBusiness proxyAdherent;
	
	@ManagedProperty(value ="#{mbaffichAdherent.selectedIndispo}")
	private Indisponibilite indispo;

	@EJB
	IndisponibiliteBusiness proxyIndisponibilite;	
	
	
	public String addPeriodeIndispo() {
			proxyIndisponibilite.insertIndispo(adherent, dateDebutIndispo, dateFinIndispo);
			return "pageAdherent.xhtml";
	}
	
	public String UpdateIndispo() {
		dateDebutIndispo = indispo.getDebutDateIndisponibilite();
		dateFinIndispo = indispo.getFinDateIndisponibilite();				
		proxyIndisponibilite.update(indispo, dateDebutIndispo, dateFinIndispo);
		return "pageAdherent.xhtml";
	}

	@PostConstruct
	public void unit() {
		indisponibilites = proxyAdherent.displayIndisponibilite(adherent);
	}
	public Adherent getAdherent() {
		return adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

	public Date getDateDebutIndispo() {
		return dateDebutIndispo;
	}


	public void setDateDebutIndispo(Date dateDebutIndispo) {
		this.dateDebutIndispo = dateDebutIndispo;
	}


	public Date getDateFinIndispo() {
		return dateFinIndispo;
	}


	public void setDateFinIndispo(Date dateFinIndispo) {
		this.dateFinIndispo = dateFinIndispo;
	}

	public Indisponibilite getIndispo() {
		return indispo;
	}

	public void setIndispo(Indisponibilite indispo) {
		this.indispo = indispo;
	}

}