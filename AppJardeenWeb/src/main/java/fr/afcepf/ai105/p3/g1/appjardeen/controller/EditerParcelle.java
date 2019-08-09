package fr.afcepf.ai105.p3.g1.appjardeen.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import fr.afcepf.ai105.p3.g1.appjardeen.business.AciditeBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.ParcelleBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.TerrainBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.TypeSolBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Acidite;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.HumiditeSol;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Parcelle;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Terrain;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.TypeSol;

@ManagedBean(name = "mbEditerParcelle")
@ViewScoped
public class EditerParcelle implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{mbGestionParcelles.selectedParcelle}")
	private Parcelle parcelle; 
	private Terrain terrain; 
	private String libelleParcelle;
	private TypeSol typeSolParcelle;
	private Terrain terrainParcelle;
	private List<TypeSol> typesSol;
	private List<Terrain> terrains;
	private List<Acidite> acidites;
	private List<HumiditeSol> humidites;
	private Acidite aciditeParcelle;
	private Date dateCreationParcelle;
	private Date dateRetraitParcelle;
	
	@EJB
	private TypeSolBusiness proxyTypeSol;
	
	@EJB
	private TerrainBusiness proxyTerrain;
	
	@EJB
	private AciditeBusiness proxyAcidite;
	
	@EJB
	private ParcelleBusiness proxyParcelle;
	
	@PostConstruct
	public void init() {
		typesSol = proxyTypeSol.obtenirTypeSol();
		terrains = proxyTerrain.obtenirTerrain();
		acidites = proxyAcidite.obtenirAcidite();
	}
	
	public String UpdateParcelle() {
		libelleParcelle = parcelle.getLibelleParcelle();
		for (Terrain terrain : terrains) {
			if(parcelle.getTerrain().getLibelleTerrain().equals(terrain.getLibelleTerrain())) {
				terrainParcelle = terrain;
			}
		}
		
		for (TypeSol typeSol : typesSol) {
			if(parcelle.getTypeSol().getLibelleTypeSol().equals(typeSol.getLibelleTypeSol())) {
				typeSolParcelle = typeSol;
			}
		}
		
		for (Acidite acidite : acidites) {
			if(parcelle.getAcidite().getIndiceAcidite()==acidite.getIndiceAcidite()) {
				aciditeParcelle = acidite;
			}
		}
		
		dateCreationParcelle = parcelle.getDateCreationParcelle();
		dateRetraitParcelle = parcelle.getDateRetraitParcelle();
		proxyParcelle.modifierParcelle(parcelle, libelleParcelle, typeSolParcelle, terrainParcelle, aciditeParcelle, dateCreationParcelle, dateRetraitParcelle);
		return "listeParcelles.xhtml";
	}
	
	public Parcelle getParcelle() {
		return parcelle;
	}
	public void setParcelle(Parcelle parcelle) {
		this.parcelle = parcelle;
	}
	public Terrain getTerrain() {
		return terrain;
	}
	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}
	public String getLibelleParcelle() {
		return libelleParcelle;
	}
	public void setLibelleParcelle(String libelleParcelle) {
		this.libelleParcelle = libelleParcelle;
	}
	
	public List<TypeSol> getTypesSol() {
		return typesSol;
	}


	public void setTypesSol(List<TypeSol> typesSol) {
		this.typesSol = typesSol;
	}


	public List<Terrain> getTerrains() {
		return terrains;
	}


	public void setTerrains(List<Terrain> terrains) {
		this.terrains = terrains;
	}


	public List<Acidite> getAcidites() {
		return acidites;
	}


	public void setAcidites(List<Acidite> acidites) {
		this.acidites = acidites;
	}


	public List<HumiditeSol> getHumidites() {
		return humidites;
	}


	public void setHumidites(List<HumiditeSol> humidites) {
		this.humidites = humidites;
	}
	public TypeSol getTypeSolParcelle() {
		return typeSolParcelle;
	}
	public void setTypeSolParcelle(TypeSol typeSolParcelle) {
		this.typeSolParcelle = typeSolParcelle;
	}
	public Terrain getTerrainParcelle() {
		return terrainParcelle;
	}
	public void setTerrainParcelle(Terrain terrainParcelle) {
		this.terrainParcelle = terrainParcelle;
	}
	public Acidite getAciditeParcelle() {
		return aciditeParcelle;
	}
	public void setAciditeParcelle(Acidite aciditeParcelle) {
		this.aciditeParcelle = aciditeParcelle;
	}
	public Date getDateCreationParcelle() {
		return dateCreationParcelle;
	}
	public void setDateCreationParcelle(Date dateCreationParcelle) {
		this.dateCreationParcelle = dateCreationParcelle;
	}
	public Date getDateRetraitParcelle() {
		return dateRetraitParcelle;
	}
	public void setDateRetraitParcelle(Date dateRetraitParcelle) {
		this.dateRetraitParcelle = dateRetraitParcelle;
	}

	
	
	
}
