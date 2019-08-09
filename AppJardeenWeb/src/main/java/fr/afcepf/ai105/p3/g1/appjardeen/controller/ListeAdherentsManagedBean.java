package fr.afcepf.ai105.p3.g1.appjardeen.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import fr.afcepf.ai105.p3.g1.appjardeen.business.AdherentBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.DesinscriptionBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.InscriptionBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.MotifDesinscriptionBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Desinscription;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Inscription;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.MotifDesinscription;

@ManagedBean(name = "mbListeAdherents")
@ViewScoped
public class ListeAdherentsManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Adherent> adherents;
	private Adherent adherentSelected;

	private List<Adherent> listeAdherentsDesinscritOuInscriptionMaxPerimee;
	private List<Adherent> listeAdherentsDesinscrit;
	private List<Adherent> listeAdherentsEnregistresNonInscrit;
	private List<Adherent> listeAdherentsInscriptionArrivantAEcheance;
	private List<Adherent> listeTabAdherentEnAttenteInscriptionEtInscriptionArrivantATerme = new ArrayList<>();
	private List<MotifDesinscription> motifs;
	private MotifDesinscription motifSelected;
	private String affichageDdlMotifDesinscription ="lg"; //Par defaut lg => c'est caché 
	private String affichageBtnAfficherDesinscrireAdherent ="xs"; //Par defaut lg => c'est pas caché 
	private String affichageBtnDesinscrireAdherent ="lg"; //Par defaut lg => c'est caché 
	
	
	@EJB
	AdherentBusiness proxyAdherentBusiness;
	@EJB
	MotifDesinscriptionBusiness proxyMotifDesincription;
	@EJB
	DesinscriptionBusiness proxyDesinscriptionBusiness;
	@EJB
	InscriptionBusiness proxyInscriptionBusines;
	
	@PostConstruct
    public void init() {
		adherents = proxyAdherentBusiness.listerAdherentsInscrit();	
		listeAdherentsDesinscritOuInscriptionMaxPerimee = proxyAdherentBusiness.listerAdherentsDesinscrit(); 
		listeAdherentsEnregistresNonInscrit = proxyAdherentBusiness.listerAdherentsAInscrire();
		motifs = proxyMotifDesincription.obtenirTousLesMotifsDesinscription();
		listeAdherentsDesinscrit = proxyDesinscriptionBusiness.obtenirListeAdherentsDesinscrit();
		listeAdherentsInscriptionArrivantAEcheance=proxyInscriptionBusines.obtenirListeAdherentsInscriptionArrivantAEcheance();
		
		listeTabAdherentEnAttenteInscriptionEtInscriptionArrivantATerme = new ArrayList<>();
		for (Adherent adherent : listeAdherentsEnregistresNonInscrit) {
			listeTabAdherentEnAttenteInscriptionEtInscriptionArrivantATerme.add(adherent);
		}
		for (Adherent adherent : listeAdherentsInscriptionArrivantAEcheance) {
			listeTabAdherentEnAttenteInscriptionEtInscriptionArrivantATerme.add(adherent);
		}
	}
	
	public String afficherFicheAdherent() {
		return "pageAdherent.xhtml?faces-redirect=true";
	}
	
	public String getPhoto(Adherent a) {
		String photo="";
		if(a.getSexe().getIdSexe()==1) {
			photo ="user-male";
		}else {
			photo ="user-female";
		}
		return photo;
	}
	
	public void inscrireAdherent(Adherent adherent) {
		List<Desinscription> desinscriptions = proxyDesinscriptionBusiness.obtenirDesinscriptionsByAdherent(adherent);
		for (Desinscription desinscription : desinscriptions) {
			proxyDesinscriptionBusiness.retirerDesinscription(desinscription);
		}
		Inscription inscription = new Inscription();
		inscription.setAdherent(adherent);
		inscription.setDateInscription(new Date());
		proxyInscriptionBusines.ajouterUneInscription(inscription);
		
		//adherents = proxyAdherentBusiness.listerAdherentsInscrit();	
		//listeAdherentsDesinscritOuInscriptionMaxPerimee = proxyAdherentBusiness.listerAdherentsDesinscrit(); 
		//listeAdherentsEnregistresNonInscrit = proxyAdherentBusiness.listerAdherentsAInscrire();
		init();
	}
	
	public String couleurEtatAdherent(Adherent adherent){
		String returned="";
		 	if(listeAdherentsDesinscrit.contains(adherent)) {
		 		returned="red";
		 	}else if(listeAdherentsEnregistresNonInscrit.contains(adherent)) {
		 		returned="green";
		 	}else if(listeAdherentsInscriptionArrivantAEcheance.contains(adherent)) {
		 		returned="yellow";
		 	}else {
		 		returned="orange";
		 	}
		return returned;	
	}
	
	public String etatAdherent(Adherent adherent){
		String returned="";

	 	if(listeAdherentsDesinscrit.contains(adherent)) {
	 		returned="desinscrit";
	 	}else if(listeAdherentsEnregistresNonInscrit.contains(adherent)) {
	 		returned="en attente d'inscription";
	 	}else if(listeAdherentsInscriptionArrivantAEcheance.contains(adherent)) {
	 		returned="inscription arrivant a échéance";
	 	}else {
	 		returned="fin inscription";
	 	}
		return returned;	
	}
	
	
	public void desinscrireAdherent(Adherent adherent) {
		Desinscription desinscription = new Desinscription();
		desinscription.setAdherent(adherent);
		
		desinscription.setMotifDesinscription(motifSelected);
		desinscription.setDateDesinscription(new Date());
		desinscription = proxyDesinscriptionBusiness.enregistrerDesinscription(desinscription);
		//adherents = proxyAdherentBusiness.listerAdherentsInscrit();	
				
		//listeAdherentsDesinscritOuInscriptionMaxPerimee = proxyAdherentBusiness.listerAdherentsDesinscrit(); 
		//listeAdherentsEnregistresNonInscrit = proxyAdherentBusiness.listerAdherentsAInscrire();
		//listeAdherentsDesinscrit = proxyDesinscriptionBusiness.obtenirListeAdherentsDesinscrit();
		init();

		afficherMotifDesinscription();
	}
	
	
	public void afficherMotifDesinscription() {
		affichageDdlMotifDesinscription= (affichageDdlMotifDesinscription == "xs") ? "lg":"xs";
		affichageBtnAfficherDesinscrireAdherent= (affichageBtnAfficherDesinscrireAdherent == "xs") ? "lg":"xs";
		affichageBtnDesinscrireAdherent= (affichageBtnDesinscrireAdherent == "xs") ? "lg":"xs";

	}
	
	public String obtenirDerniereDateInscription(Adherent adherent) {
		String date = proxyInscriptionBusines.obtenirDerniereDateInscription(adherent);
		return date;
	}
	public int getIdCompetence(Adherent a) {
		return a.getCompetence().getIdCompetence();
	}
	public List<Adherent> getAdherents() {
		return adherents;
	}
	public void setAdherent(List<Adherent> adherents) {
		this.adherents = adherents;
	}
	public Adherent getAdherentSelected() {
		return adherentSelected;
	}
	
	public void setAdherentSelected(Adherent adherentSelected) {
		this.adherentSelected = adherentSelected;
	}

	public List<Adherent> getAdherentsEnAttenteInscription() {
		return listeAdherentsEnregistresNonInscrit;
	}

	public List<MotifDesinscription> getMotifs() {
		return motifs;
	}

	public void setMotifs(List<MotifDesinscription> motifs) {
		this.motifs = motifs;
	}

	public MotifDesinscription getMotifSelected() {
		return motifSelected;
	}

	public void setMotifSelected(MotifDesinscription motifSelected) {
		this.motifSelected = motifSelected;
	}

	public String getAffichageDdlMotifDesinscription() {
		return affichageDdlMotifDesinscription;
	}

	public void setAffichageDdlMotifDesinscription(String affichageDdlMotifDesinscription) {
		this.affichageDdlMotifDesinscription = affichageDdlMotifDesinscription;
	}

	public void setAdherents(List<Adherent> adherents) {
		this.adherents = adherents;
	}


	public void setAdherentsEnAttenteInscription(List<Adherent> adherentsEnAttenteInscription) {
		this.listeAdherentsEnregistresNonInscrit = adherentsEnAttenteInscription;
	}

	public String getAffichageBtnAfficherDesinscrireAdherent() {
		return affichageBtnAfficherDesinscrireAdherent;
	}

	public void setAffichageBtnAfficherDesinscrireAdherent(String affichageBtnAfficherDesinscrireAdherent) {
		this.affichageBtnAfficherDesinscrireAdherent = affichageBtnAfficherDesinscrireAdherent;
	}

	public String getAffichageBtnDesinscrireAdherent() {
		return affichageBtnDesinscrireAdherent;
	}

	public void setAffichageBtnDesinscrireAdherent(String affichageBtnDesinscrireAdherent) {
		this.affichageBtnDesinscrireAdherent = affichageBtnDesinscrireAdherent;
	}

	public List<Adherent> getListeAdherentsDesinscritOuInscriptionMaxPerimee() {
		return listeAdherentsDesinscritOuInscriptionMaxPerimee;
	}

	public void setListeAdherentsDesinscritOuInscriptionMaxPerimee(
			List<Adherent> listeAdherentsDesinscritOuInscriptionMaxPerimee) {
		this.listeAdherentsDesinscritOuInscriptionMaxPerimee = listeAdherentsDesinscritOuInscriptionMaxPerimee;
	}

	public List<Adherent> getListeAdherentsDesinscrit() {
		return listeAdherentsDesinscrit;
	}

	public void setListeAdherentsDesinscrit(List<Adherent> listeAdherentsDesinscrit) {
		this.listeAdherentsDesinscrit = listeAdherentsDesinscrit;
	}

	public List<Adherent> getListeAdherentsEnregistresNonInscrit() {
		return listeAdherentsEnregistresNonInscrit;
	}

	public void setListeAdherentsEnregistresNonInscrit(List<Adherent> listeAdherentsEnregistresNonInscrit) {
		this.listeAdherentsEnregistresNonInscrit = listeAdherentsEnregistresNonInscrit;
	}

	public List<Adherent> getListeAdherentsInscriptionArrivantAEcheance() {
		return listeAdherentsInscriptionArrivantAEcheance;
	}

	public void setListeAdherentsInscriptionArrivantAEcheance(List<Adherent> listeAdherentsInscriptionArrivantAEcheance) {
		this.listeAdherentsInscriptionArrivantAEcheance = listeAdherentsInscriptionArrivantAEcheance;
	}

	public List<Adherent> getListeTabAdherentEnAttenteInscriptionEtInscriptionArrivantATerme() {
		return listeTabAdherentEnAttenteInscriptionEtInscriptionArrivantATerme;
	}

	public void setListeTabAdherentEnAttenteInscriptionEtInscriptionArrivantATerme(
			List<Adherent> listeTabAdherentEnAttenteInscriptionEtInscriptionArrivantATerme) {
		this.listeTabAdherentEnAttenteInscriptionEtInscriptionArrivantATerme = listeTabAdherentEnAttenteInscriptionEtInscriptionArrivantATerme;
	}
	
}
