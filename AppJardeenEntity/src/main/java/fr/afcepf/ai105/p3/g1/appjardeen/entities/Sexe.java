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
@Table(name="sexe")
public class Sexe implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sexe")
	private int idSexe;
	@Column(name = "libelle_sexe")
	private String libelleSexe;
	
	@OneToMany(mappedBy = "sexe")
	private Set<Adherent> adherents;

	public Sexe(){

	}

	
	public Sexe(String libelleSexe) {
		super();
		this.libelleSexe = libelleSexe;
	}


	public int getIdSexe() {
		return idSexe;
	}

	public void setIdSexe(int idSexe) {
		this.idSexe = idSexe;
	}

	public String getLibelleSexe() {
		return libelleSexe;
	}

	public void setLibelleSexe(String libelleSexe) {
		this.libelleSexe = libelleSexe;
	}

	public Set<Adherent> getAdherents() {
		return adherents;
	}

	public void setAdherents(Set<Adherent> adherents) {
		this.adherents = adherents;
	}


}//end Sexe