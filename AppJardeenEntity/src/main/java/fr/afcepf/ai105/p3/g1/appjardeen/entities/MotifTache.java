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
@Table(name = "motif_tache")
public class MotifTache implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_motif_tache")
	private int idMotifTache;
	@Column(name = "libelle_motif_tache")
	private String libelleMotifTache;
	
	@OneToMany(mappedBy = "motifAnnulation")
	private Set<Tache> tachesAnnulees;
	@OneToMany(mappedBy = "motifReport")
	private Set<Tache> tachesReportees;

	public MotifTache(){

	}

	public MotifTache(String libelleMotifTache) {
		super();
		this.libelleMotifTache = libelleMotifTache;
	}

	public int getIdMotifTache() {
		return idMotifTache;
	}

	public void setIdMotifTache(int idMotifTache) {
		this.idMotifTache = idMotifTache;
	}

	public String getLibelleMotifTache() {
		return libelleMotifTache;
	}

	public void setLibelleMotifTache(String libelleMotifTache) {
		this.libelleMotifTache = libelleMotifTache;
	}

	public Set<Tache> getTachesAnnulees() {
		return tachesAnnulees;
	}

	public void setTachesAnnulees(Set<Tache> tachesAnnulees) {
		this.tachesAnnulees = tachesAnnulees;
	}

	public Set<Tache> getTachesReportees() {
		return tachesReportees;
	}

	public void setTachesReportees(Set<Tache> tachesReportees) {
		this.tachesReportees = tachesReportees;
	}


}//end MotifTache