package fr.afcepf.ai105.p3.g1.appjardeen.businessimpl;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai105.p3.g1.appjardeen.business.ExpositionBusiness;

@Remote(ExpositionBusiness.class)
@Stateless
public class ExpositionBusinessImpl implements ExpositionBusiness{

}
