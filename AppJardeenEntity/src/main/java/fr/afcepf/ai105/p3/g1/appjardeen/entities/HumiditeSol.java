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
@Table(name = "humidite_sol")
public class HumiditeSol implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_humidite")
	private int idHumidite;
	@Column(name="libelle_humidite")
	private String libelleHumidite;
	
	@OneToMany(mappedBy = "humiditeSol")
	private Set<Parcelle> parcelles;
	@OneToMany(mappedBy = "humiditeSol")
	private Set<Plante> plantes;

	public HumiditeSol(){

	}

	public HumiditeSol(String libelleHumidite) {
		super();
		this.libelleHumidite = libelleHumidite;
	}

	public int getIdHumidite() {
		return idHumidite;
	}

	public void setIdHumidite(int idHumidite) {
		this.idHumidite = idHumidite;
	}

	public String getLibelleHumidite() {
		return libelleHumidite;
	}

	public void setLibelleHumidite(String libelleHumidite) {
		this.libelleHumidite = libelleHumidite;
	}

	public Set<Parcelle> getParcelles() {
		return parcelles;
	}

	public void setParcelles(Set<Parcelle> parcelles) {
		this.parcelles = parcelles;
	}

	public Set<Plante> getPlantes() {
		return plantes;
	}

	public void setPlantes(Set<Plante> plantes) {
		this.plantes = plantes;
	}


}//end HumiditeSol