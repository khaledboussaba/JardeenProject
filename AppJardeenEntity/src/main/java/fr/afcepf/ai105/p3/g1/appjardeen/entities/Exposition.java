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
@Table(name = "exposition")
public class Exposition implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_exposition")
	private int idExposition;
	@Column(name="libelle_exposition")
	private String libelleExposition;
	
	@OneToMany(mappedBy = "exposition")
	private Set<Plante> plantes;

	public Exposition(){

	}

	public Exposition(String libelleExposition) {
		super();
		this.libelleExposition = libelleExposition;
	}

	public int getIdExposition() {
		return idExposition;
	}

	public void setIdExposition(int idExposition) {
		this.idExposition = idExposition;
	}

	public String getLibelleExposition() {
		return libelleExposition;
	}

	public void setLibelleExposition(String libelleExposition) {
		this.libelleExposition = libelleExposition;
	}

	public Set<Plante> getPlantes() {
		return plantes;
	}

	public void setPlantes(Set<Plante> plantes) {
		this.plantes = plantes;
	}


}//end Exposition