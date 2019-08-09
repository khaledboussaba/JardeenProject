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
@Table(name = "rusticite")
public class Rusticite implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rusticite")
	private int idRusticite;
	@Column(name = "indice_rusticite")
	private int indiceRusticite;
	
	@OneToMany(mappedBy = "rusticite")
	private Set<Plante> plantes;

	public Rusticite(){

	}

	
	public Rusticite(int indiceRusticite) {
		super();
		this.indiceRusticite = indiceRusticite;
	}




	public int getIdRusticite() {
		return idRusticite;
	}


	public void setIdRusticite(int idRusticite) {
		this.idRusticite = idRusticite;
	}


	public int getIndiceRusticite() {
		return indiceRusticite;
	}

	public void setIndiceRusticite(int indiceRusticite) {
		this.indiceRusticite = indiceRusticite;
	}

	public Set<Plante> getPlantes() {
		return plantes;
	}

	public void setPlantes(Set<Plante> plantes) {
		this.plantes = plantes;
	}


}//end Rusticite