package fr.afcepf.ai105.p3.g1.appjardeen.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "actions_plante")
public class ActionsPlante implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_actions_plante")
	private int idActionsPlante;
	@Column(name = "num_ordonnancement")
	private int numOrdonnancement;
	
	@ManyToOne
	@JoinColumn(name = "id_action")
	private Actions action;

	@ManyToOne
	@JoinColumn(name = "id_plante")
	private Plante plante;

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

	public int getIdActionsPlante() {
		return idActionsPlante;
	}

	public void setIdActionsPlante(int idActionsPlante) {
		this.idActionsPlante = idActionsPlante;
	}

	public ActionsPlante() {
		super();
	}

	public int getNumOrdonnancement() {
		return numOrdonnancement;
	}

	public void setNumOrdonnancement(int numOrdonnancement) {
		this.numOrdonnancement = numOrdonnancement;
	}

	
	
}
