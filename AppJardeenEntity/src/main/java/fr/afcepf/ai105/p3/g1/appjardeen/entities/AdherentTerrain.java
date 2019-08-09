package fr.afcepf.ai105.p3.g1.appjardeen.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "adherent_terrain")
public class AdherentTerrain implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_adherent_terrain")
	private int idAdherentTerrain;

	@ManyToOne
	@JoinColumn(name = "id_adherent")
	private Adherent adherent;

	@ManyToOne
	@JoinColumn(name = "id_terrain")
	private Terrain terrain;

	public AdherentTerrain() {
		super();
	}

	public AdherentTerrain(Adherent adherent, Terrain terrain) {
		super();
		this.adherent = adherent;
		this.terrain = terrain;
	}

	public int getIdAdherentTerrain() {
		return idAdherentTerrain;
	}

	public void setIdAdherentTerrain(int idAdherentTerrain) {
		this.idAdherentTerrain = idAdherentTerrain;
	}

	public Adherent getAdherent() {
		return adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

	public Terrain getTerrain() {
		return terrain;
	}

	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}
}
