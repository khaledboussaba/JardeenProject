package fr.afcepf.ai105.p3.g1.appjardeen.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

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
@Table(name = "affectation_adherent")
public class AffectationAdherent implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_affectation_adherent")
	private int idAffectationAdherent;
		
	@ManyToOne
	@JoinColumn(name = "id_adherent")
	private Adherent adherent;
	
	@ManyToOne
	@JoinColumn(name = "id_tache")
	private Tache tache;

	public AffectationAdherent(){

	}

	public AffectationAdherent(Adherent adherent, Tache tache) {
		super();
		
		this.adherent = adherent;
		this.tache = tache;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(adherent, tache);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof AffectationAdherent)) {
			return false;
		}
		AffectationAdherent other = (AffectationAdherent) obj;
		return Objects.equals(adherent, other.adherent) && Objects.equals(tache, other.tache);
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


}//end AffectationAdherent