package fr.afcepf.ai105.p3.g1.appjardeen.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.afcepf.ai105.p3.g1.appjardeen.business.AdherentBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.AffectationAdherentBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.TacheBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;

@ManagedBean(name="mbTest")
@ViewScoped
public class TestManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private static int test;
	@EJB 
	AffectationAdherentBusiness proxyAffectationAdherentBusiness ;
	@EJB 
	AdherentBusiness proxyAdherentBusiness ;	
	@EJB 
	TacheBusiness proxyTacheBusiness ;
	
	public void affectationJardeenierTache() {		
		proxyAffectationAdherentBusiness.affecterAdherentTache(1,1);
		proxyAffectationAdherentBusiness.affecterAdherentTache(2,1);
	}
	
	public void desaffectationJardeenierTache() {
		proxyAffectationAdherentBusiness.desaffecterAdherentTacheById(1);
	}
	
	public void reporterTache() {
//		LocalDateTime dateDeb = LocalDateTime.of(2019, 07,10,0,0);
//		LocalDateTime dateFin = LocalDateTime.of(2019, 07,12,0,0);
//		System.out.println("Date :>"+dateDeb);
//		proxyTacheBusiness.reporterTache(1, dateDeb, dateFin); 
	}
	
	public void annulerTache() {
		proxyTacheBusiness.annulerTache(1,1); 
	}
	

	public int getId() {
		test++;
		return test;
	}
	public String getIdT() {
		return "test";
	}
	public static int getTest() {
		test++;
		return test;
	}

	public static void setTest(int test) {
		TestManagedBean.test = test;
	}
	
}
