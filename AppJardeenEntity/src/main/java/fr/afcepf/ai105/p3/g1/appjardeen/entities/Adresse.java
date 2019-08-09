package fr.afcepf.ai105.p3.g1.appjardeen.entities;

import java.io.Serializable;
import java.util.Set;

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
 * @created 25-mai-2019 17:32:28
 */
@Entity
@Table(name = "adresse")
public class Adresse implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_adresse")
	private int idAdresse;
	
	@Column(name="libelle_adresse")
	private String libelleAdresse;
	
	@ManyToOne
	@JoinColumn(name = "id_ville")
	private Ville ville;
	
	@OneToMany(mappedBy = "adresse")
	private Set<Adherent> adherents;
	@OneToMany(mappedBy = "adresse")
	private Set<Terrain> terrains;
	
	public Adresse(){
	}

	public Adresse(String libelleAdresse) {
		super();
		this.libelleAdresse = libelleAdresse;
	}

	public int getIdAdresse() {
		return idAdresse;
	}

	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}

	public String getLibelleAdresse() {
		return libelleAdresse;
	}

	public void setLibelleAdresse(String libelleAdresse) {
		this.libelleAdresse = libelleAdresse;
	}



	/**
	 * @return the adherents
	 */
	public Set<Adherent> getAdherents() {
		return adherents;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	/**
	 * @param adherents the adherents to set
	 */
	public void setAdherents(Set<Adherent> adherents) {
		this.adherents = adherents;
	}





	/**
	 * @return the terrains
	 */
	public Set<Terrain> getTerrains() {
		return terrains;
	}

	/**
	 * @param terrains the terrains to set
	 */
	public void setTerrains(Set<Terrain> terrains) {
		this.terrains = terrains;
	}


	

}//end Adresse