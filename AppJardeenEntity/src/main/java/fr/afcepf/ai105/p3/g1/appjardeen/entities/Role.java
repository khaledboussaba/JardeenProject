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
@Table(name = "role")
public class Role implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_role")
	private int idRole;
	@Column(name = "libelle_role")
	private String libelleRole;
	
	@OneToMany(mappedBy = "role")
	private Set<Adherent> adherents;

	public Role(){

	}

	
	public Role(String libelleRole) {
		super();
		this.libelleRole = libelleRole;
	}


	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getLibelleRole() {
		return libelleRole;
	}

	public void setLibelleRole(String libelleRole) {
		this.libelleRole = libelleRole;
	}

	public Set<Adherent> getAdherents() {
		return adherents;
	}

	public void setAdherents(Set<Adherent> adherents) {
		this.adherents = adherents;
	}


}//end Role