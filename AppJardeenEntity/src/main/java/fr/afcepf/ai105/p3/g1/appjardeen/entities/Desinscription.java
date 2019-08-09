package fr.afcepf.ai105.p3.g1.appjardeen.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author formation
 * @version 1.0
 * @created 25-mai-2019 17:32:28
 */
@Entity
@Table(name = "desinscription")
public class Desinscription implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_desinscription")
	private int idDesinscription;
	@Column(name = "date_desinscription")
	private Date dateDesinscription;
	
	@ManyToOne
	@JoinColumn(name = "id_adherent")
	private Adherent adherent;
	@ManyToOne
	@JoinColumn(name = "id_motif_desinscription")
	private MotifDesinscription motifDesinscription;

	public Desinscription(){

	}

	public Desinscription(Date dateDesinscription, Adherent adherent, MotifDesinscription motifDesinscription) {
		super();
		this.dateDesinscription = dateDesinscription;
		this.adherent = adherent;
		this.motifDesinscription = motifDesinscription;
	}

	public int getIdDesinscription() {
		return idDesinscription;
	}

	public void setIdDesinscription(int idDesinscription) {
		this.idDesinscription = idDesinscription;
	}

	public Date getDateDesinscription() {
		return dateDesinscription;
	}

	public void setDateDesinscription(Date dateDesinscription) {
		this.dateDesinscription = dateDesinscription;
	}

	public Adherent getAdherent() {
		return adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

	public MotifDesinscription getMotifDesinscription() {
		return motifDesinscription;
	}

	public void setMotifDesinscription(MotifDesinscription motifDesinscription) {
		this.motifDesinscription = motifDesinscription;
	}


}//end Desinscription