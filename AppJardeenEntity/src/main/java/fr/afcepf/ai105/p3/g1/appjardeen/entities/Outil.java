package fr.afcepf.ai105.p3.g1.appjardeen.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * @author merye
 * @version 1.0
 * @created 25-mai-2019 17:32:28
 */
@Entity
@Table(name = "outil")
public class Outil implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_outil")
	private int idOutil;
	@Column(name = "libelle_outil")	
	private String libelleOutil;
	@Column(name = "quantite_outil_totale")	
	private int quantiteOutilTotale;
	
	@OneToMany(mappedBy = "outil")
	private List<OutilTache> outilsTache;
	
	@OneToMany(mappedBy = "outil")
	private List<OutilAction> outilsAction;
	
	@Transient
	private int quantiteAllouee;

	public Outil(){

	}

	public Outil(String libelleOutil, int quantiteOutilTotale) {
		super();
		this.libelleOutil = libelleOutil;
		this.quantiteOutilTotale = quantiteOutilTotale;
	}

	public Outil(int idOutil, int quantiteOutilTotale, int quantiteAllouee) {
		super();
		this.idOutil = idOutil;
		this.quantiteOutilTotale = quantiteOutilTotale;
		this.setQuantiteAllouee(quantiteAllouee);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idOutil);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Outil)) {
			return false;
		}
		Outil other = (Outil) obj;
		return idOutil == other.idOutil;
	}

	public int getIdOutil() {
		return idOutil;
	}
	public void setIdOutil(int idOutil) {
		this.idOutil = idOutil;
	}
	public String getLibelleOutil() {
		return libelleOutil;
	}
	public void setLibelleOutil(String libelleOutil) {
		this.libelleOutil = libelleOutil;
	}
	public int getQuantiteOutilTotale() {
		return quantiteOutilTotale;
	}
	public void setQuantiteOutilTotale(int quantiteOutilTotale) {
		this.quantiteOutilTotale = quantiteOutilTotale;
	}
	public List<OutilTache> getOutilsTache() {
		return outilsTache;
	}
	public void setOutilTache(List<OutilTache> outilsTache) {
		this.outilsTache = outilsTache;
	}
	public List<OutilAction> getOutilsAction() {
		return outilsAction;
	}
	public void setOutilAction(List<OutilAction> outilsAction) {
		this.outilsAction = outilsAction;
	}
	@Transient
	public int getQuantiteAllouee() {
		return quantiteAllouee;
	}
	public void setQuantiteAllouee(int quantiteAllouee) {
		this.quantiteAllouee = quantiteAllouee;
	}
}//end Outil