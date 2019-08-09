package fr.afcepf.ai105.p3.g1.appjardeen.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import fr.afcepf.ai105.p3.g1.appjardeen.business.AffectationAdherentBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.TacheBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Tache;

@ManagedBean(name ="mbPlanningTache")
@ViewScoped
public class PlannigTacheMangedBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private ScheduleModel eventModel;

	private ScheduleEvent event = new DefaultScheduleEvent();

	private List<Tache> tachesPlanifiees;
	
	private int nbAdherentsRequis;
	
	private List<Adherent> adherentsAffectes;
	private PlanningTacheEvent selectedEvent;
	private PlanningTacheEvent e;

	@EJB
	private TacheBusiness proxyTacheBusiness;
	
	@EJB
	private AffectationAdherentBusiness proxyAffect;

	@PostConstruct
	public void init() {
		tachesPlanifiees = proxyTacheBusiness.obtenirLesTachesPlanifees();
		eventModel = new DefaultScheduleModel();

		for (int i = 0; i < tachesPlanifiees.size(); i++) {
			e = new PlanningTacheEvent();
			adherentsAffectes=proxyAffect.obtenirAdherentsAffectesByIdTache(tachesPlanifiees.get(i).getIdTache());
			
			e.setTitle(tachesPlanifiees.get(i).getParcelle().getLibelleParcelle() + " " + tachesPlanifiees.get(i).getLibelleTache().split("_")[0]);
			e.setAdherents(adherentsAffectes);
			e.setStartDate(tachesPlanifiees.get(i).getDateDebutTache());
			e.setEndDate(tachesPlanifiees.get(i).getDateFinTache());
			
			int[] nbAdherent = {tachesPlanifiees.get(i).getAffectationsAdherents().size(), tachesPlanifiees.get(i).getNbAdherentRequis()};
			
			e.setData(nbAdherent);
			e.setDescription(tachesPlanifiees.get(i).getLibelleTache());
			e.setTerrain(tachesPlanifiees.get(i).getParcelle().getTerrain());
			e.setParcelle(tachesPlanifiees.get(i).getParcelle());
			e.setAction(tachesPlanifiees.get(i).getAction());
			e.setCompetence(tachesPlanifiees.get(i).getCompetence());
			e.setPlante(tachesPlanifiees.get(i).getPlante());
			e.setTache(tachesPlanifiees.get(i));
			
//			e.setDescription(String.valueOf(tachesPlanifiees.get(i).getNbAdherentRequis()));
			
			
			
			switch (tachesPlanifiees.get(i).getAction().getIdAction()) {
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

	//    @PostConstruct
	//    public void init() {
	//    	tachesPlanifiees = proxyTacheBusiness.obtenirLesTachesPlanifees();
	//        eventModel = new DefaultScheduleModel();
	//        for (int i = 0; i < tachesPlanifiees.size(); i++) {
	//        	eventModel.addEvent(new DefaultScheduleEvent(tachesPlanifiees.get(i).getLibelleTache(), tachesPlanifiees.get(i).getDateDebutTache(),
	//        			tachesPlanifiees.get(i).getDateFinTache()));
	//        }
	//
	//    }

	
	
	public ScheduleModel getEventModel() {
		return eventModel;
	}


	public List<Tache> getTachesPlanifiees() {
		return tachesPlanifiees;
	}
	
	public int getNbAdherentsRequis() {
		return nbAdherentsRequis;
	}


	public ScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}

	public void addEvent() {
		if(event.getId() == null)
			eventModel.addEvent(e);//e au lieu de event
		else
			eventModel.updateEvent(e);

		//event = new DefaultScheduleEvent();
		
		e = new PlanningTacheEvent();
		
	}

	public void onEventSelect(SelectEvent selectEvent) {
		//event = (ScheduleEvent) selectEvent.getObject();
		e= (PlanningTacheEvent) selectEvent.getObject();
		selectedEvent =e;
	}

	public List<Adherent> getAdherentsAffectes() {
		return adherentsAffectes;
	}

	public void setAdherentsAffectes(List<Adherent> adherentsAffectes) {
		this.adherentsAffectes = adherentsAffectes;
	}

	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}

	public void setTachesPlanifiees(List<Tache> tachesPlanifiees) {
		this.tachesPlanifiees = tachesPlanifiees;
	}

	public void setNbAdherentsRequis(int nbAdherentsRequis) {
		this.nbAdherentsRequis = nbAdherentsRequis;
	}

	public PlanningTacheEvent getSelectedEvent() {
		return selectedEvent;
	}

	public void setSelectedEvent(PlanningTacheEvent selectedEvent) {
		this.selectedEvent = selectedEvent;
	}

	public PlanningTacheEvent getE() {
		return e;
	}

	public void setE(PlanningTacheEvent e) {
		this.e = e;
	}
 
}
