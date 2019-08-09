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
 * @created 25-mai-2019 17:32:29
 */
@Entity
@Table(name = "type_sol")
public class TypeSol implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_type_sol")
	private int idTypeSol;
	@Column(name = "libelle_type_sol")
	private String libelleTypeSol;
	
	@OneToMany(mappedBy = "typeSol")
	private Set<Parcelle> parcelles;
	@OneToMany(mappedBy = "typeSol")
	private Set<Plante> plantes;

	public TypeSol(){

	}

	public TypeSol(String libelleTypeSol) {
		super();
		this.libelleTypeSol = libelleTypeSol;
	}

	public int getIdTypeSol() {
		return idTypeSol;
	}

	public void setIdTypeSol(int idTypeSol) {
		this.idTypeSol = idTypeSol;
	}

	public String getLibelleTypeSol() {
		return libelleTypeSol;
	}

	public void setLibelleTypeSol(String libelleTypeSol) {
		this.libelleTypeSol = libelleTypeSol;
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


}//end TypeSol