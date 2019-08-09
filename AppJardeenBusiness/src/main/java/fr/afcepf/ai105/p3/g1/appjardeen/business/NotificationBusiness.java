package fr.afcepf.ai105.p3.g1.appjardeen.business;

import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Notification;

public interface NotificationBusiness {

	List<Notification> listerAlertesCotisations();
	List<Notification> listerAlertesJardiniers();
	List<Notification> listerNotificationsSemisPlante();
	List<Notification> listerNotificationsFloraisonPlante();
	List<Notification> listerNotificationsRecoltePlante();
}
