package fr.afcepf.ai105.p3.g1.appjardeen.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;

import fr.afcepf.ai105.p3.g1.appjardeen.business.ActionsBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.ActionsPlanteBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.AdherentBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.AffectationAdherentBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.CompetenceBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.Convertisseur;
import fr.afcepf.ai105.p3.g1.appjardeen.business.OutilBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.OutilTacheBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.ParcelleBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.PlanteBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.TacheBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.TerrainBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Actions;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.AffectationAdherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Competence;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Outil;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Parcelle;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Plante;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Tache;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Terrain;

@ManagedBean (name = "mbEditerTache")
@ViewScoped
public class EditerTacheManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<Outil> outilsDisponibles = new ArrayList<>();
	private List<Outil> outilsAffectes = new ArrayList<>();
	private List<Outil> quantitesOutilsUtilises = new ArrayList<>();
	private List<String> indexOutilsDisponibles = new ArrayList<>();
	private List<String> indexOutilsAffectes = new ArrayList<>();
	private List<Competence> competences = new ArrayList<>();
	private List<Adherent> adherentsDisponibles = new ArrayList<>();
	private List<Adherent> adherentsAffectes = new ArrayList<>();
	private List<String> indexAdherentsDisponibles = new ArrayList<>();
	private List<String> indexAdherentsAffectes = new ArrayList<>();
	private List<AffectationAdherent> affectationsAdherents = new ArrayList<>();
	private UIComponent libelleTache;
	private Terrain terrainChoisi;
	private Parcelle parcelleChoisie;
	private Plante planteChoisie;
	private Actions actionChoisie;
	private Competence competenceRequise;
	private String nbJardiniersChoisi;
	private UIComponent dateComponent;
	private Date dateHeureDebut;
	private Date dateHeureFin;
	private String heureDebutTache = "7";
	private String heureFinTache = "19";
	private String affichageFormulaire = "xs"; // xs: caché caché pour toutes les tailles en dessous d'une fenêtre extra small, donc visible.
	private String affichageTableauxAdherents = "lg"; // lg : caché pour toutes les tailles en dessous d'une fenêtre plein, donc caché.
	private String affichageTableauxOutils = "lg";
	
	@EJB
	private PlanteBusiness proxyPlanteBusiness;
	@EJB
	private ActionsBusiness proxyActionsBusiness;
	@EJB
	private CompetenceBusiness proxyCompetenceBusiness;
	@EJB
	private AdherentBusiness proxyAdherentBusiness;
	@EJB
	private Convertisseur proxyConvertisseur;
	@EJB
	private TacheBusiness proxyTacheBusiness;
	@EJB
	private OutilTacheBusiness proxyOutilTacheBusiness;
	@EJB
	private AffectationAdherentBusiness proxyAffectationAdherentBusiness;
	@EJB
	private OutilBusiness proxyOutilBusiness;
	@EJB
	private ParcelleBusiness proxyParcelleBusiness;
	@EJB
	private ActionsPlanteBusiness proxyActionsPlanteBusiness;
	@EJB
	private TerrainBusiness proxyTerrainBusiness;
	
	@ManagedProperty(value ="#{mbListeTaches.tacheAEditer}")
	private Tache tacheAediter;
	
	@PostConstruct
	public void init() {
		System.out.println("----------------------" + tacheAediter + "-----------------------");
		terrainChoisi = tacheAediter.getParcelle().getTerrain();
		parcelleChoisie = tacheAediter.getParcelle();
		planteChoisie = tacheAediter.getPlante();
		actionChoisie = tacheAediter.getAction();
		competenceRequise = tacheAediter.getCompetence();
		nbJardiniersChoisi = Integer.toString(tacheAediter.getNbAdherentRequis());
		competences = proxyCompetenceBusiness.listerCompetences();
	}
	
	public void passerAuxOutils() {
		affichageFormulaire = "lg";
		affichageTableauxAdherents = "lg";
		affichageTableauxOutils = "xs";
	}
	
	public void retourFormulaire() {
		affichageFormulaire = "xs";
		affichageTableauxAdherents = "lg";
		affichageTableauxOutils = "lg";
	}
	
	public void retourAdherents() {
		affichageFormulaire = "lg";
		affichageTableauxAdherents = "xs";
		affichageTableauxOutils = "lg";
	}
	
	public void listerDisponibles() {
		affichageFormulaire = "lg";
		affichageTableauxAdherents = "xs";
		affichageTableauxOutils = "lg";
		adherentsAffectes.clear();
		outilsAffectes.clear();
		quantitesOutilsUtilises.clear();
		dateHeureDebut = ConvertirDate(heureDebutTache);
		dateHeureFin = ConvertirDate(heureFinTache);
		int niveauCompetence = competenceRequise.getIdCompetence();
		adherentsDisponibles = proxyAdherentBusiness.listerAdherentsDisponiblesEtCompetents(dateHeureDebut, dateHeureFin, niveauCompetence);
		outilsAffectes = proxyOutilBusiness.listerOutilsDisponiblesRecommandes(dateHeureDebut, dateHeureFin, actionChoisie);
		outilsDisponibles = proxyOutilBusiness.listerOutilsDisponibles(dateHeureDebut, dateHeureFin, outilsAffectes);
		for (int i = 0; i < outilsAffectes.size(); i++) {
			Outil outilAlloue = new Outil(outilsAffectes.get(i).getIdOutil(), outilsAffectes.get(i).getQuantiteOutilTotale(), 0);
			quantitesOutilsUtilises.add(outilAlloue);
		}
	}
	
	public Date ConvertirDate(String heure) {
		String chaineDate = dateComponent.getAttributes().get("value").toString();
		Date dateConvertie = proxyConvertisseur.ConversionDate(chaineDate, heure);
		return dateConvertie;
	}

	public void selectionnerAdherentDisponible(String index) {
		indexAdherentsDisponibles.add(index);
	}
	
	public void selectionnerAdherentAffecte(String index) {
		indexAdherentsAffectes.add(index);
	}
	
	public void deselectionnerAdherentDisponible(String index) {
		indexAdherentsDisponibles.remove(index);
	}
	
	public void deselectionnerAdherentAffecte(String index) {
		indexAdherentsAffectes.remove(index);
	}
	
	public void validerSelectionDisponibles() {
		List<Adherent> adherentsARetirer = new ArrayList<>();
		for (int i = 0; i < indexAdherentsDisponibles.size(); i++) {
			adherentsARetirer.add(adherentsDisponibles.get(Integer.parseInt(indexAdherentsDisponibles.get(i))));
		}
		for (int i = 0; i < adherentsARetirer.size(); i++) {
			adherentsDisponibles.remove(adherentsARetirer.get(i));
			adherentsAffectes.add(adherentsARetirer.get(i));
		}
		indexAdherentsDisponibles.clear();
	}
		
	public void validerSelectionAffectes() {
		
		List<Adherent> adherentsARetirer = new ArrayList<>();
		for (int i = 0; i < indexAdherentsAffectes.size(); i++) {
			adherentsARetirer.add(adherentsAffectes.get(Integer.parseInt(indexAdherentsAffectes.get(i))));
		}
		for (int i = 0; i < adherentsARetirer.size(); i++) {
			adherentsAffectes.remove(adherentsARetirer.get(i));
			adherentsDisponibles.add(adherentsARetirer.get(i));
		}
		indexAdherentsAffectes.clear();
	}
	
	public void selectionnerOutilDisponible(String index) {
		indexOutilsDisponibles.add(index);
	}
	
	public void selectionnerOutilAffecte(String index) {
		indexOutilsAffectes.add(index);
	}
	
	public void deselectionnerOutilDisponible(String index) {
		indexOutilsDisponibles.remove(index);
	}
	
	public void deselectionnerOutilAffecte(String index) {
		indexOutilsAffectes.remove(index);
	}
	
	public void validerSelectionOutilsDisponibles() {
		List<Outil> outilsARetirer = new ArrayList<>();
		for (int i = 0; i < indexOutilsDisponibles.size(); i++) {
			outilsARetirer.add(outilsDisponibles.get(Integer.parseInt(indexOutilsDisponibles.get(i))));
		}
		for (int i = 0; i < outilsARetirer.size(); i++) {
			outilsDisponibles.remove(outilsARetirer.get(i));
			outilsAffectes.add(outilsARetirer.get(i));
		}
		for (int i = 0; i < outilsAffectes.size(); i++) {
			Outil outilAlloue = new Outil(outilsAffectes.get(i).getIdOutil(), outilsAffectes.get(i).getQuantiteOutilTotale(), 0);
			if (!quantitesOutilsUtilises.contains(outilAlloue)) {
				quantitesOutilsUtilises.add(outilAlloue);
			}
		}
		indexOutilsDisponibles.clear();
	}
		
	public void validerSelectionOutilsAffectes() {
		List<Outil> outilsARetirer = new ArrayList<>();
		for (int i = 0; i < indexOutilsAffectes.size(); i++) {
			outilsARetirer.add(outilsAffectes.get(Integer.parseInt(indexOutilsAffectes.get(i))));
		}
		for (int i = 0; i < outilsARetirer.size(); i++) {
			quantitesOutilsUtilises.remove(outilsAffectes.indexOf(outilsARetirer.get(i)));
			outilsAffectes.remove(outilsARetirer.get(i));
			outilsDisponibles.add(outilsARetirer.get(i));
		}
		indexOutilsAffectes.clear();
	}

	public String editerTache() {
		String[] elementsNb = nbJardiniersChoisi.split("\\.");
		String nb = elementsNb[0];
		int nbJardinier = Integer.parseInt(nb);
		proxyTacheBusiness.editionTache(
			tacheAediter,
			libelleTache.getAttributes().get("value").toString(),
			parcelleChoisie,
			planteChoisie,
			actionChoisie,
			competenceRequise,
			nbJardinier,
			dateHeureDebut,
			dateHeureFin,
			outilsAffectes,
			quantitesOutilsUtilises,
			adherentsAffectes
			);
		return "/planningTaches.xhtml?faces-redirect=true";
	}

	
	public List<Outil> getOutilsDisponibles() {
		return outilsDisponibles;
	}
	public void setOutilsDisponibles(List<Outil> outilsDisponibles) {
		this.outilsDisponibles = outilsDisponibles;
	}
	public List<Outil> getOutilsAffectes() {
		return outilsAffectes;
	}
	public void setOutilsAffectes(List<Outil> outilsAffectes) {
		this.outilsAffectes = outilsAffectes;
	}
	public List<Outil> getQuantitesOutilsUtilises() {
		return quantitesOutilsUtilises;
	}
	public void setQuantitesOutilsUtilises(List<Outil> quantitesOutilsUtilises) {
		this.quantitesOutilsUtilises = quantitesOutilsUtilises;
	}
	public List<String> getIndexOutilsDisponibles() {
		return indexOutilsDisponibles;
	}
	public void setIndexOutilsDisponibles(List<String> indexOutilsDisponibles) {
		this.indexOutilsDisponibles = indexOutilsDisponibles;
	}
	public List<String> getIndexOutilsAffectes() {
		return indexOutilsAffectes;
	}
	public void setIndexOutilsAffectes(List<String> indexOutilsAffectes) {
		this.indexOutilsAffectes = indexOutilsAffectes;
	}
	public List<Competence> getCompetences() {
		return competences;
	}
	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}
	public List<Adherent> getAdherentsDisponibles() {
		return adherentsDisponibles;
	}
	public void setAdherentsDisponibles(List<Adherent> adherentsDisponibles) {
		this.adherentsDisponibles = adherentsDisponibles;
	}
	public List<Adherent> getAdherentsAffectes() {
		return adherentsAffectes;
	}
	public void setAdherentsAffectes(List<Adherent> adherentsAffectes) {
		this.adherentsAffectes = adherentsAffectes;
	}
	public List<String> getIndexAdherentsDisponibles() {
		return indexAdherentsDisponibles;
	}
	public void setIndexAdherentsDisponibles(List<String> indexAdherentsDisponibles) {
		this.indexAdherentsDisponibles = indexAdherentsDisponibles;
	}
	public List<String> getIndexAdherentsAffectes() {
		return indexAdherentsAffectes;
	}
	public void setIndexAdherentsAffectes(List<String> indexAdherentsAffectes) {
		this.indexAdherentsAffectes = indexAdherentsAffectes;
	}
	public List<AffectationAdherent> getAffectationsAdherents() {
		return affectationsAdherents;
	}
	public void setAffectationsAdherents(List<AffectationAdherent> affectationsAdherents) {
		this.affectationsAdherents = affectationsAdherents;
	}
	public UIComponent getLibelleTache() {
		return libelleTache;
	}
	public void setLibelleTache(UIComponent libelleTache) {
		this.libelleTache = libelleTache;
	}
	public Terrain getTerrainChoisi() {
		return terrainChoisi;
	}
	public void setTerrainChoisi(Terrain terrainChoisi) {
		this.terrainChoisi = terrainChoisi;
	}
	public Parcelle getParcelleChoisie() {
		return parcelleChoisie;
	}
	public void setParcelleChoisie(Parcelle parcelleChoisie) {
		this.parcelleChoisie = parcelleChoisie;
	}
	public Plante getPlanteChoisie() {
		return planteChoisie;
	}
	public void setPlanteChoisie(Plante planteChoisie) {
		this.planteChoisie = planteChoisie;
	}
	public Actions getActionChoisie() {
		return actionChoisie;
	}
	public void setActionChoisie(Actions actionChoisie) {
		this.actionChoisie = actionChoisie;
	}
	public Competence getCompetenceRequise() {
		return competenceRequise;
	}
	public void setCompetenceRequise(Competence competenceRequise) {
		this.competenceRequise = competenceRequise;
	}
	public String getNbJardiniersChoisi() {
		return nbJardiniersChoisi;
	}
	public void setNbJardiniersChoisi(String nbJardiniersChoisi) {
		this.nbJardiniersChoisi = nbJardiniersChoisi;
	}
	public UIComponent getDateComponent() {
		return dateComponent;
	}
	public void setDateComponent(UIComponent dateComponent) {
		this.dateComponent = dateComponent;
	}
	public Date getDateHeureDebut() {
		return dateHeureDebut;
	}
	public void setDateHeureDebut(Date dateHeureDebut) {
		this.dateHeureDebut = dateHeureDebut;
	}
	public Date getDateHeureFin() {
		return dateHeureFin;
	}
	public void setDateHeureFin(Date dateHeureFin) {
		this.dateHeureFin = dateHeureFin;
	}
	public String getHeureDebutTache() {
		return heureDebutTache;
	}
	public void setHeureDebutTache(String heureDebutTache) {
		this.heureDebutTache = heureDebutTache;
	}
	public String getHeureFinTache() {
		return heureFinTache;
	}
	public void setHeureFinTache(String heureFinTache) {
		this.heureFinTache = heureFinTache;
	}
	public String getAffichageFormulaire() {
		return affichageFormulaire;
	}
	public void setAffichageFormulaire(String affichageFormulaire) {
		this.affichageFormulaire = affichageFormulaire;
	}
	public String getAffichageTableauxAdherents() {
		return affichageTableauxAdherents;
	}
	public void setAffichageTableauxAdherents(String affichageTableauxAdherents) {
		this.affichageTableauxAdherents = affichageTableauxAdherents;
	}
	public String getAffichageTableauxOutils() {
		return affichageTableauxOutils;
	}
	public void setAffichageTableauxOutils(String affichageTableauxOutils) {
		this.affichageTableauxOutils = affichageTableauxOutils;
	}

	public Tache getTacheAediter() {
		return tacheAediter;
	}

	public void setTacheAediter(Tache tacheAediter) {
		this.tacheAediter = tacheAediter;
	}
	
	
}


