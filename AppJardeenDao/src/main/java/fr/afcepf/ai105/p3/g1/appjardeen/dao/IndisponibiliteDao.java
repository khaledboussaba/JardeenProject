package fr.afcepf.ai105.p3.g1.appjardeen.dao;

import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Indisponibilite;

public interface IndisponibiliteDao extends GenericDao<Indisponibilite> {
	
	
	List<Indisponibilite> getIndisponibilitesByAdherent(Adherent adherent);

}
