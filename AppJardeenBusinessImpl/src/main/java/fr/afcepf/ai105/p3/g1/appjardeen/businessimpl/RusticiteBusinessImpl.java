package fr.afcepf.ai105.p3.g1.appjardeen.businessimpl;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai105.p3.g1.appjardeen.business.RusticiteBusiness;

@Remote(RusticiteBusiness.class)
@Stateless
public class RusticiteBusinessImpl implements RusticiteBusiness{

}
