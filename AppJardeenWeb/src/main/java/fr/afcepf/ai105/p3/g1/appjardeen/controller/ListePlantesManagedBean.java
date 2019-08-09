package fr.afcepf.ai105.p3.g1.appjardeen.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import fr.afcepf.ai105.p3.g1.appjardeen.business.PlanteBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.TacheBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Plante;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Tache;

@ManagedBean(name = "mbPlante")
@SessionScoped
public class ListePlantesManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Plante> plantes;
	private Plante planteSelected;

	@EJB
	PlanteBusiness proxyPlanteBusiness;
	
	@PostConstruct
    public void init() {
		plantes= proxyPlanteBusiness.listerPlantes();
    }
	
    public String editPlante(Plante plante) {
		planteSelected = plante;
		return "/ordonnancementActionsPlante.xhtml?faces-redirect=true";
    }
	
    public String afficherTache(Plante p) {
    	planteSelected=p;
		return "/listeTachesPlante.xhtml?faces-redirect=true";
    }
	
	public List<Plante> getPlantes() {
		return plantes;
	}

	public void setPlantes(List<Plante> plantes) {
		this.plantes = plantes;
	}

	public Plante getPlanteSelected() {
		return planteSelected;
	}

	public void setPlanteSelected(Plante planteSelected) {
		this.planteSelected = planteSelected;
	}

	
	
}
