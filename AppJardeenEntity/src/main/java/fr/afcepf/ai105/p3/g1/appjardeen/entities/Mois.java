package fr.afcepf.ai105.p3.g1.appjardeen.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author merye
 * @version 1.0
 * @created 25-mai-2019 17:32:28
 */
@Entity
@Table(name="mois")
public class Mois implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_mois")
	private int idMois;
	@Column(name="libelle_mois")
	private String libelleMois;
	
	@OneToMany(mappedBy = "debutSemis")
	private Set<Plante> plantesDebutSemis;
	@OneToMany(mappedBy = "finSemis")
	private Set<Plante> plantesFinSemis;
	
	@OneToMany(mappedBy = "debutFloraison")
	private Set<Plante> plantesDebutFloraison;
	@OneToMany(mappedBy = "finFloraison")
	private Set<Plante> plantesFinFloraison;
	
	@OneToMany(mappedBy = "debutRecolte")
	private Set<Plante> plantesDebutRecolte;
	@OneToMany(mappedBy = "finRecolte")
	private Set<Plante> plantesFinRecolte;

	public Mois(){

	}

	public Mois(String libelleMois) {
		super();
		this.libelleMois = libelleMois;
	}

	public int getIdMois() {
		return idMois;
	}

	public void setIdMois(int idMois) {
		this.idMois = idMois;
	}

	public String getLibelleMois() {
		return libelleMois;
	}

	public void setLibelleMois(String libelleMois) {
		this.libelleMois = libelleMois;
	}

	public Set<Plante> getPlantesDebutSemis() {
		return plantesDebutSemis;
	}

	public void setPlantesDebutSemis(Set<Plante> plantesDebutSemis) {
		this.plantesDebutSemis = plantesDebutSemis;
	}

	public Set<Plante> getPlantesFinSemis() {
		return plantesFinSemis;
	}

	public void setPlantesFinSemis(Set<Plante> plantesFinSemis) {
		this.plantesFinSemis = plantesFinSemis;
	}

	public Set<Plante> getPlantesDebutFloraison() {
		return plantesDebutFloraison;
	}

	public void setPlantesDebutFloraison(Set<Plante> plantesDebutFloraison) {
		this.plantesDebutFloraison = plantesDebutFloraison;
	}

	public Set<Plante> getPlantesDebutRecolte() {
		return plantesDebutRecolte;
	}

	public void setPlantesDebutRecolte(Set<Plante> plantesDebutRecolte) {
		this.plantesDebutRecolte = plantesDebutRecolte;
	}

	public Set<Plante> getPlantesFinFloraison() {
		return plantesFinFloraison;
	}

	public void setPlantesFinFloraison(Set<Plante> plantesFinFloraison) {
		this.plantesFinFloraison = plantesFinFloraison;
	}

	public Set<Plante> getPlantesFinRecolte() {
		return plantesFinRecolte;
	}

	public void setPlantesFinRecolte(Set<Plante> plantesFinRecolte) {
		this.plantesFinRecolte = plantesFinRecolte;
	}


}//end Mois