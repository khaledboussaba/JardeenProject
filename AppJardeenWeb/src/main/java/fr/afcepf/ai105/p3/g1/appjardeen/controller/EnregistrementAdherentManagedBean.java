package fr.afcepf.ai105.p3.g1.appjardeen.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import fr.afcepf.ai105.p3.g1.appjardeen.business.CompteBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.SexeBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.VilleBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adresse;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Competence;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Role;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Sexe;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Ville;

@ManagedBean(name = "mbRegister")
public class EnregistrementAdherentManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Adherent adherent = new Adherent();
	private List<Sexe> sexes;
	private List<Ville> villes;
	private Ville villeSelected = new Ville();
	private Adresse adresse= new Adresse();
	private int idSexe ;

	
	@EJB
	private CompteBusiness proxyCompteBusiness;
	
	@EJB
	private SexeBusiness proxySexeBusiness;
	
	@EJB
	private VilleBusiness proxyVilleBusiness;
	
	@PostConstruct
    public void init() {
        adherent = new Adherent();
        sexes = proxySexeBusiness.getAll();
        villes = proxyVilleBusiness.obtenirToutesLesVilles();
    }
	
	public String registerAdherent() {
		adherent.setSexe(sexes.get(idSexe));
		adherent.setDateEnregistrement(new Date());
		adresse.setVille(villeSelected);
		adherent.setAdresse(adresse);
		adherent.setLogin(adherent.getPrenom().toLowerCase());
		adherent.setPassword(adherent.getPrenom().toLowerCase() + adherent.getNomNaissance().toUpperCase());
		Role role = new Role();
		role.setIdRole(3);
		Competence competence = new Competence();
		competence.setIdCompetence(1);
		adherent.setCompetence(competence);
		adherent.setRole(role);
		adherent = proxyCompteBusiness.registerAdherent(adherent);
		return "/accueilVisiteur.xhtml?faces-redirect=true";
	}

	
	public String validerInscription() {
		
		return "/identification.xhtml?faces-redirect=true";
	}

	public Adherent getAdherent() {
		return adherent;
	}


	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}
	
	public List<Sexe> getSexes() {
		return sexes;
	}
	
	public void setSexes(List<Sexe> sexes) {
		this.sexes = sexes;
	}

	public int getIdSexe() {
		return idSexe;
	}

	public void setIdSexe(int idSexe) {
		this.idSexe = idSexe;
	}

	public List<Ville> getVilles() {
		return villes;
	}

	public void setVilles(List<Ville> villes) {
		this.villes = villes;
	}

	public Ville getVilleSelected() {
		return villeSelected;
	}

	public void setVilleSelected(Ville villeSelected) {
		this.villeSelected = villeSelected;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}
