package fr.afcepf.ai105.p3.g1.appjardeen.businessimpl;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai105.p3.g1.appjardeen.business.TypePlanteBusiness;

@Remote(TypePlanteBusiness.class)
@Stateless
public class TypePlanteBusinessImpl implements TypePlanteBusiness{

}
