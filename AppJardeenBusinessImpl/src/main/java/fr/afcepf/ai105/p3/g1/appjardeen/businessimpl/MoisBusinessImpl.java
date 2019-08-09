package fr.afcepf.ai105.p3.g1.appjardeen.businessimpl;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai105.p3.g1.appjardeen.business.MoisBusiness;

@Remote(MoisBusiness.class)
@Stateless
public class MoisBusinessImpl implements MoisBusiness {

}
