package fr.afcepf.ai105.p3.g1.appjardeen.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import fr.afcepf.ai105.p3.g1.appjardeen.business.AffectationAdherentBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.TacheBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.VolontariatAdherentBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Plante;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Tache;

@ManagedBean(name = "mbListeTachesPlantes") 
@RequestScoped
public class ListeTachesPlanteManagedBean implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value= "#{mbPlante.planteSelected}")
	private Plante plante; 

	@ManagedProperty(value = "#{mbConnect.adherent}")
	private Adherent adherent;	
	
	private List<Tache> tachesVolontariat;
	private List<Tache> tachesAffectees;
	private Tache selectedTache;
	private List<Tache> taches;
	private String affichage = "fa-heart-o";
	private String titrePlante;

	@EJB
	TacheBusiness proxyTaches;
	@EJB
	VolontariatAdherentBusiness proxyVonlontariat;
	@EJB
	AffectationAdherentBusiness proxyAffectAdherent;
	
	@PostConstruct
	public void init() {
		taches = proxyTaches.obtenirLesTachesPlanifeesViaPlante(plante);
		tachesAffectees = proxyAffectAdherent.obtenirTacheAffectByIdAdherent(adherent.getIdAdherent());
		tachesVolontariat = proxyVonlontariat.obtenirTacheVolontariatByAdherent(adherent.getIdAdherent());
	}

	public String masquerButton(Tache tache) {
			
			if(tachesAffectees.contains(tache)) {
				affichage="fa-heart";
			}else if(tachesVolontariat.contains(tache)) {
				affichage="fa-heart";
			}else {
				affichage ="fa-heart-o";
			}
		return affichage;
	}

	public void seporterVolontaire(Tache tache) {
		selectedTache = tache;
		proxyVonlontariat.insertVolontariat(adherent, selectedTache);
	}
	
	
	public List<Tache> getTaches() {
		return taches;
	}


	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}


	public Adherent getAdherent() {
		return adherent;
	}


	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}


	public Tache getSelectedTache() {
		return selectedTache;
	}


	public void setSelectedTache(Tache selectedTache) {
		this.selectedTache = selectedTache;
	}


	public String getAffichage() {
		return affichage;
	}


	public void setAffichage(String affichage) {
		this.affichage = affichage;
	}


	public List<Tache> getTachesVonlontariat() {
		return tachesVolontariat;
	}


	public void setTachesVolontariat(List<Tache> tachesVolontariat) {
		this.tachesVolontariat = tachesVolontariat;
	}


	public List<Tache> getTachesAffectees() {
		return tachesAffectees;
	}


	public void setTachesAffectees(List<Tache> tachesAffectees) {
		this.tachesAffectees = tachesAffectees;
	}

	public Plante getPlante() {
		return plante;
	}

	public void setPlante(Plante plante) {
		this.plante = plante;
	}

	public String getTitrePlante() {
		return titrePlante;
	}

	public void setTitrePlante(String titrePlante) {
		this.titrePlante = titrePlante;
	}

	public List<Tache> getTachesVolontariat() {
		return tachesVolontariat;
	}
	
	
	
}