//package fr.afcepf.ai105.p3.g1.appjardeen.controller;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.function.Predicate;
//
//import javax.annotation.PostConstruct;
//import javax.ejb.EJB;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ManagedProperty;
//import javax.faces.bean.SessionScoped;
//
//import fr.afcepf.ai105.p3.g1.appjardeen.business.ActionsBusiness;
//import fr.afcepf.ai105.p3.g1.appjardeen.business.AdherentBusiness;
//import fr.afcepf.ai105.p3.g1.appjardeen.business.AffectationAdherentBusiness;
//import fr.afcepf.ai105.p3.g1.appjardeen.business.CompetenceBusiness;
//import fr.afcepf.ai105.p3.g1.appjardeen.business.ParcelleBusiness;
//import fr.afcepf.ai105.p3.g1.appjardeen.business.PlanteBusiness;
//import fr.afcepf.ai105.p3.g1.appjardeen.business.TacheBusiness;
//import fr.afcepf.ai105.p3.g1.appjardeen.business.TerrainBusiness;
//import fr.afcepf.ai105.p3.g1.appjardeen.business.VolontariatAdherentBusiness;
//import fr.afcepf.ai105.p3.g1.appjardeen.entities.Actions;
//import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
//import fr.afcepf.ai105.p3.g1.appjardeen.entities.Competence;
//import fr.afcepf.ai105.p3.g1.appjardeen.entities.Parcelle;
//import fr.afcepf.ai105.p3.g1.appjardeen.entities.Plante;
//import fr.afcepf.ai105.p3.g1.appjardeen.entities.Tache;
//import fr.afcepf.ai105.p3.g1.appjardeen.entities.Terrain;
//
//@ManagedBean(name = "mbEditerTache")
//@SessionScoped
//public class EditerTacheManagedBean implements Serializable {
//
//
//	private static final long serialVersionUID = 1L;
//	private List<Parcelle> parcelles = new ArrayList<>();;
//	private List<Terrain> terrains = new ArrayList<>();
//	private List<Plante> plantes = new ArrayList<>();
//	private List<Actions> actions = new ArrayList<>();
//	private List<Competence> competences = new ArrayList<>();
//	private List<Adherent> adherentsAffectes = new ArrayList<>();
//	private Terrain terrainChoisi;
//	private List<Parcelle> parc = new ArrayList<>();
//	private List<Plante> pflanze = new ArrayList<>();
//	private List<Actions> act = new ArrayList<>();
//	private List<Terrain> ter = new ArrayList<>();
//	private List<Competence> comp = new ArrayList<>();
//	private int nbAdResteAaffecter;
//	private List<Adherent> adherentsVolontaires = new ArrayList<>();
//	private List<Adherent> adherentsDisponibles = new ArrayList<>();
//	private boolean affichage;
//	private Tache tache;
//	private Terrain terrainTache; 
//	private Parcelle parcelleTache;
//	private Competence competenceTache;
//	private Actions actionTache;
//	private Plante planteTache;
//	private Date debutTache;
//	private Date finTache;
//	private int nbAdherentRequis;
//	private String libelleTache;
//	
//	
//	
//	
//	@EJB
//	private ParcelleBusiness proxyParcelleBusiness;
//	
//	@ManagedProperty("#{mbPlanningTache.selectedEvent}")
//	private PlanningTacheEvent selectedEvent;
//	
//
//	@EJB
//	private TerrainBusiness proxyTerrainBusiness;
//	
//	@EJB
//	private PlanteBusiness proxyPlante;
//	
//	@EJB
//	private ActionsBusiness proxyActions;
//	
//	@EJB
//	private CompetenceBusiness proxyCompetence;
//	
//	@EJB
//	private VolontariatAdherentBusiness proxyVolontariat;
//	
//	@EJB 
//	private AffectationAdherentBusiness proxyAffectationAdherentBusiness ;
//	
//	@EJB 
//	private AdherentBusiness proxyAdherentBusiness ;	
//	
//	@EJB 
//	private TacheBusiness proxyTacheBusiness ;
//	
//	
//	@PostConstruct
//	public void init() {
//		
//		terrainTache = selectedEvent.getTerrain();
//		parcelleTache = selectedEvent.getParcelle();
//		actionTache = selectedEvent.getAction();
//		competenceTache = selectedEvent.getCompetence();
//		if(selectedEvent.getPlante()!=null) {
//			planteTache = selectedEvent.getPlante();
//		}
//		
//		
//		tache = selectedEvent.getTache();
//		terrains.add(selectedEvent.getTerrain()); //je recupere le terrain lié à la tâche selectionnée
//		ter = proxyTerrainBusiness.obtenirTerrain();
//		//condition pour verifier si la liste ter(terrain) contient le terrain de la tache selectionnée
//		Predicate<Terrain> conditionTer = terrain -> terrain.getLibelleTerrain().equals(selectedEvent.getTerrain().getLibelleTerrain());
//		//si oui je le supprimme pour ne pas l'avoir en double sur mon SelectOneMenu
//		ter.removeIf(conditionTer);
//		//je rajoute la liste ter à la liste que j'affiche sur SelectOneMenu
//		terrains.addAll(ter);
//
//		pflanze = proxyPlante.listerPlantes();
//		
//		if(selectedEvent.getPlante() != null) {
//			plantes.add(selectedEvent.getPlante());
//			Predicate<Plante> conditionPlante = plante -> plante.getLibellePlante().equals(selectedEvent.getPlante().getLibellePlante());
//			pflanze.removeIf(conditionPlante);
//		}
//				
//		plantes.addAll(pflanze);
//		
//		actions.add(selectedEvent.getAction());
//		act = proxyActions.listerActions();
//		Predicate<Actions> conditionAct = actions -> actions.getLibelleAction().equals(selectedEvent.getAction().getLibelleAction());
//		act.removeIf(conditionAct);
//		actions.addAll(act);
//		
//		parcelles.add(selectedEvent.getParcelle());
//		parc = proxyParcelleBusiness.listerParcelles();
//		Predicate<Parcelle> condition = parcelle -> parcelle.getLibelleParcelle().equals(selectedEvent.getParcelle().getLibelleParcelle());
//		parc.removeIf(condition);
//		parcelles.addAll(parc);
//		
//		competences.add(selectedEvent.getCompetence());
//		
//		comp = proxyCompetence.listerCompetences();
//		
//		Predicate<Competence> conditionComp = competence -> competence.getLibelleCompetence().equals(selectedEvent.getCompetence().getLibelleCompetence());
//		comp.removeIf(conditionComp);
//		competences.addAll(comp);
//		
//		adherentsAffectes.addAll(selectedEvent.getAdherents());
//		
//		adherentsVolontaires = proxyVolontariat.obtenirAdherentsVolontaireByIdTache(selectedEvent.getTache());
//		nbAdherentRequis = tache.getNbAdherentRequis();
//		nbAdResteAaffecter = nbAdherentRequis - adherentsAffectes.size();
//		
//		//si le nombre requis = le nbr affecté le btn affecter sera masqué
//		if(nbAdResteAaffecter== tache.getNbAdherentRequis()) {
//			affichage = false;
//		}else {
//			affichage = true;
//		}
//		
//		Date debut =selectedEvent.getStartDate();
//		Date fin = selectedEvent.getEndDate();
//		adherentsDisponibles = proxyAdherentBusiness.listerAdherentsDisponible(debut, fin);
//		
//	}
//	
//	public void affecterAdherent(int idAdherent) {
//		Tache tache= selectedEvent.getTache();
//		proxyAffectationAdherentBusiness.affecterAdherentTache(idAdherent, tache.getIdTache());
//	}
//	
//	public void desaffecterAdherent(Adherent adherent) {
//		Tache tache= selectedEvent.getTache();		
//		int idAffectation = proxyAffectationAdherentBusiness.obtenirIdAffectation(tache, adherent);
//		proxyAffectationAdherentBusiness.desaffecterAdherentTacheById(idAffectation);
//		
//	}
//	
//	public String reporterTache() {
//		debutTache = tache.getDateDebutTache();
//		finTache = tache.getDateFinTache();
//		proxyTacheBusiness.reporterTache(tache.getIdTache(), debutTache, finTache);
//		
//		return "/listeTaches.xhtml?faces-redirect=true";
//		
//	}
//
//	
//	public void modifierTache() {
//		libelleTache = tache.getLibelleTache();
//		parcelleTache = tache.getParcelle();
//		planteTache= tache.getPlante();
//		actionTache= tache.getAction();
//		competenceTache = tache.getCompetence();
//		nbAdherentRequis = tache.getNbAdherentRequis();
//		proxyTacheBusiness.modifierTache(tache, libelleTache, parcelleTache, planteTache, actionTache, competenceTache, nbAdherentRequis);
//	}
//
//	
//	public String marquerAdherentsVolontare(Adherent adherent) {
//		String style="";
//		if(adherentsVolontaires.contains(adherent)) {
//			//style="background-image: radial-gradient(circle closest-side, green 0%, purple 20%, yellowgreen 100%);";
//			style="font-weight:bold; background-image: linear-gradient(yellow, green, white)";
//		}
//		return style; 
//	}
//	
//	
//	
//	
//
//	public List<Parcelle> getParcelles() {
//		return parcelles;
//	}
//
//	public void setParcelles(List<Parcelle> parcelles) {
//		this.parcelles = parcelles;
//	}
//
//	public Terrain getTerrainChoisi() {
//		return terrainChoisi;
//	}
//
//	public void setTerrainChoisi(Terrain terrainChoisi) {
//		this.terrainChoisi = terrainChoisi;
//	}
//
//
//
//	public List<Terrain> getTerrains() {
//		return terrains;
//	}
//
//	public void setTerrains(List<Terrain> terrains) {
//		this.terrains = terrains;
//	}
//
//
//
//	public List<Plante> getPlantes() {
//		return plantes;
//	}
//
//
//
//	public void setPlantes(List<Plante> plantes) {
//		this.plantes = plantes;
//	}
//
//
//
//	public List<Actions> getActions() {
//		return actions;
//	}
//
//
//
//	public void setActions(List<Actions> actions) {
//		this.actions = actions;
//	}
//
//
//
//	public List<Competence> getCompetences() {
//		return competences;
//	}
//
//
//
//	public void setCompetences(List<Competence> competences) {
//		this.competences = competences;
//	}
//
//
//	public List<Parcelle> getParc() {
//		return parc;
//	}
//
//
//
//	public void setParc(List<Parcelle> parc) {
//		this.parc = parc;
//	}
//
//
//
//	public List<Plante> getPflanze() {
//		return pflanze;
//	}
//
//
//
//	public void setPflanze(List<Plante> pflanze) {
//		this.pflanze = pflanze;
//	}
//
//
//
//	public List<Actions> getAct() {
//		return act;
//	}
//
//
//
//	public void setAct(List<Actions> act) {
//		this.act = act;
//	}
//
//
//
//	public List<Terrain> getTer() {
//		return ter;
//	}
//
//
//
//	public void setTer(List<Terrain> ter) {
//		this.ter = ter;
//	}
//
//
//
//	public List<Adherent> getAdherentsAffectes() {
//		return adherentsAffectes;
//	}
//
//
//
//	public void setAdherentsAffectes(List<Adherent> adherentsAffectes) {
//		this.adherentsAffectes = adherentsAffectes;
//	}
//
//
//
//	public List<Competence> getComp() {
//		return comp;
//	}
//
//
//
//	public void setComp(List<Competence> comp) {
//		this.comp = comp;
//	}
//
//
//
//	public List<Adherent> getAdherentsVolontaires() {
//		return adherentsVolontaires;
//	}
//
//
//
//	public void setAdherentsVolontaires(List<Adherent> adherentsVolontaires) {
//		this.adherentsVolontaires = adherentsVolontaires;
//	}
//
//	public int getNbAdResteAaffecter() {
//		return nbAdResteAaffecter;
//	}
//
//	public void setNbAdResteAaffecter(int nbAdResteAaffecter) {
//		this.nbAdResteAaffecter = nbAdResteAaffecter;
//	}
//
//	public boolean isAffichage() {
//		return affichage;
//	}
//
//	public void setAffichage(boolean affichage) {
//		this.affichage = affichage;
//	}
//
//	public List<Adherent> getAdherentsDisponibles() {
//		return adherentsDisponibles;
//	}
//
//	public void setAdherentsDisponibles(List<Adherent> adherentsDisponibles) {
//		this.adherentsDisponibles = adherentsDisponibles;
//	}
//
//	public Tache getTache() {
//		return tache;
//	}
//
//	public void setTache(Tache tache) {
//		this.tache = tache;
//	}
//
//	public Terrain getTerrainTache() {
//		return terrainTache;
//	}
//
//	public void setTerrainTache(Terrain terrainTache) {
//		this.terrainTache = terrainTache;
//	}
//
//	public Parcelle getParcelleTache() {
//		return parcelleTache;
//	}
//
//	public void setParcelleTache(Parcelle parcelleTache) {
//		this.parcelleTache = parcelleTache;
//	}
//
//	public Competence getCompetenceTache() {
//		return competenceTache;
//	}
//
//	public void setCompetenceTache(Competence competenceTache) {
//		this.competenceTache = competenceTache;
//	}
//
//	public Actions getActionTache() {
//		return actionTache;
//	}
//
//	public void setActionTache(Actions actionTache) {
//		this.actionTache = actionTache;
//	}
//
//	public Plante getPlanteTache() {
//		return planteTache;
//	}
//
//	public void setPlanteTache(Plante planteTache) {
//		this.planteTache = planteTache;
//	}
//
//	
//
//	public PlanningTacheEvent getSelectedEvent() {
//		return selectedEvent;
//	}
//
//	public void setSelectedEvent(PlanningTacheEvent selectedEvent) {
//		this.selectedEvent = selectedEvent;
//	}
//
//	public Date getDebutTache() {
//		return debutTache;
//	}
//
//	public void setDebutTache(Date debutTache) {
//		this.debutTache = debutTache;
//	}
//
//	public Date getFinTache() {
//		return finTache;
//	}
//
//	public void setFinTache(Date finTache) {
//		this.finTache = finTache;
//	}
//
//	public int getNbAdherentRequis() {
//		return nbAdherentRequis;
//	}
//
//	public void setNbAdherentRequis(int nbAdherentRequis) {
//		this.nbAdherentRequis = nbAdherentRequis;
//	}
//
//	public String getLibelleTache() {
//		return libelleTache;
//	}
//
//	public void setLibelleTache(String libelleTache) {
//		this.libelleTache = libelleTache;
//	}
//	
//	
//	
//
//}
