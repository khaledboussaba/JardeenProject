package fr.afcepf.ai105.p3.g1.appjardeen.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import fr.afcepf.ai105.p3.g1.appjardeen.business.AdherentTerrainBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.AdherentTerrain;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Terrain;


@ManagedBean(name = "mbTerrainsAdherent")
@SessionScoped
public class TerrainsAdherentManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	

	private List<AdherentTerrain> terrainsFavoris;
	private AdherentTerrain adTerrain;
	@ManagedProperty(value = "#{mbConnect.adherent}")
	private Adherent adherent;

	@EJB
	private AdherentTerrainBusiness proxyAdherentTerrains;
	
	@PostConstruct
	public void init() {
		
		terrainsFavoris = proxyAdherentTerrains.obtenirAdherentTerrain(adherent.getIdAdherent());
	
	}

	public void supprimmerTerrain(AdherentTerrain adTerrain) {
		
		proxyAdherentTerrains.annullerTerrainFavoris(adTerrain);
	}
	
	public Adherent getAdherent() {
		return adherent;
	}



	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

	public List<AdherentTerrain> getTerrainsFavoris() {
		return terrainsFavoris;
	}

	public void setTerrainsFavoris(List<AdherentTerrain> terrainsFavoris) {
		this.terrainsFavoris = terrainsFavoris;
	}

	public AdherentTerrain getAdTerrain() {
		return adTerrain;
	}

	public void setAdTerrain(AdherentTerrain adTerrain) {
		this.adTerrain = adTerrain;
	}
	
	
	
	
	
}
