package fr.afcepf.ai105.p3.g1.appjardeen.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author merye
 * @version 1.0
 * @created 25-mai-2019 17:32:29
 */
@Entity
@Table(name = "terrain")
public class Terrain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_terrain")
	private int idTerrain;
	@Column(name="libelle_terrain")
	private String libelleTerrain;
	private int largeur;
	private int longueur;
	@Column(name="date_creation_terrain")
	private Date dateCreationTerrain;
	@Column(name="date_retrait_terrain")	
	private Date dateRetraitTerrain;
	
	@OneToMany(mappedBy = "terrain")
	private Set<AdherentTerrain> terrainAdherent;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_adresse")
	private Adresse adresse;
	
	@OneToMany(mappedBy = "terrain")
	private Set<Parcelle> parcelles;

	public Terrain(){
	}

	public Terrain(String libelleTerrain, int largeur, int longueur, Date dateCreationTerrain,
			Date dateRetraitTerrain, Adresse adresse) {
		super();
		this.libelleTerrain = libelleTerrain;
		this.largeur = largeur;
		this.longueur = longueur;
		this.dateCreationTerrain = dateCreationTerrain;
		this.dateRetraitTerrain = dateRetraitTerrain;
		this.adresse = adresse;

	}

	public Terrain(String libelleTerrain) {
		super();
		this.libelleTerrain = libelleTerrain;
	}

	public int getIdTerrain() {
		return idTerrain;
	}

	public void setIdTerrain(int idTerrain) {
		this.idTerrain = idTerrain;
	}

	public String getLibelleTerrain() {
		return libelleTerrain;
	}

	public void setLibelleTerrain(String libelleTerrain) {
		this.libelleTerrain = libelleTerrain;
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	public Date getDateCreationTerrain() {
		return dateCreationTerrain;
	}

	public void setDateCreationTerrain(Date dateCreationTerrain) {
		this.dateCreationTerrain = dateCreationTerrain;
	}

	public Date getDateRetraitTerrain() {
		return dateRetraitTerrain;
	}

	public void setDateRetraitTerrain(Date dateRetraitTerrain) {
		this.dateRetraitTerrain = dateRetraitTerrain;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Set<Parcelle> getParcelles() {
		return parcelles;
	}

	public void setParcelles(Set<Parcelle> parcelles) {
		this.parcelles = parcelles;
	}


}//end Terrain