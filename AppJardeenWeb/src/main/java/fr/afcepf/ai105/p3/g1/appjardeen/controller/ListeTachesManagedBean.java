package fr.afcepf.ai105.p3.g1.appjardeen.controller;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
//import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.ai105.p3.g1.appjardeen.business.AffectationAdherentBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.TacheBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.VolontariatAdherentBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Tache;

@ManagedBean(name = "mbListeTaches") 
@SessionScoped
public class ListeTachesManagedBean implements Serializable{

	
	private static final long serialVersionUID = 1L;

	private List<Tache> taches;
	private String affichage = "fa-heart";
	private String affichageCoeurPlein = "lg";
	private String affichageCoeurVide = "lg";

	
//	@ManagedProperty(value = "#{mbPlanningAdherent.tachesVolontariat}")
	private List<Tache> tachesVonlontariat;
//	@ManagedProperty(value = "#{mbPlanningAdherent.taches}")
	private List<Tache> tachesAffectees;
	
	private Set<Tache> tachesAffecteesDansCeBean = new HashSet<>();
	
	@ManagedProperty(value = "#{mbConnect.adherent}")
	private Adherent adherent;
	
	private Tache selectedTache;
	private Tache tacheAEditer;
	
	@EJB
	TacheBusiness proxyTaches;
	@EJB
	VolontariatAdherentBusiness proxyVonlontariat;
	 @EJB
	private AffectationAdherentBusiness proxyAffectAdherent;
	
	@EJB
	private VolontariatAdherentBusiness proxyVolontariat;
	
	private String titrePlante;
	
	@PostConstruct
	public void init() {
		//REDA
		tachesVonlontariat = proxyVolontariat.obtenirTacheVolontariatByAdherent(adherent.getIdAdherent());
		tachesAffectees = proxyAffectAdherent.obtenirTacheAffectByIdAdherent(adherent.getIdAdherent());

		
		
			taches = proxyTaches.obtenirLesTachesPlanifees();
			tacheAEditer = new Tache();
			for (Tache t : tachesAffectees) {
				tachesAffecteesDansCeBean.add(t);
			}
			for (Tache t : tachesVonlontariat) {
				tachesAffecteesDansCeBean.add(t);
			}
	}

	public String masquerButton(Tache tache) {
			
			if(tachesAffecteesDansCeBean.contains(tache)) {
				affichage="fa-heart";
			}else {
				affichage ="fa-heart-o";
			}
		return affichage;
	}

	public void sePorterVolontaire(Tache tache) {
		selectedTache = tache;
		proxyVonlontariat.insertVolontariat(adherent, selectedTache);
		if(tachesAffecteesDansCeBean.contains(tache)) {
			tachesAffecteesDansCeBean.remove(tache);
		} else {
			
			tachesAffecteesDansCeBean.add(tache);
		}	
	}
	
	public String editerTache(Tache tache) {
		tacheAEditer = tache;
		System.out.println("------------------------" + tacheAEditer.getLibelleTache() + "-----------------------");
		System.out.println("------------------------" + tacheAEditer.getIdTache() + "-----------------------");
		return "editerTache.xhtml?faces-redirect=true";
	}
	
	public List<Tache> getTaches() {
		return taches;
	}


	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}


	public Adherent getAdherent() {
		return adherent;
	}


	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}


	public Tache getSelectedTache() {
		return selectedTache;
	}


	public void setSelectedTache(Tache selectedTache) {
		this.selectedTache = selectedTache;
	}


	public String getAffichage() {
		return affichage;
	}


	public void setAffichage(String affichage) {
		this.affichage = affichage;
	}


	public List<Tache> getTachesVonlontariat() {
		return tachesVonlontariat;
	}


	public void setTachesVonlontariat(List<Tache> tachesVonlontariat) {
		this.tachesVonlontariat = tachesVonlontariat;
	}


	public List<Tache> getTachesAffectees() {
		return tachesAffectees;
	}


	public void setTachesAffectees(List<Tache> tachesAffectees) {
		this.tachesAffectees = tachesAffectees;
	}

	public String getTitrePlante() {
		return titrePlante;
	}

	public void setTitrePlante(String titrePlante) {
		this.titrePlante = titrePlante;
	}

	public String getAffichageCoeurPlein() {
		return affichageCoeurPlein;
	}

	public void setAffichageCoeurPlein(String affichageCoeurPlein) {
		this.affichageCoeurPlein = affichageCoeurPlein;
	}

	public String getAffichageCoeurVide() {
		return affichageCoeurVide;
	}

	public void setAffichageCoeurVide(String affichageCoeurVide) {
		this.affichageCoeurVide = affichageCoeurVide;
	}

	public Set<Tache> getTachesAffecteesDansCeBean() {
		return tachesAffecteesDansCeBean;
	}

	public void setTachesAffecteesDansCeBean(Set<Tache> tachesAffecteesDansCeBean) {
		this.tachesAffecteesDansCeBean = tachesAffecteesDansCeBean;
	}

	public Tache getTacheAEditer() {
		return tacheAEditer;
	}

	public void setTacheAEditer(Tache tacheAEditer) {
		this.tacheAEditer = tacheAEditer;
	}
	
	
	
}
