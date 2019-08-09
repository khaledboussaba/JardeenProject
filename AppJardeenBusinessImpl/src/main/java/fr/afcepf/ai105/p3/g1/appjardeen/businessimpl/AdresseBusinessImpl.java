package fr.afcepf.ai105.p3.g1.appjardeen.businessimpl;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai105.p3.g1.appjardeen.business.AdresseBusiness;

@Remote(AdresseBusiness.class)
@Stateless
public class AdresseBusinessImpl implements AdresseBusiness{

}

