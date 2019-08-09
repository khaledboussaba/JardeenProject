package fr.afcepf.ai105.p3.g1.appjardeen.controller;

import java.util.Date;
import java.util.List;

import org.primefaces.model.DefaultScheduleEvent;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Actions;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Competence;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Parcelle;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Plante;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Terrain;

public class PlannintAdherentEvent extends DefaultScheduleEvent  {

	private static final long serialVersionUID = 1L;
	
	private List<Adherent> adherent;
	private Terrain terrain;
	private Parcelle parcelle;
	private Actions action;
	private Plante plante;
	private Competence competence;
		
	public PlannintAdherentEvent() {
		super();
		
	}

	public PlannintAdherentEvent(String title, Date start, Date end, Object data, List<Adherent> adherent, 
								Terrain terrain, Parcelle parcelle,  Actions action,
								Plante plante, Competence competence) {
		super(title, start, end, data);
		this.adherent = adherent;
		this.terrain = terrain;
		this.parcelle = parcelle;
		this.action = action;
		this.plante = plante;
		this.competence = competence;
	}

	

	public PlannintAdherentEvent(List<Adherent> adherent, Terrain terrain) {
		super();
		this.adherent = adherent;
		this.terrain = terrain;
	}

	public List<Adherent> getAdherent() {
		return adherent;
	}

	public void setAdherent(List<Adherent> adherent) {
		this.adherent = adherent;
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
	
	
	

}
