package fr.afcepf.ai105.p3.g1.appjardeen.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.afcepf.ai105.p3.g1.appjardeen.business.NotificationBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.TacheBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Notification;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Tache;

@ManagedBean (name = "mbDashboard")
@RequestScoped
public class DashboardManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<Tache> tachesDuJour = new ArrayList<>();
	private Date dateDuJour = new Date();
	private List<Notification> alertesCotisation = new ArrayList<>();
	private List<Notification> alertesJardiniers = new ArrayList<>();
	private List<Notification> notificationsSemisPlante = new ArrayList<>();
	private List<Notification> notificationsFloraisonPlante = new ArrayList<>();
	private List<Notification> notificationsRecoltePlante = new ArrayList<>();
	
	@EJB
	private TacheBusiness proxyTacheBusiness;
	@EJB
	private NotificationBusiness proxyNotificationBusiness;

	@PostConstruct
	public void init() {
		tachesDuJour = proxyTacheBusiness.listerTachesDuJour();
		alertesCotisation = proxyNotificationBusiness.listerAlertesCotisations();
		alertesJardiniers = proxyNotificationBusiness.listerAlertesJardiniers();
		notificationsSemisPlante = proxyNotificationBusiness.listerNotificationsSemisPlante();
		notificationsFloraisonPlante = proxyNotificationBusiness.listerNotificationsFloraisonPlante();
		notificationsRecoltePlante = proxyNotificationBusiness.listerNotificationsRecoltePlante();
	}
	
	public List<Tache> getTachesDuJour() {
		return tachesDuJour;
	}
	public void setTachesDuJour(List<Tache> tachesDuJour) {
		this.tachesDuJour = tachesDuJour;
	}
	public Date getDateDuJour() {
		return dateDuJour;
	}
	public void setDateDuJour(Date dateDuJour) {
		this.dateDuJour = dateDuJour;
	}
	public List<Notification> getAlertesCotisation() {
		return alertesCotisation;
	}
	public void setAlertesCotisation(List<Notification> alertesCotisation) {
		this.alertesCotisation = alertesCotisation;
	}
	public List<Notification> getAlertesJardiniers() {
		return alertesJardiniers;
	}
	public void setAlertesJardiniers(List<Notification> alertesJardiniers) {
		this.alertesJardiniers = alertesJardiniers;
	}
	public List<Notification> getNotificationsSemisPlante() {
		return notificationsSemisPlante;
	}
	public void setNotificationsSemisPlante(List<Notification> notificationsSemisPlante) {
		this.notificationsSemisPlante = notificationsSemisPlante;
	}
	public List<Notification> getNotificationsFloraisonPlante() {
		return notificationsFloraisonPlante;
	}
	public void setNotificationsFloraisonPlante(List<Notification> notificationsFloraisonPlante) {
		this.notificationsFloraisonPlante = notificationsFloraisonPlante;
	}
	public List<Notification> getNotificationsRecoltePlante() {
		return notificationsRecoltePlante;
	}
	public void setNotificationsRecoltePlante(List<Notification> notificationsRecoltePlante) {
		this.notificationsRecoltePlante = notificationsRecoltePlante;
	}
}
