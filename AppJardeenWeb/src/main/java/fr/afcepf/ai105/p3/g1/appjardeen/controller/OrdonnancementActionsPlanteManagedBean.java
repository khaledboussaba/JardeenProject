package fr.afcepf.ai105.p3.g1.appjardeen.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.afcepf.ai105.p3.g1.appjardeen.business.ActionsBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.ActionsPlanteBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Actions;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.ActionsPlante;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Plante;

@ManagedBean(name = "mbOrdoActionsPlante")
public class OrdonnancementActionsPlanteManagedBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{mbPlante.planteSelected}")
	private Plante plante; 
	private List<Actions> allActions;
	private List<ActionsPlante> actionsPlanteDejaAffectees;
	private ActionsPlante newActionsPlante = new ActionsPlante();
	private ActionsPlante actionsPlanteSelected = new ActionsPlante();

	@EJB 
	ActionsBusiness proxyActionBusiness;
	@EJB 
	ActionsPlanteBusiness proxyActionsPlanteBusiness;
	
	@PostConstruct
	public void init() {
		allActions = proxyActionBusiness.listeActionsNonDejaOrdonnanceeByPlante(plante);
		actionsPlanteDejaAffectees = proxyActionsPlanteBusiness.obtenirToutesActionsPlanteByPlante(plante);
	}

	public String affecterActionPlante() {
		newActionsPlante.setPlante(plante);
		proxyActionsPlanteBusiness.ajouterActionPlante(newActionsPlante);
		return "ordonnancementActionsPlante.xhtml?faces-redirect=true";
	}
	
	public String supprimerActionPlante(int id) {
		proxyActionsPlanteBusiness.supprimerActionPlante(id);
		return "ordonnancementActionsPlante.xhtml?faces-redirect=true";
	}
	
	public Plante getPlante() {
		return plante;
	}

	public void setPlante(Plante plante) {
		this.plante = plante;
	}

	public List<Actions> getAllActions() {
		return allActions;
	}

	public void setAllActions(List<Actions> allActions) {
		this.allActions = allActions;
	}

	public List<ActionsPlante> getActionsPlanteDejaAffectees() {
		return actionsPlanteDejaAffectees;
	}

	public void setActionsPlanteDejaAffectees(List<ActionsPlante> actionsPlanteDejaAffectees) {
		this.actionsPlanteDejaAffectees = actionsPlanteDejaAffectees;
	}

	public ActionsPlante getNewActionsPlante() {
		return newActionsPlante;
	}

	public void setNewActionsPlante(ActionsPlante newActionsPlante) {
		this.newActionsPlante = newActionsPlante;
	}

	public ActionsPlante getActionsPlanteSelected() {
		return actionsPlanteSelected;
	}

	public void setActionsPlanteSelected(ActionsPlante actionsPlanteSelected) {
		this.actionsPlanteSelected = actionsPlanteSelected;
	}
  
	

	
}
