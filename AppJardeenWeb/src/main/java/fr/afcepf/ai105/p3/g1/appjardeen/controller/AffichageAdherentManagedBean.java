package fr.afcepf.ai105.p3.g1.appjardeen.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.ai105.p3.g1.appjardeen.business.AdherentBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.IndisponibiliteBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Indisponibilite;

@ManagedBean(name = "mbaffichAdherent")
@SessionScoped
public class AffichageAdherentManagedBean implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{mbConnect.adherent}")
	private Adherent adherent; 
	private List<Indisponibilite> indisponibilites= new ArrayList<>();
	private Indisponibilite indispo;
	private Date debutIndispo;
	private Date finIndispo;
	private Indisponibilite selectedIndispo;
	private String photo;
	private boolean affichage;
	private String visInput;
	

	@EJB
	private AdherentBusiness proxyAdherent;
	
	@EJB
	private IndisponibiliteBusiness proxyIndispo;
	


	public String niveauCompetence() {
		return proxyAdherent.competence(adherent);
	}
	
	public String civilite() {
		return proxyAdherent.sexe(adherent);
	}
	
	public String role() {
		return proxyAdherent.role(adherent);
	}
	
	@PostConstruct
	public void init() {
		
		indisponibilites = proxyAdherent.displayIndisponibilite(adherent);
		
		if(adherent.getSexe().getLibelleSexe().equals("Femme")) {
			photo="user-female.png";
		}else {
			photo="user-male.png";
		}
		
		if(adherent.getRole().getLibelleRole().equals("Adherent")) {
			affichage=false;
			visInput ="hidden";
		} else {
			affichage = true;
			visInput ="button";
		}
		
	}
	
	public String afficherIndispo(Indisponibilite indispo) {
		selectedIndispo = indispo; 
		return "editerIndisponibilite.xhtml?faces-redirect=true";
		
	}
	public void supprimerIndispo(Indisponibilite indispo) {
		proxyIndispo.annulerIndispo(indispo);
	}
	
	public Adherent getAdherent() {
		return adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

	public List<Indisponibilite> getIndisponibilites() {
		return indisponibilites;
	}

	public void setIndisponibilites(List<Indisponibilite> indisponibilites) {
		this.indisponibilites = indisponibilites;
	}

	public Indisponibilite getIndispo() {
		return indispo;
	}

	public void setIndispo(Indisponibilite indispo) {
		this.indispo = indispo;
	}

	public Date getFinIndispo() {
		return finIndispo;
	}

	public void setFinIndispo(Date finIndispo) {
		this.finIndispo = finIndispo;
	}

	public Date getDebutIndispo() {
		return debutIndispo;
	}

	public void setDebutIndispo(Date debutIndispo) {
		this.debutIndispo = debutIndispo;
	}

	public Indisponibilite getSelectedIndispo() {
		return selectedIndispo;
	}

	public void setSelectedIndispo(Indisponibilite selectedIndispo) {
		this.selectedIndispo = selectedIndispo;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public boolean isAffichage() {
		return affichage;
	}

	public void setAffichage(boolean affichage) {
		this.affichage = affichage;
	}

	public String getVisInput() {
		return visInput;
	}

	public void setVisInput(String visInput) {
		this.visInput = visInput;
	}

	
}
