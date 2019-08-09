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
 * @created 25-mai-2019 17:32:29
 */
@Entity
@Table(name = "plante")
public class Plante implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_plante")
	private int idPlante;
	
	@Column(name = "libelle_plante")
	private String libellePlante;
	
	@Column(name = "photo")
	private String photo;
	
	@ManyToOne
	@JoinColumn(name = "id_acidite")
	private Acidite acidite;
	@ManyToOne
	@JoinColumn(name = "id_type_plante")
	private TypePlante typePlante;
	@ManyToOne
	@JoinColumn(name = "id_besoin_eau")
	private BesoinEau besoinEau;
	@ManyToOne
	@JoinColumn(name = "id_exposition")
	private Exposition exposition;
	@ManyToOne
	@JoinColumn(name = "id_rusticite")
	private Rusticite rusticite;
	@ManyToOne
	@JoinColumn(name = "id_type_sol")
	private TypeSol typeSol;
	

	@ManyToOne
	@JoinColumn(name = "id_humidite_sol")
	private HumiditeSol humiditeSol;
	
	@ManyToOne
	@JoinColumn(name = "id_debut_semis")
	private Mois debutSemis;
	@ManyToOne
	@JoinColumn(name = "id_fin_semis")
	private Mois finSemis;
	
	@ManyToOne
	@JoinColumn(name = "id_debut_floraison")
	private Mois debutFloraison;
	@ManyToOne
	@JoinColumn(name = "id_fin_floraison")
	private Mois finFloraison;
	
	@ManyToOne
	@JoinColumn(name = "id_debut_recolte")
	private Mois debutRecolte;
	@ManyToOne
	@JoinColumn(name = "id_fin_recolte")
	private Mois finRecolte;

	@OneToMany(mappedBy = "plante")
	private Set<Tache> taches;
	
	@OneToMany(mappedBy = "plante")
	private Set<ActionsPlante> actionPlante;

	public Plante(){

	}

	public Plante(String libellePlante, Acidite acidite, TypePlante typePlante, BesoinEau besoinEau,
			Exposition exposition, Rusticite rusticite, TypeSol typeSol, Set<Tache> taches, HumiditeSol humiditeSol,
			Mois debutSemis, Mois finSemis, Mois debutFloraison, Mois debutRecolte, Mois finFloraison,
			Mois finRecolte) {
		super();
		this.libellePlante = libellePlante;
		this.acidite = acidite;
		this.typePlante = typePlante;
		this.besoinEau = besoinEau;
		this.exposition = exposition;
		this.rusticite = rusticite;
		this.typeSol = typeSol;
		this.taches = taches;
		this.humiditeSol = humiditeSol;
		this.debutSemis = debutSemis;
		this.finSemis = finSemis;
		this.debutFloraison = debutFloraison;
		this.debutRecolte = debutRecolte;
		this.finFloraison = finFloraison;
		this.finRecolte = finRecolte;
	}
	
	public Plante(String libellePlante) {
		super();
		this.libellePlante = libellePlante;
	}

	public int getIdPlante() {
		return idPlante;
	}

	public void setIdPlante(int idPlante) {
		this.idPlante = idPlante;
	}

	public String getLibellePlante() {
		return libellePlante;
	}

	public void setLibellePlante(String libellePlante) {
		this.libellePlante = libellePlante;
	}

	public Acidite getAcidite() {
		return acidite;
	}

	public void setAcidite(Acidite acidite) {
		this.acidite = acidite;
	}

	public TypePlante getTypePlante() {
		return typePlante;
	}

	public void setTypePlante(TypePlante typePlante) {
		this.typePlante = typePlante;
	}

	public BesoinEau getBesoinEau() {
		return besoinEau;
	}

	public void setBesoinEau(BesoinEau besoinEau) {
		this.besoinEau = besoinEau;
	}

	public Exposition getExposition() {
		return exposition;
	}

	public void setExposition(Exposition exposition) {
		this.exposition = exposition;
	}

	public Rusticite getRusticite() {
		return rusticite;
	}

	public void setRusticite(Rusticite rusticite) {
		this.rusticite = rusticite;
	}

	public TypeSol getTypeSol() {
		return typeSol;
	}

	public void setTypeSol(TypeSol typeSol) {
		this.typeSol = typeSol;
	}

	public Set<Tache> getTaches() {
		return taches;
	}

	public void setTaches(Set<Tache> taches) {
		this.taches = taches;
	}

	public HumiditeSol getHumiditeSol() {
		return humiditeSol;
	}

	public void setHumiditeSol(HumiditeSol humiditeSol) {
		this.humiditeSol = humiditeSol;
	}

	public Mois getDebutSemis() {
		return debutSemis;
	}

	public void setDebutSemis(Mois debutSemis) {
		this.debutSemis = debutSemis;
	}

	public Mois getFinSemis() {
		return finSemis;
	}

	public void setFinSemis(Mois finSemis) {
		this.finSemis = finSemis;
	}

	public Mois getDebutFloraison() {
		return debutFloraison;
	}

	public void setDebutFloraison(Mois debutFloraison) {
		this.debutFloraison = debutFloraison;
	}

	public Mois getDebutRecolte() {
		return debutRecolte;
	}

	public void setDebutRecolte(Mois debutRecolte) {
		this.debutRecolte = debutRecolte;
	}

	public Mois getFinFloraison() {
		return finFloraison;
	}

	public void setFinFloraison(Mois finFloraison) {
		this.finFloraison = finFloraison;
	}

	public Mois getFinRecolte() {
		return finRecolte;
	}

	public void setFinRecolte(Mois finRecolte) {
		this.finRecolte = finRecolte;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Set<ActionsPlante> getActionPlante() {
		return actionPlante;
	}

	public void setActionPlante(Set<ActionsPlante> actionPlante) {
		this.actionPlante = actionPlante;
	}
	
	
}//end Plante