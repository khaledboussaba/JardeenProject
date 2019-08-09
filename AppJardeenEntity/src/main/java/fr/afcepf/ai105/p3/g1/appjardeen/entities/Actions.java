package fr.afcepf.ai105.p3.g1.appjardeen.entities;


import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author merye
 * @version 1.0
 * @created 25-mai-2019 17:32:28
 */
@Entity
@Table(name="actions")
public class Actions implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_action")
	private int idAction;
	@Column(name="libelle_action")
	private String libelleAction;
	
	@ManyToOne
	@JoinColumn(name = "id_competence")
	private Competence competence;
	
	@OneToMany(mappedBy = "action")
	private List<OutilAction> outilAction;
	
	@OneToMany(mappedBy = "action")
	private List<Tache> taches;
	
	@OneToMany(mappedBy = "action")
	private List<ActionsPlante> actionsPlante;
	
	public Actions(){

	}

	public Actions(String libelleAction, Competence competence) {
		super();
		this.libelleAction = libelleAction;
		this.competence = competence;
	}

	public Actions(String libelleAction) {
		super();
		this.libelleAction = libelleAction;
	}

	
	public int getIdAction() {
		return idAction;
	}
	public void setIdAction(int idAction) {
		this.idAction = idAction;
	}
	public String getLibelleAction() {
		return libelleAction;
	}
	public List<OutilAction> getOutilAction() {
		return outilAction;
	}
	public void setOutilAction(List<OutilAction> outilAction) {
		this.outilAction = outilAction;
	}
	public List<ActionsPlante> getActionsPlante() {
		return actionsPlante;
	}
	public void setActionsPlante(List<ActionsPlante> actionsPlante) {
		this.actionsPlante = actionsPlante;
	}
	public void setLibelleAction(String libelleAction) {
		this.libelleAction = libelleAction;
	}
	public Competence getCompetence() {
		return competence;
	}
	public void setCompetence(Competence competence) {
		this.competence = competence;
	}
	public List<Tache> getTaches() {
		return taches;
	}
	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}
}//end Action