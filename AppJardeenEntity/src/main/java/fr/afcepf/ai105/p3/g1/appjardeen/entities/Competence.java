package fr.afcepf.ai105.p3.g1.appjardeen.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author merye
 * @version 1.0
 * @created 25-mai-2019 17:32:28
 */
@Entity
@Table(name = "competence")
public class Competence implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_competence")
	private int idCompetence;
	@Column(name = "libelle_competence")
	private String libelleCompetence;
	
	@OneToMany(mappedBy = "competence")
	private Set<Actions> actions;
	@OneToMany(mappedBy = "competence")
	private Set<Adherent> adherents;
	@OneToMany(mappedBy = "competence")
	private Set<Tache> taches;

	public Competence(){

	}

	public Competence(String libelleCompetence) {
		super();
		this.libelleCompetence = libelleCompetence;
	}


	public int getIdCompetence() {
		return idCompetence;
	}

	public void setIdCompetence(int idCompetence) {
		this.idCompetence = idCompetence;
	}

	public String getLibelleCompetence() {
		return libelleCompetence;
	}

	public void setLibelleCompetence(String libelleCompetence) {
		this.libelleCompetence = libelleCompetence;
	}

	public Set<Actions> getActions() {
		return actions;
	}

	public void setActions(Set<Actions> actions) {
		this.actions = actions;
	}

	public Set<Adherent> getAdherents() {
		return adherents;
	}

	public void setAdherents(Set<Adherent> adherents) {
		this.adherents = adherents;
	}

	public Set<Tache> getTaches() {
		return taches;
	}

	public void setTaches(Set<Tache> taches) {
		this.taches = taches;
	}
}//end Competence