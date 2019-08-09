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
 * @author merye
 * @version 1.0
 * @created 25-mai-2019 17:32:28
 */
@Entity
@Table(name="indisponibilite")
public class Indisponibilite implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_indisponibilite")
	private int idIndisponibilite;
	@Column(name = "debut_date_indisponibilite")
	private Date debutDateIndisponibilite;
	@Column(name = "fin_date_indisponibilite")
	private Date finDateIndisponibilite;

	
	@ManyToOne
	@JoinColumn(name = "id_adherent")
	private Adherent adherent;

	public Indisponibilite(){

	}

	public Indisponibilite(Date debutDateIndisponibilite, Date finDateIndisponibilite, Adherent adherent) {
		super();
		this.debutDateIndisponibilite = debutDateIndisponibilite;
		this.finDateIndisponibilite = finDateIndisponibilite;
		this.adherent = adherent;
	}

	public int getIdIndisponibilite() {
		return idIndisponibilite;
	}

	public void setIdIndisponibilite(int idIndisponibilite) {
		this.idIndisponibilite = idIndisponibilite;
	}

	public Date getDebutDateIndisponibilite() {
		return debutDateIndisponibilite;
	}

	public void setDebutDateIndisponibilite(Date debutDateIndisponibilite) {
		this.debutDateIndisponibilite = debutDateIndisponibilite;
	}

	public Date getFinDateIndisponibilite() {
		return finDateIndisponibilite;
	}

	public void setFinDateIndisponibilite(Date finDateIndisponibilite) {
		this.finDateIndisponibilite = finDateIndisponibilite;
	}

	public Adherent getAdherent() {
		return adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

}//end Indisponibilite