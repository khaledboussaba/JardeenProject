package fr.afcepf.ai105.p3.g1.appjardeen.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
 * @author formation
 * @version 1.0
 * @created 25-mai-2019 17:32:29
 */
@Entity
@Table(name="parcelle")
public class Parcelle implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_parcelle")
	private int idParcelle;
	@Column(name = "libelle_parcelle")
	private String libelleParcelle;
	@Column(name = "date_creation_parcelle")	
	private Date dateCreationParcelle;
	@Column(name = "date_retrait_parcelle")	
	private Date dateRetraitParcelle;
	@Column(name = "couleur_parcelle")	
	private String couleurParcelle;
	
	@ManyToOne
	@JoinColumn(name = "id_type_sol")
	private TypeSol typeSol;
	@ManyToOne
	@JoinColumn(name = "id_acidite")
	private Acidite acidite;
	@ManyToOne
	@JoinColumn(name = "id_humidite_sol")
	private HumiditeSol humiditeSol;
	@ManyToOne
	@JoinColumn(name = "id_terrain")
	private Terrain terrain;
	
	@OneToMany(mappedBy = "parcelle", cascade = CascadeType.ALL)
	private List<Tache> taches;
	
	@OneToMany( mappedBy = "parcelle", cascade = CascadeType.ALL)
	private List<Emplacement> emplacements;


	public Parcelle(){

	}

	public Parcelle(String libelleParcelle, Date dateCreationParcelle, Date dateRetraitParcelle, TypeSol typeSol,
			Acidite acidite, HumiditeSol humiditeSol,Terrain terrain) {
		super();
		this.libelleParcelle = libelleParcelle;
		this.dateCreationParcelle = dateCreationParcelle;
		this.dateRetraitParcelle = dateRetraitParcelle;
		this.typeSol = typeSol;
		this.acidite = acidite;
		this.humiditeSol = humiditeSol;
		this.terrain = terrain;
	}
	
	public Parcelle(String libelleParcelle) {
		super();
		this.libelleParcelle = libelleParcelle;
	}
	


	public int getIdParcelle() {
		return idParcelle;
	}

	public void setIdParcelle(int idParcelle) {
		this.idParcelle = idParcelle;
	}

	public String getLibelleParcelle() {
		return libelleParcelle;
	}

	public void setLibelleParcelle(String libelleParcelle) {
		this.libelleParcelle = libelleParcelle;
	}

	public Date getDateCreationParcelle() {
		return dateCreationParcelle;
	}

	public void setDateCreationParcelle(Date dateCreationParcelle) {
		this.dateCreationParcelle = dateCreationParcelle;
	}
	
	public Date getDateRetraitParcelle() {
		return dateRetraitParcelle;
	}

	public void setDateRetraitParcelle(Date dateRetraitParcelle) {
		this.dateRetraitParcelle = dateRetraitParcelle;
	}

	public TypeSol getTypeSol() {
		return typeSol;
	}

	public void setTypeSol(TypeSol typeSol) {
		this.typeSol = typeSol;
	}

	public Acidite getAcidite() {
		return acidite;
	}

	public void setAcidite(Acidite acidite) {
		this.acidite = acidite;
	}

	public HumiditeSol getHumiditeSol() {
		return humiditeSol;
	}

	public String getCouleurParcelle() {
		return couleurParcelle;
	}

	public void setCouleurParcelle(String couleurParcelle) {
		this.couleurParcelle = couleurParcelle;
	}

	public void setHumiditeSol(HumiditeSol humiditeSol) {
		this.humiditeSol = humiditeSol;
	}


	public List<Tache> getTaches() {
		return taches;
	}

	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}

	public List<Emplacement> getEmplacements() {
		return emplacements;
	}

	public void setEmplacements(List<Emplacement> emplacements) {
		this.emplacements = emplacements;
	}

	public Terrain getTerrain() {
		return terrain;
	}

	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}

	
}//end Parcelle