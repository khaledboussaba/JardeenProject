package fr.afcepf.ai105.p3.g1.appjardeen.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.afcepf.ai105.p3.g1.appjardeen.business.OutilBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Outil;

@ManagedBean(name = "mbListeOutils")
@RequestScoped
public class ListeOutilsManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Outil> outils;
	private Outil outilSelected;
	
	@EJB
	OutilBusiness proxyOutilBusiness;
	
	@PostConstruct
	public void init() {
		outils= proxyOutilBusiness.listerOutils();
	}
	
	public void modificationQuantiteOutil() {
		for (int i = 0; i < outils.size(); i++) {
			proxyOutilBusiness.modificationQuantiteOutils(outils.get(i));
		}
	}

	public List<Outil> getOutils() {
		return outils;
	}

	public void setOutils(List<Outil> outils) {
		this.outils = outils;
	}

	public Outil getOutilSelected() {
		return outilSelected;
	}

	public void setOutilSelected(Outil outilSelected) {
		this.outilSelected = outilSelected;
	}
	
}
