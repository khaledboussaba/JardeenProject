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
@Table(name="acidite")
public class Acidite implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_acidite")
	private int idAcidite;
	@Column(name="indice_acidite")
	private int indiceAcidite;
	
	@OneToMany(mappedBy = "acidite")
	private Set<Plante> plantes;
	@OneToMany(mappedBy = "acidite")
	private Set<Parcelle> parcelles;

	public Acidite(){

	}

	
	public Acidite(int indiceAcidite) {
		super();
		this.indiceAcidite = indiceAcidite;
	}


	public int getIdAcidite() {
		return idAcidite;
	}

	public void setIdAcidite(int idAcidite) {
		this.idAcidite = idAcidite;
	}

	public int getIndiceAcidite() {
		return indiceAcidite;
	}

	public void setIndiceAcidite(int indiceAcidite) {
		this.indiceAcidite = indiceAcidite;
	}

	public Set<Plante> getPlantes() {
		return plantes;
	}

	public void setPlantes(Set<Plante> plantes) {
		this.plantes = plantes;
	}

	public Set<Parcelle> getParcelles() {
		return parcelles;
	}

	public void setParcelles(Set<Parcelle> parcelles) {
		this.parcelles = parcelles;
	}


}//end Acidite