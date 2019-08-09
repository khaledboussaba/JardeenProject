package fr.afcepf.ai105.p3.g1.appjardeen.entities;

import java.io.Serializable;
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
 * @author merye
 * @version 1.0
 * @created 25-mai-2019 17:32:29
 */
@Entity
@Table(name = "outil_tache")
public class OutilTache implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_outil_tache")
	private int idOutilTache;
	
	@Column(name = "quantite_outil_utilisee")
	private int quantiteOutilUtilisee;

	@ManyToOne
	@JoinColumn(name = "id_tache")
	private Tache tache;
	
	@ManyToOne
	@JoinColumn(name = "id_outil")
	private Outil outil;

	public OutilTache(){

	}

	public OutilTache(int quantiteOutilUtilisee, Tache tache, Outil outil) {
		super();
		this.quantiteOutilUtilisee = quantiteOutilUtilisee;
		this.tache = tache;
		this.outil = outil;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(outil, tache);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof OutilTache)) {
			return false;
		}
		OutilTache other = (OutilTache) obj;
		return Objects.equals(outil, other.outil) && Objects.equals(tache, other.tache);
	}

	public int getQuantiteOutilUtilisee() {
		return quantiteOutilUtilisee;
	}

	public void setQuantiteOutilUtilisee(int quantiteOutilUtilisee) {
		this.quantiteOutilUtilisee = quantiteOutilUtilisee;
	}

	public Tache getTache() {
		return tache;
	}

	public void setTache(Tache tache) {
		this.tache = tache;
	}

	public Outil getOutil() {
		return outil;
	}

	public void setOutil(Outil outil) {
		this.outil = outil;
	}


}//end OutilsTache