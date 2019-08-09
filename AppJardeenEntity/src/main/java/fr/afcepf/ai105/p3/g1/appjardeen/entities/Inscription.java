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
@Table(name = "inscription")
public class Inscription implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )	
	@Column(name = "id_inscription")
	private int idInscription;
	@Column(name = "date_inscription")
	private Date dateInscription;
	
	
	
	@ManyToOne
	@JoinColumn(name = "id_adherent")
	private Adherent adherent;

	public Inscription(){

	}

	public Inscription(Date dateInscription, Adherent adherent) {
		super();
		this.dateInscription = dateInscription;
		this.adherent = adherent;
	}

	public int getIdInscription() {
		return idInscription;
	}

	public void setIdInscription(int idInscription) {
		this.idInscription = idInscription;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public Adherent getAdherent() {
		return adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}


}//end Inscription