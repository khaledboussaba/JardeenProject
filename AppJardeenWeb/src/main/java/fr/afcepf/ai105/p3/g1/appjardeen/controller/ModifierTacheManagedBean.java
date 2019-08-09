

//package fr.afcepf.ai105.p3.g1.appjardeen.controller;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import javax.annotation.PostConstruct;
//import javax.ejb.EJB;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ManagedProperty;
//import javax.faces.bean.ViewScoped;
//
//import fr.afcepf.ai105.p3.g1.appjardeen.business.AdherentBusiness;
//import fr.afcepf.ai105.p3.g1.appjardeen.business.CompetenceBusiness;
//import fr.afcepf.ai105.p3.g1.appjardeen.business.OutilBusiness;
//import fr.afcepf.ai105.p3.g1.appjardeen.business.TerrainBusiness;
//import fr.afcepf.ai105.p3.g1.appjardeen.entities.Actions;
//import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
//import fr.afcepf.ai105.p3.g1.appjardeen.entities.Competence;
//import fr.afcepf.ai105.p3.g1.appjardeen.entities.Outil;
//import fr.afcepf.ai105.p3.g1.appjardeen.entities.Parcelle;
//import fr.afcepf.ai105.p3.g1.appjardeen.entities.Plante;
//import fr.afcepf.ai105.p3.g1.appjardeen.entities.Tache;
//import fr.afcepf.ai105.p3.g1.appjardeen.entities.Terrain;
//
//@ManagedBean(name ="mbModifierTache")
//@ViewScoped
//public class ModifierTacheManagedBean implements Serializable {
//
//
//	private static final long serialVersionUID = 1L;
//	private List<Terrain> terrains = new ArrayList<>();
//	private List<Competence> competences = new ArrayList<>();
//	private List<Adherent> adherentsDisponibles = new ArrayList<>();
//	private List<Adherent> adherentsAffectes = new ArrayList<>();
//	private List<Outil> outilsAffectes = new ArrayList<>();
//
//	private List<Outil> outilsDisponibles = new ArrayList<>();
//
//	private Terrain terrainTache; 
//	private Parcelle parcelleTache;
//	private Actions actionTache;
//	private Plante planteTache;
//	private Date debutTache;
//	private Date finTache;
//	private Competence competenceTache;
//	private Tache tache; 
//	private int nbrJardinniersRequis;
//	private String affichageTableauxAdherents = "lg";
//	private Competence competenceRequise;
//	private String affichageFormulaire = "xs";
//	private String affichageTableauxOutils= "lg";
//
//	
//	@ManagedProperty("#{mbPlanningTache.selectedEvent}")
//	private PlanningTacheEvent selectedEvent;
//	
//	@EJB
//	private TerrainBusiness proxyTerrainBusiness;
//	
//	@EJB 
//	private AdherentBusiness proxyAdherentBusiness ;	 
//	
//	@EJB
//	private CompetenceBusiness proxyCompetenceBusiness;
//	
//	@EJB
//	private OutilBusiness proxyOutilBusiness; 
//	
//	
//	@PostConstruct
//	public void init() {
//		terrains = proxyTerrainBusiness.obtenirTerrainNonRetire();
//		terrainTache = selectedEvent.getTerrain();
//		parcelleTache = selectedEvent.getParcelle();
//		actionTache = selectedEvent.getAction();
//		if(selectedEvent.getPlante()!=null) {
//			planteTache = selectedEvent.getPlante();
//		}
//		
//		debutTache = selectedEvent.getStartDate();
//		finTache = selectedEvent.getEndDate();
//		competenceTache = selectedEvent.getCompetence();
//		System.out.println("=========="+competenceTache.getLibelleCompetence()+"====================");
//		setCompetences(proxyCompetenceBusiness.listerCompetences());;
//		nbrJardinniersRequis = selectedEvent.getTache().getNbAdherentRequis();
//		adherentsDisponibles=proxyAdherentBusiness.listerAdherentsDisponible(debutTache, finTache);
//		adherentsAffectes.addAll(selectedEvent.getAdherents());
//	}
//
//	
//	public void listerDisponibles() {
//		setAffichageFormulaire("lg");
//		affichageTableauxAdherents = "xs";
////		int niveauCompetence = competenceRequise.getIdCompetence();
//		int niveauCompetence = 3;
//		adherentsDisponibles = proxyAdherentBusiness.listerAdherentsDisponiblesEtCompetents(debutTache, finTache, niveauCompetence);
//		System.out.println("=============="+debutTache+"hhhhhhhhhhhhhhhhhhh");
//
//		setOutilsDisponibles(proxyOutilBusiness.listerOutilsDisponibles(debutTache, finTache, outilsAffectes));
//		
//		for (Adherent adherent : adherentsAffectes) {
//			System.out.println("=============="+adherent.getIdAdherent()+"hhhhhhhhhhhhhhhhhhh");
//		}
//		
//
//	}
//	
//	
//	public void passerAuxOutils() {
//		affichageFormulaire = "lg";
//		affichageTableauxAdherents = "lg";
//		affichageTableauxOutils = "xs";
//	}
//	
//	public void retourFormulaire() {
//		affichageFormulaire = "xs";
//		affichageTableauxAdherents = "lg";
//		setAffichageTableauxOutils("lg");
//	}
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
//	public PlanningTacheEvent getSelectedEvent() {
//		return selectedEvent;
//	}
//
//	public void setSelectedEvent(PlanningTacheEvent selectedEvent) {
//		this.selectedEvent = selectedEvent;
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
//	public Competence getCompetenceTache() {
//		return competenceTache;
//	}
//
//	public void setCompetenceTache(Competence competenceTache) {
//		this.competenceTache = competenceTache;
//	}
//
//	public List<Competence> getCompetences() {
//		return competences;
//	}
//
//	public void setCompetences(List<Competence> competences) {
//		this.competences = competences;
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
//	public int getNbrJardinniersRequis() {
//		return nbrJardinniersRequis;
//	}
//
//	public void setNbrJardinniersRequis(int nbrJardinniersRequis) {
//		this.nbrJardinniersRequis = nbrJardinniersRequis;
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
//	public String getAffichageTableauxAdherents() {
//		return affichageTableauxAdherents;
//	}
//
//	public void setAffichageTableauxAdherents(String affichageTableauxAdherents) {
//		this.affichageTableauxAdherents = affichageTableauxAdherents;
//	}
//
//	public List<Adherent> getAdherentsAffectes() {
//		return adherentsAffectes;
//	}
//
//	public void setAdherentsAffectes(List<Adherent> adherentsAffectes) {
//		this.adherentsAffectes = adherentsAffectes;
//	}
//
//
//	public Competence getCompetenceRequise() {
//		return competenceRequise;
//	}
//
//
//	public void setCompetenceRequise(Competence competenceRequise) {
//		this.competenceRequise = competenceRequise;
//	}
//
//
//	public String getAffichageFormulaire() {
//		return affichageFormulaire;
//	}
//
//
//	public void setAffichageFormulaire(String affichageFormulaire) {
//		this.affichageFormulaire = affichageFormulaire;
//	}
//
//
//	public String getAffichageTableauxOutils() {
//		return affichageTableauxOutils;
//	}
//
//
//	public void setAffichageTableauxOutils(String affichageTableauxOutils) {
//		this.affichageTableauxOutils = affichageTableauxOutils;
//	}
//
//
//	public List<Outil> getOutilsDisponibles() {
//		return outilsDisponibles;
//	}
//
//
//	public void setOutilsDisponibles(List<Outil> outilsDisponibles) {
//		this.outilsDisponibles = outilsDisponibles;
//	}
//
//
//	
//	
//	
//	
//}
