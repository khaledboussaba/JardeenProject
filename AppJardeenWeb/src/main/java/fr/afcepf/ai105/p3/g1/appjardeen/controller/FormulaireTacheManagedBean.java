package fr.afcepf.ai105.p3.g1.appjardeen.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
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
import fr.afcepf.ai105.p3.g1.appjardeen.entities.ActionsPlante;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.AffectationAdherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Competence;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Outil;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Parcelle;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Plante;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Tache;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Terrain;

@ManagedBean (name = "mbFormulaireTache")
@ViewScoped
public class FormulaireTacheManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<Terrain> terrains = new ArrayList<>();
	private List<Parcelle> parcelles = new ArrayList<>();
	private List<Plante> plantes = new ArrayList<>();
	private List<Actions> actions = new ArrayList<>();
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
	private String affichageDdlParcelle = "lg";
	private String affichageDdlPlante = "lg";
	private String affichageDdlAction = "lg";
	private String affichageDdlCompetence = "lg";
	
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
	
	@PostConstruct
	public void init() {
		terrains = proxyTerrainBusiness.obtenirTerrainNonRetire();
		terrains.add(0, new Terrain("-"));
	}
	
	public void listerParcellesTerrains() {
		parcelles = proxyParcelleBusiness.listerParcellesTerrain(terrainChoisi);
		parcelles.add(0, new Parcelle("-"));
		affichageDdlParcelle = "xs";
		affichageDdlPlante = "lg";
		affichageDdlAction = "lg";
		affichageDdlCompetence = "lg";
	}
	
	public void determinerPlanteEnCours() {
		plantes.clear();
		actions.clear();
		Tache derniereTache = proxyTacheBusiness.obtenirDerniereTachePlanifee(parcelleChoisie);

		if(derniereTache != null) {
			ActionsPlante derniereActionsPlante = proxyActionsPlanteBusiness.obtenirNumOrdreActionByPlanteAndAction(derniereTache.getAction(), derniereTache.getPlante());
			List<Actions> actionsRestantes = new ArrayList<>();
			
			if(derniereActionsPlante != null) {
				actionsRestantes = proxyActionsPlanteBusiness.obtenirToutesActionApresNumOrdreByPlante(derniereTache.getPlante(), derniereActionsPlante.getNumOrdonnancement());
			}
			if (actionsRestantes.size() > 0) {
				plantes.add(derniereTache.getPlante());
				actions = actionsRestantes;
			} else {
				plantes = proxyPlanteBusiness.listerPlantes();
				actions = proxyActionsBusiness.listerActions();
			}
		} else {
			plantes = proxyPlanteBusiness.listerPlantes();
		}
		plantes.add(0, new Plante("-"));
		affichageDdlPlante = "xs";
		affichageDdlAction = "lg";
		affichageDdlCompetence = "lg";
	}
	
	public void listerActionsOrdonneesRestantes() {
		
		actions.clear();
		Tache derniereTache = proxyTacheBusiness.obtenirDerniereTachePlanifee(parcelleChoisie);

		if(derniereTache != null) {
			ActionsPlante derniereActionsPlante = proxyActionsPlanteBusiness.obtenirNumOrdreActionByPlanteAndAction(derniereTache.getAction(), derniereTache.getPlante());
			List<Actions> actionsRestantes = new ArrayList<>();
			
			if(derniereActionsPlante != null) {
				actionsRestantes = proxyActionsPlanteBusiness.obtenirToutesActionApresNumOrdreByPlante(derniereTache.getPlante(), derniereActionsPlante.getNumOrdonnancement());
			}
			if (actionsRestantes.size() > 0) {
				for (int i = 0; i < actionsRestantes.size(); i++) {
					Actions action = new Actions();
					action = actionsRestantes.get(i);
					action.setLibelleAction((i + 1) + " - " + action.getLibelleAction());
					actions.add(action);
				}
				actions.add(new Actions("-----"));
				List<Actions> toutesLesActions = proxyActionsBusiness.listerActions();
				boolean presente = false;
				for (Actions uneParmisToutes : toutesLesActions) {
					for (Actions uneOrdonnee : actions) {
						if (uneParmisToutes.getIdAction() == uneOrdonnee.getIdAction()) {
							presente = true;
						}
					}
					if (!presente) {
						actions.add(uneParmisToutes);
					}
					presente = false;
				}
			} else {
				actions = proxyActionsBusiness.listerActions();
			}
		} else {
			actions = proxyActionsBusiness.listerActions();
		}
		actions.add(0, new Actions("-"));
		affichageDdlAction = "xs";
		affichageDdlCompetence = "lg";
	}
	
	public void listerCompetenceRecommandee()
	{
		competences.clear();
		Competence competence = proxyActionsBusiness.obtenirCompetenceSelonAction(actionChoisie);
//		competence.setLibelleCompetence(competence.getLibelleCompetence());
		competences.add(competence);
		competences.add(new Competence("-----"));
		List<Competence> toutesLesCompetences = proxyCompetenceBusiness.listerCompetences();
		for (Competence c : toutesLesCompetences) {
			if (c.getIdCompetence() != competence.getIdCompetence()) {
				competences.add(c);
			}
		}
		affichageDdlCompetence = "xs";
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

	public String creerTache() {
		String[] elementsNb = nbJardiniersChoisi.split("\\.");
		String nb = elementsNb[0];
		int nbJardinier = Integer.parseInt(nb);
		proxyTacheBusiness.creationTache(
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

	public List<Terrain> getTerrains() {
		return terrains;
	}
	public void setTerrains(List<Terrain> terrains) {
		this.terrains = terrains;
	}
	public List<Parcelle> getParcelles() {
		return parcelles;
	}
	public void setParcelles(List<Parcelle> parcelles) {
		this.parcelles = parcelles;
	}
	public List<Plante> getPlantes() {
		return plantes;
	}
	public void setPlantes(List<Plante> plantes) {
		this.plantes = plantes;
	}
	public List<Actions> getActions() {
		return actions;
	}
	public void setActions(List<Actions> actions) {
		this.actions = actions;
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
	public String getAffichageDdlParcelle() {
		return affichageDdlParcelle;
	}
	public void setAffichageDdlParcelle(String affichageDdlParcelle) {
		this.affichageDdlParcelle = affichageDdlParcelle;
	}
	public String getAffichageDdlPlante() {
		return affichageDdlPlante;
	}
	public void setAffichageDdlPlante(String affichageDdlPlante) {
		this.affichageDdlPlante = affichageDdlPlante;
	}
	public String getAffichageDdlAction() {
		return affichageDdlAction;
	}
	public void setAffichageDdlAction(String affichageDdlAction) {
		this.affichageDdlAction = affichageDdlAction;
	}
	public String getAffichageDdlCompetence() {
		return affichageDdlCompetence;
	}
	public void setAffichageDdlCompetence(String affichageDdlCompetence) {
		this.affichageDdlCompetence = affichageDdlCompetence;
	}
}
