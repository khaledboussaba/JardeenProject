package fr.afcepf.ai105.p3.g1.appjardeen.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import fr.afcepf.ai105.p3.g1.appjardeen.business.TerrainBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.VilleBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adresse;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Terrain;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Ville;

@ManagedBean(name="mbEnregistrementTerrain")
@SessionScoped
public class EnregistrementTerrainManagedBean implements Serializable{
	private static final long serialVersionUID = 1L;

//	private Terrain terrain;
//	private List<Ville> villes; 
//	private Ville villeSelected;
//
//	
//	@EJB
//	private TerrainBusiness proxyTerrainBusiness;
//	@EJB
//	private VilleBusiness proxyVilleBusiness;	
//	
//	@PostConstruct
//	public void init() {
//		terrain = new Terrain();
//		villes=proxyVilleBusiness.obtenirToutesLesVilles();
//	}	
//	
//	public Terrain getTerrain() {
//		return terrain;
//	}
//
//	public void setTerrain(Terrain terrain) {
//		this.terrain = terrain;
//	}
//
//	public List<Ville> getVilles() {
//		return villes;
//	}
//
//	public void setVilles(List<Ville> villes) {
//		this.villes = villes;
//	}
//
//	public Ville getVilleSelected() {
//		return villeSelected;
//	}
//
//	public void setVilleSelected(Ville villeSelected) {
//		this.villeSelected = villeSelected;
//	}

	

}
