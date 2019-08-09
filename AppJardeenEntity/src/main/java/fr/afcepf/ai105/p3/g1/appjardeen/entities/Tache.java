package fr.afcepf.ai105.p3.g1.appjardeen.entities;

import java.io.Serializable;
import java.util.Date; 
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author merye
 * @version 1.0
 * @created 25-mai-2019 17:32:29
 */
@Entity
@Table(name = "tache")
public class Tache implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_tache")
	private int idTache;
	
	@Column(name="libelle_tache")
	private String libelleTache;
	
	@Column(name="date_annulation_tache")
	private Date dateAnnulationTache;
	
	@Column(name="date_debut_tache")
	private Date dateDebutTache;
	
	@Column(name="date_fin_tache")
	private Date dateFinTache;
	
	@Column(name="nb_adherent_requis")
	private int nbAdherentRequis;
	
	@ManyToOne
	@JoinColumn(name = "id_motif_annulation")
	private MotifTache motifAnnulation;
	
	@ManyToOne
	@JoinColumn(name = "id_parcelle")
	private Parcelle parcelle;
	
	@ManyToOne
	@JoinColumn(name = "id_action")
	private Actions action;
	
	@ManyToOne
	@JoinColumn(name = "id_tache_pere")
	private Tache tachePere;
	
	@ManyToOne
	@JoinColumn(name = "id_plante")
	private Plante plante;
	
	@ManyToOne
	@JoinColumn(name = "id_motif_report")
	private MotifTache motifReport;
	
	@ManyToOne
	@JoinColumn(name = "id_competence")
	private Competence competence;
	
	@OneToMany(mappedBy = "tache", fetch = FetchType.EAGER)
	private List<OutilTache> outilTache;
	
	@OneToMany(mappedBy = "tache", fetch = FetchType.EAGER)
	private List<AffectationAdherent> affectationsAdherents;
	@OneToMany(mappedBy = "tachePere")
	private List<Tache> tachesFilles;
	
	@OneToMany(mappedBy = "tache")
	private List<VolontariatAdherent> volontariatAdherent;
	
	public Tache(){

	}

	public Tache(String libelleTache, Date dateDebutTache, Date dateFinTache, int nbAdherentRequis,
			Parcelle parcelle, Actions action, Plante plante, Competence competence) {
		super();
		this.libelleTache = libelleTache;
		this.dateDebutTache = dateDebutTache;
		this.dateFinTache = dateFinTache;
		this.nbAdherentRequis = nbAdherentRequis;
		this.parcelle = parcelle;
		this.action = action;
		this.plante = plante;
		this.competence = competence;
	}
	
		public Tache(String libelleTache, Date dateAnnulationTache, Date dateDebutTache, Date dateFinTache,
			int nbAdherentRequis, MotifTache motifAnnulation, Parcelle parcelle, Actions action, Tache tacheSuivante,
			Tache tachePrecedente, Plante plante, MotifTache motifReport, 
			Competence competence, List<OutilTache> outilTache,
			List<AffectationAdherent> affectationsAdherents) {
		super();
		this.libelleTache = libelleTache;
		this.dateAnnulationTache = dateAnnulationTache;
		this.dateDebutTache = dateDebutTache;
		this.dateFinTache = dateFinTache;
		this.nbAdherentRequis = nbAdherentRequis;
		this.motifAnnulation = motifAnnulation;
		this.parcelle = parcelle;
		this.action = action;
		this.plante = plante;
		this.competence = competence;
		this.outilTache = outilTache;
		this.affectationsAdherents = affectationsAdherents;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idTache);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Tache)) {
			return false;
		}
		Tache other = (Tache) obj;
		return idTache == other.idTache;
	}

	public int getIdTache() {
		return idTache;
	}
	public void setIdTache(int idTache) {
		this.idTache = idTache;
	}
	public String getLibelleTache() {
		return libelleTache;
	}

	public void setLibelleTache(String libelleTache) {
		this.libelleTache = libelleTache;
	}
	public Date getDateAnnulationTache() {
		return dateAnnulationTache;
	}
	public void setDateAnnulationTache(Date dateAnnulationTache) {
		this.dateAnnulationTache = dateAnnulationTache;
	}
	public Date getDateDebutTache() {
		return dateDebutTache;
	}

	public void setDateDebutTache(Date dateDebutTache2) {
		this.dateDebutTache = dateDebutTache2;
	}

	public Date getDateFinTache() {
		return dateFinTache;
	}

	public void setDateFinTache(Date dateFinTache) {
		this.dateFinTache = dateFinTache;
	}

	public int getNbAdherentRequis() {
		return nbAdherentRequis;
	}

	public void setNbAdherentRequis(int nbAdherentRequis) {
		this.nbAdherentRequis = nbAdherentRequis;
	}

	public MotifTache getMotifAnnulation() {
		return motifAnnulation;
	}

	public void setMotifAnnulation(MotifTache motifAnnulation) {
		this.motifAnnulation = motifAnnulation;
	}

	public Parcelle getParcelle() {
		return parcelle;
	}

	public void setParcelle(Parcelle parcelle) {
		this.parcelle = parcelle;
	}

	public Actions getAction() {
		return action;
	}

	public void setAction(Actions action) {
		this.action = action;
	}


	public Plante getPlante() {
		return plante;
	}

	public void setPlante(Plante plante) {
		this.plante = plante;
	}

	public MotifTache getMotifReport() {
		return motifReport;
	}

	public void setMotifReport(MotifTache motifReport) {
		this.motifReport = motifReport;
	}

	public List<VolontariatAdherent> getVolontariatAdherent() {
		return volontariatAdherent;
	}



	public void setVolontariatAdherent(List<VolontariatAdherent> volontariatAdherent) {
		this.volontariatAdherent = volontariatAdherent;
	}



	public Competence getCompetence() {
		return competence;
	}

	public void setCompetence(Competence competence) {
		this.competence = competence;
	}
	public List<OutilTache> getOutilTache() {
		return outilTache;
	}
	public void setOutilTache(List<OutilTache> outilTache) {
		this.outilTache = outilTache;
	}



	public List<AffectationAdherent> getAffectationsAdherents() {
		return affectationsAdherents;
	}



	public void setAffectationsAdherents(List<AffectationAdherent> affectationsAdherents) {
		this.affectationsAdherents = affectationsAdherents;
	}



	public Tache getTachePere() {
		return tachePere;
	}



	public void setTachePere(Tache tachePere) {
		this.tachePere = tachePere;
	}
	public List<Tache> getTachesFilles() {
		return tachesFilles;
	}
	public void setTachesFilles(List<Tache> tachesFilles) {
		this.tachesFilles = tachesFilles;
	}





	
}//end Tache