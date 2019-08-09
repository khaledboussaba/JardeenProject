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
@Table(name = "type_plante")
public class TypePlante implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_type_plante")
	private int idTypePlante;
	@Column(name = "libelle_type_plante")
	private String libelleTypePlante;
	
	@OneToMany(mappedBy = "typePlante")
	private Set<Plante> plantes;

	public TypePlante(){

	}

	public TypePlante(String libelleTypePlante) {
		super();
		this.libelleTypePlante = libelleTypePlante;
	}

	public int getIdTypePlante() {
		return idTypePlante;
	}

	public void setIdTypePlante(int idTypePlante) {
		this.idTypePlante = idTypePlante;
	}

	public String getLibelleTypePlante() {
		return libelleTypePlante;
	}

	public void setLibelleTypePlante(String libelleTypePlante) {
		this.libelleTypePlante = libelleTypePlante;
	}

	public Set<Plante> getPlantes() {
		return plantes;
	}

	public void setPlantes(Set<Plante> plantes) {
		this.plantes = plantes;
	}


}//end TypePlante