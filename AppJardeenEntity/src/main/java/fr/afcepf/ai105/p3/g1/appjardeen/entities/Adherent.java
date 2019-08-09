package fr.afcepf.ai105.p3.g1.appjardeen.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @created 25-mai-2019 17:32:28
 */
@Entity
@Table(name="adherent")
public class Adherent implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_adherent")
	private int idAdherent;
	
	@Column(name = "nom_naissance")
	private String nomNaissance;
	
	@Column(name="nom_usage")
	private String nomUsage;
	
	private String prenom;
	
	@Column(name="date_de_naissance")
	private Date dateDeNaissance;
	
	private String email;
	private String telephone;
	
	@Column(name="date_enregistrement")
	private Date dateEnregistrement;
	
	private String login;
	private String password;
	
	@OneToMany(mappedBy = "adherent")
	private Set<Inscription> inscriptions;
	
	@OneToMany(mappedBy = "adherent")
	private Set<AffectationAdherent> tachesAffectes;
	
	@OneToMany(mappedBy = "adherent")
	private Set<Indisponibilite> indisponibilites;
	@OneToMany(mappedBy = "adherent")
	private Set<Desinscription> desinscriptions;
	
	@OneToMany(mappedBy = "adherent")
	private Set<VolontariatAdherent> volontairiatAdherent;

	@OneToMany(mappedBy = "adherent")
	private Set<AdherentTerrain> terrainAdherent;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_adresse")
	private Adresse adresse;
	@ManyToOne
	@JoinColumn(name = "id_role")
	private Role role;
	@ManyToOne
	@JoinColumn(name = "id_sexe")
	private Sexe sexe;
	
	@ManyToOne
	@JoinColumn(name = "id_competence") 
	private Competence competence;
	

	public Adherent(){

	}

	
	public Adherent(String nomNaissance, String nomUsage, String prenom, Date dateDeNaissance, String email,
			String telephone, Date dateEnregistrement, String login, String password, Adresse adresse, Role role,
			Sexe sexe, Competence competence) {
		super();
		this.nomNaissance = nomNaissance;
		this.nomUsage = nomUsage;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.email = email;
		this.telephone = telephone;
		this.dateEnregistrement = dateEnregistrement;
		this.login = login;
		this.password = password;
		this.adresse = adresse;
		this.role = role;
		this.sexe = sexe;
		this.competence = competence;
	}
	
	



	public Adherent(int idAdherent, String nomNaissance, String nomUsage, String prenom, Date dateDeNaissance,
			String email, String telephone, Date dateEnregistrement, String login, String password,
			Set<Inscription> inscriptions, Set<AffectationAdherent> tachesAffectes,
			Set<Indisponibilite> indisponibilites, Set<Desinscription> desinscriptions,
			Set<VolontariatAdherent> volontairiatAdherent, Adresse adresse, Role role, Sexe sexe,
			Competence competence) {
		super();
		this.idAdherent = idAdherent;
		this.nomNaissance = nomNaissance;
		this.nomUsage = nomUsage;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.email = email;
		this.telephone = telephone;
		this.dateEnregistrement = dateEnregistrement;
		this.login = login;
		this.password = password;
		this.inscriptions = inscriptions;
		this.tachesAffectes = tachesAffectes;
		this.indisponibilites = indisponibilites;
		this.desinscriptions = desinscriptions;
		this.volontairiatAdherent = volontairiatAdherent;
		this.adresse = adresse;
		this.role = role;
		this.sexe = sexe;
		this.competence = competence;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idAdherent);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Adherent)) {
			return false;
		}
		Adherent other = (Adherent) obj;
		return idAdherent == other.idAdherent;
	}
	

	public int getIdAdherent() {
		return idAdherent;
	}

	public void setIdAdherent(int idAdherent) {
		this.idAdherent = idAdherent;
	}

	public String getNomNaissance() {
		return nomNaissance;
	}

	public void setNomNaissance(String nomNaissance) {
		this.nomNaissance = nomNaissance;
	}

	public String getNomUsage() {
		return nomUsage;
	}

	public void setNomUsage(String nomUsage) {
		this.nomUsage = nomUsage;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getDateEnregistrement() {
		return dateEnregistrement;
	}

	public void setDateEnregistrement(Date dateEnregistrement) {
		this.dateEnregistrement = dateEnregistrement;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Inscription> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(Set<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	public Sexe getSexe() {
		return sexe;
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}

	public Set<Indisponibilite> getIndisponibilites() {
		return indisponibilites;
	}

	public void setIndisponibilites(Set<Indisponibilite> indisponibilites) {
		this.indisponibilites = indisponibilites;
	}

	public Set<Desinscription> getDesinscriptions() {
		return desinscriptions;
	}

	public void setDesinscriptions(Set<Desinscription> desinscriptions) {
		this.desinscriptions = desinscriptions;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}



	public Competence getCompetence() {
		return competence;
	}


	public void setCompetence(Competence competence) {
		this.competence = competence;
	}

	public Set<VolontariatAdherent> getVolontairiatAdherent() {
		return volontairiatAdherent;
	}


	public void setVolontairiatAdherent(Set<VolontariatAdherent> volontairiatAdherent) {
		this.volontairiatAdherent = volontairiatAdherent;
	}


	public Set<AffectationAdherent> getTachesAffectes() {
		return tachesAffectes;
	}

	public void setTachesAffectes(Set<AffectationAdherent> tachesAffectes) {
		this.tachesAffectes = tachesAffectes;
	}


	public Set<AdherentTerrain> getTerrainAdherent() {
		return terrainAdherent;
	}


	public void setTerrainAdherent(Set<AdherentTerrain> terrainAdherent) {
		this.terrainAdherent = terrainAdherent;
	}

	

}//end Adherent