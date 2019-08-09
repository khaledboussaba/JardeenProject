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
@Table(name = "outil_action")
public class OutilAction implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_outil_action")
	private int idOutilTache;
	
	@ManyToOne
	@JoinColumn(name = "id_action")
	private Actions action;
	
	@ManyToOne
	@JoinColumn(name = "id_outil")
	private Outil outil;
	
	public OutilAction(Actions action, Outil outil) {
		super();
		this.action = action;
		this.outil = outil;
	}
	
	public OutilAction() {
		super();
	}

	public int getIdOutilTache() {
		return idOutilTache;
	}
	public void setIdOutilTache(int idOutilTache) {
		this.idOutilTache = idOutilTache;
	}
	public Actions getAction() {
		return action;
	}
	public void setAction(Actions action) {
		this.action = action;
	}
	public Outil getOutil() {
		return outil;
	}
	public void setOutil(Outil outil) {
		this.outil = outil;
	}
	
	
}
