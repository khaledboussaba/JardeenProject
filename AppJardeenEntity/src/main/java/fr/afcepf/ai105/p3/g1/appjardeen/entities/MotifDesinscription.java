package fr.afcepf.ai105.p3.g1.appjardeen.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author formation
 * @version 1.0
 * @created 25-mai-2019 17:32:28
 */
@Entity
@Table(name = "motif_desinscription")
public class MotifDesinscription implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_motif_desinscription")
	private int idMotifDesinscription;
	@Column(name = "libelle_motif_desinscription")
	private String libelleMotifDesinscription;
	
	@OneToMany(mappedBy = "motifDesinscription")
	private Set<Desinscription> desinscriptions;

	public MotifDesinscription(){

	}

	public MotifDesinscription(String libelleMotifDesinscription) {
		super();
		this.libelleMotifDesinscription = libelleMotifDesinscription;
	}

	public int getIdMotifDesinscription() {
		return idMotifDesinscription;
	}

	public void setIdMotifDesinscription(int idMotifDesinscription) {
		this.idMotifDesinscription = idMotifDesinscription;
	}

	public String getLibelleMotifDesinscription() {
		return libelleMotifDesinscription;
	}

	public void setLibelleMotifDesinscription(String libelleMotifDesinscription) {
		this.libelleMotifDesinscription = libelleMotifDesinscription;
	}

	public Set<Desinscription> getDesinscriptions() {
		return desinscriptions;
	}

	public void setDesinscriptions(Set<Desinscription> desinscriptions) {
		this.desinscriptions = desinscriptions;
	}


}//end MotifDesinscription