package fr.afcepf.ai105.p3.g1.appjardeen.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.ai105.p3.g1.appjardeen.business.ParcelleBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Acidite;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Parcelle;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Terrain;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.TypeSol;

@ManagedBean(name = "mbGestionParcelles")
@SessionScoped
public class GestionParcellesManagedBean implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private List<Parcelle> parcelles;
	private Parcelle selectedParcelle;
	private String libelleParcelle;
	private TypeSol typeSol;
	private Terrain terrain;
	private Acidite acidite;
	private Date dateCreation;
	
	@EJB
	ParcelleBusiness proxyParcelles;
	
	@PostConstruct
	public void init() {
		parcelles = proxyParcelles.listerParcelles();
	}
	
	public String ajouterParcelle() {
		proxyParcelles.createParcelle(libelleParcelle, typeSol, terrain, acidite, dateCreation);
		return "pageAdherent.xhtml";
	}
	
	public String afficherParcelle(Parcelle parcelle) {
		selectedParcelle = parcelle; 
		return "editerParcelle.xhtml?faces-redirect=true";
		
	}
	


	public List<Parcelle> getParcelles() {
		return parcelles;
	}

	public void setParcelles(List<Parcelle> parcelles) {
		this.parcelles = parcelles;
	}

	public Parcelle getSelectedParcelle() {
		return selectedParcelle;
	}

	public void setSelectedParcelle(Parcelle selectedParcelle) {
		this.selectedParcelle = selectedParcelle;
	}

	public String getLibelleParcelle() {
		return libelleParcelle;
	}

	public void setLibelleParcelle(String libelleParcelle) {
		this.libelleParcelle = libelleParcelle;
	}

	public TypeSol getTypeSol() {
		return typeSol;
	}

	public void setTypeSol(TypeSol typeSol) {
		this.typeSol = typeSol;
	}

	public Terrain getTerrain() {
		return terrain;
	}

	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}

	public Acidite getAcidite() {
		return acidite;
	}

	public void setAcidite(Acidite acidite) {
		this.acidite = acidite;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	

}
