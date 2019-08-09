package fr.afcepf.ai105.p3.g1.appjardeen.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.ai105.p3.g1.appjardeen.business.AdherentBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.CompetenceBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.RoleBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.SexeBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Acidite;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Competence;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Role;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Sexe;


@ManagedBean(name = "mbEditInfoAdherent")
@SessionScoped
public class FormulaireMajAdherent {

	private List<Competence> competences = new ArrayList<>();
	private List<Sexe> civilites = new ArrayList<>();
	private List<Role> roles = new ArrayList<>();
	private String nom;
	private String prenom;
	private String email;
	private String login;
	private String motDpasse;
	private String telephone;
	private Sexe sexe;
	private Date dateNaissance;
	private Competence competence;
	
	@ManagedProperty(value = "#{mbConnect.adherent}")
	private Adherent adherent; 
	
	
	
	
	@EJB
	AdherentBusiness proxyAdherent;
	
	@EJB
	CompetenceBusiness proxyCompetence;
	
	@EJB
	SexeBusiness proxySexe;
	
	RoleBusiness proxyRole;

	@PostConstruct
	public void init() {
		
		competences = proxyCompetence.listerCompetences();
		civilites = proxySexe.getAll();
			
	}
	
	public String mAjInfoAdherent() {
		login = adherent.getLogin();
		motDpasse = adherent.getPassword();
		email = adherent.getEmail();
		nom = adherent.getNomNaissance();
		telephone = adherent.getTelephone();
		prenom = adherent.getPrenom();
		for (Sexe seXe : civilites) {
			if(adherent.getSexe().getLibelleSexe()==seXe.getLibelleSexe()) {
				sexe = seXe;
			}
		}
		for (Competence comp : competences) {
			if(adherent.getCompetence().getLibelleCompetence()==comp.getLibelleCompetence()) {
				competence = comp;
			}
		}
	
		
		dateNaissance = adherent.getDateDeNaissance();
		proxyAdherent.modifierInfoAdherent(adherent, login, motDpasse, email, telephone, nom, prenom, dateNaissance, competence, sexe);
		
		return "/pageAdherent.xhtml?faces-redirect=true";
	}
	
	
	
	public List<Competence> getCompetences() {
		return competences;
	}

	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}



	public List<Sexe> getCivilites() {
		return civilites;
	}



	public void setCivilites(List<Sexe> civilites) {
		this.civilites = civilites;
	}

	public Adherent getAdherent() {
		return adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDpasse() {
		return motDpasse;
	}

	public void setMotDpasse(String motDpasse) {
		this.motDpasse = motDpasse;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
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

	public Sexe getSexe() {
		return sexe;
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Competence getCompetence() {
		return competence;
	}

	public void setCompetence(Competence competence) {
		this.competence = competence;
	}
	
	
	
	
}
