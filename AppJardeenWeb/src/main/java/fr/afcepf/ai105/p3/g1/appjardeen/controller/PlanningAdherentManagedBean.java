package fr.afcepf.ai105.p3.g1.appjardeen.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import fr.afcepf.ai105.p3.g1.appjardeen.business.AffectationAdherentBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.VolontariatAdherentBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.AffectationAdherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Tache;

@ManagedBean(name = "mbPlanningAdherent")
@ViewScoped
public class PlanningAdherentManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<Tache> taches;
	private List<Tache> tachesVolontariat;
	private List<Tache> tachesAdherent = new ArrayList<>();
	private String etat="";
	private List<AffectationAdherent> adherentAffecte;
	
	@ManagedProperty("#{mbConnect.adherent}")
	private Adherent adherent;
	
	 private ScheduleModel eventModel;
	 private ScheduleEvent event = new DefaultScheduleEvent();
	 private List<Adherent> adherents;
	 private PlannintAdherentEvent newEvent;
	 private PlannintAdherentEvent selectedEvent;
	
	 @EJB
	private AffectationAdherentBusiness proxyAffectAdherent;
	
	@EJB
	private VolontariatAdherentBusiness proxyVolontariat;
	
	@EJB
	private AffectationAdherentBusiness proxyAffect;
		
	@PostConstruct
	public void init() {
//		taches = new ArrayList<>();
		eventModel = new DefaultScheduleModel();
		//Adh affecté
		taches = proxyAffectAdherent.obtenirTacheAffectByIdAdherent(adherent.getIdAdherent());
		
		//Adh volontaire
		tachesVolontariat = proxyVolontariat.obtenirTacheVolontariatByAdherent(adherent.getIdAdherent());
		
		//fusionner les deux listes
		tachesAdherent.addAll(taches);
		tachesAdherent.addAll(tachesVolontariat);
		
		for (Tache tache: taches) {
			newEvent = new PlannintAdherentEvent();
			//adh affectés à "tache"
			adherents=proxyAffect.obtenirAdherentsAffectesByIdTache(tache.getIdTache());
			newEvent.setAdherent(adherents);
			newEvent.setTitle(tache.getParcelle().getLibelleParcelle()
						+": "+ tache.getLibelleTache().split("_")[0]);
			newEvent.setStartDate(tache.getDateDebutTache());
			newEvent.setEndDate(tache.getDateFinTache());
			newEvent.setDescription(tache.getLibelleTache());
			newEvent.setTerrain(tache.getParcelle().getTerrain());
			newEvent.setParcelle(tache.getParcelle());
			newEvent.setAction(tache.getAction());
			newEvent.setCompetence(tache.getCompetence());
//			System.out.println("=====================>  competence :"+tache.getCompetence()+"=========================");
			newEvent.setPlante(tache.getPlante());
			newEvent.setData(tache);
			
			switch (tache.getAction().getIdAction()) {
			case 1:
				newEvent.setStyleClass("couleur1");
				break;
			case 2:
				newEvent.setStyleClass("couleur2");
				break;
			case 3:
				newEvent.setStyleClass("couleur3");
				break;
			case 4:
				newEvent.setStyleClass("couleur4");
				break;
			case 5:
				newEvent.setStyleClass("couleur5");
				break;
			case 6:
				newEvent.setStyleClass("couleur6");
				break;
			case 7:
				newEvent.setStyleClass("couleur7");
				break;
			case 8:
				newEvent.setStyleClass("couleur8");
				break;
			case 9:
				newEvent.setStyleClass("couleur9");
				break;
			case 10:
				newEvent.setStyleClass("couleur10");
				break;
			case 11:
				newEvent.setStyleClass("couleur11");
				break;
			case 12:
				newEvent.setStyleClass("couleur12");
				break;
			case 13:
				newEvent.setStyleClass("couleur13");
				break;
			case 14:
				newEvent.setStyleClass("couleur14");
				break;
			case 15:
				newEvent.setStyleClass("couleur15");
				break;
			case 16:
				newEvent.setStyleClass("couleur16");
				break;
			case 17:
				newEvent.setStyleClass("couleur17");
				break;
			default:
				break;
			}
			
			
			//eventModel.addEvent(e);
			eventModel.addEvent(newEvent);
		}
		
		
	}
	
	
	public void addEvent() {
		if(event.getId() == null)
			eventModel.addEvent(newEvent);
		else
			eventModel.updateEvent(newEvent);

		newEvent = new PlannintAdherentEvent();
	}

	public void onEventSelect(SelectEvent selectEvent) {
		newEvent = (PlannintAdherentEvent) selectEvent.getObject();
//		adherents = new ArrayList<>();
		selectedEvent=  newEvent;
	}
	
	
	public String etatTache(Tache tache) {
		if(taches.contains(tache)) {
			etat="Affecté";
		}else {
			etat="Volontaire";
		}
				
		return etat; 
	}
	
	public void detailsTache(Tache tache) {
		adherents=proxyAffect.obtenirAdherentsAffectesByIdTache(tache.getIdTache());
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

	public List<Tache> getTachesVolontariat() {
		return tachesVolontariat;
	}

	public void setTachesVolontariat(List<Tache> tachesVolontariat) {
		this.tachesVolontariat = tachesVolontariat;
	}

	public List<Tache> getTachesAdherent() {
		return tachesAdherent;
	}

	public void setTachesAdherent(List<Tache> tachesAdherent) {
		this.tachesAdherent = tachesAdherent;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public List<AffectationAdherent> getAdherentAffecte() {
		return adherentAffecte;
	}

	public void setAdherentAffecte(List<AffectationAdherent> adherentAffecte) {
		this.adherentAffecte = adherentAffecte;
	}

	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}

	public ScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}


	public List<Adherent> getAdherents() {
		return adherents;
	}


	public void setAdherents(List<Adherent> adherents) {
		this.adherents = adherents;
	}


	public PlannintAdherentEvent getNewEvent() {
		return newEvent;
	}


	public void setNewEvent(PlannintAdherentEvent newEvent) {
		this.newEvent = newEvent;
	}


	public PlannintAdherentEvent getSelectedEvent() {
		return selectedEvent;
	}


	public void setSelectedEvent(PlannintAdherentEvent selectedEvent) {
		this.selectedEvent = selectedEvent;
	}
	
	
	
}
