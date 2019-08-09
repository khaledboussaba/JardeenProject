package fr.afcepf.ai105.p3.g1.appjardeen.entities;

import java.io.Serializable;
import java.util.Date;

public class Notification implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String libelleNotification;
	private String description;
	private Date dateDebutEvenement;
	private Date dateFinEvenement;
	private Adherent adherent;
	private Plante plante;
	
	public Notification(String libelleNotification, String description) {
		super();
		this.libelleNotification = libelleNotification;
		this.description = description;
	}

	public String getLibelleNotification() {
		return libelleNotification;
	}
	public void setLibelleNotification(String libelleNotification) {
		this.libelleNotification = libelleNotification;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateDebutEvenement() {
		return dateDebutEvenement;
	}
	public void setDateDebutEvenement(Date dateDebutEvenement) {
		this.dateDebutEvenement = dateDebutEvenement;
	}
	public Date getDateFinEvenement() {
		return dateFinEvenement;
	}
	public void setDateFinEvenement(Date dateFinEvenement) {
		this.dateFinEvenement = dateFinEvenement;
	}
	public Adherent getAdherent() {
		return adherent;
	}
	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}
	public Plante getPlante() {
		return plante;
	}
	public void setPlante(Plante plante) {
		this.plante = plante;
	}
}
