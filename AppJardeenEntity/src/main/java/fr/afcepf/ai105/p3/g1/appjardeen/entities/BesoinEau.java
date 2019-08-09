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
@Table(name = "besoin_eau")
public class BesoinEau implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_besoin_eau")
	private int idBesoinEau;
	@Column(name="indice_besoin_eau")
	private int indiceBesoinEau;
	
	@OneToMany(mappedBy = "besoinEau")
	private Set<Plante> plantes;

	public BesoinEau(){

	}

	public BesoinEau(int indiceBesoinEau) {
		super();
		this.indiceBesoinEau = indiceBesoinEau;
	}


	public int getIdBesoinEau() {
		return idBesoinEau;
	}

	public void setIdBesoinEau(int idBesoinEau) {
		this.idBesoinEau = idBesoinEau;
	}

	public int getIndiceBesoinEau() {
		return indiceBesoinEau;
	}

	public void setIndiceBesoinEau(int indiceBesoinEau) {
		this.indiceBesoinEau = indiceBesoinEau;
	}

	public Set<Plante> getPlantes() {
		return plantes;
	}

	public void setPlantes(Set<Plante> plantes) {
		this.plantes = plantes;
	}


}//end BesoinEau