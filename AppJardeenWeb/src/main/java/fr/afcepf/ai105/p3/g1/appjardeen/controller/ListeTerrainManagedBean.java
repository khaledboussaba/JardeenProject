package fr.afcepf.ai105.p3.g1.appjardeen.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.ai105.p3.g1.appjardeen.business.AdherentTerrainBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.TerrainBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.VilleBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adresse;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Tache;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Terrain;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Ville;

@ManagedBean(name = "mbListeTerrain")
@SessionScoped
public class ListeTerrainManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Terrain terrain;
	private List<Terrain> terrains;
	private List<Terrain> terrainsRetires;
	private Terrain terrainSelected;
	private List<Ville> villes; 
	private Ville villeSelected;
	private Adresse adresse = new Adresse();
	private String affichage = "fa-heart-o";
	@ManagedProperty(value = "#{mbConnect.adherent}")
	private Adherent adherent; 
	
	private List<Terrain> mesTerrains;
	
	@EJB
	private TerrainBusiness proxyTerrainBusiness;
	@EJB
	private VilleBusiness proxyVilleBusiness;	
	
	@EJB
	private AdherentTerrainBusiness proxyTerrainAdherent;
	
	@EJB
	private AdherentTerrainBusiness proxyAdherentTerrains;
	
	@PostConstruct
	public void init() {
		terrain = new Terrain();
		mesTerrains = proxyAdherentTerrains.obtenirTerrainAdherent(adherent.getIdAdherent());
		terrains = proxyTerrainBusiness.obtenirTerrainNonRetire();
		terrainsRetires = proxyTerrainBusiness.obtenirLaListeDesTerrainsRetires();
		villes=proxyVilleBusiness.obtenirToutesLesVilles();
	}

	public String retirerTerrain(Terrain terrain) {
		this.terrain = terrain;
		terrain.setDateRetraitTerrain(new Date());
		proxyTerrainBusiness.retirerTerrain(terrain);
		init();
		return "/listeTerrain.xhtml?faces-redirect=true";
	}
	
	public String rajouterTerrain(Terrain terrain) {
		this.terrain = terrain;
		terrain.setDateRetraitTerrain(null);
		terrain.setDateCreationTerrain(new Date());
		proxyTerrainBusiness.rajouterTerrain(terrain);
		init();
		return "/listeTerrain.xhtml?faces-redirect=true";
	}
	
	public String creerNouveauTerrain() {
		terrain.setDateCreationTerrain(new Date());
		adresse.setVille(villeSelected);
		terrain.setAdresse(adresse);
		terrain = proxyTerrainBusiness.enregistrerTerrain(terrain);
		init();
		return "/listeTerrain.xhtml?faces-redirect=true";
	}
	
	public String afficherTerrain(Terrain terrain) {
		terrainSelected=terrain;
		return "/parcelles.xhtml?faces-redirect=true";
	}
	
	public void choisirTerrainFavoris(Terrain terrain) {
		terrainSelected = terrain;
		proxyTerrainAdherent.ajouterTerrainFavoris(adherent, terrainSelected);
	}
	
	
	public String masquerButton(Terrain terrain) {	
		if(mesTerrains.contains(terrain)) {
				affichage = "fa-heart";
		} else {
				affichage = "fa-heart-o";	
		}	
	return affichage;
}
	
	
	public List<Terrain> getTerrains() {
		return terrains;
	}

	public void setTerrains(List<Terrain> terrains) {
		this.terrains = terrains;
	}

	public List<Terrain> getTerrainsRetires() {
		return terrainsRetires;
	}

	public void setTerrainsRetires(List<Terrain> terrainsRetires) {
		this.terrainsRetires = terrainsRetires;
	}

	public Terrain getTerrainSelected() {
		return terrainSelected;
	}

	public void setTerrainSelected(Terrain terrainSelected) {
		this.terrainSelected = terrainSelected;
	}

	public Terrain getTerrain() {
		return terrain;
	}

	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}

	public List<Ville> getVilles() {
		return villes;
	}

	public void setVilles(List<Ville> villes) {
		this.villes = villes;
	}

	public Ville getVilleSelected() {
		return villeSelected;
	}

	public void setVilleSelected(Ville villeSelected) {
		this.villeSelected = villeSelected;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Adherent getAdherent() {
		return adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

	public List<Terrain> getMesTerrains() {
		return mesTerrains;
	}

	public void setMesTerrains(List<Terrain> mesTerrains) {
		this.mesTerrains = mesTerrains;
	}

	public String isAffichage() {
		return affichage;
	}

	public void setAffichage(String affichage) {
		this.affichage = affichage;
	}
	
	
}
