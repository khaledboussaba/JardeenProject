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

/**
 * @author merye
 * @version 1.0
 * @created 25-mai-2019 17:32:28
 */
@Entity
@Table(name = "emplacement")
public class Emplacement implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_emplacement")
	private int idEmplacement;
	private int numLigne;
	private int numColonne;

	@ManyToOne
	@JoinColumn(name = "id_parcelle")
	private Parcelle parcelle;

	public Emplacement() {

	}

	public Emplacement(int numLigne, int numColonne) {
		super();
		this.numLigne = numLigne;
		this.numColonne = numColonne;
	}
	public Emplacement(int numLigne, int numColonne, Parcelle p) {
		super();
		this.numLigne = numLigne;
		this.numColonne = numColonne;
		this.parcelle=p;
	}
	
	public int getIdEmplacement() {
		return idEmplacement;
	}

	public void setIdEmplacement(int idEmplacement) {
		this.idEmplacement = idEmplacement;
	}

	public Parcelle getParcelle() {
		return parcelle;
	}

	public void setParcelle(Parcelle parcelle) {
		this.parcelle = parcelle;
	}

	public int getNumLigne() {
		return numLigne;
	}

	public void setNumLigne(int numLigne) {
		this.numLigne = numLigne;
	}

	public int getNumColonne() {
		return numColonne;
	}

	public void setNumColonne(int numColonne) {
		this.numColonne = numColonne;
	}

	@Override
	public String toString() {
		return "Emplacement [numLigne=" + numLigne + ", numColonne=" + numColonne + "]";
	}

	@Override
	public boolean equals(Object obj) {
		return (((Emplacement) obj).getNumLigne() == this.getNumLigne()) && (((Emplacement) obj).getNumColonne() == this.getNumColonne());
	}
	
}// end Emplacement