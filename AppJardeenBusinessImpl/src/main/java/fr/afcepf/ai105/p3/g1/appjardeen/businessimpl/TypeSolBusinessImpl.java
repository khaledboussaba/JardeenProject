package fr.afcepf.ai105.p3.g1.appjardeen.businessimpl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai105.p3.g1.appjardeen.business.TypeSolBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.dao.TypeSolDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.TypeSol;

@Remote(TypeSolBusiness.class)
@Stateless
public class TypeSolBusinessImpl implements TypeSolBusiness {

	@EJB
	TypeSolDao proxyTypeSol;
	@Override
	public List<TypeSol> obtenirTypeSol() {
		List<TypeSol> typesSol = proxyTypeSol.getTypesSol();
		return typesSol;
	}
	@Override
	public List<TypeSol> obtenirTousLesTypesSol() {
		return proxyTypeSol.getCollection("SELECT ts FROM TypeSol ts");
	}

}
