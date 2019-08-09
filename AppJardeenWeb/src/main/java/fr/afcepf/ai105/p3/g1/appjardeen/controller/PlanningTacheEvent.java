package fr.afcepf.ai105.p3.g1.appjardeen.controller;

import java.util.Date;
import java.util.List;

import org.primefaces.model.DefaultScheduleEvent;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Actions;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Competence;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Parcelle;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Plante;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Tache;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Terrain;

public class PlanningTacheEvent extends DefaultScheduleEvent{

	private static final long serialVersionUID = 1L;
	
	private List<Adherent> adherents;
	private Terrain terrain;
	private Parcelle parcelle;
	private Actions action;
	private Plante plante;
	private Competence competence;
	private Tache tache;
	
	
	
	
	public PlanningTacheEvent() {
		super();
		
	}

	public PlanningTacheEvent(String title, Date start, Date end, Object data, 
							List<Adherent> adherents, Terrain terrain, Parcelle parcelle,  Actions action,
							Plante plante, Competence competence, Tache tache) {
		super(title, start, end, data);
		this.adherents = adherents;
		this.terrain = terrain;
		this.parcelle = parcelle;
		this.action = action;
		this.plante = plante;
		this.competence = competence;
		this.tache = tache;
	}

	
	public PlanningTacheEvent(List<Adherent> adherents) {
		super();
		this.adherents = adherents;
	}

	public List<Adherent> getAdherents() {
		return adherents;
	}

	public void setAdherents(List<Adherent> adherents) {
		this.adherents = adherents;
	}

	public Terrain getTerrain() {
		return terrain;
	}

	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}

	public Parcelle getParcelle() {
		return parcelle;
	}

	public void setParcelle(Parcelle parcelle) {
		this.parcelle = parcelle;
	}

	public Actions getAction() {
		return action;
	}

	public void setAction(Actions action) {
		this.action = action;
	}

	public Plante getPlante() {
		return plante;
	}

	public void setPlante(Plante plante) {
		this.plante = plante;
	}

	public Competence getCompetence() {
		return competence;
	}

	public void setCompetence(Competence competence) {
		this.competence = competence;
	}

	public Tache getTache() {
		return tache;
	}

	public void setTache(Tache tache) {
		this.tache = tache;
	}
	
	

}
