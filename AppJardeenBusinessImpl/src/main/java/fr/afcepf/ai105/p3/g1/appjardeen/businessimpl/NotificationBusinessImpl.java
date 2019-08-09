package fr.afcepf.ai105.p3.g1.appjardeen.businessimpl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai105.p3.g1.appjardeen.business.NotificationBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.dao.InscriptionDao;
import fr.afcepf.ai105.p3.g1.appjardeen.dao.PlanteDao;
import fr.afcepf.ai105.p3.g1.appjardeen.dao.TacheDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Inscription;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Notification;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Plante;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Tache;

@Remote(NotificationBusiness.class)
@Stateless
public class NotificationBusinessImpl implements NotificationBusiness {

	@EJB
	private InscriptionDao proxyInscriptionDao;
	@EJB
	private TacheDao proxyTacheDao;
	@EJB
	private PlanteDao proxyPlanteDao;
	
	@Override
	public List<Notification> listerAlertesCotisations() {
		List<Notification> notifications = new ArrayList<>();
		List<Inscription> inscriptionsAEcheance = proxyInscriptionDao.getInscriptionAEcheance();
		for (Inscription i : inscriptionsAEcheance) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(i.getDateInscription());
			calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + 1);
			Date date = calendar.getTime();
			LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
			String dateFormatee = localDate.format(formatter);
			Notification notification = new Notification(
											"Cotisation à payer",
											"La cotisation de "
													+ i.getAdherent().getPrenom()
													+ " "
													+ i.getAdherent().getNomNaissance()
													+ " arrive à échéance le "
													+ dateFormatee
													);
			notifications.add(notification);
		}
		return notifications;
	}

	@Override
	public List<Notification> listerAlertesJardiniers() {
		List<Notification> notifications = new ArrayList<>();
		List<Tache> taches = proxyTacheDao.getTacheManquantDeJardiniers();
		for (Tache t : taches) {
			Notification notification = new Notification(
											"Tâche non pourvue",
											"Il manque des jardiniers sur la tâche "
												+ "\"" + t.getLibelleTache() + "\""
												);
			notifications.add(notification);
		}
		return notifications;
	}

	@Override
	public List<Notification> listerNotificationsSemisPlante() {
		List<Notification> notifications = new ArrayList<>();
		List<Plante> plantes = proxyPlanteDao.getPlantesEnPeriodeDeSemis();
		for (Plante p : plantes) {
			Notification notification = new Notification(
											"Période de semis/plantation",
											p.getLibellePlante()
												+ " : de "
												+ p.getDebutSemis().getLibelleMois().toLowerCase()
												+ " à "
												+ p.getFinSemis().getLibelleMois().toLowerCase()
											);
			notifications.add(notification);
		}
		return notifications;
	}

	@Override
	public List<Notification> listerNotificationsFloraisonPlante() {
		List<Notification> notifications = new ArrayList<>();
		List<Plante> plantes = proxyPlanteDao.getPlantesEnPeriodeDeFloraison();
		for (Plante p : plantes) {
			Notification notification = new Notification(
											"Période de floraison",
											p.getLibellePlante()
												+ " : de "
												+ p.getDebutFloraison().getLibelleMois().toLowerCase()
												+ " à "
												+ p.getFinFloraison().getLibelleMois().toLowerCase()
											);
			notifications.add(notification);
		}
		return notifications;
	}

	@Override
	public List<Notification> listerNotificationsRecoltePlante() {
		List<Notification> notifications = new ArrayList<>();
		List<Plante> plantes = proxyPlanteDao.getPlantesEnPeriodeDeRecolte();
		for (Plante p : plantes) {
			Notification notification = new Notification(
										"Période de récolte",
										p.getLibellePlante()
											+ " : de "
											+ p.getDebutRecolte().getLibelleMois().toLowerCase()
											+ " à "
											+ p.getFinRecolte().getLibelleMois().toLowerCase()
										);
			notifications.add(notification);
		}
		return notifications;
	}
}
