package fr.afcepf.ai105.p3.g1.appjardeen.business;

import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.TypeSol;

public interface TypeSolBusiness {
	List<TypeSol> obtenirTypeSol();

	List<TypeSol> obtenirTousLesTypesSol();
}
