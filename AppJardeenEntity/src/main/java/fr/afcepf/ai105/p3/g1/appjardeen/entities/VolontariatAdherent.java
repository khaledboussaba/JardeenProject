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
@Table(name = "volontariat_adherent")
public class VolontariatAdherent implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_volontariat_adherent")
	private int idAdherentVolontaire;
	
	@ManyToOne
	@JoinColumn(name = "id_adherent")
	private Adherent adherent;
	
	@ManyToOne
	@JoinColumn(name = "id_tache")
	private Tache tache;

	public int getIdAdherentVolontaire() {
		return idAdherentVolontaire;
	}

	public void setIdAdherentVolontaire(int idAdherentVolontaire) {
		this.idAdherentVolontaire = idAdherentVolontaire;
	}

	public Adherent getAdherent() {
		return adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

	public Tache getTache() {
		return tache;
	}

	public void setTache(Tache tache) {
		this.tache = tache;
	}
	
	
	
}
