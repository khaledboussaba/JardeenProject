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

import fr.afcepf.ai105.p3.g1.appjardeen.business.IndisponibiliteBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.VolontariatAdherentBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.AffectationAdherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Indisponibilite;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Tache;

@ManagedBean(name = "mbPlanningIndisponibilites")
@ViewScoped
public class PlanningIndisponibilitesManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<Indisponibilite> indisponibilites;
	
	@ManagedProperty("#{mbConnect.adherent}")
	private Adherent adherent;
	
	 private ScheduleModel eventModel;
	 private ScheduleEvent event = new DefaultScheduleEvent();
	
	@EJB
	IndisponibiliteBusiness proxyIndisponibiliteBusiness;
	
	@EJB
	VolontariatAdherentBusiness proxyVolontariat;
	
		
	@PostConstruct
	public void init() {
		
		indisponibilites = proxyIndisponibiliteBusiness.listerIndisponibilites(adherent);
		eventModel = new DefaultScheduleModel();
		
		for (Indisponibilite i: indisponibilites) {
			
			 DefaultScheduleEvent e = new DefaultScheduleEvent();
			e.setTitle("Indisponibilité");
			e.setStartDate(i.getDebutDateIndisponibilite());
			System.out.println("===================="+e.getStartDate()+"=============================");
			e.setEndDate(i.getFinDateIndisponibilite());
			e.setDescription("Description");
			System.out.println("===================="+e.getDescription()+"=============================");
			
			switch (i.getIdIndisponibilite()) {
			case 1:
				e.setStyleClass("couleur1");
				break;
			case 2:
				e.setStyleClass("couleur2");
				break;
			case 3:
				e.setStyleClass("couleur3");
				break;
			case 4:
				e.setStyleClass("couleur4");
				break;
			case 5:
				e.setStyleClass("couleur5");
				break;
			case 6:
				e.setStyleClass("couleur6");
				break;
			case 7:
				e.setStyleClass("couleur7");
				break;
			case 8:
				e.setStyleClass("couleur8");
				break;
			case 9:
				e.setStyleClass("couleur9");
				break;
			case 10:
				e.setStyleClass("couleur10");
				break;
			case 11:
				e.setStyleClass("couleur11");
				break;
			case 12:
				e.setStyleClass("couleur12");
				break;
			case 13:
				e.setStyleClass("couleur13");
				break;
			case 14:
				e.setStyleClass("couleur14");
				break;
			case 15:
				e.setStyleClass("couleur15");
				break;
			case 16:
				e.setStyleClass("couleur16");
				break;
			case 17:
				e.setStyleClass("couleur17");
				break;
			default:
				break;
			}
			eventModel.addEvent(e);
		}
	}
	
	
	public void addEvent() {
		if(event.getId() == null) {
			eventModel.addEvent(event);
		} else {
			eventModel.updateEvent(event);
		}
		event = new DefaultScheduleEvent();
	}

	public void onEventSelect(SelectEvent selectEvent) {
		event = (ScheduleEvent) selectEvent.getObject();
	}
	
	
	public List<Indisponibilite> getIndisponibilites() {
		return indisponibilites;
	}
	public void setIndisponibilites(List<Indisponibilite> indisponibilites) {
		this.indisponibilites = indisponibilites;
	}
	public Adherent getAdherent() {
		return adherent;
	}
	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
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
}